package com.wear.widget.control;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.control.DSFingerImageView;
import com.wear.widget.control.VSeekBarView;
import dc.ah4;
import dc.xe3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes4.dex */
public class DSMultipleToyControlView extends RelativeLayout {
    public static final String F = TouchControlView.class.getSimpleName();
    public static String G = ",";
    public Toy A;
    public String B;
    public boolean C;
    public HashMap<String, String> D;
    public int E;
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
    public DSFingerImageView l;
    public RelativeLayout m;
    public VSeekBarView n;
    public RelativeLayout o;
    public VSeekBarView p;
    public RelativeLayout q;
    public VSeekBarView r;
    public int s;
    public MyApplication t;
    public CurveLineTimeView u;
    public boolean v;
    public int w;
    public String[] x;
    public int[] y;
    public String z;

    public class a implements DSFingerImageView.j {
        public a() {
        }

        @Override // com.wear.widget.control.DSFingerImageView.j
        public void a() {
            if (!DSMultipleToyControlView.this.C) {
                DSMultipleToyControlView.this.C = true;
                DSMultipleToyControlView.this.F();
            }
            if (DSMultipleToyControlView.this.f.getVisibility() == 0) {
                DSMultipleToyControlView.this.f.setVisibility(8);
            }
        }

        @Override // com.wear.widget.control.DSFingerImageView.j
        public void b(String str, String str2, String str3, boolean z, long j) {
            if (DSMultipleToyControlView.this.a != null) {
                DSMultipleToyControlView.this.a.b(false, str, str2, str3, z, j);
            }
        }
    }

    public class b implements VSeekBarView.d {
        public b() {
        }

