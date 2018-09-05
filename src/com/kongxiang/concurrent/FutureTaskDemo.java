package com.kongxiang.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.concurrent
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/3 23:59
 */
public class FutureTaskDemo {
  static String result  ="hello";
  public static void main(String[] args) {

   // 异步Runnable 写法
    FutureTask<String> futureTask = new FutureTask<String>(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        result = "result_run_result 5000";
        System.out.println(result);
      }
    }, null );

    futureTask.run();
    // 异步Runnable 写法
    FutureTask<String> futureTask1 = new FutureTask<String>(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(20000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        result = "result_run_result 3000";
        System.out.println(result);
      }
    }, null );

    futureTask1.run();
    System.out.println(result);
  }
}
