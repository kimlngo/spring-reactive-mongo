package com.kimlngo.springframework.mongo.service.persistence;

import com.kimlngo.springframework.mongo.domain.QuoteHistory;
import com.kimlngo.springframework.mongo.model.Quote;
import reactor.core.publisher.Mono;

public interface QuoteHistoryService {
    Mono<QuoteHistory> saveQuoteToMongo(Quote quote);
}
