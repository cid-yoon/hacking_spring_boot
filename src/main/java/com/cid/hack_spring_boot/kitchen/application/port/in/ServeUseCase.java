package com.cid.hack_spring_boot.kitchen.application.port.in;

import com.cid.hack_spring_boot.kitchen.domain.Dish;
import reactor.core.publisher.Flux;

public interface ServeUseCase
{
    Flux<Dish> serveDish();
}
