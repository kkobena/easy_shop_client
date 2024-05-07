package com.kobe.warehouse.easy_shop_client.view_model.control.combo.experimental;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.StringConverter;


import java.util.Collection;

public class AutoCompletionTextFieldBinding <T>  extends AutoCompletionBinding<T> {


    private StringConverter<T> converter;



    /**
     * Creates a new auto-completion binding between the given textField
     * and the given suggestion provider.
     *
     * @param textField
     * @param suggestionProvider
     */
    public AutoCompletionTextFieldBinding(final TextField textField,
                                          Callback<ISuggestionRequest, Collection<T>> suggestionProvider,
                                          final StringConverter<T> converter) {

        super(textField, suggestionProvider, converter);
        this.converter = converter;

        getCompletionTarget().textProperty().addListener(textChangeListener);
        getCompletionTarget().focusedProperty().addListener(focusChangedListener);
    }


    /***************************************************************************
     *                                                                         *
     * Public API                                                              *
     *                                                                         *
     **************************************************************************/

    /** {@inheritDoc} */
    @Override public TextField getCompletionTarget(){
        return (TextField)super.getCompletionTarget();
    }

    /** {@inheritDoc} */
    @Override public void dispose(){
        getCompletionTarget().textProperty().removeListener(textChangeListener);
        getCompletionTarget().focusedProperty().removeListener(focusChangedListener);
    }

    /** {@inheritDoc} */
    @Override protected void completeUserInput(T completion){
        String newText = converter.toString(completion);
        getCompletionTarget().setText(newText);
        getCompletionTarget().positionCaret(newText.length());
    }


    /***************************************************************************
     *                                                                         *
     * Event Listeners                                                         *
     *                                                                         *
     **************************************************************************/


    private final ChangeListener<String> textChangeListener = (obs, oldText, newText) -> {
        if (getCompletionTarget().isFocused()) {
            setUserInput(newText);
        }
    };

    private final ChangeListener<Boolean> focusChangedListener = (obs, oldFocused, newFocused) -> {
        if(newFocused == false)
            hidePopup();
    };
}