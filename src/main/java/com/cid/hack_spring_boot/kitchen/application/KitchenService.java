package com.cid.hack_spring_boot.kitchen.application;

import com.cid.hack_spring_boot.kitchen.application.port.in.DeliveryUseCase;
import com.cid.hack_spring_boot.kitchen.application.port.in.ServeUseCase;
import com.cid.hack_spring_boot.kitchen.domain.Dish;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Random;

@Service
public class KitchenService implements DeliveryUseCase, ServeUseCase {

    private final List<Dish> menu = List.of(new Dish("Sesame Chicken"),
            new Dish("Lo mein noodles, plain"),
            new Dish("Sweet & sour beef"));

    private final Random picker = new Random();

    /**
     * 요리 스트림 생성
     */
    private Flux<Dish> getDishes() {
        return Flux.<Dish>generate(sink -> sink.next(randomDish()))
                .delayElements(Duration.ofMillis(250));
    }

    /**
     * 임의 요리 선택
     */
    private Dish randomDish() {
        return menu.get(picker.nextInt(menu.size()));
    }


    @Override
    public Flux<Dish> deliverDish() {
        return getDishes()
                .map(Dish::deliver);
    }

    @Override
    public Flux<Dish> serveDish() {
        return getDishes();
    }
}
