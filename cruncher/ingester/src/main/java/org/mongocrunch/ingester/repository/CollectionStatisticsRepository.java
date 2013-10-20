package org.mongocrunch.ingester.repository;

import org.mongocrunch.ingester.repository.model.CollectionStatistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionStatisticsRepository extends MongoRepository<CollectionStatistics, String> {
}
