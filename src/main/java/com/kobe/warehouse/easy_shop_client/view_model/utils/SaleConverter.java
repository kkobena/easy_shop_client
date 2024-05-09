package com.kobe.warehouse.easy_shop_client.view_model.utils;

import com.kobe.warehouse.easy_shop_client.http.response.sale.CashSale;
import com.kobe.warehouse.easy_shop_client.http.response.sale.Sale;
import com.kobe.warehouse.easy_shop_client.http.response.sale.ThirdPartySale;
import com.kobe.warehouse.easy_shop_client.view_model.customer.AssuredCustomer;
import com.kobe.warehouse.easy_shop_client.view_model.customer.UninsuredCustomer;
import com.kobe.warehouse.easy_shop_client.view_model.sale.CashSaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.SaleModel;
import com.kobe.warehouse.easy_shop_client.view_model.sale.ThirdPartySaleModel;
import java.util.Objects;
import java.util.function.Function;
import javafx.collections.FXCollections;

public final class SaleConverter {
  public static Function<Sale, SaleModel> convertSaleToModel =
      (sale) -> {
        if (sale instanceof CashSale cashSale) {
          CashSaleModel cashSaleModel = updateCashSaleModel(cashSale);
          toSaleModel(cashSaleModel, sale);
          return cashSaleModel;
        } else if (sale instanceof ThirdPartySale thirdPartySale) {
          ThirdPartySaleModel thirdPartySaleModel = updateThirdPartySaleModel(thirdPartySale);
          toSaleModel(thirdPartySaleModel, sale);
          return thirdPartySaleModel;
        }
        return null;
      };
  public static Function<SaleModel, Sale> convertModelToSale =
      (saleModel) -> {
        if (saleModel instanceof CashSaleModel cashSaleModel) {
          CashSale cashSale = updateCashSale(cashSaleModel);
          toSale(cashSale, saleModel);
          return cashSale;
        } else if (saleModel instanceof ThirdPartySaleModel thirdPartySaleModel) {
          ThirdPartySale thirdPartySale = updateThirdPartySale(thirdPartySaleModel);
          toSale(thirdPartySale, saleModel);
          return thirdPartySale;
        }
        return null;
      };

  static void toSaleModel(SaleModel saleModel, Sale sale) {
    if (Objects.nonNull(sale.getCanceledSale())) {
      saleModel.setCanceledSale(convertSaleToModel.apply(sale.getCanceledSale()));
    }
    saleModel.setStatut(sale.getStatut());
    saleModel.setAvoir(sale.isAvoir());
    saleModel.setDiffere(sale.isDiffere());
    saleModel.setNatureVente(sale.getNatureVente());
    saleModel.setCommentaire(sale.getCommentaire());
    saleModel.setCassier(sale.getCassier());
    saleModel.setImported(sale.isImported());
    if (Objects.nonNull(sale.getMontantVerse())) {
      saleModel.setMontantVerse(sale.getMontantVerse());
    }
    if (Objects.nonNull(sale.getTaxAmount())) {
      saleModel.setTaxAmount(sale.getTaxAmount());
    }
    if (Objects.nonNull(sale.getSalesAmount())) {
      saleModel.setSalesAmount(sale.getSalesAmount());
    }
    saleModel.setSeller(sale.getSeller());
    saleModel.setSalesLines(FXCollections.observableArrayList(sale.getSalesLines()));
    if (Objects.nonNull(sale.getDiscountAmount())) {
      saleModel.setDiscountAmount(sale.getDiscountAmount());
    }
    if (Objects.nonNull(sale.getNetAmount())) {
      saleModel.setNetAmount(sale.getNetAmount());
    }
    if (Objects.nonNull(sale.getHtAmount())) {
      saleModel.setHtAmount(sale.getHtAmount());
    }
    if (Objects.nonNull(sale.getAmountToBePaid())) {
      saleModel.setAmountToBePaid(sale.getAmountToBePaid());
    }
    if (Objects.nonNull(sale.getRestToPay())) {
      saleModel.setRestToPay(sale.getRestToPay());
    }
    if (Objects.nonNull(sale.getMontantRendu())) {
      saleModel.setMontantRendu(sale.getMontantRendu());
    }
    saleModel.setCreatedAt(sale.getCreatedAt());
    saleModel.setUpdatedAt(sale.getUpdatedAt());
    saleModel.setPayments(FXCollections.observableArrayList(sale.getPayments()));
    saleModel.setNumberTransaction(sale.getNumberTransaction());
    saleModel.setTypePrescription(sale.getTypePrescription());
    saleModel.setUserFullName(sale.getUserFullName());
  }

  static CashSaleModel updateCashSaleModel(CashSale cashSale) {
    CashSaleModel saleModel = new CashSaleModel();
    UninsuredCustomer uninsuredCustomer = cashSale.getCustomer();
    if (Objects.nonNull(uninsuredCustomer)) {
      saleModel.setCustomer(uninsuredCustomer);
    }

    return saleModel;
  }

  static ThirdPartySaleModel updateThirdPartySaleModel(ThirdPartySale thirdPartySale) {
    ThirdPartySaleModel saleModel = new ThirdPartySaleModel();
    AssuredCustomer assuredCustomer = thirdPartySale.getCustomer();
    if (Objects.nonNull(assuredCustomer)) {
      saleModel.setCustomer(assuredCustomer);
    }

    return saleModel;
  }

  static void toSale(Sale sale, SaleModel saleModel) {
    sale.setDiffere(saleModel.isDiffere());
    sale.setNatureVente(saleModel.getNatureVente());
    sale.setCommentaire(saleModel.getCommentaire());
    sale.setCassier(saleModel.getCassier());
    sale.setCassierId(sale.getCassier().getId());
    sale.setMontantVerse(saleModel.getMontantVerse());

    sale.setTaxAmount(saleModel.getTaxAmount());

    sale.setSalesAmount(saleModel.getSalesAmount());

    sale.setSeller(saleModel.getSeller());
    sale.setSellerId(sale.getSeller().getId());
    sale.setSalesLines(saleModel.getSalesLines());

    sale.setDiscountAmount(saleModel.getDiscountAmount());

    sale.setNetAmount(saleModel.getNetAmount());
    sale.setHtAmount(saleModel.getHtAmount());
    sale.setAmountToBePaid(saleModel.getAmountToBePaid());
    sale.setRestToPay(saleModel.getRestToPay());
    sale.setMontantRendu(sale.getMontantRendu());
    sale.setPayments(saleModel.getPayments());
    sale.setNumberTransaction(saleModel.getNumberTransaction());
    sale.setTypePrescription(saleModel.getTypePrescription());
    sale.setNatureVente(saleModel.getNatureVente());
  }

  static CashSale updateCashSale(CashSaleModel saleModel) {
    CashSale cashSale = new CashSale();
    UninsuredCustomer uninsuredCustomer = saleModel.getCustomer();
    if (Objects.nonNull(uninsuredCustomer)) {
      cashSale.setCustomer(uninsuredCustomer);
      cashSale.setCustomerId(uninsuredCustomer.getId());
    }
    return cashSale;
  }

  static ThirdPartySale updateThirdPartySale(ThirdPartySaleModel saleModel) {
    ThirdPartySale thirdPartySale = new ThirdPartySale();
    AssuredCustomer assuredCustomer = saleModel.getCustomer();
    thirdPartySale.setCustomer(assuredCustomer);
    thirdPartySale.setCustomerId(assuredCustomer.getId());
    return thirdPartySale;
  }
}
