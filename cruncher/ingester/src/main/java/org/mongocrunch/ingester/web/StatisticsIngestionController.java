package org.mongocrunch.ingester.web;

import java.util.Map;

import org.mongocrunch.ingester.service.StatisticsIngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StatisticsIngestionController {

  private StatisticsIngestionService statisticsIngestionService;

  @Autowired
  public StatisticsIngestionController(StatisticsIngestionService statisticsIngestionService) {
    this.statisticsIngestionService = statisticsIngestionService;
  }

  @RequestMapping(value = "/stats/{clientUID}/collections", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(HttpStatus.ACCEPTED)
  public HttpEntity<?> storeCollectionStatistics(@RequestBody Map<String, Object> statistics,
      @PathVariable String clientUID) {
    statisticsIngestionService.saveCollectionStatistics(clientUID, statistics);
    return HttpEntity.EMPTY;
  }
}
