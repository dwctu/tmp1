package com.wear.main.toy.newtoy;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.dao.DaoUtils;
import com.wear.main.toy.ToySettingActivity;
import com.wear.main.toy.newtoy.MyToyAdapter;
import com.wear.main.toy.newtoy.MyToyStrengthAdapter;
import com.wear.main.toy.pin.ToyPinRemoveFailTipActivity;
import com.wear.main.toy.pin.ToyPinTipActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.ConnectingTipDialog;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.aj2;
import dc.cc0;
import dc.db2;
import dc.h32;
import dc.ke3;
import dc.lp1;
import dc.me0;
import dc.og3;
import dc.pc1;
import dc.pj3;
import dc.rp1;
import dc.sg3;
import dc.ud3;
import dc.vc1;
import dc.wi2;
import dc.xb1;
import dc.ye3;
import dc.yj2;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: MyToyAdapter.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0002H\u0015J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/wear/main/toy/newtoy/MyToyAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/Toy;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "elementId", "", "getElementId", "()Ljava/lang/String;", "setElementId", "(Ljava/lang/String;)V", "hashMap", "Landroidx/collection/ArrayMap;", "longClickListener", "Lcom/wear/main/toy/newtoy/MyToyAdapter$OnItemLongClickListener;", "onStrengthChangeListener", "Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter$OnStrengthChangeListener;", "addSettingClickLog", "", "toy", "changeToyConnectState", MultipleAddresses.Address.ELEMENT, "isSelect", "", "convert", "holder", "item", "getToyStrengthWithAddress", "", "Lcom/wear/bean/MyToyConfigBean;", "initStrengthView", "setItemLongClickListener", "click", "setOnStrengthChangeListener", "setSettingTipViewVisible", "view", "Landroid/view/View;", "turnApp", "updateFirmwareUI", "Companion", "OnItemLongClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MyToyAdapter extends BaseQuickAdapter<Toy, BaseViewHolder> {

    @NotNull
    public static final a D = new a(null);

    @NotNull
    public static final String E = "salace2_click_change_function";

    @Nullable
    public String A;

    @Nullable
    public MyToyStrengthAdapter.a B;

    @NotNull
    public final ArrayMap<String, Toy> C;

    @Nullable
    public b z;

    /* compiled from: MyToyAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/main/toy/newtoy/MyToyAdapter$Companion;", "", "()V", "KV_SALACE2_HAD_CLICK_FUNCTION", "", "getKV_SALACE2_HAD_CLICK_FUNCTION", "()Ljava/lang/String;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return MyToyAdapter.E;
        }
    }

    /* compiled from: MyToyAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/wear/main/toy/newtoy/MyToyAdapter$OnItemLongClickListener;", "", "itemLongClick", "", "item", "Lcom/wear/bean/Toy;", "position", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void a(@NotNull Toy toy, int i);
    }

    public MyToyAdapter() {
        super(R.layout.toy_mytoyitem1, null, 2, null);
        this.C = new ArrayMap<>();
    }

    public static final void M0(Toy item, MyToyAdapter this$0, BaseViewHolder holder, View view) {
        pc1 pc1VarG;
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        MyApplication myApplication = WearUtils.x;
        if (myApplication == null || (pc1VarG = myApplication.G()) == null) {
            return;
        }
        String address = item.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "item.address");
        Toy toyQ = pc1VarG.Q(address);
        if (toyQ != null) {
            toyQ.setConnectScanTime(0L);
            toyQ.setConnectTryNumb(4);
            this$0.notifyItemChanged(holder.getAdapterPosition());
            item.setConnectApp(0);
            item.setFormApp("Remote");
            item.setUpdateTime(System.currentTimeMillis());
        }
    }

    public static final void N0(MyToyAdapter this$0, Toy item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        pj3.j(this$0.J(), ToySettingActivity.class, "toy_address_Id", item.getAddress());
        this$0.J0(item);
    }

    public static final void O0(MyToyAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new ConnectingTipDialog(this$0.J()).show();
    }

    public static final void P0(SwitchView switchButton, Toy item, MyToyAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(switchButton, "$switchButton");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switchButton.setChecked(!item.isSelect());
        String address = item.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "item.address");
        this$0.K0(address, switchButton.isChecked());
        EventBus.getDefault().post(new vc1(item.getAddress(), item.getBattery()));
        if (!switchButton.isChecked()) {
            item.setLogFormApp(item.getFormApp());
            item.setFormApp("Lovense Remote");
            WearUtils.x.G().w0(this$0.J(), item);
            return;
        }
        if (!xb1.b(item.getUuid(), item.getAddress()) && DaoUtils.getToyPinStatusDao().findToyPinStatus(item.getAddress()) == null && og3.a(9)) {
            Intent intent = new Intent(this$0.J(), (Class<?>) ToyPinTipActivity.class);
            intent.putExtra("toyId", item.getAddress());
            this$0.J().startActivity(intent);
        } else if (xb1.b(item.getUuid(), item.getAddress()) && ud3.a(item.getAddress()) && !ud3.c(null, item.getAddress()) && og3.a(9)) {
            Intent intent2 = new Intent(this$0.J(), (Class<?>) ToyPinRemoveFailTipActivity.class);
            intent2.putExtra("toyId", item.getAddress());
            intent2.putExtra("type", 1);
            this$0.J().startActivity(intent2);
        } else {
            item.setIsSelect(1);
        }
        item.setConnectApp(0);
        if (TextUtils.equals("Lovense Remote", item.getFormApp())) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        String address2 = item.getAddress();
        Intrinsics.checkNotNullExpressionValue(address2, "item.address");
        jSONObject.put((JSONObject) "toy_mac", StringsKt__StringsJVMKt.replace$default(address2, SignatureImpl.INNER_SEP, "", false, 4, (Object) null));
        jSONObject.put((JSONObject) "connected_app", item.getFormApp());
        rp1.a.w(jSONObject.toJSONString());
    }

    public static final boolean Q0(MyToyAdapter this$0, Toy item, BaseViewHolder holder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        b bVar = this$0.z;
        if (bVar == null) {
            return true;
        }
        bVar.a(item, holder.getAdapterPosition());
        return true;
    }

    public static final void f1(Toy toy, MyToyAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(toy, "$toy");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (toy.isConnected()) {
            lp1.a.e(this$0.J(), toy.getAddress());
        } else {
            sg3.h(R.string.toy_settings_no_toy_toast);
        }
    }

    public final void J0(Toy toy) {
        ye3.k("toys", "toy_settings_click", "click", "settings", "button", "", "", -1L, toy.getAddress());
    }

    public final void K0(String str, boolean z) {
        Toy toyQ = WearUtils.x.G().Q(str);
        if (toyQ == null) {
            return;
        }
        toyQ.setConnectTryNumb(4);
        if (z) {
            toyQ.setIsSelect(1);
            toyQ.setConnectApp(0);
        } else {
            toyQ.setIsSelect(0);
            WearUtils.x.G().E(toyQ);
            String address = toyQ.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "temp.address");
            aj2.b(address, cc0.DISCONNECTED);
            WearUtils.x.G().v0(toyQ.getAddress());
            toyQ.setDisConnectType(1);
            toyQ.setRealDeviceType(false);
            toyQ.setIsLongRange(0);
            pc1 pc1VarG = WearUtils.x.G();
            String address2 = toyQ.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "temp.address");
            pc1VarG.disconnect(address2);
            toyQ.setConnectApp(-1);
            EventBus.getDefault().post(new yj2(toyQ));
        }
        wi2.e().f("ToyActivity.onItemClickAction()-->toyAddress:" + toyQ.getAddress() + ", isSelect:" + z);
        toyQ.setLogFormApp(toyQ.getFormApp());
        toyQ.setUpdateTime(System.currentTimeMillis());
        WearUtils.x.G().w0(J(), toyQ);
        db2.A().P();
        h32.i().z();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02bb  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @android.annotation.SuppressLint({"UseSwitchCompatOrMaterialCode"})
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C(@org.jetbrains.annotations.NotNull final com.chad.library.adapter.base.viewholder.BaseViewHolder r13, @org.jetbrains.annotations.NotNull final com.wear.bean.Toy r14) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.newtoy.MyToyAdapter.C(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.wear.bean.Toy):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.wear.bean.MyToyConfigBean> R0(com.wear.bean.Toy r17) throws java.lang.NoSuchFieldException {
        /*
            Method dump skipped, instructions count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.newtoy.MyToyAdapter.R0(com.wear.bean.Toy):java.util.List");
    }

    public final void S0(BaseViewHolder baseViewHolder, Toy toy) {
        if (K().size() > 2) {
            ((RelativeLayout) baseViewHolder.getView(R.id.mytoy_item1_settingrl)).setVisibility(8);
            return;
        }
        if (!toy.isSelect() || !toy.isConnected()) {
            ((RelativeLayout) baseViewHolder.getView(R.id.mytoy_item1_settingrl)).setVisibility(8);
            return;
        }
        ((RelativeLayout) baseViewHolder.getView(R.id.mytoy_item1_settingrl)).setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mytoy_item1_funcationreycler);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        MyToyStrengthAdapter myToyStrengthAdapter = adapter instanceof MyToyStrengthAdapter ? (MyToyStrengthAdapter) adapter : null;
        if (myToyStrengthAdapter == null) {
            RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
            MyToyStrengthAdapter myToyStrengthAdapter2 = adapter2 instanceof MyToyStrengthAdapter ? (MyToyStrengthAdapter) adapter2 : null;
            myToyStrengthAdapter = myToyStrengthAdapter2 == null ? new MyToyStrengthAdapter(J()) : myToyStrengthAdapter2;
            myToyStrengthAdapter.y(this.B);
            myToyStrengthAdapter.w(this.A);
            recyclerView.setAdapter(myToyStrengthAdapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
            linearLayoutManager.setOrientation(1);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        if (!WearUtils.g1(toy.getMotors()) || toy.isBAToy()) {
            myToyStrengthAdapter.x(R0(toy));
        }
    }

    public final void Z0(@Nullable String str) {
        this.A = str;
    }

    public final void a1(@NotNull b click) {
        Intrinsics.checkNotNullParameter(click, "click");
        this.z = click;
    }

    public final void b1(@NotNull MyToyStrengthAdapter.a onStrengthChangeListener) {
        Intrinsics.checkNotNullParameter(onStrengthChangeListener, "onStrengthChangeListener");
        this.B = onStrengthChangeListener;
    }

    public final void c1(View view, Toy toy) {
        int i = (toy.isSelect() && toy.isConnected() && ke3.b("new_feature", "toy_strength_setting", false)) ? 0 : 8;
        if (i == 8) {
            i = (!toy.isBAToy() || me0.a(E, false)) ? 8 : 0;
        }
        view.setVisibility(i);
    }

    public final void d1(Toy toy, BaseViewHolder baseViewHolder) {
        if (toy.isSelect()) {
            ((ImageView) baseViewHolder.getView(R.id.other_app_connect_iv_icon)).setVisibility(8);
            return;
        }
        if (toy.getConnectApp() != 1 || TextUtils.equals("Lovense Remote", toy.getFormApp())) {
            this.C.remove(toy.getAddress());
            ((TextView) baseViewHolder.getView(R.id.toy_image)).setBackgroundResource(R.drawable.newtoy_iconbg);
            ((ImageView) baseViewHolder.getView(R.id.other_app_connect_iv_icon)).setVisibility(8);
            baseViewHolder.setText(R.id.statusText, ah4.e(R.string.not_connect));
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strE = ah4.e(R.string.toy_connected_to_other_apps);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.toy_connected_to_other_apps)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{toy.getFormApp()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        baseViewHolder.setText(R.id.statusText, str);
        ((ImageView) baseViewHolder.getView(R.id.other_app_connect_iv_icon)).setVisibility(0);
        ((TextView) baseViewHolder.getView(R.id.toy_image)).setBackgroundResource(R.drawable.newtoy_iconbg);
        if (this.C.containsKey(toy.getAddress())) {
            return;
        }
        rp1.a.A(toy);
        this.C.put(toy.getAddress(), toy);
    }

    public final void e1(BaseViewHolder baseViewHolder, final Toy toy) {
        ((RelativeLayout) baseViewHolder.getView(R.id.mytoy_item1_settingrl)).setVisibility(8);
        ((ConstraintLayout) baseViewHolder.getView(R.id.cl_setting)).setVisibility(8);
        ((ConstraintLayout) baseViewHolder.getView(R.id.notice_firmware_update)).setVisibility(0);
        ((TextView) baseViewHolder.getView(R.id.connect_now)).setVisibility(0);
        baseViewHolder.setText(R.id.connect_now, ah4.e(R.string.common_update));
        if (toy.isEI01Toy()) {
            baseViewHolder.setText(R.id.notice_content, ah4.e(R.string.notification_update_flexer_firmware2));
        } else if (toy.isEAToy()) {
            baseViewHolder.setText(R.id.notice_content, ah4.e(R.string.notification_update__firmware3));
        } else if (toy.isXMachine()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strE = ah4.e(R.string.notification_update_firmware1);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.notification_update_firmware1)");
            String str = String.format(strE, Arrays.copyOf(new Object[]{toy.getShowName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            baseViewHolder.setText(R.id.notice_content, str);
        } else if (toy.isMiniXMachine()) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String strE2 = ah4.e(R.string.notification_update_firmware1);
            Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.notification_update_firmware1)");
            String str2 = String.format(strE2, Arrays.copyOf(new Object[]{toy.getShowName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            baseViewHolder.setText(R.id.notice_content, str2);
        }
        ((TextView) baseViewHolder.getView(R.id.update_firmware)).setOnClickListener(new View.OnClickListener() { // from class: dc.gj2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyToyAdapter.f1(toy, this, view);
            }
        });
    }
}
