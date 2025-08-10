package dc;

import android.media.MediaRecorder;
import com.google.firebase.messaging.Constants;
import com.wear.bean.chat.VoiceFilesBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioRecordAction.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0019\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/wear/ui/chat/action/AudioRecordAction;", "", "cancelRecord", "", "getMediaRecorder", "Landroid/media/MediaRecorder;", "isPlaying", "", "startPlay", "file", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startRecord", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "stopPlay", "stopRecord", "Lcom/wear/bean/chat/VoiceFilesBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface ir2 {
    void O();

    @Nullable
    MediaRecorder P();

    @Nullable
    Object Q(@NotNull File file, @NotNull Continuation<? super Unit> continuation);

    void R();

    @Nullable
    VoiceFilesBean S();

    boolean T(@NotNull String str);

    boolean isPlaying();
}
