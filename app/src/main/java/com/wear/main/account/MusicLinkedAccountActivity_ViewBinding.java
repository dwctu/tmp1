package com.wear.main.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class MusicLinkedAccountActivity_ViewBinding implements Unbinder {
    public MusicLinkedAccountActivity a;

    @UiThread
    public MusicLinkedAccountActivity_ViewBinding(MusicLinkedAccountActivity musicLinkedAccountActivity, View view) {
        this.a = musicLinkedAccountActivity;
        musicLinkedAccountActivity.actionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar_account, "field 'actionBar'", MyActionBar.class);
        musicLinkedAccountActivity.musicAccountSpotifyLinked = (TextView) Utils.findRequiredViewAsType(view, R.id.music_account_spotify_linked, "field 'musicAccountSpotifyLinked'", TextView.class);
        musicLinkedAccountActivity.musicAccountSpotify = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_account_spotify, "field 'musicAccountSpotify'", LinearLayout.class);
        musicLinkedAccountActivity.musicAccountGoogleLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.music_account_google_logo, "field 'musicAccountGoogleLogo'", ImageView.class);
        musicLinkedAccountActivity.musicAccountGoogleLinked = (TextView) Utils.findRequiredViewAsType(view, R.id.music_account_google_linked, "field 'musicAccountGoogleLinked'", TextView.class);
        musicLinkedAccountActivity.musicAccountGoogle = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_account_google, "field 'musicAccountGoogle'", LinearLayout.class);
        musicLinkedAccountActivity.musicAccountPandoraLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.music_account_pandora_logo, "field 'musicAccountPandoraLogo'", ImageView.class);
        musicLinkedAccountActivity.musicAccountPandoraLinked = (TextView) Utils.findRequiredViewAsType(view, R.id.music_account_pandora_linked, "field 'musicAccountPandoraLinked'", TextView.class);
        musicLinkedAccountActivity.musicAccountPandora = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_account_pandora, "field 'musicAccountPandora'", LinearLayout.class);
        musicLinkedAccountActivity.spotifyMusicLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.spotify_music_layout, "field 'spotifyMusicLayout'", LinearLayout.class);
        musicLinkedAccountActivity.alexaAccountLinked = (TextView) Utils.findRequiredViewAsType(view, R.id.alexa_account_linked, "field 'alexaAccountLinked'", TextView.class);
        musicLinkedAccountActivity.alexaAccount = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alexa_account, "field 'alexaAccount'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicLinkedAccountActivity musicLinkedAccountActivity = this.a;
        if (musicLinkedAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        musicLinkedAccountActivity.actionBar = null;
        musicLinkedAccountActivity.musicAccountSpotifyLinked = null;
        musicLinkedAccountActivity.musicAccountSpotify = null;
        musicLinkedAccountActivity.musicAccountGoogleLogo = null;
        musicLinkedAccountActivity.musicAccountGoogleLinked = null;
        musicLinkedAccountActivity.musicAccountGoogle = null;
        musicLinkedAccountActivity.musicAccountPandoraLogo = null;
        musicLinkedAccountActivity.musicAccountPandoraLinked = null;
        musicLinkedAccountActivity.musicAccountPandora = null;
        musicLinkedAccountActivity.spotifyMusicLayout = null;
        musicLinkedAccountActivity.alexaAccountLinked = null;
        musicLinkedAccountActivity.alexaAccount = null;
    }
}
