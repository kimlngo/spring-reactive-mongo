package com.kimlngo.springframework.mongo.repository;

import com.kimlngo.springframework.mongo.domain.QuoteHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuoteHistoryRepository extends ReactiveMongoRepository<QuoteHistory, String> {
}
