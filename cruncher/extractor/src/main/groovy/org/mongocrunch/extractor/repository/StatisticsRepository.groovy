package org.mongocrunch.extractor.repository

import org.jongo.Jongo

public class StatisticsRepository {

    Jongo jongo

    public StatisticsRepository(Jongo jongo) {
        this.jongo = jongo
    }

    def findStorageStatistics() {
        jongo.runCommand("{ dbStats: 1, scale: 1024 }").as(Map)
    }
}