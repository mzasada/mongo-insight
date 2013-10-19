import pymongo
from apscheduler.scheduler import Scheduler

scheduler = Scheduler()
db = pymongo.MongoClient('mongodb://localhost:27017/')['ecp']


def find_all_collections():
    return db.collection_names()


def send_collection_stats(collection):
    print db.command("collstats", collection, scale=1024)


@scheduler.interval_schedule(minutes=15)
def send_statistics_job():
    for collection in find_all_collections():
        send_collection_stats(collection)


scheduler.start()
while True:
    pass