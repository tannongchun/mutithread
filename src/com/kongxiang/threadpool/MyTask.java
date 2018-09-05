package com.kongxiang.threadpool;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.threadpool
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/3 23:06
 */
public class MyTask implements  Runnable {

  private Integer taskId ;
  private String taskName;

  public MyTask(Integer taskId, String taskName) {
    this.taskId = taskId;
    this.taskName = taskName;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(5*1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(" taskid =>" + this.taskId  +"  taskName=>" +this.taskName);
  }
}
