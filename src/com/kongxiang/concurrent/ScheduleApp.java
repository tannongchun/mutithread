package com.kongxiang.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.concurrent
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/3 22:41
 */
class Temp extends  Thread {
  @Override
  public void run(){
    System.out.println(" running......");
  }
}

public class ScheduleApp {

  public static  void main(String []args){
      Temp command = new Temp();
    ScheduledExecutorService executorService =Executors.newScheduledThreadPool(1);
    executorService.scheduleWithFixedDelay(command,1,3, TimeUnit.SECONDS);
  }

}
