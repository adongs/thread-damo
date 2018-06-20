package com.thread.demo;

/**
 * @Author yudong
 * @Date 2018年06月20日 上午10:47
 */
public class ThreadTest extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("线程完成启动");
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
    }
}
