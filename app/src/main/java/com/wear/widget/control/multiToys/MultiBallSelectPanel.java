package com.wear.widget.control.multiToys;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lovense.wear.R;
import com.wear.adapter.mutlitoys.MutliSelectAdapter;
import com.wear.bean.Toy;
import com.wear.bean.controlmutlitoys.BaseBallBean;
import com.wear.bean.controlmutlitoys.MultiToyOFunBean;
import com.wear.bean.socketio.msg.response.DSMultiToySelectChangeResponse;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.cg3;
import dc.ek2;
import dc.fk2;
import dc.qa2;
import dc.th4;
import dc.uu1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes4.dex */
public class MultiBallSelectPanel extends RelativeLayout implements MutliSelectAdapter.a {
    public TextView a;
    public View b;
    public View c;
    public TextView d;
    public ConstraintLayout e;
    public RelativeLayout f;
    public Context g;
    public LayoutInflater h;
    public RelativeLayout i;
    public RecyclerView j;
    public List<MultiToyOFunBean> k;
    public List<MultiToyOFunBean> l;
    public boolean m;
    public List<BaseBallBean> n;
    public List<BaseBallBean> o;
    public MutliSelectAdapter p;
    public int q;
    public int r;
    public int s;
    public String t;
    public boolean u;
    public b v;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiBallSelectPanel multiBallSelectPanel = MultiBallSelectPanel.this;
            multiBallSelectPanel.r(multiBallSelectPanel.n.size() != MultiBallSelectPanel.this.q);
        }
    }

    public interface b {
        void b(String str);

        void d(List<MultiToyOFunBean> list, boolean z);

        void f(List<BaseBallBean> list, List<MultiToyOFunBean> list2);

        void i(@NonNull List<BaseBallBean> list);

        void j(List<MultiToyOFunBean> list);

        void k(List<BaseBallBean> list);

        void m(BaseBallBean baseBallBean, boolean z);

        void n(boolean z, boolean z2);

        void q(List<BaseBallBean> list);

        void t(List<MultiToyOFunBean> list, boolean z);
    }

    public MultiBallSelectPanel(Context context) {
        this(context, null);
    }

    private String getConnectToyCountTip() {
        return this.s == 1 ? String.format(ah4.e(R.string.control_panel_toy_connected), Integer.valueOf(this.s)) : String.format(ah4.e(R.string.control_panel_toys_connected), Integer.valueOf(this.s));
    }

    @NonNull
    public static String h(boolean z) {
        return z ? "t" : "pos";
    }

    public void A(@NonNull List<Toy> list, boolean z, boolean z2, boolean z3) {
        List<MultiToyOFunBean> list2;
        List<BaseBallBean> list3 = this.o;
        if (list3 == null) {
            this.o = new ArrayList();
        } else {
            list3.clear();
        }
        List<BaseBallBean> list4 = this.n;
        if (list4 != null) {
            this.o.addAll(list4);
        }
        List<MultiToyOFunBean> listN = n(list, z3);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.q = 0;
        ArrayList arrayList3 = new ArrayList();
        for (BaseBallBean baseBallBean : this.o) {
            if (baseBallBean.isSelected()) {
                arrayList3.add(baseBallBean.getToyAddress() + ContainerUtils.FIELD_DELIMITER + baseBallBean.getToyFun());
            }
        }
        for (MultiToyOFunBean multiToyOFunBean : listN) {
            if (u(multiToyOFunBean, arrayList2, false, z, arrayList3)) {
                arrayList.add(multiToyOFunBean);
            }
        }
        if (this.v != null) {
            ArrayList arrayList4 = new ArrayList();
            for (BaseBallBean baseBallBean2 : arrayList2) {
                if (baseBallBean2.isSelected()) {
                    arrayList4.add(baseBallBean2);
                }
            }
            this.v.k(arrayList4);
            this.v.t(arrayList, z2);
        }
        List<MultiToyOFunBean> list5 = this.k;
        if (list5 == null) {
            this.k = new ArrayList();
        } else {
            list5.clear();
        }
        this.k.addAll(listN);
        List<MultiToyOFunBean> list6 = this.l;
        if (list6 == null) {
            this.l = new ArrayList();
        } else {
            list6.clear();
        }
        this.l.addAll(arrayList);
        List<BaseBallBean> list7 = this.n;
        if (list7 == null) {
            this.n = new ArrayList();
        } else {
            list7.clear();
        }
        this.n.addAll(arrayList2);
        MutliSelectAdapter mutliSelectAdapter = this.p;
        if (mutliSelectAdapter != null && (list2 = this.k) != null) {
            mutliSelectAdapter.X(list2);
        }
        i();
    }

    @Override // com.wear.adapter.mutlitoys.MutliSelectAdapter.a
    public boolean a(@NonNull String str, @NonNull String str2, boolean z) {
        if (z) {
            for (BaseBallBean baseBallBean : this.n) {
                if (baseBallBean.isEqual(str, str2)) {
                    return baseBallBean.isSelected();
                }
            }
            return false;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (BaseBallBean baseBallBean2 : this.n) {
            if (baseBallBean2.isEqual(str, str2)) {
                z2 = !baseBallBean2.isSelected();
                baseBallBean2.setSelected(z2);
                b bVar = this.v;
                if (bVar != null) {
                    bVar.m(baseBallBean2, false);
                }
            }
            if (baseBallBean2.isSelected() && ((!this.m && !arrayList.contains(baseBallBean2.getToyAddress())) || (this.m && !arrayList.contains(baseBallBean2.getToyFun())))) {
                if (this.m) {
                    arrayList.add(baseBallBean2.getToyFun());
                } else {
                    arrayList.add(baseBallBean2.getToyAddress());
                }
            }
        }
        if (arrayList.size() != this.l.size()) {
            this.l.clear();
            for (MultiToyOFunBean multiToyOFunBean : this.k) {
                if ((!this.m && arrayList.contains(multiToyOFunBean.getToyAddress())) || (this.m && arrayList.contains(multiToyOFunBean.getFun()))) {
                    this.l.add(multiToyOFunBean);
                }
            }
            b bVar2 = this.v;
            if (bVar2 != null) {
                bVar2.d(this.l, false);
            }
        }
        f(z2, str, str2);
        if (z2) {
            this.q++;
        } else {
            this.q--;
        }
        return z2;
    }

    @Override // com.wear.adapter.mutlitoys.MutliSelectAdapter.a
    public void b(String str) {
        b bVar = this.v;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(boolean r8, java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.multiToys.MultiBallSelectPanel.f(boolean, java.lang.String, java.lang.String):void");
    }

    public void g(boolean z, @NonNull List<Toy> list) {
        this.m = z;
        this.n.clear();
        this.k = n(list, false);
        q();
    }

    public List<BaseBallBean> getBaseBalls() {
        return this.n;
    }

    public List<MultiToyOFunBean> getListConnectToyOFuns() {
        return this.k;
    }

    public List<MultiToyOFunBean> getListSelectedToyOFuns() {
        return this.l;
    }

    public final void i() throws Resources.NotFoundException {
        ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
        int dimensionPixelSize = (((this.g.getResources().getDimensionPixelSize(R.dimen.mutli_toys_select_item_height) * ((int) Math.ceil(this.k.size() / 2))) + this.g.getResources().getDimensionPixelSize(R.dimen.mutli_toys_select_uman_height)) - this.g.getResources().getDimensionPixelSize(R.dimen.mutli_toys_select_uman_height_marbottom)) + this.g.getResources().getDimensionPixelSize(R.dimen.mutli_toys_select_padding_top);
        if (dimensionPixelSize < this.g.getResources().getDimensionPixelSize(R.dimen.mutli_toys_select_uman_height)) {
            dimensionPixelSize = this.g.getResources().getDimensionPixelSize(R.dimen.mutli_toys_select_uman_height);
        }
        layoutParams.height = dimensionPixelSize;
        this.i.setLayoutParams(layoutParams);
        this.a.setText(getConnectToyCountTip());
    }

    @NonNull
    public final String j(Toy toy, boolean z) {
        if (qa2.a() || z) {
            return "t";
        }
        if (TextUtils.isEmpty(toy.getWorkMode())) {
            return h(fk2.a.c(toy.getAddress()) == ek2.SPEED);
        }
        return h(toy.getWorkMode() != null && toy.getWorkMode().equals(ek2.SPEED.name().toLowerCase()));
    }

    public String k() {
        List<BaseBallBean> list = this.n;
        if (list != null && list.size() != 0) {
            for (BaseBallBean baseBallBean : this.n) {
                if (uu1.g(baseBallBean.getSymbol()) && baseBallBean.getToyFun().equals("pos") && baseBallBean.isSelected()) {
                    return baseBallBean.getToyAddress();
                }
            }
        }
        return null;
    }

    public void l(Context context) {
        this.g = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.h = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_multi_select_toys, (ViewGroup) null);
        this.i = (RelativeLayout) viewInflate.findViewById(R.id.multi_select_slid_layout_uman);
        this.j = (RecyclerView) viewInflate.findViewById(R.id.multi_select_toys_rcv);
        this.a = (TextView) viewInflate.findViewById(R.id.multi_select_toys_nums);
        this.b = viewInflate.findViewById(R.id.multi_select_toys_btn_line);
        this.c = viewInflate.findViewById(R.id.multi_select_toys_btn_rorect);
        this.d = (TextView) viewInflate.findViewById(R.id.tip);
        this.f = (RelativeLayout) viewInflate.findViewById(R.id.slide_top_panel);
        this.e = (ConstraintLayout) viewInflate.findViewById(R.id.linear_text_tip);
        addView(viewInflate);
    }

    public final void m() throws Resources.NotFoundException {
        this.l = new ArrayList();
        this.n = new ArrayList();
        List<MultiToyOFunBean> list = this.k;
        if (list != null) {
            this.q = 0;
            for (MultiToyOFunBean multiToyOFunBean : list) {
                if (u(multiToyOFunBean, this.n, true, false, null)) {
                    this.l.add(multiToyOFunBean);
                }
            }
            if (this.n.size() > this.r) {
                r(true);
            } else {
                r(false);
            }
            MutliSelectAdapter mutliSelectAdapter = new MutliSelectAdapter(this.k, R.layout.item_mutli_toys_select);
            this.p = mutliSelectAdapter;
            mutliSelectAdapter.Y(this);
            cg3.c(this.j, this.p, 2);
            i();
            if (this.v != null) {
                ArrayList arrayList = new ArrayList();
                for (BaseBallBean baseBallBean : this.n) {
                    if (baseBallBean.isSelected()) {
                        arrayList.add(baseBallBean);
                    }
                }
                this.v.i(arrayList);
                this.v.d(this.l, true);
            }
        }
    }

    public final List<MultiToyOFunBean> n(@NonNull List<Toy> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.s = list.size();
        int i = 0;
        if (this.m) {
            ArrayList arrayList2 = new ArrayList();
            for (Toy toy : list) {
                String toyFunction = Toy.getToyFunction(toy.getType());
                if (("v1,v2".equals(toyFunction) || "v1,v2,v3".equals(toyFunction)) && !this.t.equals("CREATE_PATTERN")) {
                    toyFunction = PSOProgramService.VS_Key;
                }
                if (toy.isF01Toy()) {
                    toyFunction = "t";
                }
                if (toyFunction.contains("s") && !toyFunction.contains("pos")) {
                    toyFunction = "s";
                }
                if (toyFunction.contains("f") && !this.t.equals("CREATE_PATTERN")) {
                    toyFunction = "v,f";
                }
                if (toy.isBAToy()) {
                    toyFunction = j(toy, z);
                }
                if (!WearUtils.e1(toyFunction)) {
                    String[] strArrSplit = toyFunction.split(",");
                    if (strArrSplit.length > 0) {
                        for (String str : strArrSplit) {
                            if (!arrayList2.contains(str)) {
                                String nameByFun = Toy.getNameByFun(str);
                                if ("CREATE_PATTERN".equals(this.t) && toy.isF01Toy()) {
                                    nameByFun = ah4.e(R.string.toy_function_thrust_speed);
                                }
                                MultiToyOFunBean multiToyOFunBean = new MultiToyOFunBean(this.m, nameByFun, str, "", 0, true, toy.isF01Toy(), toy.getToySymbol());
                                multiToyOFunBean.setToyName(toy.getName());
                                arrayList.add(multiToyOFunBean);
                                arrayList2.add(str);
                            }
                        }
                    }
                }
            }
        } else {
            for (Toy toy2 : list) {
                String address = toy2.getAddress();
                if ("GROUP_CHAT_DS_CONTROL".equals(this.t) || WearUtils.e1(address)) {
                    address = toy2.getDeviceId();
                }
                String str2 = address;
                if (!WearUtils.e1(str2)) {
                    int battery = (toy2.isF01Toy() || Toy.TOY_XMACHINE.equalsIgnoreCase(toy2.getName()) || Toy.TOY_XMACHINE.equalsIgnoreCase(toy2.getSimpleType())) ? -1 : toy2.getBattery();
                    String toyFunction2 = Toy.getToyFunction(toy2.getType());
                    if (!this.m && toy2.isF01Toy()) {
                        toyFunction2 = toyFunction2.substring(i, toyFunction2.indexOf(","));
                    }
                    if (!this.m && toyFunction2.contains("s") && !toyFunction2.contains("pos")) {
                        toyFunction2 = "s";
                    }
                    if (toy2.isBAToy()) {
                        toyFunction2 = j(toy2, z);
                    }
                    MultiToyOFunBean multiToyOFunBean2 = new MultiToyOFunBean(this.m, toy2.getSimpleName(), toyFunction2, str2, battery, toy2.getStatus() == 1, toy2.isF01Toy(), toy2.getToySymbol());
                    multiToyOFunBean2.setToyName(toy2.getName());
                    arrayList.add(multiToyOFunBean2);
                    i = 0;
                }
            }
        }
        return arrayList;
    }

    public void o() {
    }

    public void p(b bVar) {
        this.v = bVar;
    }

    public void q() {
        List<MultiToyOFunBean> list = this.l;
        if (list != null) {
            list.clear();
        }
        List<BaseBallBean> list2 = this.n;
        if (list2 != null) {
            list2.clear();
        }
        List<MultiToyOFunBean> list3 = this.k;
        if (list3 != null) {
            this.q = 0;
            for (MultiToyOFunBean multiToyOFunBean : list3) {
                if (u(multiToyOFunBean, this.n, true, false, null)) {
                    this.l.add(multiToyOFunBean);
                }
            }
            MutliSelectAdapter mutliSelectAdapter = this.p;
            if (mutliSelectAdapter != null) {
                mutliSelectAdapter.notifyDataSetChanged();
            }
        }
        if (this.v != null) {
            ArrayList arrayList = new ArrayList();
            for (BaseBallBean baseBallBean : this.n) {
                if (baseBallBean.isSelected()) {
                    arrayList.add(baseBallBean);
                }
            }
            this.v.f(arrayList, this.l);
        }
    }

    public final void r(boolean z) {
        b bVar = this.v;
        if (bVar != null) {
            bVar.n(z, false);
        }
        t(z);
    }

    public void s(boolean z) {
        if (z) {
            if (this.a.getVisibility() != 8) {
                this.a.setVisibility(8);
                this.j.setVisibility(0);
                t(true);
                return;
            }
            return;
        }
        if (this.a.getVisibility() != 0) {
            this.a.setVisibility(0);
            this.j.setVisibility(4);
            t(false);
        }
    }

    public void setBackground(int i) {
        this.i.setBackgroundResource(th4.b(getContext(), R.color.transparent));
        this.a.setBackgroundResource(th4.b(getContext(), R.color.transparent));
        this.b.setBackgroundResource(R.color.multi_toys_select_line_dark);
        this.b.setBackgroundColor(th4.b(getContext(), R.color.multi_toys_select_line_dark));
        try {
            GradientDrawable gradientDrawable = (GradientDrawable) this.c.getBackground();
            gradientDrawable.setColor(th4.b(getContext(), R.color.multi_toys_select_rect_dark));
            this.c.setBackground(gradientDrawable);
        } catch (Exception unused) {
        }
    }

    public void setControlLink(boolean z) {
        this.u = z;
    }

    public void setControlPanelType(String str) {
        this.t = str;
    }

    public void setListConnectToys(@NonNull List<Toy> list, boolean z, int i) {
        if (list != null) {
            this.m = z;
            this.r = i;
            this.k = n(list, false);
            m();
        }
    }

    public void setSlideTopPanelVisibility(int i) {
        this.f.setVisibility(i);
    }

    public final void t(boolean z) {
        if ("CHAT_VIDEO_CONTROL".equals(this.t) || "CHAT_VOICE_CONTROL".equals(this.t)) {
            this.i.setBackgroundColor(th4.b(getContext(), z ? R.color.multi_toys_select_toyrcv_bg : R.color.transparent));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean u(com.wear.bean.controlmutlitoys.MultiToyOFunBean r18, java.util.List<com.wear.bean.controlmutlitoys.BaseBallBean> r19, boolean r20, boolean r21, java.util.List<java.lang.String> r22) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.multiToys.MultiBallSelectPanel.u(com.wear.bean.controlmutlitoys.MultiToyOFunBean, java.util.List, boolean, boolean, java.util.List):boolean");
    }

    public void v(int i) {
        this.r = i;
    }

    public void w(@NonNull List<DSMultiToySelectChangeResponse.BallSelectBean> list) {
        boolean z;
        if (this.v != null) {
            for (BaseBallBean baseBallBean : this.n) {
                for (DSMultiToySelectChangeResponse.BallSelectBean ballSelectBean : list) {
                    if ((!MultiControlPanel.A && baseBallBean.getToyAddress().equals(ballSelectBean.getDeviceId()) && baseBallBean.getToyFun().equals(ballSelectBean.getFun())) || (MultiControlPanel.A && baseBallBean.getToyFun().equals(ballSelectBean.getFun()))) {
                        baseBallBean.setSelected(ballSelectBean.getIsSelect() == 1);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (BaseBallBean baseBallBean2 : this.n) {
                if (baseBallBean2.isSelected()) {
                    arrayList.add(baseBallBean2);
                }
            }
            this.v.k(arrayList);
            ArrayList arrayList2 = new ArrayList();
            List<MultiToyOFunBean> list2 = this.k;
            if (list2 != null && list2.size() > 0) {
                for (int i = 0; i < this.k.size(); i++) {
                    MultiToyOFunBean multiToyOFunBean = this.k.get(i);
                    Iterator<BaseBallBean> it = this.n.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        BaseBallBean next = it.next();
                        if ((!MultiControlPanel.A && multiToyOFunBean.getToyAddress().equals(next.getToyAddress())) || (MultiControlPanel.A && multiToyOFunBean.getFun().equals(next.getToyFun()))) {
                            if (next.isSelected()) {
                                z = true;
                                break;
                            }
                        }
                    }
                    if (z) {
                        arrayList2.add(multiToyOFunBean);
                    }
                }
            }
            this.v.t(arrayList2, false);
            this.l.clear();
            this.l.addAll(arrayList2);
        }
    }

    public void x(@NonNull String str, int i) {
        if (str != null) {
            String lowerCase = str.contains(SignatureImpl.INNER_SEP) ? str.replace(SignatureImpl.INNER_SEP, "").toLowerCase() : null;
            List<MultiToyOFunBean> list = this.k;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (MultiToyOFunBean multiToyOFunBean : this.k) {
                if (multiToyOFunBean.getToyAddress().equals(str) || multiToyOFunBean.getToyAddress().equals(lowerCase)) {
                    multiToyOFunBean.setBattery(i);
                    return;
                }
            }
        }
    }

    public void y(@NonNull String str, boolean z) {
        if (str != null) {
            String lowerCase = str.contains(SignatureImpl.INNER_SEP) ? str.replace(SignatureImpl.INNER_SEP, "").toLowerCase() : null;
            List<MultiToyOFunBean> list = this.k;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (MultiToyOFunBean multiToyOFunBean : this.k) {
                if (multiToyOFunBean.getToyAddress().equals(str) || multiToyOFunBean.getToyAddress().equals(lowerCase)) {
                    multiToyOFunBean.setConnected(z);
                    this.p.notifyItemChanged(this.k.indexOf(multiToyOFunBean));
                    return;
                }
            }
        }
    }

    public void z(List<Toy> list, boolean z, boolean z2, int i) {
        boolean z3;
        b bVar;
        boolean z4;
        List<MultiToyOFunBean> listN = n(list, z2);
        ArrayList<MultiToyOFunBean> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<MultiToyOFunBean> it = listN.iterator();
        while (true) {
            boolean z5 = false;
            if (!it.hasNext()) {
                break;
            }
            MultiToyOFunBean next = it.next();
            next.setFysModel(z2);
            Iterator<MultiToyOFunBean> it2 = this.k.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (next.isEqual(it2.next().getToyAddress(), "")) {
                        break;
                    }
                } else {
                    z5 = true;
                    break;
                }
            }
            if (z5) {
                arrayList.add(next);
            }
        }
        for (MultiToyOFunBean multiToyOFunBean : this.k) {
            Iterator<MultiToyOFunBean> it3 = listN.iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (multiToyOFunBean.isEqual(it3.next().getToyAddress(), "")) {
                        z4 = false;
                        break;
                    }
                } else {
                    z4 = true;
                    break;
                }
            }
            if (z4) {
                arrayList3.add(multiToyOFunBean);
                for (BaseBallBean baseBallBean : this.n) {
                    if (TextUtils.equals(baseBallBean.getToyAddress(), multiToyOFunBean.getToyAddress())) {
                        arrayList2.add(baseBallBean);
                        if (baseBallBean.isSelected()) {
                            this.q--;
                        }
                    }
                }
            }
        }
        if (arrayList3.isEmpty() || i != 1) {
            z3 = false;
        } else {
            this.k.removeAll(arrayList3);
            this.l.removeAll(arrayList3);
            this.n.removeAll(arrayList2);
            z3 = true;
        }
        if (!arrayList.isEmpty()) {
            this.k.addAll(arrayList);
            ArrayList arrayList4 = new ArrayList();
            if (i == 2) {
                arrayList4.add("");
            }
            for (MultiToyOFunBean multiToyOFunBean2 : arrayList) {
                if (u(multiToyOFunBean2, this.n, false, z, arrayList4) && i == 1) {
                    this.l.add(multiToyOFunBean2);
                }
            }
            z3 = true;
        }
        if ((!arrayList3.isEmpty() || !arrayList.isEmpty()) && i == 1 && (bVar = this.v) != null) {
            if (z2) {
                bVar.j(this.l);
            } else {
                bVar.t(this.l, false);
            }
            this.v.q(this.n);
        }
        if (z3) {
            this.p.X(this.k);
            i();
        }
        if (i != 1 || z2) {
            return;
        }
        postDelayed(new a(), 100L);
    }

    public MultiBallSelectPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiBallSelectPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        l(context);
    }
}
