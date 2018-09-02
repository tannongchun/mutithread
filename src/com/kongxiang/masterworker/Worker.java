package com.kongxiang.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @version 1.0
 * @description:
 *    具体任务处理器
 * @projectName: com.kongxiang.masterworker
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/2 19:38
 */
public class Worker implements  Runnable{
  //
  private  ConcurrentLinkedQueue<Task> workQuue;
  private ConcurrentHashMap<String,Object> resultMap;

  @Override
  public void run() {
    while(true){
       Task input = workQuue.poll();
      if(input == null) {
        break;
      }
     Object output=  handle(input);
      // 存放结果集里面
     this.resultMap.put(String.valueOf(input.getId()),output);
    }

  }
  // 处理具体耗时业务
  private Object handle(Task input) {
    Object result =null;
    try {
      Thread.sleep(500);
      result = input.getPrice();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return  result;
  }

  public void setWorkQuue(ConcurrentLinkedQueue<Task> workQuue) {
    this.workQuue = workQuue;
  }

  public void setResultMap(ConcurrentHashMap<String,Object> resultMap) {
    this.resultMap = resultMap;
  }
}
