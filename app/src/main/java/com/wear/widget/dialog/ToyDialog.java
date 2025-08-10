package com.wear.widget.dialog;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.bean.StrengthBean;
import com.wear.bean.Toy;
import com.wear.bean.event.ChangeToyEvent;
import com.wear.databinding.DialogNewToyBinding;
import com.wear.main.toy.newtoy.MyToyAdapter;
import com.wear.main.toy.newtoy.MyToyStrengthAdapter;
import com.wear.main.toy.newtoy.NewToyActivity;
import com.wear.main.toy.newtoy.NewToyViewModel;
import com.wear.main.toy.newtoy.SearchToyAdapter;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.ToyDialog;
import dc.a14;
import dc.ah4;
import dc.br;
import dc.db2;
import dc.h04;
import dc.h32;
import dc.kf;
import dc.kn3;
import dc.me3;
import dc.n90;
import dc.pc1;
import dc.q61;
import dc.qf;
import dc.re3;
import dc.rp1;
import dc.rq1;
import dc.u51;
import dc.uc1;
import dc.uy3;
import dc.v51;
import dc.vg3;
import dc.wi2;
import dc.wz3;
import dc.xc1;
import dc.xe3;
import dc.ye3;
import dc.zj2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyDialog.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 T2\u00020\u0001:\u0002TUB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J \u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020%H\u0002J\b\u0010,\u001a\u00020\"H\u0003J\b\u0010-\u001a\u00020\"H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\"\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u000106H\u0016J$\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010=\u001a\u00020\"H\u0016J\u0010\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020CH\u0007J\u0012\u0010A\u001a\u00020\"2\b\u0010B\u001a\u0004\u0018\u00010DH\u0007J\u0010\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020EH\u0007J\u0010\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020FH\u0007J\b\u0010G\u001a\u00020\"H\u0016J\u001a\u0010H\u001a\u00020\"2\u0006\u0010I\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010J\u001a\u00020\"H\u0002J\u000e\u0010K\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010L\u001a\u00020\"2\u0006\u0010M\u001a\u00020NH\u0002J\u0018\u0010O\u001a\u00020\"2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020%H\u0002J\b\u0010S\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001f¨\u0006V"}, d2 = {"Lcom/wear/widget/dialog/ToyDialog;", "Lcom/wear/widget/dialog/CustomBottomSheetDialogFragment;", "()V", "btWork", "Lcom/lovense/btservice/work/BtWork;", "dataBinding", "Lcom/wear/databinding/DialogNewToyBinding;", "elementId", "", "kotlin.jvm.PlatformType", "mBlueToothReceiver", "Landroid/content/BroadcastReceiver;", "myToyAdapter", "Lcom/wear/main/toy/newtoy/MyToyAdapter;", "getMyToyAdapter", "()Lcom/wear/main/toy/newtoy/MyToyAdapter;", "myToyAdapter$delegate", "Lkotlin/Lazy;", "onDismissListener", "Lcom/wear/widget/dialog/ToyDialog$OnDismissListener;", "scanLogFlag", "", "searchToyAdapter", "Lcom/wear/main/toy/newtoy/SearchToyAdapter;", "getSearchToyAdapter", "()Lcom/wear/main/toy/newtoy/SearchToyAdapter;", "searchToyAdapter$delegate", "showSetting", "viewModel", "Lcom/wear/main/toy/newtoy/NewToyViewModel;", "getViewModel", "()Lcom/wear/main/toy/newtoy/NewToyViewModel;", "viewModel$delegate", "addNoLocationPermissionLog", "", "append", "count", "", "cancelScan", "checkAndroidQLocationPermission", "delToy", "toyId", "toyName", "position", "initData", "initView", "isOpenGPS", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onMessageEvent", "event", "Lcom/component/dxtoy/core/api/event/ToyScanEvent;", "Lcom/lovense/btservice/work/EventBusToyConnectEvent;", "Lcom/wear/bean/event/ChangeToyEvent;", "Lcom/wear/main/toy/newtoy/ToyUnReconnectEvent;", "onResume", "onViewCreated", "view", "scanDevice", "setOnDismissListener", "setupBtDisabledText", "textView", "Landroid/widget/TextView;", "showUpdataDialog", "toy", "Lcom/wear/bean/Toy;", "showString", "startAnimator", "Companion", "OnDismissListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ToyDialog extends CustomBottomSheetDialogFragment {

    @NotNull
    public static final a j = new a(null);

    @NotNull
    public final Lazy a;
    public DialogNewToyBinding b;

    @NotNull
    public final Lazy c;

    @NotNull
    public final Lazy d;

    @NotNull
    public pc1 e;
    public final String f;
    public boolean g;

    @Nullable
    public b h;

    @NotNull
    public final BroadcastReceiver i;

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/wear/widget/dialog/ToyDialog$Companion;", "", "()V", "GPS_ACTION", "", "newInstance", "Lcom/wear/widget/dialog/ToyDialog;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ToyDialog a() {
            return new ToyDialog();
        }
    }

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wear/widget/dialog/ToyDialog$OnDismissListener;", "", "onDismiss", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void onDismiss();
    }

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/wear/widget/dialog/ToyDialog$checkAndroidQLocationPermission$1", "Lcom/hjq/permissions/OnPermissionCallback;", "onDenied", "", "permissions", "", "", "never", "", "onGranted", TtmlNode.COMBINE_ALL, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements u51 {
        public c() {
        }

        @Override // dc.u51
        public void a(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            ToyDialog.this.X().i().postValue(Boolean.TRUE);
            ye3.d("Z0123", "没有蓝牙权限");
            DialogNewToyBinding dialogNewToyBinding = ToyDialog.this.b;
            DialogNewToyBinding dialogNewToyBinding2 = null;
            if (dialogNewToyBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding = null;
            }
            dialogNewToyBinding.b.c.setText(ah4.e(R.string.des_no_bluetooth_permission));
            DialogNewToyBinding dialogNewToyBinding3 = ToyDialog.this.b;
            if (dialogNewToyBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding3 = null;
            }
            dialogNewToyBinding3.e.e.setText(ah4.e(R.string.des_no_bluetooth_permission));
            DialogNewToyBinding dialogNewToyBinding4 = ToyDialog.this.b;
            if (dialogNewToyBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding4 = null;
            }
            dialogNewToyBinding4.b.e.setVisibility(0);
            ToyDialog.this.g = true;
            ToyDialog toyDialog = ToyDialog.this;
            DialogNewToyBinding dialogNewToyBinding5 = toyDialog.b;
            if (dialogNewToyBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding2 = dialogNewToyBinding5;
            }
            TextView textView = dialogNewToyBinding2.e.h;
            Intrinsics.checkNotNullExpressionValue(textView, "dataBinding.newtoyToycon…ntstub.newtoyBldisabledtv");
            toyDialog.A0(textView);
        }

        @Override // dc.u51
        public void b(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            ToyDialog.this.X().i().postValue(Boolean.valueOf(!z));
            ye3.d("Z0123", "没有获取蓝牙全部权限");
            ToyDialog.this.g = false;
        }
    }

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/wear/widget/dialog/ToyDialog$checkAndroidQLocationPermission$2", "Lcom/hjq/permissions/OnPermissionCallback;", "onDenied", "", "permissions", "", "", "never", "", "onGranted", TtmlNode.COMBINE_ALL, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements u51 {
        public d() {
        }

        @Override // dc.u51
        public void a(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            ye3.d("Z0123", "没有获取定位权限");
            ToyDialog.this.X().i().postValue(Boolean.TRUE);
            DialogNewToyBinding dialogNewToyBinding = ToyDialog.this.b;
            DialogNewToyBinding dialogNewToyBinding2 = null;
            if (dialogNewToyBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding = null;
            }
            dialogNewToyBinding.b.c.setText(ah4.e(R.string.des_gps_permission_required));
            DialogNewToyBinding dialogNewToyBinding3 = ToyDialog.this.b;
            if (dialogNewToyBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding3 = null;
            }
            dialogNewToyBinding3.e.e.setText(ah4.e(R.string.des_gps_permission_required));
            DialogNewToyBinding dialogNewToyBinding4 = ToyDialog.this.b;
            if (dialogNewToyBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding4 = null;
            }
            dialogNewToyBinding4.b.d.setText(ah4.e(R.string.app_trun_on_bluetooth_gps));
            ToyDialog.this.M();
            DialogNewToyBinding dialogNewToyBinding5 = ToyDialog.this.b;
            if (dialogNewToyBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding5 = null;
            }
            dialogNewToyBinding5.b.e.setVisibility(0);
            ToyDialog.this.g = true;
            ToyDialog toyDialog = ToyDialog.this;
            DialogNewToyBinding dialogNewToyBinding6 = toyDialog.b;
            if (dialogNewToyBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding2 = dialogNewToyBinding6;
            }
            TextView textView = dialogNewToyBinding2.e.h;
            Intrinsics.checkNotNullExpressionValue(textView, "dataBinding.newtoyToycon…ntstub.newtoyBldisabledtv");
            toyDialog.A0(textView);
        }

        @Override // dc.u51
        public void b(@NotNull List<String> permissions, boolean z) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            ToyDialog.this.X().i().postValue(Boolean.valueOf(!z));
            ye3.d("Z0123", "没有获取定位全部权限");
            ToyDialog.this.g = false;
        }
    }

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/widget/dialog/ToyDialog$delToy$deleteDialog$1", "Lcom/wear/widget/CommonDialog$ClickListener;", "doCancel", "", "doConfirm", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements kn3.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ ToyDialog b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        public e(String str, ToyDialog toyDialog, int i, String str2) {
            this.a = str;
            this.b = toyDialog;
            this.c = i;
            this.d = str2;
        }

        public static final void a(ToyDialog this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.e.resetBleParams();
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            rq1.d.r(this.a);
            Toy toyQ = this.b.e.Q(this.a);
            if (toyQ == null) {
                return;
            }
            this.b.e.E(toyQ);
            toyQ.setDisConnectType(1);
            toyQ.setRealDeviceType(false);
            toyQ.setIsLongRange(0);
            this.b.V().q0(this.c);
            pc1 pc1Var = this.b.e;
            String address = toyQ.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "deleteToy.address");
            pc1Var.a0(address, true);
            vg3 vg3VarB = vg3.b();
            final ToyDialog toyDialog = this.b;
            vg3VarB.a(new Runnable() { // from class: dc.ir3
                @Override // java.lang.Runnable
                public final void run() {
                    ToyDialog.e.a(toyDialog);
                }
            });
            this.b.e.p0(true);
            re3.u(toyQ);
            rp1.a.j(toyQ);
            db2.A().P();
            h32.i().z();
            wi2.e().f("ToyActivity.delToy()-->toyId:" + this.a + ", toyName:" + this.d);
            ArrayList<Toy> arrayListO = this.b.e.o();
            StringBuilder sb = new StringBuilder();
            sb.append("doConfirm: ");
            sb.append(arrayListO.size());
            xe3.a("test", sb.toString());
            MyApplication.l0();
            EventBus.getDefault().post(new uc1(toyQ.getAddress(), -10));
            EventBus.getDefault().post(new xc1(toyQ.getAddress(), -1));
            me3.g();
            if (this.b.V().K().size() == 0 && Intrinsics.areEqual(this.b.X().i().getValue(), Boolean.TRUE)) {
                this.b.X().j().postValue(Boolean.FALSE);
            }
        }
    }

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.widget.dialog.ToyDialog$initData$8$1", f = "ToyDialog.kt", i = {}, l = {353}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ToyDialog.this.new f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((f) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
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
            ToyDialog.this.X().p(30);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/widget/dialog/ToyDialog$initView$2", "Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter$OnStrengthChangeListener;", "onStrengthChange", "", "bean", "Lcom/wear/bean/StrengthBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements MyToyStrengthAdapter.a {
        public g() {
        }

        @Override // com.wear.main.toy.newtoy.MyToyStrengthAdapter.a
        public void a(@Nullable StrengthBean strengthBean) {
            ToyDialog.this.X().r(strengthBean);
        }
    }

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/widget/dialog/ToyDialog$initView$5", "Lcom/wear/main/toy/newtoy/MyToyAdapter$OnItemLongClickListener;", "itemLongClick", "", "item", "Lcom/wear/bean/Toy;", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class h implements MyToyAdapter.b {
        public h() {
        }

        @Override // com.wear.main.toy.newtoy.MyToyAdapter.b
        public void a(@NotNull Toy item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            ToyDialog toyDialog = ToyDialog.this;
            String address = item.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "item.address");
            String simpleName = item.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "item.simpleName");
            toyDialog.R(address, simpleName, i);
        }
    }

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/main/toy/newtoy/MyToyAdapter;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function0<MyToyAdapter> {
        public static final i a = new i();

        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MyToyAdapter invoke() {
            return new MyToyAdapter();
        }
    }

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/main/toy/newtoy/SearchToyAdapter;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function0<SearchToyAdapter> {
        public static final j a = new j();

        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SearchToyAdapter invoke() {
            return new SearchToyAdapter();
        }
    }

    /* compiled from: ToyDialog.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/wear/widget/dialog/ToyDialog$setupBtDisabledText$redTextClickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class k extends ClickableSpan {
        public k() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", ToyDialog.this.requireContext().getPackageName(), null));
            ToyDialog.this.startActivityForResult(intent, 1);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
            ds.setColor(ResourcesCompat.getColor(ToyDialog.this.getResources(), R.color.diff_select_text_color, null));
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$5"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function0<Fragment> {
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStoreOwner;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$owner$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ Function0 $ownerProducer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Function0 function0) {
            super(0);
            this.$ownerProducer = function0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner) this.$ownerProducer.invoke();
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$6"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ Lazy $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Lazy lazy) {
            super(0);
            this.$owner$delegate = lazy;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = FragmentViewModelLazyKt.m20viewModels$lambda1(this.$owner$delegate).getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$7"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ Lazy $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Function0 function0, Lazy lazy) {
            super(0);
            this.$extrasProducer = function0;
            this.$owner$delegate = lazy;
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
            ViewModelStoreOwner viewModelStoreOwnerM20viewModels$lambda1 = FragmentViewModelLazyKt.m20viewModels$lambda1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM20viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM20viewModels$lambda1 : null;
            CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
            return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$8"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ Lazy $owner$delegate;
        public final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Fragment fragment, Lazy lazy) {
            super(0);
            this.$this_viewModels = fragment;
            this.$owner$delegate = lazy;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            ViewModelStoreOwner viewModelStoreOwnerM20viewModels$lambda1 = FragmentViewModelLazyKt.m20viewModels$lambda1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM20viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM20viewModels$lambda1 : null;
            if (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) {
                defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
            }
            Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    public ToyDialog() {
        Lazy lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new m(new l(this)));
        this.a = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NewToyViewModel.class), new n(lazy), new o(null, lazy), new p(this, lazy));
        this.c = LazyKt__LazyJVMKt.lazy(j.a);
        this.d = LazyKt__LazyJVMKt.lazy(i.a);
        pc1 pc1VarG = WearUtils.x.G();
        Intrinsics.checkNotNullExpressionValue(pc1VarG, "application.btWork");
        this.e = pc1VarG;
        this.f = WearUtils.E();
        this.i = new BroadcastReceiver() { // from class: com.wear.widget.dialog.ToyDialog$mBlueToothReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    int iHashCode = action.hashCode();
                    DialogNewToyBinding dialogNewToyBinding = null;
                    if (iHashCode != -1530327060) {
                        if (iHashCode == -1184851779 && action.equals("android.location.PROVIDERS_CHANGED")) {
                            if (this.a.l0()) {
                                this.a.g = true;
                                DialogNewToyBinding dialogNewToyBinding2 = this.a.b;
                                if (dialogNewToyBinding2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                } else {
                                    dialogNewToyBinding = dialogNewToyBinding2;
                                }
                                if (dialogNewToyBinding.e.l.getVisibility() == 0) {
                                    this.a.X().j().postValue(Boolean.TRUE);
                                }
                                ye3.d("Z0123", "GPS开启");
                                this.a.Q();
                                return;
                            }
                            this.a.g = false;
                            this.a.X().i().postValue(Boolean.TRUE);
                            ye3.d("Z0123", "GPS关闭");
                            this.a.X().j().postValue(Boolean.FALSE);
                            DialogNewToyBinding dialogNewToyBinding3 = this.a.b;
                            if (dialogNewToyBinding3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                dialogNewToyBinding3 = null;
                            }
                            dialogNewToyBinding3.b.c.setText(ah4.e(R.string.des_gps_disabled));
                            DialogNewToyBinding dialogNewToyBinding4 = this.a.b;
                            if (dialogNewToyBinding4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                dialogNewToyBinding4 = null;
                            }
                            dialogNewToyBinding4.b.d.setText(ah4.e(R.string.app_trun_on_bluetooth_gps));
                            DialogNewToyBinding dialogNewToyBinding5 = this.a.b;
                            if (dialogNewToyBinding5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                dialogNewToyBinding5 = null;
                            }
                            dialogNewToyBinding5.e.e.setText(ah4.e(R.string.des_gps_disabled));
                            DialogNewToyBinding dialogNewToyBinding6 = this.a.b;
                            if (dialogNewToyBinding6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                            } else {
                                dialogNewToyBinding = dialogNewToyBinding6;
                            }
                            dialogNewToyBinding.b.e.setVisibility(8);
                            this.a.X().q();
                            return;
                        }
                        return;
                    }
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0)) {
                            case 10:
                                this.a.g = false;
                                this.a.X().i().postValue(Boolean.TRUE);
                                ye3.d("Z0123", "蓝牙状态关闭");
                                this.a.X().j().postValue(Boolean.FALSE);
                                DialogNewToyBinding dialogNewToyBinding7 = this.a.b;
                                if (dialogNewToyBinding7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                    dialogNewToyBinding7 = null;
                                }
                                dialogNewToyBinding7.b.c.setText(ah4.e(R.string.des_bluetooth_disabled));
                                DialogNewToyBinding dialogNewToyBinding8 = this.a.b;
                                if (dialogNewToyBinding8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                    dialogNewToyBinding8 = null;
                                }
                                dialogNewToyBinding8.e.e.setText(ah4.e(R.string.des_bluetooth_disabled));
                                DialogNewToyBinding dialogNewToyBinding9 = this.a.b;
                                if (dialogNewToyBinding9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                } else {
                                    dialogNewToyBinding = dialogNewToyBinding9;
                                }
                                dialogNewToyBinding.b.e.setVisibility(8);
                                this.a.X().q();
                                break;
                            case 11:
                                this.a.g = true;
                                DialogNewToyBinding dialogNewToyBinding10 = this.a.b;
                                if (dialogNewToyBinding10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                } else {
                                    dialogNewToyBinding = dialogNewToyBinding10;
                                }
                                if (dialogNewToyBinding.e.l.getVisibility() == 0) {
                                    this.a.X().j().postValue(Boolean.TRUE);
                                }
                                this.a.Q();
                                break;
                            case 12:
                                this.a.g = true;
                                DialogNewToyBinding dialogNewToyBinding11 = this.a.b;
                                if (dialogNewToyBinding11 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                } else {
                                    dialogNewToyBinding = dialogNewToyBinding11;
                                }
                                if (dialogNewToyBinding.e.l.getVisibility() == 0) {
                                    this.a.X().j().postValue(Boolean.TRUE);
                                }
                                this.a.Q();
                                this.a.y0();
                                break;
                            case 13:
                                this.a.g = false;
                                this.a.X().i().postValue(Boolean.TRUE);
                                ye3.d("Z0123", "蓝牙状态变更关闭");
                                this.a.X().j().postValue(Boolean.FALSE);
                                DialogNewToyBinding dialogNewToyBinding12 = this.a.b;
                                if (dialogNewToyBinding12 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                    dialogNewToyBinding12 = null;
                                }
                                dialogNewToyBinding12.b.c.setText(ah4.e(R.string.des_bluetooth_disabled));
                                DialogNewToyBinding dialogNewToyBinding13 = this.a.b;
                                if (dialogNewToyBinding13 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                    dialogNewToyBinding13 = null;
                                }
                                dialogNewToyBinding13.e.e.setText(ah4.e(R.string.des_bluetooth_disabled));
                                DialogNewToyBinding dialogNewToyBinding14 = this.a.b;
                                if (dialogNewToyBinding14 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                                } else {
                                    dialogNewToyBinding = dialogNewToyBinding14;
                                }
                                dialogNewToyBinding.b.e.setVisibility(8);
                                this.a.X().q();
                                break;
                        }
                    }
                }
            }
        };
    }

    public static final void E0(ToyDialog this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        DialogNewToyBinding dialogNewToyBinding = this$0.b;
        if (dialogNewToyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding = null;
        }
        dialogNewToyBinding.c.d.setText(this$0.O(iIntValue));
    }

    public static final void b0(ToyDialog this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        DialogNewToyBinding dialogNewToyBinding = null;
        if (it.booleanValue()) {
            DialogNewToyBinding dialogNewToyBinding2 = this$0.b;
            if (dialogNewToyBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding = dialogNewToyBinding2;
            }
            dialogNewToyBinding.d.c.setVisibility(0);
            return;
        }
        DialogNewToyBinding dialogNewToyBinding3 = this$0.b;
        if (dialogNewToyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            dialogNewToyBinding = dialogNewToyBinding3;
        }
        dialogNewToyBinding.d.c.setVisibility(8);
    }

    public static final void c0(ToyDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this$0.requireContext().getPackageName(), null));
        this$0.startActivityForResult(intent, 1);
    }

    public static final void d0(ToyDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W().y0(new ArrayList());
        this$0.W().notifyDataSetChanged();
        this$0.X().h().postValue(Boolean.TRUE);
        uy3.d(a14.a, null, null, this$0.new f(null), 3, null);
    }

    public static final void e0(ToyDialog this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        DialogNewToyBinding dialogNewToyBinding = null;
        if (!it.booleanValue()) {
            MutableLiveData<Boolean> mutableLiveDataH = this$0.X().h();
            Boolean bool = Boolean.TRUE;
            mutableLiveDataH.postValue(bool);
            Boolean value = this$0.X().k().getValue();
            Boolean bool2 = Boolean.FALSE;
            if (Intrinsics.areEqual(value, bool2)) {
                DialogNewToyBinding dialogNewToyBinding2 = this$0.b;
                if (dialogNewToyBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                } else {
                    dialogNewToyBinding = dialogNewToyBinding2;
                }
                dialogNewToyBinding.b.b.setVisibility(8);
                this$0.X().j().postValue(bool);
                return;
            }
            DialogNewToyBinding dialogNewToyBinding3 = this$0.b;
            if (dialogNewToyBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding = dialogNewToyBinding3;
            }
            dialogNewToyBinding.b.b.setVisibility(8);
            this$0.X().j().postValue(bool2);
            return;
        }
        ye3.d("Z0123", "蓝牙/定位权限（开关）缺失");
        MutableLiveData<Boolean> mutableLiveDataK = this$0.X().k();
        Boolean bool3 = Boolean.FALSE;
        mutableLiveDataK.postValue(bool3);
        this$0.X().g();
        this$0.X().h().postValue(bool3);
        ArrayList<Toy> arrayListO = WearUtils.x.G().o();
        if (arrayListO == null || arrayListO.isEmpty()) {
            ye3.d("Z0123", "玩具列表没有数据");
            DialogNewToyBinding dialogNewToyBinding4 = this$0.b;
            if (dialogNewToyBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding = dialogNewToyBinding4;
            }
            dialogNewToyBinding.b.b.setVisibility(0);
            this$0.X().j().postValue(bool3);
            return;
        }
        ye3.d("Z0123", "玩具列表有数据");
        DialogNewToyBinding dialogNewToyBinding5 = this$0.b;
        if (dialogNewToyBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            dialogNewToyBinding = dialogNewToyBinding5;
        }
        dialogNewToyBinding.b.b.setVisibility(8);
        this$0.X().j().postValue(Boolean.TRUE);
    }

    public static final void f0(ToyDialog this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        DialogNewToyBinding dialogNewToyBinding = null;
        if (it.booleanValue()) {
            DialogNewToyBinding dialogNewToyBinding2 = this$0.b;
            if (dialogNewToyBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding = dialogNewToyBinding2;
            }
            dialogNewToyBinding.c.c.setVisibility(0);
            return;
        }
        DialogNewToyBinding dialogNewToyBinding3 = this$0.b;
        if (dialogNewToyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            dialogNewToyBinding = dialogNewToyBinding3;
        }
        dialogNewToyBinding.c.c.setVisibility(8);
    }

    public static final void g0(ToyDialog this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        DialogNewToyBinding dialogNewToyBinding = null;
        if (it.booleanValue()) {
            this$0.y0();
            this$0.X().p(30);
            DialogNewToyBinding dialogNewToyBinding2 = this$0.b;
            if (dialogNewToyBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding2 = null;
            }
            dialogNewToyBinding2.e.d.setVisibility(0);
            DialogNewToyBinding dialogNewToyBinding3 = this$0.b;
            if (dialogNewToyBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding3 = null;
            }
            dialogNewToyBinding3.e.k.setVisibility(8);
            DialogNewToyBinding dialogNewToyBinding4 = this$0.b;
            if (dialogNewToyBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding4 = null;
            }
            if (dialogNewToyBinding4.e.d.o()) {
                return;
            }
            DialogNewToyBinding dialogNewToyBinding5 = this$0.b;
            if (dialogNewToyBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding = dialogNewToyBinding5;
            }
            dialogNewToyBinding.e.d.r();
            return;
        }
        DialogNewToyBinding dialogNewToyBinding6 = this$0.b;
        if (dialogNewToyBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding6 = null;
        }
        dialogNewToyBinding6.e.d.setVisibility(8);
        DialogNewToyBinding dialogNewToyBinding7 = this$0.b;
        if (dialogNewToyBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding7 = null;
        }
        if (dialogNewToyBinding7.e.d.o()) {
            DialogNewToyBinding dialogNewToyBinding8 = this$0.b;
            if (dialogNewToyBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding8 = null;
            }
            dialogNewToyBinding8.e.d.q();
        }
        if (Intrinsics.areEqual(this$0.X().i().getValue(), Boolean.TRUE)) {
            DialogNewToyBinding dialogNewToyBinding9 = this$0.b;
            if (dialogNewToyBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding = dialogNewToyBinding9;
            }
            dialogNewToyBinding.e.k.setVisibility(8);
        } else {
            DialogNewToyBinding dialogNewToyBinding10 = this$0.b;
            if (dialogNewToyBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding = dialogNewToyBinding10;
            }
            dialogNewToyBinding.e.k.setVisibility(0);
        }
        this$0.X().q();
    }

    public static final void h0(ToyDialog this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        DialogNewToyBinding dialogNewToyBinding = null;
        if (!it.booleanValue()) {
            DialogNewToyBinding dialogNewToyBinding2 = this$0.b;
            if (dialogNewToyBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding2 = null;
            }
            dialogNewToyBinding2.e.l.setVisibility(8);
            if (Intrinsics.areEqual(this$0.X().i().getValue(), Boolean.TRUE)) {
                ye3.d("Z0123", "玩具列表没有数据并且权限/开关有问题");
                DialogNewToyBinding dialogNewToyBinding3 = this$0.b;
                if (dialogNewToyBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                } else {
                    dialogNewToyBinding = dialogNewToyBinding3;
                }
                dialogNewToyBinding.b.b.setVisibility(0);
                return;
            }
            return;
        }
        DialogNewToyBinding dialogNewToyBinding4 = this$0.b;
        if (dialogNewToyBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding4 = null;
        }
        dialogNewToyBinding4.e.l.setVisibility(0);
        if (Intrinsics.areEqual(this$0.X().i().getValue(), Boolean.TRUE)) {
            DialogNewToyBinding dialogNewToyBinding5 = this$0.b;
            if (dialogNewToyBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding5 = null;
            }
            dialogNewToyBinding5.e.c.setVisibility(0);
            DialogNewToyBinding dialogNewToyBinding6 = this$0.b;
            if (dialogNewToyBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding6 = null;
            }
            dialogNewToyBinding6.e.b.setVisibility(0);
            DialogNewToyBinding dialogNewToyBinding7 = this$0.b;
            if (dialogNewToyBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding7 = null;
            }
            dialogNewToyBinding7.e.k.setVisibility(8);
        } else {
            DialogNewToyBinding dialogNewToyBinding8 = this$0.b;
            if (dialogNewToyBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding8 = null;
            }
            dialogNewToyBinding8.e.c.setVisibility(8);
            DialogNewToyBinding dialogNewToyBinding9 = this$0.b;
            if (dialogNewToyBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding9 = null;
            }
            dialogNewToyBinding9.e.b.setVisibility(8);
        }
        if (WearUtils.x.G().o().size() > 0) {
            DialogNewToyBinding dialogNewToyBinding10 = this$0.b;
            if (dialogNewToyBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding = dialogNewToyBinding10;
            }
            dialogNewToyBinding.e.g.setVisibility(0);
            return;
        }
        DialogNewToyBinding dialogNewToyBinding11 = this$0.b;
        if (dialogNewToyBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            dialogNewToyBinding = dialogNewToyBinding11;
        }
        dialogNewToyBinding.e.g.setVisibility(8);
    }

    public static final void i0(Ref.IntRef count, ToyDialog this$0, List list) {
        Intrinsics.checkNotNullParameter(count, "$count");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list == null || list.isEmpty()) {
            return;
        }
        if (count.element != list.size() && count.element > 0) {
            this$0.X().p(30);
        }
        this$0.W().y0(list);
        this$0.W().notifyDataSetChanged();
        count.element = list.size();
    }

    public static final void k0(ToyDialog this$0, BaseQuickAdapter adapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        List listK = adapter.K();
        if (i2 < 0 || i2 >= listK.size() || !Intrinsics.areEqual(this$0.X().i().getValue(), Boolean.FALSE)) {
            return;
        }
        NewToyViewModel newToyViewModelX = this$0.X();
        Object obj = listK.get(i2);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.wear.bean.Toy");
        newToyViewModelX.d((Toy) obj);
        adapter.q0(i2);
    }

    public final void A0(TextView textView) {
        String str;
        int iIndexOf$default;
        if (this.g) {
            str = ah4.e(R.string.button_go_to_settings) + " >";
        } else {
            str = "";
        }
        String str2 = ((Object) textView.getText()) + str;
        SpannableString spannableString = new SpannableString(str2);
        if (this.g && (iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, str, 0, false, 6, (Object) null)) != -1) {
            spannableString.setSpan(new k(), iIndexOf$default, str.length() + iIndexOf$default, 17);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void C0() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 4);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: dc.kr3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ToyDialog.E0(this.a, valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(4000L);
        valueAnimatorOfInt.setRepeatCount(200);
        valueAnimatorOfInt.setRepeatMode(1);
        valueAnimatorOfInt.start();
    }

    public final void M() {
        ye3.j("toys", "location_permission_required", "", "", "", "", "", -1L);
    }

    public final String O(int i2) {
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

    public final void P() {
        this.e.i(false);
        this.e.p0(true);
    }

    public final void Q() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 && i2 <= 30) {
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
        }
        if (i2 >= 33) {
            requireContext().registerReceiver(this.i, intentFilter, 2);
        } else {
            requireContext().registerReceiver(this.i, intentFilter);
        }
        Object systemService = requireContext().getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        DialogNewToyBinding dialogNewToyBinding = null;
        if (adapter == null || !adapter.isEnabled()) {
            X().i().postValue(Boolean.TRUE);
            ye3.d("Z0123", "蓝牙未开启");
            DialogNewToyBinding dialogNewToyBinding2 = this.b;
            if (dialogNewToyBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding2 = null;
            }
            dialogNewToyBinding2.b.c.setText(ah4.e(R.string.des_bluetooth_disabled));
            DialogNewToyBinding dialogNewToyBinding3 = this.b;
            if (dialogNewToyBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding3 = null;
            }
            dialogNewToyBinding3.e.e.setText(ah4.e(R.string.des_bluetooth_disabled));
            DialogNewToyBinding dialogNewToyBinding4 = this.b;
            if (dialogNewToyBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding4 = null;
            }
            dialogNewToyBinding4.e.h.setText(ah4.e(R.string.connect_toy_entrance2));
            DialogNewToyBinding dialogNewToyBinding5 = this.b;
            if (dialogNewToyBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding5 = null;
            }
            TextView textView = dialogNewToyBinding5.e.h;
            Intrinsics.checkNotNullExpressionValue(textView, "dataBinding.newtoyToycon…ntstub.newtoyBldisabledtv");
            A0(textView);
            DialogNewToyBinding dialogNewToyBinding6 = this.b;
            if (dialogNewToyBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding = dialogNewToyBinding6;
            }
            dialogNewToyBinding.b.e.setVisibility(8);
            return;
        }
        if (i2 >= 31) {
            q61 q61VarN = q61.n(this);
            q61VarN.i(v51.a.a);
            q61VarN.j(new c());
            DialogNewToyBinding dialogNewToyBinding7 = this.b;
            if (dialogNewToyBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            } else {
                dialogNewToyBinding = dialogNewToyBinding7;
            }
            dialogNewToyBinding.e.h.setText(ah4.e(R.string.connect_toy_entrance2));
            return;
        }
        if (!(24 <= i2 && i2 < 31)) {
            X().i().postValue(Boolean.FALSE);
            return;
        }
        Object systemService2 = requireContext().getSystemService(FirebaseAnalytics.Param.LOCATION);
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.location.LocationManager");
        if (((LocationManager) systemService2).isProviderEnabled("gps")) {
            q61 q61VarN2 = q61.n(this);
            q61VarN2.h("android.permission.ACCESS_FINE_LOCATION");
            q61VarN2.h("android.permission.ACCESS_COARSE_LOCATION");
            q61VarN2.j(new d());
        } else {
            X().i().postValue(Boolean.TRUE);
            DialogNewToyBinding dialogNewToyBinding8 = this.b;
            if (dialogNewToyBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding8 = null;
            }
            dialogNewToyBinding8.b.d.setText(ah4.e(R.string.app_trun_on_bluetooth_gps));
            DialogNewToyBinding dialogNewToyBinding9 = this.b;
            if (dialogNewToyBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding9 = null;
            }
            dialogNewToyBinding9.b.c.setText(ah4.e(R.string.des_gps_disabled));
            DialogNewToyBinding dialogNewToyBinding10 = this.b;
            if (dialogNewToyBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding10 = null;
            }
            dialogNewToyBinding10.e.e.setText(ah4.e(R.string.des_gps_disabled));
            ye3.d("Z0123", "没有开启GPS");
            DialogNewToyBinding dialogNewToyBinding11 = this.b;
            if (dialogNewToyBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding11 = null;
            }
            TextView textView2 = dialogNewToyBinding11.e.h;
            Intrinsics.checkNotNullExpressionValue(textView2, "dataBinding.newtoyToycon…ntstub.newtoyBldisabledtv");
            A0(textView2);
            DialogNewToyBinding dialogNewToyBinding12 = this.b;
            if (dialogNewToyBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
                dialogNewToyBinding12 = null;
            }
            dialogNewToyBinding12.b.e.setVisibility(8);
        }
        DialogNewToyBinding dialogNewToyBinding13 = this.b;
        if (dialogNewToyBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            dialogNewToyBinding = dialogNewToyBinding13;
        }
        dialogNewToyBinding.e.h.setText(ah4.e(R.string.app_trun_on_bluetooth_gps));
    }

    public final void R(String str, String str2, int i2) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str3 = String.format(ah4.e(R.string.common_dialog_delete).toString(), Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
        kn3 kn3Var = new kn3(requireContext(), str3, ah4.e(R.string.common_delete), ah4.e(R.string.common_cancel), true, (kn3.d) new e(str, this, i2, str2));
        kn3Var.show();
        kn3Var.p();
    }

    public final MyToyAdapter V() {
        return (MyToyAdapter) this.d.getValue();
    }

    public final SearchToyAdapter W() {
        return (SearchToyAdapter) this.c.getValue();
    }

    public final NewToyViewModel X() {
        return (NewToyViewModel) this.a.getValue();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void a0() {
        X().i().observe(this, new Observer() { // from class: dc.dr3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ToyDialog.e0(this.a, (Boolean) obj);
            }
        });
        X().k().observe(this, new Observer() { // from class: dc.gr3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ToyDialog.f0(this.a, (Boolean) obj);
            }
        });
        X().h().observe(this, new Observer() { // from class: dc.fr3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ToyDialog.g0(this.a, (Boolean) obj);
            }
        });
        ArrayList<Toy> arrayListO = WearUtils.x.G().o();
        NewToyActivity.a aVar = NewToyActivity.o;
        Intrinsics.checkNotNull(arrayListO, "null cannot be cast to non-null type java.util.ArrayList<com.wear.bean.Toy>{ kotlin.collections.TypeAliasesKt.ArrayList<com.wear.bean.Toy> }");
        aVar.c(arrayListO);
        V().y0(arrayListO);
        X().j().observe(this, new Observer() { // from class: dc.br3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ToyDialog.h0(this.a, (Boolean) obj);
            }
        });
        final Ref.IntRef intRef = new Ref.IntRef();
        X().f().observe(this, new Observer() { // from class: dc.jr3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ToyDialog.i0(intRef, this, (List) obj);
            }
        });
        X().l().observe(this, new Observer() { // from class: dc.er3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ToyDialog.b0(this.a, (Boolean) obj);
            }
        });
        DialogNewToyBinding dialogNewToyBinding = this.b;
        DialogNewToyBinding dialogNewToyBinding2 = null;
        if (dialogNewToyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding = null;
        }
        dialogNewToyBinding.b.e.setOnClickListener(new View.OnClickListener() { // from class: dc.lr3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToyDialog.c0(this.a, view);
            }
        });
        DialogNewToyBinding dialogNewToyBinding3 = this.b;
        if (dialogNewToyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            dialogNewToyBinding2 = dialogNewToyBinding3;
        }
        dialogNewToyBinding2.e.k.setOnClickListener(new View.OnClickListener() { // from class: dc.hr3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToyDialog.d0(this.a, view);
            }
        });
    }

    public final void j0() {
        EventBus.getDefault().register(this);
        DialogNewToyBinding dialogNewToyBinding = this.b;
        DialogNewToyBinding dialogNewToyBinding2 = null;
        if (dialogNewToyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding = null;
        }
        dialogNewToyBinding.c.c.setVisibility(0);
        DialogNewToyBinding dialogNewToyBinding3 = this.b;
        if (dialogNewToyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding3 = null;
        }
        dialogNewToyBinding3.f.setText(ah4.e(R.string.common_patterns_toys));
        DialogNewToyBinding dialogNewToyBinding4 = this.b;
        if (dialogNewToyBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding4 = null;
        }
        dialogNewToyBinding4.e.g.setText(ah4.e(R.string.account_toy));
        DialogNewToyBinding dialogNewToyBinding5 = this.b;
        if (dialogNewToyBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding5 = null;
        }
        dialogNewToyBinding5.e.m.setText(ah4.e(R.string.title_available_toys));
        X().g();
        Q();
        qf<Drawable> qfVarT = kf.y(this).t(Integer.valueOf(R.drawable.adv));
        DialogNewToyBinding dialogNewToyBinding6 = this.b;
        if (dialogNewToyBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding6 = null;
        }
        qfVarT.A0(dialogNewToyBinding6.c.b);
        C0();
        DialogNewToyBinding dialogNewToyBinding7 = this.b;
        if (dialogNewToyBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding7 = null;
        }
        RecyclerView recyclerView = dialogNewToyBinding7.e.j;
        recyclerView.setAdapter(W());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        V().b1(new g());
        V().Z0(this.f);
        DialogNewToyBinding dialogNewToyBinding8 = this.b;
        if (dialogNewToyBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding8 = null;
        }
        RecyclerView recyclerView2 = dialogNewToyBinding8.e.i;
        recyclerView2.setAdapter(V());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(requireContext());
        linearLayoutManager2.setOrientation(1);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        W().E0(new br() { // from class: dc.cr3
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                ToyDialog.k0(this.a, baseQuickAdapter, view, i2);
            }
        });
        DialogNewToyBinding dialogNewToyBinding9 = this.b;
        if (dialogNewToyBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBinding9 = null;
        }
        dialogNewToyBinding9.d.d.bringToFront();
        V().a1(new h());
        pc1.a.k(this.f);
        DialogNewToyBinding dialogNewToyBinding10 = this.b;
        if (dialogNewToyBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        } else {
            dialogNewToyBinding2 = dialogNewToyBinding10;
        }
        TextView textView = dialogNewToyBinding2.d.b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strE = ah4.e(R.string.connect_toy_tip3);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.connect_toy_tip3)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{7}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
    }

    public final boolean l0() {
        Object systemService = requireContext().getSystemService(FirebaseAnalytics.Param.LOCATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Q();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.BottomSheetDialog);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogNewToyBinding dialogNewToyBindingC = DialogNewToyBinding.c(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogNewToyBindingC, "inflate(inflater, container, false)");
        this.b = dialogNewToyBindingC;
        if (dialogNewToyBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
            dialogNewToyBindingC = null;
        }
        RelativeLayout root = dialogNewToyBindingC.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "dataBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        X().q();
        P();
        EventBus.getDefault().unregister(this);
        try {
            requireContext().unregisterReceiver(this.i);
        } catch (Exception unused) {
        }
        pc1.a.k("");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        b bVar = this.h;
        if (bVar != null) {
            bVar.onDismiss();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@NotNull n90 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        X().g();
    }

    @Override // com.wear.widget.dialog.CustomBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        V().notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (!isDetached()) {
            FragmentActivity activity = getActivity();
            if (!(activity != null && activity.isDestroyed())) {
                FragmentActivity activity2 = getActivity();
                if (!(activity2 != null && activity2.isFinishing())) {
                    j0();
                    a0();
                    return;
                }
            }
        }
        dismiss();
    }

    public final void y0() {
        this.e.h();
        this.e.i(true);
        this.e.W(0);
    }

    public final void z0(@NotNull b onDismissListener) {
        Intrinsics.checkNotNullParameter(onDismissListener, "onDismissListener");
        this.h = onDismissListener;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@NotNull zj2 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        V().notifyDataSetChanged();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@NotNull ChangeToyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        NewToyActivity.o.b(event, V());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @SuppressLint({"NotifyDataSetChanged"})
    public final void onMessageEvent(@Nullable xc1 xc1Var) {
        if (xc1Var != null && xc1Var.b() == 1 && V().K().size() > 1) {
            NewToyActivity.a aVar = NewToyActivity.o;
            List<Toy> listK = V().K();
            Intrinsics.checkNotNull(listK, "null cannot be cast to non-null type java.util.ArrayList<com.wear.bean.Toy>{ kotlin.collections.TypeAliasesKt.ArrayList<com.wear.bean.Toy> }");
            aVar.c((ArrayList) listK);
        }
        V().notifyDataSetChanged();
        W().notifyDataSetChanged();
    }
}
