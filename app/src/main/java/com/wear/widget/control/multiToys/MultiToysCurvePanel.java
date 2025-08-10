package com.wear.widget.control.multiToys;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import com.lovense.wear.R;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.controlmutlitoys.BaseBallBean;
import com.wear.bean.controlmutlitoys.ControlBallBean;
import com.wear.bean.controlmutlitoys.MultiToyOFunBean;
import com.wear.util.WearUtils;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.control.multiToys.MultiCurveLineView;
import dc.ek2;
import dc.uu1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes4.dex */
public class MultiToysCurvePanel extends RelativeLayout implements MultiControlPanel.t {
    public Context a;
    public LayoutInflater b;
    public NestedScrollView c;
    public LinearLayout d;
    public int e;
    public List<MultiToyOFunBean> f;
    public List<MultiToyOFunBean> g;
    public int h;
    public int i;
    public boolean j;
    public String k;
    public int l;
    public LinkedHashMap<String, MultiCurveLineView> m;
    public MultiCurveLineView.a n;
    public boolean o;
    public Pattern p;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            MultiToysCurvePanel.this.d.removeAllViews();
            if (MultiToysCurvePanel.this.f != null) {
                for (int i = 0; i < MultiToysCurvePanel.this.f.size(); i++) {
                    MultiToysCurvePanel multiToysCurvePanel = MultiToysCurvePanel.this;
                    multiToysCurvePanel.h((MultiToyOFunBean) multiToysCurvePanel.f.get(i), i);
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            MultiToysCurvePanel.this.d.removeAllViews();
            if (MultiToysCurvePanel.this.f != null) {
                for (int i = 0; i < MultiToysCurvePanel.this.f.size(); i++) {
                    MultiToysCurvePanel multiToysCurvePanel = MultiToysCurvePanel.this;
                    multiToysCurvePanel.h((MultiToyOFunBean) multiToysCurvePanel.f.get(i), i);
                }
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ d c;

        public c(List list, boolean z, d dVar) {
            this.a = list;
            this.b = z;
            this.c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            MultiToysCurvePanel.this.j(this.a, this.b);
            d dVar = this.c;
            if (dVar != null) {
                dVar.a(MultiToysCurvePanel.this.d.getChildCount(), MultiToysCurvePanel.this.i);
            }
        }
    }

    public interface d {
        void a(int i, int i2);
    }

    public MultiToysCurvePanel(Context context) {
        this(context, null);
    }

    public void A(List<MultiToyOFunBean> list) {
        boolean z;
        if (this.f.size() == 0) {
            this.g.clear();
        }
        Iterator<MultiToyOFunBean> it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().isFysModel()) {
                z = true;
                break;
            }
        }
        if (!z) {
            this.g.clear();
            Iterator<MultiToyOFunBean> it2 = this.f.iterator();
            while (it2.hasNext()) {
                this.g.add(it2.next());
            }
        }
        this.f.clear();
        B(list, false, false, null);
    }

