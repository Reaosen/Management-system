package com.reaosen.management_system.Model;

public class TransportRecord {
    private Integer transportid;

    private Integer wasterecordid;

    private Integer transporttime;

    private String transportvehicle;

    private String drivername;

    private Integer accountId;

    private Integer gmtCreate;

    private Integer gmtModified;

    public Integer getTransportid() {
        return transportid;
    }

    public void setTransportid(Integer transportid) {
        this.transportid = transportid;
    }

    public Integer getWasterecordid() {
        return wasterecordid;
    }

    public void setWasterecordid(Integer wasterecordid) {
        this.wasterecordid = wasterecordid;
    }

    public Integer getTransporttime() {
        return transporttime;
    }

    public void setTransporttime(Integer transporttime) {
        this.transporttime = transporttime;
    }

    public String getTransportvehicle() {
        return transportvehicle;
    }

    public void setTransportvehicle(String transportvehicle) {
        this.transportvehicle = transportvehicle;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
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