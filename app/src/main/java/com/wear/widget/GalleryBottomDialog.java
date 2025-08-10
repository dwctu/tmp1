package com.wear.widget;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.widget.GalleryBottomDialog;
import dc.ah4;
import dc.ce3;
import dc.on3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GalleryBottomDialog.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0003J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/wear/widget/GalleryBottomDialog;", "Lcom/wear/widget/BottomDialog;", "context", "Landroid/content/Context;", "layoutResouce", "", "type", "bottomClickListener", "Lcom/wear/widget/GalleryBottomDialog$ClickListener;", "(Landroid/content/Context;IILcom/wear/widget/GalleryBottomDialog$ClickListener;)V", "getView", "Landroid/view/View;", "initData", "", "view", "initView", "ClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class GalleryBottomDialog extends BottomDialog {
    public final int c;
    public final int d;

    @Nullable
    public final a e;

    /* compiled from: GalleryBottomDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/wear/widget/GalleryBottomDialog$ClickListener;", "", "doCancel", "", "doConfirm", "name", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(@Nullable String str);
    }

    /* compiled from: GalleryBottomDialog.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/wear/widget/GalleryBottomDialog$initData$2$1", "Lcom/wear/widget/EditDialog$ClickListener;", "doCancel", "", "doConfirm", "name", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements on3.c {
        public b() {
        }

        @Override // dc.on3.c
        public void a(@Nullable String str) {
            a aVar = GalleryBottomDialog.this.e;
            if (aVar != null) {
                aVar.a(str);
            }
        }

        @Override // dc.on3.c
        public void doCancel() {
        }
    }

    public static final boolean f(Ref.FloatRef startY, Ref.FloatRef moveY, View decorView, GalleryBottomDialog this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(startY, "$startY");
        Intrinsics.checkNotNullParameter(moveY, "$moveY");
        Intrinsics.checkNotNullParameter(decorView, "$decorView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            startY.element = motionEvent.getY();
        } else if (action == 1) {
            String str = "decorView.scrollY==" + decorView.getScrollY() + " -decorView.height / 5===" + ((-decorView.getHeight()) / 8) + "moveY==" + moveY.element;
            if (decorView.getScrollY() < (-decorView.getHeight()) / 5) {
                this$0.dismiss();
            }
            decorView.scrollTo(0, 0);
        } else if (action == 2) {
            float y = motionEvent.getY() - startY.element;
            moveY.element = y;
            if (y > 0.0f) {
                decorView.scrollBy(0, -((int) y));
                startY.element = motionEvent.getY();
            }
            if (decorView.getScrollY() > 0) {
                decorView.scrollTo(0, 0);
            }
        }
        return true;
    }

    public static final void g(GalleryBottomDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.d == 1) {
            new on3(this$0.b, ah4.e(R.string.common_email), ah4.e(R.string.button_apply_developer), this$0.new b());
        } else {
            this$0.dismiss();
        }
    }

    @Override // com.wear.widget.BottomDialog
    @NotNull
    public View b() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(this.c, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(getContext()).inflate(layoutResouce, null)");
        return viewInflate;
    }

    @Override // com.wear.widget.BottomDialog
    public void c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.height = -2;
            attributes.width = -1;
            window.setAttributes(attributes);
            window.getDecorView().setPadding(0, ce3.a(this.b, 60.0f), 0, 0);
        }
        e(view);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void e(View view) {
        ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollView);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        final View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window!!.decorView");
        scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: dc.dn3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return GalleryBottomDialog.f(floatRef, floatRef2, decorView, this, view2, motionEvent);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.tv_dismiss);
        if (this.d == 1) {
            textView.setText(ah4.e(R.string.button_apply_developer));
        } else {
            textView.setText(ah4.e(R.string.button_continue));
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: dc.en3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GalleryBottomDialog.g(this.a, view2);
            }
        });
    }
}
