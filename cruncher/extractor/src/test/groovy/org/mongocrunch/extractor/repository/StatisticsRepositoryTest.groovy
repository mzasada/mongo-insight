package org.mongocrunch.extractor.repository

import com.mongodb.DB
import com.mongodb.Mongo
import org.jongo.Jongo
import spock.lang.Specification

class StatisticsRepositoryTest extends Specification {

    StatisticsRepository statisticsRepository

    def setup() {
        DB db = new Mongo().getDB("gcs")
        statisticsRepository = new StatisticsRepository(new Jongo(db))
    }

    def "should connect to local MongoDB instance"() {
        expect:
        def result = statisticsRepository.findStorageStatistics()
        println(result)
    }
}
