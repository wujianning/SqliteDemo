package com.wjn.sqlitedemo.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.provider.ContactsContract;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmsActivity extends Activity {

    private TextView textView;

    private SMSContent smsObsever;//短信观察者

    private Handler handler =new Handler(){
        public void handleMessage(android.os.Message msg) {
            Bundle bundle=msg.getData();
            String body=bundle.getString("body");
            Toast.makeText(SmsActivity.this,body,Toast.LENGTH_LONG).show();
            Log.d("TAG","body----:"+body);
        };
    };

    private TextView resulttextview;

    private List<Map<String,String>> list=new ArrayList<Map<String,String>>();
    private Uri SMS_INBOX = Uri.parse("content://sms/");

    /**获取库Phon表字段**/
    private static final String[] PHONES_PROJECTION = new String[] {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Photo.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.CONTACT_ID };
    /**联系人显示名称**/
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;
    /**电话号码**/
    private static final int PHONES_NUMBER_INDEX = 1;
    /**头像ID**/
    private static final int PHONES_PHOTO_ID_INDEX = 2;
    /**联系人的ID**/
    private static final int PHONES_CONTACT_ID_INDEX = 3;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        TelephonyManager mr  = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        mr.listen(new PhonecallListener(), PhoneStateListener.LISTEN_CALL_STATE);


//        PhoneStateListener listener = new PhoneStateListener() {
//            @Override
//            public void onCallStateChanged(int state, String number) {
//                switch (state) {
//                    // 无任何状态
//                    case TelephonyManager.CALL_STATE_IDLE:
//                        break;
//                    case TelephonyManager.CALL_STATE_OFFHOOK:
//                        break;
//                    // 来电铃响时
//                    case TelephonyManager.CALL_STATE_RINGING:
//                        //相应操作
//                        break;
//                    default:
//                        break;
//                }
//                super.onCallStateChanged(state, number);
//            }
//        };

//        mr.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);




//        StringBuilder stringBuilder=new StringBuilder();
//
//        stringBuilder.append("设备编号：" + mr.getDeviceId()+"\n\n");
//        stringBuilder.append("软件版本：" + (mr.getDeviceSoftwareVersion()!= null?mr.getDeviceSoftwareVersion():"未知")+"\n\n");
//        stringBuilder.append("运营商代号：" + mr.getNetworkOperator()+"\n\n");
//        stringBuilder.append("运营商名称：" + mr.getNetworkOperatorName()+"\n\n");
//        stringBuilder.append("网络类型：" + mr.getPhoneType()+"\n\n");
//        stringBuilder.append("设备当前位置：" + (mr.getCellLocation() != null ? mr.getCellLocation().toString() : "未知位置")+"\n\n");
//        stringBuilder.append("SIM卡的国别：" + mr.getSimCountryIso()+"\n\n");
//        stringBuilder.append("SIM卡序列号：" + mr.getSimSerialNumber()+"\n\n");
//        stringBuilder.append("SIM卡状态：" + mr.getSimState()+"\n\n");

        resulttextview= (TextView) findViewById(R.id.activity_sms_textviews);
//        getPhoneContacts();

        /**
         *111
         * */

        StringBuilder stringBuilder=new StringBuilder();

        int type=mr.getPhoneType();
        if(TelephonyManager.PHONE_TYPE_CDMA==type){//电信
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) mr.getCellLocation();
            int cid = cdmaCellLocation.getBaseStationId(); //获取cdma基站识别标号 BID
            int lac = cdmaCellLocation.getNetworkId(); //获取cdma网络编号NID
            stringBuilder.append("电信cid："+cid+"\n\n");
            stringBuilder.append("电信lac："+lac+"\n\n");
        }else if(TelephonyManager.PHONE_TYPE_GSM==type){//移动和联通
            GsmCellLocation gsmCellLocation = (GsmCellLocation) mr.getCellLocation();
            int cid = gsmCellLocation.getCid(); //获取gsm基站识别标号
            int lac = gsmCellLocation.getLac(); //获取gsm网络编号
            stringBuilder.append("移动和联通cid："+cid+"\n\n");
            stringBuilder.append("移动和联通lac："+lac+"\n\n");
        }

        /**
         * 222
         * */


        int data = mr.getDataActivity();
        switch (data) {
            case TelephonyManager.DATA_ACTIVITY_IN://正在接受数据
                stringBuilder.append("正在接受数据"+"\n\n");
                break;
            case TelephonyManager.DATA_ACTIVITY_OUT://正在发送数据
                stringBuilder.append("正在发送数据"+"\n\n");
                break;
            case TelephonyManager.DATA_ACTIVITY_INOUT://正在接受和发送数据
                stringBuilder.append("正在接受和发送数据"+"\n\n");
                break;
            case TelephonyManager.DATA_ACTIVITY_NONE:// 无数据发送和接受
                stringBuilder.append("无数据发送和接受"+"\n\n");
                break;
        }


        /**
         * 333
         * */

        String deviceID=mr.getDeviceId();
        stringBuilder.append("deviceID："+deviceID+"\n\n");

        /**
         * 444
         * */

        String version=mr.getDeviceSoftwareVersion();
        stringBuilder.append("version："+version+"\n\n");

        /**
         * 555
         * */

        String number=mr.getLine1Number();
        stringBuilder.append("number："+number+"\n\n");

        resulttextview.setText(stringBuilder.toString());

