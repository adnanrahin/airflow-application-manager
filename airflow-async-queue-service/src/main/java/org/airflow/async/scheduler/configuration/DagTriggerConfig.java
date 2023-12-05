package org.airflow.async.scheduler.configuration;

import org.airflow.async.scheduler.controller.DagTriggerController;
import org.airflow.async.scheduler.service.DagRunService;
import org.airflow.async.scheduler.service.DagTriggerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class DagTriggerConfig {

    @Bean
    public DagTaskScheduler dagTriggerService(
            DagRunService dagRunService,
            DagTriggerService dagTriggerService,
            DagTriggerController dagTriggerController) {
        return new DagTaskScheduler(dagRunService, dagTriggerService, dagTriggerController);
    }

}
