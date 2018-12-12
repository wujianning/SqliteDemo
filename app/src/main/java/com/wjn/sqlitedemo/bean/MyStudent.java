package com.wjn.sqlitedemo.bean;

public class MyStudent {

    private String name;
    private String sex;
    private String age;
    private String height;
    private String weight;

    public MyStudent(Builder builder){
        this.name=builder.name;
        this.sex=builder.sex;
        this.age=builder.age;
        this.height=builder.height;
        this.weight=builder.weight;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public static class Builder{
        private String name;
        private String sex;
        private String age;
        private String height;
        private String weight;

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder sex(String sex){
            this.sex=sex;
            return this;
        }

        public Builder age(String age){
            this.age=age;
            return this;
        }

        public Builder height(String height){
            this.height=height;
            return this;
        }

        public Builder weight(String weight){
            this.weight=weight;
            return this;
        }

        public MyStudent build() {
            return new MyStudent(this);
        }

    }

}
