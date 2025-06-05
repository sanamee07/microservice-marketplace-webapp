package edu.fra.uas.model;

public class Advertisement {
    private long userId;
    private long advertisementId;
    private String title;
    private String description;
    private double pricePerUnit;

    public Advertisement(long userId, long advertisementId, String title, String description, double pricePerUnit) {
        this.userId = userId;
        this.advertisementId = advertisementId;
        this.title = title;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
    }

    public Advertisement() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(long advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
    
}
