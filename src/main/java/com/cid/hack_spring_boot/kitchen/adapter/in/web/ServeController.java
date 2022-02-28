package com.cid.hack_spring_boot.kitchen.adapter.in.web;

import com.cid.hack_spring_boot.kitchen.application.KitchenService;
import com.cid.hack_spring_boot.kitchen.application.port.in.DeliveryUseCase;
import com.cid.hack_spring_boot.kitchen.application.port.in.ServeUseCase;
import com.cid.hack_spring_boot.kitchen.domain.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
public class ServeController {
    private final ServeUseCase serveUseCase;
    private final DeliveryUseCase deliveryUseCase;

    @GetMapping(value = "/serve", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> serveDishes() {
        return this.serveUseCase.serveDish();
    }

    @GetMapping(value = "/served-dish", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> deliverDishes() {
        return deliveryUseCase.deliverDish();
    }
}
