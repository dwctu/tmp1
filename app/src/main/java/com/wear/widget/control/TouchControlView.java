package com.wear.widget.control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.control.FingerImageView;
import com.wear.widget.control.VSeekBarView;
import dc.ah4;
import dc.ce3;
import dc.xe3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes4.dex */
public class TouchControlView extends RelativeLayout {
    public static final String M = TouchControlView.class.getSimpleName();
    public static String N = SignatureImpl.INNER_SEP;
    public static String O = ",";
    public static String P = ";";
    public static int Q = -2;
    public int[] A;
    public String B;
    public Toy C;
    public String D;
    public boolean E;
    public int F;
    public HashMap<String, String> G;
    public int K;
    public String L;
    public f a;
    public LayoutInflater b;
    public RelativeLayout c;
    public RelativeLayout d;
    public int e;
    public TextView f;
    public TextView g;
    public TextView h;
    public View i;
    public View j;
    public ImageView k;
    public FingerImageView l;
    public LinearLayout m;
    public RelativeLayout n;
    public VSeekBarView o;
    public RelativeLayout p;
    public VSeekBarView q;
    public RelativeLayout r;
    public VSeekBarView s;
    public int t;
    public Handler u;
    public MyApplication v;
    public CurveLineTimeView w;
    public boolean x;
    public int y;
    public String[] z;

    public class a implements VSeekBarView.d {
        public a() {
        }

        @Override // com.wear.widget.control.VSeekBarView.d
        public void a(String str, String str2, String str3, boolean z) {
            if (TouchControlView.this.a == null || WearUtils.e1(str2)) {
                return;
            }
            TouchControlView.this.a.b(false, str, str2, str3, z, 0L);
        }
    }

    public class b implements FingerImageView.h {
        public b() {
        }

        @Override // com.wear.widget.control.FingerImageView.h
        public void a() {
            if (!TouchControlView.this.E) {
                TouchControlView.this.E = true;
                TouchControlView.this.N();
            }
            if (TouchControlView.this.f.getVisibility() == 0) {
                TouchControlView.this.f.setVisibility(8);
            }
        }

        @Override // com.wear.widget.control.FingerImageView.h
        public void b(String str, String str2, String str3, boolean z, long j) {
            if (TouchControlView.this.a != null) {
                TouchControlView.this.a.b(false, str, str2, str3, z, j);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TouchControlView.this.l.s();
        }
    }

    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String toyFunction;
            String[] strArrSplit;
            int i = message.what;
            if (i == 136) {
                String string = message.getData().getString("tags");
                String string2 = message.getData().getString("groups");
                TouchControlView.this.B = string;
                String unused = TouchControlView.M;
                String str = "tags=" + string + " - groups=" + string2;
                if (WearUtils.e1(string) || WearUtils.e1(string2)) {
                    return;
                }
                String[] strArrSplit2 = string.split(TouchControlView.O);
                String[] strArrSplit3 = string2.split(TouchControlView.O);
                if (strArrSplit2 != null && strArrSplit3 != null && strArrSplit2.length == strArrSplit3.length) {
                    if (TouchControlView.this.w == null || TouchControlView.this.w.b == null) {
                        return;
                    }
                    TouchControlView.this.w.b.setBothLinePoint(string2);
                    return;
                }
                String unused2 = TouchControlView.M;
                String str2 = "ERROR!!! tags=" + string + " - groups=" + string2;
                return;
            }
            if (i != 153) {
                return;
            }
            String string3 = message.getData().getString("tags");
            String string4 = message.getData().getString("groups");
            TouchControlView.this.B = string3;
            if (WearUtils.e1(string3) || WearUtils.e1(string4)) {
                return;
            }
            String[] strArrSplit4 = string3.split(TouchControlView.O);
            String[] strArrSplit5 = string4.split(TouchControlView.O);
            if (strArrSplit4 == null || strArrSplit5 == null || strArrSplit4.length != strArrSplit5.length) {
                String unused3 = TouchControlView.M;
                String str3 = "ERROR!!! tags=" + string3 + " - groups=" + string4;
                return;
            }
            if (TouchControlView.this.w != null && TouchControlView.this.w.b != null) {
                TouchControlView.this.w.b.setBothLinePoint(string4);
            }
            if (TouchControlView.this.G.get(string3) == null || !TouchControlView.this.G.get(string3).equals(string4)) {
                TouchControlView.this.K = 0;
            } else {
                if (string4.indexOf("0") == -1) {
                    return;
                }
                TouchControlView touchControlView = TouchControlView.this;
                int i2 = touchControlView.K;
                touchControlView.K = i2 + 1;
                if (i2 > 5) {
                    return;
                }
            }
            TouchControlView.this.G.put(string3, string4);
            for (int i3 = 0; i3 < strArrSplit4.length; i3++) {
                if (!WearUtils.e1(strArrSplit4[i3])) {
                    if (!Toy.TOY_OPERATION.containsKey(strArrSplit4[i3]) || WearUtils.e1(strArrSplit5[i3])) {
                        Toy toyQ = TouchControlView.this.v.G().Q(strArrSplit4[i3]);
                        if (toyQ != null && !WearUtils.e1(toyQ.getType()) && Toy.ICON_MAP_CONTROL.containsKey(toyQ.getType()) && !WearUtils.e1(strArrSplit5[i3]) && (toyFunction = Toy.getToyFunction(toyQ.getType())) != null && (strArrSplit = toyFunction.split(",")) != null && strArrSplit5.length >= strArrSplit.length) {
                            int i4 = 0;
                            for (String str4 : strArrSplit) {
                                if (!WearUtils.e1(str4) && Toy.TOY_OPERATION.containsKey(str4)) {
                                    TouchControlView.this.F(toyQ, str4, Integer.valueOf(strArrSplit5[i4]).intValue(), i3 * 30);
                                }
                                i4++;
                            }
                        }
                    } else {
                        TouchControlView touchControlView2 = TouchControlView.this;
                        touchControlView2.F(touchControlView2.C, strArrSplit4[i3], Integer.valueOf(strArrSplit5[i3]).intValue(), i3 * 30);
                    }
                }
            }
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ ImageView a;

