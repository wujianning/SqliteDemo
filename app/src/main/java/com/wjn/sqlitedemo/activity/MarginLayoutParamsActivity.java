package com.wjn.sqlitedemo.activity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.bean.Animal;
import com.wjn.sqlitedemo.bean.Animal1;
import com.wjn.sqlitedemo.bean.Animal2;
import com.wjn.sqlitedemo.bean.BaoMa;
import com.wjn.sqlitedemo.bean.BenChi;
import com.wjn.sqlitedemo.bean.Driver;
import com.wjn.sqlitedemo.bean.Factory;
import com.wjn.sqlitedemo.bean.FatherNumber;
import com.wjn.sqlitedemo.bean.Fruit;
import com.wjn.sqlitedemo.bean.FruitDiscount;
import com.wjn.sqlitedemo.bean.MyBean2;
import com.wjn.sqlitedemo.bean.MyNumber;
import com.wjn.sqlitedemo.bean.MyStudent;
import com.wjn.sqlitedemo.bean.Person;
import com.wjn.sqlitedemo.bean.SonNumber;
import com.wjn.sqlitedemo.bean.Student;
import com.wjn.sqlitedemo.bean.Workers;
import com.wjn.sqlitedemo.utils.MyComparator;
import com.wjn.sqlitedemo.utils.MyComparator2;
import com.wjn.sqlitedemo.view.ScrollerLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MarginLayoutParamsActivity extends AppCompatActivity {

    private ScrollerLayout scrollerLayout;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marginlayoutparams);

        scrollerLayout= (ScrollerLayout) findViewById(R.id.activity_marginlayout_scrollerlayout);

        scrollerLayout.removeAllViewsInLayout();
        for(int i=0;i<3;i++){
            TextView textView=new TextView(this);
            textView.setBackgroundColor(Color.RED);
            textView.setTextColor(Color.WHITE);
            textView.setClickable(true);
            ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,300);
            textView.setText("Scroller滑动Demo-"+"TextView-"+(i+1));
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(layoutParams);
            scrollerLayout.addView(textView);
        }


        initJava();

    }

    /**
     * Java基础知识
     * */

    public void initJava(){
        Factory factory=new Factory();
        factory.order(new Workers());
    }

    public void initJavassssssssssssssssssssssssssssss(){
        Driver driver1=new Driver(new BenChi());
        driver1.driverCar();

        Driver driver2=new Driver(new BaoMa());
        driver2.driverCar();
    }

    public void initJavasssssssssssssssssssssssssssss(){
//        Driver driver1=new Driver();
//        driver1.setDrive("张三");
//        driver1.setCar("奔驰车");
//
//        Driver driver2=new Driver();
//        driver2.setDrive("李四");
//        driver2.setCar("宝马车");
//
//        Driver driver3=new Driver();
//        driver3.setDrive("王五");
//        driver3.setCar("法拉利车");
//
//        driver1.drive();
//        driver2.drive();
//        driver3.drive();
    }


    public void initJavassssssssssssssssssssssssssss(){
        FatherNumber fatherNumber=new FatherNumber();
        int result1=fatherNumber.add(10,20);
        Log.d("TAG","调用父类10+20="+result1);
        SonNumber sonNumber=new SonNumber();
        int result2=sonNumber.add(10,20);
        Log.d("TAG","调用子类10+20="+result2);
        int result3=sonNumber.minus(20,10);
        Log.d("TAG","子类(20-10)+(20+10)="+result3);
    }

    public void initJavasssssssssssssssssssssssssss(){
        Student student=new Student();
        student.setAge("28");
        student.setName("张三");
        student.setSex("男");
        List<String> list=new ArrayList<>();
        list.add("詹姆斯,韦德,保罗,安东尼");
        student.setList(list);

        Student clonestudent1= (Student) student.clone();
        List<String> lists=new ArrayList<>();
        lists.add("詹姆斯,韦德");
        clonestudent1.setList(lists);

        List<String> list1=student.getList();
        int len1=list1.size();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<len1;i++){
            stringBuilder.append(list1.get(i)+",");
        }
        String result1="原有对象\n姓名："+student.getName()+"\n喜爱的球星："+stringBuilder.toString();
        Log.d("TAG","result1----:"+result1);
        Log.d("TAG","------------------------------------------------------------------------------");

        List<String> list2=clonestudent1.getList();
        int len2=list2.size();
        StringBuilder stringBuilder2=new StringBuilder();
        for(int i=0;i<len2;i++){
            stringBuilder2.append(list2.get(i)+",");
        }
        String result2="克隆对象\n姓名："+clonestudent1.getName()+"\n喜爱的球星："+stringBuilder2.toString();
        Log.d("TAG","result2----:"+result2);

    }

    public void initJavassssssssssssssssssssssssss(){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        AlertDialog alertDialog=builder.setTitle("对话框")
                .setMessage("这是一个对话框")
                .setIcon(R.mipmap.iv3)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create();
        alertDialog.show();


//        MyStudent.Builder builder=new MyStudent.Builder();
//        MyStudent myStudent=builder.name("小丽")
//                .sex("女")
//                .age("24")
//                .height("165")
//                .weight("90")
//                .build();
//        String result="姓名："+myStudent.getName()+"  性别："+myStudent.getSex()+"  年龄："+myStudent.getAge()
//                       +"  身高："+myStudent.getHeight()+"  体重："+myStudent.getWeight();
//        Log.d("TAG","result----:"+result);
    }

    public void initJavasssssssssssssssssssssssss(){
        FruitDiscount fruit1=new FruitDiscount("苹果","烟台","3.5",90);
        FruitDiscount fruit2=new FruitDiscount("葡萄","新疆","18",80);
        String result="水果："+fruit1.getName()+"  产地："+fruit1.getOrigin()
                +"  原价："+fruit1.getPrice()+"  打折后价格："+fruit1.getCurrentPrice()+"\n\n"
                      +"水果："+fruit2.getName()+"  产地："+fruit2.getOrigin()
                +"  原价："+fruit2.getPrice()+"  打折后价格："+fruit2.getCurrentPrice();
        Log.d("TAG","result----:"+result);
    }

    public void initJavassssssssssssssssssssssss(){
        Animal animal=new Animal();
        animal.eatFood("牛","草");
        animal.eatFood("羊","草");
        animal.eatFood("猪","草");
        animal.eatFood("狗","骨头");
        animal.eatFood("猫","老鼠");
    }

    public void initJavasssssssssssssssssssssss(){
        String string="{\"id\":\"14\",\"name\":\"张三\",\"sex\":\"男\"}";
        Gson gson = new Gson();
        Student student=gson.fromJson(string,Student.class);
        String id=student.getAge();
        String name=student.getName();
        String sex=student.getSex();
        Log.d("TAG","id----:"+id);
        Log.d("TAG","name----:"+name);
        Log.d("TAG","sex----:"+sex);
    }

    public void initJavassssssssssssssssssssss(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("age", "25");
        map.put("name", "张三");
        map.put("sex", "男");
        String mapJson = JSON.toJSONString(map);
        Log.d("TAG","mapJson----:"+mapJson);

        Student student1=new Student();
        student1.setAge("20");
        student1.setName("张三");
        student1.setSex("男");

        Student student2=new Student();
        student2.setAge("22");
        student2.setName("小华");
        student2.setSex("女");

        List<Student> list=new ArrayList<Student>();
        list.add(student1);
        list.add(student2);

        String listJson=JSON.toJSONString(list);
        Log.d("TAG","listJson----:"+listJson);

        Student student=new Student();
        student.setAge("20");
        student.setName("张三");
        student.setSex("男");
        String beanJson=JSON.toJSONString(student);
        Log.d("TAG","beanJson----:"+beanJson);

        String Jsonstring="{\"age\":\"20\",\"name\":\"张三\",\"sex\":\"男\"}";
        com.alibaba.fastjson.JSONObject object=JSON.parseObject(Jsonstring);
        String age=object.getString("age");
        String name=object.getString("name");
        String sex=object.getString("sex");

        Log.d("TAG","age----:"+age);
        Log.d("TAG","name----:"+name);
        Log.d("TAG","sex----:"+sex);

        String Arraystring="[{\"age\":\"20\",\"name\":\"张三\",\"sex\":\"男\"}," +
                "{\"age\":\"22\",\"name\":\"小华\",\"sex\":\"女\"}]";
        com.alibaba.fastjson.JSONArray array=JSON.parseArray(Arraystring);
        int length=array.size();
        for(int i=0;i<length;i++){
          com.alibaba.fastjson.JSONObject jsonObject=array.getJSONObject(i);
          String ages=jsonObject.getString("age");
          String names=jsonObject.getString("name");
          String sexs=jsonObject.getString("sex");
          Log.d("TAG","ages----:"+ages);
          Log.d("TAG","names----:"+names);
          Log.d("TAG","sexs----:"+sexs);
        }


        String string="{\"result\":[{\"sex\":\"男\",\"age\":\"20\",\"name\":\"张三\"}," +
                "{\"sex\":\"女\",\"age\":\"22\",\"name\":\"小华\"}," +
                "{\"sex\":\"男\",\"age\":\"25\",\"name\":\"李四\"}," +
                "{\"sex\":\"女\",\"age\":\"27\",\"name\":\"小丽\"}]" +
                ",\"school\":\"清华大学\",\"error\":false}";

        com.alibaba.fastjson.JSONObject jsonObject=JSON.parseObject(string);
        com.alibaba.fastjson.JSONArray jsonArray=jsonObject.getJSONArray("result");
        int lengths=jsonArray.size();
        for(int i=0;i<lengths;i++){
            com.alibaba.fastjson.JSONObject jsonObjects=jsonArray.getJSONObject(i);
            String sexss=jsonObjects.getString("sex");
            String agess=jsonObjects.getString("age");
            String namess=jsonObjects.getString("name");
            Log.d("TAG","sexss----:"+sexss);
            Log.d("TAG","agess----:"+agess);
            Log.d("TAG","namess----:"+namess);
        }
        String school=jsonObject.getString("school");
        Log.d("TAG","school----:"+school);
        boolean error=jsonObject.getBoolean("error");
        Log.d("TAG","error----:"+error);
    }

    public void initJavasssssssssssssssssssss(){
        //模拟数据
        Student student1=new Student();
        student1.setAge("20");
        student1.setName("张三");
        student1.setSex("男");

        Student student2=new Student();
        student2.setAge("22");
        student2.setName("小华");
        student2.setSex("女");

        Student student3=new Student();
        student3.setAge("25");
        student3.setName("李四");
        student3.setSex("男");

        Student student4=new Student();
        student4.setAge("27");
        student4.setName("小丽");
        student4.setSex("女");

        List<Student> list=new ArrayList<Student>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray=new JSONArray();

        int length=list.size();
        for(int i=0;i<length;i++){
            Student student=list.get(i);
            JSONObject object=new JSONObject();
            try {
                object.put("name", student.getName());
                object.put("age", student.getAge());
                object.put("sex", student.getSex());
                jsonArray.put(i,object);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            jsonObject.put("result", jsonArray);
            jsonObject.put("error", false);
            jsonObject.put("school", "清华大学");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String result=jsonObject.toString();
        Log.d("TAG","result----:"+result);
    }

    public void initJavassssssssssssssssssss(){
       String string="{\"result\":[{\"sex\":\"男\",\"age\":\"20\",\"name\":\"张三\"}," +
               "{\"sex\":\"女\",\"age\":\"22\",\"name\":\"小华\"}," +
               "{\"sex\":\"男\",\"age\":\"25\",\"name\":\"李四\"}," +
               "{\"sex\":\"女\",\"age\":\"27\",\"name\":\"小丽\"}]" +
               ",\"school\":\"清华大学\",\"error\":false}";

        List<Student> list=new ArrayList<Student>();
        try {
            JSONObject jsonObject=new JSONObject(string);
            //获取Object类型数据
            String school=jsonObject.getString("school");
            boolean error=jsonObject.getBoolean("error");

            Log.d("TAG","school----:"+school);
            Log.d("TAG","error----:"+error);

            //获取Array类型数据
            JSONArray jsonArray=jsonObject.getJSONArray("result");
            int length=jsonArray.length();
            for(int i=0;i<length;i++){
                Student student=new Student();
                JSONObject object=(JSONObject) jsonArray.opt(i);
                student.setName(object.getString("name"));
                student.setAge(object.getString("age"));
                student.setSex(object.getString("sex"));
                list.add(student);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //遍历集合
        Iterator<Student> iterator=list.iterator();
        while(iterator.hasNext()){
            Student student=iterator.next();
            String name=student.getName();
            String age=student.getAge();
            String sex=student.getSex();

            Log.d("TAG","name----:"+name);
            Log.d("TAG","age----:"+age);
            Log.d("TAG","sex----:"+sex);
        }
    }

    public void initJavasssssssssssssssssss(){
        int[] arr1 = { 0, 1, 2, 3, 4 };
        int[] arr2 = { 9, 9, 9, 9, 9 };

        for(int i1:arr2){
            Log.d("TAG","数组2拷贝前----："+i1);
        }

        System.arraycopy(arr1, 2, arr2, 0, 3);//从第一个数组下标2开始拷贝 拷贝到数组2 下标从0开始到3

        for(int i2:arr2){
            Log.d("TAG","数组2拷贝后----："+i2);
        }

        long num=System.currentTimeMillis();
        Log.d("TAG","当前时间毫秒数----："+num);

        String userdir = System.getProperty("user.dir");
        Log.d("TAG","userdir----:"+userdir);


        long currentTimeMillis=System.currentTimeMillis();
        Date mdate = new Date(currentTimeMillis);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result1=simpleDateFormat1.format(mdate);
        Log.d("TAG","result1----："+result1);

        String date = "2018-06-21 18:02:05";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long time2 = simpleDateFormat.parse(date).getTime();
            Log.d("TAG","time2----："+time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void initJavassssssssssssssssss(){
        String str = new String("Dear friends, welcome to China");
        StringTokenizer stoken = new StringTokenizer(str);
        for (int i = 1; stoken.hasMoreElements(); i++) {
            Log.d("TAG","第" + i + "个token:" + stoken.nextToken());
        }
    }

    public void initJavasssssssssssssssss(){
        Date date = new Date();
        Log.d("TAG","当前日期----："+date);

        Calendar calendar = Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;//[0,11]，所以要加1
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        int second=calendar.get(Calendar.SECOND);
        String result="当前日期----："+year+"年"+month+"月"+day+"日 "+hour+":"+minute+":"+second;
        Log.d("TAG",result);

        final char[] week = {'日', '一', '二', '三', '四', '五', '六'};
        int week_num = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        Log.d("TAG","今天是星期" + week[week_num]);

        Date mdate = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result1=simpleDateFormat1.format(mdate);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String result2=simpleDateFormat2.format(mdate);
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
        String result3=simpleDateFormat3.format(mdate);
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String result4=simpleDateFormat4.format(mdate);

        Log.d("TAG","result1----:"+result1);
        Log.d("TAG","result2----:"+result2);
        Log.d("TAG","result3----:"+result3);
        Log.d("TAG","result4----:"+result4);
    }

    public void initJavassssssssssssssss(){

        /**
         * 方式1
         * 0.000：三位小数 同理 0.00：两位小数 依次类推...
         * */

        double a=3.154215;
        DecimalFormat myformat=new java.text.DecimalFormat("0.000");
        String result1 = myformat.format(a);
        Log.d("TAG",a+"保留三位小数："+result1);

        /**
         * 方式2
         * #.000：三位小数 同理 #.00：两位小数
         * */

        double b=3.256321;
        DecimalFormat   df=new DecimalFormat("#.000");
        String result2=df.format(b);
        Log.d("TAG",b+"保留三位小数："+result2);

        /**
         * BigDecimal类操作保留几位小数
         * */

        double   c=3.558525;
        BigDecimal   bigDecimal=new   BigDecimal(c);
        double result3=bigDecimal.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();
        Log.d("TAG",c+"保留三位小数并四舍五入："+result3);
    }

    public void initJavasssssssssssssss(){
        BigDecimal a=new BigDecimal("4.5");
        BigDecimal b=new BigDecimal("1.5");
        BigDecimal c=new BigDecimal("2");

        BigDecimal result1=a.divide(b,2,BigDecimal.ROUND_HALF_UP);
        BigDecimal result2=a.divide(c,2,BigDecimal.ROUND_HALF_UP);
        Log.d("TAG","4.5/1.5="+result1);
        Log.d("TAG","4.5/2="+result2);
    }

    public void initJavassssssssssssss(){
        BigDecimal  a=new BigDecimal ("4.5");
        BigDecimal  b=new BigDecimal ("1.5");
        BigDecimal  c=new BigDecimal ("-10.5");

        BigDecimal  add_result=a.add(b);
        BigDecimal  subtract_result=a.subtract(b);
        BigDecimal  multiply_result=a.multiply(b);
        BigDecimal  divide_result=a.divide(b);
        BigDecimal  remainder_result=a.remainder(b);
        BigDecimal  max_result=a.max(b);
        BigDecimal  min_result=a.min(b);
        BigDecimal  abs_result=c.abs();
        BigDecimal  negate_result=a.negate();

        Log.d("TAG","4.5+1.5="+add_result);
        Log.d("TAG","4.5-1.5="+subtract_result);
        Log.d("TAG","4.5*1.5="+multiply_result);
        Log.d("TAG","4.5/1.5="+divide_result);
        Log.d("TAG","4.5/1.5余数="+remainder_result);
        Log.d("TAG","4.5和1.5最大数="+max_result);
        Log.d("TAG","4.5和1.5最小数="+min_result);
        Log.d("TAG","-10.5的绝对值="+abs_result);
        Log.d("TAG","4.5的相反数="+negate_result);

//        String string1 = new BigInteger("20", 10).toString(2);
//        Log.d("TAG","十进制的20转换成二进制是："+string1);
//
//        String string2 = new BigInteger("20", 10).toString(8);
//        Log.d("TAG","十进制的20转换成八进制是："+string2);
//
//        String string3 = new BigInteger("20", 10).toString(16);
//        Log.d("TAG","十进制的20转换成十六进制是："+string3);
//
//        String string4 = new BigInteger("110", 2).toString(10);
//        Log.d("TAG","二进制的110转换成十进制是："+string4);
//
//        String string5 = new BigInteger("110", 8).toString(10);
//        Log.d("TAG","八进制的110转换成十进制是："+string5);
//
//        String string6 = new BigInteger("110", 16).toString(10);
//        Log.d("TAG","十六进制的110转换成十进制是："+string6);
    }

    public void initJavasssssssssssss(){

        /**
         * 有参构造方法使用
         * */

        Random random=new Random(20);
        int num1=random.nextInt();
        int num2=random.nextInt(20);
        Log.d("TAG","num1----:"+num1);
        Log.d("TAG","num2----:"+num2);

        float num3=random.nextFloat();
        Log.d("TAG","num3----:"+num3);

        long num4=random.nextLong();
        Log.d("TAG","num4----:"+num4);

        double num5=random.nextDouble();
        Log.d("TAG","num5----:"+num5);

        boolean num6=random.nextBoolean();
        Log.d("TAG","num6----:"+num6);

    }

    public void initJavassssssssssss(){
        int a=10;
        Integer b=10;
        Integer c=10;
        int d=128;
        Integer e=128;
        Integer f=128;

        boolean b1=(a==b);//true
        boolean b2=(b==c);//true
        boolean b3=(d==e);//true
        boolean b4=(e==f);//false
        boolean b5=(e.equals(f));//

        float f1=12;
        Float f2=12F;
        Float f3=12f;

        long l1=12;
        Long l2=12L;
        Long l3=12l;

        Log.d("TAG","b1----:"+b1);
        Log.d("TAG","b2----:"+b2);
        Log.d("TAG","b3----:"+b3);
        Log.d("TAG","b4----:"+b4);
        Log.d("TAG","b5----:"+b5);
    }

    public void initJavasssssssssss(){
        String str="123433353334321065";
        boolean b=isPalindromeNumber(str,0,str.length()-1,str.length());
        Log.d("TAG",str+" 是否是回文："+b);
    }

    public boolean isPalindromeNumber(String string,int low,int height,int length){
        if(length==1){
            return true;
        }else{
            if(string.charAt(low)==string.charAt(height)){
                return isPalindromeNumber(string,low+1,height-1,length-2);
            }else{
                return false;
            }
        }
    }

    public void removeMethod(String s) {
        Log.d("TAG", "去重前----:" + s);
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) ==s.lastIndexOf(c)) {//此字符第一次位置和最后位置一致 即肯定没有重复的直接添加
                sb.append(c);
            } else {//同理 次字符出现过多次
                int fristposition=s.indexOf(c);//次字符第一次出现的位置
                if(fristposition==i){//第一次出现的位置和当前位置一致 即第一次出现添加
                    sb.append(c);
                }
            }
        }
        Log.d("TAG", "去重后----:" + sb.toString());
    }

    public String removeRepeatChar(String s) {
        if (s == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            sb.append(c);
            i++;
            while (i < len && s.charAt(i) == c) {//这个是如果这两个值相等，就让i+1取下一个元素
                i++;
            }
        }
        return sb.toString();
    }

    public void initJavassssssssss(){
        double result1= MyNumber.myNumber.currentvalue;
        Log.d("TAG","result1----:"+result1);

        MyNumber myNumber=new MyNumber(2.8);
        double result2=myNumber.currentvalue;
        Log.d("TAG","result2----:"+result2);
    }

    public void initJavasssssssss(){
        MyBean2 myBean21=new MyBean2(12,"张三");
        MyBean2 myBean22=new MyBean2(12,"张三");
        boolean b1=(myBean21==myBean22);
        boolean b2=myBean21.equals(myBean22);
        Log.d("TAG","b1----:"+b1);
        Log.d("TAG","b2----:"+b2);
    }



    public void initJavassssssss(){
        int a=10;
        int b=10;
        long c=10;
        float d=10;
        double e=10.00;
        boolean b1=(a==b);
        boolean b2=(a==c);
        boolean b3=(a==d);
        boolean b4=(a==e);

        String s1="abc";
        String s2=new String("abc");
        String s3="abc";
        String s4=new String("abc");
        boolean b5=(s1==s2);
        boolean b6=(s1==s3);
        boolean b7=(s1==s4);
        boolean b8=(s2==s4);
        boolean b9=(s1.equals(s2));
        boolean b10=(s1.equals(s3));
        boolean b11=(s1.equals(s4));
        boolean b12=(s2.equals(s4));

        Log.d("TAG","b1----:"+b1);
        Log.d("TAG","b2----:"+b2);
        Log.d("TAG","b3----:"+b3);
        Log.d("TAG","b4----:"+b4);
        Log.d("TAG","b5----:"+b5);
        Log.d("TAG","b6----:"+b6);
        Log.d("TAG","b7----:"+b7);
        Log.d("TAG","b8----:"+b8);
        Log.d("TAG","b9----:"+b9);
        Log.d("TAG","b10----:"+b10);
        Log.d("TAG","b11----:"+b11);
        Log.d("TAG","b12----:"+b12);
    }



    public void initJavasssssss(){
        MyBean2 myBean21=new MyBean2(12,"张三");
        MyBean2 myBean22=new MyBean2(22,"李四");
        MyBean2 myBean23=new MyBean2(8,"王五");
        MyBean2 myBean24=new MyBean2(32,"张飞");
        MyBean2 myBean25=new MyBean2(35,"关羽");
        MyBean2 myBean26=new MyBean2(5,"小米");
        MyBean2 myBean27=new MyBean2(8,"小强");
        ArrayList<MyBean2> arrayList=new ArrayList<MyBean2>();
        arrayList.add(myBean21);
        arrayList.add(myBean22);
        arrayList.add(myBean23);
        arrayList.add(myBean24);
        arrayList.add(myBean25);
        arrayList.add(myBean26);
        arrayList.add(myBean27);

        /**
         * 排序前遍历
         * */

        Iterator<MyBean2> iterator=arrayList.iterator();
        while (iterator.hasNext()){
            MyBean2 myBean2=iterator.next();
            int age=myBean2.getAge();
            String name=myBean2.getName();
            Log.d("TAG","age----："+age+"----name："+name);
        }

        /**
         * 排序
         * */

        MyComparator2 myComparator2=new MyComparator2();
        Collections.sort(arrayList,myComparator2);
        Log.d("TAG","*******************");

        /**
         * 排序后遍历
         * */

        Iterator<MyBean2> iterators=arrayList.iterator();
        while (iterators.hasNext()){
            MyBean2 myBean2=iterators.next();
            int age=myBean2.getAge();
            String name=myBean2.getName();
            Log.d("TAG","age----："+age+"----name："+name);
        }

    }

    public void initJavassssss(){
        int []arr = {10,20,30,40,50,50,50,50};
        String string=Arrays.toString(arr);
        Log.d("TAG","string----："+string);
    }

    public void initJavasssss(){
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("D");
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        Iterator<String> iterator=arrayList.iterator();
        while(iterator.hasNext()){
            Log.d("TAG",iterator.next()+"");
        }

        Log.d("TAG","***List按String.CASE_INSENSITIVE_ORDER排序(adc->abc)***");

        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);

        Iterator<String> iterators=arrayList.iterator();
        while(iterators.hasNext()){
            Log.d("TAG",iterators.next()+"");
        }

    }

    public void initJavassss(){
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("8");
        arrayList.add("1");

        Iterator<String> iterator=arrayList.iterator();
        while(iterator.hasNext()){
            Log.d("TAG",iterator.next()+"");
        }

        Log.d("TAG","********** sort方法自然排序的升序排序集合后*****************");

        Collections.sort(arrayList);

        Iterator<String> iterators=arrayList.iterator();
        while(iterators.hasNext()){
            Log.d("TAG",iterators.next()+"");
        }
    }

    public void initJavasss(){
        ArrayList<Person> arrayList=new ArrayList<Person>();
        Person person1=new Person();
        person1.setName("张三");
        person1.setAge("2018-01-02");

        Person person2=new Person();
        person2.setName("李四");
        person2.setAge("2018-02-02");

        Person person3=new Person();
        person3.setName("王五");
        person3.setAge("2018-03-02");

        Person person4=new Person();
        person4.setName("赵云");
        person4.setAge("2017-01-02");

        Person person5=new Person();
        person5.setName("关羽");
        person5.setAge("2016-01-02");

        Person person6=new Person();
        person6.setName("小强");
        person6.setAge("2018-08-02");

        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(person3);
        arrayList.add(person4);
        arrayList.add(person5);
        arrayList.add(person6);

        Iterator<Person> iterator=arrayList.iterator();
        while(iterator.hasNext()){
            Person person=iterator.next();
            String name=person.getName();
            String age=person.getAge();
            Log.d("TAG","name----:"+name+"----age----:"+age);
        }

        MyComparator myComparator=new MyComparator();
        Collections.sort(arrayList,myComparator);

        Log.d("TAG","**********排序后************");

        Iterator<Person> iterators=arrayList.iterator();
        while(iterators.hasNext()){
            Person person=iterators.next();
            String name=person.getName();
            String age=person.getAge();
            Log.d("TAG","name----:"+name+"----age----:"+age);
        }

    }

    public void initJavass(){
        List<String> list=new LinkedList<String>();
        list.add(null);
        list.add("bbbb1");
        list.add("aaaa1");
        list.add("bbbb1");
        list.add("cccc1");
        list.add("dddd1");
        list.add("dddd1");
        list.add("dddd1");
        list.add(null);

        Iterator<String> i=list.iterator();
        while(i.hasNext()){
            Log.d("TAG",i.next()+"");
        }
    }

    public void initJavas(){
        Hashtable<String, String> hashtable=new Hashtable<String,String>();
        Hashtable<String,String>allhashtable=new Hashtable<String,String>();

        /**
         * put("key","value")——>“key”“values”
         */

        hashtable.put("1", "张三1");
        hashtable.put("2", "李四1");
        hashtable.put("3", "王五1");
        hashtable.put("4", "赵六1");

        /**
         * putAll(hashtable); ——>把一个hashtable全部放到另一个hashtable中
         */

        allhashtable.putAll(hashtable);

        /**
         * get ——>根据key获取相应的values
         */

        String str=hashtable.get("2");
        String allstr=allhashtable.get("2");
        Log.d("TAG","get ——>根据key获取相应的values----str----:"+str);
        Log.d("TAG","get ——>根据key获取相应的values----allstr----:"+allstr);
        Log.d("TAG","**************************************************************************************");

        /**
         * size——>hashtable长度
         */

        int len=hashtable.size();
        int alllen=allhashtable.size();
        Log.d("TAG","size——>hashtable长度----len----:"+len);
        Log.d("TAG","size——>hashtable长度----alllen----:"+alllen);
        Log.d("TAG","**************************************************************************************");

        /**
         * containsKey(“key”)——>map中是否包含相应的key
         */

        boolean b1=hashtable.containsKey("2");
        Log.d("TAG","containsKey(“key”)——>hashtable中是否包含相应的key----b1----:"+b1);
        Log.d("TAG","**************************************************************************************");

        /**
         * containsValue(“values”)——>map中是否包含相应的values
         */

        boolean b2=hashtable.containsValue("李四");
        Log.d("TAG","containsValue(“values”)——>hashtable中是否包含相应的values----b2----:"+b2);
        Log.d("TAG","**************************************************************************************");

        /**
         * isEmpty ——>map是否为空
         */

        boolean b3=hashtable.isEmpty();
        Log.d("TAG","isEmpty ——>hashtable是否为空----b3----:"+b3);
        Log.d("TAG","**************************************************************************************");

        /**
         * hashtable迭代方法1 ——>keySet()
         *  keySet()把Map集合中的所有键都保存到一个Set类型的集合对象中返回。
         */

        Set<String> keyset=hashtable.keySet();
        Iterator<String> i1=keyset.iterator();
        while(i1.hasNext()){
            String key=i1.next();
            String value=hashtable.get(key);
            Log.d("TAG","keySet迭代key----:"+key+"----value----:"+value);
        }
        Log.d("TAG","**************************************************************************************");

        /**
         * hashtable迭代方法2 ——>values()
         * values()把所有的值存储到一个Collection集合中返回，Collection<V> values():获取集合中所有值的集合。
         * 缺点： values方法只能返回所有 的值，没有键。
         */


        Collection<String> valuecollection=hashtable.values();
        Iterator<String> i2=valuecollection.iterator();
        while(i2.hasNext()){
            String value=i2.next();
            Log.d("TAG","values迭代"+"value----:"+value);
        }
        Log.d("TAG","**************************************************************************************");

        /**
         * hashtable迭代方法3 ——>entrySet()
         * entrySet()这种方法既能够获取键又能够获取值。
         */

        Set<Map.Entry<String, String>> keyvalue=hashtable.entrySet();
        Iterator<Map.Entry<String, String>> i3=keyvalue.iterator();
        while(i3.hasNext()){
            Map.Entry<String, String> me=i3.next();
            String key=me.getKey();
            String value=me.getValue();
            Log.d("TAG","entrySet迭代key----:"+key+"----value----:"+value);
        }
        Log.d("TAG","**************************************************************************************");

        /**
         * remove ——>通过key 删除对应的values
         */

        hashtable.remove("2");//通过key 删除对应的值

        /**
         * clear ——>清空hashtable中所有元素
         */

        hashtable.clear();

    }


}
