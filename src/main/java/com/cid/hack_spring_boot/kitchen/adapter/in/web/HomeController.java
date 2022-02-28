package com.cid.hack_spring_boot.kitchen.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

// 스프링 컨테이너 json이나 xml 같은 데이터가 아닌 템플릿을 사용한 웹 페이지를 반환
@RequiredArgsConstructor
@Controller
public class HomeController {
    @GetMapping("/")
    Mono<String> hom() {
        // 리액티브 컨테이너인 mono에 담아서 보냄, home이라는 문제열을 Mono.just()로 감싸서 반환
        // 궅이 담아서 보낼 필요 없지만 그 이유는 잠시후에
        return Mono.just("home");
    }
}
