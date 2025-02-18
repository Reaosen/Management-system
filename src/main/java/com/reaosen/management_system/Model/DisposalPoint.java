package com.reaosen.management_system.Model;

public class DisposalPoint {
    private Integer disposalPointId;

    private String address;

    private String contact;

    private String responsiblePerson;

    private Integer accountId;

    private Integer gmtCreate;

    private Integer gmtModified;

    public Integer getDisposalPointId() {
        return disposalPointId;
    }

    public void setDisposalPointId(Integer disposalPointId) {
        this.disposalPointId = disposalPointId;
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