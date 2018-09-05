package com.kongxiang.concurrent.future;

import java.util.concurrent.*;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.concurrent.future
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/5 20:56
 */
public class FutureTaskDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    FutureTask<String> futureTask = new FutureTask<String>(new Runner<String>("hello, world"));

    ExecutorService executorService = Executors.newFixedThreadPool(1);
      // 提交任务
    Future future = executorService.submit(futureTask);
     System.out.println(" future excute .....");
     //输出Future
    while (true){
      // null 表示执行为空
      if(null == future.get()){
        System.out.println(" future while ====> 执行完成了 " + future.get());
        break;
      }
    }
     System.out.println(" future ====> " + future.get());
    System.out.println(" futureTask ====> " + futureTask.get());
    // 关闭线程
    executorService.shutdown();
  }
}
