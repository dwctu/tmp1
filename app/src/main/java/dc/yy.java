package dc;

import com.broadcom.bt.util.mime4j.field.ContentTypeField;
import com.google.common.net.HttpHeaders;
import com.xtremeprog.sdk.ble.BleService;
import dc.ez;
import dc.fz;
import dc.wy;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.codec.language.bm.Rule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;

/* compiled from: LogInterceptor.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/component/dxhttp/interceptor/logger/LogInterceptor;", "Lokhttp3/Interceptor;", "()V", "mPrinter", "Lcom/component/dxhttp/utils/FormatPrinter;", "printLevel", "Lcom/component/dxhttp/interceptor/logger/LogInterceptor$Level;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "parseContent", "", "responseBody", "Lokhttp3/ResponseBody;", "encoding", "clone", "Lokio/Buffer;", "printResult", DeliveryReceiptRequest.ELEMENT, "Lokhttp3/Request;", SaslStreamElements.Response.ELEMENT, "logResponse", "", "Companion", "Level", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class yy implements sc4 {

    @NotNull
    public static final a c = new a(null);

    @NotNull
    public final cz a = new xy();

    @NotNull
    public final b b = b.ALL;

    /* compiled from: LogInterceptor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/component/dxhttp/interceptor/logger/LogInterceptor$Companion;", "", "()V", "convertCharset", "", ContentTypeField.PARAM_CHARSET, "Ljava/nio/charset/Charset;", "isForm", "", "mediaType", "Lokhttp3/MediaType;", "isHtml", "isJson", "isParseable", "isPlain", "isText", "isXml", "parseParams", DeliveryReceiptRequest.ELEMENT, "Lokhttp3/Request;", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(@Nullable Charset charset) {
            String strValueOf = String.valueOf(charset);
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) strValueOf, "[", 0, false, 6, (Object) null);
            if (iIndexOf$default == -1) {
                return strValueOf;
            }
            String strSubstring = strValueOf.substring(iIndexOf$default + 1, strValueOf.length() - 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final boolean b(@Nullable tc4 tc4Var) {
            if ((tc4Var == null ? null : tc4Var.e()) == null) {
                return false;
            }
            String strE = tc4Var.e();
            Intrinsics.checkNotNullExpressionValue(strE, "mediaType.subtype()");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = strE.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "x-www-form-urlencoded", false, 2, (Object) null);
        }

        public final boolean c(@Nullable tc4 tc4Var) {
            if ((tc4Var == null ? null : tc4Var.e()) == null) {
                return false;
            }
            String strE = tc4Var.e();
            Intrinsics.checkNotNullExpressionValue(strE, "mediaType.subtype()");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = strE.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) XHTMLExtension.ELEMENT, false, 2, (Object) null);
        }

        @JvmStatic
        public final boolean d(@Nullable tc4 tc4Var) {
            if ((tc4Var == null ? null : tc4Var.e()) == null) {
                return false;
            }
            String strE = tc4Var.e();
            Intrinsics.checkNotNullExpressionValue(strE, "mediaType.subtype()");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = strE.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "json", false, 2, (Object) null);
        }

        public final boolean e(@Nullable tc4 tc4Var) {
            if ((tc4Var == null ? null : tc4Var.f()) == null) {
                return false;
            }
            return g(tc4Var) || f(tc4Var) || d(tc4Var) || b(tc4Var) || c(tc4Var) || h(tc4Var);
        }

        public final boolean f(@Nullable tc4 tc4Var) {
            if ((tc4Var == null ? null : tc4Var.e()) == null) {
                return false;
            }
            String strE = tc4Var.e();
            Intrinsics.checkNotNullExpressionValue(strE, "mediaType.subtype()");
            String lowerCase = strE.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            return StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "plain", false, 2, (Object) null);
        }

        public final boolean g(@Nullable tc4 tc4Var) {
            if ((tc4Var == null ? null : tc4Var.f()) == null) {
                return false;
            }
            return Intrinsics.areEqual("text", tc4Var.f());
        }

        @JvmStatic
        public final boolean h(@Nullable tc4 tc4Var) {
            if ((tc4Var == null ? null : tc4Var.e()) == null) {
                return false;
            }
            String strE = tc4Var.e();
            Intrinsics.checkNotNullExpressionValue(strE, "mediaType.subtype()");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = strE.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            return StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "xml", false, 2, (Object) null);
        }

        @NotNull
        public final String i(@NotNull yc4 request) throws UnsupportedEncodingException {
            Intrinsics.checkNotNullParameter(request, "request");
            try {
                zc4 zc4VarA = request.h().b().a();
                if (zc4VarA == null) {
                    return "";
                }
                nd4 nd4Var = new nd4();
                zc4VarA.writeTo(nd4Var);
                Charset charsetForName = Charset.forName("UTF-8");
                tc4 tc4VarContentType = zc4VarA.contentType();
                if (tc4VarContentType != null) {
                    charsetForName = tc4VarContentType.b(charsetForName);
                }
                String strQ = nd4Var.Q(charsetForName);
                ez.a aVar = ez.a;
                Intrinsics.checkNotNull(strQ);
                if (aVar.a(strQ)) {
                    strQ = URLDecoder.decode(strQ, a(charsetForName));
                }
                wy.b bVar = wy.a;
                Intrinsics.checkNotNull(strQ);
                return bVar.a(strQ);
            } catch (IOException e) {
                e.printStackTrace();
                return "{\"error\": \"" + ((Object) e.getMessage()) + "\"}";
            }
        }
    }

    /* compiled from: LogInterceptor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/component/dxhttp/interceptor/logger/LogInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", BleService.EXTRA_REQUEST, "RESPONSE", Rule.ALL, "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum b {
        NONE,
        REQUEST,
        RESPONSE,
        ALL
    }

    public final String a(bd4 bd4Var, String str, nd4 nd4Var) {
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNull(bd4Var);
        tc4 tc4VarContentType = bd4Var.contentType();
        if (tc4VarContentType != null) {
            charsetForName = tc4VarContentType.b(charsetForName);
        }
        if (StringsKt__StringsJVMKt.equals("gzip", str, true)) {
            fz.a aVar = fz.a;
            byte[] bArrM = nd4Var.M();
            Intrinsics.checkNotNullExpressionValue(bArrM, "clone.readByteArray()");
            return aVar.b(bArrM, c.a(charsetForName));
        }
        if (!StringsKt__StringsJVMKt.equals("zlib", str, true)) {
            return nd4Var.Q(charsetForName);
        }
        fz.a aVar2 = fz.a;
        byte[] bArrM2 = nd4Var.M();
        Intrinsics.checkNotNullExpressionValue(bArrM2, "clone.readByteArray()");
        return aVar2.d(bArrM2, c.a(charsetForName));
    }

    public final String b(yc4 yc4Var, ad4 ad4Var, boolean z) throws IOException {
        try {
            bd4 bd4VarB = ad4Var.A().c().b();
            Intrinsics.checkNotNull(bd4VarB);
            pd4 pd4VarSource = bd4VarB.source();
            pd4VarSource.request(Long.MAX_VALUE);
            nd4 nd4VarA = pd4VarSource.a();
            String strC = ad4Var.q().c(HttpHeaders.CONTENT_ENCODING);
            nd4 nd4VarClone = nd4VarA.clone();
            Intrinsics.checkNotNullExpressionValue(nd4VarClone, "buffer.clone()");
            return a(bd4VarB, strC, nd4VarClone);
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"error\": \"" + ((Object) e.getMessage()) + "\"}";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    @Override // dc.sc4
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public dc.ad4 intercept(@org.jetbrains.annotations.NotNull dc.sc4.a r30) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.yy.intercept(dc.sc4$a):dc.ad4");
    }
}
