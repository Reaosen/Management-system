package com.reaosen.management_system.Model;

public class TransportRecord {
    private Integer transportId;

    private Integer wasteRecordId;

    private Integer transportTime;

    private String transportVehicle;

    private Integer collectionPointId;

    private Integer disposalPointId;

    private String transportusername;

    private Integer transportAccountId;

    private Integer gmtCreate;

    private Integer gmtModified;

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public Integer getWasteRecordId() {
        return wasteRecordId;
    }

    public void setWasteRecordId(Integer wasteRecordId) {
        this.wasteRecordId = wasteRecordId;
    }

    public Integer getTransportTime() {
        return transportTime;
    }

    public void setTransportTime(Integer transportTime) {
        this.transportTime = transportTime;
    }

    public String getTransportVehicle() {
        return transportVehicle;
    }

    public void setTransportVehicle(String transportVehicle) {
        this.transportVehicle = transportVehicle;
    }

    public Integer getCollectionPointId() {
        return collectionPointId;
    }

    public void setCollectionPointId(Integer collectionPointId) {
        this.collectionPointId = collectionPointId;
    }

    public Integer getDisposalPointId() {
        return disposalPointId;
    }

    public void setDisposalPointId(Integer disposalPointId) {
        this.disposalPointId = disposalPointId;
    }

    public String getTransportusername() {
        return transportusername;
    }

    public void setTransportusername(String transportusername) {
        this.transportusername = transportusername;
    }

    public Integer getTransportAccountId() {
        return transportAccountId;
    }

    public void setTransportAccountId(Integer transportAccountId) {
        this.transportAccountId = transportAccountId;
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