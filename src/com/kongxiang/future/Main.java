package com.kongxiang.future;

/**
 *  Future 设计模式
 */
public class Main {

    public static void main(String[] args) {
      FutureClient fc = new FutureClient();
      Data data = fc.request("请求参数");
      System.out.println("请求发送成功");
      System.out.println("做其他的事情...");
      System.out.println(Thread.currentThread().getState());
      // 依赖上一步数据 - 异步操作
      String result  =data.getRequest();
      System.out.println(result);
    }
}
