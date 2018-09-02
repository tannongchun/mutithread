package com.kongxiang.providerconsumer;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.providerconsumer
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/2 21:31
 */
public class Data {
  private int  id ;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  @Override
  public  String toString(){
  return "{ id => " + id +"; name =>" + name+" }";
}
}
