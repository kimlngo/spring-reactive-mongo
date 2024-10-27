package com.kimlngo.springframework.mongo.service.generator;

import com.kimlngo.springframework.mongo.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {

    Flux<Quote> fetchQuoteStream(Duration period);
}
