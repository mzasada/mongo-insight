package org.mongocrunch.ingester.service;

import java.util.Date;
import java.util.Map;

import org.mongocrunch.ingester.repository.CollectionStatisticsRepository;
import org.mongocrunch.ingester.repository.model.CollectionStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class StatisticsIngestionServiceImpl implements StatisticsIngestionService {
  private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsIngestionServiceImpl.class);
  private CollectionStatisticsRepository collectionStatisticsRepository;

  @Autowired
  public StatisticsIngestionServiceImpl(CollectionStatisticsRepository collectionStatisticsRepository) {
    this.collectionStatisticsRepository = collectionStatisticsRepository;
  }

  @Async
  @Override
  public void saveCollectionStatistics(String clientUID, Map<String, Object> statistics) {
    LOGGER.info("Storing collection statistics for client {}", clientUID);
    CollectionStatistics collectionStatistics = new CollectionStatistics();
    collectionStatistics.setClientUID(clientUID);
    collectionStatistics.setStatistics(statistics);
    collectionStatistics.setTimestamp(new Date());
    collectionStatisticsRepository.save(collectionStatistics);
  }
}
