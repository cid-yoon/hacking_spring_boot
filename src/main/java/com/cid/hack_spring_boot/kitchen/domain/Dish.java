package com.cid.hack_spring_boot.kitchen.domain;

import lombok.Getter;

public class Dish {

    // 음식 이름
    @Getter
    private final String name;

    // 배송 여부
    private final boolean delivered;

    public Dish(String name, boolean delivered) {
        this.name = name;
        this.delivered = delivered;
    }

    public Dish(String name) {
        this(name, false);
    }

    public static Dish deliver(Dish dish) {
        return new Dish(dish.name, true);
    }


    //  method
    public boolean isDelivered() {
        return delivered;
    }


    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", delivered=" + delivered +
                '}';
    }


}
