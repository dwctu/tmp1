package com.wear.ui.discover.giftCard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.wear.BaseActivity;
import com.wear.adapter.GiftCardAdapter;
import com.wear.bean.GiftCard;
import com.wear.bean.response.NoLogicGiftCardResponse;
import com.wear.dao.DaoUtils;
import com.wear.dao.GiftCardDao;
import com.wear.main.account.login.LoginActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ae1;
import dc.eg3;
import dc.me3;
import dc.ne1;
import dc.pj3;
import dc.tn2;
import dc.wn2;
import dc.ye3;
import dc.yn2;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import skin.support.widget.SkinCompatButton;

/* loaded from: classes3.dex */
public class GiftCardActivity extends BaseActivity {
    public static String h = "isNewGiftCard";
    public static int i = 8888;

    @BindView(R.id.app_bar_layout)
    public ConstraintLayout appBarLayout;
    public GiftCardAdapter b;

    @BindView(R.id.checkout_image)
    public ImageView checkoutImage;
    public Timer d;
    public TimerTask e;

    @BindView(R.id.gift_image)
    public ImageView giftImage;

    @BindView(R.id.gift_list)
    public ConstraintLayout giftList;

    @BindView(R.id.guide_page)
    public ConstraintLayout guidePage;

    @BindView(R.id.inner_title)
    public TextView innerTitle;

    @BindView(R.id.innner_layout)
    public ConstraintLayout innnerLayout;

    @BindView(R.id.nav_back)
    public ImageView navBack;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    @BindView(R.id.set_new_gift_image)
    public ImageView setNewGiftImage;

    @BindView(R.id.set_new_gift_layout)
    public ConstraintLayout setNewGiftLayout;

    @BindView(R.id.share_image)
    public ImageView shareImage;

    @BindView(R.id.smartRefresh)
    public SmartRefreshLayout smartRefresh;

    @BindView(R.id.start_gift)
    public SkinCompatButton startGift;

    @BindView(R.id.wait_image)
    public ImageView waitImage;
    public String a = WearUtils.k + "public/giftstore";
    public List<GiftCard> c = new ArrayList();
    public String f = null;
    public boolean g = false;

    public class a implements ne1 {
        public a() {
        }

