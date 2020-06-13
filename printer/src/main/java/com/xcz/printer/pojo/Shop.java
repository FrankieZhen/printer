package com.xcz.printer.pojo;

import java.math.BigDecimal;

public class Shop {
    private Integer id;

    private String shopName;

    private String location;

    private Integer property;

    private String picture;

    private String product;

    private String proprice;

    private Integer iscolorful;

    private String remark;

    private BigDecimal lat;

    private BigDecimal lng;

    private BigDecimal singlePurePrice;

    private BigDecimal doublePurePrice;

    private BigDecimal singleColorPrice;

    private BigDecimal doubleColorPrice;

    private BigDecimal deliverPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getProprice() {
        return proprice;
    }

    public void setProprice(String proprice) {
        this.proprice = proprice == null ? null : proprice.trim();
    }

    public Integer getIscolorful() {
        return iscolorful;
    }

    public void setIscolorful(Integer iscolorful) {
        this.iscolorful = iscolorful;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getSinglePurePrice() {
        return singlePurePrice;
    }

    public void setSinglePurePrice(BigDecimal singlePurePrice) {
        this.singlePurePrice = singlePurePrice;
    }

    public BigDecimal getDoublePurePrice() {
        return doublePurePrice;
    }

    public void setDoublePurePrice(BigDecimal doublePurePrice) {
        this.doublePurePrice = doublePurePrice;
    }

    public BigDecimal getSingleColorPrice() {
        return singleColorPrice;
    }

    public void setSingleColorPrice(BigDecimal singleColorPrice) {
        this.singleColorPrice = singleColorPrice;
    }

    public BigDecimal getDoubleColorPrice() {
        return doubleColorPrice;
    }

    public void setDoubleColorPrice(BigDecimal doubleColorPrice) {
        this.doubleColorPrice = doubleColorPrice;
    }

    public BigDecimal getDeliverPrice() {
        return deliverPrice;
    }

    public void setDeliverPrice(BigDecimal deliverPrice) {
        this.deliverPrice = deliverPrice;
    }
}