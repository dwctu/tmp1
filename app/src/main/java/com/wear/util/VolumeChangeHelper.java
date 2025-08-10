package com.wear.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import io.agora.rtc2.internal.VolumeChangeReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VliumeChangeHelper.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\b\u0018\u00010\u000bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/wear/util/VolumeChangeHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "audioManager", "Landroid/media/AudioManager;", "getContext", "()Landroid/content/Context;", "setContext", "mVolumeBroadCastReceiver", "Lcom/wear/util/VolumeChangeHelper$VolumeBroadCastReceiver;", "mVolumeChangeListener", "Lcom/wear/util/VolumeChangeHelper$VolumeChangeListener;", "registerVolumeChangeListener", "", "volumeChangeListener", "unregisterReceiver", "Companion", "VolumeBroadCastReceiver", "VolumeChangeListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class VolumeChangeHelper {

    @NotNull
    public Context a;

    @Nullable
    public VolumeBroadCastReceiver b;

    @Nullable
    public a c;

    @Nullable
    public AudioManager d;

    /* compiled from: VliumeChangeHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/wear/util/VolumeChangeHelper$VolumeBroadCastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/wear/util/VolumeChangeHelper;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class VolumeBroadCastReceiver extends BroadcastReceiver {
        public VolumeBroadCastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (intent != null) {
                try {
                    VolumeChangeHelper volumeChangeHelper = VolumeChangeHelper.this;
                    if (Intrinsics.areEqual(intent.getAction(), VolumeChangeReceiver.ACTION_VOLUME_CHANGED) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                        AudioManager audioManager = volumeChangeHelper.d;
                        if (audioManager != null) {
                            audioManager.getStreamVolume(3);
                        }
                        a aVar = volumeChangeHelper.c;
                        if (aVar != null) {
                            aVar.a();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: VliumeChangeHelper.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wear/util/VolumeChangeHelper$VolumeChangeListener;", "", "onVolumechange", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();
    }

    public VolumeChangeHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        Object systemService = context.getSystemService("audio");
        this.d = systemService instanceof AudioManager ? (AudioManager) systemService : null;
    }

    public final void c(@NotNull a volumeChangeListener) {
        Intrinsics.checkNotNullParameter(volumeChangeListener, "volumeChangeListener");
        this.c = volumeChangeListener;
        this.b = new VolumeBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VolumeChangeReceiver.ACTION_VOLUME_CHANGED);
        VolumeBroadCastReceiver volumeBroadCastReceiver = this.b;
        if (volumeBroadCastReceiver != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                Context context = this.a;
                Intrinsics.checkNotNull(volumeBroadCastReceiver);
                context.registerReceiver(volumeBroadCastReceiver, intentFilter, 4);
            } else {
                Context context2 = this.a;
                Intrinsics.checkNotNull(volumeBroadCastReceiver);
                context2.registerReceiver(volumeBroadCastReceiver, intentFilter);
            }
        }
    }
}
