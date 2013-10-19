package org.mongocrunch.ingester.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class StatisticsIngestionServiceImpl implements StatisticsIngestionService {

  private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsIngestionServiceImpl.class);

  @Async
  @Override
  public void saveCollectionStatistics(String clientUID, Map<String, Object> statistics) {
    LOGGER.info("Storing collection statistics for client {}", clientUID);
  }
}
