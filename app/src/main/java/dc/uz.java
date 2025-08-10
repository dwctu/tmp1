package dc;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.wear.widget.control.FingImageLayout;
import java.nio.charset.Charset;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Map;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: DXAESBaseUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bE\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000 T2\u00020\u0001:\u0001TB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010\u0004R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0006R\u001b\u0010\u0015\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0016\u0010\u0006R\u001b\u0010\u0018\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0006R\u001b\u0010\u001b\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001c\u0010\u0006R\u001b\u0010\u001e\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\b\u001a\u0004\b\u001f\u0010\u0006R\u001b\u0010!\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\b\u001a\u0004\b\"\u0010\u0006R\u001b\u0010$\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b%\u0010\u0006R\u001b\u0010'\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\b\u001a\u0004\b(\u0010\u0006R\u001b\u0010*\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\b\u001a\u0004\b+\u0010\u0006R\u001b\u0010-\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b.\u0010\u0006R\u001b\u00100\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\b\u001a\u0004\b1\u0010\u0006R\u001b\u00103\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\b\u001a\u0004\b4\u0010\u0006R\u001a\u00106\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u00109R\u001b\u0010=\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\b\u001a\u0004\b>\u0010\u0006R\u001b\u0010@\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\b\u001a\u0004\bA\u0010\u0006R\u001b\u0010C\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\b\u001a\u0004\bD\u0010\u0006R\u001b\u0010F\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\b\u001a\u0004\bG\u0010\u0006R'\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040J8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\b\u001a\u0004\bK\u0010L¨\u0006U"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/dxaes/DXAESBaseUtils;", "", "()V", "CAM_IO_KEY_PUBLIC", "", "getCAM_IO_KEY_PUBLIC", "()Ljava/lang/String;", "CAM_IO_KEY_PUBLIC$delegate", "Lkotlin/Lazy;", "CAM_IO_KEY_PUBLIC_IVY", "getCAM_IO_KEY_PUBLIC_IVY", "CAM_IO_KEY_PUBLIC_IVY$delegate", "CAM_IO_KEY_TEST", "getCAM_IO_KEY_TEST", "CAM_IO_KEY_TEST$delegate", "CAM_IO_KEY_TEST_IVY", "getCAM_IO_KEY_TEST_IVY", "CAM_IO_KEY_TEST_IVY$delegate", "CHAT_TRANS_KEY", "getCHAT_TRANS_KEY", "CHAT_TRANS_KEY$delegate", "CHAT_TRANS_KEY_IVY", "getCHAT_TRANS_KEY_IVY", "CHAT_TRANS_KEY_IVY$delegate", "DATE_TRANS_KEY", "getDATE_TRANS_KEY", "DATE_TRANS_KEY$delegate", "DATE_TRANS_KEY_IVY", "getDATE_TRANS_KEY_IVY", "DATE_TRANS_KEY_IVY$delegate", "EXCEPTION_LOG_KEY", "getEXCEPTION_LOG_KEY", "EXCEPTION_LOG_KEY$delegate", "EXCEPTION_LOG_KEY_IVY", "getEXCEPTION_LOG_KEY_IVY", "EXCEPTION_LOG_KEY_IVY$delegate", "FROM_SERVER_KEY", "getFROM_SERVER_KEY", "FROM_SERVER_KEY$delegate", "FROM_SERVER_KEY_IVY", "getFROM_SERVER_KEY_IVY", "FROM_SERVER_KEY_IVY$delegate", "INSTALL_AES_KEY", "getINSTALL_AES_KEY", "INSTALL_AES_KEY$delegate", "INSTALL_AES_KEY_IVY", "getINSTALL_AES_KEY_IVY", "INSTALL_AES_KEY_IVY$delegate", "LOCAL_DATABASE_KEY", "getLOCAL_DATABASE_KEY", "LOCAL_DATABASE_KEY$delegate", "LOCAL_DATABASE_KEY_IVY", "getLOCAL_DATABASE_KEY_IVY", "LOCAL_DATABASE_KEY_IVY$delegate", "LOCAL_SAVE_KEY", "getLOCAL_SAVE_KEY", "setLOCAL_SAVE_KEY", "(Ljava/lang/String;)V", "LOCAL_SAVE_KEY_IVY", "getLOCAL_SAVE_KEY_IVY", "setLOCAL_SAVE_KEY_IVY", "NEW_LOG_KEY", "getNEW_LOG_KEY", "NEW_LOG_KEY$delegate", "NEW_LOG_KEY_IVY", "getNEW_LOG_KEY_IVY", "NEW_LOG_KEY_IVY$delegate", "TOKEN_KEY", "getTOKEN_KEY", "TOKEN_KEY$delegate", "TOKEN_KEY_IVY", "getTOKEN_KEY_IVY", "TOKEN_KEY_IVY$delegate", "keyHashMap", "", "getKeyHashMap", "()Ljava/util/Map;", "keyHashMap$delegate", "generateRandomKey", "num", "", "initAesLocalKey", "", "value", "Companion", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class uz {

    @NotNull
    public static final String A = "AES/CBC/PKCS5Padding";

    @NotNull
    public static final String B = "aes_local_key";

    @NotNull
    public static final g x = new g(null);

    @NotNull
    public static final String y = "DXAESUtil";

    @NotNull
    public static final String z = "AES";

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(v.a);

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(new t());

    @NotNull
    public final Lazy c = LazyKt__LazyJVMKt.lazy(new u());

    @NotNull
    public final Lazy d = LazyKt__LazyJVMKt.lazy(new l());

    @NotNull
    public final Lazy e = LazyKt__LazyJVMKt.lazy(new m());

    @NotNull
    public final Lazy f = LazyKt__LazyJVMKt.lazy(new e());

    @NotNull
    public final Lazy g = LazyKt__LazyJVMKt.lazy(new f());

    @NotNull
    public final Lazy h = LazyKt__LazyJVMKt.lazy(new h());

    @NotNull
    public final Lazy i = LazyKt__LazyJVMKt.lazy(new i());

    @NotNull
    public final Lazy j = LazyKt__LazyJVMKt.lazy(new j());

    @NotNull
    public final Lazy k = LazyKt__LazyJVMKt.lazy(new k());

    @NotNull
    public final Lazy l = LazyKt__LazyJVMKt.lazy(new p());

    @NotNull
    public final Lazy m = LazyKt__LazyJVMKt.lazy(new q());

    @NotNull
    public final Lazy n = LazyKt__LazyJVMKt.lazy(new r());

    @NotNull
    public final Lazy o = LazyKt__LazyJVMKt.lazy(new s());

    @NotNull
    public final Lazy p = LazyKt__LazyJVMKt.lazy(new n());

    @NotNull
    public final Lazy q = LazyKt__LazyJVMKt.lazy(new o());

    @NotNull
    public final Lazy r = LazyKt__LazyJVMKt.lazy(new c());

    @NotNull
    public final Lazy s = LazyKt__LazyJVMKt.lazy(new d());

    @NotNull
    public final Lazy t = LazyKt__LazyJVMKt.lazy(new a());

    @NotNull
    public final Lazy u = LazyKt__LazyJVMKt.lazy(new b());
    public String v;
    public String w;

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<String> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.u);
            return str == null ? yz.a.b(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<String> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.v);
            return str == null ? yz.a.c(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends Lambda implements Function0<String> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.s);
            return str == null ? yz.a.d(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class d extends Lambda implements Function0<String> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.t);
            return str == null ? yz.a.e(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class e extends Lambda implements Function0<String> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.g);
            return str == null ? yz.a.f(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class f extends Lambda implements Function0<String> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.h);
            return str == null ? yz.a.g(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J(\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J(\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0004X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0004X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/dxaes/DXAESBaseUtils$Companion;", "", "()V", "AES_LOCAL_KEY", "", "CIPHER_ALGORITHM", "getCIPHER_ALGORITHM$hytto_apps_android_components_base_dxhyttoutils", "()Ljava/lang/String;", "KEY_ALGORITHM", "getKEY_ALGORITHM$hytto_apps_android_components_base_dxhyttoutils", "TAG", "getTAG$hytto_apps_android_components_base_dxhyttoutils", "convertToKey", "Ljava/security/Key;", "keyBytes", "", "decrypt", "encryptedData", "iv", "Ljava/security/AlgorithmParameters;", "data", "key", "encrypt", "generateIV", "generateKey", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g {
        public g() {
        }

        public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Key a(@NotNull byte[] keyBytes) throws Exception {
            Intrinsics.checkNotNullParameter(keyBytes, "keyBytes");
            return new SecretKeySpec(keyBytes, i());
        }

        @JvmStatic
        @Nullable
        public final String b(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            if (!(str == null || str.length() == 0)) {
                if (!(str2 == null || str2.length() == 0)) {
                    if (!(str3 == null || str3.length() == 0)) {
                        try {
                            return qd0.c(c(Base64.decode(str, 0), g(str2), f(str3)));
                        } catch (Exception e) {
                            de0.l(j(), e.getMessage());
                        }
                    }
                }
            }
            return null;
        }

        @NotNull
        public final byte[] c(@Nullable byte[] bArr, @NotNull byte[] keyBytes, @NotNull AlgorithmParameters iv) throws Exception {
            Intrinsics.checkNotNullParameter(keyBytes, "keyBytes");
            Intrinsics.checkNotNullParameter(iv, "iv");
            Key keyA = a(keyBytes);
            Cipher cipher = Cipher.getInstance(h());
            cipher.init(2, keyA, iv);
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(encryptedData)");
            return bArrDoFinal;
        }

        @JvmStatic
        @Nullable
        public final String d(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            if (!(str == null || str.length() == 0)) {
                if (!(str2 == null || str2.length() == 0)) {
                    if (!(str3 == null || str3.length() == 0)) {
                        try {
                            Charset charset = Charsets.UTF_8;
                            byte[] bytes = str.getBytes(charset);
                            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                            byte[] bArrEncode = Base64.encode(e(bytes, g(str2), f(str3)), 2);
                            Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(encryptedData, Base64.NO_WRAP)");
                            return new String(bArrEncode, charset);
                        } catch (Exception e) {
                            de0.l(j(), e.getMessage());
                        }
                    }
                }
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final byte[] e(@NotNull byte[] data, @NotNull byte[] keyBytes, @Nullable AlgorithmParameters algorithmParameters) throws Exception {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(keyBytes, "keyBytes");
            Key keyA = a(keyBytes);
            Security.addProvider(vz.C.U());
            Cipher cipher = Cipher.getInstance(h());
            cipher.init(1, keyA, algorithmParameters);
            byte[] bArrDoFinal = cipher.doFinal(data);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(data)");
            return bArrDoFinal;
        }

        @NotNull
        public final AlgorithmParameters f(@NotNull String iv) throws Exception {
            Intrinsics.checkNotNullParameter(iv, "iv");
            Charset charsetForName = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
            byte[] bytes = iv.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            AlgorithmParameters params = AlgorithmParameters.getInstance(i());
            params.init(new IvParameterSpec(bytes));
            Intrinsics.checkNotNullExpressionValue(params, "params");
            return params;
        }

        @JvmStatic
        @NotNull
        public final byte[] g(@NotNull String key) throws Exception {
            Intrinsics.checkNotNullParameter(key, "key");
            Charset charsetForName = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
            byte[] bytes = key.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }

        @NotNull
        public final String h() {
            return uz.A;
        }

        @NotNull
        public final String i() {
            return uz.z;
        }

        @NotNull
        public final String j() {
            return uz.y;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class h extends Lambda implements Function0<String> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.i);
            return str == null ? yz.a.h(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class i extends Lambda implements Function0<String> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.j);
            return str == null ? yz.a.i(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class j extends Lambda implements Function0<String> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.k);
            return str == null ? yz.a.j(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class k extends Lambda implements Function0<String> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.l);
            return str == null ? yz.a.k(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class l extends Lambda implements Function0<String> {
        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.c);
            return str == null ? yz.a.l(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class m extends Lambda implements Function0<String> {
        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.d);
            return str == null ? yz.a.m(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class n extends Lambda implements Function0<String> {
        public n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.q);
            return str == null ? yz.a.n(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class o extends Lambda implements Function0<String> {
        public o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.r);
            return str == null ? yz.a.o(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class p extends Lambda implements Function0<String> {
        public p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.m);
            return str == null ? yz.a.p(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class q extends Lambda implements Function0<String> {
        public q() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.n);
            return str == null ? yz.a.q(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class r extends Lambda implements Function0<String> {
        public r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.o);
            return str == null ? yz.a.s(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class s extends Lambda implements Function0<String> {
        public s() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.p);
            return str == null ? yz.a.t(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class t extends Lambda implements Function0<String> {
        public t() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.a);
            return str == null ? yz.a.w(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class u extends Lambda implements Function0<String> {
        public u() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String str = uz.this.o().get(hz.b);
            return str == null ? yz.a.x(xz.a) : str;
        }
    }

    /* compiled from: DXAESBaseUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class v extends Lambda implements Function0<Map<String, String>> {
        public static final v a = new v();

        public v() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Map<String, String> invoke() {
            return yz.a.r(xz.a);
        }
    }

    @JvmStatic
    @Nullable
    public static final String d(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return x.b(str, str2, str3);
    }

    @JvmStatic
    @Nullable
    public static final String e(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return x.d(str, str2, str3);
    }

    public final String f(int i2) {
        String[] strArr = {"0", "1", "2", ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "a", "b", "c", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "e", "f", "g", XHTMLText.H, "i", "j", "k", "l", "m", GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, "o", "p", XHTMLText.Q, StreamManagement.AckRequest.ELEMENT, "s", "t", "u", PSOProgramService.VS_Key, "w", "x", FingImageLayout.ObjectAnimatorY, "z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int i3 = 0;
        while (i3 < i2) {
            i3++;
            sb.append(strArr[random.nextInt(62)]);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "result.toString()");
        return string;
    }

    @NotNull
    public final String g() {
        return (String) this.f.getValue();
    }

    @NotNull
    public final String h() {
        return (String) this.g.getValue();
    }

    @NotNull
    public final String i() {
        return (String) this.h.getValue();
    }

    @NotNull
    public final String j() {
        return (String) this.i.getValue();
    }

    @NotNull
    public final String k() {
        return (String) this.j.getValue();
    }

    @NotNull
    public final String l() {
        return (String) this.k.getValue();
    }

    @NotNull
    public final String m() {
        return (String) this.d.getValue();
    }

    @NotNull
    public final String n() {
        return (String) this.e.getValue();
    }

    @NotNull
    public final Map<String, String> o() {
        return (Map) this.a.getValue();
    }

    @NotNull
    public final String p() {
        return (String) this.l.getValue();
    }

    @NotNull
    public final String q() {
        return (String) this.m.getValue();
    }

    @NotNull
    public final String r() {
        String str = this.v;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("LOCAL_SAVE_KEY");
        return null;
    }

    @NotNull
    public final String s() {
        String str = this.w;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("LOCAL_SAVE_KEY_IVY");
        return null;
    }

    @NotNull
    public final String t() {
        return (String) this.n.getValue();
    }

    @NotNull
    public final String u() {
        return (String) this.o.getValue();
    }

    @NotNull
    public final String v() {
        return (String) this.b.getValue();
    }

    @NotNull
    public final String w() {
        return (String) this.c.getValue();
    }

    public final void x(@Nullable String str) {
        if (!(str == null || str.length() == 0)) {
            me0.j(B, str);
        }
        String str2 = B;
        String strF = me0.f(str2, "");
        if (fe0.a(strF)) {
            strF = f(50);
            me0.j(str2, strF);
        }
        String md = td0.b(Intrinsics.stringPlus(strF, "LVW"));
        Intrinsics.checkNotNullExpressionValue(md, "md");
        String strSubstring = md.substring(0, 16);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        y(strSubstring);
        String strSubstring2 = md.substring(14, 30);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        z(strSubstring2);
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.v = str;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.w = str;
    }
}
