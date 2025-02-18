package com.reaosen.management_system.Model;

public class WasteType {
    private Integer wasteTypeId;

    private String typeName;

    private Integer gmtCreate;

    private Integer gmtModified;

    private String description;

    public Integer getWasteTypeId() {
        return wasteTypeId;
    }

    public void setWasteTypeId(Integer wasteTypeId) {
        this.wasteTypeId = wasteTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}