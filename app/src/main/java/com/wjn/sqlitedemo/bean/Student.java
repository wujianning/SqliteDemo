package com.wjn.sqlitedemo.bean;

import java.util.List;

public class Student implements Cloneable {

    private String name;
    private String sex;
    private String age;
    private List<String> list;

    public Student(){

    }

    public Student(String name,String sex,String age,List<String> list){
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.list=list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public Object clone() {
        Student student=null;
        try {
            student= (Student) super.clone();
            student.name=this.name;
            student.sex=this.sex;
            student.age=this.age;
            student.list=this.list;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
    }

    public String toString(){
        return "姓名:"+name+"  性别:"+sex+"  年龄:"+age;
    }
}
