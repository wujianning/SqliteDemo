package com.wjn.sqlitedemo.bean;

import java.text.DecimalFormat;

public class FruitDiscount extends Fruit{

    private String name;
    private String origin;
    private String price;
    private float discount;

    public FruitDiscount(String name, String origin, String price,float discount){
        super(name, origin, price);
        this.name=name;
        this.origin=origin;
        this.price=price;
        this.discount=discount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOrigin() {
        return origin;
    }

    @Override
    public String getPrice() {
        return price;
    }

    public String getCurrentPrice(){
        String result=price;
        if(null!=price){
            //判断价格字符串是否是数字
            boolean b=isNumber(price);
            if(b){
                double p=Double.parseDouble(price);
                if(discount>=10&&discount<=100){
                    double d=p*(discount/100);
                    DecimalFormat myformat=new java.text.DecimalFormat("0.00");
                    result = myformat.format(d);
                }
            }
        }
        return result;
    }

    /**
     * 判断字符串是否是纯数字
     * */

    public boolean isNumber(String str){
        return str.matches("^[0.0-9.0]+$");
    }

}
