package com.xcz.printer.pojo;

public class User {
    private Integer id;

    private String openid;

    private String nickname;

    private Integer gender;

    private String avatarurl;

    private String language;

    private String city;

    private String province;

    private String country;

    private String defPhone;

    private String defAddress;

    private String defName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getDefPhone() {
        return defPhone;
    }

    public void setDefPhone(String defPhone) {
        this.defPhone = defPhone == null ? null : defPhone.trim();
    }

    public String getDefAddress() {
        return defAddress;
    }

    public void setDefAddress(String defAddress) {
        this.defAddress = defAddress == null ? null : defAddress.trim();
    }

    public String getDefName() {
        return defName;
    }

    public void setDefName(String defName) {
        this.defName = defName == null ? null : defName.trim();
    }
}