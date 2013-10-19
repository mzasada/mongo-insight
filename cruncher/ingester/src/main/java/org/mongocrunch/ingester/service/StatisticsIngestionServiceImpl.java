package org.mongocrunch.ingester.service;

import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class StatisticsIngestionServiceImpl implements StatisticsIngestionService {
  @Async
  @Override
  public void saveCollectionStatistics(String clientUID, Map<String, Object> statistics) {
  }
}
