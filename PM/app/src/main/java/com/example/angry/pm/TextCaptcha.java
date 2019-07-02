package com.example.angry.pm;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;

import java.io.CharArrayWriter;
import java.util.Random;

/**
 * Created by Angry on 8/16/2017.
 */

public class TextCaptcha extends Captcha{

    public TextCaptcha(int width,int height)
    {
        setWidth(width);
        setHeight(height);
        this.image=captchaImg();
    }

    @Override
    protected Bitmap captchaImg() {
        LinearGradient lg=new LinearGradient(0,0,this.width,this.height, Color.CYAN,Color.RED, Shader.TileMode.MIRROR);
        Paint p=new Paint();
        p.setDither(true);
        p.setShader(lg);
        Bitmap bitimg=Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.RGB_565);
        Canvas c = new Canvas(bitimg);
        c.drawRect(0, 0, getWidth(), getHeight(), p);
        Paint tp = new Paint();
        tp.setDither(true);
        tp.setTextSize(getWidth() / getHeight() * 20);
        Random r = new Random(System.currentTimeMillis());
        CharArrayWriter cab = new CharArrayWriter();
        char ch=' ';
        for (int i = 0; i < 8; i++) {
            ch = (char) (r.nextInt(91 - 65) + (65));
            cab.append(ch);
        }
        char[] data = cab.toCharArray();
        for (int i = 0; i < data.length; i++) {
            this.x += (30 - (3 * 8) + (Math.abs(r.nextInt()) % (65 - (1.2 * 8))));
            this.y = 50 + Math.abs(r.nextInt()) % 50;
            Canvas cc = new Canvas(bitimg);
            tp.setTextSkewX(r.nextFloat() - r.nextFloat());
            tp.setColor(Color.GREEN);
            cc.drawText(data, i, 1, this.x, this.y, tp);
            tp.setTextSkewX(0);
        }
        return bitimg;
    }
}
