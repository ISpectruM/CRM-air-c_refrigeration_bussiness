package com.ispectrum.crmclima.areas.schedules.models.dtos;

import com.ispectrum.crmclima.areas.clients.models.dtos.ClientDto;
import com.ispectrum.crmclima.areas.locations.models.dtos.LocationDto;
import com.ispectrum.crmclima.areas.orders.entities.enums.MontageType;
import com.ispectrum.crmclima.areas.orders.entities.enums.ProphylacticType;
import com.ispectrum.crmclima.areas.orders.entities.enums.RepairType;
import com.ispectrum.crmclima.areas.products.models.dtos.BaseProductDto;

import java.time.LocalDate;
import java.util.Map;

public class CreateScheduleDto {
    private String service;

    private String id;

    private LocalDate orderDate;

    private MontageType montageType;

    private ProphylacticType prophylacticType;

    private RepairType repairType;

    private Integer count;

    private String product;

    private Map<BaseProductDto,Integer> airConditioners;

    private String other;

    private String description;

    private ClientDto client;

    private LocationDto location;

    private Double deposit;

    private Double forPayment;

    private String status;

    private String comment;

    private LocalDate scheduleDate;

    private boolean isMarked;
    private boolean isFinished;
    private boolean isWithInvoice;
    private boolean isPayed;
    private boolean isDeferred;
    private boolean isWaiting;
    private boolean isWarranty;
    private boolean isForFinishing;

    public CreateScheduleDto() {
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }



    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClientDto getClient() {
        return this.client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public LocationDto getLocation() {
        return this.location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getOther() {
        return this.other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Map<BaseProductDto, Integer> getAirConditioners() {
        return this.airConditioners;
    }

    public void setAirConditioners(Map<BaseProductDto, Integer> airConditioners) {
        this.airConditioners = airConditioners;
    }

    public MontageType getMontageType() {
        return this.montageType;
    }

    public void setMontageType(MontageType montageType) {
        this.montageType = montageType;
    }

    public ProphylacticType getProphylacticType() {
        return this.prophylacticType;
    }

    public void setProphylacticType(ProphylacticType prophylacticType) {
        this.prophylacticType = prophylacticType;
    }

    public RepairType getRepairType() {
        return this.repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
