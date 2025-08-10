package com.iceteck.silicompressorr.videocompression;

import android.annotation.SuppressLint;
import java.nio.ByteBuffer;

@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class MediaController {
    public static native int convertVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3, int i4, int i5);
}
