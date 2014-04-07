package name.oleg.scheduler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {
    private static Logger logger = Logger.getLogger(SchedulerService.class);

    @Autowired
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private List<Worker> workers;

    //Fire at 10:15 AM on the 3th day of every month
//    @Scheduled(cron = "0 15 10 3 * ?")
//    @Scheduled(fixedDelay = 5000)
    public void vacancyParserScheduler() {
        for (Worker worker : workers) {
            logger.info("Task start - " + worker);
            try {
//                worker.work();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            logger.info("Task end - " + worker);
        }
    }
}
