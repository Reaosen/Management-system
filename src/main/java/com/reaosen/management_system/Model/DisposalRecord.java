package com.reaosen.management_system.Model;

public class DisposalRecord {
    private Integer disposalId;

    private Integer wasteRecordId;

    private Integer disposalTime;

    private String disposalMethod;

    private Integer disposalPointId;

    private Integer disposalAccountId;

    private Integer gmtCreate;

    private Integer gmtModified;

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

    public String getDisposalMethod() {
        return disposalMethod;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
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
}