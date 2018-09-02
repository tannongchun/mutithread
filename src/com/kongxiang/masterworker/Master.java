package com.kongxiang.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.masterworker
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/2 19:28
 */
public class Master {
  // 1.任务容器
  private ConcurrentLinkedQueue<Task> workQueue  = new ConcurrentLinkedQueue<Task>();

  // 2.worker 容器
  private HashMap<String,Thread> workers =new HashMap<String,Thread>();

  // 3.结果容器
  private ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<String,Object>();

  // 4.构造函数
  public  Master( Worker worker,int workCount){
    // 添加引用
    // 任务的提取、任务提交
    worker.setWorkQuue(this.workQueue);
    worker.setResultMap(this.resultMap);
    //
    for(int i =0 ;i<workCount;i++ ){
      workers.put("Node"+i,new Thread(worker));
    }
  }

  // 5. 提交任务
  public void submit (Task task){
    this.workQueue.add(task);
  }

  // 6.执行任务 启动任务让所有的worker 工作
  public void excute (){
    for(Map.Entry<String,Thread> me : workers.entrySet()){
      me.getValue().start();
    }
  }
// 7.判断线程是否执行完成
  public boolean isComplete() {
    for(Map.Entry<String,Thread> me : workers.entrySet()){
       if(me.getValue().getState() != Thread.State.TERMINATED){
         return false;
       }
    }
    return  true;
  }
  // 8.返回结果集
  public int getResult() {
    int result =0 ;
    for(Map.Entry<String,Object> me : resultMap.entrySet()){
      result = result +(Integer) me.getValue();
    }
    return result ;
  }
}
