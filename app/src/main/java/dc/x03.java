package dc;

import android.content.Context;
import androidx.multidex.MultiDexExtractor;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wear.bean.data.VoiceModelData;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.vc4;
import dc.yc4;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ModelStorageService.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002%&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0004H\u0007J\u0006\u0010\u001d\u001a\u00020\u0006J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/ModelStorageService;", "", "()V", "downloadStatus", "Lcom/wear/ui/discover/voicecontrol/ModelStorageService$DownloadStatus;", "errorProgress", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/wear/ui/discover/voicecontrol/ModelStorageService$DownloadModelListener;", "voiceModelData", "Lcom/wear/bean/data/VoiceModelData;", "getVoiceModelData", "()Lcom/wear/bean/data/VoiceModelData;", "setVoiceModelData", "(Lcom/wear/bean/data/VoiceModelData;)V", "downloadModel", "", "context", "Landroid/content/Context;", ImagesContract.URL, "", "modelName", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadPattern", "outputFile", "Ljava/io/File;", "(Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadStatus", "getErrorProgress", "haveStorageModel", "", "onError", "errorMessage", "registerDownloadListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unRegisterDownloadListener", "DownloadModelListener", "DownloadStatus", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class x03 {

    @Nullable
    public static VoiceModelData c;
    public static int d;

    @NotNull
    public static final x03 a = new x03();

    @NotNull
    public static final CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList<>();

    @NotNull
    public static volatile b e = b.NORMAL;

    /* compiled from: ModelStorageService.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/ModelStorageService$DownloadModelListener;", "", "onComplete", "", "onError", "message", "", "onProgress", "progress", "", "onStart", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(int i);

        void onComplete();

        void onError(@Nullable String message);

        void onStart();
    }

    /* compiled from: ModelStorageService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/ModelStorageService$DownloadStatus;", "", "(Ljava/lang/String;I)V", "NORMAL", "START", "PROGRESS", "ERROR", "COMPLETE", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum b {
        NORMAL,
        START,
        PROGRESS,
        ERROR,
        COMPLETE
    }

    /* compiled from: ModelStorageService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.ModelStorageService$downloadModel$2", f = "ModelStorageService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $modelName;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Context context, String str2, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$context = context;
            this.$modelName = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(this.$url, this.$context, this.$modelName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Exception {
            String voiceResourceId;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Iterator it = x03.b.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onStart();
            }
            x03 x03Var = x03.a;
            x03.e = b.START;
            vc4 vc4VarB = new vc4.b().b();
            yc4.a aVar = new yc4.a();
            aVar.d();
            aVar.k(this.$url);
            ad4 ad4VarExecute = vc4VarB.a(aVar.b()).execute();
            if (ad4VarExecute.isSuccessful()) {
                File externalFilesDir = this.$context.getExternalFilesDir("wear/model");
                File file = new File(externalFilesDir, this.$modelName + MultiDexExtractor.EXTRACTED_SUFFIX);
                if (!file.exists()) {
                    file.createNewFile();
                }
                bd4 bd4VarB = ad4VarExecute.b();
                InputStream inputStreamByteStream = bd4VarB != null ? bd4VarB.byteStream() : null;
                bd4 bd4VarB2 = ad4VarExecute.b();
                long jContentLength = bd4VarB2 != null ? bd4VarB2.contentLength() : 1L;
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                if (inputStreamByteStream != null) {
                    String str = this.$modelName;
                    byte[] bArr = new byte[2048];
                    float f = 0.0f;
                    x03.e = b.PROGRESS;
                    while (true) {
                        int i = inputStreamByteStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, i);
                        f += i;
                        float f2 = (f / jContentLength) * 100;
                        x03 x03Var2 = x03.a;
                        x03.d = MathKt__MathJVMKt.roundToInt(f2);
                        Iterator it2 = x03.b.iterator();
                        while (it2.hasNext()) {
                            ((a) it2.next()).a(MathKt__MathJVMKt.roundToInt(f2));
                        }
                    }
                    bufferedOutputStream.close();
                    hh3.b(file, externalFilesDir, true);
                    File file2 = new File(externalFilesDir, str + "/uuid");
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
                    bufferedWriter.write(UUID.randomUUID().toString());
                    bufferedWriter.close();
                    Iterator it3 = x03.b.iterator();
                    while (it3.hasNext()) {
                        ((a) it3.next()).onComplete();
                    }
                    MyApplication myApplication = WearUtils.x;
                    VoiceModelData voiceModelDataH = x03.a.h();
                    if (voiceModelDataH == null || (voiceResourceId = voiceModelDataH.getVoiceResourceId()) == null) {
                        voiceResourceId = "1";
                    }
                    eg3.i(myApplication, "modelVersion", voiceResourceId);
                    x03.e = b.COMPLETE;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ModelStorageService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.ModelStorageService$downloadPattern$2", f = "ModelStorageService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ File $outputFile;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, File file, Continuation<? super d> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$outputFile = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.$url, this.$outputFile, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws IOException {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            vc4 vc4VarB = new vc4.b().b();
            yc4.a aVar = new yc4.a();
            aVar.d();
            aVar.k(this.$url);
            ad4 ad4VarExecute = vc4VarB.a(aVar.b()).execute();
            if (ad4VarExecute.isSuccessful()) {
                bd4 bd4VarB = ad4VarExecute.b();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bd4VarB != null ? bd4VarB.byteStream() : null));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.$outputFile));
                String line = bufferedReader.readLine();
                while (line != null) {
                    bufferedWriter.write(line);
                    line = bufferedReader.readLine();
                    bufferedWriter.newLine();
                }
                bufferedReader.close();
                bufferedWriter.close();
            }
            return Unit.INSTANCE;
        }
    }

    @JvmStatic
    @NotNull
    public static final b f() {
        return e;
    }

    @Nullable
    public final Object d(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation) throws IOException {
        Object objG = sy3.g(n04.b(), new c(str, context, str2, null), continuation);
        return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
    }

    @Nullable
    public final Object e(@NotNull String str, @NotNull File file, @NotNull Continuation<? super Unit> continuation) throws IOException {
        Object objG = sy3.g(n04.b(), new d(str, file, null), continuation);
        return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
    }

    public final int g() {
        return d;
    }

    @Nullable
    public final VoiceModelData h() {
        return c;
    }

    public final boolean i(@NotNull Context context, @NotNull String modelName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        File file = new File(context.getExternalFilesDir("wear/model"), modelName);
        return file.exists() && file.length() > 0;
    }

    public final void j(@NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        e = b.ERROR;
        Iterator<T> it = b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onError(errorMessage);
        }
    }

    public final void k(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        b.add(listener);
    }

    public final void l(@Nullable VoiceModelData voiceModelData) {
        c = voiceModelData;
    }

    public final void m(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        b.remove(listener);
    }
}
