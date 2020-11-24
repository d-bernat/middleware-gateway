package de.dbernat.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("monitoring")
public class AliveController
{
    @GetMapping("alive")
    public Mono<String> alive() {
        return Mono.just(":-)");
    }
}