        @Override // dc.ne1
        public void b(@NonNull ae1 ae1Var) {
            GiftCardActivity.this.smartRefresh.D(true);
            GiftCardActivity.this.y4();
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            if (GiftCardActivity.this.recyclerView.getVisibility() != 0 || GiftCardActivity.this.c == null || GiftCardActivity.this.c.size() <= 0) {
                return;
            }
            for (int i = 0; i < GiftCardActivity.this.c.size(); i++) {
                if (((GiftCard) GiftCardActivity.this.c.get(i)).getStatus() == 1 && TextUtils.equals("yes", ((GiftCard) GiftCardActivity.this.c.get(i)).getShowExpireItem())) {
                    if (((GiftCard) GiftCardActivity.this.c.get(i)).getExpireTime().longValue() < System.currentTimeMillis()) {
                        ((GiftCard) GiftCardActivity.this.c.get(i)).setStatus(2);
                        DaoUtils.getGiftCardDao().update((GiftCardDao) GiftCardActivity.this.c.get(i));
                    }
                    if (GiftCardActivity.this.b != null) {
                        GiftCardActivity.this.b.notifyItemChanged(i, Integer.valueOf(R.id.gift_card_status));
                        GiftCardActivity.this.b.notifyItemChanged(i, Integer.valueOf(R.id.gift_card_refund));
                        GiftCardActivity.this.b.notifyItemChanged(i, Integer.valueOf(R.id.gift_card_share));
                    }
                }
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            GiftCardActivity.this.runOnMainThread(new Runnable() { // from class: dc.gx2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            });
        }
    }

    public class c implements yn2<NoLogicGiftCardResponse> {
        public c() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(NoLogicGiftCardResponse noLogicGiftCardResponse) {
            if (noLogicGiftCardResponse.getResult().booleanValue() && noLogicGiftCardResponse.getDataX() != null) {
                GiftCardActivity.this.f = noLogicGiftCardResponse.getDataX().getLink();
            }
            if (GiftCardActivity.this.g) {
                GiftCardActivity.this.y4();
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            String str = "onError: " + netException.getMessage();
            if (GiftCardActivity.this.g) {
                GiftCardActivity.this.y4();
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class d implements wn2<List<GiftCard>> {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                GiftCardActivity.this.smartRefresh.r();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                GiftCardActivity.this.smartRefresh.r();
            }
        }

        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(List list) {
            GiftCardActivity.this.dissDialog();
            GiftCardActivity.this.smartRefresh.r();
            if (list == null || list.size() <= 0) {
                if (GiftCardActivity.this.g) {
                    GiftCardActivity.this.g = false;
                }
                GiftCardActivity.this.giftList.setVisibility(8);
                GiftCardActivity.this.guidePage.setVisibility(0);
                return;
            }
            GiftCardActivity.this.giftList.setVisibility(0);
            GiftCardActivity.this.guidePage.setVisibility(8);
            GiftCardActivity.this.c.clear();
            GiftCardActivity.this.c.addAll(list);
            GiftCardActivity.this.b.r(GiftCardActivity.this.c);
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            String str2 = "onError:" + str;
            GiftCardActivity.this.runOnMainThread(new a());
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
            String str = "onError:" + netException.getMessage();
            GiftCardActivity.this.runOnMainThread(new b());
        }

        @Override // dc.wn2
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(boolean z, final List<GiftCard> list) {
            GiftCardActivity.this.runOnMainThread(new Runnable() { // from class: dc.hx2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e(list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G4(View view) {
        if (!MyApplication.O) {
            pj3.s(this, LoginActivity.class);
            this.guidePage.setVisibility(8);
            this.g = true;
            return;
        }
        if (TextUtils.isEmpty(this.f)) {
            if (WearUtils.v) {
                this.a += "?_utm_pro=2203031253";
            } else {
                this.a += "?_utm_pro=2203031110";
            }
            pj3.w(this, this.a);
        } else {
            if (WearUtils.v) {
                this.f += "?_utm_pro=2203031253";
            } else {
                this.f += "?_utm_pro=2203031110";
            }
            pj3.w(this, this.f);
        }
        ye3.d("M0013", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I4(View view) {
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        if (WearUtils.v) {
            this.f += "?_utm_pro=2203031253";
        } else {
            this.f += "?_utm_pro=2203031110";
        }
        pj3.w(this, this.f);
    }

    public final void A4() {
        showDialog();
        if (!this.g) {
            y4();
        }
        z4();
    }

    public final void B4() {
        TimerTask timerTask = this.e;
        if (timerTask != null) {
            timerTask.cancel();
            this.e = null;
        }
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
            this.d = null;
        }
        this.e = new b();
        Timer timer2 = new Timer();
        this.d = timer2;
        timer2.schedule(this.e, 1000L, 1000L);
    }

    public final void C4() {
        this.navBack.setOnClickListener(new View.OnClickListener() { // from class: dc.jx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.E4(view);
            }
        });
        this.startGift.setOnClickListener(new View.OnClickListener() { // from class: dc.ix2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.G4(view);
            }
        });
        this.setNewGiftLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.kx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.I4(view);
            }
        });
        this.b = new GiftCardAdapter(this, this.c);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.recyclerView.setAdapter(this.b);
        this.smartRefresh.G(new a());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gift_card);
        me3.c(me3.c.GIFT_UI_ENTER);
        ye3.c("gift", "into page", null);
        ButterKnife.bind(this);
        eg3.j(this, h, false);
        B4();
        C4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.GIFT_UI_EXIT);
        TimerTask timerTask = this.e;
        if (timerTask != null) {
            timerTask.cancel();
            this.e = null;
        }
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
            this.d = null;
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        A4();
    }

    public final void y4() {
        MyApplication.N().L(1, new d());
    }

    public final void z4() {
        HashMap map = new HashMap();
        map.put("type", "gift");
        tn2.x(this).h("/nh-order/web/login", WearUtils.A.toJson(map), new c());
    }
}
