package dc;

import com.component.dxbilog.lib.business.bean.BILogS0014ContentBean;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.gs;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAppManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/component/dxbilog/lib/manager/BILogAppManager;", "", "()V", "appActionEngine", "Lcom/component/dxbilog/lib/listener/IBILogAppActionEngine;", "getAppActionEngine", "()Lcom/component/dxbilog/lib/listener/IBILogAppActionEngine;", "setAppActionEngine", "(Lcom/component/dxbilog/lib/listener/IBILogAppActionEngine;)V", "appDataEngine", "Lcom/component/dxbilog/lib/listener/IBILogAppDataEngine;", "getAppDataEngine", "()Lcom/component/dxbilog/lib/listener/IBILogAppDataEngine;", "setAppDataEngine", "(Lcom/component/dxbilog/lib/listener/IBILogAppDataEngine;)V", "logS0014", "", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class gs {

    @Nullable
    public as a;

    @Nullable
    public bs b;

    /* compiled from: BILogAppManager.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/component/dxbilog/lib/manager/BILogAppManager$logS0014$1$1$1", "Lcom/component/dxhyttoutils/lib/listener/DeviceIdCallback;", "done", "", TtmlNode.ATTR_ID, "", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements lz {
        public final /* synthetic */ as a;

        public a(as asVar) {
            this.a = asVar;
        }

        public static final void b(as it) {
            Intrinsics.checkNotNullParameter(it, "$it");
            BILogS0014ContentBean bILogS0014ContentBean = new BILogS0014ContentBean();
            bILogS0014ContentBean.setEmulator(rd0.f());
            bILogS0014ContentBean.setRoot(rd0.e());
            bILogS0014ContentBean.setHook(rd0.g());
            if (bILogS0014ContentBean.isUpload()) {
                String json = xd0.h().toJson(bILogS0014ContentBean);
                Intrinsics.checkNotNullExpressionValue(json, "getGsonNotNull().toJson(contentBean)");
                it.a("S0014", json);
            }
        }

        @Override // dc.lz
        public void a(@NotNull String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ExecutorService executorServiceB = se0.b();
            final as asVar = this.a;
            executorServiceB.execute(new Runnable() { // from class: dc.es
                @Override // java.lang.Runnable
                public final void run() {
                    gs.a.b(asVar);
                }
            });
        }
    }

    public static final void d(gs this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        as asVar = this$0.a;
        if (asVar == null) {
            return;
        }
        tz.a.d(new a(asVar));
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final bs getB() {
        return this.b;
    }

    public final void c() {
        se0.b().execute(new Runnable() { // from class: dc.ds
            @Override // java.lang.Runnable
            public final void run() {
                gs.d(this.a);
            }
        });
    }

    public final void e(@Nullable as asVar) {
        this.a = asVar;
    }
}
