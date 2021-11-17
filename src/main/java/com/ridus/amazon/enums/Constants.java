package com.ridus.amazon.enums;

public enum Constants {

    TIME_TO_WAIT(20),
    POSITION_TO_START(1),
    ITEM_QUANTITY(2),
    NEW_ITEM_QUANTITY(1);

    int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
