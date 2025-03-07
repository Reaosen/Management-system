package com.reaosen.management_system.Model;

import java.math.BigDecimal;

public class CollectionPoint {
    private Integer collectionPointId;

    private String address;

    private String contact;

    private String responsiblePerson;

    private Integer collectionAccountId;

    private Integer gmtCreate;

    private Integer gmtModified;

    private BigDecimal storageCapacity;

    private BigDecimal usedCapacity;

    private BigDecimal remainingCapacity;

    public Integer getCollectionPointId() {
        return collectionPointId;
    }

    public void setCollectionPointId(Integer collectionPointId) {
        this.collectionPointId = collectionPointId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
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

    public BigDecimal getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(BigDecimal storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public BigDecimal getUsedCapacity() {
        return usedCapacity;
    }

    public void setUsedCapacity(BigDecimal usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    public BigDecimal getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(BigDecimal remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }
}