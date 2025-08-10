package dc;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: Toy.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/wear/ext/ToySymbol;", "", "symbols", "", "", "(Ljava/lang/String;ILjava/util/List;)V", "getSymbols", "()Ljava/util/List;", "XMACHINE", "MINI_XMACHINE", "TENERA", "SOLACE_PRO", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public enum wu1 {
    XMACHINE(CollectionsKt__CollectionsJVMKt.listOf("f")),
    MINI_XMACHINE(CollectionsKt__CollectionsJVMKt.listOf("fs")),
    TENERA(CollectionsKt__CollectionsJVMKt.listOf(XHTMLText.Q)),
    SOLACE_PRO(CollectionsKt__CollectionsJVMKt.listOf("ba"));


    @NotNull
    private final List<String> symbols;

    wu1(List list) {
        this.symbols = list;
    }

    @NotNull
    public final List<String> getSymbols() {
        return this.symbols;
    }
}
