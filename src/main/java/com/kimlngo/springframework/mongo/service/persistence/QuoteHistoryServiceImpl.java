package com.kimlngo.springframework.mongo.service.persistence;

import com.kimlngo.springframework.mongo.domain.QuoteHistory;
import com.kimlngo.springframework.mongo.model.Quote;
import com.kimlngo.springframework.mongo.repository.QuoteHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuoteHistoryServiceImpl implements QuoteHistoryService {

    private final QuoteHistoryRepository repository;

    @Override
    public Mono<QuoteHistory> saveQuoteToMongo(Quote quote) {
        return repository.save(QuoteHistory.builder()
                                           .ticker(quote.getTicker())
                                           .price(quote.getPrice())
                                           .instant(quote.getInstant())
                                           .build());
    }
}