        public e(ImageView imageView) {
            this.a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.setBackgroundResource(TouchControlView.this.A[TouchControlView.g(TouchControlView.this) % TouchControlView.this.z.length]);
            if (TouchControlView.this.y >= 2147483646) {
                TouchControlView.this.y = 0;
            }
            if (WearUtils.e1(TouchControlView.this.B)) {
                TouchControlView touchControlView = TouchControlView.this;
                touchControlView.B = touchControlView.o.getSeekBarsTags();
            }
            int progress = TouchControlView.this.o.d.getProgress();
            if (progress > 100) {
                progress = 100;
            }
            if (TouchControlView.this.a != null) {
                TouchControlView.this.a.b(true, TouchControlView.this.B, progress + TouchControlView.O + String.valueOf(TouchControlView.Q), null, true, 0L);
            }
        }
    }

    public interface f {
        void a(List<Toy> list, String str);

        void b(boolean z, String str, String str2, String str3, boolean z2, long j);
    }

    public TouchControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 8;
        this.x = true;
        this.y = 0;
        this.z = new String[]{"l", StreamManagement.AckRequest.ELEMENT};
        this.A = new int[]{R.drawable.toolbar_icon_anticlockwise, R.drawable.toolbar_icon_clockwise};
        this.B = "";
        this.C = null;
        this.D = "";
        this.E = false;
        this.G = new HashMap<>();
        this.K = 0;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.b = layoutInflater;
        this.c = (RelativeLayout) layoutInflater.inflate(R.layout.touch_control, (ViewGroup) null);
        w();
        this.d = (RelativeLayout) this.c.findViewById(R.id.finger_layout);
        this.f = (TextView) this.c.findViewById(R.id.tapTip);
        this.g = (TextView) this.c.findViewById(R.id.tap_time);
        this.h = (TextView) this.c.findViewById(R.id.tap_name);
        this.i = this.c.findViewById(R.id.top_empty_layout);
        this.j = this.c.findViewById(R.id.top_area_line);
        this.k = (ImageView) this.c.findViewById(R.id.finger_label_image);
        this.m = (LinearLayout) this.c.findViewById(R.id.vseekbars_layout);
        this.n = (RelativeLayout) this.c.findViewById(R.id.vseekBar_left_layout);
        this.o = (VSeekBarView) this.c.findViewById(R.id.vseekBar_left);
        this.p = (RelativeLayout) this.c.findViewById(R.id.vseekBar_right_layout);
        this.q = (VSeekBarView) this.c.findViewById(R.id.vseekBar_right);
        this.r = (RelativeLayout) this.c.findViewById(R.id.vseekBar_expansion_layout);
        this.s = (VSeekBarView) this.c.findViewById(R.id.vseekBar_expansion);
        this.o.setVSeekBar(PSOProgramService.VS_Key, ah4.e(R.string.toy_control_vibrate), getResources().getColor(R.color.buttom_select_background));
        this.o.setChangeListener(true, new a());
        this.n.setVisibility(0);
        this.o.e(this.q);
        this.o.e(this.s);
        this.o.setExpansionVseekBar(this.s);
        FingerImageView fingerImageView = (FingerImageView) this.c.findViewById(R.id.ficView);
        this.l = fingerImageView;
        fingerImageView.A(PSOProgramService.VS_Key, R.drawable.touch_btn);
        this.l.setChangeListener(new b());
        addView(this.c);
        this.F = 0;
    }

    public static /* synthetic */ int g(TouchControlView touchControlView) {
        int i = touchControlView.y + 1;
        touchControlView.y = i;
        return i;
    }

    public void A(int i) {
        this.l.n(i);
        this.o.g(i);
        this.q.g(i);
        this.s.g(i);
    }

    public void B() {
        this.l.q();
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView != null) {
            curveLineTimeView.h();
        }
        this.q.i();
        this.s.i();
        this.o.i();
    }

    public void C() {
        this.l.s();
    }

    public void D(int i) {
        this.t = i;
        v();
        if (i == 0) {
            this.d.setVisibility(0);
            this.m.setVisibility(8);
        }
    }

    public void E() {
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView != null) {
            curveLineTimeView.i();
        }
    }

    public final void F(Toy toy, String str, int i, int i2) {
        String[] strArr = Toy.TOY_OPERATION.get(str);
        if (WearUtils.j1(strArr) || strArr.length < 2) {
            return;
        }
        int iIntValue = 100 / Integer.valueOf(strArr[1]).intValue();
        if (i > 0 && i / iIntValue == 0) {
            i = iIntValue;
        }
        String str2 = strArr[0];
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int i3 = i / iIntValue;
        sb.append(i3);
        String strReplace = str2.replace("#", sb.toString());
        String str3 = "opertion=" + str + " -> value/each>" + i + "/" + iIntValue + "=" + i3 + " command=" + strReplace;
        MyApplication myApplication = this.v;
        if (myApplication == null || myApplication.G() == null || this.v.G().P().size() <= 0) {
            return;
        }
        if (toy == null || WearUtils.e1(toy.getAddress())) {
            String str4 = "sendCommand: 1:command=" + strReplace + ",patternHead=" + this.F;
            if (toy != null) {
                this.v.G().j0(toy.getAddress(), strReplace, this.F);
                return;
            }
            return;
        }
        if (this.F != 1 || toy.isF01Toy()) {
            String str5 = "sendCommand:2:command=" + strReplace + ",patternHead=" + this.F;
            this.v.G().i0(toy.getAddress(), strReplace);
        }
    }

    public synchronized String G(String str, String str2) {
        Message message = new Message();
        message.what = 153;
        Bundle bundle = new Bundle();
        bundle.putString("tags", str);
        bundle.putString("groups", str2);
        message.setData(bundle);
        this.u.sendMessage(message);
        return Toy.changeSinglefuncLineToTayValue(str, str2);
    }

    public void H(String str, Integer num) {
        this.l.z(str, num == null ? R.drawable.touch_btn : num.intValue());
    }

    public void I(String str, String str2, Integer num) {
        this.s.setVSeekBar(str, str2, num == null ? getResources().getColor(R.color.buttom_select_background) : getResources().getColor(num.intValue()));
        this.r.setVisibility(0);
    }

    public void J(String str, String str2, Integer num) {
        this.o.setVSeekBar(str, str2, num == null ? getResources().getColor(R.color.buttom_select_background) : getResources().getColor(num.intValue()));
        this.n.setVisibility(0);
    }

    public void K(String str, Integer num) {
        this.l.A(str, num == null ? R.drawable.touch_btn : num.intValue());
    }

    public void L(String str, String str2, Integer num) {
        CurveLineView curveLineView;
        this.q.setVSeekBar(str, str2, num == null ? getResources().getColor(R.color.color_accent_second) : getResources().getColor(num.intValue()));
        this.p.setVisibility(0);
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView != null && (curveLineView = curveLineTimeView.b) != null) {
            curveLineView.setShowBothLine(true);
        }
        if (str.equals(StreamManagement.AckRequest.ELEMENT)) {
            ImageView lableImage = this.q.getLableImage();
            lableImage.setVisibility(0);
            lableImage.setBackgroundResource(this.A[this.y % this.z.length]);
            lableImage.setOnClickListener(new e(lableImage));
        }
    }

    public void M(String str, Integer num) {
        CurveLineView curveLineView;
        this.l.B(str, num == null ? R.drawable.touch_btn : num.intValue());
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView == null || (curveLineView = curveLineTimeView.b) == null) {
            return;
        }
        curveLineView.setShowBothLine(true);
    }

    public void N() {
        this.l.setPause(false);
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView == null || curveLineTimeView.getVisibility() != 0) {
            return;
        }
        this.w.setPause(false);
    }

    public void O(boolean z, Toy toy) throws Resources.NotFoundException {
        setFingerAndNoStart(z, toy);
        this.l.setPause(false);
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView == null || curveLineTimeView.getVisibility() != 0) {
            return;
        }
        this.w.setPause(false);
    }

    public void P() {
        this.l.setPause(true);
        this.o.setPause(true);
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView != null) {
            curveLineTimeView.setPause(true);
        }
        MyApplication myApplication = this.v;
        if (myApplication != null) {
            myApplication.G().u0();
        }
        this.t = 0;
        v();
    }

    public void Q(Integer num, int i, int i2, Integer num2) {
        if (num != null) {
            getFicView().t(ce3.a(this.v, num.intValue()));
        }
        ImageView fingerLabelImage = getFingerLabelImage();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fingerLabelImage.getLayoutParams();
        layoutParams.setMargins(0, ce3.a(this.v, i), 0, ce3.a(this.v, i2));
        fingerLabelImage.setLayoutParams(layoutParams);
        if (num2 != null) {
            View top_area_line = getTop_area_line();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) top_area_line.getLayoutParams();
            int iA = ce3.a(this.v, num2.intValue());
            this.l.E = iA / 2;
            layoutParams2.setMargins(0, iA, 0, 0);
            top_area_line.setLayoutParams(layoutParams2);
            View top_empty_layout = getTop_empty_layout();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) top_empty_layout.getLayoutParams();
            layoutParams3.height = iA;
            top_empty_layout.setLayoutParams(layoutParams3);
            FingerImageView fingerImageView = this.l;
            fingerImageView.F = layoutParams3.height;
            if (iA == 0) {
                fingerImageView.F = getFicView().d.getHeight() / 2;
            }
        }
        invalidate();
    }

    public String getControlDeviceId() {
        return this.D;
    }

    public int getControlType() {
        return this.t;
    }

    public FingerImageView getFicView() {
        return this.l;
    }

    public ImageView getFingerLabelImage() {
        return this.k;
    }

    public Toy getFingerToy() {
        return this.C;
    }

    public List<String> getLoopDatas() {
        return this.l.getDatas();
    }

    public TextView getTapName() {
        return this.h;
    }

    public int getTime() {
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView != null) {
            return curveLineTimeView.getTime();
        }
        return 0;
    }

    public View getTop_area_line() {
        return this.j;
    }

    public View getTop_empty_layout() {
        return this.i;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.t != 2) {
            this.l.s();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void s(String str, String str2, String str3) throws Resources.NotFoundException {
        Integer[] numArr;
        int[] toyFuncIcon;
        z("bindFunToy toyType=" + str + " function=" + str2 + " expFunction=" + str3);
        boolean zE1 = WearUtils.e1(str2);
        Integer numValueOf = Integer.valueOf(R.color.color_accent_second);
        if (!zE1) {
            this.L = str2;
            t();
            String[] strArrSplit = str2.split(",");
            if (!WearUtils.j1(strArrSplit) && (toyFuncIcon = Toy.getToyFuncIcon(str, 1, 0, false)) != null && strArrSplit.length == toyFuncIcon.length) {
                int length = strArrSplit.length;
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    String str4 = strArrSplit[i2];
                    if (i == 1) {
                        toyFuncIcon = Toy.getToyFuncIcon(str, 1, i, false);
                    }
                    if (i == 0) {
                        K(str4, Integer.valueOf(toyFuncIcon[i]));
                        CurveLineTimeView curveLineTimeView = this.w;
                        if (curveLineTimeView != null) {
                            curveLineTimeView.getCurveLine().setOneLineColor(Toy.getCurveLineColor(str4));
                        }
                    } else if (i == 1) {
                        if (str.toLowerCase().equals("qa01")) {
                            str4 = "s";
                        }
                        M(str4, Integer.valueOf(toyFuncIcon[i]));
                        CurveLineTimeView curveLineTimeView2 = this.w;
                        if (curveLineTimeView2 != null) {
                            curveLineTimeView2.getCurveLine().setSecondLineColor(Toy.getCurveLineColor(str4));
                        }
                    }
                    if (this.x) {
                        String[] strArr = Toy.TOY_OPERATION.get(str4);
                        if (!WearUtils.j1(strArr) && strArr.length >= 3) {
                            if (i == 0) {
                                J(str4, Toy.getLableTitle(str, ah4.e(Integer.valueOf(strArr[2]).intValue())), Integer.valueOf(R.color.buttom_select_background));
                            } else if (i == 1) {
                                L(str4, ah4.e(Integer.valueOf(strArr[2]).intValue()), numValueOf);
                            }
                        }
                    }
                    i++;
                }
            }
        }
        if (!WearUtils.e1(str3)) {
            Map<String, Integer[]> map = Toy.TOY_MAP_FUNC;
            if (map.containsKey(str3) && (numArr = map.get(str3)) != null && numArr.length > 1) {
                this.L += "," + str3;
                if (numArr[1] != null) {
                    H(str3, numArr[1]);
                }
                CurveLineTimeView curveLineTimeView3 = this.w;
                if (curveLineTimeView3 != null) {
                    curveLineTimeView3.getCurveLine().setSecondLineColor(Toy.getCurveLineColor(str3));
                }
                if (this.x && numArr[0] != null) {
                    I(str3, ah4.e(numArr[0].intValue()), numValueOf);
                }
            }
        }
        this.l.setLastFunction(this.L);
    }

    public void setControlDeviceId(String str) {
        this.D = str;
    }

    public void setControlFloatType() {
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        if (this.t == 0) {
            this.o.setPause(true);
            this.l.setPause(false);
            this.d.setVisibility(0);
            this.m.setVisibility(8);
        }
        this.t = this.t != 2 ? 2 : 0;
        v();
    }

    public void setControlLiveType() {
        x();
    }

    public void setControlLoopType() {
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        if (this.t == 0) {
            this.o.setPause(true);
            this.l.setPause(false);
            this.d.setVisibility(0);
            this.m.setVisibility(8);
        }
        this.t = this.t != 1 ? 1 : 0;
        v();
    }

    public void setControlManualType() {
        this.t = 0;
        v();
        this.l.setPause(true);
        this.o.setProgress(0);
        this.q.setProgress(0);
        this.s.setProgress(0);
        this.o.setPause(false);
        this.d.setVisibility(8);
        this.m.setVisibility(0);
    }

    public void setControlType(int i) {
        this.t = i;
    }

    public void setCurveLineTimeColor(Integer num) {
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView != null) {
            curveLineTimeView.setTimeColor(num);
        }
    }

    public void setCurveLineToyName(String str) {
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView != null) {
            curveLineTimeView.setToyName(str);
        }
    }

    public void setCurveLineToyNameColor(Integer num) {
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView != null) {
            curveLineTimeView.setToyNameColor(num);
        }
    }

    public void setCurveLineTvTimeVisibility(int i) {
        CurveLineTimeView curveLineTimeView = this.w;
        if (curveLineTimeView != null) {
            curveLineTimeView.setTvTimeVisibility(i);
        }
    }

    public void setFingerAndNoStart(boolean z, Toy toy) throws Resources.NotFoundException {
        this.x = z;
        List<Toy> arrayList = new ArrayList<>();
        if (toy == null) {
            arrayList = u();
        } else {
            this.C = toy;
            setControlDeviceId(toy.getDeviceId());
            arrayList.add(toy);
            y(toy);
        }
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(arrayList, this.l.getFingerTags());
        }
    }

    public void setFingerLabelImageVisibility(int i) {
        this.k.setVisibility(i);
    }

    public void setListener(f fVar) {
        this.a = fVar;
    }

    public void setLoopDatas(List<String> list) {
        this.l.setDatas(list);
    }

    public void setPatternHeadTFlag(int i) {
        this.F = i;
    }

    public void setProgress(int i) {
        this.o.setProgress(i);
        this.q.setProgress(i);
        this.s.setProgress(i);
    }

    public void setTapNameColor(Integer num) {
        this.h.setTextColor(num == null ? getResources().getColor(R.color.buttom_select_background) : getResources().getColor(num.intValue()));
    }

    public void setTapNameGravity(int i) {
        this.h.setGravity(i);
    }

    public void setTapNameString(String str) {
        this.h.setText(Html.fromHtml(str));
    }

    public void setTapNameVisibility(int i, String str) {
        this.h.setVisibility(i);
        if (!WearUtils.e1(str)) {
            this.h.setText(Html.fromHtml(str));
        }
        this.j.setVisibility(i);
        this.i.setVisibility(i);
    }

    public void setTapTimeString(String str) {
        this.g.setText(str);
    }

    public void setTapTimeVisibility(int i) {
        this.g.setVisibility(i);
    }

    public void setTapTipVisibility(int i) {
        this.e = i;
        if (i == 8) {
            this.f.setVisibility(8);
        }
    }

    public void setWidget(MyApplication myApplication, CurveLineTimeView curveLineTimeView) {
        this.v = myApplication;
        this.w = curveLineTimeView;
    }

    public void t() {
        if (this.t == 0) {
            this.l.g();
        }
        this.l.h();
        this.l.f();
        if (this.t == 0) {
            this.o.j();
            this.n.setVisibility(8);
        }
        this.q.j();
        this.p.setVisibility(8);
        this.s.j();
        this.r.setVisibility(8);
    }

    public final List<Toy> u() throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList();
        ArrayList<Toy> arrayListP = this.v.G().P();
        if (arrayListP.size() == 2) {
            int[] toyFuncIcon = Toy.getToyFuncIcon(arrayListP.get(0).getType(), 2, 0, false);
            if (toyFuncIcon != null && toyFuncIcon.length == 1) {
                arrayList.add(arrayListP.get(0));
                K(arrayListP.get(0).getAddress(), Integer.valueOf(toyFuncIcon[0]));
                if (this.x) {
                    J(arrayListP.get(0).getAddress(), arrayListP.get(0).getName(), Integer.valueOf(R.color.buttom_select_background));
                }
            }
            int[] toyFuncIcon2 = Toy.getToyFuncIcon(arrayListP.get(1).getType(), 2, 1, false);
            if (toyFuncIcon2 != null && toyFuncIcon2.length == 1) {
                arrayList.add(arrayListP.get(1));
                M(arrayListP.get(1).getAddress(), Integer.valueOf(toyFuncIcon2[0]));
                if (this.x) {
                    L(arrayListP.get(1).getAddress(), arrayListP.get(1).getName(), Integer.valueOf(R.color.color_accent_second));
                }
            }
        } else if (arrayListP.size() == 1) {
            arrayList.add(arrayListP.get(0));
            y(arrayListP.get(0));
        }
        return arrayList;
    }

    public final void v() {
        this.l.setControlType(this.t);
        if (this.t == 1) {
            this.f.setText(ah4.e(R.string.pattern_touchMsg_loop));
        } else {
            this.f.setText(ah4.e(R.string.pattern_touchMsg));
        }
        if (this.e == 0) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public final void w() {
        this.u = new d();
    }

    public void x() {
        this.o.setProgress(0);
        this.q.setProgress(0);
        this.s.setProgress(0);
        this.o.setPause(true);
        this.l.setPause(true);
        new Handler(Looper.getMainLooper()).postDelayed(new c(), 100L);
        this.d.setVisibility(0);
        this.m.setVisibility(8);
    }

    public final void y(Toy toy) throws Resources.NotFoundException {
        if (toy == null) {
            return;
        }
        s(toy.getType(), Toy.getToyFunction(toy.getType()), null);
    }

    public final void z(String str) {
        xe3.a("TouchControlView", str);
    }
}
