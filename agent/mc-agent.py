import pymongo
import atexit
from apscheduler.scheduler import Scheduler

scheduler = Scheduler(daemon=True)
db = pymongo.MongoClient('mongodb://localhost:27017/')['ecp']


def find_all_collections():
    return db.collection_names()


def send_collection_stats(collection):
    print db.command("collstats", collection, scale=1024)


@scheduler.cron_schedule(minute='0/5')
def send_statistics_job():
    for collection in find_all_collections():
        send_collection_stats(collection)


scheduler.start()
atexit.register(lambda: scheduler.shutdown(wait=False))
while True:
    pass