package com.thread.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 计算一组数的总和
 * @Author yudong
 * @Date 2018年06月20日 下午3:26
 */
public class ForkJoinPool2Test extends RecursiveTask<Integer> {

    private List<Integer> number = new ArrayList<>();

    public ForkJoinPool2Test(List<Integer> number) {
        this.number = number;
    }

    @Override
    protected Integer compute() {
       //如果这一组数超过了100个,分发下去
        int sum=0;
        int size = number.size();
        if (size<5){
            for (int i =0;i<size;i++){
                sum=sum+number.get(i);
            }
            try {
            Thread.sleep(200L);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"求和完了:"+sum);
            return sum;
        }else{
            ForkJoinPool2Test  f1  = new ForkJoinPool2Test(number.subList(0,4));
            ForkJoinPool2Test  f2  = new ForkJoinPool2Test(number.subList(4,number.size()));
            f1.fork();
            f2.fork();
            return f1.join()+f2.join();


        }
    }


    public static void main(String[] args) throws Exception{
        List<Integer> number = new ArrayList<>();
        for (int i = 1;i<=100;i++){
            number.add(i);
        }
        Long time = System.currentTimeMillis();
        ForkJoinPool2Test f = new ForkJoinPool2Test(number);
        ForkJoinPool pool=new ForkJoinPool(1);
        Integer sum  = 0;
        sum = pool.submit(f).get();
        System.out.println("求和:"+sum+"   使用时间"+(System.currentTimeMillis()-time));
        pool.shutdown();



    }

}
