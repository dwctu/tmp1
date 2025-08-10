package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'TOPHY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: HyttoEum.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/component/dxhyttoutils/lib/data/HyttoEum$AppCode;", "", XHTMLText.CODE, "", "tag", "", "tag2", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getTag", "()Ljava/lang/String;", "getTag2", "REMOTE", "VIBEMATE", "TOPHY", "STREAM_MASTER", "CONNECT", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class iz {
    public static final iz CONNECT;
    public static final iz TOPHY;
    private final int code;

    @NotNull
    private final String tag;

    @NotNull
    private final String tag2;
    public static final iz REMOTE = new iz("REMOTE", 0, 10, "remote", null, 4, null);
    public static final iz VIBEMATE = new iz("VIBEMATE", 1, 20, "vibemate", "surfease");
    public static final iz STREAM_MASTER = new iz("STREAM_MASTER", 3, 40, "streammaster", null, 4, null);
    private static final /* synthetic */ iz[] $VALUES = $values();

    private static final /* synthetic */ iz[] $values() {
        return new iz[]{REMOTE, VIBEMATE, TOPHY, STREAM_MASTER, CONNECT};
    }

    static {
        String str = null;
        int i = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        TOPHY = new iz("TOPHY", 2, 30, "tophy", str, i, defaultConstructorMarker);
        CONNECT = new iz("CONNECT", 4, 50, "connect", str, i, defaultConstructorMarker);
    }

    private iz(String str, int i, int i2, String str2, String str3) {
        this.code = i2;
        this.tag = str2;
        this.tag2 = str3;
    }

    public static iz valueOf(String str) {
        return (iz) Enum.valueOf(iz.class, str);
    }

    public static iz[] values() {
        return (iz[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getTag2() {
        return this.tag2;
    }

    public /* synthetic */ iz(String str, int i, int i2, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, str2, (i3 & 4) != 0 ? str2 : str3);
    }
}
