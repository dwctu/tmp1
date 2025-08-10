package dc;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CharacterHandler.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxhttp/interceptor/logger/CharacterHandler;", "", "()V", "Companion", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class wy {

    @NotNull
    public static final b a = new b(null);

    /* compiled from: CharacterHandler.kt */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0016R\"\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"com/component/dxhttp/interceptor/logger/CharacterHandler$Companion$EMOJI_FILTER$1", "Landroid/text/InputFilter;", "emoji", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getEmoji", "()Ljava/util/regex/Pattern;", "setEmoji", "(Ljava/util/regex/Pattern;)V", "filter", "", "source", TtmlNode.START, "", TtmlNode.END, "dest", "Landroid/text/Spanned;", "dstart", "dend", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements InputFilter {
        public Pattern a = Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66);

        @Override // android.text.InputFilter
        @Nullable
        public CharSequence filter(@NotNull CharSequence source, int start, int end, @NotNull Spanned dest, int dstart, int dend) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            if (this.a.matcher(source).find()) {
                return "";
            }
            return null;
        }
    }

    /* compiled from: CharacterHandler.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/component/dxhttp/interceptor/logger/CharacterHandler$Companion;", "", "()V", "EMOJI_FILTER", "Landroid/text/InputFilter;", "getEMOJI_FILTER", "()Landroid/text/InputFilter;", "jsonFormat", "", "json", "xmlFormat", "xml", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String a(@NotNull String json) throws JSONException {
            String string;
            Intrinsics.checkNotNullParameter(json, "json");
            if (TextUtils.isEmpty(json)) {
                return "Empty/Null json content";
            }
            try {
                int length = json.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) json.charAt(!z ? i : length), 32) <= 0;
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
                String string2 = json.subSequence(i, length + 1).toString();
                if (StringsKt__StringsJVMKt.startsWith$default(string2, "{", false, 2, null)) {
                    string = new JSONObject(string2).toString(4);
                    Intrinsics.checkNotNullExpressionValue(string, "{\n                    va…ring(4)\n                }");
                } else {
                    if (!StringsKt__StringsJVMKt.startsWith$default(string2, "[", false, 2, null)) {
                        return string2;
                    }
                    string = new JSONArray(string2).toString(4);
                    Intrinsics.checkNotNullExpressionValue(string, "{\n                    va…ring(4)\n                }");
                }
                return string;
            } catch (OutOfMemoryError unused) {
                return "Output omitted because of Object size";
            } catch (JSONException unused2) {
                return json;
            }
        }

        @JvmStatic
        @Nullable
        public final String b(@Nullable String str) throws TransformerException, IllegalArgumentException {
            if (TextUtils.isEmpty(str)) {
                return "Empty/Null xml content";
            }
            try {
                StreamSource streamSource = new StreamSource(new StringReader(str));
                StreamResult streamResult = new StreamResult(new StringWriter());
                Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
                transformerNewTransformer.setOutputProperty("indent", "yes");
                transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformerNewTransformer.transform(streamSource, streamResult);
                return new Regex(SimpleComparison.GREATER_THAN_OPERATION).replaceFirst(streamResult.getWriter().toString(), ">\n");
            } catch (TransformerException unused) {
                return str;
            }
        }
    }

    static {
        new a();
    }
}
