package com.kongxiang.masterworker;

import java.util.Random;

/**
 * @version 1.0
 * @description:
 *    主运行程序
 * @projectName: com.kongxiang.masterworker
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/2 20:28
 */
public class Main {
  public static  void main(String []args ){
    System.out.println("机器CPU核心数" + Runtime.getRuntime().availableProcessors() );
    // 20个线程数执行
    Master master = new Master(new Worker(), 50);
    Random random = new Random();
    Task t = null;
    for (int i = 1; i <= 100; i++) {
      t = new Task();
      t.setId(i);
      t.setName("task >>> " + i);
      t.setPrice(random.nextInt(1000));
      master.submit(t);
    }

    master.excute();
    long start = System.currentTimeMillis();
    while(true){
      // 判断任务是否完成
      if(master.isComplete()){
        long end = System.currentTimeMillis();
        int result = master.getResult();
        // 每个任务耗时0.5s  100 任务，10个线程  总共耗时 (0.5 * 100 / 10 ≈ 5.0s)
        System.out.println(" 结果是"+ result + " 耗时 " + (end- start));
        // 结束循环
        break;
      }
    }

  }
}
