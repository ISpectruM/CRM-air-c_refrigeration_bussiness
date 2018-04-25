package com.ispectrum.crmclima.areas.orders.models.ajax;

public class StatusBindingSaveModel {

    private boolean isMarked;
    private boolean isFinished;
    private boolean isForFinishing;
    private boolean isWithInvoice;
    private boolean isPayed;
    private boolean isDeferred;
    private boolean isWaiting;

    public StatusBindingSaveModel() {
    }

    public boolean getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(boolean marked) {
        this.isMarked = marked;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public void setIsFinished(boolean finished) {
        this.isFinished = finished;
    }

    public boolean getIsWithInvoice() {
        return this.isWithInvoice;
    }

    public void setIsWithInvoice(boolean withInvoice) {
        this.isWithInvoice = withInvoice;
    }

    public boolean getIsPayed() {
        return this.isPayed;
    }

    public void setIsPayed(boolean payed) {
        this.isPayed = payed;
    }

    public boolean getIsDeferred() {
        return this.isDeferred;
    }

    public void setIsDeferred(boolean deferred) {
        this.isDeferred = deferred;
    }

    public boolean getIsWaiting() {
        return this.isWaiting;
    }

    public void setIsWaiting(boolean waiting) {
        this.isWaiting = waiting;
    }

    public boolean getIsForFinishing() {
        return this.isForFinishing;
    }

    public void setIsForFinishing(boolean forFinishing) {
        isForFinishing = forFinishing;
    }

}
