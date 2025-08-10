package dc;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: FormatPrinter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JH\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH&J\\\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH&¨\u0006\u0018"}, d2 = {"Lcom/component/dxhttp/utils/FormatPrinter;", "", "printFileRequest", "", DeliveryReceiptRequest.ELEMENT, "Lokhttp3/Request;", "printFileResponse", "chainMs", "", "isSuccessful", "", XHTMLText.CODE, "", HeadersExtension.ELEMENT, "", "segments", "", "message", "responseUrl", "printJsonRequest", "bodyString", "printJsonResponse", "contentType", "Lokhttp3/MediaType;", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface cz {
    void a(@NotNull yc4 yc4Var);

    void b(long j, boolean z, int i, @NotNull String str, @Nullable tc4 tc4Var, @Nullable String str2, @NotNull List<String> list, @NotNull String str3, @NotNull String str4);

    void c(long j, boolean z, int i, @NotNull String str, @NotNull List<String> list, @NotNull String str2, @NotNull String str3);

    void d(@NotNull yc4 yc4Var, @NotNull String str);
}
