package org.airflow.async.scheduler.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@RestController
public class SchedulerControllerForTest {

    private final Queue<String> stringQueue = new ConcurrentLinkedQueue<>();

    @RequestMapping(method = RequestMethod.GET, value = "/task/{value}")
    public String triggerThePoll(@PathVariable String value) {

        if (value.equalsIgnoreCase("true")) {
            String qValue = value + " " + Integer.toString(stringQueue.size());
            stringQueue.add(qValue);
            return "New Params Are Added to Rest Transit Poll" + qValue;
        } else {
            return "Should Print this " + stringQueue.poll();
        }

    }

/*    @Scheduled(fixedRate = 2000)
    public void getCurrentTime() {
        System.out.println(showMeTheTime());
        showMeTheTime();
    }


    public String showMeTheTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }*/

}
