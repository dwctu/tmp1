package com.wear.adapter.toy;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.adapter.toy.ToyRecyclerViewAdapter;
import com.wear.bean.Toy;
import com.wear.bean.ToyAddBean;
import com.wear.bean.ToySelectEvent;
import com.wear.bean.event.ToyAddClickEvent;
import com.wear.main.toy.ToyActivity;
import com.wear.main.toy.ToySettingActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.ConnectingTipDialog;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.be3;
import dc.ce3;
import dc.ds3;
import dc.es3;
import dc.lp1;
import dc.ls3;
import dc.og3;
import dc.pc1;
import dc.pj3;
import dc.sg3;
import dc.th4;
import dc.xb1;
import dc.yb1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public class ToyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final MyApplication b;
    public pc1 c;
    public ToyActivity d;
    public b f;
    public List<Object> a = new ArrayList();
    public final ToyAddBean e = new ToyAddBean();
    public final HashMap<String, ToyHolder> g = new HashMap<>();

    public static class ToyHolder extends RecyclerView.ViewHolder {
        public ImageView A;
        public String B;
        public String a;
        public ImageView b;
        public View c;
        public ImageView d;
        public ImageView e;
        public TextView f;
        public ImageView g;
        public TextView h;
        public SwitchView i;
        public TextView j;
        public LinearLayout k;
        public TextView l;
        public TextView m;
        public LinearLayout n;
        public TextView o;
        public TextView p;
        public LinearLayout q;
        public View r;
        public LinearLayout s;
        public ImageView t;
        public ImageView u;
        public TextView v;
        public TextView w;
        public SkinCompatConstraintLayout x;
        public TextView y;
        public TextView z;

        public ToyHolder(@NonNull View view) {
            super(view);
            this.b = (ImageView) view.findViewById(R.id.toy_img);
            this.c = view.findViewById(R.id.toy_search_item);
            this.d = (ImageView) view.findViewById(R.id.toy_battery_img);
            this.f = (TextView) view.findViewById(R.id.toy_status);
            this.g = (ImageView) view.findViewById(R.id.toy_connecting_tip);
            this.h = (TextView) view.findViewById(R.id.toy_name);
            this.i = (SwitchView) view.findViewById(R.id.toy_item_select_switch);
            this.j = (TextView) view.findViewById(R.id.toy_update);
            this.e = (ImageView) view.findViewById(R.id.toy_rssi_img);
            this.v = (TextView) view.findViewById(R.id.toy_ready);
            this.s = (LinearLayout) view.findViewById(R.id.ll_connected);
            this.k = (LinearLayout) view.findViewById(R.id.ll_connected_show);
            this.n = (LinearLayout) view.findViewById(R.id.ll_connecting_show);
            this.l = (TextView) view.findViewById(R.id.tv_connect_scan_start);
            this.m = (TextView) view.findViewById(R.id.tv_connect_scan_now);
            this.q = (LinearLayout) view.findViewById(R.id.rl_error_b0011);
            this.o = (TextView) view.findViewById(R.id.tv_error_b0011);
            this.p = (TextView) view.findViewById(R.id.tv_error_b0011_restart);
            this.r = view.findViewById(R.id.tv_setting);
            this.x = (SkinCompatConstraintLayout) view.findViewById(R.id.notice_firmware_update);
            this.y = (TextView) view.findViewById(R.id.notice_content);
            this.z = (TextView) view.findViewById(R.id.update_firmware);
            this.t = (ImageView) view.findViewById(R.id.iv_pin_connected);
            this.u = (ImageView) view.findViewById(R.id.iv_pin_connecting);
            this.w = (TextView) view.findViewById(R.id.toy_connect_now_text);
            this.A = (ImageView) view.findViewById(R.id.connect_app);
        }

        public String a() {
            return this.B;
        }

        public void b(String str) {
            this.B = str;
        }
    }

    public class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ Toy a;
        public final /* synthetic */ ToyHolder b;

        public a(ToyRecyclerViewAdapter toyRecyclerViewAdapter, Toy toy, ToyHolder toyHolder) {
            this.a = toy;
            this.b = toyHolder;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!this.a.isSelect()) {
                EventBus.getDefault().post(new ToySelectEvent(this.a.getAddress(), !this.a.isSelect()));
                return;
            }
            this.a.setConnectTryNumb(4);
            this.b.w.setVisibility(8);
            this.b.g.setVisibility(8);
            EventBus.getDefault().post(new ToySelectEvent(this.a.getAddress(), !this.a.isSelect()));
        }
    }

    public interface b {
        void a(String str, String str2);
    }

    public static class c extends RecyclerView.ViewHolder {
        public View a;

        public c(@NonNull View view) {
            super(view);
            this.a = view.findViewById(R.id.add_item);
        }
    }

    public ToyRecyclerViewAdapter(ToyActivity toyActivity) {
        this.d = toyActivity;
        MyApplication myApplication = (MyApplication) toyActivity.getApplication();
        this.b = myApplication;
        this.c = myApplication.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean C(Toy toy, View view) {
        new ls3(this.d, toy.getAddress()).e();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(Toy toy, View view) {
        new es3(this.d).d(toy.getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(Toy toy, View view) {
        pj3.j(this.d, ToySettingActivity.class, "toy_address_Id", toy.getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean J(Toy toy, View view) {
        b bVar = this.f;
        if (bVar == null) {
            return true;
        }
        bVar.a(toy.getAddress(), toy.getSimpleName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(Toy toy, View view) {
        pj3.j(this.d, ToySettingActivity.class, "toy_address_Id", toy.getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean N(Toy toy, View view) {
        b bVar = this.f;
        if (bVar == null) {
            return true;
        }
        bVar.a(toy.getAddress(), toy.getSimpleName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(Toy toy, View view) {
        if (toy.isConnected()) {
            lp1.a.e(this.d, toy.getAddress());
        } else {
            sg3.h(R.string.toy_settings_no_toy_toast);
        }
    }

    public static /* synthetic */ void p(Toy toy, ToyHolder toyHolder, View view) {
        toy.setConnectTryNumb(4);
        toyHolder.w.setVisibility(8);
        toyHolder.g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(Toy toy, ToyHolder toyHolder, View view) {
        Toy toyQ = this.b.G().Q(toy.getAddress());
        if (toyQ != null) {
            toyQ.setConnectScanTime(0L);
            toyQ.setConnectTryNumb(0);
            toyQ.setConnectType(0);
        }
        toyHolder.q.setVisibility(8);
    }

    public static /* synthetic */ void s(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(View view) {
        new ConnectingTipDialog(this.d).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(Toy toy, View view) {
        Toy toyQ = this.b.G().Q(toy.getAddress());
        if (toyQ != null) {
            toyQ.setConnectScanTime(0L);
            toyQ.setConnectTryNumb(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(Toy toy, View view) {
        new ds3(this.d, toy).d(toy.getSimpleName(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(Toy toy, View view) {
        lp1.a.e(this.d, toy.getAddress());
    }

    public void Q(String str) {
        ArrayList<Toy> arrayListO = this.b.G().o();
        if (arrayListO == null || arrayListO.size() == 0) {
            this.a.clear();
            this.g.clear();
            return;
        }
        this.a.clear();
        this.a.add(this.e);
        this.a.addAll(arrayListO);
        if (!WearUtils.e1(str)) {
            Iterator<Toy> it = arrayListO.iterator();
            while (it.hasNext()) {
                it.next().setIsSelect(1);
            }
        }
        this.g.clear();
    }

    public void R(b bVar) {
        this.f = bVar;
    }

    public final void S(ToyHolder toyHolder, final Toy toy) {
        toyHolder.r.setVisibility(8);
        toyHolder.x.setVisibility(0);
        if (toy.isEI01Toy()) {
            toyHolder.y.setText(ah4.e(R.string.notification_update_flexer_firmware2));
        } else if (toy.isEAToy()) {
            toyHolder.y.setText(ah4.e(R.string.notification_update__firmware3));
        }
        toyHolder.z.setOnClickListener(new View.OnClickListener() { // from class: dc.ro1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.P(toy, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Object> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        List<Object> list = this.a;
        if (list == null || list.get(i) == null) {
            return i;
        }
        return this.a.get(i) instanceof Toy ? ((Toy) this.a.get(i)).getDeviceType().hashCode() : this.a.get(i).hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.a.get(i) instanceof Toy ? 1 : 0;
    }

    public final void l(final ToyHolder toyHolder, final Toy toy) {
        if (toy.getConnectTryNumb() > 15) {
            toyHolder.s.setVisibility(0);
            toyHolder.n.setVisibility(8);
            toyHolder.k.setVisibility(8);
            toyHolder.w.setVisibility(0);
            toyHolder.w.setText(ah4.e(R.string.connect_now));
            toyHolder.w.setOnClickListener(new View.OnClickListener() { // from class: dc.uo1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToyRecyclerViewAdapter.p(toy, toyHolder, view);
                }
            });
            toyHolder.f.setText(ah4.e(R.string.not_connect));
            toyHolder.g.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) toyHolder.f.getLayoutParams();
            layoutParams.setMarginStart(ce3.a(this.d, 8.0f));
            toyHolder.f.setLayoutParams(layoutParams);
            return;
        }
        toyHolder.b.setSelected(false);
        toyHolder.s.setVisibility(0);
        if (xb1.b(toy.getUuid(), toy.getAddress()) || !og3.a(9)) {
            toyHolder.t.setVisibility(8);
        } else {
            toyHolder.t.setVisibility(0);
        }
        toyHolder.d.setVisibility(8);
        toyHolder.e.setVisibility(8);
        if (toy.getConnectType() == 3) {
            toyHolder.k.setVisibility(8);
            toyHolder.n.setVisibility(8);
            toyHolder.f.setVisibility(0);
            toyHolder.f.setText(ah4.e(R.string.toy_connecting));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) toyHolder.f.getLayoutParams();
            layoutParams2.setMarginStart(ce3.a(this.d, 0.0f));
            toyHolder.f.setLayoutParams(layoutParams2);
            toyHolder.q.setVisibility(0);
            toyHolder.o.setText(String.format(ah4.e(R.string.toy_connect_error_b0011), toy.getSimpleName()));
            toyHolder.p.setOnClickListener(new View.OnClickListener() { // from class: dc.wo1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.r(toy, toyHolder, view);
                }
            });
            toyHolder.q.setOnClickListener(new View.OnClickListener() { // from class: dc.jo1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToyRecyclerViewAdapter.s(view);
                }
            });
            return;
        }
        toyHolder.g.setVisibility(0);
        toyHolder.g.setOnClickListener(new View.OnClickListener() { // from class: dc.mo1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.u(view);
            }
        });
        toyHolder.q.setVisibility(8);
        if (toy.getConnectTryNumb() <= 10 || toy.getConnectType() != 0 || !toy.isSelect()) {
            toyHolder.s.setVisibility(0);
            toyHolder.k.setVisibility(8);
            toyHolder.n.setVisibility(8);
            if (xb1.b(toy.getUuid(), toy.getAddress()) || !og3.a(9)) {
                toyHolder.t.setVisibility(8);
            } else {
                toyHolder.t.setVisibility(0);
            }
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) toyHolder.f.getLayoutParams();
            layoutParams3.setMarginStart(ce3.a(this.d, 0.0f));
            toyHolder.f.setLayoutParams(layoutParams3);
            toyHolder.f.setVisibility(0);
            toyHolder.f.setText(ah4.e(R.string.toy_connecting));
            return;
        }
        toyHolder.s.setVisibility(8);
        toyHolder.n.setVisibility(0);
        if (xb1.b(toy.getUuid(), toy.getAddress()) || !og3.a(9)) {
            toyHolder.u.setVisibility(8);
        } else {
            toyHolder.u.setVisibility(0);
        }
        toyHolder.l.setText(String.format(ah4.e(R.string.toy_reconnect_time), ((toy.getConnectTryNumb() + 1) - ((be3.I().getTime() - toy.getConnectScanTime()) / 1000)) + "s"));
        toyHolder.m.setOnClickListener(new View.OnClickListener() { // from class: dc.po1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.w(toy, view);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    public final void m(ToyHolder toyHolder, final Toy toy) {
        toyHolder.b.setSelected(true);
        toyHolder.w.setVisibility(8);
        toyHolder.s.setVisibility(0);
        toyHolder.k.setVisibility(0);
        if (xb1.b(toy.getUuid(), toy.getAddress()) || !og3.a(9)) {
            toyHolder.t.setVisibility(8);
        } else {
            toyHolder.t.setVisibility(0);
        }
        toyHolder.n.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) toyHolder.f.getLayoutParams();
        layoutParams.setMarginStart(ce3.a(this.d, 0.0f));
        toyHolder.f.setLayoutParams(layoutParams);
        toyHolder.f.setVisibility(0);
        toyHolder.q.setVisibility(8);
        toyHolder.f.setText(ah4.e(R.string.toy_connected));
        toyHolder.f.setText(ah4.e(R.string.toy_connected) + "");
        toyHolder.e.setVisibility(0);
        if (toy.isF01Toy()) {
            toyHolder.v.setVisibility(0);
            toyHolder.d.setVisibility(8);
            if (toy.isF01IsReady()) {
                toyHolder.v.setText(ah4.e(R.string.f01_ready));
                toyHolder.v.setOnClickListener(new View.OnClickListener() { // from class: dc.lo1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.E(toy, view);
                    }
                });
                toyHolder.v.setTextColor(this.d.getResources().getColor(R.color.toy_f01_gray_text));
                toyHolder.v.setBackground(ResourcesCompat.getDrawable(this.d.getResources(), R.drawable.shape_1_gray, this.d.getTheme()));
            } else {
                toyHolder.v.setText(ah4.e(R.string.f01_not_ready));
                toyHolder.v.setOnClickListener(new View.OnClickListener() { // from class: dc.to1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.y(toy, view);
                    }
                });
                toyHolder.v.setTextColor(this.d.getResources().getColor(R.color.select_text_color));
                toyHolder.v.setBackground(ResourcesCompat.getDrawable(this.d.getResources(), R.drawable.shape_1_red, this.d.getTheme()));
            }
        } else {
            Toy.updateToyBattery(toyHolder.d, toy.getBattery());
        }
        if (yb1.A || (toy.getUpdateDfu() != null && toy.getUpdateDfu().isHasUpdate())) {
            toyHolder.j.setVisibility(0);
            toyHolder.j.setOnClickListener(new View.OnClickListener() { // from class: dc.ko1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.A(toy, view);
                }
            });
            if (WearUtils.B) {
                toyHolder.j.setOnLongClickListener(new View.OnLongClickListener() { // from class: dc.oo1
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return this.a.C(toy, view);
                    }
                });
            }
        }
        toyHolder.e.setImageDrawable(th4.d(this.d, toy.getRssiImg()));
    }

    public final void n(c cVar) {
        cVar.a.setOnClickListener(new View.OnClickListener() { // from class: dc.qo1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventBus.getDefault().post(new ToyAddClickEvent());
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    public final void o(ToyHolder toyHolder, int i) {
        final Toy toy = (Toy) this.a.get(i);
        if (toy == null || !Toy.ICON_MAP.containsKey(toy.getType())) {
            return;
        }
        toyHolder.b(toy.getAddress());
        this.g.put(toy.getAddress(), toyHolder);
        toyHolder.h.setText(toy.getSimpleFullName());
        toyHolder.j.setVisibility(8);
        if (WearUtils.e1(toy.getDefineRename())) {
            toyHolder.h.setText(toy.getSimpleFullName());
        } else {
            toyHolder.h.setText(toy.getSimpleFullName() + " · " + toy.getDefineRename());
        }
        toyHolder.e.setEnabled(false);
        toyHolder.g.setVisibility(8);
        toyHolder.v.setVisibility(8);
        if (this.c.a(toy.getAddress())) {
            m(toyHolder, toy);
        } else {
            l(toyHolder, toy);
        }
        if (toy.isSelect()) {
            toyHolder.b.setImageResource(toy.getToyIcon());
            toyHolder.A.setVisibility(8);
        } else {
            toyHolder.w.setVisibility(8);
            toyHolder.g.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) toyHolder.f.getLayoutParams();
            layoutParams.setMarginStart(ce3.a(this.d, 0.0f));
            toyHolder.f.setLayoutParams(layoutParams);
            String str = "connectApp = " + toy.getConnectApp() + " & formApp = " + toy.getFormApp();
            if (toy.getConnectApp() != 1 || TextUtils.equals("Lovense Remote", toy.getFormApp())) {
                toyHolder.b.setImageResource(Toy.getToyIconLinkedId(toy.getType(), i, false));
                toyHolder.A.setVisibility(8);
                toyHolder.f.setText(ah4.e(R.string.not_connect));
            } else {
                toyHolder.f.setText(String.format(ah4.e(R.string.toy_connected_to_other_apps), toy.getFormApp()));
                toyHolder.A.setVisibility(0);
                toyHolder.b.setImageResource(R.drawable.nav_unknown_1);
            }
            toyHolder.d.setVisibility(0);
            toyHolder.e.setVisibility(0);
            if (xb1.b(toy.getUuid(), toy.getAddress()) || !og3.a(9)) {
                toyHolder.t.setVisibility(8);
            } else {
                toyHolder.t.setVisibility(0);
            }
        }
        toyHolder.a = toy.getAddress();
        toyHolder.i.setOnCheckedChangeListener(new a(this, toy, toyHolder));
        toyHolder.i.setSelected(toy.isSelect());
        toyHolder.i.setEnabled(toy.getConnectType() != 3);
        if (toy.isEI01Toy() && toy.getVersion().intValue() < 3) {
            S(toyHolder, toy);
        } else if (toy.isGravity() && toy.getVersion().intValue() == 3) {
            S(toyHolder, toy);
        } else {
            toyHolder.r.setVisibility(0);
            toyHolder.x.setVisibility(8);
        }
        toyHolder.r.setOnClickListener(new View.OnClickListener() { // from class: dc.vo1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.H(toy, view);
            }
        });
        toyHolder.r.setOnLongClickListener(new View.OnLongClickListener() { // from class: dc.no1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.a.J(toy, view);
            }
        });
        toyHolder.c.setOnClickListener(new View.OnClickListener() { // from class: dc.so1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.L(toy, view);
            }
        });
        toyHolder.c.setOnLongClickListener(new View.OnLongClickListener() { // from class: dc.io1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.a.N(toy, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof c) {
            n((c) viewHolder);
        } else if (viewHolder instanceof ToyHolder) {
            o((ToyHolder) viewHolder, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return i == 1 ? new ToyHolder(LayoutInflater.from(this.d).inflate(R.layout.toy_item, viewGroup, false)) : new c(LayoutInflater.from(this.d).inflate(R.layout.view_toy_list_add, viewGroup, false));
    }
}
