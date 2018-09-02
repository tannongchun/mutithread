package com.kongxiang.masterworker;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.masterworker
 * @className: DesignModel
 * @author:谭农春
 * @createTime:2018/9/2 19:30
 */
public class Task {
  private int id;
  private String name;
  private int price ;

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

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
