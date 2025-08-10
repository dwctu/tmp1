package dc;

import com.component.dxdatabase.lib.bean.BILogDbBean;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseStrategyHandler.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/handler/BaseStrategyHandler;", "Lcom/component/dxbilog/lib/manual/strategy/handler/IStrategyHandler;", "()V", "isEnable", "", "()Z", "next", "getNext", "()Lcom/component/dxbilog/lib/manual/strategy/handler/IStrategyHandler;", "setNext", "(Lcom/component/dxbilog/lib/manual/strategy/handler/IStrategyHandler;)V", "handle", "", "beanList", "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "maybeDo", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class bt implements ct {

    @Nullable
    public ct a;

    @Override // dc.ct
    public abstract void a(@Nullable List<BILogDbBean> list);

    @Override // dc.ct
    public void b(@Nullable List<BILogDbBean> list) {
        if (d()) {
            a(list);
            return;
        }
        ct ctVar = this.a;
        if (ctVar == null) {
            return;
        }
        ctVar.a(list);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final ct getA() {
        return this.a;
    }

    public abstract boolean d();

    public final void e(@Nullable ct ctVar) {
        this.a = ctVar;
    }
}
