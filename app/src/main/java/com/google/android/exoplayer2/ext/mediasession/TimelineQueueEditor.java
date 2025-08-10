package com.google.android.exoplayer2.ext.mediasession;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

/* loaded from: classes2.dex */
public final class TimelineQueueEditor implements MediaSessionConnector.QueueEditor, MediaSessionConnector.CommandReceiver {
    public static final String COMMAND_MOVE_QUEUE_ITEM = "exo_move_window";
    public static final String EXTRA_FROM_INDEX = "from_index";
    public static final String EXTRA_TO_INDEX = "to_index";
    private final MediaDescriptionEqualityChecker equalityChecker;
    private final MediaControllerCompat mediaController;
    private final MediaDescriptionConverter mediaDescriptionConverter;
    private final QueueDataAdapter queueDataAdapter;

    public interface MediaDescriptionConverter {
        @Nullable
        MediaItem convert(MediaDescriptionCompat mediaDescriptionCompat);
    }

    public interface MediaDescriptionEqualityChecker {
        boolean equals(MediaDescriptionCompat mediaDescriptionCompat, MediaDescriptionCompat mediaDescriptionCompat2);
    }

    public static final class MediaIdEqualityChecker implements MediaDescriptionEqualityChecker {
        @Override // com.google.android.exoplayer2.ext.mediasession.TimelineQueueEditor.MediaDescriptionEqualityChecker
        public boolean equals(MediaDescriptionCompat mediaDescriptionCompat, MediaDescriptionCompat mediaDescriptionCompat2) {
            return Util.areEqual(mediaDescriptionCompat.getMediaId(), mediaDescriptionCompat2.getMediaId());
        }
    }

    public interface QueueDataAdapter {
        void add(int i, MediaDescriptionCompat mediaDescriptionCompat);

        void move(int i, int i2);

        void remove(int i);
    }

    public TimelineQueueEditor(MediaControllerCompat mediaControllerCompat, QueueDataAdapter queueDataAdapter, MediaDescriptionConverter mediaDescriptionConverter) {
        this(mediaControllerCompat, queueDataAdapter, mediaDescriptionConverter, new MediaIdEqualityChecker());
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueEditor
    public void onAddQueueItem(Player player, MediaDescriptionCompat mediaDescriptionCompat) {
        onAddQueueItem(player, mediaDescriptionCompat, player.getCurrentTimeline().getWindowCount());
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.CommandReceiver
    public boolean onCommand(Player player, String str, @Nullable Bundle bundle, @Nullable ResultReceiver resultReceiver) {
        if (!COMMAND_MOVE_QUEUE_ITEM.equals(str) || bundle == null) {
            return false;
        }
        int i = bundle.getInt(EXTRA_FROM_INDEX, -1);
        int i2 = bundle.getInt(EXTRA_TO_INDEX, -1);
        if (i == -1 || i2 == -1) {
            return true;
        }
        this.queueDataAdapter.move(i, i2);
        player.moveMediaItem(i, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueEditor
    public void onRemoveQueueItem(Player player, MediaDescriptionCompat mediaDescriptionCompat) {
        List<MediaSessionCompat.QueueItem> queue = this.mediaController.getQueue();
        for (int i = 0; i < queue.size(); i++) {
            if (this.equalityChecker.equals(queue.get(i).getDescription(), mediaDescriptionCompat)) {
                this.queueDataAdapter.remove(i);
                player.removeMediaItem(i);
                return;
            }
        }
    }

    public TimelineQueueEditor(MediaControllerCompat mediaControllerCompat, QueueDataAdapter queueDataAdapter, MediaDescriptionConverter mediaDescriptionConverter, MediaDescriptionEqualityChecker mediaDescriptionEqualityChecker) {
        this.mediaController = mediaControllerCompat;
        this.queueDataAdapter = queueDataAdapter;
        this.mediaDescriptionConverter = mediaDescriptionConverter;
        this.equalityChecker = mediaDescriptionEqualityChecker;
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueEditor
    public void onAddQueueItem(Player player, MediaDescriptionCompat mediaDescriptionCompat, int i) {
        MediaItem mediaItemConvert = this.mediaDescriptionConverter.convert(mediaDescriptionCompat);
        if (mediaItemConvert != null) {
            this.queueDataAdapter.add(i, mediaDescriptionCompat);
            player.addMediaItem(i, mediaItemConvert);
        }
    }
}
