package com.kongxiang.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.concurrent
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/5 21:23
 */
public class CompletionServiceDemo {
    // 谁最先执行就是谁
    public static void main(String[] args) throws InterruptedException, ExecutionException {
      ExecutorService executor = Executors.newFixedThreadPool(10);
      CompletionService completionService = new ExecutorCompletionService(executor);
      for (int i =1; i <=10; i ++) {
        final  int result = i;
        completionService.submit(new Callable() {
          @Override
          public Object call() throws Exception {
            Thread.sleep(new Random().nextInt(5000));
            return result;
          }
        });
      }
      System.out.println(completionService.take().get());

      executor.shutdown();
    }
  }


