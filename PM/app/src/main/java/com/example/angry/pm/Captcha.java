package com.example.angry.pm;

import android.graphics.Bitmap;

/**
 * Created by Angry on 8/16/2017.
 */

public abstract class Captcha {
    protected Bitmap image;
    protected  int width,height,x,y;
    protected abstract Bitmap captchaImg();

    protected int getWidth()
    {
        return this.width;
    }
    protected int getHeight()
    {
        return this.height;
    }
    protected Bitmap getImage()
    {
        return this.image;
    }
    protected void setWidth(int width)
    {
        if(width>50 && width<500)
        {
            this.width=width;
        }
        else
        {
            this.width=100;
        }
    }
    protected void setHeight(int height)
    {
        if(height>50 && height<500)
        {
            this.height=height;
        }
        else
        {
            this.height=100;
        }
    }
}
