package com.kongxiang.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.concurrent
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/5 20:51
 */
public class CountDownLatchDemo {

  public static void main(String[] args) {

    final CountDownLatch countDownLatch = new CountDownLatch(2);
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
          countDownLatch.countDown();
          System.out.println(" excute 1");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    },"t1").start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(5000);
          countDownLatch.countDown();
          System.out.println(" excute 2");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    },"t2").start();

    System.out.println(" await have running.... ");
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(" await have excuted ");
  }

}