        @Override // com.wear.widget.control.VSeekBarView.d
        public void a(String str, String str2, String str3, boolean z) {
            if (DSMultipleToyControlView.this.a == null || WearUtils.e1(str2)) {
                return;
            }
            DSMultipleToyControlView.this.a.b(false, str, str2, str3, z, 0L);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DSMultipleToyControlView.this.l.o();
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
                DSMultipleToyControlView.this.z = string;
                String unused = DSMultipleToyControlView.F;
                String str = "tags=" + string + " - groups=" + string2;
                if (WearUtils.e1(string) || WearUtils.e1(string2)) {
                    return;
                }
                String[] strArrSplit2 = string.split(DSMultipleToyControlView.G);
                String[] strArrSplit3 = string2.split(DSMultipleToyControlView.G);
                if (strArrSplit2 != null && strArrSplit3 != null && strArrSplit2.length == strArrSplit3.length) {
                    if (DSMultipleToyControlView.this.u == null || DSMultipleToyControlView.this.u.b == null) {
                        return;
                    }
                    DSMultipleToyControlView.this.u.b.setBothLinePoint(string2);
                    return;
                }
                String unused2 = DSMultipleToyControlView.F;
                String str2 = "ERROR!!! tags=" + string + " - groups=" + string2;
                return;
            }
            if (i != 153) {
                return;
            }
            String string3 = message.getData().getString("tags");
            String string4 = message.getData().getString("groups");
            DSMultipleToyControlView.this.z = string3;
            if (WearUtils.e1(string3) || WearUtils.e1(string4)) {
                return;
            }
            String[] strArrSplit4 = string3.split(DSMultipleToyControlView.G);
            String[] strArrSplit5 = string4.split(DSMultipleToyControlView.G);
            if (strArrSplit4 == null || strArrSplit5 == null || strArrSplit4.length != strArrSplit5.length) {
                String unused3 = DSMultipleToyControlView.F;
                String str3 = "ERROR!!! tags=" + string3 + " - groups=" + string4;
                return;
            }
            if (DSMultipleToyControlView.this.u != null && DSMultipleToyControlView.this.u.b != null) {
                DSMultipleToyControlView.this.u.b.setBothLinePoint(string4);
            }
            if (DSMultipleToyControlView.this.D.get(string3) == null || !DSMultipleToyControlView.this.D.get(string3).equals(string4)) {
                DSMultipleToyControlView.this.E = 0;
            } else {
                if (string4.indexOf("0") == -1) {
                    return;
                }
                DSMultipleToyControlView dSMultipleToyControlView = DSMultipleToyControlView.this;
                int i2 = dSMultipleToyControlView.E;
                dSMultipleToyControlView.E = i2 + 1;
                if (i2 > 5) {
                    return;
                }
            }
            DSMultipleToyControlView.this.D.put(string3, string4);
            for (int i3 = 0; i3 < strArrSplit4.length; i3++) {
                if (!WearUtils.e1(strArrSplit4[i3])) {
                    if (!Toy.TOY_OPERATION.containsKey(strArrSplit4[i3]) || WearUtils.e1(strArrSplit5[i3])) {
                        Toy toyQ = DSMultipleToyControlView.this.t.G().Q(strArrSplit4[i3]);
                        if (toyQ != null && !WearUtils.e1(toyQ.getType()) && Toy.ICON_MAP_CONTROL.containsKey(toyQ.getType()) && !WearUtils.e1(strArrSplit5[i3]) && (toyFunction = Toy.getToyFunction(toyQ.getType())) != null && (strArrSplit = toyFunction.split(",")) != null && strArrSplit5.length >= strArrSplit.length) {
                            int i4 = 0;
                            for (String str4 : strArrSplit) {
                                if (!WearUtils.e1(str4) && Toy.TOY_OPERATION.containsKey(str4)) {
                                    DSMultipleToyControlView.this.A(toyQ, str4, Integer.valueOf(strArrSplit5[i4]).intValue(), i3 * 30);
                                }
                                i4++;
                            }
                        }
                    } else {
                        DSMultipleToyControlView dSMultipleToyControlView2 = DSMultipleToyControlView.this;
                        dSMultipleToyControlView2.A(dSMultipleToyControlView2.A, strArrSplit4[i3], Integer.valueOf(strArrSplit5[i3]).intValue(), i3 * 30);
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
            this.a.setBackgroundResource(DSMultipleToyControlView.this.y[DSMultipleToyControlView.g(DSMultipleToyControlView.this) % DSMultipleToyControlView.this.x.length]);
            if (DSMultipleToyControlView.this.w >= 2147483646) {
                DSMultipleToyControlView.this.w = 0;
            }
            if (WearUtils.e1(DSMultipleToyControlView.this.z)) {
                DSMultipleToyControlView dSMultipleToyControlView = DSMultipleToyControlView.this;
                dSMultipleToyControlView.z = dSMultipleToyControlView.n.getSeekBarsTags();
            }
            int progress = DSMultipleToyControlView.this.n.d.getProgress();
            if (progress > 100) {
                progress = 100;
            }
            if (DSMultipleToyControlView.this.a != null) {
                DSMultipleToyControlView.this.a.b(true, DSMultipleToyControlView.this.z, progress + DSMultipleToyControlView.G + String.valueOf(TouchControlView.Q), null, true, 0L);
            }
        }
    }

    public interface f {
        void a(List<Toy> list, String str);

        void b(boolean z, String str, String str2, String str3, boolean z2, long j);
    }

    public DSMultipleToyControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 8;
        this.v = true;
        this.w = 0;
        this.x = new String[]{"l", StreamManagement.AckRequest.ELEMENT};
        this.y = new int[]{R.drawable.toolbar_icon_anticlockwise, R.drawable.toolbar_icon_clockwise};
        this.z = "";
        this.A = null;
        this.B = "";
        this.C = false;
        this.D = new HashMap<>();
        this.E = 0;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.b = layoutInflater;
        this.c = (RelativeLayout) layoutInflater.inflate(R.layout.view_ds_toy_control, (ViewGroup) null);
        w();
        this.d = (RelativeLayout) this.c.findViewById(R.id.finger_layout);
        this.f = (TextView) this.c.findViewById(R.id.tapTip);
        this.g = (TextView) this.c.findViewById(R.id.tap_time);
        this.h = (TextView) this.c.findViewById(R.id.tap_name);
        this.i = this.c.findViewById(R.id.top_empty_layout);
        this.j = this.c.findViewById(R.id.top_area_line);
        this.k = (ImageView) this.c.findViewById(R.id.finger_label_image);
        DSFingerImageView dSFingerImageView = (DSFingerImageView) this.c.findViewById(R.id.ficView);
        this.l = dSFingerImageView;
        dSFingerImageView.u(PSOProgramService.VS_Key, R.drawable.touch_btn);
        this.l.setChangeListener(new a());
        addView(this.c);
    }

    public static /* synthetic */ int g(DSMultipleToyControlView dSMultipleToyControlView) {
        int i = dSMultipleToyControlView.w + 1;
        dSMultipleToyControlView.w = i;
        return i;
    }

    public final void A(Toy toy, String str, int i, int i2) {
        String[] strArr = Toy.TOY_OPERATION.get(str);
        if (WearUtils.j1(strArr) || strArr.length < 2) {
            return;
        }
        int iIntValue = 100 / Integer.valueOf(strArr[1]).intValue();
        if (i > 0 && i / iIntValue == 0) {
            i = iIntValue;
        }
        String strReplace = strArr[0].replace("#", "" + (i / iIntValue));
        MyApplication myApplication = this.t;
        if (myApplication == null || myApplication.G() == null || this.t.G().P().size() <= 0) {
            return;
        }
        if (toy == null || (toy != null && WearUtils.e1(toy.getAddress()))) {
            this.t.G().g0(strReplace);
        } else {
            this.t.G().i0(toy.getAddress(), strReplace);
        }
    }

