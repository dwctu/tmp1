package com.githang.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public class IconTabPageIndicator extends LinearLayout implements PageIndicator {
    private static final CharSequence EMPTY_TITLE = "";
    private ViewPager.OnPageChangeListener mListener;
    private int mSelectedTabIndex;
    private final View.OnClickListener mTabClickListener;
    private final LinearLayout mTabLayout;
    private OnTabReselectedListener mTabReselectedListener;
    private Runnable mTabSelector;
    private int mTabWidth;
    private ViewPager mViewPager;

    public interface OnTabReselectedListener {
        void onTabReselected(int i);
    }

    public class TabView extends TextView {
        private int iconHeight;
        private int iconWidth;
        private int mIndex;

        public TabView(IconTabPageIndicator iconTabPageIndicator, Context context) {
            this(context, null, R.attr.tabView);
        }

        public int getIndex() {
            return this.mIndex;
        }

        @Override // android.widget.TextView, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (IconTabPageIndicator.this.mTabWidth > 0) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(IconTabPageIndicator.this.mTabWidth, 1073741824), i2);
            }
        }

        public void setIcon(int i) throws Resources.NotFoundException {
            if (i > 0) {
                Drawable drawable = getContext().getResources().getDrawable(i);
                int intrinsicWidth = this.iconWidth;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = drawable.getIntrinsicWidth();
                }
                int intrinsicHeight = this.iconHeight;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = drawable.getIntrinsicHeight();
                }
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                setCompoundDrawables(null, drawable, null, null);
            }
        }

        public TabView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabView, i, 0);
            this.iconWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.iconHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public IconTabPageIndicator(Context context) {
        this(context, null);
    }

    private void addTab(int i, CharSequence charSequence, int i2) throws Resources.NotFoundException {
        TabView tabView = new TabView(this, getContext());
        tabView.mIndex = i;
        tabView.setOnClickListener(this.mTabClickListener);
        tabView.setText(charSequence);
        if (i2 > 0) {
            tabView.setIcon(i2);
        }
        this.mTabLayout.addView(tabView, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    private void animateToTab(int i) {
        final View childAt = this.mTabLayout.getChildAt(i);
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.githang.viewpagerindicator.IconTabPageIndicator.2
            @Override // java.lang.Runnable
            public void run() {
                childAt.getLeft();
                int width = (IconTabPageIndicator.this.getWidth() - childAt.getWidth()) / 2;
                IconTabPageIndicator.this.mTabSelector = null;
            }
        };
        this.mTabSelector = runnable2;
        post(runnable2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.githang.viewpagerindicator.PageIndicator
    public void notifyDataSetChanged() throws Resources.NotFoundException {
        this.mTabLayout.removeAllViews();
        PagerAdapter adapter = this.mViewPager.getAdapter();
        IconPagerAdapter iconPagerAdapter = adapter instanceof IconPagerAdapter ? (IconPagerAdapter) adapter : null;
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            CharSequence pageTitle = adapter.getPageTitle(i);
            if (pageTitle == null) {
                pageTitle = EMPTY_TITLE;
            }
            addTab(i, pageTitle, iconPagerAdapter != null ? iconPagerAdapter.getIconResId(i) : 0);
        }
        if (this.mSelectedTabIndex > count) {
            this.mSelectedTabIndex = count - 1;
        }
        setCurrentItem(this.mSelectedTabIndex);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) throws Resources.NotFoundException {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        int childCount = this.mTabLayout.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.mTabWidth = -1;
        } else {
            this.mTabWidth = View.MeasureSpec.getSize(i) / childCount;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, i2);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setCurrentItem(this.mSelectedTabIndex);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) throws Resources.NotFoundException {
        setCurrentItem(i);
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
    }

    @Override // com.githang.viewpagerindicator.PageIndicator
    public void setCurrentItem(int i) throws Resources.NotFoundException {
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.mSelectedTabIndex = i;
        viewPager.setCurrentItem(i, false);
        int childCount = this.mTabLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.mTabLayout.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
            i2++;
        }
    }

    @Override // com.githang.viewpagerindicator.PageIndicator
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mListener = onPageChangeListener;
    }

    public void setOnTabReselectedListener(OnTabReselectedListener onTabReselectedListener) {
        this.mTabReselectedListener = onTabReselectedListener;
    }

    @Override // com.githang.viewpagerindicator.PageIndicator
    public void setViewPager(ViewPager viewPager) throws Resources.NotFoundException {
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.mViewPager = viewPager;
        viewPager.setOnPageChangeListener(this);
        notifyDataSetChanged();
    }

    public IconTabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabClickListener = new View.OnClickListener() { // from class: com.githang.viewpagerindicator.IconTabPageIndicator.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws Resources.NotFoundException {
                int currentItem = IconTabPageIndicator.this.mViewPager.getCurrentItem();
                int index = ((TabView) view).getIndex();
                IconTabPageIndicator.this.mViewPager.setCurrentItem(index, false);
                if (currentItem != index || IconTabPageIndicator.this.mTabReselectedListener == null) {
                    return;
                }
                IconTabPageIndicator.this.mTabReselectedListener.onTabReselected(index);
            }
        };
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.mTabLayout = linearLayout;
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.githang.viewpagerindicator.PageIndicator
    public void setViewPager(ViewPager viewPager, int i) throws Resources.NotFoundException {
        setViewPager(viewPager);
        setCurrentItem(i);
    }
}
