package com.srini.ratelimit.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type App service.
 */
@Service
@Slf4j
public class AppService {

    private AtomicInteger counter = new AtomicInteger() ;

    /**
     * Get default string.
     *
     * @return the string
     */
    @RateLimiter(name = "serviceA", fallbackMethod = "fallbackA")
    public String getDefault(){
        log.info("{} -> counter {} ", Thread.currentThread().getName(), counter.incrementAndGet());
        return "Get from default" ;
    }


    private String fallbackA(Throwable throwable){
        log.error("{}", throwable);
        counter.set(0);
        return "fallbackA" ;
    }
}
