package com.tencent.qgame.animplayer.textureview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import dc.pg1;
import dc.vh1;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InnerTextureView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/tencent/qgame/animplayer/textureview/InnerTextureView;", "Landroid/view/TextureView;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Ldc/pg1;", "a", "Ldc/pg1;", "getPlayer", "()Ldc/pg1;", "setPlayer", "(Ldc/pg1;)V", "player", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animplayer_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class InnerTextureView extends TextureView {

    /* renamed from: a, reason: from kotlin metadata */
    @Nullable
    public pg1 player;

    @JvmOverloads
    public InnerTextureView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public InnerTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ InnerTextureView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev) {
        pg1 pg1Var;
        vh1 vh1VarJ;
        pg1 pg1Var2 = this.player;
        if ((pg1Var2 == null || !pg1Var2.o() || ev == null || (pg1Var = this.player) == null || (vh1VarJ = pg1Var.j()) == null || !vh1VarJ.e(ev)) ? false : true) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Nullable
    public final pg1 getPlayer() {
        return this.player;
    }

    public final void setPlayer(@Nullable pg1 pg1Var) {
        this.player = pg1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InnerTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }
}