    public void B(String str, String str2, Integer num) {
        this.n.setVSeekBar(str, str2, num == null ? getResources().getColor(R.color.buttom_select_background) : getResources().getColor(num.intValue()));
        this.m.setVisibility(0);
    }

    public void C(String str, Integer num) {
        this.l.u(str, num == null ? R.drawable.touch_btn : num.intValue());
    }

    public void D(String str, String str2, Integer num) {
        CurveLineView curveLineView;
        this.p.setVSeekBar(str, str2, num == null ? getResources().getColor(R.color.color_accent_second) : getResources().getColor(num.intValue()));
        this.o.setVisibility(0);
        CurveLineTimeView curveLineTimeView = this.u;
        if (curveLineTimeView != null && (curveLineView = curveLineTimeView.b) != null) {
            curveLineView.setShowBothLine(true);
        }
        if (str.equals(StreamManagement.AckRequest.ELEMENT)) {
            ImageView lableImage = this.p.getLableImage();
            lableImage.setVisibility(0);
            lableImage.setBackgroundResource(this.y[this.w % this.x.length]);
            lableImage.setOnClickListener(new e(lableImage));
        }
    }

    public void E(String str, Integer num) {
        CurveLineView curveLineView;
        this.l.v(str, num == null ? R.drawable.touch_btn : num.intValue());
        CurveLineTimeView curveLineTimeView = this.u;
        if (curveLineTimeView == null || (curveLineView = curveLineTimeView.b) == null) {
            return;
        }
        curveLineView.setShowBothLine(true);
    }

    public void F() {
        this.l.setPause(false);
        CurveLineTimeView curveLineTimeView = this.u;
        if (curveLineTimeView == null || curveLineTimeView.getVisibility() != 0) {
            return;
        }
        this.u.setPause(false);
    }

    public String getControlDeviceId() {
        return this.B;
    }

    public int getControlType() {
        return this.s;
    }

    public DSFingerImageView getFicView() {
        return this.l;
    }

    public ImageView getFingerLabelImage() {
        return this.k;
    }

    public Toy getFingerToy() {
        return this.A;
    }

    public boolean getShowType() {
        return this.d.getVisibility() == 0;
    }

    public TextView getTapName() {
        return this.h;
    }

