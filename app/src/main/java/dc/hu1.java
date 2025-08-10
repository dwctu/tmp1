package dc;

import com.component.dxutilcode.lib.utils.ToastUtils;
import com.sun.jna.Callback;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpCoroutine.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestDownloadFile$2$1", "Lcom/wear/util/MyListener;", Callback.METHOD_NAME, "", "result", "", "message", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes3.dex */
public final class hu1 extends ff3 {
    public final /* synthetic */ yy3<File> a;

    /* JADX WARN: Multi-variable type inference failed */
    public hu1(yy3<? super File> yy3Var) {
        this.a = yy3Var;
    }

    @Override // dc.ff3
    public void b(boolean z, @Nullable Object obj) {
        if (!z) {
            ToastUtils.z("File download failed.", new Object[0]);
            return;
        }
        yy3<File> yy3Var = this.a;
        File file = obj instanceof File ? (File) obj : null;
        if (file == null) {
            return;
        }
        Result.Companion companion = Result.INSTANCE;
        yy3Var.resumeWith(Result.m86constructorimpl(file));
    }
}
