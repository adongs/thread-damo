package com.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author yudong
 * @Date 2018年06月20日 下午1:45
 */
public class ExecutorServiceTest {

    public static void main(String[] args) {
        //创建指定数量的线程池
        ExecutorService  es = Executors.newFixedThreadPool(10);
        //创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
        ExecutorService  es1 = Executors.newCachedThreadPool();
        //创建一个单线程化的Executor,它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
        ExecutorService  es2 = Executors.newSingleThreadExecutor();
        //创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类,配置核心线程数量
        ExecutorService  es3 = Executors.newScheduledThreadPool(10);
        //创建持有足够线程的线程池来支持给定的并行级别，并通过使用多个队列，减少竞争，它需要穿一个并行级别的参数，如果不传，则被设定为默认的CPU数量
        ExecutorService  es4 = Executors.newWorkStealingPool();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("线程完成启动");
            }
        };
        es.execute(task);
    }
}
