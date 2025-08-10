package com.wear.bean.event;

import android.app.Activity;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.RemoteControlActivity;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.alarm.AlarmSoundPlayActivity;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.protocol.MessageType;
import com.wear.ui.home.sound.SoundPlayActivity;
import dc.ah4;
import dc.ch3;

/* loaded from: classes3.dex */
public class MusicPlayEvent {
    public boolean ControlisPause;
    public boolean isControlChat;
    public boolean isControlLinkChat;
    public boolean isGroupControlChat;
    public boolean isGroupDSChat;
    public boolean isPlayAudio;
    public boolean isPlayPatternOnHomePattern;
    public boolean isRouletteControl;
    public boolean playPatternPause;

    public String getTip(Activity activity) {
        Account accountU;
        if (activity instanceof SoundPlayActivity) {
            return ah4.e(R.string.cancel_sound_control_and_play_music);
        }
        if (activity instanceof CreatePatternActivity) {
            return ah4.e(R.string.cancel_create_pattem_and_play_music);
        }
        if (activity instanceof PatternPlayActivity) {
            return ah4.e(R.string.cancel_pattem_control_and_play_music);
        }
        if (activity instanceof AlarmSoundPlayActivity) {
            return ah4.e(R.string.cancel_sound_control_and_play_music);
        }
        if ((activity instanceof RemoteControlActivity) || (activity instanceof RemoteMultiControlActivity)) {
            return ah4.e(R.string.cancel_remote_control_and_play_music);
        }
        if (this.ControlisPause) {
            return ah4.e(R.string.cancel_control_and_play_music);
        }
        if (this.isPlayAudio) {
            return ah4.e(R.string.cancel_sound_control_and_play_music);
        }
        if (this.isGroupControlChat) {
            return ah4.e(R.string.cancel_syn_control_and_play_music);
        }
        if (this.isGroupDSChat) {
            return ah4.e(R.string.cancel_syn_control_and_play_music);
        }
        if (this.isControlLinkChat) {
            return ah4.e(R.string.control_link_conflict_toast);
        }
        if (!this.isControlChat || (accountU = ch3.n().u()) == null || accountU.getLiveStatus() == 0) {
            return this.isRouletteControl ? ah4.e(R.string.roulette_conflict_toast) : ah4.e(R.string.cancel_control_and_play_music);
        }
        MessageType messageType = accountU.currentControlType;
        return messageType == MessageType.live ? ah4.e(R.string.cancel_live_control_and_play_music) : messageType == MessageType.sync ? ah4.e(R.string.cancel_syn_control_and_play_music) : messageType == MessageType.video ? ah4.e(R.string.cancel_video_control_and_play_music) : ah4.e(R.string.cancel_voice_control_and_play_music);
    }

    public boolean isPatternPause() {
        return this.playPatternPause || this.isPlayPatternOnHomePattern;
    }

    public boolean isPause() {
        return this.ControlisPause || this.isControlChat || this.isPlayAudio || this.isGroupControlChat || this.isGroupDSChat || this.isRouletteControl;
    }
}
