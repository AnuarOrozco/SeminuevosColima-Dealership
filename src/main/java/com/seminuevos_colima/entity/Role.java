package com.seminuevos_colima.entity;

public enum Role {

    VENDEDOR("Vendedor"),
    COMPRADOR("Comprador"),
    ADMINISTRADOR("Administrador");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    // Método auxiliar para verificar si el rol es ADMINISTRADOR
    public boolean isAdmin() {
        return this == ADMINISTRADOR;
    }
}

