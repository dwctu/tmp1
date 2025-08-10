package com.wear.main.longDistance.controllink;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.lovense.wear.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.wear.adapter.ControlLinkAdapter;
import com.wear.bean.event.ExpiredNotifyEvent;
import com.wear.bean.event.RefreshControlLinkList;
import com.wear.bean.socketio.controlLink.request.ControlLinkBaseRequest;
import com.wear.bean.socketio.controlLink.request.DeleteControlLinkRequest;
import com.wear.bean.socketio.controlLink.response.ControlLinkListResponse;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.ControlLinkNewTipDialog;
import com.wear.widget.MyActionBar;
import com.wear.xmpp.FragmentStateLossActivity;
import dc.ae1;
import dc.ah4;
import dc.be3;
import dc.c83;
import dc.ce3;
import dc.cs3;
import dc.db2;
import dc.dq2;
import dc.eg3;
import dc.is3;
import dc.ke3;
import dc.l22;
import dc.le1;
import dc.me3;
import dc.ne1;
import dc.pc1;
import dc.pj3;
import dc.sg3;
import dc.th4;
import dc.tn2;
import dc.ye3;
import dc.yn2;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ControlLinkNewActivity extends FragmentStateLossActivity implements View.OnClickListener, ControlLinkAdapter.i, l22.j {
    public static String f = "is_show_red_dot";

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.active_type)
    public LinearLayout activeType;

    @BindView(R.id.active_type_text)
    public TextView activeTypeText;

    @BindView(R.id.all_type)
    public LinearLayout allType;

    @BindView(R.id.all_type_text)
    public TextView allTypeText;
    public Timer b;

    @BindView(R.id.btn_create_control_link)
    public LinearLayout btnCreateControlLink;
    public TimerTask c;

    @BindView(R.id.createButton)
    public TextView createButton;
    public ControlLinkAdapter d;

    @BindView(R.id.deleteAll)
    public TextView deleteAll;
    public List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO> e;

    @BindView(R.id.expired_type)
    public LinearLayout expiredType;

    @BindView(R.id.expired_type_text)
    public TextView expiredTypeText;

    @BindView(R.id.view_red_dot)
    public View mViewRedDot;

    @BindView(R.id.noControlLinkLayout)
    public ConstraintLayout noControlLinkLayout;

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    @BindView(R.id.smartRefresh)
    public SmartRefreshLayout smartRefresh;

    @BindView(R.id.tips)
    public TextView tips;

    @BindView(R.id.type_constrain)
    public ConstraintLayout typeConstrain;

    @BindView(R.id.vertical_line)
    public ImageView verticalLine;

    @BindView(R.id.waiting_type)
    public LinearLayout waitingType;

    @BindView(R.id.waiting_type_text)
    public TextView waitingTypeText;

    public class a implements is3.d {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.a);
            ControlLinkNewActivity.this.startActivity(Intent.createChooser(intent, ah4.e(R.string.control_link_title)));
        }
    }

    public class b implements is3.d {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ControlLinkNewActivity.this.showDialog();
            l22.n().u(this.a);
        }
    }

    public class c implements is3.d {
        public final /* synthetic */ ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO a;

        public c(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
            this.a = longTimeControlLinkListDTO;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ControlLinkNewActivity.this.showDialog();
            l22.n().v(this.a);
        }
    }

    public class d implements yn2<BaseResponseBean> {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBean baseResponseBean) {
            if (baseResponseBean.isResult()) {
                try {
                    ControlLinkNewActivity.this.e.remove(this.a);
                    ControlLinkNewActivity.this.d.notifyItemRemoved(this.a);
                } catch (Exception e) {
                    e.printStackTrace();
                    ControlLinkNewActivity.this.H4();
                }
                if (ControlLinkNewActivity.this.e.isEmpty()) {
                    ControlLinkNewActivity.this.G4(null);
                } else {
                    ControlLinkNewActivity controlLinkNewActivity = ControlLinkNewActivity.this;
                    controlLinkNewActivity.G4((ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) controlLinkNewActivity.e.get(0));
                }
            }
            c83.R1().y2(true);
            ControlLinkNewActivity controlLinkNewActivity2 = ControlLinkNewActivity.this;
            controlLinkNewActivity2.btnCreateControlLink.setVisibility(controlLinkNewActivity2.e.size() == 0 ? 8 : 0);
            ControlLinkNewActivity controlLinkNewActivity3 = ControlLinkNewActivity.this;
            controlLinkNewActivity3.noControlLinkLayout.setVisibility(controlLinkNewActivity3.e.size() == 0 ? 0 : 4);
            ControlLinkNewActivity controlLinkNewActivity4 = ControlLinkNewActivity.this;
            controlLinkNewActivity4.smartRefresh.setVisibility(controlLinkNewActivity4.e.size() == 0 ? 4 : 0);
        }

        @Override // dc.yn2
        public void onCompleted() {
            ControlLinkNewActivity.this.dissDialog();
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            sg3.l(netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
            ControlLinkNewActivity.this.showDialog();
        }
    }

    public class e implements MyActionBar.f {
        public e() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.f(ControlLinkNewActivity.this, ToyActivity.class);
        }
    }

    public class f implements MyActionBar.f {
        public f() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ControlLinkNewActivity.this.finish();
        }
    }

    public class g implements is3.d {
        public g() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ControlLinkNewActivity.this.showDialog();
            l22.n().h();
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkNewActivity.this.K4();
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkNewActivity.this.K4();
        }
    }

    public class j implements ne1 {
        public j(ControlLinkNewActivity controlLinkNewActivity) {
        }

        @Override // dc.ne1
        public void b(@NonNull ae1 ae1Var) {
            l22.n().s(true, true);
        }
    }

    public class k implements le1 {
        public k(ControlLinkNewActivity controlLinkNewActivity) {
        }

        @Override // dc.le1
        public void f(@NonNull ae1 ae1Var) {
            l22.n().t(true);
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            new ControlLinkNewTipDialog(ControlLinkNewActivity.this).show();
            eg3.j(ControlLinkNewActivity.this, ControlLinkNewActivity.f, false);
            ControlLinkNewActivity.this.mViewRedDot.setVisibility(8);
            ye3.h(1);
        }
    }

    public class m extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ControlLinkNewActivity.this.H4();
                ControlLinkNewActivity.this.recyclerView.scrollToPosition(0);
            }
        }

        public m() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            if (ControlLinkNewActivity.this.recyclerView.getVisibility() != 0 || ControlLinkNewActivity.this.e == null || ControlLinkNewActivity.this.e.size() <= 0) {
                return;
            }
            for (int i = 0; i < ControlLinkNewActivity.this.e.size(); i++) {
                if (((ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) ControlLinkNewActivity.this.e.get(i)).getExpiredTimestamp().longValue() - MyApplication.N().h > System.currentTimeMillis() && ((ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) ControlLinkNewActivity.this.e.get(i)).getCurrentStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE)) {
                    String str = "run: 左未来时间戳：=" + be3.i(be3.a, new Date(((ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) ControlLinkNewActivity.this.e.get(i)).getExpiredTimestamp().longValue())) + "现在时间戳=" + be3.i(be3.a, new Date(System.currentTimeMillis()));
                    if (ControlLinkNewActivity.this.d != null) {
                        ControlLinkNewActivity.this.d.notifyItemChanged(i, Integer.valueOf(R.id.countTime));
                    }
                }
                if (((ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) ControlLinkNewActivity.this.e.get(i)).getNextOnWaitingTimestamp() - MyApplication.N().h > System.currentTimeMillis() && ((ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) ControlLinkNewActivity.this.e.get(i)).isRewaiting() && ControlLinkNewActivity.this.d != null) {
                    ControlLinkNewActivity.this.d.notifyItemChanged(i, Integer.valueOf(R.id.repeat));
                }
                if (((ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) ControlLinkNewActivity.this.e.get(i)).isRewaiting()) {
                    String strI = be3.i(be3.a, new Date(((ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) ControlLinkNewActivity.this.e.get(i)).getNextOnWaitingTimestamp() - MyApplication.N().h));
                    String strI2 = be3.i(be3.a, new Date(System.currentTimeMillis()));
                    String str2 = "run: 未来时间戳：=" + strI + "现在时间戳=" + strI2;
                    if (TextUtils.equals(strI, strI2)) {
                        ControlLinkNewActivity.this.delayHandler.postDelayed(new a(), 600L);
                    }
                }
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ControlLinkNewActivity.this.runOnMainThread(new Runnable() { // from class: dc.xa2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            });
        }
    }

    public class n extends RecyclerView.ItemDecoration {
        public n(ControlLinkNewActivity controlLinkNewActivity) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = ce3.a(recyclerView.getContext(), 0.0f);
            } else {
                rect.top = ce3.a(recyclerView.getContext(), 10.0f);
            }
            rect.right = ce3.a(recyclerView.getContext(), 16.0f);
            rect.bottom = ce3.a(recyclerView.getContext(), 10.0f);
            rect.left = ce3.a(recyclerView.getContext(), 16.0f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.onDraw(canvas, recyclerView, state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D4(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        if (!TextUtils.isEmpty(longTimeControlLinkListDTO.getLastActiveSessionId())) {
            dq2.w().q(longTimeControlLinkListDTO.getLastActiveSessionId(), "manual", 0L);
        }
        showDialog();
        l22.n().j(longTimeControlLinkListDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F4() {
        pj3.t(this, LoginActivity.class, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(View view) {
        if (MyApplication.Z) {
            return;
        }
        cs3.a(this, ah4.e(R.string.notification_delete_control_link3), new g()).show();
    }

    @Override // com.wear.adapter.ControlLinkAdapter.i
    public void A2(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        cs3.a(this, ah4.e(R.string.notification_disable_control_link), new is3.d() { // from class: dc.bb2
            @Override // dc.is3.d
            public final void doConfirm() {
                l22.n().i(str);
            }
        }).show();
    }

    @Override // com.wear.adapter.ControlLinkAdapter.i
    public void C1(final ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, boolean z) {
        cs3.a(this, ah4.e(z ? R.string.notification_disable_control_link : R.string.notification_end_control_link), new is3.d() { // from class: dc.za2
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.D4(longTimeControlLinkListDTO);
            }
        }).show();
    }

    public final void G4(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        RefreshControlLinkList refreshControlLinkList = new RefreshControlLinkList();
        if (longTimeControlLinkListDTO != null) {
            refreshControlLinkList.setLongTimeControlLinkListDTO(longTimeControlLinkListDTO);
        }
        EventBus.getDefault().post(refreshControlLinkList);
    }

    public void H4() {
        if (isDestroyed() || isFinishing()) {
            return;
        }
        l22.n().s(false, true);
    }

    public final void I4(boolean z) {
        this.deleteAll.setEnabled(!z);
    }

    public void J4(int i2) {
        cs3.c(this, ah4.e(i2), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), new is3.d() { // from class: dc.ya2
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.F4();
            }
        }).show();
    }

    public final void K4() {
        int i2;
        if (MyApplication.Z) {
            J4(R.string.offline_control_link);
            return;
        }
        ye3.d("M0051", "");
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO> list = this.e;
        int i3 = 0;
        if (list == null || list.size() <= 0) {
            i2 = 0;
        } else {
            i2 = 0;
            for (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO : l22.n().k()) {
                if (longTimeControlLinkListDTO.getCurrentStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE)) {
                    i2++;
                    List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> toys = longTimeControlLinkListDTO.getToys();
                    if (toys != null && toys.size() > 0) {
                        Iterator<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> it = toys.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().getToyId());
                        }
                    }
                }
                if (longTimeControlLinkListDTO.getCurrentStatus().equals("waiting")) {
                    i3++;
                    List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> toys2 = longTimeControlLinkListDTO.getToys();
                    if (toys2 != null && toys2.size() > 0) {
                        Iterator<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> it2 = toys2.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(it2.next().getToyId());
                        }
                    }
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("waitingCount", i3);
        bundle.putInt("activeCount", i2);
        bundle.putStringArrayList("activeToyList", arrayList);
        bundle.putStringArrayList("waitingToyList", arrayList2);
        pj3.p(this, CreateControlLinkActivity.class, CreateControlLinkActivity.u, bundle);
    }

    @Override // com.wear.adapter.ControlLinkAdapter.i
    public void M3(List<String> list, String str) {
        String strSubstring;
        StringBuilder sb = new StringBuilder();
        if (list == null || list.size() <= 0) {
            strSubstring = "";
        } else {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            strSubstring = sb.substring(0, sb.length() - 1);
        }
        if (list.size() != 0) {
            cs3.c(this, list.size() > 1 ? String.format(ah4.e(R.string.notification_toys_disconnected), strSubstring) : String.format(ah4.e(R.string.notification_toy_disconnected), strSubstring), ah4.e(R.string.common_share), ah4.e(R.string.common_cancel), new a(str)).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        startActivity(Intent.createChooser(intent, ah4.e(R.string.control_link_title)));
    }

    @Override // dc.l22.j
    public void R() {
        dissDialog();
        this.d.L(l22.n().k());
        this.btnCreateControlLink.setVisibility(this.e.size() == 0 ? 8 : 0);
        this.noControlLinkLayout.setVisibility(this.e.size() == 0 ? 0 : 4);
        this.smartRefresh.r();
        this.smartRefresh.m();
        this.smartRefresh.setVisibility(this.e.size() != 0 ? 0 : 4);
        this.smartRefresh.C(l22.n().r());
        I4(this.e.size() == 0);
    }

    @Override // com.wear.adapter.ControlLinkAdapter.i
    public void Y3(int i2, String str) {
        w4(i2, str);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onActivityResult(i2, i3, intent);
        if (i2 == CreateControlLinkActivity.u && i3 == CreateControlLinkActivity.v) {
            this.recyclerView.scrollToPosition(0);
            if (ke3.a("new_user", "control_link_list")) {
                ControlLinkNewTipDialog controlLinkNewTipDialog = new ControlLinkNewTipDialog(this);
                if (eg3.d(this, f, true)) {
                    controlLinkNewTipDialog.show();
                    eg3.j(this, f, false);
                    this.mViewRedDot.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.active_type /* 2131362021 */:
                this.allTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                this.activeTypeText.setTextColor(th4.b(this, R.color.colorPrimary));
                this.waitingTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                this.expiredTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                break;
            case R.id.all_type /* 2131362079 */:
                this.allTypeText.setTextColor(th4.b(this, R.color.colorPrimary));
                this.activeTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                this.waitingTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                this.expiredTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                break;
            case R.id.expired_type /* 2131362702 */:
                this.expiredTypeText.setTextColor(th4.b(this, R.color.colorPrimary));
                this.activeTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                this.waitingTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                this.allTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                break;
            case R.id.waiting_type /* 2131365663 */:
                this.waitingTypeText.setTextColor(th4.b(this, R.color.colorPrimary));
                this.activeTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                this.allTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                this.expiredTypeText.setTextColor(th4.b(this, R.color.control_link_item_text_color));
                break;
        }
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_control_link_new);
        me3.c(me3.c.CONTROL_LINK_UI_ENTER);
        ye3.c("control link", "into page", null);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.actionbar.setToysAction(new e(), true, this);
        this.actionbar.n();
        this.actionbar.setBackAction(new f());
        MyApplication.N().O();
        List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO> listK = l22.n().k();
        this.e = listK;
        this.btnCreateControlLink.setVisibility(listK.isEmpty() ? 8 : 0);
        this.noControlLinkLayout.setVisibility(this.e.isEmpty() ? 0 : 4);
        this.smartRefresh.setVisibility(this.e.isEmpty() ? 4 : 0);
        x4();
        y4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.CONTROL_LINK_UI_EXIT);
        EventBus.getDefault().unregister(this);
        this.actionbar.s();
        TimerTask timerTask = this.c;
        if (timerTask != null) {
            timerTask.cancel();
            this.c = null;
        }
        Timer timer = this.b;
        if (timer != null) {
            timer.cancel();
            this.b = null;
        }
        l22.n().A(1);
        l22.n().x(null);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ControlLinkBaseRequest controlLinkBaseRequest) {
        H4();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.actionbar.setToy(pc1.a.P());
        db2.A().E();
        l22.n().s(true, true);
    }

    @Override // com.wear.adapter.ControlLinkAdapter.i
    public void u0(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, List<String> list) {
        String strSubstring;
        StringBuilder sb = new StringBuilder();
        if (list == null || list.size() <= 0) {
            strSubstring = "";
        } else {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(ah4.d(it.next()));
                sb.append(", ");
            }
            strSubstring = sb.substring(0, sb.length() - 2);
        }
        if (list.size() > 0) {
            cs3.c(this, list.size() > 1 ? String.format(ah4.e(R.string.notification_toys_associated), strSubstring) : String.format(ah4.e(R.string.notification_toy_associated), strSubstring), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), new c(longTimeControlLinkListDTO)).show();
        } else {
            showDialog();
            l22.n().g(longTimeControlLinkListDTO);
        }
    }

    public final void w4(int i2, String str) {
        dq2.w().q(str, "manual", 0L);
        tn2.x(this).h("/app/long_time_control_link/delete", WearUtils.A.toJson(new DeleteControlLinkRequest(str)), new d(i2));
    }

    public final void x4() {
        TimerTask timerTask = this.c;
        if (timerTask != null) {
            timerTask.cancel();
            this.c = null;
        }
        Timer timer = this.b;
        if (timer != null) {
            timer.cancel();
            this.b = null;
        }
        this.c = new m();
        Timer timer2 = new Timer();
        this.b = timer2;
        timer2.schedule(this.c, 1000L, 1000L);
    }

    @Override // com.wear.adapter.ControlLinkAdapter.i
    public void y3(int i2, String str, boolean z) {
        if (z) {
            cs3.c(this, ah4.e(R.string.link_end_control_notice), ah4.e(R.string.common_generate), ah4.e(R.string.common_cancel), new b(str)).show();
        } else {
            showDialog();
            l22.n().u(str);
        }
    }

    public final void y4() {
        this.allTypeText.setText(ah4.c(R.string.common_all));
        this.allType.setOnClickListener(new View.OnClickListener() { // from class: dc.cb2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        this.activeType.setOnClickListener(new View.OnClickListener() { // from class: dc.cb2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        this.waitingType.setOnClickListener(new View.OnClickListener() { // from class: dc.cb2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        this.expiredType.setOnClickListener(new View.OnClickListener() { // from class: dc.cb2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        I4(MyApplication.Z);
        if (eg3.d(this, f, true)) {
            this.mViewRedDot.setVisibility(0);
        } else {
            this.mViewRedDot.setVisibility(8);
        }
        this.deleteAll.setOnClickListener(new View.OnClickListener() { // from class: dc.ab2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.A4(view);
            }
        });
        this.btnCreateControlLink.setOnClickListener(new h());
        this.createButton.setOnClickListener(new i());
        ControlLinkAdapter controlLinkAdapter = new ControlLinkAdapter(this, this.e);
        this.d = controlLinkAdapter;
        controlLinkAdapter.M(this);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.recyclerView.addItemDecoration(new n(this));
        this.recyclerView.setAdapter(this.d);
        this.smartRefresh.G(new j(this));
        this.smartRefresh.F(new k(this));
        this.tips.setOnClickListener(new l());
        this.typeConstrain.setVisibility(8);
        l22.n().x(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ExpiredNotifyEvent expiredNotifyEvent) {
        H4();
    }
}
