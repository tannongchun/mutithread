package com.kongxiang.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.threadpool
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/3 23:05
 */
public class UseThreadPoolExecutorDemo {

  public  static  void main(String args[]){
    ThreadPoolExecutor pool  = new ThreadPoolExecutor(
        1,
        2,
        60, // 60 s 线程自动回收
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<Runnable>(3),
        // 丢弃队列衷第一个个
//        new ThreadPoolExecutor.DiscardOldestPolicy()
        // 后面一个任务先执行
          new ThreadPoolExecutor.CallerRunsPolicy()
//        new LinkedBlockingQueue<Runnable>()
    );

    // 创建 6个任务
    for( int i =1 ;i<=6;i++){
      pool.execute(new MyTask(i,"任务"+i));
    }
    // 所有线程执行完成
    pool.shutdown();

  }
}
