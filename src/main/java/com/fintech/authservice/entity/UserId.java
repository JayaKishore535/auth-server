package com.fintech.authservice.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserId implements Serializable {

    @Column(name = "USERID", nullable = false)
    private String id;

    @Column(name = "MOBILE", nullable = false)
    private String mobileNumber;

    public String getId() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}