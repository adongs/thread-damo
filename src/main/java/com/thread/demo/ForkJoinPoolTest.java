package com.thread.demo;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @Author yudong
 * @Date 2018年06月20日 下午2:37
 */
public class ForkJoinPoolTest extends RecursiveAction {

    //任务容器,可以为一个对象
    private int task = 0;

    //构造方法用于传入数据对象
    public ForkJoinPoolTest(int task) {
        this.task = task;
    }

    @Override
    protected void compute() {
        //是否分发的条件,这里是如果任务量大于20,就分解成两个小任务执行
        if (task <=20){
            System.out.println(Thread.currentThread().getName()+"承担了"+task+"份工作");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            Random m = new Random();
            int x = 20;
            ForkJoinPoolTest n1 = new ForkJoinPoolTest(x);
            ForkJoinPoolTest n2 = new ForkJoinPoolTest(task - x);
            n1.fork();
            n2.fork();
        }
    }

    public static void main(String[] args) {
        //创建一个支持分解任务的线程池ForkJoinPool
        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinPoolTest n1 = new ForkJoinPoolTest(52);
        pool.submit(n1);
        pool.awaitQuiescence(20, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
