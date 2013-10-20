package org.mongocrunch.ingester.repository.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class CollectionStatistics implements Serializable {
  @Id
  private String id;
  private String clientUID;
  private Date timestamp;
  private Map<String, Object> statistics;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClientUID() {
    return clientUID;
  }

  public void setClientUID(String clientUID) {
    this.clientUID = clientUID;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public Map<String, Object> getStatistics() {
    return statistics;
  }

  public void setStatistics(Map<String, Object> statistics) {
    this.statistics = statistics;
  }
}
