package dc;

import android.media.MediaRecorder;
import com.google.firebase.messaging.Constants;
import com.sun.jna.Callback;
import com.wear.bean.chat.VoiceFilesBean;
import com.wear.util.WearUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioRecordActionIml.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0019\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/wear/ui/chat/action/AudioRecordActionIml;", "Lcom/wear/ui/chat/action/AudioRecordAction;", "()V", "audioUtil", "Lcom/wear/widget/chatMic/AudioUtil;", "currentVoiceDuration", "", "recordAudioName", "", "startTimeMills", "", "cancelRecord", "", "getMediaRecorder", "Landroid/media/MediaRecorder;", "isPlaying", "", "startPlay", "file", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startRecord", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "stopPlay", "stopRecord", "Lcom/wear/bean/chat/VoiceFilesBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class jr2 implements ir2 {

    @Nullable
    public String a;

    @NotNull
    public final so3 b = new so3();
    public long c;
    public int d;

    /* compiled from: AudioRecordActionIml.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/ui/chat/action/AudioRecordActionIml$startPlay$2$1", "Lcom/wear/util/MyListener;", Callback.METHOD_NAME, "", "result", "", "message", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends ff3 {
        public final /* synthetic */ yy3<Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(yy3<? super Unit> yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.ff3
        public void b(boolean z, @Nullable Object obj) {
            if (this.a.isActive()) {
                yy3<Unit> yy3Var = this.a;
                Result.Companion companion = Result.INSTANCE;
                yy3Var.resumeWith(Result.m86constructorimpl(Unit.INSTANCE));
            }
        }
    }

    @Override // dc.ir2
    public void O() throws IllegalStateException {
        this.b.H();
        String str = this.a;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = this.a;
        Intrinsics.checkNotNull(str2);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // dc.ir2
    @Nullable
    public MediaRecorder P() {
        return this.b.o();
    }

    @Override // dc.ir2
    @Nullable
    public Object Q(@NotNull File file, @NotNull Continuation<? super Unit> continuation) {
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        this.b.D(file.getAbsolutePath(), new a(zy3Var));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objX : Unit.INSTANCE;
    }

    @Override // dc.ir2
    public void R() {
        this.b.F();
    }

    @Override // dc.ir2
    @Nullable
    public VoiceFilesBean S() throws IllegalStateException {
        this.b.H();
        this.d = ((int) (System.currentTimeMillis() - this.c)) / 1000;
        String str = this.a;
        if (str == null || str.length() == 0) {
            return null;
        }
        String str2 = this.a;
        Intrinsics.checkNotNull(str2);
        File file = new File(str2);
        if (file.exists()) {
            return new VoiceFilesBean(file, this.d);
        }
        return null;
    }

    @Override // dc.ir2
    public boolean T(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        StringBuilder sb = new StringBuilder();
        sb.append(WearUtils.T("mic").getAbsolutePath());
        sb.append(File.separator);
        sb.append(WearUtils.B(messageId + ".acc"));
        this.a = sb.toString();
        this.c = System.currentTimeMillis();
        return this.b.w(this.a);
    }

    @Override // dc.ir2
    public boolean isPlaying() {
        return this.b.s();
    }
}
