package com.wjn.sqlitedemo.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.wjn.sqlitedemo.R;
import com.wjn.sqlitedemo.utils.AndroidtoJs;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class WebViewActivity1 extends AppCompatActivity {

    private TextView textView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        textView= (TextView) findViewById(R.id.activity_webview_textview);

        webView= (WebView) findViewById(R.id.activity_webview_webview);

        WebSettings webSettings = webView.getSettings();

        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 先加载JS代码
        webView.loadUrl("https://www.baidu.com/");

        webView.setWebViewClient(new WebViewClient(){

            /**
             * shouldInterceptRequest方法 低版本
             * */

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                Log.d("TAG","url----:"+url);
                if("https://m.baidu.com/static/index/plus/plus_logo.png".equals(url)){
                    // 步骤1:创建一个输入流
                    InputStream is = null;
                    try {
                        // 步骤2:打开需要替换的资源(存放在assets文件夹里) 在app/src/main下创建一个assets文件夹
                        // assets文件夹里再创建一个images文件夹,放一个error.png的图片
                        is =getApplicationContext().getAssets().open("images/ic_launcher.png");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // 步骤4:替换资源
                    WebResourceResponse response = new WebResourceResponse("image/png", "utf-8", is);
                    // 参数1:http请求里该图片的Content-Type,此处图片为image/png
                    // 参数2:编码类型
                    // 参数3:替换资源的输入流
                    return response;
                }
                return super.shouldInterceptRequest(view, url);
            }

            /**
             * shouldInterceptRequest方法 高版本 API21以上
             * */

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                String url=request.getUrl().toString();
                if("https://m.baidu.com/static/index/plus/plus_logo.png".equals(url)){
                    // 步骤1:创建一个输入流
                    InputStream is = null;
                    try {
                        // 步骤2:打开需要替换的资源(存放在assets文件夹里) 在app/src/main下创建一个assets文件夹 assets文件夹里再创建一个images文件夹,放一个error.png的图片
                        is =getApplicationContext().getAssets().open("images/ic_launcher.png");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // 步骤4:替换资源
                    WebResourceResponse response = new WebResourceResponse("image/png", "utf-8", is);
                    // 参数1:http请求里该图片的Content-Type,此处图片为image/png
                    // 参数2:编码类型
                    // 参数3:替换资源的输入流
                    return response;
                }
                return super.shouldInterceptRequest(view, request);
            }
        });

//        webView.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
//                result.confirm("js调用了Android的方法成功啦");
//                return super.onJsPrompt(view, url, message, defaultValue, result);
//            }
//        });


//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//
//                /**
//                 * 步骤2：根据协议的参数，判断是否是所需要的url
//                 * 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
//                 * 假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
//                 * */
//
//                Uri uri = Uri.parse(url);
//                // 如果url的协议 = 预先约定的 js 协议 就解析往下解析参数
//                if ( uri.getScheme().equals("js")) {
//                    // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议 所以拦截url,下面JS开始调用Android需要的方法
//                    if (uri.getAuthority().equals("webview")) {
//                        //  步骤3：执行JS所需要调用的逻辑
//                        Toast.makeText(WebViewActivity1.this,"js调用了Android的方法@@@@&&&&!!!",Toast.LENGTH_LONG).show();
//                        // 可以在协议上带有参数并传递到Android上
//                        Set<String> collection = uri.getQueryParameterNames();
//                        Iterator<String> iterable=collection.iterator();
//                        String value="";
//                        while(iterable.hasNext()){
//                            value=value+iterable.next()+";";
//                        }
//                        Toast.makeText(WebViewActivity1.this,value,Toast.LENGTH_LONG).show();
//                    }
//                    return true;
//                }
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//        });


//        WebSettings webSettings = webView.getSettings();
//        // 设置与Js交互的权限
//        webSettings.setJavaScriptEnabled(true);
//        // 设置允许JS弹窗
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        // 先载入JS代码
//        webView.loadUrl("file:///android_asset/javascript.html");
//
//
//        /**
//         * 由于设置了弹窗检验调用结果,所以需要支持js对话框
//         * webview只是载体，内容的渲染需要使用webviewChromClient类去实现
//         * 通过设置WebChromeClient对象处理JavaScript的对话框设置响应js 的Alert()函数
//         * */
//
//        webView.setWebChromeClient(new WebChromeClient() {
//            @Override
//            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
//                AlertDialog.Builder b = new AlertDialog.Builder(WebViewActivity1.this);
//                b.setTitle("Alert");
//                b.setMessage(message);
//                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        result.confirm();
//                    }
//                });
//                b.setCancelable(false);
//                b.create().show();
//                return true;
//            }
//
//        });
//
//
//        textView.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onClick(View v) {
////                loadUrlMethod();
//                evaluateJavascriptMethod();
//            }
//        });

    }

    /**
     * Android调用Js代码 loadUrl方法
     * */

    public void loadUrlMethod(){
        // 通过Handler发送消息
        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:callJS()");
            }
        });
    }

    /**
     * Android调用Js代码 evaluateJavascript方法
     * */

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void evaluateJavascriptMethod(){
        webView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                //此处为 js 返回的结果
                Toast.makeText(WebViewActivity1.this,value,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
