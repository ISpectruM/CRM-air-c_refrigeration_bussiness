package com.ispectrum.crmclima.areas.orders.models.dtos;

import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.locations.models.dtos.LocationDto;
import com.ispectrum.crmclima.areas.orders.entities.enums.MontageType;
import com.ispectrum.crmclima.areas.products.entities.enums.ProductType;
import com.ispectrum.crmclima.areas.products.models.dtos.AirConditionerDto;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class MontageOrderDto {
    private String id;

    private LocalDate orderDate;

    private MontageType montageType;

    private Integer count;

    private ClientDto client;

    private LocationDto location;

    private Double price;

    private Double deposit;

    private Double discount;

    private Double forPayment;

    private String comment;

    private LocalDate scheduleDate;

    private String status;

    private String product;

    private Map<AirConditionerDto, Integer> airConditioners;

    private boolean isMarked;
    private boolean isFinished;
    private boolean isWithInvoice;
    private boolean isPayed;
    private boolean isDeferred;
    private boolean isWaiting;
    private boolean isWarranty;
    private boolean isForFinishing;



    public MontageOrderDto() {
    }


    public MontageType getMontageType() {
        return this.montageType;
    }

    public void setMontageType(MontageType montageType) {
        this.montageType = montageType;
    }

    public ClientDto getClient() {
        return this.client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Map<AirConditionerDto, Integer> getAirConditioners() {
        return this.airConditioners;
    }

    public void setAirConditioners(Map<AirConditionerDto, Integer> airConditioners) {
        this.airConditioners = airConditioners;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public LocationDto getLocation() {
        return this.location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDeposit() {
        return this.deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getForPayment() {
        return this.forPayment;
    }

    public void setForPayment(Double forPayment) {
        this.forPayment = forPayment;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getScheduleDate() {
        return this.scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public boolean getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(boolean marked) {
        isMarked = marked;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public void setIsFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean getIsWithInvoice() {
        return this.isWithInvoice;
    }

    public void setIsWithInvoice(boolean withInvoice) {
        isWithInvoice = withInvoice;
    }

    public boolean getIsPayed() {
        return this.isPayed;
    }

    public void setIsPayed(boolean payed) {
        isPayed = payed;
    }

    public boolean getIsDeferred() {
        return this.isDeferred;
    }

    public void setIsDeferred(boolean deferred) {
        isDeferred = deferred;
    }

    public boolean getIsWaiting() {
        return this.isWaiting;
    }

    public void setIsWaiting(boolean waiting) {
        isWaiting = waiting;
    }

    public boolean getIsWarranty() {
        return this.isWarranty;
    }

    public void setIsWarranty(boolean warranty) {
        isWarranty = warranty;
    }

    public boolean getIsForFinishing() {
        return this.isForFinishing;
    }

    public void setIsForFinishing(boolean forFinishing) {
        isForFinishing = forFinishing;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
