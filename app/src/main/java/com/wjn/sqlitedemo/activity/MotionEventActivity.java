package com.wjn.sqlitedemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.TextView;

import com.dalong.marqueeview.MarqueeView;
import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.bean.Person;
import com.wjn.sqlitedemo.bean.Student;
import com.wjn.sqlitedemo.view.MarqueeText;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Locale;

public class MotionEventActivity extends AppCompatActivity {

    private MarqueeText marqueeText;
    private MarqueeView marqueeView;
    private TextView textView;
    private int lastX;
    private int lastY;
    private VelocityTracker velocityTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motionevent);


        marqueeText= (MarqueeText) findViewById(R.id.activity_motionevent_marqueetext);
        marqueeText.setText("借助 Android Things，您可以大规模构建和维护 IoT 设备。" +
                "我们最近发布了 Android Things 1.0 正式版，它将为生产设备提供长期支持，" +
                "帮助您轻松地将 IoT 设备从原型设计推进到商品化。");

        marqueeView= (MarqueeView) findViewById(R.id.tv_marquee);
        marqueeView.setText("跑马灯");
        marqueeView.setFocusable(true);
        marqueeView.requestFocus();
        marqueeView.startScroll(); //开始

        if(velocityTracker == null) {//velocityTracker对象为空 获取velocityTracker对象
            velocityTracker = VelocityTracker.obtain();
        }else {//velocityTracker对象不为空 将velocityTracker对象重置为初始状态
            velocityTracker.clear();
        }

        textView= (TextView) findViewById(R.id.activity_motionevent_textview);
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action=motionEvent.getAction();
                int x= (int) motionEvent.getRawX();
                int y= (int) motionEvent.getRawY();
                velocityTracker.addMovement(motionEvent);//向velocityTracker对象添加action
                switch(action){
                    case MotionEvent.ACTION_DOWN://按下
                        lastX=x;
                        lastY=y;
                        break;
                    case MotionEvent.ACTION_MOVE://移动
                        velocityTracker.computeCurrentVelocity(1000);
                        Log.d("TAG", "移动X velocity: " + velocityTracker.getXVelocity());
                        Log.d("TAG", "移动Y velocity: " + velocityTracker.getYVelocity());
                        break;
                    case MotionEvent.ACTION_UP://抬起
                        velocityTracker.computeCurrentVelocity(1000);
                        Log.d("TAG", "抬起X velocity: " + velocityTracker.getXVelocity());
                        Log.d("TAG", "抬起Y velocity: " + velocityTracker.getYVelocity());
                        break;
                }
                return false;
            }
        });
    }

    /**
     * Java Math类举例
     * */

    private void mathMethod(){

        /**
         * Math.sqrt()//计算平方根
         * Math.cbrt()//计算立方根
         * Math.hypot(x,y)//计算 (x的平方+y的平方)的平方根
         */

        Log.d("TAG","Math.sqrt(16)----:"+Math.sqrt(16));//4.0
        Log.d("TAG","Math.cbrt(8)----:"+Math.cbrt(8));//2.0
        Log.d("TAG","Math.hypot(3,4)----:"+Math.hypot(3,4));//5.0

        /**
         * Math.pow(a,b)//计算a的b次方
         * Math.exp(x)//计算e^x的值
         * */

        Log.d("TAG","------------------------------------------");
        Log.d("TAG","Math.pow(3,2)----:"+Math.pow(3,2));//9.0
        Log.d("TAG","Math.exp(3)----:"+Math.exp(3));//20.085536923187668

        /**
         * Math.max();//计算最大值
         * Math.min();//计算最小值
         * */

        Log.d("TAG","------------------------------------------");
        Log.d("TAG","Math.max(2.3,4.5)----:"+Math.max(7,15));//15
        Log.d("TAG","Math.min(2.3,4.5)----:"+Math.min(2.3,4.5));//2.3

        /**
         * Math.abs求绝对值
         */

        Log.d("TAG","------------------------------------------");
        Log.d("TAG","Math.abs(-10.4)----:"+Math.abs(-10.4));//10.4
        Log.d("TAG","Math.abs(10.1)----:"+Math.abs(10.1));//10.1

        /**
         * Math.ceil天花板的意思，就是返回大的值
         */

        Log.d("TAG","------------------------------------------");
        Log.d("TAG","Math.ceil(-10.1)----:"+Math.ceil(-10.1));//-10.0
        Log.d("TAG","Math.ceil(10.7)----:"+Math.ceil(10.7));//11.0
        Log.d("TAG","Math.ceil(-0.7)----:"+Math.ceil(-0.7));//-0.0
        Log.d("TAG","Math.ceil(0.0)----:"+Math.ceil(0.0));//0.0
        Log.d("TAG","Math.ceil(-0.0)----:"+Math.ceil(-0.0));//-0.0
        Log.d("TAG","Math.ceil(-1.7)----:"+Math.ceil(-1.7));//-1.0

        /**
         * Math.floor地板的意思，就是返回小的值
         */

        Log.d("TAG","------------------------------------------");
        Log.d("TAG","Math.floor(-10.1)----:"+Math.floor(-10.1));//-11.0
        Log.d("TAG","Math.floor(10.7)----:"+Math.floor(10.7));//10.0
        Log.d("TAG","Math.floor(-0.7)----:"+Math.floor(-0.7));//-1.0
        Log.d("TAG","Math.floor(0.0)----:"+Math.floor(0.0));//0.0
        Log.d("TAG","Math.floor(-0.0)----:"+Math.floor(-0.0));//-0.0

        /**
         * Math.random 取得一个大于或者等于0.0小于不等于1.0的随机数[0,1)
         */

        Log.d("TAG","------------------------------------------");
        Log.d("TAG","Math.random()----:"+Math.random());//输出[0,1)间的随机数 0.8979626325354049
        Log.d("TAG","Math.random()*100----:"+Math.random()*100);//输出[0,100)间的随机数 32.783762836248144

        /**
         * Math.rint 四舍五入
         * 返回double值
         */

        Log.d("TAG","------------------------------------------");
        Log.d("TAG","Math.rint(10.1)----:"+Math.rint(10.1));//10.0
        Log.d("TAG","Math.rint(10.7)----:"+Math.rint(10.7));//11.0
        Log.d("TAG","Math.rint(-10.5)----:"+Math.rint(-10.5));//-10.0
        Log.d("TAG","Math.rint(-10.51)----:"+Math.rint(-10.51));//-11.0
        Log.d("TAG","Math.rint(-10.2)----:"+Math.rint(-10.2));//-10.0
        Log.d("TAG","Math.rint(9)----:"+Math.rint(9));//9.0


        /**
         * Math.round 四舍五入
         * float时返回int值，double时返回long值
         */

        Log.d("TAG","------------------------------------------");
        Log.d("TAG","Math.round(10.1)----:"+Math.round(10.1));//10
        Log.d("TAG","Math.round(10.7)----:"+Math.round(10.7));//11
        Log.d("TAG","Math.round(-10.5)----:"+Math.round(-10.5));//-10
        Log.d("TAG","Math.round(-10.51)----:"+Math.round(-10.51));//-11
        Log.d("TAG","Math.round(-10.2)----:"+Math.round(-10.2));//-10
        Log.d("TAG","Math.round(9)----:"+Math.round(9));//9

        /**
         * Math.nextUp(a) 返回比a大一点点的浮点数
         * Math.nextDown(a) 返回比a小一点点的浮点数
         * Math.nextAfter(a,b) 返回(a,b)或(b,a)间与a相邻的浮点数 b可以比a小
         * */

        Log.d("TAG","------------------------------------------");
        Log.d("TAG","Math.nextUp(1.2)----:"+Math.nextUp(1.2));//1.2000000000000002
//        Log.d("TAG","Math.nextDown(1.2)----:"+Math.nextDown(1.2));//1.1999999999999997
        Log.d("TAG","Math.nextAfter(1.2, 2.7)----:"+Math.nextAfter(1.2, 2.7));//1.2000000000000002
        Log.d("TAG","Math.nextAfter(1.2, -1)----:"+Math.nextAfter(1.2, -1));//1.1999999999999997

    }

    /**
     * Java String.format举例
     * */

    private void StringFormatMethod(){
        Date date=new Date();
        //b的使用，月份简称
        String result1=String.format(Locale.US,"英文月份简称：%tb",date);
        String result2=String.format("本地月份简称：%tb%n",date);
        String result3=String.format(Locale.US,"英文月份全称：%tB",date);
        String result4=String.format("本地月份全称：%tB%n",date);
        String result5=String.format(Locale.US,"英文星期的简称：%ta",date);
        String result6=String.format("本地星期的简称：%tA%n",date);
        String result7=String.format("年的前两位数字（不足两位前面补0）：%tC%n",date);
        String result8=String.format("年的后两位数字（不足两位前面补0）：%ty%n",date);
        String result9=String.format("一年中的天数（即年的第几天）：%tj%n",date);
        String result10=String.format("两位数字的月份（不足两位前面补0）：%tm%n",date);
        String result11=String.format("两位数字的日（不足两位前面补0）：%td%n",date);
        String result12=String.format("月份的日（前面不补0）：%te",date);
        String result13=String.format("2位数字24时制的小时（不足2位前面补0）:%tH%n", date);
        String result14=String.format("2位数字12时制的小时（不足2位前面补0）:%tI%n", date);
        String result15=String.format("2位数字24时制的小时（前面不补0）:%tk%n", date);
        String result16=String.format("2位数字12时制的小时（前面不补0）:%tl%n", date);
        String result17=String.format("2位数字的分钟（不足2位前面补0）:%tM%n", date);
        String result18=String.format("2位数字的秒（不足2位前面补0）:%tS%n", date);
        String result19=String.format("3位数字的毫秒（不足3位前面补0）:%tL%n", date);
        String result20=String.format("9位数字的毫秒数（不足9位前面补0）:%tN%n", date);
        String result21=String.format(Locale.US, "小写字母的上午或下午标记(英)：%tp", date);
        String result22=String.format("小写字母的上午或下午标记（中）：%tp%n", date);
        String result23=String.format("相对于GMT的RFC822时区的偏移量:%tz%n", date);
        String result24=String.format("时区缩写字符串:%tZ%n", date);
        String result25=String.format("1970-1-1 00:00:00 到现在所经过的秒数：%ts%n", date);
        String result26=String.format("1970-1-1 00:00:00 到现在所经过的毫秒数：%tQ%n", date);


        Log.d("TAG","result1----:"+result1);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result2----:"+result2);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result3----:"+result3);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result4----:"+result4);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result5----:"+result5);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result6----:"+result6);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result7----:"+result7);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result8----:"+result8);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result9----:"+result9);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result10----:"+result10);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result11----:"+result11);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result12----:"+result12);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result13----:"+result13);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result14----:"+result14);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result15----:"+result15);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result16----:"+result16);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result17----:"+result17);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result18----:"+result18);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result19----:"+result19);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result20----:"+result20);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result21----:"+result21);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result22----:"+result22);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result23----:"+result23);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result24----:"+result24);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result25----:"+result25);
        Log.d("TAG","--------------------------------------------");
        Log.d("TAG","result26----:"+result26);
        Log.d("TAG","--------------------------------------------");
    }

    /**
     * Java 克隆使用
     * */

    private void CloneableMethod(){
        Student student=new Student();
        student.setAge("28");
        student.setName("张三");
        student.setSex("男");

        Student clonestudent=null;

        clonestudent= (Student) student.clone();

        String result1="原有对象\n姓名："+student.getName()+"\n性别："+student.getSex()+"\n年龄："+student.getAge();
        Log.d("TAG","result1----:"+result1);
        Log.d("TAG","------------------------------------------------------------------------------");
        String result2="克隆对象\n姓名："+clonestudent.getName()+"\n性别："+clonestudent.getSex()+"\n年龄："+clonestudent.getAge();
        Log.d("TAG","result2----:"+result2);

    }

    /**
     * Java 反射 获取类属性方法等信息
     * */

    public void reflectionMethod(){
        try {
            //1.利用Class.forName("类的全路径")方法获取Class对象
            Class myclass=Class.forName("com.wjn.sqlitedemo.bean.Student");

            //2.利用Method获取Student类的所有方法信息
            Method[] method=myclass.getDeclaredMethods();
            for(Method m:method){
                Log.d("TAG","类的所有方法信息："+m.toString());
            }

            Log.d("TAG","********************************************************************");

            //3.利用Field获取Student类的所有成员属性信息
            Field[] field=myclass.getDeclaredFields();
            for(Field f:field){
                Log.d("TAG","类的所有成员属性信息："+f.toString());
                System.out.println(f.toString());
            }

            Log.d("TAG","********************************************************************");

            //4.利用Constructor获取Student类的所有构造方法信息
            Constructor[] constructor=myclass.getDeclaredConstructors();
            for(Constructor c:constructor){
                Log.d("TAG","类的所有构造方法信息："+c.toString());
                System.out.println(c.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Java 反射 创建类对象
     * */

    public void reflectionMethods(){
        //1.利用Class.forName("类的全路径")方法获取Class对象
        Class myclass= null;
        try {
            myclass = Class.forName("com.wjn.sqlitedemo.bean.Student");
            //2.利用get set方法创建对象
            Student student= null;
            try {
                student = (Student) myclass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            student.setName("张三");
            student.setSex("男");
            student.setAge("27");
            Log.d("TAG","利用get set方法创建对象获取类信息："+student.toString());

            Log.d("TAG","********************************************************************");

            //3.利用构造方法创建对象
            Constructor cc = myclass.getDeclaredConstructor(String.class,String.class,String.class);
            Student student1= (Student) cc.newInstance("李四","男","29");
            Log.d("TAG","利用构造方法创建对象取类信息："+student1.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * onDestroy方法
     * */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (velocityTracker != null) {
            velocityTracker.recycle();
            velocityTracker = null;
        }
    }
}
