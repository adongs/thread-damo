package com.thread.demo;

import org.springframework.scheduling.concurrent.DefaultManagedAwareThreadFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * @Author yudong
 * @Date 2018年06月20日 下午2:07
 */
public class ScheduledExecutorServiceTest {


    public static void main(String[] args) {


        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(2,Executors.defaultThreadFactory());

    }
}
