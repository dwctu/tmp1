package dc;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.jivesoftware.smackx.shim.packet.Header;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: DefaultFormatPrinter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016JH\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\\\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016¨\u0006\u001a"}, d2 = {"Lcom/component/dxhttp/interceptor/logger/DefaultFormatPrinter;", "Lcom/component/dxhttp/utils/FormatPrinter;", "()V", "printFileRequest", "", DeliveryReceiptRequest.ELEMENT, "Lokhttp3/Request;", "printFileResponse", "chainMs", "", "isSuccessful", "", XHTMLText.CODE, "", HeadersExtension.ELEMENT, "", "segments", "", "message", "responseUrl", "printJsonRequest", "bodyString", "printJsonResponse", "contentType", "Lokhttp3/MediaType;", "Companion", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class xy implements cz {

    @NotNull
    public static final b a = new b(null);
    public static final String b;

    @NotNull
    public static final String c;

    @NotNull
    public static final String[] d;

    @NotNull
    public static final String[] e;

    /* compiled from: DefaultFormatPrinter.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"com/component/dxhttp/interceptor/logger/DefaultFormatPrinter$Companion$last$1", "Ljava/lang/ThreadLocal;", "", "initialValue", "()Ljava/lang/Integer;", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends ThreadLocal<Integer> {
        @Override // java.lang.ThreadLocal
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer initialValue() {
            return 0;
        }
    }

    /* compiled from: DefaultFormatPrinter.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u001d\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010$\u001a\u00020%H\u0002¢\u0006\u0002\u0010&JM\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,2\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050.2\u0006\u0010/\u001a\u00020\u0005H\u0002¢\u0006\u0002\u00100J\u0018\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\u0005H\u0002J\u0018\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020,2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u0005H\u0002J1\u00107\u001a\u000608j\u0002`92\u0006\u0010:\u001a\u00020\u00052\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010<\u001a\u00020,H\u0002¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005H\u0002J\u0018\u0010?\u001a\u00020\u00052\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050.H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001e\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/component/dxhttp/interceptor/logger/DefaultFormatPrinter$Companion;", "", "()V", "ARMS", "", "", "[Ljava/lang/String;", "AnaLySisTAG", "BODY_TAG", "CENTER_LINE", "CORNER_BOTTOM", "CORNER_UP", "DEFAULT_LINE", "DOUBLE_SEPARATOR", "END_LINE", "HEADERS_TAG", "LINE_SEPARATOR", "kotlin.jvm.PlatformType", "METHOD_TAG", "N", "OMITTED_REQUEST", "OMITTED_RESPONSE", "RECEIVED_TAG", "REQUEST_UP_LINE", "RESPONSE_UP_LINE", "STATUS_CODE_TAG", ExifInterface.GPS_DIRECTION_TRUE, "TAG", "URL_TAG", "last", "Ljava/lang/ThreadLocal;", "", "computeKey", "dotHeaders", Header.ELEMENT, "getRequest", DeliveryReceiptRequest.ELEMENT, "Lokhttp3/Request;", "(Lokhttp3/Request;)[Ljava/lang/String;", "getResponse", "tookMs", "", XHTMLText.CODE, "isSuccessful", "", "segments", "", "message", "(Ljava/lang/String;JIZLjava/util/List;Ljava/lang/String;)[Ljava/lang/String;", "getTag", "isRequest", ImagesContract.URL, "Lokhttp3/HttpUrl;", "isEmpty", "line", "logLines", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "tag", "lines", "withLineSize", "(Ljava/lang/String;[Ljava/lang/String;Z)Ljava/lang/StringBuilder;", "resolveTag", "slashSegments", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String f(String str) {
            String str2 = xy.b;
            Intrinsics.checkNotNull(str2);
            int i = 0;
            Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{str2}, false, 0, 6, (Object) null).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            StringBuilder sb = new StringBuilder();
            if (strArr.length > 1) {
                int length = strArr.length;
                while (i < length) {
                    int i2 = i + 1;
                    sb.append(i == 0 ? "┌ " : i == strArr.length - 1 ? "└ " : "├ ");
                    sb.append(strArr[i]);
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                    i = i2;
                }
            } else {
                int length2 = strArr.length;
                while (i < length2) {
                    String str3 = strArr[i];
                    i++;
                    sb.append("─ ");
                    sb.append(str3);
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
            return string;
        }

        public final String[] g(yc4 yc4Var) {
            String str;
            String string = yc4Var.e().toString();
            Intrinsics.checkNotNullExpressionValue(string, "request.headers().toString()");
            StringBuilder sb = new StringBuilder();
            sb.append("Method: @");
            sb.append((Object) yc4Var.g());
            sb.append(xy.c);
            if (k(string)) {
                str = "";
            } else {
                str = "Headers:" + ((Object) xy.b) + f(string);
            }
            sb.append(str);
            String string2 = sb.toString();
            String str2 = xy.b;
            Intrinsics.checkNotNull(str2);
            Object[] array = StringsKt__StringsKt.split$default((CharSequence) string2, new String[]{str2}, false, 0, 6, (Object) null).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (String[]) array;
        }

        public final String[] h(String str, long j, int i, boolean z, List<String> list, String str2) {
            String strM = m(list);
            StringBuilder sb = new StringBuilder();
            String str3 = "";
            sb.append(!TextUtils.isEmpty(strM) ? Intrinsics.stringPlus(strM, " - ") : "");
            sb.append("is success : ");
            sb.append(z);
            sb.append(" - Received in: ");
            sb.append(j);
            sb.append("ms");
            sb.append(xy.c);
            sb.append("Status Code: ");
            sb.append(i);
            sb.append(" / ");
            sb.append(str2);
            sb.append(xy.c);
            if (!k(str)) {
                str3 = "Headers:" + ((Object) xy.b) + f(str);
            }
            sb.append(str3);
            String string = sb.toString();
            String str4 = xy.b;
            Intrinsics.checkNotNull(str4);
            Object[] array = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{str4}, false, 0, 6, (Object) null).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (String[]) array;
        }

        public final String i(boolean z, String str) {
            return (StringsKt__StringsJVMKt.startsWith$default(str.toString(), "http://120.24.231.55:8099/", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(str.toString(), "https://mg-dcc.boye520.com/", false, 2, null)) ? z ? "AnaLySisLog-Request" : "AnaLySisLog-Response" : z ? "HttpLog-Request" : "HttpLog-Response";
        }

        public final String j(boolean z, rc4 rc4Var) {
            String string = rc4Var.toString();
            Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
            if (!StringsKt__StringsJVMKt.startsWith$default(string, "http://120.24.231.55:8099/", false, 2, null)) {
                String string2 = rc4Var.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "url.toString()");
                if (!StringsKt__StringsJVMKt.startsWith$default(string2, "https://mg-dcc.boye520.com/", false, 2, null)) {
                    return z ? "HttpLog-Request" : "HttpLog-Response";
                }
            }
            return z ? "AnaLySisLog-Request" : "AnaLySisLog-Response";
        }

        public final boolean k(String str) {
            if (!TextUtils.isEmpty(str) && !Intrinsics.areEqual(IOUtils.LINE_SEPARATOR_UNIX, str) && !Intrinsics.areEqual("\t", str)) {
                int length = str.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                if (!TextUtils.isEmpty(str.subSequence(i, length + 1).toString())) {
                    return false;
                }
            }
            return true;
        }

        public final StringBuilder l(String str, String[] strArr, boolean z) {
            StringBuilder sb = new StringBuilder();
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str2 = strArr[i];
                i++;
                Intrinsics.checkNotNull(str2);
                int length2 = str2.length();
                int i2 = z ? 110 : length2;
                int i3 = length2 / i2;
                if (i3 >= 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        sb.append('\n');
                        int i6 = i4 * i2;
                        int length3 = i5 * i2;
                        if (length3 > str2.length()) {
                            length3 = str2.length();
                        }
                        String strSubstring = str2.substring(i6, length3);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        if (i4 == i3) {
                            break;
                        }
                        i4 = i5;
                    }
                }
            }
            return sb;
        }

        public final String m(List<String> list) {
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append("/");
                sb.append(str);
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "segmentString.toString()");
            return string;
        }
    }

    static {
        String property = System.getProperty("line.separator");
        b = property;
        c = Intrinsics.stringPlus(property, property);
        d = new String[]{property, "Omitted response body"};
        e = new String[]{property, "Omitted request body"};
        new a();
    }

    @Override // dc.cz
    public void a(@NotNull yc4 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        b bVar = a;
        rc4 rc4VarJ = request.j();
        Intrinsics.checkNotNullExpressionValue(rc4VarJ, "request.url()");
        String strJ = bVar.j(true, rc4VarJ);
        StringBuilder sb = new StringBuilder("┌────── Request ──────");
        StringBuilder sbL = bVar.l(strJ, new String[]{Intrinsics.stringPlus("URL: ", request.j())}, false);
        StringBuilder sbL2 = bVar.l(strJ, bVar.g(request), true);
        StringBuilder sbL3 = bVar.l(strJ, e, true);
        sb.append((CharSequence) sbL);
        sb.append((CharSequence) sbL2);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "headLine.append(s1).append(s2).toString()");
        de0.i(string);
        String str = "┌────── Request ──────" + ((CharSequence) sbL3);
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder(REQUEST_UP…NE).append(s3).toString()");
        de0.i(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    @Override // dc.cz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(long r20, boolean r22, int r23, @org.jetbrains.annotations.NotNull java.lang.String r24, @org.jetbrains.annotations.Nullable dc.tc4 r25, @org.jetbrains.annotations.Nullable java.lang.String r26, @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r27, @org.jetbrains.annotations.NotNull java.lang.String r28, @org.jetbrains.annotations.NotNull java.lang.String r29) throws org.json.JSONException, javax.xml.transform.TransformerException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.xy.b(long, boolean, int, java.lang.String, dc.tc4, java.lang.String, java.util.List, java.lang.String, java.lang.String):void");
    }

    @Override // dc.cz
    public void c(long j, boolean z, int i, @NotNull String headers, @NotNull List<String> segments, @NotNull String message, @NotNull String responseUrl) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(responseUrl, "responseUrl");
        b bVar = a;
        String strI = bVar.i(false, responseUrl);
        String[] strArr = {Intrinsics.stringPlus("URL: ", responseUrl)};
        StringBuilder sb = new StringBuilder("┌────── Response ──────");
        StringBuilder sbL = bVar.l(strI, strArr, true);
        StringBuilder sbL2 = bVar.l(strI, bVar.h(headers, j, i, z, segments, message), true);
        StringBuilder sbL3 = bVar.l(strI, d, true);
        sb.append((CharSequence) sbL);
        sb.append((CharSequence) sbL2);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "headLine.append(s1).append(s2).toString()");
        de0.i(string);
        String str = "┌────── Response ──────" + ((CharSequence) sbL3);
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder(RESPONSE_U…NE).append(s3).toString()");
        de0.i(str);
    }

    @Override // dc.cz
    public void d(@NotNull yc4 request, @NotNull String bodyString) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bodyString, "bodyString");
        StringBuilder sb = new StringBuilder();
        sb.append("Body:");
        String str = b;
        sb.append((Object) str);
        sb.append(StringsKt__StringsJVMKt.replace$default(bodyString, "\\/", "/", false, 4, (Object) null));
        String string = sb.toString();
        b bVar = a;
        rc4 rc4VarJ = request.j();
        Intrinsics.checkNotNullExpressionValue(rc4VarJ, "request.url()");
        String strJ = bVar.j(true, rc4VarJ);
        StringBuilder sb2 = new StringBuilder("┌────── Request ──────");
        StringBuilder sbL = bVar.l(strJ, new String[]{Intrinsics.stringPlus("URL: ", request.j())}, false);
        StringBuilder sbL2 = bVar.l(strJ, bVar.g(request), true);
        Intrinsics.checkNotNull(str);
        Object[] array = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{str}, false, 0, 6, (Object) null).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        StringBuilder sbL3 = bVar.l(strJ, (String[]) array, true);
        sb2.append((CharSequence) sbL);
        sb2.append((CharSequence) sbL2);
        String string2 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "headLine.append(s1).append(s2).toString()");
        de0.i(string2);
        String str2 = "┌────── Request ──────" + ((CharSequence) sbL3);
        Intrinsics.checkNotNullExpressionValue(str2, "StringBuilder(REQUEST_UP…NE).append(s3).toString()");
        de0.i(str2);
    }
}
