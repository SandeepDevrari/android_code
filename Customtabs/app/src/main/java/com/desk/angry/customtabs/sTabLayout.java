package com.desk.angry.customtabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.TooltipCompat;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class sTabLayout extends HorizontalScrollView {

    private final TabIndicator tabIndicator;

    public sTabLayout(Context context) {
        this(context,null);
    }

    public sTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public sTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setHorizontalScrollBarEnabled(false);
        tabIndicator = new TabIndicator(context);
        super.addView(tabIndicator, 0, new HorizontalScrollView.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));
    }
    class sTabView extends LinearLayout{
        public sTabView(Context context) {
            super(context);
        }

    }

    public static final class Tab {

        public static final int INVALID_POSITION = -1;

        private Object mTag;
        private Drawable mIcon;
        private CharSequence mText;
        private CharSequence mContentDesc;
        private int mPosition = INVALID_POSITION;
        private View mCustomView;

        sTabLayout mParent;
        TabView mView;

        Tab() {
            // Private constructor
        }

        @Nullable
        public Object getTag() {
            return mTag;
        }

        @NonNull
        public Tab setTag(@Nullable Object tag) {
            mTag = tag;
            return this;
        }


        @Nullable
        public View getCustomView() {
            return mCustomView;
        }

        @NonNull
        public Tab setCustomView(@Nullable View view) {
            mCustomView = view;
            updateView();
            return this;
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int resId) {
            final LayoutInflater inflater = LayoutInflater.from(mView.getContext());
            return setCustomView(inflater.inflate(resId, mView, false));
        }


        @Nullable
        public Drawable getIcon() {
            return mIcon;
        }


        public int getPosition() {
            return mPosition;
        }

        void setPosition(int position) {
            mPosition = position;
        }


        @Nullable
        public CharSequence getText() {
            return mText;
        }


        @NonNull
        public Tab setIcon(@Nullable Drawable icon) {
            mIcon = icon;
            updateView();
            return this;
        }


        @NonNull
        public Tab setIcon(@DrawableRes int resId) {
            if (mParent == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return setIcon(AppCompatResources.getDrawable(mParent.getContext(), resId));
        }


        @NonNull
        public Tab setText(@Nullable CharSequence text) {
            mText = text;
            updateView();
            return this;
        }


        @NonNull
        public Tab setText(@StringRes int resId) {
            if (mParent == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return setText(mParent.getResources().getText(resId));
        }

        @NonNull
        public Tab setContentDescription(@StringRes int resId) {
            if (mParent == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return setContentDescription(mParent.getResources().getText(resId));
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence contentDesc) {
            mContentDesc = contentDesc;
            updateView();
            return this;
        }

        @Nullable
        public CharSequence getContentDescription() {
            return mContentDesc;
        }

        void updateView() {
            if (mView != null) {
                //mView.update();
            }
        }

    }

    class TabView extends LinearLayout {
        private Tab mTab;
        private TextView mTextView;
        private ImageView mIconView;

        private View mCustomView;
        private TextView mCustomTextView;
        private ImageView mCustomIconView;

        private int mDefaultMaxLines = 2;

        public TabView(Context context) {
            super(context);
            ViewCompat.setPaddingRelative(this, mTabPaddingStart, mTabPaddingTop,
                    mTabPaddingEnd, mTabPaddingBottom);
            setGravity(Gravity.CENTER);
            setOrientation(VERTICAL);
            setClickable(true);
            ViewCompat.setPointerIcon(this,
                    PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        }

        void setTab(@Nullable final Tab tab) {
            if (tab != mTab) {
                mTab = tab;
            }
        }



        public Tab getTab() {
            return mTab;
        }

        /**
         * Approximates a given lines width with the new provided text size.
         */
        private float approximateLineWidth(Layout layout, int line, float textSize) {
            return layout.getLineWidth(line) * (textSize / layout.getPaint().getTextSize());
        }
    }
    private class TabIndicator extends LinearLayout{
        private final Paint mSelectedIndicatorPaint;
        private int mSelectedIndicatorHeight;
        int mSelectedPosition = -1;
        float mSelectionOffset;

        private int mLayoutDirection = -1;

        private int mIndicatorLeft = -1;
        private int mIndicatorRight = -1;

        private ValueAnimator mIndicatorAnimator;
        public TabIndicator(Context context) {
            super(context);
            setWillNotDraw(false);
            mSelectedIndicatorPaint = new Paint();
            mSelectedIndicatorPaint.setStrokeCap(Paint.Cap.ROUND);
        }

        @Override
        public void draw(Canvas canvas) {
            super.draw(canvas);

            // Thick colored underline below the current selection
            if (mIndicatorLeft >= 0 && mIndicatorRight > mIndicatorLeft) {
                canvas.drawRect(mIndicatorLeft, getHeight() - mSelectedIndicatorHeight,
                        mIndicatorRight, getHeight(), mSelectedIndicatorPaint);
            }
        }
    }
}
