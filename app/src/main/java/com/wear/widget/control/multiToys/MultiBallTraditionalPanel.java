package com.wear.widget.control.multiToys;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.adapter.mutlitoys.MultiTradBallsAdapter;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.controlmutlitoys.BaseBallBean;
import com.wear.bean.controlmutlitoys.ControlBallBean;
import com.wear.util.WearUtils;
import dc.ce3;
import dc.cg3;
import dc.uu1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class MultiBallTraditionalPanel extends RelativeLayout {
    public static int h;
    public LayoutInflater a;
    public RecyclerView b;
    public List<ControlBallBean> c;
    public List<ControlBallBean> d;
    public MultiTradBallsAdapter e;
    public int f;
    public b g;

    public class a implements MultiTradBallsAdapter.b {
        public a() {
        }

        @Override // com.wear.adapter.mutlitoys.MultiTradBallsAdapter.b
        public void a(ControlBallBean controlBallBean, int i) {
            if (controlBallBean == null || WearUtils.e1(controlBallBean.getId()) || MultiBallTraditionalPanel.this.c == null) {
                return;
            }
            Iterator it = MultiBallTraditionalPanel.this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ControlBallBean controlBallBean2 = (ControlBallBean) it.next();
                if (controlBallBean.getId().equals(controlBallBean2.getId())) {
                    controlBallBean2.setProgress(i);
                    break;
                }
            }
            if (MultiBallTraditionalPanel.this.d.contains(controlBallBean)) {
                return;
            }
            MultiBallTraditionalPanel.this.d.add(controlBallBean);
            if (MultiBallTraditionalPanel.this.g != null) {
                MultiBallTraditionalPanel.this.g.c(MultiBallTraditionalPanel.this.d);
            }
        }

        @Override // com.wear.adapter.mutlitoys.MultiTradBallsAdapter.b
        public void b(ControlBallBean controlBallBean) {
            if (MultiBallTraditionalPanel.this.d.contains(controlBallBean)) {
                MultiBallTraditionalPanel.this.d.remove(controlBallBean);
                if (MultiBallTraditionalPanel.this.g != null) {
                    MultiBallTraditionalPanel.this.g.c(MultiBallTraditionalPanel.this.d);
                }
            }
        }
    }

    public interface b {
        void b(List<BaseBallBean> list);

        void c(List<ControlBallBean> list);

        void d();
    }

    public MultiBallTraditionalPanel(Context context) {
        this(context, null);
    }

    public void d(BaseBallBean baseBallBean, boolean z) {
        if (baseBallBean.isSelected()) {
            if (this.c == null) {
                this.c = Collections.synchronizedList(new ArrayList());
            }
            ControlBallBean controlBallBean = new ControlBallBean();
            controlBallBean.getBaseBallBeans().add(baseBallBean);
            this.c.add(controlBallBean);
            e(this.c.size());
            this.e.A(this.c);
            if (z) {
                return;
            }
            this.b.scrollToPosition(this.c.size() - 1);
        }
    }

    public final void e(int i) {
        int dimensionPixelSize = (getResources().getDimensionPixelSize(R.dimen.mutli_toys_trad_seekbar_width) * i) + (i == 2 ? h : 0);
        int i2 = this.f;
        if (dimensionPixelSize > i2) {
            dimensionPixelSize = i2;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.leftMargin = (i2 - dimensionPixelSize) / 2;
        this.b.setLayoutParams(layoutParams);
    }

    public void f(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.layout_multi_traditional_panel, (ViewGroup) null);
        addView(viewInflate);
        this.b = (RecyclerView) viewInflate.findViewById(R.id.layout_traditional_recyclerview);
    }

    public void g() {
        this.c = Collections.synchronizedList(new ArrayList());
        this.d = new ArrayList();
        int iA = ce3.a(getContext(), 43.5f);
        h = iA;
        MultiTradBallsAdapter multiTradBallsAdapter = new MultiTradBallsAdapter(this.c, R.layout.item_mutli_toys_trad_ball, iA);
        this.e = multiTradBallsAdapter;
        cg3.d(this.b, multiTradBallsAdapter);
        this.e.B(new a());
    }

    public List<Ball2CurveEventBean> getBall2CurveEventBeans() {
        ArrayList arrayList = new ArrayList();
        if (!this.c.isEmpty()) {
            for (ControlBallBean controlBallBean : this.c) {
                List<BaseBallBean> baseBallBeans = controlBallBean.getBaseBallBeans();
                String strValueOf = (controlBallBean.getProgress() <= 0 || controlBallBean.getProgress() >= 5) ? String.valueOf((controlBallBean.getProgress() / 5) * 5) : "5";
                for (BaseBallBean baseBallBean : baseBallBeans) {
                    if (baseBallBean.getToyFun().equals("p") && controlBallBean.getProgress() > 0 && controlBallBean.getProgress() < 33) {
                        strValueOf = "35";
                    }
                    Ball2CurveEventBean ball2CurveEventBean = new Ball2CurveEventBean(baseBallBean.getToyAddress(), baseBallBean.getToyFun(), strValueOf);
                    ball2CurveEventBean.setSymbol(baseBallBean.getSymbol());
                    arrayList.add(ball2CurveEventBean);
                }
            }
        }
        return arrayList;
    }

    public List<ControlBallBean> getCopyListBalls() {
        return WearUtils.x(this.c);
    }

    public List<ControlBallBean> getListBalls() {
        return this.c;
    }

    public void h() {
        List<ControlBallBean> list = this.c;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.c.clear();
        e(this.c.size());
        this.e.A(this.c);
    }

    public void i(BaseBallBean baseBallBean) {
        List<ControlBallBean> list = this.c;
        if (list == null || list.size() == 0) {
            return;
        }
        boolean zIsFunction = baseBallBean.isFunction();
        List<ControlBallBean> list2 = this.c;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (ControlBallBean controlBallBean : this.c) {
            List<BaseBallBean> baseBallBeans = controlBallBean.getBaseBallBeans();
            if (baseBallBeans != null && baseBallBeans.size() > 0) {
                for (BaseBallBean baseBallBean2 : baseBallBeans) {
                    if ((zIsFunction && baseBallBean2.getToyFun().equals(baseBallBean.getToyFun())) || (!zIsFunction && baseBallBean2.getToyAddress().equals(baseBallBean.getToyAddress()) && baseBallBean2.getToyFun().equals(baseBallBean.getToyFun()))) {
                        baseBallBeans.remove(baseBallBean2);
                        if (baseBallBeans.size() == 0) {
                            this.c.remove(controlBallBean);
                        }
                        e(this.c.size());
                        this.e.A(this.c);
                        return;
                    }
                }
            }
        }
    }

    public void j(@NonNull List<BaseBallBean> list) {
        boolean z;
        if (list == null) {
            return;
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        if (this.c.size() > 0) {
            Iterator<ControlBallBean> it = this.c.iterator();
            while (it.hasNext()) {
                for (BaseBallBean baseBallBean : it.next().getBaseBallBeans()) {
                    Iterator<BaseBallBean> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        BaseBallBean next = it2.next();
                        if (baseBallBean.isEqual(MultiControlPanel.A, next.getToyAddress(), next.getToyFun())) {
                            map.put(baseBallBean, next);
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        arrayList.add(baseBallBean);
                    }
                }
            }
        }
        if (list.size() > 0) {
            for (BaseBallBean baseBallBean2 : list) {
                Iterator<ControlBallBean> it3 = this.c.iterator();
                boolean z2 = false;
                while (it3.hasNext()) {
                    Iterator<BaseBallBean> it4 = it3.next().getBaseBallBeans().iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            BaseBallBean next2 = it4.next();
                            if (baseBallBean2.isEqual(MultiControlPanel.A, next2.getToyAddress(), next2.getToyFun())) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                }
                if (!z2) {
                    arrayList2.add(baseBallBean2);
                }
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            i((BaseBallBean) it5.next());
        }
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            d((BaseBallBean) it6.next(), false);
        }
        for (BaseBallBean baseBallBean3 : map.keySet()) {
            BaseBallBean baseBallBean4 = (BaseBallBean) map.get(baseBallBean3);
            if (baseBallBean4 != null) {
                k(baseBallBean3, baseBallBean4);
            }
        }
        l(list);
    }

    public final void k(BaseBallBean baseBallBean, BaseBallBean baseBallBean2) {
        List<ControlBallBean> list;
        String toyFun = baseBallBean.getToyFun();
        String toyFun2 = baseBallBean2.getToyFun();
        if (toyFun == null || toyFun2 == null) {
            return;
        }
        if (toyFun.equals("t") || toyFun.equals("pos")) {
            if ((!toyFun2.equals("t") && !toyFun2.equals("pos")) || (list = this.c) == null || list.size() == 0) {
                return;
            }
            ControlBallBean controlBallBean = null;
            for (ControlBallBean controlBallBean2 : this.c) {
                Iterator<BaseBallBean> it = controlBallBean2.getBaseBallBeans().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BaseBallBean next = it.next();
                    if (next == baseBallBean) {
                        if (uu1.g(next.getSymbol())) {
                            controlBallBean2.setProgress(0);
                        }
                        controlBallBean = controlBallBean2;
                    }
                }
            }
            if (controlBallBean == null) {
                return;
            }
            List<BaseBallBean> baseBallBeans = controlBallBean.getBaseBallBeans();
            baseBallBeans.remove(baseBallBean);
            baseBallBeans.add(baseBallBean2);
            int iIndexOf = this.c.indexOf(controlBallBean);
            if (iIndexOf == -1) {
                return;
            }
            this.e.notifyItemChanged(iIndexOf);
        }
    }

    public final void l(@NonNull List<BaseBallBean> list) {
        this.g.b(list);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (motionEvent.getAction() == 0 && (bVar = this.g) != null) {
            bVar.d();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAllProgress(int i) {
        List<ControlBallBean> list = this.c;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<ControlBallBean> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().setProgress(i);
        }
        this.e.A(this.c);
    }

    public void setDatas(@NonNull List<ControlBallBean> list) {
        if (list == null) {
            return;
        }
        List<ControlBallBean> list2 = this.c;
        if (list2 != null) {
            WearUtils.A.toJson(list2).equals(WearUtils.A.toJson(list));
            this.c.clear();
        } else {
            this.c = Collections.synchronizedList(new ArrayList());
        }
        this.c.addAll(WearUtils.x(list));
        for (ControlBallBean controlBallBean : this.c) {
            if (controlBallBean.getDatas() != null) {
                controlBallBean.getDatas().clear();
            }
            controlBallBean.setLooping(false);
            controlBallBean.setLoopIndex(0);
            if (controlBallBean.getControlMode() != 1) {
                controlBallBean.setControlMode(0);
                controlBallBean.setProgress(0);
            }
        }
        this.f = (getWidth() - getPaddingLeft()) - getPaddingRight();
        e(this.c.size());
        this.e.A(this.c);
    }

    public void setTradOnTouchListener(b bVar) {
        this.g = bVar;
    }

    public MultiBallTraditionalPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiBallTraditionalPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        new HashMap();
        f(context);
    }
}
