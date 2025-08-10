package dc;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: RomUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/utils/RomInfo;", "", "()V", "androidVersionCode", "", "getAndroidVersionCode", "()I", "setAndroidVersionCode", "(I)V", "androidVersionName", "", "getAndroidVersionName", "()Ljava/lang/String;", "setAndroidVersionName", "(Ljava/lang/String;)V", "model", "getModel", "setModel", "name", "getName", "setName", "uiVersion", "getUiVersion", "setUiVersion", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class eu2 {

    @Nullable
    public String a;

    /* renamed from: b, reason: from toString */
    @Nullable
    public String uiVersion;

    /* renamed from: c, reason: from toString */
    public int androidVersion;

    /* renamed from: d, reason: from toString */
    @Nullable
    public String androidVersionName;

    /* renamed from: e, reason: from toString */
    @Nullable
    public String model;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getA() {
        return this.a;
    }

    public final void c(int i) {
        this.androidVersion = i;
    }

    public final void d(@Nullable String str) {
        this.androidVersionName = str;
    }

    public final void e(@Nullable String str) {
        this.model = str;
    }

    public final void f(@Nullable String str) {
        this.a = str;
    }

    public final void g(@Nullable String str) {
        this.uiVersion = str;
    }

    @NotNull
    public String toString() {
        return "RomInfo{name=" + this.a + ", uiVersion=" + this.uiVersion + ", model=" + this.model + ", androidVersion=" + this.androidVersion + ", androidVersionName=" + this.androidVersionName + MessageFormatter.DELIM_STOP;
    }
}
