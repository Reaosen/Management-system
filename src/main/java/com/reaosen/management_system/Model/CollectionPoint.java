package com.reaosen.management_system.Model;

public class CollectionPoint {
    private Integer collectionpointid;

    private String address;

    private String contact;

    private String responsibleperson;

    private Integer accountId;

    private Integer gmtCreate;

    private Integer gmtModified;

    public Integer getCollectionpointid() {
        return collectionpointid;
    }

    public void setCollectionpointid(Integer collectionpointid) {
        this.collectionpointid = collectionpointid;
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

    public String getResponsibleperson() {
        return responsibleperson;
    }

    public void setResponsibleperson(String responsibleperson) {
        this.responsibleperson = responsibleperson;
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