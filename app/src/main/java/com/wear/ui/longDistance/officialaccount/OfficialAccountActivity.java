package com.wear.ui.longDistance.officialaccount;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.wear.BaseActivity;
import com.wear.bean.EntryPoint;
import com.wear.bean.official.OfficialAcount;
import com.wear.bean.official.OfficialMsg;
import com.wear.databinding.ActivityOfficialAccountBinding;
import com.wear.main.longDistance.scan.PictureEnlargeActivity;
import com.wear.ui.longDistance.officialaccount.OfficialAccountActivity;
import com.wear.ui.longDistance.officialaccount.adapter.OfficialSourcesAdapter;
import com.wear.ui.longDistance.video.VideoPlayerActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ae1;
import dc.kg3;
import dc.ku1;
import dc.ne1;
import dc.pj3;
import dc.re3;
import dc.th4;
import dc.vl2;
import dc.we3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialAccountActivity.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/wear/ui/longDistance/officialaccount/OfficialAccountActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "adapter", "Lcom/wear/ui/longDistance/officialaccount/adapter/OfficialSourcesAdapter;", "binding", "Lcom/wear/databinding/ActivityOfficialAccountBinding;", "isShowBottom", "", "list", "", "Lcom/wear/bean/official/OfficialMsg;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "officialaCountModel", "Lcom/wear/ui/longDistance/officialaccount/OfficialaCountModel;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class OfficialAccountActivity extends BaseActivity<vl2> {
    public ActivityOfficialAccountBinding a;
    public OfficialSourcesAdapter b;
    public OfficialaCountModel c;
    public boolean d = true;

    @NotNull
    public List<OfficialMsg> e = new ArrayList();

    /* compiled from: OfficialAccountActivity.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/wear/ui/longDistance/officialaccount/OfficialAccountActivity$initView$2", "Lcom/wear/ui/longDistance/officialaccount/adapter/OfficialSourcesAdapter$OfficialButtonClickListener;", "onClick", "", ImagesContract.URL, "", "onImageClick", "isVideo", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements OfficialSourcesAdapter.a {
        public a() {
        }

        @Override // com.wear.ui.longDistance.officialaccount.adapter.OfficialSourcesAdapter.a
        public void a(@NotNull String url, boolean z) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (z) {
                VideoPlayerActivity.v4(re3.k(), url);
                return;
            }
            Intent intent = new Intent(OfficialAccountActivity.this, (Class<?>) PictureEnlargeActivity.class);
            intent.putExtra("picture_uri", url);
            intent.putExtra("hide_upper_right", true);
            OfficialAccountActivity.this.startActivity(intent);
        }

        @Override // com.wear.ui.longDistance.officialaccount.adapter.OfficialSourcesAdapter.a
        public void b(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            we3.q(re3.k(), url, EntryPoint.Official);
            ku1.a("Lovense Remote", "lovense_remote_message_link_click", "click", "lovense_remote_message_link", "link", url, null, null);
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((OfficialMsg) t).getUserReceiveTime()), Long.valueOf(((OfficialMsg) t2).getUserReceiveTime()));
        }
    }

    public static final void t4(OfficialAccountActivity this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OfficialaCountModel officialaCountModel = this$0.c;
        OfficialSourcesAdapter officialSourcesAdapter = null;
        if (officialaCountModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel = null;
        }
        officialaCountModel.M();
        ActivityOfficialAccountBinding activityOfficialAccountBinding = this$0.a;
        if (activityOfficialAccountBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountBinding = null;
        }
        activityOfficialAccountBinding.d.r();
        this$0.e.clear();
        if (list != null) {
            this$0.e.addAll(list);
            List<OfficialMsg> list2 = this$0.e;
            if (list2.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(list2, new b());
            }
            OfficialSourcesAdapter officialSourcesAdapter2 = this$0.b;
            if (officialSourcesAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                officialSourcesAdapter2 = null;
            }
            officialSourcesAdapter2.y0(this$0.e);
        }
        OfficialSourcesAdapter officialSourcesAdapter3 = this$0.b;
        if (officialSourcesAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            officialSourcesAdapter3 = null;
        }
        if (officialSourcesAdapter3.K().size() > 0) {
            OfficialaCountModel officialaCountModel2 = this$0.c;
            if (officialaCountModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
                officialaCountModel2 = null;
            }
            OfficialAcount value = officialaCountModel2.o().getValue();
            if (value != null) {
                value.setMessage((OfficialMsg) CollectionsKt___CollectionsKt.last((List) this$0.e));
            }
        } else if (this$0.e.size() == 0) {
            OfficialSourcesAdapter officialSourcesAdapter4 = this$0.b;
            if (officialSourcesAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                officialSourcesAdapter4 = null;
            }
            officialSourcesAdapter4.u0(R.layout.smartrefreshlayout_empty_view);
        }
        OfficialaCountModel officialaCountModel3 = this$0.c;
        if (officialaCountModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel3 = null;
        }
        MutableLiveData<OfficialAcount> mutableLiveDataO = officialaCountModel3.o();
        OfficialaCountModel officialaCountModel4 = this$0.c;
        if (officialaCountModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel4 = null;
        }
        mutableLiveDataO.postValue(officialaCountModel4.o().getValue());
        if (this$0.d) {
            ActivityOfficialAccountBinding activityOfficialAccountBinding2 = this$0.a;
            if (activityOfficialAccountBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityOfficialAccountBinding2 = null;
            }
            RecyclerView recyclerView = activityOfficialAccountBinding2.c;
            OfficialSourcesAdapter officialSourcesAdapter5 = this$0.b;
            if (officialSourcesAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                officialSourcesAdapter5 = null;
            }
            recyclerView.scrollToPosition(officialSourcesAdapter5.getItemCount() - 1);
            this$0.d = false;
        }
        OfficialSourcesAdapter officialSourcesAdapter6 = this$0.b;
        if (officialSourcesAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            officialSourcesAdapter = officialSourcesAdapter6;
        }
        officialSourcesAdapter.notifyDataSetChanged();
    }

    public static final void u4(View view) {
        pj3.f(re3.k(), OfficialAccountInfoActivity.class);
    }

    public static final void v4(OfficialAccountActivity this$0, ae1 it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        OfficialaCountModel officialaCountModel = this$0.c;
        if (officialaCountModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel = null;
        }
        officialaCountModel.F(true);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOfficialAccountBinding activityOfficialAccountBindingC = ActivityOfficialAccountBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityOfficialAccountBindingC, "inflate(layoutInflater)");
        this.a = activityOfficialAccountBindingC;
        ActivityOfficialAccountBinding activityOfficialAccountBinding = null;
        if (activityOfficialAccountBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountBindingC = null;
        }
        setContentView(activityOfficialAccountBindingC.getRoot());
        OfficialaCountModel officialaCountModelA = OfficialaCountModel.g.a();
        this.c = officialaCountModelA;
        if (officialaCountModelA == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModelA = null;
        }
        officialaCountModelA.L(0L);
        s4();
        OfficialaCountModel officialaCountModel = this.c;
        if (officialaCountModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel = null;
        }
        List<OfficialMsg> value = officialaCountModel.q().getValue();
        if (value != null) {
            value.clear();
        }
        OfficialaCountModel officialaCountModel2 = this.c;
        if (officialaCountModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel2 = null;
        }
        officialaCountModel2.F(false);
        OfficialaCountModel officialaCountModel3 = this.c;
        if (officialaCountModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel3 = null;
        }
        officialaCountModel3.M();
        OfficialaCountModel officialaCountModel4 = this.c;
        if (officialaCountModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel4 = null;
        }
        MutableLiveData<OfficialAcount> mutableLiveDataO = officialaCountModel4.o();
        OfficialaCountModel officialaCountModel5 = this.c;
        if (officialaCountModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel5 = null;
        }
        mutableLiveDataO.postValue(officialaCountModel5.o().getValue());
        ActivityOfficialAccountBinding activityOfficialAccountBinding2 = this.a;
        if (activityOfficialAccountBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityOfficialAccountBinding = activityOfficialAccountBinding2;
        }
        activityOfficialAccountBinding.b.setParentBackgroundColor(th4.b(this, R.color.lvs_ui_standard_systemBackground));
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OfficialaCountModel officialaCountModel = this.c;
        if (officialaCountModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel = null;
        }
        officialaCountModel.L(0L);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
    }

    public final void s4() {
        ActivityOfficialAccountBinding activityOfficialAccountBinding = this.a;
        OfficialSourcesAdapter officialSourcesAdapter = null;
        if (activityOfficialAccountBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountBinding = null;
        }
        activityOfficialAccountBinding.b.setRightImage(R.drawable.tag_official, 0);
        ActivityOfficialAccountBinding activityOfficialAccountBinding2 = this.a;
        if (activityOfficialAccountBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountBinding2 = null;
        }
        activityOfficialAccountBinding2.d.J(new ClassicsHeader(re3.k()));
        this.b = new OfficialSourcesAdapter(this.e);
        OfficialaCountModel officialaCountModel = this.c;
        if (officialaCountModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("officialaCountModel");
            officialaCountModel = null;
        }
        officialaCountModel.q().observe(this, new Observer() { // from class: dc.s93
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OfficialAccountActivity.t4(this.a, (List) obj);
            }
        });
        OfficialSourcesAdapter officialSourcesAdapter2 = this.b;
        if (officialSourcesAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            officialSourcesAdapter2 = null;
        }
        officialSourcesAdapter2.O0(new a());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        ActivityOfficialAccountBinding activityOfficialAccountBinding3 = this.a;
        if (activityOfficialAccountBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountBinding3 = null;
        }
        activityOfficialAccountBinding3.c.setLayoutManager(linearLayoutManager);
        ActivityOfficialAccountBinding activityOfficialAccountBinding4 = this.a;
        if (activityOfficialAccountBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountBinding4 = null;
        }
        RecyclerView recyclerView = activityOfficialAccountBinding4.c;
        OfficialSourcesAdapter officialSourcesAdapter3 = this.b;
        if (officialSourcesAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            officialSourcesAdapter3 = null;
        }
        recyclerView.setAdapter(officialSourcesAdapter3);
        ActivityOfficialAccountBinding activityOfficialAccountBinding5 = this.a;
        if (activityOfficialAccountBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountBinding5 = null;
        }
        activityOfficialAccountBinding5.b.setIconAction(Integer.valueOf(R.drawable.nav_profile_selector), new MyActionBar.f() { // from class: dc.t93
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                OfficialAccountActivity.u4(view);
            }
        });
        ClassicsHeader classicsHeader = new ClassicsHeader(this);
        ActivityOfficialAccountBinding activityOfficialAccountBinding6 = this.a;
        if (activityOfficialAccountBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountBinding6 = null;
        }
        activityOfficialAccountBinding6.d.J(classicsHeader);
        ActivityOfficialAccountBinding activityOfficialAccountBinding7 = this.a;
        if (activityOfficialAccountBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountBinding7 = null;
        }
        activityOfficialAccountBinding7.d.G(new ne1() { // from class: dc.u93
            @Override // dc.ne1
            public final void b(ae1 ae1Var) {
                OfficialAccountActivity.v4(this.a, ae1Var);
            }
        });
        ActivityOfficialAccountBinding activityOfficialAccountBinding8 = this.a;
        if (activityOfficialAccountBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountBinding8 = null;
        }
        RecyclerView recyclerView2 = activityOfficialAccountBinding8.c;
        OfficialSourcesAdapter officialSourcesAdapter4 = this.b;
        if (officialSourcesAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            officialSourcesAdapter4 = null;
        }
        recyclerView2.scrollToPosition(officialSourcesAdapter4.getItemCount() - 1);
        OfficialSourcesAdapter officialSourcesAdapter5 = this.b;
        if (officialSourcesAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            officialSourcesAdapter = officialSourcesAdapter5;
        }
        officialSourcesAdapter.notifyDataSetChanged();
    }
}
