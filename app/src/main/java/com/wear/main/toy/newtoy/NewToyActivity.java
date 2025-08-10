package com.wear.main.toy.newtoy;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseBindActivity;
import com.wear.bean.StrengthBean;
import com.wear.bean.Toy;
import com.wear.bean.event.ChangeToyEvent;
import com.wear.bean.event.EventBusToyF01ModeEvent;
import com.wear.bean.event.ToyListItemChangeSettingEvent;
import com.wear.databinding.ActivityNewToyBinding;
import com.wear.main.toy.newtoy.MyToyAdapter;
import com.wear.main.toy.newtoy.MyToyStrengthAdapter;
import com.wear.main.toy.newtoy.NewToyActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.br;
import dc.cs3;
import dc.db2;
import dc.ek2;
import dc.fk2;
import dc.gd0;
import dc.h04;
import dc.h32;
import dc.is3;
import dc.kf;
import dc.kn3;
import dc.lp1;
import dc.me0;
import dc.me3;
import dc.mp1;
import dc.n90;
import dc.pc1;
import dc.q61;
import dc.re3;
import dc.rp1;
import dc.rq1;
import dc.sg3;
import dc.u51;
import dc.uc1;
import dc.uy3;
import dc.v51;
import dc.vc1;
import dc.vg3;
import dc.wi2;
import dc.wz3;
import dc.xc1;
import dc.xe3;
import dc.ye3;
import dc.zj2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewToyActivity.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001OB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0002J \u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020 H\u0017J\b\u0010,\u001a\u00020 H\u0016J\u0006\u0010-\u001a\u00020\u0014J\b\u0010.\u001a\u00020/H\u0002J\"\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u00020 H\u0016J\u0012\u00106\u001a\u00020 2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\b\u00109\u001a\u00020 H\u0014J\u0010\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020<H\u0007J\u0012\u0010:\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010=H\u0007J\u0012\u0010:\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010>H\u0007J\u0010\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020?H\u0007J\u0012\u0010:\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010@H\u0007J\u0010\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020AH\u0007J\b\u0010B\u001a\u00020 H\u0014J\u0010\u0010C\u001a\u00020 2\u0006\u0010;\u001a\u00020DH\u0007J\b\u0010E\u001a\u00020 H\u0002J\u0010\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020HH\u0002J\u0018\u0010I\u001a\u00020 2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\rH\u0002J\b\u0010M\u001a\u00020 H\u0002J\b\u0010N\u001a\u00020 H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006P"}, d2 = {"Lcom/wear/main/toy/newtoy/NewToyActivity;", "Lcom/wear/BaseBindActivity;", "Lcom/wear/databinding/ActivityNewToyBinding;", "()V", "btWork", "Lcom/lovense/btservice/work/BtWork;", "getBtWork", "()Lcom/lovense/btservice/work/BtWork;", "setBtWork", "(Lcom/lovense/btservice/work/BtWork;)V", "delayUpdateMyToyListRunnable", "Ljava/lang/Runnable;", "elementId", "", "kotlin.jvm.PlatformType", "mBlueToothReceiver", "Landroid/content/BroadcastReceiver;", "myToyAdapter", "Lcom/wear/main/toy/newtoy/MyToyAdapter;", "scanLogFlag", "", "searchToyAdapter", "Lcom/wear/main/toy/newtoy/SearchToyAdapter;", "showSetting", "toySettingUpdating", "viewModel", "Lcom/wear/main/toy/newtoy/NewToyViewModel;", "getViewModel", "()Lcom/wear/main/toy/newtoy/NewToyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addNoLocationPermissionLog", "", "append", "count", "", "cancelScan", "checkAndroidQLocationPermission", "checkShowWarningMultiple", "delToy", "toyId", "toyName", "position", "initData", "initView", "isOpenGPS", "makeFilter", "Landroid/content/IntentFilter;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMessageEvent", "event", "Lcom/component/dxtoy/core/api/event/ToyScanEvent;", "Lcom/lovense/btservice/work/EventBusToyBatteryEvent;", "Lcom/lovense/btservice/work/EventBusToyConnectEvent;", "Lcom/wear/bean/event/ChangeToyEvent;", "Lcom/wear/bean/event/EventBusToyF01ModeEvent;", "Lcom/wear/main/toy/newtoy/ToyUnReconnectEvent;", "onResume", "onToyListItemChangeSettingEvent", "Lcom/wear/bean/event/ToyListItemChangeSettingEvent;", "scanDevice", "setupBtDisabledText", "textView", "Landroid/widget/TextView;", "showUpdateDialog", "toy", "Lcom/wear/bean/Toy;", "showString", "startAnimator", "updateMyToyListUi", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NewToyActivity extends BaseBindActivity<ActivityNewToyBinding> {

    @NotNull
    public static final a o = new a(null);

    @NotNull
    public final Lazy f;
    public SearchToyAdapter g;
    public MyToyAdapter h;

    @NotNull
    public pc1 i;
    public final String j;
    public boolean k;

    @NotNull
    public final Runnable l;
    public boolean m;

    @NotNull
    public final BroadcastReceiver n;

    /* compiled from: NewToyActivity.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/wear/main/toy/newtoy/NewToyActivity$Companion;", "", "()V", "GPS_ACTION", "", "WARN_MULTIPLE_TOYS_TIPS_CLOSE", "findChangeMyToy", "Lcom/wear/bean/Toy;", "event", "Lcom/wear/bean/event/ChangeToyEvent;", "toyAdapter", "Lcom/wear/main/toy/newtoy/MyToyAdapter;", "onChangeToyEvent", "", "sortMyToyList", "list", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* compiled from: Comparisons.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
        /* renamed from: com.wear.main.toy.newtoy.NewToyActivity$a$a, reason: collision with other inner class name */
        public static final class C0137a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((Toy) t).getUpdateTime()), Long.valueOf(((Toy) t2).getUpdateTime()));
            }
        }

        /* compiled from: Comparisons.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
        public static final class b<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((Toy) t2).getUpdateTime()), Long.valueOf(((Toy) t).getUpdateTime()));
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Toy a(ChangeToyEvent changeToyEvent, MyToyAdapter myToyAdapter) {
            Toy toy = null;
            for (Toy toy2 : myToyAdapter.K()) {
                if (Intrinsics.areEqual(toy2.getAddress(), changeToyEvent.getAddress())) {
                    toy = toy2;
                }
            }
            return toy;
        }

        public final void b(@NotNull ChangeToyEvent event, @NotNull MyToyAdapter toyAdapter) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(toyAdapter, "toyAdapter");
            Toy toyA = a(event, toyAdapter);
            if (!event.isAdd()) {
                if (toyA != null) {
                    toyAdapter.K().remove(toyA);
                    toyAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (toyA == null) {
                pc1 pc1Var = pc1.a;
                String address = event.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "event.address");
                Toy toyQ = pc1Var.Q(address);
                if (toyQ != null) {
                    toyAdapter.K().add(toyQ);
                    toyAdapter.notifyDataSetChanged();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final void c(@NotNull List<Toy> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            if (list.isEmpty() || list.size() == 1) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Toy) obj).isConnected()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list) {
                if (!((Toy) obj2).isConnected()) {
                    arrayList2.add(obj2);
                }
            }
            List listPlus = CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.sortedWith(arrayList, new C0137a()), (Iterable) CollectionsKt___CollectionsKt.sortedWith(arrayList2, new b()));
            list.clear();
            list.addAll(listPlus);
        }
    }

    /* compiled from: NewToyActivity.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/wear/main/toy/newtoy/NewToyActivity$checkAndroidQLocationPermission$1", "Lcom/hjq/permissions/OnPermissionCallback;", "onDenied", "", "permissions", "", "", "never", "", "onGranted", TtmlNode.COMBINE_ALL, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements u51 {
        public b() {
        }

        @Override // dc.u51
        public void a(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            NewToyActivity.this.t4().i().postValue(Boolean.TRUE);
            ye3.d("Z0123", "没有蓝牙权限");
            NewToyActivity.this.v4().b.c.setText(ah4.e(R.string.des_no_bluetooth_permission));
            NewToyActivity.this.v4().e.e.setText(ah4.e(R.string.des_no_bluetooth_permission));
            NewToyActivity.this.v4().b.e.setVisibility(0);
            NewToyActivity.this.m = true;
            NewToyActivity newToyActivity = NewToyActivity.this;
            TextView textView = newToyActivity.v4().e.h;
            Intrinsics.checkNotNullExpressionValue(textView, "dataBinding.newtoyToycon…ntstub.newtoyBldisabledtv");
            newToyActivity.u5(textView);
        }

        @Override // dc.u51
        public void b(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            NewToyActivity.this.t4().i().postValue(Boolean.valueOf(!z));
            ye3.d("Z0123", "没有获取蓝牙全部权限");
            NewToyActivity.this.m = false;
        }
    }

    /* compiled from: NewToyActivity.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/wear/main/toy/newtoy/NewToyActivity$checkAndroidQLocationPermission$2", "Lcom/hjq/permissions/OnPermissionCallback;", "onDenied", "", "permissions", "", "", "never", "", "onGranted", TtmlNode.COMBINE_ALL, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements u51 {
        public c() {
        }

        @Override // dc.u51
        public void a(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            ye3.d("Z0123", "没有获取定位权限");
            NewToyActivity.this.t4().i().postValue(Boolean.TRUE);
            NewToyActivity.this.v4().b.c.setText(ah4.e(R.string.des_gps_permission_required));
            NewToyActivity.this.v4().e.e.setText(ah4.e(R.string.des_gps_permission_required));
            NewToyActivity.this.v4().b.d.setText(ah4.e(R.string.app_trun_on_bluetooth_gps));
            NewToyActivity.this.J4();
            NewToyActivity.this.v4().b.e.setVisibility(0);
            NewToyActivity.this.m = true;
            NewToyActivity newToyActivity = NewToyActivity.this;
            TextView textView = newToyActivity.v4().e.h;
            Intrinsics.checkNotNullExpressionValue(textView, "dataBinding.newtoyToycon…ntstub.newtoyBldisabledtv");
            newToyActivity.u5(textView);
        }

        @Override // dc.u51
        public void b(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            NewToyActivity.this.t4().i().postValue(Boolean.valueOf(!z));
            ye3.d("Z0123", "没有获取定位全部权限");
            NewToyActivity.this.m = false;
        }
    }

    /* compiled from: NewToyActivity.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/main/toy/newtoy/NewToyActivity$delToy$deleteDialog$1", "Lcom/wear/widget/CommonDialog$ClickListener;", "doCancel", "", "doConfirm", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements kn3.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ NewToyActivity b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        public d(String str, NewToyActivity newToyActivity, int i, String str2) {
            this.a = str;
            this.b = newToyActivity;
            this.c = i;
            this.d = str2;
        }

        public static final void a(NewToyActivity this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getI().resetBleParams();
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            rq1.d.r(this.a);
            Toy toyQ = this.b.application.G().Q(this.a);
            if (toyQ == null) {
                return;
            }
            this.b.application.G().E(toyQ);
            toyQ.setDisConnectType(1);
            toyQ.setRealDeviceType(false);
            toyQ.setIsLongRange(0);
            Integer numValueOf = Integer.valueOf(this.c);
            MyToyAdapter myToyAdapter = null;
            if (!(numValueOf.intValue() >= 0)) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                NewToyActivity newToyActivity = this.b;
                int iIntValue = numValueOf.intValue();
                MyToyAdapter myToyAdapter2 = newToyActivity.h;
                if (myToyAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
                    myToyAdapter2 = null;
                }
                myToyAdapter2.q0(iIntValue);
            }
            pc1 pc1VarG = this.b.application.G();
            String address = toyQ.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "deleteToy.address");
            pc1VarG.a0(address, true);
            vg3 vg3VarB = vg3.b();
            final NewToyActivity newToyActivity2 = this.b;
            vg3VarB.a(new Runnable() { // from class: dc.pj2
                @Override // java.lang.Runnable
                public final void run() {
                    NewToyActivity.d.a(newToyActivity2);
                }
            });
            this.b.getI().p0(true);
            re3.u(toyQ);
            rp1.a.j(toyQ);
            db2.A().P();
            h32.i().z();
            wi2.e().f("ToyActivity.delToy()-->toyId:" + this.a + ", toyName:" + this.d);
            ArrayList<Toy> arrayListO = this.b.application.G().o();
            StringBuilder sb = new StringBuilder();
            sb.append("doConfirm: ");
            sb.append(arrayListO.size());
            xe3.a("test", sb.toString());
            MyApplication.l0();
            EventBus.getDefault().post(new uc1(toyQ.getAddress(), -10));
            EventBus.getDefault().post(new xc1(toyQ.getAddress(), -1));
            MyToyAdapter myToyAdapter3 = this.b.h;
            if (myToyAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
                myToyAdapter3 = null;
            }
            myToyAdapter3.notifyItemRemoved(this.c);
            this.b.N4();
            me3.g();
            MyToyAdapter myToyAdapter4 = this.b.h;
            if (myToyAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
            } else {
                myToyAdapter = myToyAdapter4;
            }
            if (myToyAdapter.K().size() != 0) {
                this.b.v4().e.g.setVisibility(0);
                return;
            }
            if (Intrinsics.areEqual(this.b.t4().i().getValue(), Boolean.TRUE)) {
                this.b.t4().j().postValue(Boolean.FALSE);
            }
            this.b.v4().e.g.setVisibility(8);
        }
    }

    /* compiled from: NewToyActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.main.toy.newtoy.NewToyActivity$initData$8$1", f = "NewToyActivity.kt", i = {}, l = {TypedValues.Custom.TYPE_COLOR}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NewToyActivity.this.new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (h04.a(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            NewToyActivity.this.t4().p(30);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NewToyActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/main/toy/newtoy/NewToyActivity$initView$2", "Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter$OnStrengthChangeListener;", "onStrengthChange", "", "bean", "Lcom/wear/bean/StrengthBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements MyToyStrengthAdapter.a {
        public f() {
        }

        @Override // com.wear.main.toy.newtoy.MyToyStrengthAdapter.a
        public void a(@Nullable StrengthBean strengthBean) {
            NewToyActivity.this.t4().r(strengthBean);
        }
    }

    /* compiled from: NewToyActivity.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/main/toy/newtoy/NewToyActivity$initView$5", "Lcom/wear/main/toy/newtoy/MyToyAdapter$OnItemLongClickListener;", "itemLongClick", "", "item", "Lcom/wear/bean/Toy;", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements MyToyAdapter.b {
        public g() {
        }

        @Override // com.wear.main.toy.newtoy.MyToyAdapter.b
        public void a(@NotNull Toy item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            NewToyActivity newToyActivity = NewToyActivity.this;
            String address = item.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "item.address");
            String simpleName = item.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "item.simpleName");
            newToyActivity.P4(address, simpleName, i);
        }
    }

    /* compiled from: NewToyActivity.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/wear/main/toy/newtoy/NewToyActivity$setupBtDisabledText$redTextClickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class h extends ClickableSpan {
        public h() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", NewToyActivity.this.getPackageName(), null));
            NewToyActivity.this.startActivityForResult(intent, 1);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
            ds.setColor(ResourcesCompat.getColor(NewToyActivity.this.getResources(), R.color.diff_select_text_color, null));
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$3"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Function0 function0, ComponentActivity componentActivity) {
            super(0);
            this.$extrasProducer = function0;
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            Function0 function0 = this.$extrasProducer;
            if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                return creationExtras;
            }
            CreationExtras defaultViewModelCreationExtras = this.$this_viewModels.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    public NewToyActivity() {
        super(R.layout.activity_new_toy, 27);
        this.f = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NewToyViewModel.class), new j(this), new i(this), new k(null, this));
        pc1 pc1VarG = WearUtils.x.G();
        Intrinsics.checkNotNullExpressionValue(pc1VarG, "application.btWork");
        this.i = pc1VarG;
        this.j = WearUtils.E();
        this.l = new Runnable() { // from class: dc.sj2
            @Override // java.lang.Runnable
            public final void run() {
                NewToyActivity.Q4(this.a);
            }
        };
        this.n = new BroadcastReceiver() { // from class: com.wear.main.toy.newtoy.NewToyActivity$mBlueToothReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    int iHashCode = action.hashCode();
                    boolean z = true;
                    if (iHashCode != -1530327060) {
                        if (iHashCode == -1184851779 && action.equals("android.location.PROVIDERS_CHANGED")) {
                            if (this.a.d5()) {
                                this.a.m = true;
                                if (this.a.v4().e.l.getVisibility() == 0) {
                                    this.a.t4().j().postValue(Boolean.TRUE);
                                }
                                ye3.d("Z0123", "GPS开启");
                                this.a.M4();
                                return;
                            }
                            this.a.m = false;
                            this.a.t4().i().postValue(Boolean.TRUE);
                            ye3.d("Z0123", "GPS关闭");
                            this.a.t4().j().postValue(Boolean.FALSE);
                            this.a.v4().b.c.setText(ah4.e(R.string.des_gps_disabled));
                            this.a.v4().b.d.setText(ah4.e(R.string.app_trun_on_bluetooth_gps));
                            this.a.v4().e.e.setText(ah4.e(R.string.des_gps_disabled));
                            this.a.v4().b.e.setVisibility(8);
                            this.a.t4().q();
                            return;
                        }
                        return;
                    }
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0)) {
                            case 10:
                                this.a.m = false;
                                this.a.t4().i().postValue(Boolean.TRUE);
                                ye3.d("Z0123", "蓝牙状态关闭");
                                ArrayList<Toy> arrayListO = WearUtils.x.G().o();
                                if (arrayListO != null && !arrayListO.isEmpty()) {
                                    z = false;
                                }
                                if (z) {
                                    this.a.t4().j().postValue(Boolean.FALSE);
                                }
                                this.a.v4().b.c.setText(ah4.e(R.string.des_bluetooth_disabled));
                                this.a.v4().e.e.setText(ah4.e(R.string.des_bluetooth_disabled));
                                this.a.v4().b.e.setVisibility(8);
                                this.a.t4().q();
                                break;
                            case 11:
                                this.a.m = true;
                                if (this.a.v4().e.l.getVisibility() == 0) {
                                    this.a.t4().j().postValue(Boolean.TRUE);
                                }
                                this.a.M4();
                                break;
                            case 12:
                                this.a.m = true;
                                if (this.a.v4().e.l.getVisibility() == 0) {
                                    this.a.t4().j().postValue(Boolean.TRUE);
                                }
                                this.a.M4();
                                this.a.t5();
                                break;
                            case 13:
                                this.a.m = false;
                                this.a.t4().i().postValue(Boolean.TRUE);
                                ye3.d("Z0123", "蓝牙状态变更关闭");
                                ArrayList<Toy> arrayListO2 = WearUtils.x.G().o();
                                if (arrayListO2 != null && !arrayListO2.isEmpty()) {
                                    z = false;
                                }
                                if (z) {
                                    this.a.t4().j().postValue(Boolean.FALSE);
                                }
                                this.a.v4().b.c.setText(ah4.e(R.string.des_bluetooth_disabled));
                                this.a.v4().e.e.setText(ah4.e(R.string.des_bluetooth_disabled));
                                this.a.v4().b.e.setVisibility(8);
                                this.a.t4().q();
                                break;
                        }
                    }
                }
            }
        };
    }

    public static final void O4(NewToyActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v4().e.n.setVisibility(8);
        me0.k("warn_multiple_toys_tips_close", true);
    }

    public static final void Q4(NewToyActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<Toy> arrayListO = WearUtils.x.G().o();
        a aVar = o;
        Intrinsics.checkNotNull(arrayListO, "null cannot be cast to non-null type java.util.ArrayList<com.wear.bean.Toy>{ kotlin.collections.TypeAliasesKt.ArrayList<com.wear.bean.Toy> }");
        aVar.c(arrayListO);
        MyToyAdapter myToyAdapter = this$0.h;
        if (myToyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
            myToyAdapter = null;
        }
        myToyAdapter.y0(arrayListO);
    }

    public static final void T4(NewToyActivity this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!it.booleanValue()) {
            MutableLiveData<Boolean> mutableLiveDataH = this$0.t4().h();
            Boolean bool = Boolean.TRUE;
            mutableLiveDataH.postValue(bool);
            Boolean value = this$0.t4().k().getValue();
            Boolean bool2 = Boolean.FALSE;
            if (Intrinsics.areEqual(value, bool2)) {
                this$0.v4().b.b.setVisibility(8);
                this$0.t4().j().postValue(bool);
                return;
            } else {
                this$0.v4().b.b.setVisibility(8);
                this$0.t4().j().postValue(bool2);
                return;
            }
        }
        ye3.d("Z0123", "蓝牙/定位权限（开关）缺失");
        MutableLiveData<Boolean> mutableLiveDataK = this$0.t4().k();
        Boolean bool3 = Boolean.FALSE;
        mutableLiveDataK.postValue(bool3);
        this$0.t4().g();
        this$0.t4().h().postValue(bool3);
        ArrayList<Toy> arrayListO = WearUtils.x.G().o();
        if (arrayListO == null || arrayListO.isEmpty()) {
            ye3.d("Z0123", "玩具列表没有数据");
            this$0.v4().b.b.setVisibility(0);
            this$0.t4().j().postValue(bool3);
        } else {
            ye3.d("Z0123", "玩具列表有数据");
            this$0.v4().b.b.setVisibility(8);
            this$0.t4().j().postValue(Boolean.TRUE);
        }
    }

    public static final void U4(NewToyActivity this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            this$0.v4().c.c.setVisibility(0);
        } else {
            this$0.v4().c.c.setVisibility(8);
        }
    }

    public static final void V4(NewToyActivity this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            this$0.t5();
            this$0.t4().p(30);
            this$0.v4().e.d.setVisibility(0);
            this$0.v4().e.k.setVisibility(8);
            if (this$0.v4().e.d.o()) {
                return;
            }
            this$0.v4().e.d.r();
            return;
        }
        this$0.v4().e.d.setVisibility(8);
        if (this$0.v4().e.d.o()) {
            this$0.v4().e.d.q();
        }
        if (Intrinsics.areEqual(this$0.t4().i().getValue(), Boolean.TRUE)) {
            this$0.v4().e.k.setVisibility(8);
        } else {
            this$0.v4().e.k.setVisibility(0);
        }
        this$0.t4().q();
    }

    public static final void W4(NewToyActivity this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!it.booleanValue()) {
            this$0.v4().e.l.setVisibility(8);
            if (Intrinsics.areEqual(this$0.t4().i().getValue(), Boolean.TRUE)) {
                ye3.d("Z0123", "玩具列表没有数据并且权限/开关有问题");
                this$0.v4().b.b.setVisibility(0);
                return;
            }
            return;
        }
        this$0.v4().e.l.setVisibility(0);
        if (Intrinsics.areEqual(this$0.t4().i().getValue(), Boolean.TRUE)) {
            this$0.v4().e.c.setVisibility(0);
            this$0.v4().e.b.setVisibility(0);
            this$0.v4().e.k.setVisibility(8);
        } else {
            this$0.v4().e.c.setVisibility(8);
            this$0.v4().e.b.setVisibility(8);
        }
        if (this$0.k) {
            this$0.v4().getRoot().removeCallbacks(this$0.l);
            this$0.v4().getRoot().postDelayed(this$0.l, 5000L);
        } else {
            this$0.l.run();
        }
        this$0.N4();
        if (WearUtils.x.G().o().size() > 0) {
            this$0.v4().e.g.setVisibility(0);
        } else {
            this$0.v4().e.g.setVisibility(8);
        }
    }

    public static final void X4(Ref.IntRef count, NewToyActivity this$0, List list) {
        Intrinsics.checkNotNullParameter(count, "$count");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list == null || list.isEmpty()) {
            return;
        }
        if (count.element != list.size() && count.element > 0) {
            this$0.t4().p(30);
        }
        SearchToyAdapter searchToyAdapter = this$0.g;
        SearchToyAdapter searchToyAdapter2 = null;
        if (searchToyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchToyAdapter");
            searchToyAdapter = null;
        }
        searchToyAdapter.y0(list);
        SearchToyAdapter searchToyAdapter3 = this$0.g;
        if (searchToyAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchToyAdapter");
        } else {
            searchToyAdapter2 = searchToyAdapter3;
        }
        searchToyAdapter2.notifyDataSetChanged();
        count.element = list.size();
    }

    public static final void Y4(NewToyActivity this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!it.booleanValue()) {
            this$0.v4().d.c.setVisibility(8);
        } else {
            this$0.v4().d.c.setVisibility(0);
            this$0.t4().j().postValue(Boolean.FALSE);
        }
    }

    public static final void Z4(NewToyActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this$0.getPackageName(), null));
        this$0.startActivityForResult(intent, 1);
    }

    public static final void a5(NewToyActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchToyAdapter searchToyAdapter = this$0.g;
        if (searchToyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchToyAdapter");
            searchToyAdapter = null;
        }
        searchToyAdapter.y0(new ArrayList());
        SearchToyAdapter searchToyAdapter2 = this$0.g;
        if (searchToyAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchToyAdapter");
            searchToyAdapter2 = null;
        }
        searchToyAdapter2.notifyDataSetChanged();
        this$0.t4().h().postValue(Boolean.TRUE);
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, this$0.new e(null), 3, null);
    }

    public static final void b5(NewToyActivity this$0, BaseQuickAdapter adapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (!Intrinsics.areEqual(this$0.t4().i().getValue(), Boolean.FALSE) || adapter.K().size() <= i2 || adapter.K().size() <= 0) {
            return;
        }
        NewToyViewModel newToyViewModelT4 = this$0.t4();
        Object obj = adapter.K().get(i2);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.wear.bean.Toy");
        newToyViewModelT4.d((Toy) obj);
        adapter.q0(i2);
        this$0.N4();
        this$0.v4().e.g.setVisibility(0);
    }

    public static final void c5(NewToyActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    public static final void w5(Toy toy, NewToyActivity this$0) {
        Intrinsics.checkNotNullParameter(toy, "$toy");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (toy.isConnected()) {
            lp1.a.e(this$0, toy.getAddress());
        } else {
            sg3.h(R.string.toy_settings_no_toy_toast);
        }
    }

    public static final void x5(Toy toy, NewToyActivity this$0) {
        Intrinsics.checkNotNullParameter(toy, "$toy");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EventBus.getDefault().post(new xc1(toy.getAddress(), -1));
        this$0.finish();
    }

    public static final void z5(NewToyActivity this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.v4().c.d.setText(this$0.K4(((Integer) animatedValue).intValue()));
    }

    public final void A5() {
        MyToyAdapter myToyAdapter = this.h;
        if (myToyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
            myToyAdapter = null;
        }
        myToyAdapter.notifyDataSetChanged();
        N4();
    }

    public final void J4() {
        ye3.j("toys", "location_permission_required", "", "", "", "", "", -1L);
    }

    public final String K4(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(ah4.e(R.string.toy_notoy2));
        if (i2 == 0) {
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
            return string;
        }
        for (int i3 = 1; i3 <= i2; i3++) {
            sb.append(".");
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "builder.toString()");
        return string2;
    }

    public final void L4() {
        this.i.i(false);
        this.i.p0(true);
    }

    public final void M4() {
        Object systemService = getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        IntentFilter intentFilter = new IntentFilter();
        if (adapter != null && adapter.isEnabled()) {
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 && i2 <= 30) {
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
        }
        if (i2 >= 33) {
            registerReceiver(this.n, intentFilter, 2);
        } else {
            registerReceiver(this.n, intentFilter);
        }
        if (adapter == null || !adapter.isEnabled()) {
            t4().i().postValue(Boolean.TRUE);
            ye3.d("Z0123", "蓝牙未开启");
            v4().b.c.setText(ah4.e(R.string.des_bluetooth_disabled));
            v4().e.e.setText(ah4.e(R.string.des_bluetooth_disabled));
            v4().e.h.setText(ah4.e(R.string.connect_toy_entrance2));
            TextView textView = v4().e.h;
            Intrinsics.checkNotNullExpressionValue(textView, "dataBinding.newtoyToycon…ntstub.newtoyBldisabledtv");
            u5(textView);
            v4().b.e.setVisibility(8);
            return;
        }
        if (i2 >= 31) {
            q61 q61VarM = q61.m(this);
            q61VarM.i(v51.a.a);
            q61VarM.j(new b());
            v4().e.h.setText(ah4.e(R.string.connect_toy_entrance2));
            return;
        }
        if (!(24 <= i2 && i2 < 31)) {
            t4().i().postValue(Boolean.FALSE);
            return;
        }
        Object systemService2 = getSystemService(FirebaseAnalytics.Param.LOCATION);
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.location.LocationManager");
        if (((LocationManager) systemService2).isProviderEnabled("gps")) {
            q61 q61VarM2 = q61.m(this);
            q61VarM2.h("android.permission.ACCESS_FINE_LOCATION");
            q61VarM2.h("android.permission.ACCESS_COARSE_LOCATION");
            q61VarM2.j(new c());
        } else {
            t4().i().postValue(Boolean.TRUE);
            v4().b.d.setText(ah4.e(R.string.app_trun_on_bluetooth_gps));
            v4().b.c.setText(ah4.e(R.string.des_gps_disabled));
            v4().e.e.setText(ah4.e(R.string.des_gps_disabled));
            ye3.d("Z0123", "没有开启GPS");
            TextView textView2 = v4().e.h;
            Intrinsics.checkNotNullExpressionValue(textView2, "dataBinding.newtoyToycon…ntstub.newtoyBldisabledtv");
            u5(textView2);
            v4().b.e.setVisibility(8);
        }
        v4().e.h.setText(ah4.e(R.string.app_trun_on_bluetooth_gps));
    }

    public final void N4() {
        Object next;
        try {
            Iterator<T> it = pc1.a.o().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (((Toy) next).isBAToy()) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            if (!(next != null)) {
                v4().e.n.setVisibility(8);
                return;
            }
            pc1 pc1Var = pc1.a;
            if (pc1Var.P().size() < 2) {
                v4().e.n.setVisibility(8);
                return;
            }
            boolean z = false;
            for (Toy toy : pc1Var.P()) {
                if (toy.isBAToy() && fk2.a.c(toy.getAddress()) == ek2.POSITION) {
                    z = true;
                }
            }
            if (!z) {
                v4().e.n.setVisibility(8);
            } else if (me0.a("warn_multiple_toys_tips_close", false)) {
                v4().e.n.setVisibility(8);
            } else {
                v4().e.n.setVisibility(0);
                v4().e.f.setOnClickListener(new View.OnClickListener() { // from class: dc.uj2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NewToyActivity.O4(this.a, view);
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void P4(String str, String str2, int i2) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str3 = String.format(ah4.e(R.string.common_dialog_delete).toString(), Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
        kn3 kn3Var = new kn3((Context) this, str3, ah4.e(R.string.common_delete), ah4.e(R.string.common_cancel), true, (kn3.d) new d(str, this, i2, str2));
        kn3Var.show();
        kn3Var.p();
    }

    @NotNull
    /* renamed from: R4, reason: from getter */
    public final pc1 getI() {
        return this.i;
    }

    @Override // com.wear.BaseViewModelActivity
    @NotNull
    /* renamed from: S4, reason: merged with bridge method [inline-methods] */
    public NewToyViewModel t4() {
        return (NewToyViewModel) this.f.getValue();
    }

    public final boolean d5() {
        Object systemService = getSystemService(FirebaseAnalytics.Param.LOCATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        M4();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBackPressed() {
        /*
            r7 = this;
            dc.pc1 r0 = r7.i
            java.util.ArrayList r0 = r0.P()
            boolean r1 = r0.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            r3 = 0
            if (r1 == 0) goto L71
            java.util.Iterator r0 = r0.iterator()
        L13:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L71
            java.lang.Object r1 = r0.next()
            com.wear.bean.Toy r1 = (com.wear.bean.Toy) r1
            boolean r4 = r1.isEI01Toy()
            if (r4 == 0) goto L2d
            int r4 = r1.getToyVersion()
            r5 = 3
            if (r4 >= r5) goto L2d
            goto L72
        L2d:
            boolean r4 = r1.isEAToy()
            r5 = 4
            if (r4 == 0) goto L3b
            int r4 = r1.getToyVersion()
            if (r4 >= r5) goto L3b
            goto L72
        L3b:
            boolean r4 = r1.isXMachine()
            if (r4 == 0) goto L64
            int r4 = r1.getToyVersion()
            r6 = 50
            if (r6 > r4) goto L4f
            r6 = 52
            if (r4 >= r6) goto L4f
            r4 = 1
            goto L50
        L4f:
            r4 = 0
        L50:
            if (r4 != 0) goto L72
            int r4 = r1.getToyVersion()
            r6 = 80
            if (r6 > r4) goto L60
            r6 = 84
            if (r4 >= r6) goto L60
            r4 = 1
            goto L61
        L60:
            r4 = 0
        L61:
            if (r4 == 0) goto L64
            goto L72
        L64:
            boolean r4 = r1.isMiniXMachine()
            if (r4 == 0) goto L13
            int r4 = r1.getToyVersion()
            if (r4 >= r5) goto L13
            goto L72
        L71:
            r1 = 0
        L72:
            if (r1 == 0) goto Lf3
            boolean r0 = r1.isEI01Toy()
            if (r0 == 0) goto L8a
            r0 = 2131887850(0x7f1206ea, float:1.9410319E38)
            java.lang.String r0 = dc.ah4.e(r0)
            java.lang.String r2 = "getString(R.string.notif…n_update_flexer_firmware)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r7.v5(r1, r0)
            goto Lf6
        L8a:
            boolean r0 = r1.isEAToy()
            if (r0 == 0) goto La0
            r0 = 2131887847(0x7f1206e7, float:1.9410313E38)
            java.lang.String r0 = dc.ah4.e(r0)
            java.lang.String r2 = "getString(R.string.notification_update__firmware4)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r7.v5(r1, r0)
            goto Lf6
        La0:
            boolean r0 = r1.isXMachine()
            java.lang.String r4 = "format(format, *args)"
            java.lang.String r5 = "getString(R.string.notification_update_firmware2)"
            r6 = 2131887849(0x7f1206e9, float:1.9410317E38)
            if (r0 == 0) goto Lcd
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r0 = dc.ah4.e(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = r1.getShowName()
            r5[r3] = r6
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r2)
            java.lang.String r0 = java.lang.String.format(r0, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            r7.v5(r1, r0)
            goto Lf6
        Lcd:
            boolean r0 = r1.isMiniXMachine()
            if (r0 == 0) goto Lf6
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r0 = dc.ah4.e(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r6 = r1.getShowName()
            r5[r3] = r6
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r2)
            java.lang.String r0 = java.lang.String.format(r0, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            r7.v5(r1, r0)
            goto Lf6
        Lf3:
            super.onBackPressed()
        Lf6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.newtoy.NewToyActivity.onBackPressed():void");
    }

    @Override // com.wear.BaseBindActivity, com.wear.BaseViewModelActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i2 = MyApplication.m0;
        if (i2 == 0) {
            if (!MyApplication.l0) {
                setTheme(R.style.ToySearchTheme);
            }
        } else if (i2 == 1) {
            setTheme(R.style.ToySearchTheme);
        }
        super.onCreate(savedInstanceState);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        t4().q();
        L4();
        EventBus.getDefault().unregister(this);
        unregisterReceiver(this.n);
        pc1.a.k("");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@NotNull n90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        t4().g();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        A5();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onToyListItemChangeSettingEvent(@NotNull ToyListItemChangeSettingEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.k = event.isTouchMoving();
    }

    public final void t5() {
        this.i.h();
        this.i.i(true);
    }

    public final void u5(TextView textView) {
        String str;
        int iIndexOf$default;
        if (this.m) {
            str = ah4.e(R.string.button_go_to_settings) + " >";
        } else {
            str = "";
        }
        String str2 = "showSetting===" + this.m;
        String str3 = ((Object) textView.getText()) + str;
        SpannableString spannableString = new SpannableString(str3);
        if (this.m && (iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str3, str, 0, false, 6, (Object) null)) != -1) {
            spannableString.setSpan(new h(), iIndexOf$default, str.length() + iIndexOf$default, 17);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void v5(final Toy toy, String str) {
        cs3.e(this, ah4.e(R.string.button_notice), str, ah4.e(R.string.common_update), ah4.e(R.string.button_not_now), new is3.d() { // from class: dc.rj2
            @Override // dc.is3.d
            public final void doConfirm() {
                NewToyActivity.w5(toy, this);
            }
        }, new is3.c() { // from class: dc.nj2
            @Override // dc.is3.c
            public final void doCancel() {
                NewToyActivity.x5(toy, this);
            }
        }).show();
    }

    @Override // com.wear.BaseBindActivity
    @SuppressLint({"NotifyDataSetChanged"})
    public void w4() {
        t4().i().observe(this, new Observer() { // from class: dc.vj2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewToyActivity.T4(this.a, (Boolean) obj);
            }
        });
        t4().k().observe(this, new Observer() { // from class: dc.hj2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewToyActivity.U4(this.a, (Boolean) obj);
            }
        });
        t4().h().observe(this, new Observer() { // from class: dc.lj2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewToyActivity.V4(this.a, (Boolean) obj);
            }
        });
        ArrayList<Toy> arrayListO = WearUtils.x.G().o();
        a aVar = o;
        Intrinsics.checkNotNull(arrayListO, "null cannot be cast to non-null type java.util.ArrayList<com.wear.bean.Toy>{ kotlin.collections.TypeAliasesKt.ArrayList<com.wear.bean.Toy> }");
        aVar.c(arrayListO);
        MyToyAdapter myToyAdapter = this.h;
        if (myToyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
            myToyAdapter = null;
        }
        myToyAdapter.y0(arrayListO);
        t4().j().observe(this, new Observer() { // from class: dc.qj2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewToyActivity.W4(this.a, (Boolean) obj);
            }
        });
        final Ref.IntRef intRef = new Ref.IntRef();
        t4().f().observe(this, new Observer() { // from class: dc.kj2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewToyActivity.X4(intRef, this, (List) obj);
            }
        });
        t4().l().observe(this, new Observer() { // from class: dc.tj2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewToyActivity.Y4(this.a, (Boolean) obj);
            }
        });
        v4().b.e.setOnClickListener(new View.OnClickListener() { // from class: dc.jj2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewToyActivity.Z4(this.a, view);
            }
        });
        v4().e.k.setOnClickListener(new View.OnClickListener() { // from class: dc.ij2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewToyActivity.a5(this.a, view);
            }
        });
    }

    @Override // com.wear.BaseBindActivity
    public void x4() {
        MyToyAdapter myToyAdapter = null;
        ye3.c("My toys", "into page", null);
        EventBus.getDefault().register(this);
        if (gd0.i()) {
            MyActionBar myActionBar = v4().a;
            StringBuilder sb = new StringBuilder();
            sb.append(mp1.a.b() ? "【New】" : "【Old】");
            sb.append(ah4.e(R.string.common_patterns_toys));
            myActionBar.setTitle(sb.toString());
        }
        v4().c.c.setVisibility(0);
        t4().g();
        M4();
        kf.z(this).t(Integer.valueOf(R.drawable.adv)).A0(v4().c.b);
        y5();
        this.g = new SearchToyAdapter();
        RecyclerView recyclerView = v4().e.j;
        SearchToyAdapter searchToyAdapter = this.g;
        if (searchToyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchToyAdapter");
            searchToyAdapter = null;
        }
        recyclerView.setAdapter(searchToyAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyToyAdapter myToyAdapter2 = new MyToyAdapter();
        this.h = myToyAdapter2;
        if (myToyAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
            myToyAdapter2 = null;
        }
        myToyAdapter2.b1(new f());
        MyToyAdapter myToyAdapter3 = this.h;
        if (myToyAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
            myToyAdapter3 = null;
        }
        myToyAdapter3.Z0(this.j);
        RecyclerView recyclerView2 = v4().e.i;
        MyToyAdapter myToyAdapter4 = this.h;
        if (myToyAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
            myToyAdapter4 = null;
        }
        recyclerView2.setAdapter(myToyAdapter4);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(1);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        SearchToyAdapter searchToyAdapter2 = this.g;
        if (searchToyAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchToyAdapter");
            searchToyAdapter2 = null;
        }
        searchToyAdapter2.E0(new br() { // from class: dc.wj2
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                NewToyActivity.b5(this.a, baseQuickAdapter, view, i2);
            }
        });
        v4().d.d.bringToFront();
        MyToyAdapter myToyAdapter5 = this.h;
        if (myToyAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
        } else {
            myToyAdapter = myToyAdapter5;
        }
        myToyAdapter.a1(new g());
        v4().a.setBackAction(new MyActionBar.f() { // from class: dc.oj2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                NewToyActivity.c5(this.a, view);
            }
        });
        pc1.a.k(this.j);
        TextView textView = v4().d.b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strE = ah4.e(R.string.connect_toy_tip3);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.connect_toy_tip3)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{7}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
    }

    public final void y5() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 4);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: dc.mj2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NewToyActivity.z5(this.a, valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(4000L);
        valueAnimatorOfInt.setRepeatCount(200);
        valueAnimatorOfInt.setRepeatMode(1);
        valueAnimatorOfInt.start();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@NotNull zj2 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a aVar = o;
        MyToyAdapter myToyAdapter = this.h;
        if (myToyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
            myToyAdapter = null;
        }
        List<Toy> listK = myToyAdapter.K();
        Intrinsics.checkNotNull(listK, "null cannot be cast to non-null type java.util.ArrayList<com.wear.bean.Toy>{ kotlin.collections.TypeAliasesKt.ArrayList<com.wear.bean.Toy> }");
        aVar.c((ArrayList) listK);
        A5();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@NotNull ChangeToyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a aVar = o;
        MyToyAdapter myToyAdapter = this.h;
        if (myToyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
            myToyAdapter = null;
        }
        aVar.b(event, myToyAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @SuppressLint({"NotifyDataSetChanged"})
    public final void onMessageEvent(@Nullable xc1 xc1Var) {
        SearchToyAdapter searchToyAdapter = null;
        if (xc1Var != null && xc1Var.b() == 1) {
            MyToyAdapter myToyAdapter = this.h;
            if (myToyAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
                myToyAdapter = null;
            }
            if (myToyAdapter.K().size() > 1) {
                a aVar = o;
                MyToyAdapter myToyAdapter2 = this.h;
                if (myToyAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
                    myToyAdapter2 = null;
                }
                List<Toy> listK = myToyAdapter2.K();
                Intrinsics.checkNotNull(listK, "null cannot be cast to non-null type java.util.ArrayList<com.wear.bean.Toy>{ kotlin.collections.TypeAliasesKt.ArrayList<com.wear.bean.Toy> }");
                aVar.c((ArrayList) listK);
            }
        }
        A5();
        SearchToyAdapter searchToyAdapter2 = this.g;
        if (searchToyAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchToyAdapter");
        } else {
            searchToyAdapter = searchToyAdapter2;
        }
        searchToyAdapter.notifyDataSetChanged();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @SuppressLint({"NotifyDataSetChanged"})
    public final void onMessageEvent(@Nullable vc1 vc1Var) {
        StringBuilder sb = new StringBuilder();
        sb.append("电量信息变更");
        sb.append(vc1Var != null ? Integer.valueOf(vc1Var.b()) : null);
        sb.toString();
        A5();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @SuppressLint({"NotifyDataSetChanged"})
    public final void onMessageEvent(@Nullable EventBusToyF01ModeEvent event) {
        MyToyAdapter myToyAdapter = this.h;
        if (myToyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
            myToyAdapter = null;
        }
        List<Toy> listK = myToyAdapter.K();
        ArrayList<Toy> arrayList = new ArrayList();
        for (Object obj : listK) {
            if (Intrinsics.areEqual(((Toy) obj).getAddress(), event != null ? event.getAddress() : null)) {
                arrayList.add(obj);
            }
        }
        for (Toy toy : arrayList) {
            MyToyAdapter myToyAdapter2 = this.h;
            if (myToyAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
                myToyAdapter2 = null;
            }
            MyToyAdapter myToyAdapter3 = this.h;
            if (myToyAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myToyAdapter");
                myToyAdapter3 = null;
            }
            myToyAdapter2.notifyItemChanged(myToyAdapter3.K().indexOf(toy));
        }
    }
}
