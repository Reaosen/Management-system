package com.reaosen.management_system.Model;

import java.math.BigDecimal;

public class WasteRecord {
    private Integer wasteRecordId;

    private Integer wasteTypeId;

    private Integer collectionPointId;

    private Integer collectionTime;

    private BigDecimal weight;

    private Integer status;

    private Integer collectionAccountId;

    private Integer gmtCreate;

    private Integer gmtModified;

    public Integer getWasteRecordId() {
        return wasteRecordId;
    }

    public void setWasteRecordId(Integer wasteRecordId) {
        this.wasteRecordId = wasteRecordId;
    }

    public Integer getWasteTypeId() {
        return wasteTypeId;
    }

    public void setWasteTypeId(Integer wasteTypeId) {
        this.wasteTypeId = wasteTypeId;
    }

    public Integer getCollectionPointId() {
        return collectionPointId;
    }

    public void setCollectionPointId(Integer collectionPointId) {
        this.collectionPointId = collectionPointId;
    }

    public Integer getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Integer collectionTime) {
        this.collectionTime = collectionTime;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCollectionAccountId() {
        return collectionAccountId;
    }

    public void setCollectionAccountId(Integer collectionAccountId) {
        this.collectionAccountId = collectionAccountId;
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