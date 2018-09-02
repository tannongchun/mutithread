package com.kongxiang.future;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.future
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/2 10:44
 */
public class FutureData  implements  Data{

  private RealData realData ;
  private boolean isReady =false ;

  public synchronized  void setRealData(RealData realData) {
     // 如果已经加载完毕，直接退出
    if(isReady){
       return;
     }
     // 如果没有装载、则进行装载
    this.realData = realData;
    isReady = true;
    // 进行通知
    notify();
  }

  @Override
  public synchronized String getRequest() {
    while (!isReady){
      try {
        // 等待
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    //装载好直接返回数据就好
    return this.realData.getRequest();
  }
}
