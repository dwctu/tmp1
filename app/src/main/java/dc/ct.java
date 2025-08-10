package dc;

import com.component.dxdatabase.lib.bean.BILogDbBean;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: IStrategyHandler.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u001a\u0010\n\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/handler/IStrategyHandler;", "", "isEnable", "", "()Z", "handle", "", "beanList", "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "maybeDo", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ct {

    /* compiled from: IStrategyHandler.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ct ctVar, List list, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: maybeDo");
            }
            if ((i & 1) != 0) {
                list = null;
            }
            ctVar.b(list);
        }
    }

    void a(@Nullable List<BILogDbBean> list);

    void b(@Nullable List<BILogDbBean> list);
}
