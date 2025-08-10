package io.agora.metachat;

import android.view.TextureView;
import io.agora.base.internal.CalledByNative;
import java.util.Arrays;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class EnterSceneConfig {
    public String mRoomName = "";
    public TextureView mSceneView = null;
    public long mSceneId = 0;
    public byte[] mExtraCustomInfo = null;

    @CalledByNative
    public byte[] getExtraCustomInfo() {
        return this.mExtraCustomInfo;
    }

    @CalledByNative
    public String getRoomName() {
        return this.mRoomName;
    }

    @CalledByNative
    public long getSceneId() {
        return this.mSceneId;
    }

    @CalledByNative
    public TextureView getSceneView() {
        return this.mSceneView;
    }

    public String toString() {
        return "EnterSceneConfig{mRoomName='" + this.mRoomName + "', mSceneView=" + this.mSceneView + ", mSceneId=" + this.mSceneId + ", mExtraCustomInfo=" + Arrays.toString(this.mExtraCustomInfo) + MessageFormatter.DELIM_STOP;
    }
}
