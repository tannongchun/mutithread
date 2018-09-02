package com.kongxiang.providerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.providerconsumer
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/2 21:46
 */
public class Main {
  public static void main(String[] args) throws InterruptedException {
    // 声明一个容量为10的缓存队列
    BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

    Producer producer1 = new Producer(queue);
    Producer producer2 = new Producer(queue);
    Producer producer3 = new Producer(queue);
    // 三个生产者一个消费者
    Consumer consumer = new Consumer(queue);

    // 借助Executors
    ExecutorService service = Executors.newCachedThreadPool();
    // 启动线程
    service.execute(producer1);
    service.execute(producer2);
    service.execute(producer3);
    service.execute(consumer);

    // 执行10s
    Thread.sleep(10 * 1000);
    producer1.stop();
    producer2.stop();
    producer3.stop();

    Thread.sleep(2000);
    // 退出Executor
    service.shutdown();
  }
}
