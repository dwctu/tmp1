package com.wear.widget.chatfunction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import com.wear.widget.chatfunction.LiveControlParentView;
import dc.ce3;
import dc.th4;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveControlParentView.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u001fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0001H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u000bR\u000e\u0010\t\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/wear/widget/chatfunction/LiveControlParentView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeLayout", "itemclick", "Lcom/wear/widget/chatfunction/LiveControlParentView$ItemClick;", "name", "Landroid/widget/TextView;", "shutLayout", "textView", "timeView", "totalLayout", "getControlTime", "", "getImageView", "", "item", "initView", "setControlTime", "text", "setControlTimeViewVisibility", "visicble", "setControlTipText", "setItemClickListener", "itemClick", "ItemClick", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class LiveControlParentView extends LinearLayout {

    @NotNull
    public LinearLayout a;

    @NotNull
    public final TextView b;

    @Nullable
    public a c;

    @NotNull
    public final TextView d;

    @NotNull
    public final TextView e;

    @NotNull
    public LinearLayout f;

    @NotNull
    public LinearLayout g;

    /* compiled from: LiveControlParentView.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wear/widget/chatfunction/LiveControlParentView$ItemClick;", "", "click", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveControlParentView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveControlParentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LiveControlParentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void c(LiveControlParentView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static final void d(LiveControlParentView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(LinearLayout linearLayout) {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ce3.a(getContext(), 20.0f), ce3.a(getContext(), 20.0f));
        layoutParams.bottomMargin = ce3.a(getContext(), 5.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(th4.d(getContext(), R.drawable.chat_toolbar_end));
        linearLayout.addView(imageView);
    }

    public final void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.a = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, ce3.a(getContext(), 50.0f)));
        this.a.setOrientation(1);
        this.a.setGravity(17);
        addView(this.a);
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.g.setOrientation(0);
        this.g.setGravity(17);
        a(this.g);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 16;
        this.e.setLayoutParams(layoutParams);
        this.e.setTextSize(ce3.g(getContext(), 6.0f));
        this.e.setTextColor(th4.b(getContext(), R.color.text_color_65));
        this.e.setText("00:00");
        this.g.addView(this.e);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: dc.uo3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveControlParentView.c(this.a, view);
            }
        });
        this.a.addView(this.g);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, ce3.a(getContext(), 65.0f)));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        String string = getContext().getString(R.string.live_control_panel_partner_no_toy);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…rol_panel_partner_no_toy)");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        this.d.setLayoutParams(layoutParams2);
        this.d.setTextSize(ce3.g(getContext(), 5.0f));
        this.d.setTextColor(ContextCompat.getColor(getContext(), R.color.text_color_65));
        ViewGroup.LayoutParams layoutParams3 = this.d.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams3).setMargins(ce3.a(getContext(), 10.0f), 0, ce3.a(getContext(), 10.0f), 0);
        this.d.setText(string);
        linearLayout2.addView(this.d);
        this.f.setLayoutParams(new LinearLayout.LayoutParams(ce3.a(getContext(), 100.0f), -2));
        this.f.setOrientation(1);
        this.f.setGravity(17);
        a(this.f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.b.setLayoutParams(layoutParams4);
        this.b.setTextSize(ce3.g(getContext(), 6.0f));
        this.b.setTextColor(th4.b(getContext(), R.color.text_color_65));
        this.b.setText("00:00");
        this.f.addView(this.b);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: dc.to3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveControlParentView.d(this.a, view);
            }
        });
        linearLayout2.addView(this.f);
        addView(linearLayout2);
    }

    @NotNull
    public final String getControlTime() {
        return this.b.getText().toString();
    }

    public final void setControlTime(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.b.setText(text);
    }

    public final void setControlTimeViewVisibility(int visicble) {
        this.b.setVisibility(visicble);
    }

    public final void setControlTipText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.d.setText(text);
    }

    public final void setItemClickListener(@NotNull a itemClick) {
        Intrinsics.checkNotNullParameter(itemClick, "itemClick");
        this.c = itemClick;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveControlParentView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new LinearLayout(context);
        this.b = new TextView(context);
        this.d = new TextView(context);
        this.e = new TextView(context);
        this.f = new LinearLayout(context);
        this.g = new LinearLayout(context);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        setBackgroundColor(th4.b(context, R.color.tab_bg));
        b();
    }
}
