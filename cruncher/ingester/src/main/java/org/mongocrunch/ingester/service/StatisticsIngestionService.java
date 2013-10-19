package org.mongocrunch.ingester.service;

import java.util.Map;

public interface StatisticsIngestionService {
  public void saveCollectionStatistics(String clientUID, Map<String, Object> statistics);
}
