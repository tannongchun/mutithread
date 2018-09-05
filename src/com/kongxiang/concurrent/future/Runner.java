package com.kongxiang.concurrent.future;

import java.util.concurrent.Callable;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.concurrent.future
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/5 20:56
 */
public class Runner<String>  implements  Callable<String> {

  private String param = null;

  public Runner(String param) {
    this.param = (String) param;
  }

  @Override
  public String call() throws Exception {
    return param;
  }

}
