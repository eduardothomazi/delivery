package com.eduardo.delivery.entities.enums;

public enum OrderStatus {
    PENDING(0),
    DELIVERED(1);

    private int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OrderStatus toEnum(int value){
        for (OrderStatus name : OrderStatus.values()) {
            if ( name.value == value){
                return name;
            }
        }
        return OrderStatus.valueOf("");
    }
}
