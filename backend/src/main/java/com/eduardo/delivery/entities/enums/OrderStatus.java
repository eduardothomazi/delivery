package com.eduardo.delivery.entities.enums;

public enum OrderStatus {
    PENDING(1),
    DELIVERED(2);

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
