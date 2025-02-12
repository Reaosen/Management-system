package com.reaosen.management_system.Model;

public class DisposalRecord {
    private Integer disposalid;

    private Integer wasterecordid;

    private Integer disposaltime;

    private String disposalmethod;

    private String disposallocation;

    private Integer accountId;

    private Integer gmtCreate;

    private Integer gmtModified;

    public Integer getDisposalid() {
        return disposalid;
    }

    public void setDisposalid(Integer disposalid) {
        this.disposalid = disposalid;
    }

    public Integer getWasterecordid() {
        return wasterecordid;
    }

    public void setWasterecordid(Integer wasterecordid) {
        this.wasterecordid = wasterecordid;
    }

    public Integer getDisposaltime() {
        return disposaltime;
    }

    public void setDisposaltime(Integer disposaltime) {
        this.disposaltime = disposaltime;
    }

    public String getDisposalmethod() {
        return disposalmethod;
    }

    public void setDisposalmethod(String disposalmethod) {
        this.disposalmethod = disposalmethod;
    }

    public String getDisposallocation() {
        return disposallocation;
    }

    public void setDisposallocation(String disposallocation) {
        this.disposallocation = disposallocation;
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