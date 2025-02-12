package com.reaosen.management_system.Model;

public class WasteType {
    private Integer wastetypeid;

    private String typename;

    private Integer gmtCreate;

    private Integer gmtModified;

    private String description;

    public Integer getWastetypeid() {
        return wastetypeid;
    }

    public void setWastetypeid(Integer wastetypeid) {
        this.wastetypeid = wastetypeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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