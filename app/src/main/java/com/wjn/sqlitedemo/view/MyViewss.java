package com.wjn.sqlitedemo.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.wjn.sqlitedemo.R;

public class MyViewss extends View{

    private Paint mPaint1,mPaint2,mPaint3,mPaint4,mPaint5;
    private Context mContext;
    private Camera camera;
    private Matrix matrix;

    public MyViewss(Context context) {
        this(context,null);
        init();
    }

    public MyViewss(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public MyViewss(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint1 = new Paint();
        mPaint2 = new Paint();
        mPaint3 = new Paint();
        mPaint4 = new Paint();
        mPaint5 = new Paint();

        mPaint1.setColor(Color.RED);
        mPaint2.setColor(Color.BLUE);
        mPaint3.setColor(Color.BLACK);
        mPaint4.setColor(Color.YELLOW);
        mPaint5.setColor(Color.GRAY);


        mPaint1.setTextSize(30);
        mPaint2.setTextSize(30);
        mPaint3.setTextSize(30);
        mPaint4.setTextSize(30);
        mPaint5.setTextSize(30);


        mPaint1.setTypeface(Typeface.DEFAULT_BOLD);
        mPaint2.setTypeface(Typeface.MONOSPACE);
        mPaint3.setTypeface(Typeface.SANS_SERIF);
        mPaint4.setTypeface(Typeface.SERIF);
        mPaint5.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "font/FuturaCondensed.ttf"));

        camera = new Camera();
        matrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        matrix.reset();
        camera.save();
        camera.rotateX(60);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-getWidth()/2, -getHeight()/2);
        matrix.postTranslate(getWidth()/2, getHeight()/2);


        /**
         * 使用canvas.drawBitmap设置Bitmap
         * */

        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.fristshow1,option);
        option.inSampleSize = calculateInSampleSize(option, getWidth()/2, getHeight()/2);
        option.inJustDecodeBounds = false;
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.fristshow1,option), matrix, mPaint1);
    }

    /**
     * BitmapFactory.Options设置Bitmap大小
     * */

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

}
