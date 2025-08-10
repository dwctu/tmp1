package dc;

import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.lovense.wear.R;
import com.wear.bean.ControlLinkBean;
import com.wear.bean.socketio.controlLink.request.AddFriendsRequest;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.util.WearUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlLinkAddFriendDialog.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020,H\u0002J\u0006\u00100\u001a\u00020*J\b\u00101\u001a\u00020*H\u0002J\u0006\u00102\u001a\u00020\u0011J\u000e\u00103\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u00104\u001a\u00020*J\u0006\u00105\u001a\u00020*J\u0006\u00106\u001a\u00020*J\u000e\u00107\u001a\u00020*2\u0006\u00108\u001a\u000209J\u0010\u0010:\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u000109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010#\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001a\u0010&\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001c¨\u0006<"}, d2 = {"Lcom/wear/widget/dialog/ControlLinkAddFriendDialog;", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/wear/ui/longDistance/controlLink/ControlLinkChatActivity;", "bean", "Lcom/wear/bean/ControlLinkBean;", "(Lcom/wear/ui/longDistance/controlLink/ControlLinkChatActivity;Lcom/wear/bean/ControlLinkBean;)V", "imageClose", "Landroid/widget/ImageView;", "getImageClose", "()Landroid/widget/ImageView;", "setImageClose", "(Landroid/widget/ImageView;)V", "imageIcon", "getImageIcon", "setImageIcon", "isFastDoubleClick", "", "()Z", "lastClickTime", "", "popupWindow", "Landroid/widget/PopupWindow;", "tvContent", "Landroid/widget/TextView;", "getTvContent", "()Landroid/widget/TextView;", "setTvContent", "(Landroid/widget/TextView;)V", "tvEllipsis", "getTvEllipsis", "setTvEllipsis", "tvTextAccept", "getTvTextAccept", "setTvTextAccept", "tvTextRed", "getTvTextRed", "setTvTextRed", "tvTextWhite", "getTvTextWhite", "setTvTextWhite", "animatorStart", "", "int", "", "append", "", "count", "dismiss", "initDialog", "isShowing", "logUtilsS0009", "setButtonTextToAccept", "setButtonTextToSend", "setButtonTextToWaiting", "setView", "view", "Landroid/view/View;", "showAsDropDown", "anchor", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class xr3 {

    @NotNull
    public final ControlLinkChatActivity a;

    @NotNull
    public final ControlLinkBean b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;

    @Nullable
    public PopupWindow i;
    public long j;

    public xr3(@NotNull ControlLinkChatActivity activity, @NotNull ControlLinkBean bean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.a = activity;
        this.b = bean;
        k();
    }

    public static final void b(xr3 this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.g().setText(this$0.c(((Integer) animatedValue).intValue()));
    }

    public static final void l(xr3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.o()) {
            return;
        }
        AddFriendsRequest addFriendsRequest = new AddFriendsRequest();
        addFriendsRequest.setLinkId(this$0.b.getLinkId());
        addFriendsRequest.ackId = WearUtils.E();
        eq2.f().h(addFriendsRequest);
        this$0.x();
        this$0.u(1);
    }

    public static final void m(xr3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.o()) {
            return;
        }
        AddFriendsRequest addFriendsRequest = new AddFriendsRequest();
        addFriendsRequest.setLinkId(this$0.b.getLinkId());
        addFriendsRequest.ackId = WearUtils.E();
        eq2.f().h(addFriendsRequest);
        ControlLinkChatActivity controlLinkChatActivity = this$0.a;
        if (controlLinkChatActivity != null) {
            controlLinkChatActivity.Z5(true);
        }
        this$0.u(3);
    }

    public static final void n(xr3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.o()) {
            return;
        }
        PopupWindow popupWindow = this$0.i;
        Intrinsics.checkNotNull(popupWindow);
        popupWindow.dismiss();
        ControlLinkChatActivity controlLinkChatActivity = this$0.a;
        if (controlLinkChatActivity != null) {
            controlLinkChatActivity.a6();
        }
        if (this$0.h().getVisibility() == 0) {
            this$0.u(4);
        } else if (this$0.i().getVisibility() == 0) {
            this$0.u(2);
        }
    }

    public final void A(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.f = textView;
    }

    public final void B(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.h = textView;
    }

    public final void C(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.g = textView;
    }

    public final void D(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.d = textView;
    }

    public final void E(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.e = textView;
    }

    public final void F(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View viewFindViewById = view.findViewById(R.id.image_icon);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
        z((ImageView) viewFindViewById);
        View viewFindViewById2 = view.findViewById(R.id.image_close);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        y((ImageView) viewFindViewById2);
        View viewFindViewById3 = view.findViewById(R.id.tv_text_red);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        D((TextView) viewFindViewById3);
        View viewFindViewById4 = view.findViewById(R.id.tv_text_white);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        E((TextView) viewFindViewById4);
        View viewFindViewById5 = view.findViewById(R.id.tv_content);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.TextView");
        A((TextView) viewFindViewById5);
        View viewFindViewById6 = view.findViewById(R.id.tv_text_accept);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
        C((TextView) viewFindViewById6);
        View viewFindViewById7 = view.findViewById(R.id.tv_ellipsis);
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
        B((TextView) viewFindViewById7);
    }

    public final void G(@Nullable View view) {
        try {
            PopupWindow popupWindow = this.i;
            if (popupWindow != null) {
                popupWindow.showAsDropDown(view, 0, ce3.a(this.a, -1.0f));
            }
        } catch (Exception unused) {
        }
    }

    public final void a(int i) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 4);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: dc.yp3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                xr3.b(this.a, valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(4000L);
        valueAnimatorOfInt.setRepeatCount(200);
        valueAnimatorOfInt.setRepeatMode(1);
        g().setVisibility(0);
        valueAnimatorOfInt.start();
    }

    public final String c(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
            return string;
        }
        for (int i2 = 1; i2 <= i; i2++) {
            sb.append(".");
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "builder.toString()");
        return string2;
    }

    public final void d() {
        PopupWindow popupWindow = this.i;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @NotNull
    public final ImageView e() {
        ImageView imageView = this.c;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageClose");
        return null;
    }

    @NotNull
    public final TextView f() {
        TextView textView = this.f;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvContent");
        return null;
    }

    @NotNull
    public final TextView g() {
        TextView textView = this.h;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvEllipsis");
        return null;
    }

    @NotNull
    public final TextView h() {
        TextView textView = this.g;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTextAccept");
        return null;
    }

    @NotNull
    public final TextView i() {
        TextView textView = this.d;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTextRed");
        return null;
    }

    @NotNull
    public final TextView j() {
        TextView textView = this.e;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTextWhite");
        return null;
    }

    public final void k() {
        View view = LayoutInflater.from(this.a).inflate(R.layout.dialog_control_link_add_friend, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        F(view);
        PopupWindow popupWindow = new PopupWindow(this.a);
        this.i = popupWindow;
        Intrinsics.checkNotNull(popupWindow);
        popupWindow.setContentView(view);
        PopupWindow popupWindow2 = this.i;
        Intrinsics.checkNotNull(popupWindow2);
        popupWindow2.setFocusable(false);
        PopupWindow popupWindow3 = this.i;
        Intrinsics.checkNotNull(popupWindow3);
        popupWindow3.setWidth(-1);
        PopupWindow popupWindow4 = this.i;
        Intrinsics.checkNotNull(popupWindow4);
        popupWindow4.setHeight(-2);
        PopupWindow popupWindow5 = this.i;
        Intrinsics.checkNotNull(popupWindow5);
        popupWindow5.setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow popupWindow6 = this.i;
        Intrinsics.checkNotNull(popupWindow6);
        popupWindow6.setAnimationStyle(R.style.ActionSheetDialogAnimation);
        i().setOnClickListener(new View.OnClickListener() { // from class: dc.zp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                xr3.l(this.a, view2);
            }
        });
        h().setOnClickListener(new View.OnClickListener() { // from class: dc.aq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                xr3.m(this.a, view2);
            }
        });
        e().setOnClickListener(new View.OnClickListener() { // from class: dc.bq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                xr3.n(this.a, view2);
            }
        });
    }

    public final boolean o() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.j < 1000) {
            return true;
        }
        this.j = jCurrentTimeMillis;
        return false;
    }

    public final boolean p() {
        PopupWindow popupWindow = this.i;
        if (popupWindow == null) {
            return false;
        }
        Intrinsics.checkNotNull(popupWindow);
        return popupWindow.isShowing();
    }

    public final void u(int i) {
        HashMap map = new HashMap();
        if (i == 1) {
            map.put("event_id", "send_friend_request_click");
            map.put("element_id", "send_friend_request");
        } else if (i == 2) {
            map.put("event_id", "send_friend_request_close_click");
            map.put("element_id", "send_friend_request_close");
        } else if (i == 3) {
            map.put("event_id", "accept_friend_request_click");
            map.put("element_id", "accept_friend_request");
        } else if (i == 4) {
            map.put("event_id", "accept_friend_request_close_click");
            map.put("element_id", "accept_friend_request_close");
        }
        map.put("page_name", "control link chatroom");
        map.put("event_type", "click");
        map.put("element_type", "button");
        String linkId = this.b.getLinkId();
        Intrinsics.checkNotNullExpressionValue(linkId, "bean.linkId");
        map.put("element_name", linkId);
        map.put("toys", WearUtils.x.G().m());
        ye3.e("S0009", map);
    }

    public final void v() {
        i().setVisibility(8);
        j().setVisibility(8);
        g().setVisibility(8);
        h().setVisibility(0);
        f().setText(ah4.e(R.string.control_link_friend_request_sent_reminder));
    }

    public final void w() {
        i().setVisibility(0);
        j().setVisibility(8);
        h().setVisibility(8);
        g().setVisibility(8);
        f().setText(ah4.e(R.string.control_link_friend_request_reminder));
    }

    public final void x() {
        i().setVisibility(8);
        j().setVisibility(0);
        h().setVisibility(8);
        f().setText(ah4.e(R.string.control_link_friend_request_sent));
        a(1);
    }

    public final void y(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.c = imageView;
    }

    public final void z(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
    }
}
