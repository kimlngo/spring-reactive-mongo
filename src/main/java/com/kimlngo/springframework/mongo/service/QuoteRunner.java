package com.kimlngo.springframework.mongo.service;

import com.kimlngo.springframework.mongo.service.generator.QuoteGeneratorService;
import com.kimlngo.springframework.mongo.service.persistence.QuoteHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuoteRunner implements CommandLineRunner {

    private final QuoteGeneratorService generatorService;
    private final QuoteHistoryService historyService;

    @Override
    public void run(String... args) throws Exception {
        generatorService.fetchQuoteStream(Duration.ofMillis(1000l))
                .take(50)
                .log("Got Quote: ")
                .flatMap(historyService::saveQuoteToMongo)
                .subscribe(savedQuote -> {
                    log.debug("Saved Quote: " + savedQuote);
                }, throwable -> {
                    log.error("Error", throwable);
                }, () -> {
                    log.debug("All Done!!!");
                });
    }
}