//        resulttextview.setText(stringBuilder.toString());

//        mr.listen(new MyPhoneStateListener(),290);










//        textView= (TextView) findViewById(R.id.activity_sms_textview);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Uri uri=Uri.parse("tel:"+"17710029840");
//                Intent intent=new Intent(Intent.ACTION_CALL,uri);
//                startActivity(intent);
//            }
//        });


//        smsObsever=new SMSContent(handler);//实例化短信观察者
//        //注册短信观察者
//        getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, smsObsever);



//        getSmsFromPhone();


//        String msg="这是一条短信！！！";

        /**
         * 1.获取SmsManager对象
         * */

//        SmsManager smsManager=SmsManager.getDefault();

        /**
         * 2.处理返回的发送状态
         * */

//        String SENT_SMS_ACTION = "SENT_SMS_ACTION";
//        Intent sentIntent = new Intent(SENT_SMS_ACTION);
//        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, sentIntent,  0);
//        //注册发送信息的广播接收者
//        registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context _context, Intent _intent) {
//                switch (getResultCode()) {
//                    case Activity.RESULT_OK:
//                        Toast.makeText(SmsActivity.this, "短信发送成功!", Toast.LENGTH_SHORT).show();
//                        break;
//                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:    //普通错误
//                        break;
//                    case SmsManager.RESULT_ERROR_RADIO_OFF:         //无线广播被明确地关闭
//                        break;
//                    case SmsManager.RESULT_ERROR_NULL_PDU:          //没有提供pdu
//                        break;
//                    case SmsManager.RESULT_ERROR_NO_SERVICE:         //服务当前不可用
//                        break;
//                }
//            }
//        }, new IntentFilter(SENT_SMS_ACTION));

        /**
         * 3.处理返回的接收状态
         * */

//        String DELIVERED_SMS_ACTION = "DELIVERED_SMS_ACTION";
//        //创建接收返回的接收状态的Intent
//        Intent deliverIntent = new Intent(DELIVERED_SMS_ACTION);
//        PendingIntent deliverPI = PendingIntent.getBroadcast(this, 0,deliverIntent, 0);
//        registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context _context, Intent _intent) {
//                Toast.makeText(SmsActivity.this,"收信人已经成功接收！", Toast.LENGTH_SHORT).show();
//            }
//        }, new IntentFilter(DELIVERED_SMS_ACTION));

        /**
         * 发送短信
         * */

//        //发送短信1 内容长度较短sendTextMessage方法
//        smsManager.sendTextMessage("18210160911",null,msg,sentPI,deliverPI);
//        //发送短信2 内容较长先切割短信再发送
//        List<String> divideContents = smsManager.divideMessage(msg);
//        for (String text : divideContents) {
//            smsManager.sendTextMessage("18210160911", null, text, sentPI, deliverPI);
//        }

