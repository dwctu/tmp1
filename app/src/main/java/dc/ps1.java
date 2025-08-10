package dc;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyMiddleDataDB.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/wear/component/dxtoy/db/ToyMiddleDataDB;", "Lcom/component/dxtoy/core/utils/BaseMmkvUtil;", "()V", "EXPORT_TOY_DATA", "", "clearExportToyDataLabel", "", "isHasExportToyData", "", "saveExportToyDataLabel", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ps1 extends vb0 {

    @NotNull
    public static final ps1 d = new ps1();

    public ps1() {
        super("Remote_Toy_Middle_Data", 0, 2, null);
    }

    public final void m() {
        l("export_toy_data");
    }

    public final boolean n() {
        return c("export_toy_data");
    }

    public final void o() {
        k("export_toy_data", true);
    }
}
