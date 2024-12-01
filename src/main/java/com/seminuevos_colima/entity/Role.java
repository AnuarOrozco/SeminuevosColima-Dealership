package com.seminuevos_colima.entity;

public enum Role {

    SELLER("Seller"),
    BUYER("Buyer"),
    ADMIN("Administrator");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
