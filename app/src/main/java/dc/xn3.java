package dc;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.activity.orgySetting.JoinType;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.activity.orgySetting.OrgySettingEvent;
import dc.kn3;

/* compiled from: OrgyControlWidget.java */
/* loaded from: classes4.dex */
public class xn3 implements View.OnClickListener {
    public View a;
    public View b;
    public TextView c;
    public TextView d;
    public View e;
    public View f;
    public ImageView g;
    public ImageView h;
    public Context i;

    /* compiled from: OrgyControlWidget.java */
    public class a implements kn3.d {
        public a(xn3 xn3Var) {
        }

        @Override // dc.kn3.d
        public void doCancel() {
            of3.h().d("home_btn_close_banner");
            OrgySetting.getInstance().hiddenBannerShowType(false);
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            of3.h().d("home_btn_close_banner");
            OrgySetting.getInstance().hiddenBannerShowType(true);
        }
    }

    /* compiled from: OrgyControlWidget.java */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JoinType.values().length];
            a = iArr;
            try {
                iArr[JoinType.NoWay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JoinType.No.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JoinType.Yes.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JoinType.Cancel.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public xn3(Context context, View view) {
        this.i = context;
        this.a = view;
        c();
    }

    public void a() {
        View view = this.a;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        of3.h().d("banner_view");
    }

    public final void b() {
        kn3 kn3Var = new kn3(this.i, ah4.e(R.string.orgy_event_close), ah4.e(R.string.orgy_event_close_now), ah4.e(R.string.orgy_event_close_forever), true, (kn3.d) new a(this));
        kn3Var.show();
        kn3Var.l();
        kn3Var.p();
    }

    public final void c() {
        this.b = this.a.findViewById(R.id.iv_oray_close);
        this.c = (TextView) this.a.findViewById(R.id.tv_gray_bar_top);
        this.d = (TextView) this.a.findViewById(R.id.tv_gray_bar_buttom);
        this.e = this.a.findViewById(R.id.layout_orgy_details);
        this.f = this.a.findViewById(R.id.layout_orgy_join);
        this.g = (ImageView) this.a.findViewById(R.id.iv_orgy_join);
        this.h = (ImageView) this.a.findViewById(R.id.iv_right);
        this.f.setVisibility(8);
        this.d.setVisibility(8);
        this.h.setVisibility(8);
        this.b.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.h.setOnClickListener(this);
        OrgySetting.getInstance().checkTimer();
    }

    public void d(OrgySettingEvent orgySettingEvent) {
        if (orgySettingEvent == null) {
            this.a.setVisibility(8);
            return;
        }
        if (!orgySettingEvent.isShowBanner()) {
            this.a.setVisibility(8);
            return;
        }
        this.a.setVisibility(0);
        int i = b.a[OrgySetting.getInstance().getJoinType().ordinal()];
        if (i == 1) {
            this.b.setVisibility(0);
            this.f.setVisibility(8);
            if (orgySettingEvent.isCanMark()) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
        } else if (i == 2) {
            this.b.setVisibility(0);
            this.f.setVisibility(8);
            if (orgySettingEvent.isCanMark()) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
        } else if (i == 3) {
            this.b.setVisibility(8);
            this.h.setVisibility(8);
            if (orgySettingEvent.getShowJoinBtn() == 1) {
                this.f.setVisibility(0);
                this.g.setBackgroundResource(R.drawable.gray_enable);
            } else {
                this.f.setVisibility(8);
            }
        } else if (i == 4) {
            this.b.setVisibility(8);
            this.h.setVisibility(8);
            if (orgySettingEvent.getShowJoinBtn() == 1) {
                this.f.setVisibility(0);
                this.g.setBackgroundResource(R.drawable.gray_disable);
            } else {
                this.f.setVisibility(8);
            }
        }
        this.c.setText(orgySettingEvent.getTitle());
        if (orgySettingEvent.getStartOrEnd() == 0) {
            this.d.setVisibility(0);
            this.d.setText(String.format(ah4.e(R.string.event_starts_in_banner), orgySettingEvent.getTimer()));
        } else if (orgySettingEvent.getStartOrEnd() != 1) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
            this.d.setText(String.format(ah4.e(R.string.event_ends_in_banner), orgySettingEvent.getTimer()));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_oray_close /* 2131363227 */:
                b();
                break;
            case R.id.iv_right /* 2131363283 */:
            case R.id.layout_orgy_details /* 2131363377 */:
                of3.h().d("banner_click");
                OrgySetting.getInstance().showOrgyWebView();
                break;
            case R.id.layout_orgy_join /* 2131363379 */:
                OrgySetting.getInstance().joinOrgyAction();
                break;
        }
    }
}