    public int getTime() {
        CurveLineTimeView curveLineTimeView = this.u;
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
        if (this.s != 2) {
            this.l.o();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void s(String str, String str2, String str3) throws Resources.NotFoundException {
        int[] toyFuncIcon;
        z("bindFunToy toyType=" + str + " function=" + str2 + " expFunction=" + str3);
        if (WearUtils.e1(str2)) {
            return;
        }
        t();
        String[] strArrSplit = str2.split(",");
        if (WearUtils.j1(strArrSplit) || (toyFuncIcon = Toy.getToyFuncIcon(str, 1, 0, false)) == null || strArrSplit.length != toyFuncIcon.length) {
            return;
        }
        int length = strArrSplit.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            String str4 = strArrSplit[i2];
            if (i == 1) {
                toyFuncIcon = Toy.getToyFuncIcon(str, 1, i, false);
            }
            if (i == 0) {
                C(str4, Integer.valueOf(toyFuncIcon[i]));
                CurveLineTimeView curveLineTimeView = this.u;
                if (curveLineTimeView != null) {
                    curveLineTimeView.getCurveLine().setOneLineColor(Toy.getCurveLineColor(str4));
                }
            } else if (i == 1) {
                if (str.toLowerCase().equals("qa01")) {
                    str4 = "s";
                }
                E(str4, Integer.valueOf(toyFuncIcon[i]));
                CurveLineTimeView curveLineTimeView2 = this.u;
                if (curveLineTimeView2 != null) {
                    curveLineTimeView2.getCurveLine().setSecondLineColor(Toy.getCurveLineColor(str4));
                }
            }
            if (this.v) {
                String[] strArr = Toy.TOY_OPERATION.get(str4);
                if (!WearUtils.j1(strArr) && strArr.length >= 3) {
                    if (i == 0) {
                        B(str4, Toy.getLableTitle(str, ah4.e(Integer.valueOf(strArr[2]).intValue())), Integer.valueOf(R.color.buttom_select_background));
                    } else if (i == 1) {
                        D(str4, getResources().getString(Integer.valueOf(strArr[2]).intValue()), Integer.valueOf(R.color.color_accent_second));
                    }
                }
            }
            i++;
        }
    }

    public void setControlDeviceId(String str) {
        this.B = str;
    }

    public void setControlFloatType() {
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        if (this.s == 0) {
            this.n.setPause(true);
            this.l.setPause(false);
            this.d.setVisibility(0);
        }
        this.s = this.s != 2 ? 2 : 0;
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
        if (this.s == 0) {
            this.n.setPause(true);
            this.l.setPause(false);
        }
        this.s = this.s != 1 ? 1 : 0;
        v();
    }

    public void setControlManualType() {
        this.s = 0;
        v();
        this.l.setPause(false);
        this.n.setProgress(0);
        this.p.setProgress(0);
        this.r.setProgress(0);
        this.n.setPause(true);
    }

    public void setCurveLineTimeColor(Integer num) {
        CurveLineTimeView curveLineTimeView = this.u;
        if (curveLineTimeView != null) {
            curveLineTimeView.setTimeColor(num);
        }
    }

    public void setCurveLineToyName(String str) {
        CurveLineTimeView curveLineTimeView = this.u;
        if (curveLineTimeView != null) {
            curveLineTimeView.setToyName(str);
        }
    }

    public void setCurveLineToyNameColor(Integer num) {
        CurveLineTimeView curveLineTimeView = this.u;
        if (curveLineTimeView != null) {
            curveLineTimeView.setToyNameColor(num);
        }
    }

    public void setCurveLineTvTimeVisibility(int i) {
        CurveLineTimeView curveLineTimeView = this.u;
        if (curveLineTimeView != null) {
            curveLineTimeView.setTvTimeVisibility(i);
        }
    }

    public void setFingerAndNoStart(boolean z, Toy toy) throws Resources.NotFoundException {
        this.v = z;
        List<Toy> arrayList = new ArrayList<>();
        if (toy == null) {
            arrayList = u();
        } else {
            this.A = toy;
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

    public void setVSeekBar(DSMultipleToySeekBarControlView dSMultipleToySeekBarControlView) {
        if (dSMultipleToySeekBarControlView != null) {
            this.m = dSMultipleToySeekBarControlView.getVseekBarLeftLayout();
            this.n = dSMultipleToySeekBarControlView.getVseekBarLeft();
            this.o = dSMultipleToySeekBarControlView.getVseekBarRightLayout();
            this.p = dSMultipleToySeekBarControlView.getVseekBarRight();
            this.q = dSMultipleToySeekBarControlView.getVseekBarExpansionLayout();
            this.r = dSMultipleToySeekBarControlView.getVseekBarExpansion();
            this.n.setVSeekBar(PSOProgramService.VS_Key, ah4.e(R.string.toy_control_vibrate), getResources().getColor(R.color.buttom_select_background));
            this.n.setChangeListener(true, new b());
            this.m.setVisibility(0);
            this.n.e(this.p);
            this.n.e(this.r);
            this.n.setExpansionVseekBar(this.r);
        }
    }

    public void setWidget(MyApplication myApplication, CurveLineTimeView curveLineTimeView) {
        this.t = myApplication;
        this.u = curveLineTimeView;
    }

    public void t() {
        if (this.s == 0) {
            this.l.g();
        }
        this.l.h();
        if (this.s == 0) {
            this.n.j();
            this.m.setVisibility(8);
        }
        this.p.j();
        this.o.setVisibility(8);
        this.r.j();
        this.q.setVisibility(8);
    }

    public final List<Toy> u() throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList();
        ArrayList<Toy> arrayListP = this.t.G().P();
        if (arrayListP.size() == 2) {
            int[] toyFuncIcon = Toy.getToyFuncIcon(arrayListP.get(0).getType(), 2, 0, false);
            if (toyFuncIcon != null && toyFuncIcon.length == 1) {
                arrayList.add(arrayListP.get(0));
                C(arrayListP.get(0).getAddress(), Integer.valueOf(toyFuncIcon[0]));
                if (this.v) {
                    B(arrayListP.get(0).getAddress(), arrayListP.get(0).getName(), Integer.valueOf(R.color.buttom_select_background));
                }
            }
            int[] toyFuncIcon2 = Toy.getToyFuncIcon(arrayListP.get(1).getType(), 2, 1, false);
            if (toyFuncIcon2 != null && toyFuncIcon2.length == 1) {
                arrayList.add(arrayListP.get(1));
                E(arrayListP.get(1).getAddress(), Integer.valueOf(toyFuncIcon2[0]));
                if (this.v) {
                    D(arrayListP.get(1).getAddress(), arrayListP.get(1).getName(), Integer.valueOf(R.color.color_accent_second));
                }
            }
        } else if (arrayListP.size() == 1) {
            arrayList.add(arrayListP.get(0));
            y(arrayListP.get(0));
        }
        return arrayList;
    }

    public final void v() {
        this.l.setControlType(this.s);
        if (this.s == 1) {
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

    public final void w() {
        new d();
    }

    public void x() {
        this.n.setProgress(0);
        this.p.setProgress(0);
        this.r.setProgress(0);
        this.n.setPause(false);
        this.l.setPause(true);
        new Handler(Looper.getMainLooper()).postDelayed(new c(), 100L);
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
