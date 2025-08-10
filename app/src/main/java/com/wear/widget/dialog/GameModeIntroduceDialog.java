package com.wear.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.wear.adapter.game.GamingAdAdapter;
import com.wear.bean.GamingAdBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.protocol.exception.NetException;
import com.wear.widget.dialog.GameModeIntroduceDialog;
import com.wear.widget.recycler.NoScrollRecyclerView;
import dc.ah4;
import dc.ce3;
import dc.te3;
import dc.th4;
import dc.tn2;
import dc.ye3;
import dc.zn2;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import rx.Subscription;

/* compiled from: GameModeIntroduceDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J*\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u001a\u0010\u001a\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00120\u001bJ \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u001dH\u0002J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u0012H\u0003J\u0006\u0010%\u001a\u00020\u0012J\u0006\u0010&\u001a\u00020\u0012J\u0012\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010)H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/wear/widget/dialog/GameModeIntroduceDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "rect", "Landroid/graphics/Rect;", "(Landroid/content/Context;Landroid/graphics/Rect;)V", "disposable", "Lio/reactivex/disposables/Disposable;", "rvGaming1", "Lcom/wear/widget/recycler/NoScrollRecyclerView;", "rvGaming2", "subscription", "Lrx/Subscription;", "tvGameDesc", "Landroid/widget/TextView;", "tvGuideIntegration", "addLog", "", "key", "", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getAdGamingLogoList", Callback.METHOD_NAME, "Lkotlin/Function1;", "", "", "getClickSpanString", "Landroid/text/SpannableString;", "sentence", "link", "getView", "Landroid/view/View;", "initData", "initTimer", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class GameModeIntroduceDialog extends BottomSheetDialog {

    @NotNull
    public final Context a;

    @NotNull
    public final Rect b;

    @Nullable
    public Subscription c;

    @Nullable
    public Disposable d;

    @Nullable
    public TextView e;

    @Nullable
    public TextView f;

    @Nullable
    public NoScrollRecyclerView g;

    @Nullable
    public NoScrollRecyclerView h;

    /* compiled from: GameModeIntroduceDialog.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/wear/widget/dialog/GameModeIntroduceDialog$getAdGamingLogoList$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "Lcom/wear/bean/GamingAdBean;", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements zn2<BaseResponseBeanNew<GamingAdBean>> {
        public final /* synthetic */ Function1<List<String>, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super List<String>, Unit> function1) {
            this.a = function1;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable BaseResponseBeanNew<GamingAdBean> baseResponseBeanNew) {
            if (baseResponseBeanNew != null) {
                Function1<List<String>, Unit> function1 = this.a;
                GamingAdBean gamingAdBean = baseResponseBeanNew.data;
                function1.invoke(gamingAdBean != null ? gamingAdBean.getLogo() : null);
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: GameModeIntroduceDialog.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/wear/widget/dialog/GameModeIntroduceDialog$getClickSpanString$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends ClickableSpan {
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public b(String str, int i) {
            this.b = str;
            this.c = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            te3.a(GameModeIntroduceDialog.this.a, this.b);
            GameModeIntroduceDialog.this.e(this.c);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(th4.b(GameModeIntroduceDialog.this.a, R.color.control_link_tophyapp_textcolor));
            ds.setUnderlineText(false);
        }
    }

    /* compiled from: GameModeIntroduceDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<List<? extends String>, Unit> {
        public c() {
            super(1);
        }

        public final void a(@Nullable List<String> list) {
            if (list != null) {
                GameModeIntroduceDialog gameModeIntroduceDialog = GameModeIntroduceDialog.this;
                GamingAdAdapter gamingAdAdapter = new GamingAdAdapter(CollectionsKt___CollectionsKt.slice((List) list, RangesKt___RangesKt.until(0, list.size() / 2)));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(gameModeIntroduceDialog.a);
                linearLayoutManager.setOrientation(0);
                NoScrollRecyclerView noScrollRecyclerView = gameModeIntroduceDialog.g;
                if (noScrollRecyclerView != null) {
                    noScrollRecyclerView.setLayoutManager(linearLayoutManager);
                    noScrollRecyclerView.setAdapter(gamingAdAdapter);
                    noScrollRecyclerView.scrollToPosition(gamingAdAdapter.getItemCount() - 1);
                }
                GamingAdAdapter gamingAdAdapter2 = new GamingAdAdapter(CollectionsKt___CollectionsKt.slice((List) list, RangesKt___RangesKt.until(list.size() / 2, list.size())));
                LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(gameModeIntroduceDialog.a);
                linearLayoutManager2.setOrientation(0);
                NoScrollRecyclerView noScrollRecyclerView2 = gameModeIntroduceDialog.h;
                if (noScrollRecyclerView2 != null) {
                    noScrollRecyclerView2.setLayoutManager(linearLayoutManager2);
                    noScrollRecyclerView2.setAdapter(gamingAdAdapter2);
                }
                gameModeIntroduceDialog.k();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            a(list);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameModeIntroduceDialog(@NotNull Context context, @NotNull Rect rect) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.a = context;
        this.b = rect;
    }

    public static final void j(GameModeIntroduceDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void l(GameModeIntroduceDialog this$0, Long l) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NoScrollRecyclerView noScrollRecyclerView = this$0.g;
        if (noScrollRecyclerView != null) {
            noScrollRecyclerView.smoothScrollBy(-ce3.a(this$0.a, 1.0f), 0);
        }
        NoScrollRecyclerView noScrollRecyclerView2 = this$0.h;
        if (noScrollRecyclerView2 != null) {
            noScrollRecyclerView2.smoothScrollBy(ce3.a(this$0.a, 1.0f), 0);
        }
    }

    public static final void n(GameModeIntroduceDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Subscription subscription = this$0.c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Disposable disposable = this$0.d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.b.contains((int) ev.getRawX(), (int) ev.getRawY())) {
            return super.dispatchTouchEvent(ev);
        }
        cancel();
        return true;
    }

    public final void e(int i) {
        ye3.j("Game Mode", "game_mode_tip_hyperlink_click", "click", "game_mode_tip_hyperlink", "link", i == R.string.hyperlink_interactive_gaming ? "lovense interactive gaming" : "standard soloutions document", "", -1L);
    }

    public final void f(@NotNull Context context, @NotNull Function1<? super List<String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        String strS = ye3.s();
        Intrinsics.checkNotNullExpressionValue(strS, "getAppVersionName()");
        linkedHashMap.put("version", strS);
        this.c = tn2.x(context).k("/discover/games/advertise", linkedHashMap, new a(callback));
    }

    public final SpannableString g(int i, int i2, String str) {
        String keyword = ah4.e(i2);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strE = ah4.e(i);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(sentence)");
        String str2 = String.format(strE, Arrays.copyOf(new Object[]{ah4.e(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, keyword, 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return new SpannableString(str2);
        }
        int length = keyword.length() + iIndexOf$default;
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new b(str, i2), iIndexOf$default, length, 17);
        return spannableString;
    }

    @NotNull
    public final View h() {
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_game_mode_introduce, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(R.…ame_mode_introduce, null)");
        return viewInflate;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void i() {
        TextView textView = (TextView) findViewById(R.id.tv_dismiss);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: dc.jq3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameModeIntroduceDialog.j(this.a, view);
                }
            });
        }
        f(this.a, new c());
    }

    public final void k() {
        this.d = Observable.interval(50L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: dc.hq3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GameModeIntroduceDialog.l(this.a, (Long) obj);
            }
        });
    }

    public final void m() {
        TextView textView = (TextView) findViewById(R.id.tv_new_pc_game_des);
        this.e = textView;
        if (textView != null) {
            textView.setText(g(R.string.new_pc_game_des, R.string.hyperlink_interactive_gaming, "https://www.lovense.com/interactive-gaming"));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView textView2 = (TextView) findViewById(R.id.tv_game_mode_guide_integration);
        this.f = textView2;
        if (textView2 != null) {
            textView2.setText(g(R.string.game_mode_guide_integration, R.string.hyperlink_standard_solutions, "https://developer.lovense.com/docs/standard-solutions.html"));
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.g = (NoScrollRecyclerView) findViewById(R.id.rv_gaming1);
        this.h = (NoScrollRecyclerView) findViewById(R.id.rv_gaming2);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.height = -2;
            attributes.width = -1;
            window.setAttributes(attributes);
            window.getDecorView().setPadding(0, ce3.a(this.a, 60.0f), 0, 0);
        }
        setCancelable(true);
        BottomSheetBehavior<FrameLayout> behavior = getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "this.behavior");
        behavior.setPeekHeight(ce3.a(this.a, 700.0f));
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.iq3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                GameModeIntroduceDialog.n(this.a, dialogInterface);
            }
        });
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(h());
        m();
        i();
    }
}
