package com.wear.bean.data;

import android.support.v4.media.MediaMetadataCompat;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: AudioBookListBean.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"from", "Landroid/support/v4/media/MediaMetadataCompat$Builder;", "audioBookList", "Lcom/wear/bean/data/AudioBookList;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioBookListBeanKt {
    @NotNull
    public static final MediaMetadataCompat.Builder from(@NotNull MediaMetadataCompat.Builder builder, @NotNull AudioBookList audioBookList) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(audioBookList, "audioBookList");
        long millis = TimeUnit.SECONDS.toMillis(audioBookList.getDuration() != null ? r1.intValue() : 0L);
        String id = audioBookList.getId();
        Intrinsics.checkNotNullExpressionValue(id, "audioBookList.id");
        builder.putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, id);
        builder.putString(MediaMetadataCompat.METADATA_KEY_TITLE, audioBookList.getTitle());
        builder.putLong(MediaMetadataCompat.METADATA_KEY_DURATION, millis);
        builder.putString(MediaMetadataCompat.METADATA_KEY_ALBUM, audioBookList.getTagNameListDB());
        builder.putString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI, audioBookList.getAudioUrl());
        builder.putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI, audioBookList.getCoverUrl());
        builder.putLong("com.example.android.uamp.media.METADATA_KEY_UAMP_FLAGS", 2);
        builder.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_DESCRIPTION, audioBookList.getIntro());
        builder.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, audioBookList.getCoverUrl());
        builder.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, audioBookList.getTitle());
        return builder;
    }
}
