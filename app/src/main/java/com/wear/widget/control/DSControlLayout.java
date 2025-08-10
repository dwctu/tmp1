package com.wear.widget.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.lovense.wear.R;
import com.wear.util.MyApplication;

/* loaded from: classes4.dex */
public class DSControlLayout extends RelativeLayout {
    public LayoutInflater a;
    public DSMultipleToyControlView b;
    public DSMultipleToyControlView c;
    public b d;
    public b e;
    public int f;
    public View g;
    public DSMultipleToySeekBarControlView h;
    public DSMultipleToySeekBarControlView i;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.Base.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public class b {
        public DSMultipleToyControlView a;
    }

    public enum c {
        Base(1),
        Right(2);

        private int index;

        c(int i) {
            this.index = i;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public interface d {
    }

    public DSControlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_multi_toy_control_ds, (ViewGroup) null);
        this.g = viewInflate;
        this.b = (DSMultipleToyControlView) viewInflate.findViewById(R.id.touchView);
        this.c = (DSMultipleToyControlView) this.g.findViewById(R.id.touchView_right);
        DSMultipleToySeekBarControlView dSMultipleToySeekBarControlView = (DSMultipleToySeekBarControlView) this.g.findViewById(R.id.top_vseekbars_layout);
        this.h = dSMultipleToySeekBarControlView;
        this.b.setVSeekBar(dSMultipleToySeekBarControlView);
        DSMultipleToySeekBarControlView dSMultipleToySeekBarControlView2 = (DSMultipleToySeekBarControlView) this.g.findViewById(R.id.bottom_vseekbars_layout);
        this.i = dSMultipleToySeekBarControlView2;
        this.c.setVSeekBar(dSMultipleToySeekBarControlView2);
        addView(this.g);
    }

    public int getBindToySize() {
        return this.f;
    }

    public int getControlType() {
        return this.b.getControlType();
    }

    public boolean getShowType() {
        return this.b.getShowType();
    }

    public void setApplication(MyApplication myApplication) {
    }

    public void setBindToySize(int i) {
        this.f = i;
    }

    public void setCallBack(d dVar, boolean z) {
    }

    public void setShowMore() {
        this.d.a.getFicView().setShowMore();
        this.e.a.getFicView().setShowMore();
    }

    public void setTapNameVisibility(int i, String str) {
        setTapNameVisibility(c.Base, i, str);
        setTapNameVisibility(c.Right, i, str);
    }

    public void setTapTimeVisibility(int i) {
        setTapTimeVisibility(c.Base, i);
        setTapTimeVisibility(c.Right, i);
    }

    public void setTapTipVisibility(int i) {
        setTapTipVisibility(c.Base, i);
        setTapTipVisibility(c.Right, i);
    }

    public void setTapNameVisibility(c cVar, int i, String str) {
        int i2 = a.a[cVar.ordinal()];
        if (i2 == 1) {
            this.b.setTapNameVisibility(i, str);
        } else {
            if (i2 != 2) {
                return;
            }
            this.c.setTapNameVisibility(i, str);
        }
    }

    public void setTapTimeVisibility(c cVar, int i) {
        int i2 = a.a[cVar.ordinal()];
    }

    public void setTapTipVisibility(c cVar, int i) {
        int i2 = a.a[cVar.ordinal()];
        if (i2 == 1) {
            this.b.setTapTipVisibility(i);
        } else {
            if (i2 != 2) {
                return;
            }
            this.c.setTapTipVisibility(i);
        }
    }
}