//        Uri SMS_INBOX = Uri.parse("content://sms/");
//        getSmsFromPhone(SMS_INBOX);
    }


    /*
     * 得到手机通讯录联系人信息
     */

    private void getPhoneContacts() {
        ContentResolver resolver = getContentResolver();
        // 获取手机联系人
        Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);
        if (null != phoneCursor) {
            StringBuilder stringBuilder=new StringBuilder();
            while (phoneCursor.moveToNext()) {
                //得到手机号码
                String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
                //得到联系人名称
                String contactName = phoneCursor.getString(PHONES_DISPLAY_NAME_INDEX);
                //得到联系人ID
                Long contactid = phoneCursor.getLong(PHONES_CONTACT_ID_INDEX);
                //得到联系人头像ID 大于0 表示联系人有头像
                Long photoid = phoneCursor.getLong(PHONES_PHOTO_ID_INDEX);



                stringBuilder.append("ID："+contactid+"\n\n");
                stringBuilder.append("photoid："+photoid+"\n\n");
                stringBuilder.append("姓名："+contactName+"\n\n");
                stringBuilder.append("电话号码："+phoneNumber+"\n\n");
            }
            phoneCursor.close();

            resulttextview.setText(stringBuilder.toString());
        }
    }

    /*
    *得到手机SIM卡联系人人信息
    */
    private void getSIMContacts() {
        ContentResolver resolver = getContentResolver();
        // 获取Sims卡联系人
        Uri uri = Uri.parse("content://icc/adn");
        Cursor phoneCursor = resolver.query(uri, PHONES_PROJECTION, null, null, null);

        if (phoneCursor != null) {
            StringBuilder stringBuilder=new StringBuilder();
            while (phoneCursor.moveToNext()) {
                // 得到手机号码
                String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
                // 得到联系人名称
                String contactName = phoneCursor.getString(PHONES_DISPLAY_NAME_INDEX);
                //Sim卡中没有联系人头像
                stringBuilder.append("姓名："+contactName+"\n\n");
                stringBuilder.append("电话号码："+phoneNumber+"\n\n");
            }
            resulttextview.setText(stringBuilder.toString());
            phoneCursor.close();
        }
    }


//    public class PhonecallListener extends PhoneStateListener {
//        @Override
//        public void onCallStateChanged(int state, String incomingNumber) {
//            switch (state) {
//                case TelephonyManager.CALL_STATE_IDLE:
//                    break;
//                case TelephonyManager.CALL_STATE_OFFHOOK:
//                    break;
//                //当有电话拨入时
//                case TelephonyManager.CALL_STATE_RINGING:
//                    try {
//                        Method method = Class.forName("android.os.ServiceManager").getMethod("getService", String.class);
//                        // 获取远程TELEPHONY_SERVICE的IBinder对象的代理
//                        IBinder binder = (IBinder) method.invoke(null,new Object[]{TELEPHONY_SERVICE});
//                        // 将IBinder对象的代理转换为ITelephony对象
//                        ITelephony telephony = ITelephony.Stub.asInterface(binder);
//                        // 挂断电话
//                        telephony.endCall();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
//            }
//            super.onCallStateChanged(state, incomingNumber);
//        }
//    }




    private class MyPhoneStateListener extends PhoneStateListener {
        private int asu = 0,lastSignal = 0;
        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            asu = signalStrength.getGsmSignalStrength();
            lastSignal = -113 + 2 * asu;
            resulttextview.setText("当前手机的信号强度：" + lastSignal + " dBm" );
        }
    }



    class SMSContent extends ContentObserver {
        private Handler mHandler;
        public SMSContent(Handler handler) {
            super(handler);
            mHandler=handler;
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            Cursor cursor = null;
            String body=null;
            try {
                cursor = getContentResolver().query(
                        Uri.parse("content://sms/inbox"), null, null, null,
                        "date desc");
                if(cursor!=null){
                    if(cursor.moveToNext()){//不遍历只拿当前最新的一条短信
                        //获取当前的短信内容
                        body=cursor.getString(cursor.getColumnIndex("body"));
                        Message msg=Message.obtain();
                        Bundle bundle=new Bundle();
                        bundle.putString("body", body);
                        msg.setData(bundle);
                        mHandler.sendMessage(msg);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(cursor!=null){
                    cursor.close();
                }

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        getContentResolver().unregisterContentObserver(smsObsever);
    }

    /**
     * 获取短信内容
     * */

    public void getSmsFromPhone() {
        ContentResolver cr = getContentResolver();
        String[] projection = new String[] {"_id", "address", "person","body", "date", "type" };
        Cursor cur = cr.query(SMS_INBOX, projection, null, null, "date desc");
        if (null == cur) {
            return;
        }

        StringBuilder stringBuilder=new StringBuilder();
        while(cur.moveToNext()) {
            String _id = cur.getString(cur.getColumnIndex("_id"));//_id
            String number = cur.getString(cur.getColumnIndex("address"));//手机号
            String name = cur.getString(cur.getColumnIndex("person"));//联系人姓名列表
            String body = cur.getString(cur.getColumnIndex("body"));//短信内容
            String date = cur.getString(cur.getColumnIndex("date"));//日期
            String type = cur.getString(cur.getColumnIndex("type"));//类型
            stringBuilder.append("_id："+_id+"\n"+"手机号："+number+"\n"+"姓名："+name+"\n"+"内容："+body+"\n"+"日期："+date+"\n"+"类型："+type+"\n");
        }

        Log.d("TAG","结果："+stringBuilder.toString());

    }

}
