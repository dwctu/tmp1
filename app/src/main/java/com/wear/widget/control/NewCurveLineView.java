package com.wear.widget.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHead;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.ek2;
import dc.xo3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes4.dex */
public class NewCurveLineView extends View {
    public static float l = 0.8f;
    public int a;
    public float b;
    public float c;
    public int d;
    public boolean e;
    public List<xo3> f;
    public int g;
    public int h;
    public int[] i;
    public float j;
    public List<String> k;

    public NewCurveLineView(Context context) {
        super(context);
        this.a = 20;
        this.d = 0;
        this.e = false;
        this.f = new ArrayList();
        this.h = ek2.SPEED.ordinal();
        this.i = new int[]{getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.curve_line), getResources().getColor(R.color.color_accent_second)};
        this.j = 0.0f;
        c(context);
    }

    public synchronized void a(int i, Pattern pattern, String[] strArr) {
        if (pattern != null && strArr != null) {
            if (strArr.length != 0) {
                if (i == 0) {
                    b();
                    if (pattern.getHead() == null) {
                        for (int i2 = 0; i2 < Math.min(this.a, strArr.length - 1); i2++) {
                            setFirstLinePointTemp(WearUtils.q1(strArr[i2]) ? 101.0f - Float.parseFloat(strArr[i2]) : 0.0f);
                        }
                    } else {
                        for (int i3 = 0; i3 < Math.min(this.a, strArr.length - 1); i3++) {
                            List<String> listCreateCommands = pattern.getHead().createCommands(strArr[i3]);
                            if (listCreateCommands.size() > 0) {
                                String str = listCreateCommands.get(listCreateCommands.size() - 1);
                                if (str.split(",").length <= 2 || !pattern.getHead().isAllFunc()) {
                                    setBothLinePointTemp(str);
                                } else {
                                    setBothLinePointTemp(str.split(",")[0]);
                                }
                            } else {
                                setBothLinePointTemp("0");
                            }
                        }
                    }
                    return;
                }
                if (i >= this.a * l) {
                    if (this.f.size() == 0) {
                        return;
                    }
                    if (this.f.get(0).b.size() < this.a) {
                        for (xo3 xo3Var : this.f) {
                            xo3Var.b.clear();
                            xo3Var.b.addAll(xo3Var.a);
                        }
                        int size = this.a - this.f.get(0).b.size();
                        for (int i4 = 1; i4 <= size; i4++) {
                            int i5 = i4 + i;
                            if (i5 <= strArr.length - 1) {
                                if (pattern.getHead() == null) {
                                    setFirstLinePointTemp(WearUtils.q1(strArr[i5]) ? 101.0f - Float.parseFloat(strArr[i5]) : 0.0f);
                                } else {
                                    List<String> listCreateCommands2 = pattern.getHead().createCommands(strArr[i5]);
                                    if (listCreateCommands2.size() > 0) {
                                        String str2 = listCreateCommands2.get(listCreateCommands2.size() - 1);
                                        if (str2.split(",").length <= 2 || !pattern.getHead().isAllFunc()) {
                                            setBothLinePointTemp(str2);
                                        } else {
                                            setBothLinePointTemp(str2.split(",")[0]);
                                        }
                                    } else {
                                        setBothLinePointTemp("0");
                                    }
                                }
                            }
                        }
                    }
                    int i6 = i + ((int) (this.a * (1.0f - l))) + 1;
                    if (i6 > strArr.length - 1) {
                        e();
                    } else if (pattern.getHead() == null) {
                        setFirstLinePointTemp(WearUtils.q1(strArr[i6]) ? 101.0f - Float.parseFloat(strArr[i6]) : 0.0f);
                    } else {
                        List<String> listCreateCommands3 = pattern.getHead().createCommands(strArr[i6]);
                        if (listCreateCommands3.size() > 0) {
                            String str3 = listCreateCommands3.get(listCreateCommands3.size() - 1);
                            if (str3.split(",").length <= 2 || !pattern.getHead().isAllFunc()) {
                                setBothLinePointTemp(str3);
                            } else {
                                setBothLinePointTemp(str3.split(",")[0]);
                            }
                        } else {
                            setBothLinePointTemp("0");
                        }
                    }
                }
            }
        }
    }

    public synchronized void b() {
        for (xo3 xo3Var : this.f) {
            xo3Var.a.clear();
            xo3Var.b.clear();
        }
        postInvalidate();
    }

    public final void c(Context context) {
        d(context);
    }

    public void d(Context context) {
        List<xo3> list = this.f;
        if (list != null && list.size() > 0) {
            this.f.clear();
        }
        this.g = ce3.a(context, 1.5f);
        this.d = ce3.a(context, 5.0f);
        for (int i : this.i) {
            if (this.h == ek2.POSITION.ordinal()) {
                this.f.add(new xo3(this.g, getResources().getColor(R.color.color_accent_second), getResources().getColor(R.color.text_secondary_light)));
            } else {
                this.f.add(new xo3(this.g, i, getResources().getColor(R.color.text_secondary_light)));
            }
        }
    }

    public synchronized void e() {
        for (xo3 xo3Var : this.f) {
            if (xo3Var.b.size() > 0) {
                xo3Var.b.remove(0);
            }
        }
    }

    public void f() {
        if (this.a != 20) {
            this.a = 20;
            for (xo3 xo3Var : this.f) {
                xo3Var.a.clear();
                xo3Var.b.clear();
            }
        }
    }

    public final void g(Path path, float f, float f2, float f3, float f4) {
        if (this.h == ek2.SPEED.ordinal()) {
            float f5 = (f + f3) / 2.0f;
            path.cubicTo(f5, f2, f5, f4, f3, f4);
        } else {
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b = getMeasuredWidth() / ((this.a - 1) * 1.0f);
        int measuredHeight = getMeasuredHeight();
        int i = this.d;
        this.c = (measuredHeight - i) / 100.0f;
        for (xo3 xo3Var : this.f) {
            xo3Var.e.reset();
            float f = 0.0f;
            float fFloatValue = 0.0f;
            for (int i2 = 0; i2 < xo3Var.a.size(); i2++) {
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    float f2 = i3 * this.b;
                    float fFloatValue2 = xo3Var.a.get(i3).floatValue() * this.c;
                    float f3 = i;
                    float f4 = fFloatValue2 <= f3 ? f3 : fFloatValue2;
                    float f5 = this.b * i2;
                    float fFloatValue3 = xo3Var.a.get(i2).floatValue() * this.c;
                    float f6 = fFloatValue3 <= f3 ? f3 : fFloatValue3;
                    g(xo3Var.e, f2, f4, f5, f6);
                    f = f5;
                    fFloatValue = f6;
                } else {
                    fFloatValue = xo3Var.a.get(0).floatValue() * this.c;
                    float f7 = i;
                    if (fFloatValue <= f7) {
                        fFloatValue = f7;
                    }
                    xo3Var.e.moveTo(0.0f, fFloatValue);
                }
            }
            if (!xo3Var.e.isEmpty()) {
                xo3Var.c.setStyle(Paint.Style.STROKE);
                canvas.drawPath(xo3Var.e, xo3Var.c);
                if (xo3Var.b.size() > 0) {
                    xo3Var.c.setStyle(Paint.Style.FILL);
                    int i4 = this.d;
                    canvas.drawCircle(f - i4, fFloatValue, i4, xo3Var.c);
                }
            }
            xo3Var.e.reset();
            if (xo3Var.a.size() > 0) {
                float size = this.b * (xo3Var.a.size() - 1);
                LinkedList<Float> linkedList = xo3Var.a;
                float fFloatValue4 = linkedList.get(linkedList.size() - 1).floatValue() * this.c;
                float f8 = i;
                if (fFloatValue4 <= f8) {
                    fFloatValue4 = f8;
                }
                xo3Var.e.moveTo(size, fFloatValue4);
            } else if (xo3Var.b.size() != 0) {
                float fFloatValue5 = xo3Var.b.get(0).floatValue() * this.c;
                float f9 = i;
                if (fFloatValue5 <= f9) {
                    fFloatValue5 = f9;
                }
                xo3Var.e.moveTo(0.0f, fFloatValue5);
            }
            for (int size2 = xo3Var.a.size(); size2 < xo3Var.b.size(); size2++) {
                if (size2 >= 1) {
                    int i5 = size2 - 1;
                    float f10 = i5 * this.b;
                    float fFloatValue6 = xo3Var.b.get(i5).floatValue() * this.c;
                    float f11 = i;
                    float f12 = fFloatValue6 <= f11 ? f11 : fFloatValue6;
                    float f13 = size2 * this.b;
                    float fFloatValue7 = xo3Var.b.get(size2).floatValue() * this.c;
                    g(xo3Var.e, f10, f12, f13, fFloatValue7 <= f11 ? f11 : fFloatValue7);
                }
            }
            if (!xo3Var.e.isEmpty()) {
                canvas.drawPath(xo3Var.e, xo3Var.d);
            }
        }
    }

    public synchronized void setBothLinePoint(String str) {
        setBothLinePoint(str, true, (int) (this.a * l));
    }

    public synchronized void setBothLinePointTemp(String str) {
        if (!WearUtils.e1(str)) {
            String[] strArrSplit = str.split(",");
            for (int i = 0; i < strArrSplit.length && i < this.f.size(); i++) {
                if (WearUtils.q1(strArrSplit[i])) {
                    this.j = Float.parseFloat(strArrSplit[i]);
                }
                if (this.j >= 101.0f) {
                    this.j = 100.0f;
                }
                this.j = 100.0f - this.j;
                this.f.get(i).b.add(Float.valueOf(this.j));
                if (this.f.get(i).b.size() > this.a) {
                    this.f.get(i).b.remove(0);
                }
            }
        }
    }

    public synchronized void setFirstLinePoint(float f) {
        setFirstLinePoint(f, true, (int) (this.a * l));
    }

    public synchronized void setFirstLinePointTemp(float f) {
        if (f >= 101.0f) {
            f = 100.0f;
        }
        if (this.f.size() == 0) {
            return;
        }
        this.f.get(0).b.add(Float.valueOf(f));
        if (this.f.get(0).b.size() > this.a) {
            this.f.get(0).b.remove(0);
        }
    }

    public synchronized void setInitData(PatternHead patternHead, String[] strArr, boolean z) {
        b();
        int length = strArr.length;
        int i = this.a;
        if (length > i) {
            strArr = (String[]) Arrays.copyOfRange(strArr, 0, i);
        }
        for (String str : strArr) {
            if (!WearUtils.e1(str)) {
                if (str.contains(",")) {
                    this.e = true;
                    List<String> listCreateCommands = patternHead.createCommands(str);
                    this.k = listCreateCommands;
                    if (listCreateCommands != null) {
                        int i2 = 0;
                        for (String str2 : listCreateCommands) {
                            if (this.k.size() != 1 && i2 >= this.k.size() - 1 && !WearUtils.e1(str2)) {
                                setBothLinePoint(str2, false, this.a);
                            }
                            i2++;
                        }
                    }
                } else if (!str.contains(SignatureImpl.INNER_SEP) && !str.contains(";") && WearUtils.q1(str)) {
                    if (z) {
                        setFirstLinePoint(101.0f - Float.parseFloat(str), false, this.a);
                    } else {
                        setFirstLinePoint(101.0f - (Float.parseFloat(str) * 5.0f), false, this.a);
                    }
                }
            }
        }
        postInvalidate();
    }

    public void setPaintModel(int i) {
        this.h = i;
        d(getContext());
    }

    public void setPointMax(int i) {
        this.a = i;
    }

    public synchronized void setShowBothLine(boolean z) {
        if (this.e != z) {
            b();
        }
        this.e = z;
    }

    public synchronized void setBothLinePoint(String str, boolean z, int i) {
        if (!WearUtils.e1(str)) {
            String[] strArrSplit = str.split(",");
            for (int i2 = 0; i2 < strArrSplit.length && i2 < this.f.size(); i2++) {
                if (WearUtils.q1(strArrSplit[i2])) {
                    this.j = Float.parseFloat(strArrSplit[i2]);
                }
                if (this.j >= 101.0f) {
                    this.j = 100.0f;
                }
                this.j = 100.0f - this.j;
                this.f.get(i2).a.add(Float.valueOf(this.j));
                int size = this.f.get(i2).a.size();
                while (size - i > 0) {
                    this.f.get(i2).a.remove(0);
                    size = this.f.get(i2).a.size();
                }
            }
            if (z) {
                postInvalidate();
            }
        }
    }

    public synchronized void setFirstLinePoint(float f, boolean z, int i) {
        if (f >= 101.0f) {
            f = 100.0f;
        }
        if (this.f.size() == 0) {
            return;
        }
        this.f.get(0).a.add(Float.valueOf(f));
        int size = this.f.get(0).a.size();
        while (size - i > 0) {
            this.f.get(0).a.remove(0);
            size = this.f.get(0).a.size();
        }
        if (z) {
            postInvalidate();
        }
    }

    public NewCurveLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 20;
        this.d = 0;
        this.e = false;
        this.f = new ArrayList();
        this.h = ek2.SPEED.ordinal();
        this.i = new int[]{getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.curve_line), getResources().getColor(R.color.color_accent_second)};
        this.j = 0.0f;
        c(context);
    }

    public NewCurveLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 20;
        this.d = 0;
        this.e = false;
        this.f = new ArrayList();
        this.h = ek2.SPEED.ordinal();
        this.i = new int[]{getResources().getColor(R.color.text_color_red), getResources().getColor(R.color.curve_line), getResources().getColor(R.color.color_accent_second)};
        this.j = 0.0f;
        c(context);
    }
}
