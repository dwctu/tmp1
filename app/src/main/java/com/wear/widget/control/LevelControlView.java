package com.wear.widget.control;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.gg3;
import dc.rq1;
import java.util.HashMap;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes4.dex */
public class LevelControlView extends RelativeLayout implements View.OnTouchListener {
    public static int[] v = {5, 12, 20};
    public MyApplication a;
    public int b;
    public LayoutInflater c;
    public RelativeLayout d;
    public FingerLineView e;
    public Button f;
    public Button g;
    public Button h;
    public RelativeLayout i;
    public int j;
    public int k;
    public int[] l;
    public int m;
    public HashMap<Integer, Integer> n;
    public boolean o;
    public String p;
    public String q;
    public int[] r;
    public int s;
    public int t;
    public boolean u;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            LevelControlView.this.a.G().W(0);
            LevelControlView levelControlView = LevelControlView.this;
            levelControlView.e.b = -1.0f;
            levelControlView.m = -1;
            LevelControlView.this.e.invalidate();
            LevelControlView.this.o(null);
            return true;
        }
    }

    public class b extends Handler {
        public b(LevelControlView levelControlView) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
        }
    }

    public LevelControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.j = 0;
        this.l = new int[2];
        this.m = -1;
        this.n = new HashMap<>();
        this.o = false;
        this.p = "";
        this.q = "";
        this.r = new int[]{0, 0, 0};
        this.s = -1;
        this.t = 0;
        this.u = false;
        this.c = (LayoutInflater) context.getSystemService("layout_inflater");
        h();
        RelativeLayout relativeLayout = (RelativeLayout) this.c.inflate(R.layout.level_control, (ViewGroup) null);
        this.d = relativeLayout;
        this.i = (RelativeLayout) relativeLayout.findViewById(R.id.fingerViewGroup);
        this.e = (FingerLineView) this.d.findViewById(R.id.fingerLineView);
        this.f = (Button) this.d.findViewById(R.id.program_level_1);
        this.g = (Button) this.d.findViewById(R.id.program_level_2);
        this.h = (Button) this.d.findViewById(R.id.program_level_3);
        this.f.setOnTouchListener(this);
        this.g.setOnTouchListener(this);
        this.h.setOnTouchListener(this);
        this.e.setOnTouchListener(new a());
        addView(this.d);
    }

    public static String f(Toy toy) {
        int[] programDefaultLevel = v;
        if (toy != null) {
            programDefaultLevel = toy.getProgramDefaultLevel();
        }
        return programDefaultLevel[0] + "," + programDefaultLevel[1] + "," + programDefaultLevel[2] + ";";
    }

    public static String m(Toy toy) {
        HashMap map = new HashMap();
        if (toy != null) {
            int[] programDefaultLevel = toy.getProgramDefaultLevel();
            int i = 0;
            while (i < 3) {
                int i2 = i + 1;
                map.put(Integer.valueOf(i2), Integer.valueOf(programDefaultLevel[i]));
                i = i2;
            }
        }
        String str = "";
        for (Object obj : map.keySet()) {
            str = str + "SetLevel:" + obj.toString() + SignatureImpl.INNER_SEP + map.get(obj).toString() + ";#";
        }
        return str;
    }

    public void d(View view, int i, boolean z) {
        int height = (int) (view.getHeight() * 0.58f);
        int height2 = this.i.getHeight() - ((int) (view.getHeight() * 0.58f));
        this.t = i;
        this.u = false;
        int i2 = (height2 - height) / 20;
        if (i < height) {
            height2 = height;
        } else if (i <= height2) {
            height2 = i;
        }
        int i3 = 20 - ((height2 - height) / i2);
        if (i3 >= 0 && i3 < 3 && i < this.i.getHeight()) {
            this.u = true;
        }
        switch (view.getId()) {
            case R.id.program_level_1 /* 2131364143 */:
                n(1, i3, this.u, z);
                break;
            case R.id.program_level_2 /* 2131364144 */:
                n(2, i3, this.u, z);
                break;
            case R.id.program_level_3 /* 2131364145 */:
                n(3, i3, this.u, z);
                break;
        }
    }

    public final int e(int i, int i2) {
        if (i < 0 || i > 20) {
            return getMeasuredHeight() - i2;
        }
        int i3 = i2 / 2;
        return (((20 - i) * (((this.i.getHeight() - i3) - i3) / 20)) + i3) - i3;
    }

    public final int g(View view) {
        switch (view.getId()) {
            case R.id.program_level_1 /* 2131364143 */:
                return 1;
            case R.id.program_level_2 /* 2131364144 */:
                return 2;
            case R.id.program_level_3 /* 2131364145 */:
                return 3;
            default:
                return 0;
        }
    }

    public String getLevelCommandStrings() {
        String str = "";
        for (Integer num : this.n.keySet()) {
            Integer num2 = this.n.get(num);
            str = str + "SetLevel:" + num.toString() + SignatureImpl.INNER_SEP + num2.toString() + ";#";
            this.r[Integer.valueOf(num.toString()).intValue() - 1] = Integer.valueOf(num2.toString()).intValue();
        }
        return str;
    }

    public final void h() {
        new b(this);
    }

    public void i() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        int[] iArr = this.r;
        int measuredHeight = iArr[0] == 0 ? getMeasuredHeight() - layoutParams.height : e(iArr[0], layoutParams.height);
        layoutParams.leftMargin = (this.b / 5) - (layoutParams.width / 2);
        layoutParams.topMargin = Integer.valueOf(measuredHeight).intValue();
        layoutParams.bottomMargin = -Integer.valueOf(measuredHeight).intValue();
        this.f.setLayoutParams(layoutParams);
        d(this.f, layoutParams.topMargin + (layoutParams.height / 2), true);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        int[] iArr2 = this.r;
        int measuredHeight2 = iArr2[1] == 0 ? getMeasuredHeight() - layoutParams2.height : e(iArr2[1], layoutParams2.height);
        layoutParams2.leftMargin = (this.b / 2) - (layoutParams2.width / 2);
        layoutParams2.topMargin = Integer.valueOf(measuredHeight2).intValue();
        layoutParams2.bottomMargin = -Integer.valueOf(measuredHeight2).intValue();
        this.g.setLayoutParams(layoutParams2);
        d(this.g, layoutParams2.topMargin + (layoutParams2.height / 2), true);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        int[] iArr3 = this.r;
        int measuredHeight3 = iArr3[2] == 0 ? getMeasuredHeight() - layoutParams3.height : e(iArr3[2], layoutParams3.height);
        layoutParams3.leftMargin = ((this.b * 4) / 5) - (layoutParams3.width / 2);
        layoutParams3.topMargin = Integer.valueOf(measuredHeight3).intValue();
        layoutParams3.bottomMargin = -Integer.valueOf(measuredHeight3).intValue();
        this.h.setLayoutParams(layoutParams3);
        d(this.h, layoutParams3.topMargin + (layoutParams3.height / 2), true);
        this.j = layoutParams.height;
    }

    public boolean j() {
        return this.o;
    }

    public void k(MyApplication myApplication, String str, String str2) {
        this.a = myApplication;
        this.b = gg3.e(MyApplication.H());
        this.p = str;
        Toy toyQ = myApplication.G().Q(this.q);
        this.q = toyQ == null ? "" : toyQ.getAddress();
        if (WearUtils.e1(str2)) {
            return;
        }
        String[] strArrSplit = str2.split(",");
        if (strArrSplit.length == 3) {
            int i = 0;
            for (String str3 : strArrSplit) {
                this.r[i] = Integer.valueOf(str3.replace(";", "")).intValue();
                i++;
            }
        }
    }

    public String l(Toy toy) {
        if (toy != null) {
            int[] programDefaultLevel = toy.getProgramDefaultLevel();
            int i = 0;
            while (i < 3) {
                int i2 = i + 1;
                this.n.put(Integer.valueOf(i2), Integer.valueOf(programDefaultLevel[i]));
                this.r[i] = programDefaultLevel[i];
                i = i2;
            }
        }
        return getLevelCommandStrings();
    }

    public void n(int i, int i2, boolean z, boolean z2) {
        if (this.n.get(Integer.valueOf(i)) == null || this.n.get(Integer.valueOf(i)).intValue() != i2 || this.s == -1) {
            this.s = i;
            if (!z2) {
                rq1.d.m(this.p, i2);
            }
        }
        this.n.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void o(View view) {
        if (view != null) {
            this.o = true;
            Button button = this.f;
            if (button == view) {
                button.setBackgroundResource(R.drawable.content_button_level1_blue);
                this.g.setBackgroundResource(R.drawable.content_button_level2_pink);
                this.h.setBackgroundResource(R.drawable.content_button_level3_pink);
            } else if (this.g == view) {
                button.setBackgroundResource(R.drawable.content_button_level1_pink);
                this.g.setBackgroundResource(R.drawable.content_button_level2_blue);
                this.h.setBackgroundResource(R.drawable.content_button_level3_pink);
            } else if (this.h == view) {
                button.setBackgroundResource(R.drawable.content_button_level1_pink);
                this.g.setBackgroundResource(R.drawable.content_button_level2_pink);
                this.h.setBackgroundResource(R.drawable.content_button_level3_blue);
            }
        } else {
            this.f.setBackgroundResource(R.drawable.content_button_level1_pink);
            this.g.setBackgroundResource(R.drawable.content_button_level2_pink);
            this.h.setBackgroundResource(R.drawable.content_button_level3_pink);
        }
        this.s = -1;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int[] iArr = this.l;
        if (iArr[1] < 1) {
            this.i.getLocationOnScreen(iArr);
        }
        int[] iArr2 = this.l;
        if (rawY > iArr2[1] && rawY < iArr2[1] + this.i.getHeight()) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.m = g(view);
                o(view);
                this.k = rawY - ((RelativeLayout.LayoutParams) view.getLayoutParams()).topMargin;
                if (view.getId() != R.id.program_level_1 && view.getId() == R.id.program_level_2) {
                    this.e.setColor4(getResources().getColor(R.color.text_secondary_light));
                } else {
                    this.e.setColor4(getResources().getColor(R.color.text_secondary_light));
                }
            } else if (action == 2 && this.m == g(view)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                int i = this.k;
                if (rawY - i < 0 || rawY - i >= getHeight() - this.j) {
                    return true;
                }
                layoutParams.topMargin = rawY - this.k;
                layoutParams.rightMargin = -249;
                layoutParams.bottomMargin = -249;
                view.setLayoutParams(layoutParams);
                FingerLineView fingerLineView = this.e;
                int i2 = layoutParams.topMargin;
                int i3 = layoutParams.height;
                fingerLineView.b = (i3 / 2) + i2;
                d(view, i2 + (i3 / 2), false);
            }
            this.i.invalidate();
            this.e.invalidate();
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            i();
        }
    }
}
