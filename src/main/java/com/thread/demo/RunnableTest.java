package com.thread.demo;

/**
 * @Author yudong
 * @Date 2018年06月20日 上午10:54
 */
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("线程完成启动");
    }


    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();
        thread.start();
    }
}
