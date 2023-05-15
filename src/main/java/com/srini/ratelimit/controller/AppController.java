package com.srini.ratelimit.controller;

import com.srini.ratelimit.service.AppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

/**
 * The type App controller.
 */
@RestController
@RequestMapping("/app")
@Slf4j
@RequiredArgsConstructor
public class AppController {

    private final AppService appService ;

    /**
     * Get string.
     *
     * @return the string
     */
    @GetMapping("/rate")
    public String get(){
        //fake calls to reproduce concurrent calls to exceed the rate limit
        IntStream.rangeClosed(1,11)
                .parallel()
                .forEach(e -> log.info("{}", appService.getDefault()));

        return appService.getDefault() ;
    }
}
