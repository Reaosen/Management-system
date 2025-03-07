package com.reaosen.management_system.Model;

import java.math.BigDecimal;

public class DisposalRecord {
    private Integer disposalId;

    private Integer wasteRecordId;

    private Integer disposalTime;

    private Integer disposalMethodId;

    private Integer disposalPointId;

    private Integer disposalAccountId;

    private Integer gmtCreate;

    private Integer gmtModified;

    private BigDecimal budget;

    public Integer getDisposalId() {
        return disposalId;
    }

    public void setDisposalId(Integer disposalId) {
        this.disposalId = disposalId;
    }

    public Integer getWasteRecordId() {
        return wasteRecordId;
    }

    public void setWasteRecordId(Integer wasteRecordId) {
        this.wasteRecordId = wasteRecordId;
    }

    public Integer getDisposalTime() {
        return disposalTime;
    }

    public void setDisposalTime(Integer disposalTime) {
        this.disposalTime = disposalTime;
    }

    public Integer getDisposalMethodId() {
        return disposalMethodId;
    }

    public void setDisposalMethodId(Integer disposalMethodId) {
        this.disposalMethodId = disposalMethodId;
    }

    public Integer getDisposalPointId() {
        return disposalPointId;
    }

    public void setDisposalPointId(Integer disposalPointId) {
        this.disposalPointId = disposalPointId;
    }

    public Integer getDisposalAccountId() {
        return disposalAccountId;
    }

    public void setDisposalAccountId(Integer disposalAccountId) {
        this.disposalAccountId = disposalAccountId;
    }

    public Integer getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Integer gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Integer gmtModified) {
        this.gmtModified = gmtModified;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}