    public void B(List<MultiToyOFunBean> list, boolean z, boolean z2, d dVar) {
        List<MultiToyOFunBean> list2 = this.f;
        if (list2 == null || list2.size() == 0) {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.addAll(list);
            this.d.removeAllViews();
            LinkedHashMap<String, MultiCurveLineView> linkedHashMap = this.m;
            if (linkedHashMap != null) {
                linkedHashMap.clear();
            }
            postDelayed(new b(), 10L);
            return;
        }
        ArrayList<MultiToyOFunBean> arrayList2 = new ArrayList();
        for (MultiToyOFunBean multiToyOFunBean : this.f) {
            boolean z3 = false;
            Iterator<MultiToyOFunBean> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MultiToyOFunBean next = it.next();
                if (multiToyOFunBean.isEqual(next.getToyAddress(), next.getFun())) {
                    z3 = true;
                    break;
                }
            }
            if (!z3) {
                arrayList2.add(multiToyOFunBean);
            }
        }
        for (MultiToyOFunBean multiToyOFunBean2 : arrayList2) {
            u(multiToyOFunBean2);
            Iterator<MultiToyOFunBean> it2 = this.f.iterator();
            while (true) {
                if (it2.hasNext()) {
                    MultiToyOFunBean next2 = it2.next();
                    if (multiToyOFunBean2.isEqual(next2.getToyAddress(), next2.getFun())) {
                        this.f.remove(next2);
                        break;
                    }
                }
            }
        }
        if (z) {
            postDelayed(new c(list, z2, dVar), 100L);
            return;
        }
        j(list, z2);
        if (dVar != null) {
            dVar.a(this.d.getChildCount(), this.i);
        }
    }

    public void C(String str, boolean z) {
        MultiCurveLineView multiCurveLineView;
        if (!this.m.containsKey(str)) {
            str = str.replace(SignatureImpl.INNER_SEP, "").toLowerCase();
        }
        if (!this.m.containsKey(str) || (multiCurveLineView = this.m.get(str)) == null) {
            return;
        }
        multiCurveLineView.a(!z);
    }

    public void a(MultiCurveLineView.a aVar) {
        this.n = aVar;
    }

    @Override // com.wear.widget.control.multiToys.MultiControlPanel.t
    public void c(List<ControlBallBean> list) {
        q(list);
    }

    public int getCurrentSelectedFunc() {
        return this.f.size();
    }

    public final void h(MultiToyOFunBean multiToyOFunBean, int i) throws Resources.NotFoundException {
        if (multiToyOFunBean == null) {
            return;
        }
        MultiCurveLineView multiCurveLineView = new MultiCurveLineView(this.a);
        if (this.l == 2) {
            multiCurveLineView.i();
        }
        MultiCurveLineView.a aVar = this.n;
        if (aVar != null) {
            multiCurveLineView.g(aVar);
        }
        multiCurveLineView.c(multiToyOFunBean);
        o(multiToyOFunBean, multiCurveLineView);
        this.d.addView(multiCurveLineView, i);
        if (this.m == null) {
            this.m = new LinkedHashMap<>();
        }
        this.m.put(multiToyOFunBean.getTag(), multiCurveLineView);
        k(true);
    }

    public final void i(MultiToyOFunBean multiToyOFunBean, boolean z) throws Resources.NotFoundException {
        MultiCurveLineView multiCurveLineView;
        if (this.m == null) {
            this.m = new LinkedHashMap<>();
        }
        if (this.m.containsKey(multiToyOFunBean.getTag())) {
            multiCurveLineView = this.m.get(multiToyOFunBean.getTag());
            if (multiCurveLineView == null) {
                this.m.remove(multiToyOFunBean.getTag());
            }
        } else {
            multiCurveLineView = null;
        }
        if (multiCurveLineView == null) {
            multiCurveLineView = new MultiCurveLineView(this.a);
            if (this.l == 2) {
                multiCurveLineView.i();
            }
            multiCurveLineView.c(multiToyOFunBean);
            o(multiToyOFunBean, multiCurveLineView);
        }
        MultiCurveLineView.a aVar = this.n;
        if (aVar != null) {
            multiCurveLineView.g(aVar);
        }
        if (uu1.g(multiToyOFunBean.getSymbol())) {
            multiCurveLineView.setModel(((multiToyOFunBean.isFunction() ? multiToyOFunBean.getFun() : multiToyOFunBean.getAllFun()).equals("pos") ? ek2.POSITION : ek2.SPEED).ordinal(), z, this.o);
        }
        this.d.addView(multiCurveLineView);
        if (!this.m.containsKey(multiToyOFunBean.getTag())) {
            this.m.put(multiToyOFunBean.getTag(), multiCurveLineView);
        }
        k(true);
    }

    public final void j(List<MultiToyOFunBean> list, boolean z) throws Resources.NotFoundException {
        this.d.removeAllViews();
        if (this.f == null || list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            i(list.get(i), z);
        }
        this.f.clear();
        this.f.addAll(list);
    }

    public final void k(boolean z) {
        int childCount = this.d.getChildCount();
        this.h = childCount;
        if (childCount <= 0) {
            return;
        }
        x();
    }

    public void l(Map<String, String> map) {
        for (String str : map.keySet()) {
            MultiCurveLineView multiCurveLineView = this.m.get(str);
            if (multiCurveLineView == null && str.contains(SignatureImpl.INNER_SEP)) {
                multiCurveLineView = this.m.get(str.replace(SignatureImpl.INNER_SEP, "").toLowerCase());
            }
            if (multiCurveLineView != null) {
                String str2 = map.get(str);
                if (!WearUtils.e1(str2)) {
                    multiCurveLineView.setBothLinePoint(str2);
                }
            }
        }
    }

    public final void m(Context context) {
        this.a = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.b = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_multi_curveline, this);
        this.c = (NestedScrollView) viewInflate.findViewById(R.id.multi_toys_layout_scrollview);
        this.d = (LinearLayout) viewInflate.findViewById(R.id.multi_toys_layout_content);
        this.m = new LinkedHashMap<>();
        this.f = new ArrayList();
    }

    public void n(String str, int i) {
        this.k = str;
        this.i = i;
        if (i < 0) {
            this.i = this.a.getResources().getDimensionPixelSize(R.dimen.mutli_toys_curve_item_height);
        }
        this.d.removeAllViews();
        if (this.m == null) {
            this.m = new LinkedHashMap<>();
        }
        if (this.f == null) {
            this.f = new ArrayList();
        }
    }

    public final void o(MultiToyOFunBean multiToyOFunBean, MultiCurveLineView multiCurveLineView) throws Resources.NotFoundException {
        if (uu1.g(multiToyOFunBean.getSymbol())) {
            String fun = multiToyOFunBean.isFunction() ? multiToyOFunBean.getFun() : multiToyOFunBean.getAllFun();
            if (TextUtils.isEmpty(fun) || !fun.equals("pos")) {
                multiCurveLineView.setModel(ek2.SPEED.ordinal(), false, this.o);
            } else {
                multiCurveLineView.setModel(ek2.POSITION.ordinal(), false, this.o);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.e = getHeight();
    }

    public final boolean p(String str) {
        if (this.p == null) {
            this.p = Pattern.compile("^[-\\+]?[\\d]*$");
        }
        return this.p.matcher(str).matches();
    }

    public final void q(List<ControlBallBean> list) {
        List<MultiToyOFunBean> list2;
        if (list == null || list.size() == 0 || (list2 = this.f) == null || list2.size() <= 0) {
            return;
        }
        int i = 0;
        boolean z = false;
        while (i < this.f.size()) {
            MultiToyOFunBean multiToyOFunBean = this.f.get(i);
            Iterator<ControlBallBean> it = list.iterator();
            while (it.hasNext()) {
                List<BaseBallBean> baseBallBeans = it.next().getBaseBallBeans();
                if (baseBallBeans != null && baseBallBeans.size() > 0) {
                    for (BaseBallBean baseBallBean : baseBallBeans) {
                        if ((!MultiControlPanel.A && multiToyOFunBean.getToyAddress().equals(baseBallBean.getToyAddress())) || (MultiControlPanel.A && multiToyOFunBean.getFun().equals(baseBallBean.getToyFun()))) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    break;
                }
            }
            if (z) {
                break;
            } else {
                i++;
            }
        }
        this.c.scrollTo(0, i * this.i);
    }

    public void r() {
        List<MultiToyOFunBean> list = this.f;
        if (list != null) {
            list.clear();
            this.f = null;
        }
    }

    public void s(List<Ball2CurveEventBean> list) {
        if (this.f == null || list == null) {
            return;
        }
        HashMap map = new HashMap();
        for (MultiToyOFunBean multiToyOFunBean : this.f) {
            map.put(multiToyOFunBean.getTag(), multiToyOFunBean.isFunction() ? multiToyOFunBean.getFun() : multiToyOFunBean.getAllFun());
        }
        for (Ball2CurveEventBean ball2CurveEventBean : list) {
            if (ball2CurveEventBean != null) {
                String function = ball2CurveEventBean.isFunction() ? ball2CurveEventBean.getFunction() : ball2CurveEventBean.getToyAddress();
                String str = (String) map.get(function);
                String function2 = ball2CurveEventBean.getFunction();
                String groups = ball2CurveEventBean.getGroups();
                if (!WearUtils.e1(str) && !WearUtils.e1(function2) && !WearUtils.e1(groups)) {
                    map.put(function, str.replace(function2, groups));
                }
            }
        }
        for (String str2 : map.keySet()) {
            String strReplace = (String) map.get(str2);
            if (!WearUtils.e1(strReplace)) {
                String[] strArrSplit = strReplace.split(",");
                boolean z = false;
                for (int i = 0; i < strArrSplit.length; i++) {
                    if (!p(strArrSplit[i])) {
                        strReplace = strReplace.replace(strArrSplit[i], "0");
                        z = true;
                    }
                }
                if (z) {
                    map.put(str2, strReplace);
                }
            }
        }
        for (String str3 : map.keySet()) {
            MultiCurveLineView multiCurveLineView = this.m.get(str3);
            if (multiCurveLineView != null) {
                String str4 = (String) map.get(str3);
                if (!WearUtils.e1(str4)) {
                    multiCurveLineView.setBothLinePoint(str4);
                }
            }
        }
    }

    public void setHiddenVelvoIcon(boolean z) {
        this.o = z;
    }

    public void setMultiToysCurveShowMode(Boolean bool) {
        this.j = bool.booleanValue();
        int childCount = this.d.getChildCount();
        this.h = childCount;
        if (childCount <= 0) {
            return;
        }
        x();
    }

    public void setPanelHeight(int i) {
        if (i <= 0) {
            return;
        }
        if (i > 3) {
            i = 3;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.height = i * this.i;
        this.d.setLayoutParams(layoutParams);
    }

    public void setStyle(int i) {
        this.l = i;
    }

    public void t() {
        boolean z;
        String str = "recoveryToyByFys: 恢复玩具" + this.f.size();
        Iterator<MultiToyOFunBean> it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().isFysModel()) {
                z = true;
                break;
            }
        }
        if (z) {
            this.f.clear();
            B(this.g, false, false, null);
        }
    }

    public final void u(MultiToyOFunBean multiToyOFunBean) {
        MultiCurveLineView multiCurveLineView;
        LinkedHashMap<String, MultiCurveLineView> linkedHashMap = this.m;
        if (linkedHashMap == null || (multiCurveLineView = linkedHashMap.get(multiToyOFunBean.getTag())) == null) {
            return;
        }
        this.d.removeView(multiCurveLineView);
        this.m.remove(multiToyOFunBean.getTag());
        k(false);
    }

    public void v() {
        Iterator<MultiCurveLineView> it = this.m.values().iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    public void w(List<MultiToyOFunBean> list) {
        LinkedHashMap<String, MultiCurveLineView> linkedHashMap = this.m;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        List<MultiToyOFunBean> list2 = this.f;
        if (list2 != null) {
            list2.clear();
            this.f.addAll(list);
        }
        postDelayed(new a(), 10L);
    }

    public final void x() {
        int i = this.i;
        int i2 = this.e;
        if (i2 > 0 && this.h <= 2) {
            i = i2 / 2;
        }
        if ("CHAT_SYNC_CONTROL".equals(this.k)) {
            i = (!this.j && this.h <= 2) ? this.i * 2 : this.i;
        } else if ("CHAT_LIVE_CONTROL".equals(this.k) || "CHAT_VIDEO_CONTROL".equals(this.k) || "CHAT_VOICE_CONTROL".equals(this.k) || "GROUP_CHAT_SYNC_CONTROL".equals(this.k) || "GROUP_CHAT_DS_CONTROL".equals(this.k)) {
            i = this.i;
        }
        for (int i3 = 0; i3 < this.h; i3++) {
            View childAt = this.d.getChildAt(i3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.height = i;
            childAt.setLayoutParams(layoutParams);
        }
    }

    public void y(List<MultiToyOFunBean> list) {
        this.g.clear();
        for (MultiToyOFunBean multiToyOFunBean : list) {
            multiToyOFunBean.setFysModel(false);
            this.g.add(multiToyOFunBean);
        }
    }

    public void z(String str, int i) {
        MultiCurveLineView multiCurveLineView;
        if (!this.m.containsKey(str)) {
            str = str.replace(SignatureImpl.INNER_SEP, "").toLowerCase();
        }
        if (!this.m.containsKey(str) || (multiCurveLineView = this.m.get(str)) == null) {
            return;
        }
        multiCurveLineView.k(i);
    }

    public MultiToysCurvePanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiToysCurvePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new ArrayList();
        this.o = false;
        m(context);
    }
}
