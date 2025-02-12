package com.reaosen.management_system.Model;

import java.math.BigDecimal;

public class WasteRecord {
    private Integer wasterecordid;

    private Integer wastetypeid;

    private Integer collectionpointid;

    private Integer collectiontime;

    private BigDecimal weight;

    private String status;

    private Integer accountId;

    private Integer gmtCreate;

    private Integer gmtModified;

    public Integer getWasterecordid() {
        return wasterecordid;
    }

    public void setWasterecordid(Integer wasterecordid) {
        this.wasterecordid = wasterecordid;
    }

    public Integer getWastetypeid() {
        return wastetypeid;
    }

    public void setWastetypeid(Integer wastetypeid) {
        this.wastetypeid = wastetypeid;
    }

    public Integer getCollectionpointid() {
        return collectionpointid;
    }

    public void setCollectionpointid(Integer collectionpointid) {
        this.collectionpointid = collectionpointid;
    }

    public Integer getCollectiontime() {
        return collectiontime;
    }

    public void setCollectiontime(Integer collectiontime) {
        this.collectiontime = collectiontime;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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