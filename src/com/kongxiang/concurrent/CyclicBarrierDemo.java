package com.kongxiang.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.concurrent
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/5 20:44
 */
public class CyclicBarrierDemo {

  public static void main(String[] args) {

    final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
     new Thread(new Runnable() {
       @Override
       public void run() {

         try {
           Thread.sleep(3000);
         } catch (InterruptedException e) {
           e.printStackTrace();
         }

         try {
           cyclicBarrier.await();
           System.out.println("查询数据库");
         } catch (InterruptedException e) {
           e.printStackTrace();
         } catch (BrokenBarrierException e) {
           e.printStackTrace();
         }
       }
     },"t1").start();

    new Thread(new Runnable() {
      @Override
      public void run() {

        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          cyclicBarrier.await();
          System.out.println("查询网络数据");
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
      }
    },"t2").start();

    System.out.println("main running ");
  }
}
