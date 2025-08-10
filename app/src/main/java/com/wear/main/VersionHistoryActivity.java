package com.wear.main;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.wear.BaseActivity;
import com.wear.adapter.BaseAdapter;
import com.wear.adapter.VersionHistoryAdapter;
import com.wear.bean.request.VersionHistoryRequest;
import com.wear.bean.response.VersionHistoryResponse;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.widget.MediumBoldTextView;
import dc.ae1;
import dc.ah4;
import dc.le1;
import dc.ne1;
import dc.wn2;
import dc.wn3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class VersionHistoryActivity extends BaseActivity {

    @BindView(R.id.actionbar_back)
    public ImageButton actionbarBack;
    public VersionHistoryAdapter b;

    @BindView(R.id.back_relative)
    public RelativeLayout backRelative;

    @BindView(R.id.bar)
    public RelativeLayout bar;

    @BindView(R.id.description)
    public TextView description;
    public VersionHistoryResponse.DataDTO.PageItemsDTO f;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

    @BindView(R.id.scrollView)
    public ScrollView scrollView;

    @BindView(R.id.smartRefresh)
    public SmartRefreshLayout smartRefresh;

    @BindView(R.id.title)
    public MediumBoldTextView title;
    public boolean a = false;
    public List<VersionHistoryResponse.DataDTO.PageItemsDTO> c = new ArrayList();
    public int d = 1;
    public int e = 10;

    public class a implements le1 {
        public a() {
        }

        @Override // dc.le1
        public void f(@NonNull ae1 ae1Var) {
            VersionHistoryActivity.t4(VersionHistoryActivity.this);
            VersionHistoryActivity.this.A4(new VersionHistoryRequest(Integer.valueOf(VersionHistoryActivity.this.d), Integer.valueOf(VersionHistoryActivity.this.e)));
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ VersionHistoryResponse.DataDTO.PageItemsDTO a;

        public b(VersionHistoryResponse.DataDTO.PageItemsDTO pageItemsDTO) {
            this.a = pageItemsDTO;
        }

        @Override // java.lang.Runnable
        public void run() {
            Spanned spannedFromHtml;
            VersionHistoryActivity.this.f = this.a;
            String description = (this.a.getPlatformVerLangList() == null || this.a.getPlatformVerLangList().size() == 0) ? "<p>Fixed some minor bugs.</p>" : this.a.getPlatformVerLangList().get(0).getDescription();
            if (Build.VERSION.SDK_INT >= 24) {
                VersionHistoryActivity versionHistoryActivity = VersionHistoryActivity.this;
                spannedFromHtml = Html.fromHtml(description, 63, new wn3(versionHistoryActivity, versionHistoryActivity.description), null);
            } else {
                spannedFromHtml = Html.fromHtml(description);
            }
            VersionHistoryActivity.this.description.setText(spannedFromHtml);
            VersionHistoryActivity.this.description.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public class c implements wn2<VersionHistoryResponse.DataDTO> {

        public class a implements Runnable {
            public final /* synthetic */ VersionHistoryResponse.DataDTO a;

            public a(VersionHistoryResponse.DataDTO dataDTO) {
                this.a = dataDTO;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a.getPageItems() != null) {
                    if (VersionHistoryActivity.this.d > 1) {
                        VersionHistoryActivity.this.smartRefresh.m();
                        VersionHistoryActivity.this.b.z(this.a.getPageItems());
                    } else {
                        VersionHistoryActivity.this.smartRefresh.r();
                        VersionHistoryActivity.this.b.C(this.a.getPageItems());
                    }
                }
            }
        }

        public c() {
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            if (VersionHistoryActivity.this.d > 1) {
                VersionHistoryActivity.u4(VersionHistoryActivity.this);
            }
        }

        @Override // dc.wn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(boolean z, VersionHistoryResponse.DataDTO dataDTO) {
            VersionHistoryActivity.this.runOnMainThread(new a(dataDTO));
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
            if (VersionHistoryActivity.this.d > 1) {
                VersionHistoryActivity.u4(VersionHistoryActivity.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D4(View view) {
        if (!this.a) {
            finish();
        } else {
            this.a = false;
            z4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F4(ae1 ae1Var) {
        this.d = 1;
        A4(new VersionHistoryRequest(1, Integer.valueOf(this.e)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H4(VersionHistoryResponse.DataDTO.PageItemsDTO pageItemsDTO, int i, View view) {
        this.f = pageItemsDTO;
        String description = (pageItemsDTO.getPlatformVerLangList() == null || pageItemsDTO.getPlatformVerLangList().size() == 0) ? "<p>Fixed some minor bugs.</p>" : pageItemsDTO.getPlatformVerLangList().get(0).getDescription();
        this.description.setText(Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(description, 63, new wn3(this, this.description), null) : Html.fromHtml(description));
        this.description.setMovementMethod(LinkMovementMethod.getInstance());
        this.parentHandler.postDelayed(new b(pageItemsDTO), 500L);
        this.a = true;
        z4();
    }

    public static /* synthetic */ int t4(VersionHistoryActivity versionHistoryActivity) {
        int i = versionHistoryActivity.d;
        versionHistoryActivity.d = i + 1;
        return i;
    }

    public static /* synthetic */ int u4(VersionHistoryActivity versionHistoryActivity) {
        int i = versionHistoryActivity.d;
        versionHistoryActivity.d = i - 1;
        return i;
    }

    public final void A4(VersionHistoryRequest versionHistoryRequest) {
        MyApplication.V(versionHistoryRequest, new c());
    }

    public final void B4() {
        this.title.setText(ah4.e(R.string.common_version_history));
        this.actionbarBack.setOnClickListener(new View.OnClickListener() { // from class: dc.dx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.D4(view);
            }
        });
        this.smartRefresh.G(new ne1() { // from class: dc.fx1
            @Override // dc.ne1
            public final void b(ae1 ae1Var) {
                this.a.F4(ae1Var);
            }
        });
        this.smartRefresh.F(new a());
        VersionHistoryAdapter versionHistoryAdapter = new VersionHistoryAdapter(this.c, R.layout.item_version_history_layout);
        this.b = versionHistoryAdapter;
        versionHistoryAdapter.s(new BaseAdapter.b() { // from class: dc.ex1
            @Override // com.wear.adapter.BaseAdapter.b
            public final void a0(Object obj, int i, View view) {
                this.a.H4((VersionHistoryResponse.DataDTO.PageItemsDTO) obj, i, view);
            }
        });
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.recyclerView.setAdapter(this.b);
        A4(new VersionHistoryRequest(Integer.valueOf(this.d), Integer.valueOf(this.e)));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.a) {
            finish();
        } else {
            this.a = false;
            z4();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_version_history);
        ButterKnife.bind(this);
        B4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void z4() {
        this.smartRefresh.D(!this.a);
        this.smartRefresh.C(!this.a);
        this.recyclerView.setVisibility(this.a ? 8 : 0);
        this.scrollView.setVisibility(this.a ? 0 : 8);
        if (!this.a) {
            this.title.setText(ah4.e(R.string.common_version_history));
            return;
        }
        if (this.f != null) {
            this.title.setText(this.f.getAppName() + " " + this.f.getVersion());
        }
    }
}
