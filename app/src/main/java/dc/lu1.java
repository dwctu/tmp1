package dc;

import android.view.View;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiViewClick.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/wear/ext/MultiViewClick;", "Landroid/view/View$OnClickListener;", "clickNum", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/ext/MultiViewClick$MultiClickListener;", "(ILcom/wear/ext/MultiViewClick$MultiClickListener;)V", "counterClicks", "isBusy", "", "onClick", "", PSOProgramService.VS_Key, "Landroid/view/View;", "Companion", "MultiClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class lu1 implements View.OnClickListener {
    public final int a;

    @Nullable
    public final a b;
    public int c;
    public boolean d;

    /* compiled from: MultiViewClick.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/ext/MultiViewClick$MultiClickListener;", "", "multiClick", "", "view", "Landroid/view/View;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(@Nullable View view);
    }

    @JvmOverloads
    public lu1(int i, @Nullable a aVar) {
        this.a = i;
        this.b = aVar;
    }

    public static final void b(lu1 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.c >= this$0.a) {
            a aVar = this$0.b;
            if (aVar != null) {
                aVar.a(view);
            }
            this$0.c = 0;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable final View v) {
        if (this.d) {
            return;
        }
        this.d = true;
        this.c++;
        if (v != null) {
            v.postDelayed(new Runnable() { // from class: dc.vt1
                @Override // java.lang.Runnable
                public final void run() {
                    lu1.b(this.a, v);
                }
            }, 200L);
        }
        this.d = false;
    }
}
