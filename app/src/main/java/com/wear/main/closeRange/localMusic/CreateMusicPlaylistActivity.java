package com.wear.main.closeRange.localMusic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.MusicPlaylist;
import com.wear.dao.DaoUtils;
import com.wear.dao.MusicPlaylistDao;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.sg3;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class CreateMusicPlaylistActivity extends BaseActivity {
    public MyActionBar a;
    public EditText b;
    public ProgressDialog c;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            CreateMusicPlaylistActivity.this.t4();
        }
    }

    public class b implements TextView.OnEditorActionListener {
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            CreateMusicPlaylistActivity.this.t4();
            return false;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_music_playlist);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.a = myActionBar;
        myActionBar.setYesAction(R.string.common_done, new a());
        EditText editText = (EditText) findViewById(R.id.music_playlist_name);
        this.b = editText;
        editText.setOnEditorActionListener(new b());
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public final void t4() {
        String string = this.b.getText().toString();
        if (WearUtils.e1(string)) {
            sg3.i(this, R.string.music_create_playlist_hint);
            return;
        }
        this.c = ProgressDialog.show(this, "", ah4.e(R.string.common_loading), true, true);
        MusicPlaylist musicPlaylist = new MusicPlaylist();
        musicPlaylist.setEmail(WearUtils.y.r());
        musicPlaylist.setName(string);
        musicPlaylist.setCreateFromLocalDB(1);
        DaoUtils.getMusicPlaylistDao().add((MusicPlaylistDao) musicPlaylist);
        Intent intent = new Intent();
        intent.putExtra("new_playlist_item", musicPlaylist);
        setResult(24, intent);
        finish();
        this.c.dismiss();
    }
}
