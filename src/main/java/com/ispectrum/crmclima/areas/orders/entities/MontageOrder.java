package com.ispectrum.crmclima.areas.orders.entities;

import com.ispectrum.crmclima.areas.orders.entities.enums.MontageType;
import com.ispectrum.crmclima.areas.orders.entities.enums.Shift;
import com.ispectrum.crmclima.areas.products.entities.airconditioners.AirConditioner;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Entity
public class MontageOrder extends BaseOrder {

    private final String SERVICE = "montage";

    private String otherProduct;

    @Enumerated(EnumType.STRING)
    private MontageType montageType;

    @Enumerated(EnumType.STRING)
    private Shift shift;

    @ElementCollection(targetClass = java.lang.Integer.class)
    @JoinTable(
            name = "montages_conditioners_count",
            joinColumns = @JoinColumn(name = "morder_id")
    )
    @MapKeyColumn(name = "airc_type")
    @Column(name = "count")
    private Map<AirConditioner, Integer> airConditioners;

    private Double externalPrice;


    public MontageOrder() {
        this.airConditioners = new HashMap<>();
    }


    public Shift getShift() {
        return this.shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Map<AirConditioner, Integer> getAirConditioners() {
        return this.airConditioners;
    }

    public void setAirConditioners(Map<AirConditioner, Integer> airConditioners) {
        this.airConditioners = airConditioners;
    }

    public MontageType getMontageType() {
        return this.montageType;
    }

    public void setMontageType(MontageType montageType) {
        this.montageType = montageType;
    }

    @Override
    @Transient
    public Integer getProductCount() {
        int count = 0;
        Collection<Integer> values = this.getAirConditioners().values();
        if (!values.isEmpty()) {
            count = values.stream().mapToInt(Number::intValue).sum();
        }
        return count;
    }

    @Override
    public Double getForPayment() {
        Double total = 0D;
        Double price = this.getPrice();

        if (price != null) {
            total += price;

            total = this.getDiscountedPrice(total);

            Double deposit = this.getDeposit();
            if (deposit != null && price > deposit) {
                total -= deposit;
            }
        }

        return total;
    }

    public String getSERVICE() {
        return this.SERVICE;
    }

    //Get the price embedded in the product object
    private Double getProductsPrice() {
        Double price = 0D;
        if (airConditioners.size() > 0) {
            price = this.getAirConditioners().entrySet().stream()
                    .mapToDouble(entry -> {
                        double prodPrice = 0D;
                        if (entry.getKey().getPrice() != null) {
                            prodPrice = entry.getKey().getPrice() * entry.getValue();
                        }
                        return prodPrice;
                    }).sum();
        }

        return price;
    }

    private double getDiscountedPrice(double aircCost) {
        Double discount = this.getDiscount();

        if (discount != null) {
            aircCost -= aircCost * discount / 100;
        }
        return aircCost;
    }

    //    Get the price entered in the price field
    public Double getExternalPrice() {
        return this.externalPrice;
    }

    public void setExternalPrice(Double externalPrice) {
        this.externalPrice = externalPrice;
    }

    @Override
    public Double getPrice() {
        if (this.getExternalPrice() == null) {
            return this.getProductsPrice();
        }

        return this.getExternalPrice();
    }

    public String getOtherProduct() {
        return otherProduct;
    }

    public void setOtherProduct(String otherProduct) {
        this.otherProduct = otherProduct;
    }
}
