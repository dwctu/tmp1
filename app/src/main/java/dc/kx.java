package dc;

import androidx.exifinterface.media.ExifInterface;
import androidx.multidex.MultiDexExtractor;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.broadcom.bt.util.io.IOUtils;
import com.component.dxdlog.bean.SessionToken;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.activity.orgySetting.OrgySetting;
import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DXDLogFileUtil.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J:\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/component/dxdlog/DXDLogFileUtil;", "", "()V", "retryUploadLogCount", "", "deleteLogFile", "", "zipDir", "", "fileList", "", "Ljava/io/File;", "deleteZipFile", "zipPath", "doUploadFile", "s3Token", "Lcom/component/dxdlog/bean/SessionToken;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/dxdlog/UploadLogListener;", "getZipLogFile", "Lkotlin/Pair;", "logDir", "uploadStartDate", "Ljava/util/Date;", "uploadEndDate", "uploadFile", "Companion", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class kx {

    @NotNull
    public static final b b = new b(null);

    @NotNull
    public static final Lazy<kx> c = LazyKt__LazyJVMKt.lazy(a.a);
    public int a;

    /* compiled from: DXDLogFileUtil.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxdlog/DXDLogFileUtil;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<kx> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kx invoke() {
            return new kx();
        }
    }

    /* compiled from: DXDLogFileUtil.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/component/dxdlog/DXDLogFileUtil$Companion;", "", "()V", "MAX_LOG_FILES_SIZE", "", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/component/dxdlog/DXDLogFileUtil;", "getInstance", "()Lcom/component/dxdlog/DXDLogFileUtil;", "instance$delegate", "Lkotlin/Lazy;", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final kx a() {
            return (kx) kx.c.getValue();
        }
    }

    /* compiled from: DXDLogFileUtil.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/component/dxdlog/DXDLogFileUtil$doUploadFile$client$1", "Lcom/amazonaws/auth/AWSSessionCredentials;", "getAWSAccessKeyId", "", "getAWSSecretKey", "getSessionToken", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements AWSSessionCredentials {
        public final /* synthetic */ SessionToken a;

        public c(SessionToken sessionToken) {
            this.a = sessionToken;
        }

        @Override // com.amazonaws.auth.AWSCredentials
        @NotNull
        public String a() {
            String accessKeyId;
            SessionToken sessionToken = this.a;
            return (sessionToken == null || (accessKeyId = sessionToken.getAccessKeyId()) == null) ? "" : accessKeyId;
        }

        @Override // com.amazonaws.auth.AWSCredentials
        @NotNull
        public String b() {
            String secretAccessKey;
            SessionToken sessionToken = this.a;
            return (sessionToken == null || (secretAccessKey = sessionToken.getSecretAccessKey()) == null) ? "" : secretAccessKey;
        }

        @Override // com.amazonaws.auth.AWSSessionCredentials
        @NotNull
        public String getSessionToken() {
            String sessionToken;
            SessionToken sessionToken2 = this.a;
            return (sessionToken2 == null || (sessionToken = sessionToken2.getSessionToken()) == null) ? "" : sessionToken;
        }
    }

    /* compiled from: DXDLogFileUtil.kt */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/component/dxdlog/DXDLogFileUtil$doUploadFile$transferListener$1", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "onError", "", TtmlNode.ATTR_ID, "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "current", "", "total", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements TransferListener {
        public final /* synthetic */ AmazonS3Client a;
        public final /* synthetic */ SessionToken b;
        public final /* synthetic */ String c;
        public final /* synthetic */ nx d;

        public d(AmazonS3Client amazonS3Client, SessionToken sessionToken, String str, nx nxVar) {
            this.a = amazonS3Client;
            this.b = sessionToken;
            this.c = str;
            this.d = nxVar;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void a(int i, @NotNull TransferState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state == TransferState.COMPLETED) {
                AmazonS3Client amazonS3Client = this.a;
                SessionToken sessionToken = this.b;
                this.d.a(true, amazonS3Client.R(sessionToken != null ? sessionToken.getBucketName() : null, this.c).toString());
            } else if (state == TransferState.FAILED) {
                this.d.a(false, "上传失败");
            }
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void b(int i, long j, long j2) {
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void c(int i, @NotNull Exception ex) {
            Intrinsics.checkNotNullParameter(ex, "ex");
            ex.printStackTrace();
            de0.i(ex.getMessage());
            this.d.a(false, ex.getMessage());
        }
    }

    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((File) t2).lastModified()), Long.valueOf(((File) t).lastModified()));
        }
    }

    /* compiled from: DXDLogFileUtil.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/component/dxdlog/DXDLogFileUtil$getZipLogFile$fileList$1", "Ljava/io/FileFilter;", "accept", "", "file", "Ljava/io/File;", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f implements FileFilter {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;

        public f(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        @Override // java.io.FileFilter
        public boolean accept(@Nullable File file) {
            if (file != null) {
                long j = this.a;
                long j2 = this.b;
                long jLastModified = file.lastModified() / OrgySetting.ONE_HOURE_MSEC;
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "file.name");
                if (StringsKt__StringsJVMKt.endsWith$default(name, ".xlog", false, 2, null)) {
                    if (j <= jLastModified && jLastModified < j2 + 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: DXDLogFileUtil.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/component/dxdlog/DXDLogFileUtil$uploadFile$1", "Lcom/component/dxdlog/UploadLogListener;", "onComplete", "", "isSuccess", "", "errorMsg", "", "dxDLog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g implements nx {
        public final /* synthetic */ String b;
        public final /* synthetic */ SessionToken c;
        public final /* synthetic */ nx d;

        public g(String str, SessionToken sessionToken, nx nxVar) {
            this.b = str;
            this.c = sessionToken;
            this.d = nxVar;
        }

        @Override // dc.nx
        public void a(boolean z, @Nullable String str) {
            if (z) {
                if (z) {
                    kx.this.a = 0;
                    this.d.a(true, str);
                    return;
                }
                return;
            }
            if (kx.this.a >= 1) {
                kx.this.a = 0;
                this.d.a(false, str);
            } else {
                kx.this.a++;
                kx.this.g(this.b, this.c, this);
            }
        }
    }

    public final void e(@NotNull String zipDir, @Nullable List<? extends File> list) {
        Intrinsics.checkNotNullParameter(zipDir, "zipDir");
        vd0.g(zipDir);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!vd0.d((File) it.next())) {
                    de0.l("Delete log file fail.");
                }
            }
        }
    }

    public final void f(@NotNull String zipPath) {
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        vd0.e(zipPath);
    }

    public final void g(String str, SessionToken sessionToken, nx nxVar) {
        AmazonS3Client amazonS3Client = new AmazonS3Client(new c(sessionToken), Region.e(sessionToken != null ? sessionToken.getRegion() : null));
        File file = new File(str);
        TransferNetworkLossHandler.d(ve0.a());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.N(DfuBaseService.MIME_TYPE_ZIP);
        TransferUtility.Builder builderC = TransferUtility.c();
        builderC.c(sessionToken != null ? sessionToken.getBucketName() : null);
        builderC.b(ve0.a());
        builderC.d(amazonS3Client);
        TransferUtility transferUtilityA = builderC.a();
        StringBuilder sb = new StringBuilder();
        sb.append(sessionToken != null ? sessionToken.getObjectKeyPrefix() : null);
        sb.append("android/");
        sb.append(file.getName());
        String string = sb.toString();
        transferUtilityA.h(sessionToken != null ? sessionToken.getBucketName() : null, string, file, objectMetadata).e(new d(amazonS3Client, sessionToken, string, nxVar));
    }

    @NotNull
    public final Pair<String, List<File>> h(@NotNull String logDir, @NotNull String zipDir, @NotNull Date uploadStartDate, @NotNull Date uploadEndDate) {
        Intrinsics.checkNotNullParameter(logDir, "logDir");
        Intrinsics.checkNotNullParameter(zipDir, "zipDir");
        Intrinsics.checkNotNullParameter(uploadStartDate, "uploadStartDate");
        Intrinsics.checkNotNullParameter(uploadEndDate, "uploadEndDate");
        long time = uploadStartDate.getTime();
        long j = OrgySetting.ONE_HOURE_MSEC;
        long j2 = time / j;
        de0.i("zipLogFile startDate == " + j2);
        long time2 = uploadEndDate.getTime() / j;
        de0.i("zipLogFile endDate == " + time2);
        List<File> fileList = vd0.x(logDir, new f(j2, time2));
        if ((fileList != null ? fileList.size() : 0) == 0) {
            return new Pair<>("", null);
        }
        Intrinsics.checkNotNullExpressionValue(fileList, "fileList");
        List listSortedWith = CollectionsKt___CollectionsKt.sortedWith(fileList, new e());
        long jP = 0;
        Iterator it = listSortedWith.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i2 = i + 1;
            jP += vd0.p((File) it.next());
            if (jP > 26214400) {
                listSortedWith = listSortedWith.subList(0, i);
                break;
            }
            i = i2;
        }
        de0.i("log files size == " + jP + " K");
        String str = zipDir + IOUtils.DIR_SEPARATOR_UNIX + tz.a.c() + SignatureImpl.SEP + ue0.g() + MultiDexExtractor.EXTRACTED_SUFFIX;
        try {
            vd0.c(str);
            return ze0.b(listSortedWith, new File(str)) ? new Pair<>(str, listSortedWith) : new Pair<>("", null);
        } catch (Exception e2) {
            Object[] objArr = new Object[1];
            String message = e2.getMessage();
            if (message == null) {
                message = "zip log files fail";
            }
            objArr[0] = message;
            de0.l(objArr);
            return new Pair<>("", null);
        }
    }

    public final void i(@NotNull String zipPath, @Nullable SessionToken sessionToken, @NotNull nx listener) {
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        g(zipPath, sessionToken, new g(zipPath, sessionToken, listener));
    }
}
