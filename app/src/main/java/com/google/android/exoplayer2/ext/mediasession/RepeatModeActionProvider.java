package com.google.android.exoplayer2.ext.mediasession;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector;
import com.google.android.exoplayer2.util.RepeatModeUtil;

/* loaded from: classes2.dex */
public final class RepeatModeActionProvider implements MediaSessionConnector.CustomActionProvider {
    private static final String ACTION_REPEAT_MODE = "ACTION_EXO_REPEAT_MODE";
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 3;
    private final CharSequence repeatAllDescription;
    private final CharSequence repeatOffDescription;
    private final CharSequence repeatOneDescription;
    private final int repeatToggleModes;

    public RepeatModeActionProvider(Context context) {
        this(context, 3);
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.CustomActionProvider
    public PlaybackStateCompat.CustomAction getCustomAction(Player player) {
        CharSequence charSequence;
        int i;
        int repeatMode = player.getRepeatMode();
        if (repeatMode == 1) {
            charSequence = this.repeatOneDescription;
            i = R.drawable.exo_media_action_repeat_one;
        } else if (repeatMode != 2) {
            charSequence = this.repeatOffDescription;
            i = R.drawable.exo_media_action_repeat_off;
        } else {
            charSequence = this.repeatAllDescription;
            i = R.drawable.exo_media_action_repeat_all;
        }
        return new PlaybackStateCompat.CustomAction.Builder(ACTION_REPEAT_MODE, charSequence, i).build();
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.CustomActionProvider
    public void onCustomAction(Player player, String str, @Nullable Bundle bundle) {
        int repeatMode = player.getRepeatMode();
        int nextRepeatMode = RepeatModeUtil.getNextRepeatMode(repeatMode, this.repeatToggleModes);
        if (repeatMode != nextRepeatMode) {
            player.setRepeatMode(nextRepeatMode);
        }
    }

    public RepeatModeActionProvider(Context context, int i) {
        this.repeatToggleModes = i;
        this.repeatAllDescription = context.getString(R.string.exo_media_action_repeat_all_description);
        this.repeatOneDescription = context.getString(R.string.exo_media_action_repeat_one_description);
        this.repeatOffDescription = context.getString(R.string.exo_media_action_repeat_off_description);
    }
}
