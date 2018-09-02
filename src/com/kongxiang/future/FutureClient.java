package com.kongxiang.future;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.future
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/2 10:25
 */
public class FutureClient {

  public Data request(final String  str) {
    // 1.代理对象 先返回 收到请求、可以做其他事情。
    final FutureData futureData =  new FutureData();
    // 启动一个线程
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println(" Thread is run ");
        // 3.加载真对象 耗时较长的对象
          RealData realData =new RealData(str);
          //
          futureData.setRealData(realData);
      }
    }).start();
    System.out.println(" Thread is done ");
    return  futureData;
  }
}
