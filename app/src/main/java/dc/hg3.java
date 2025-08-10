package dc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.longDistance.AddFriendActivity;
import com.wear.main.longDistance.CreateChatRoomActivity;
import com.wear.main.toy.newtoy.NewToyActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SelectPopWindowUtills.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/wear/util/SelectPopWindowUtills;", "", "()V", "showLoginDialog", "", "resId", "", "context", "Landroid/content/Context;", "showSelectPopWindow", PSOProgramService.VS_Key, "Landroid/view/View;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class hg3 {

    /* compiled from: SelectPopWindowUtills.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002&\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0003¨\u0006\u0004"}, d2 = {"com/wear/util/SelectPopWindowUtills$showSelectPopWindow$1$1", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends HashMap<String, String> {
        public a() {
            put("count", "" + ch3.i.size());
        }

        public /* bridge */ boolean a(String str) {
            return super.containsKey(str);
        }

        public /* bridge */ boolean b(String str) {
            return super.containsValue(str);
        }

        public /* bridge */ String c(String str) {
            return (String) super.get(str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj == null ? true : obj instanceof String) {
                return a((String) obj);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj == null ? true : obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        public /* bridge */ Set<Map.Entry<String, String>> d() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> e() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
            return d();
        }

        public /* bridge */ String f(String str, String str2) {
            return (String) super.getOrDefault(str, str2);
        }

        public /* bridge */ int g() {
            return super.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj == null ? true : obj instanceof String) {
                return c((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj == null ? true : obj instanceof String) ? obj2 : f((String) obj, (String) obj2);
        }

        public /* bridge */ Collection<String> h() {
            return super.values();
        }

        public /* bridge */ String i(String str) {
            return (String) super.remove(str);
        }

        public /* bridge */ boolean k(String str, String str2) {
            return super.remove(str, str2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return e();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj == null ? true : obj instanceof String) {
                return i((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return g();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<String> values() {
            return h();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if (!(obj == null ? true : obj instanceof String)) {
                return false;
            }
            if (obj2 != null ? obj2 instanceof String : true) {
                return k((String) obj, (String) obj2);
            }
            return false;
        }
    }

    public static final void g(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        pj3.t(context, LoginActivity.class, 2);
    }

    public static final void i(PopupWindow popupWindow, hg3 this$0, Context context, View view) {
        Intrinsics.checkNotNullParameter(popupWindow, "$popupWindow");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        popupWindow.dismiss();
        if (MyApplication.Z) {
            this$0.f(R.string.offline_add_people, context);
            return;
        }
        WearUtils.x.q("longDistance_add_friend", new a());
        Intent intent = new Intent(context, (Class<?>) AddFriendActivity.class);
        pj3.d(intent);
        context.startActivity(intent);
    }

    public static final void j(PopupWindow popupWindow, hg3 this$0, Context context, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(popupWindow, "$popupWindow");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        popupWindow.dismiss();
        if (MyApplication.Z) {
            this$0.f(R.string.offline_new_group, context);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("flag", 0);
        eg3.j(context, "NewGroup", true);
        ye3.i("Long Distance", "new_group_click", "click", "new_group", "button");
        pj3.g(context, CreateChatRoomActivity.class, bundle);
    }

    public static final void k(PopupWindow popupWindow, Context context, View view) {
        Intrinsics.checkNotNullParameter(popupWindow, "$popupWindow");
        Intrinsics.checkNotNullParameter(context, "$context");
        popupWindow.dismiss();
        pj3.f(context, NewToyActivity.class);
    }

    public static final void l(PopupWindow popupWindow, hg3 this$0, Context context, View view) {
        Intrinsics.checkNotNullParameter(popupWindow, "$popupWindow");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        popupWindow.dismiss();
        if (MyApplication.Z) {
            this$0.f(R.string.offline_scan_qr, context);
        } else if (context instanceof MainActivity) {
            ((MainActivity) context).c8();
        }
    }

    public final void f(int i, @NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        cs3.c(context, ah4.e(i), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), new is3.d() { // from class: dc.ed3
            @Override // dc.is3.d
            public final void doConfirm() {
                hg3.g(context);
            }
        }).show();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(@org.jetbrains.annotations.NotNull android.view.View r9, @org.jetbrains.annotations.NotNull final android.content.Context r10) {
        /*
            r8 = this;
            java.lang.String r0 = "v"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = com.wear.util.WearUtils.D
            com.wear.util.MyApplication r1 = com.wear.util.WearUtils.x
            java.lang.String r1 = dc.lg3.f(r1)
            boolean r2 = com.wear.util.MyApplication.Z
            java.lang.String r3 = "zh"
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L20
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
        L1e:
            r0 = 0
            goto L37
        L20:
            dc.ch3 r2 = dc.ch3.n()
            com.wear.network.presenter.bean.LoginUserBean r2 = r2.o()
            int r2 = r2.getIsSupportGroup()
            if (r2 == 0) goto L1e
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
            if (r1 != 0) goto L1e
            if (r0 != 0) goto L1e
            r0 = 1
        L37:
            android.content.Context r1 = r9.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            r2 = 2131559211(0x7f0d032b, float:1.874376E38)
            r3 = 0
            android.view.View r1 = r1.inflate(r2, r3)
            r2 = 2131363492(0x7f0a06a4, float:1.8346794E38)
            android.view.View r3 = r1.findViewById(r2)
            r6 = 8
            if (r0 == 0) goto L54
            r7 = 0
            goto L56
        L54:
            r7 = 8
        L56:
            r3.setVisibility(r7)
            r3 = 2131363406(0x7f0a064e, float:1.834662E38)
            android.view.View r3 = r1.findViewById(r3)
            if (r0 == 0) goto L63
            r6 = 0
        L63:
            r3.setVisibility(r6)
            android.widget.PopupWindow r0 = new android.widget.PopupWindow
            r3 = -2
            r0.<init>(r1, r3, r3)
            r3 = 2131361981(0x7f0a00bd, float:1.834373E38)
            android.view.View r3 = r1.findViewById(r3)
            dc.dd3 r6 = new dc.dd3
            r6.<init>()
            r3.setOnClickListener(r6)
            android.view.View r2 = r1.findViewById(r2)
            dc.cd3 r3 = new dc.cd3
            r3.<init>()
            r2.setOnClickListener(r3)
            r2 = 2131363426(0x7f0a0662, float:1.834666E38)
            android.view.View r2 = r1.findViewById(r2)
            dc.bd3 r3 = new dc.bd3
            r3.<init>()
            r2.setOnClickListener(r3)
            r2 = 2131361991(0x7f0a00c7, float:1.834375E38)
            android.view.View r1 = r1.findViewById(r2)
            dc.fd3 r2 = new dc.fd3
            r2.<init>()
            r1.setOnClickListener(r2)
            r0.setOutsideTouchable(r4)
            r0.setFocusable(r4)
            r1 = 1084227584(0x40a00000, float:5.0)
            int r1 = dc.ce3.a(r10, r1)
            r2 = -1069547520(0xffffffffc0400000, float:-3.0)
            int r10 = dc.ce3.a(r10, r2)
            r0.showAsDropDown(r9, r1, r10, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.hg3.h(android.view.View, android.content.Context):void");
    }
}
