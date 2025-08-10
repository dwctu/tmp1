package com.wear.widget.draggridview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class DragGridView extends GridView implements AdapterView.OnItemLongClickListener {
    public WindowManager a;
    public WindowManager.LayoutParams b;
    public int c;
    public Vibrator d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public View k;
    public ImageView l;
    public int m;
    public int n;
    public boolean o;
    public b p;
    public int q;
    public View r;
    public int s;
    public Runnable t;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            if (DragGridView.this.j > DragGridView.this.n) {
                i = DragGridView.this.s;
                DragGridView dragGridView = DragGridView.this;
                dragGridView.postDelayed(dragGridView.t, 25L);
            } else if (DragGridView.this.j < DragGridView.this.m) {
                i = -DragGridView.this.s;
                DragGridView dragGridView2 = DragGridView.this;
                dragGridView2.postDelayed(dragGridView2.t, 25L);
            } else {
                i = 0;
            }
            DragGridView.this.k();
            DragGridView.this.smoothScrollBy(i, 10);
        }
    }

    public interface b {
        void a(int i, int i2);

        boolean b(int i);
    }

    public DragGridView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void g(Bitmap bitmap) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.b = layoutParams;
        layoutParams.gravity = 51;
        layoutParams.x = this.k.getLeft() + this.e;
        this.b.y = (this.k.getTop() + this.f) - this.c;
        WindowManager.LayoutParams layoutParams2 = this.b;
        layoutParams2.format = -3;
        layoutParams2.alpha = 0.55f;
        layoutParams2.flags = 24;
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        ImageView imageView = new ImageView(getContext());
        this.l = imageView;
        imageView.setImageBitmap(bitmap);
        this.a.addView(this.l, this.b);
    }

    public final int h(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NumberFormatException {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i != 0) {
            return i;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public final void i() {
        WindowManager.LayoutParams layoutParams = this.b;
        layoutParams.x += this.i - this.g;
        layoutParams.y += this.j - this.h;
        this.a.updateViewLayout(this.l, layoutParams);
        this.g = this.i;
        this.h = this.j;
        k();
        post(this.t);
    }

    public final void j() {
        View childAt = getChildAt(this.q - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(0);
        }
        View view = this.k;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.r;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.a.removeView(this.l);
        this.l = null;
        this.o = false;
        this.r = null;
    }

    public final void k() {
        int i;
        int iPointToPosition = pointToPosition(this.i, this.j);
        b bVar = this.p;
        if ((bVar != null && !bVar.b(iPointToPosition)) || iPointToPosition == (i = this.q) || iPointToPosition == -1) {
            return;
        }
        b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.a(i, iPointToPosition);
        }
        View view = this.r;
        if (view == null) {
            this.k.setVisibility(0);
        } else {
            view.setVisibility(0);
        }
        View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
        this.r = childAt;
        childAt.setVisibility(4);
        this.q = iPointToPosition;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar = this.p;
        if (bVar != null && !bVar.b(i)) {
            return true;
        }
        if (this.m == 0) {
            this.m = getHeight() / 4;
        }
        if (this.n == 0) {
            this.n = (getHeight() * 3) / 4;
        }
        this.k = view;
        this.q = i;
        this.d.vibrate(50L);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        g(Bitmap.createBitmap(view.getDrawingCache()));
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.k.setVisibility(4);
        this.o = true;
        return false;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.g = (int) motionEvent.getX();
            this.h = (int) motionEvent.getY();
            if (this.e == 0) {
                this.e = (int) (motionEvent.getRawX() - this.g);
            }
            if (this.f == 0) {
                this.f = (int) (motionEvent.getRawY() - this.h);
            }
        } else if (action != 1) {
            if (action == 2 && this.o && this.k != null) {
                this.i = (int) motionEvent.getX();
                this.j = (int) motionEvent.getY();
                i();
                return true;
            }
        } else if (this.o) {
            removeCallbacks(this.t);
            j();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnChangeListener(b bVar) {
        this.p = bVar;
    }

    public DragGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DragGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = 30;
        this.t = new a();
        this.a = (WindowManager) context.getSystemService("window");
        this.d = (Vibrator) context.getSystemService("vibrator");
        this.c = h(context);
        setOnItemLongClickListener(this);
    }
}
