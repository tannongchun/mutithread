package com.kongxiang.future;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.future
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/2 11:05
 */
public class RealData implements Data {

  private String result;

  public RealData (String str){
    System.out.println(">>>>>>>根据 " + str +" 进行查询，这是一个很耗时的操作 .......");
   try {
     Thread.sleep(5000);
   } catch (InterruptedException e) {
     e.printStackTrace();
   }
   System.out.println(" 操作完毕，获取结果");
    result = "查询结果" ;
  }

  @Override
  public String getRequest() {
    return result;
  }
}
