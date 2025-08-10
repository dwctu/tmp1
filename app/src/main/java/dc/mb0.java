package dc;

import androidx.room.Ignore;
import com.component.dxdatabase.lib.base.bean.DbBaseBean;
import com.component.dxtoy.core.toy.bean.ToyConfigInfoBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseToy.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00104\u001a\u000205H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR \u0010\"\u001a\u0004\u0018\u00010#8F@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001c\u0010+\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/component/dxtoy/core/toy/BaseToy;", "Lcom/component/dxdatabase/lib/base/bean/DbBaseBean;", "()V", "defineRename", "", "getDefineRename", "()Ljava/lang/String;", "setDefineRename", "(Ljava/lang/String;)V", "deviceName", "getDeviceName", "setDeviceName", "value", "deviceType", "getDeviceType", "setDeviceType", "isRealDeviceType", "", "()Z", "setRealDeviceType", "(Z)V", "isSelect", "setSelect", "isVirtualToy", "setVirtualToy", "mac", "getMac", "setMac", "showName", "getShowName", "setShowName", "symbol", "getSymbol", "setSymbol", "toyConfig", "Lcom/component/dxtoy/core/toy/bean/ToyConfigInfoBean;", "getToyConfig", "()Lcom/component/dxtoy/core/toy/bean/ToyConfigInfoBean;", "setToyConfig", "(Lcom/component/dxtoy/core/toy/bean/ToyConfigInfoBean;)V", "type", "getType", "setType", "uuid", "getUuid", "setUuid", "version", "", "getVersion", "()I", "setVersion", "(I)V", "initToyConfig", "", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class mb0 extends DbBaseBean {

    @Ignore
    @Nullable
    public transient ToyConfigInfoBean a;

    @Nullable
    private String defineRename;

    @Nullable
    private String deviceName;

    @Nullable
    private String deviceType;
    private boolean isSelect;
    private boolean isVirtualToy;

    @NotNull
    private String mac = "";

    @Nullable
    private String showName;

    @Nullable
    private String symbol;

    @Nullable
    private String type;

    @Nullable
    private String uuid;
    private int version;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getDefineRename() {
        return this.defineRename;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMac() {
        return this.mac;
    }

    @Nullable
    public final String e() {
        if (this.showName == null) {
            ToyConfigInfoBean toyConfigInfoBeanG = g();
            this.showName = toyConfigInfoBeanG != null ? toyConfigInfoBeanG.getShowName() : null;
        }
        return this.showName;
    }

    @Nullable
    public final String f() {
        if (this.symbol == null) {
            k();
        }
        return this.symbol;
    }

    @Nullable
    public final ToyConfigInfoBean g() {
        if (this.a == null) {
            this.a = gb0.a.a(f());
        }
        return this.a;
    }

    @Nullable
    public final String h() {
        if (this.type == null) {
            ToyConfigInfoBean toyConfigInfoBeanG = g();
            this.type = toyConfigInfoBeanG != null ? toyConfigInfoBeanG.getType() : null;
        }
        return this.type;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: j, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final void k() {
        String str = this.deviceType;
        if (str != null) {
            List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null);
            int size = listSplit$default.size();
            if (size == 1) {
                this.symbol = (String) listSplit$default.get(0);
            } else if (size == 2 || size == 3) {
                this.symbol = (String) listSplit$default.get(0);
                this.version = Integer.parseInt((String) listSplit$default.get(1));
            } else {
                this.symbol = (String) listSplit$default.get(0);
            }
            this.a = gb0.a.a(f());
            ToyConfigInfoBean toyConfigInfoBeanG = g();
            this.type = toyConfigInfoBeanG != null ? toyConfigInfoBeanG.getType() : null;
            ToyConfigInfoBean toyConfigInfoBeanG2 = g();
            this.showName = toyConfigInfoBeanG2 != null ? toyConfigInfoBeanG2.getShowName() : null;
        }
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsVirtualToy() {
        return this.isVirtualToy;
    }

    public final void n(@Nullable String str) {
        this.defineRename = str;
    }

    public final void o(@Nullable String str) {
        this.deviceName = str;
    }

    public final void p(@Nullable String str) {
        this.deviceType = str;
        k();
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mac = str;
    }

    public final void r(boolean z) {
        this.isSelect = z;
    }

    public final void s(@Nullable String str) {
        this.showName = str;
    }

    public final void t(@Nullable String str) {
        this.symbol = str;
    }

    public final void u(@Nullable ToyConfigInfoBean toyConfigInfoBean) {
        this.a = toyConfigInfoBean;
    }

    public final void v(@Nullable String str) {
        this.type = str;
    }

    public final void w(@Nullable String str) {
        this.uuid = str;
    }

    public final void x(int i) {
        this.version = i;
    }

    public final void z(boolean z) {
        this.isVirtualToy = z;
    }
}
