package com.fintech.authservice.constant;

public enum UserType {
    CAGT("ColAgent", "CAGT"),
    CSR("Consumer", "CSR"),
    DLR("Dealer", "DLR"),
    DSA("DSA", "DSA"),
    GP("Growth Partner", "GP"),
    NBFC("NBFC", "NBFC"),
    RAGT("RecAgent", "RAGT"),
    STF("Staff", "STF");

    private final String key;
    private final String value;

    UserType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
}