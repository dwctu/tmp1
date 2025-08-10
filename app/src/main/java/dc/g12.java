package dc;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.wear.BaseActivity;
import com.wear.bean.Music;
import com.wear.bean.event.MusicPlayEvent;
import com.wear.main.closeRange.localMusic.CreateMusicPlaylistActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.BaseImageButton;
import com.wear.widget.RoateImageView;
import com.yydcdut.sdlv.SlideAndDragListView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: MusicControlLayout.java */
/* loaded from: classes3.dex */
public class g12 implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, MusicControl.h {
    public static boolean R;
    public LinearLayout A;
    public BaseImageButton B;
    public ImageView C;
    public ImageView D;
    public View E;
    public View F;
    public View G;
    public SlideAndDragListView K;
    public TextView L;
    public LinearLayout M;
    public ImageView N;
    public Activity O;
    public View P;
    public jk1 Q;
    public View a;
    public LinearLayout b;
    public LinearLayout c;
    public LinearLayout d;
    public ImageView e;
    public RoateImageView f;
    public TextView g;
    public TextView h;
    public RoundedImageView i;
    public TextView j;
    public TextView k;
    public SeekBar l;
    public SeekBar m;
    public SeekBar n;
    public TextView o;
    public TextView p;
    public BaseImageButton q;
    public BaseImageButton r;
    public BaseImageButton s;
    public BaseImageButton t;
    public ProgressBar u;
    public ProgressBar v;
    public BaseImageButton w;
    public RelativeLayout x;
    public LinearLayout y;
    public RelativeLayout z;

    /* compiled from: MusicControlLayout.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g12.this.b.setVisibility(8);
            g12.this.x(false);
            g12.this.c.setVisibility(0);
            g12.this.a.setVisibility(0);
            if (g12.this.c.getVisibility() == 0) {
                g12 g12Var = g12.this;
                g12Var.x.setBackgroundColor(g12Var.b().getResources().getColor(R.color.transparent));
                g12.this.F.setVisibility(8);
            } else {
                g12 g12Var2 = g12.this;
                g12Var2.x.setBackgroundColor(g12Var2.b().getResources().getColor(R.color.bg_relativelayout_000));
                g12.this.F.setVisibility(0);
            }
        }
    }

    /* compiled from: MusicControlLayout.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g12.this.c.setVisibility(8);
            g12.this.a.setVisibility(8);
            g12.this.b.setVisibility(0);
            g12.this.x(true);
            if (g12.this.c.getVisibility() == 0) {
                g12 g12Var = g12.this;
                g12Var.x.setBackgroundColor(g12Var.b().getResources().getColor(R.color.transparent));
                g12.this.F.setVisibility(8);
            } else {
                g12 g12Var2 = g12.this;
                g12Var2.x.setBackgroundColor(g12Var2.b().getResources().getColor(R.color.bg_relativelayout_000));
                g12.this.F.setVisibility(0);
            }
        }
    }

    /* compiled from: MusicControlLayout.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g12.this.b.setVisibility(8);
            g12.this.x(false);
            g12.this.c.setVisibility(0);
            g12.this.a.setVisibility(0);
            if (g12.this.c.getVisibility() == 0) {
                g12 g12Var = g12.this;
                g12Var.x.setBackgroundColor(g12Var.b().getResources().getColor(R.color.transparent));
                g12.this.F.setVisibility(8);
            } else {
                g12 g12Var2 = g12.this;
                g12Var2.x.setBackgroundColor(g12Var2.b().getResources().getColor(R.color.bg_relativelayout_000));
                g12.this.F.setVisibility(0);
            }
        }
    }

    /* compiled from: MusicControlLayout.java */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MusicControl.h0().d(g12.this.Q.getItem(i), i);
        }
    }

    /* compiled from: MusicControlLayout.java */
    public class e implements ImageLoadingListener {
        public e() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ((ImageView) view).setImageBitmap(bitmap);
            g12.this.i.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_music_cover);
            g12.this.i.setImageResource(R.drawable.content_icon_music_cover);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* compiled from: MusicControlLayout.java */
    public interface f {
        void a();
    }

    public g12(MyApplication myApplication) {
        EventBus.getDefault().register(this);
        MusicControl.h0().w0(this);
    }

    public void A() {
        MusicControl.h0().A0(!MusicControl.h0().O());
        if (!R) {
        }
    }

    public void B() {
        if (R) {
            this.c.setVisibility(0);
            this.a.setVisibility(0);
        }
    }

    public void C() {
        RelativeLayout relativeLayout = this.z;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        LinearLayout linearLayout = this.A;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        SeekBar seekBar = this.m;
        if (seekBar != null) {
            seekBar.setVisibility(8);
        }
    }

    public void D() {
        RelativeLayout relativeLayout = this.z;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        LinearLayout linearLayout = this.A;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        SeekBar seekBar = this.m;
        if (seekBar != null) {
            seekBar.setVisibility(0);
        }
    }

    public void E() {
        RoateImageView roateImageView;
        MusicControl.h0().A0(true);
        if (!R || (roateImageView = this.f) == null || this.i == null) {
            return;
        }
        roateImageView.j();
    }

    public void F() {
        R = false;
    }

    public Activity b() {
        if (this.O == null) {
            this.O = MyApplication.H();
        }
        return this.O;
    }

    public void c() {
        if (R) {
            this.E.setVisibility(8);
        }
    }

    public void d(BaseActivity baseActivity, View view, View view2, MusicControl.f fVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.O = (Activity) new WeakReference(baseActivity).get();
        this.P = (View) new WeakReference(view).get();
        this.a = (View) new WeakReference(view2).get();
        R = true;
        this.b = (LinearLayout) this.P.findViewById(R.id.music_play_layer_out);
        this.c = (LinearLayout) this.P.findViewById(R.id.music_play_layer_out_simple);
        LinearLayout linearLayout = (LinearLayout) this.P.findViewById(R.id.music_play_layer);
        this.d = linearLayout;
        linearLayout.bringToFront();
        this.e = (ImageView) this.P.findViewById(R.id.music_hide);
        this.f = (RoateImageView) this.P.findViewById(R.id.music_cover);
        this.g = (TextView) this.P.findViewById(R.id.music_title);
        this.h = (TextView) this.P.findViewById(R.id.music_artist);
        this.i = (RoundedImageView) this.P.findViewById(R.id.music_cover_1);
        this.j = (TextView) this.P.findViewById(R.id.music_title_1);
        this.k = (TextView) this.P.findViewById(R.id.music_artist_1);
        this.l = (SeekBar) this.P.findViewById(R.id.sensitivity_seek);
        this.m = (SeekBar) this.P.findViewById(R.id.music_seek_out_simple);
        this.n = (SeekBar) this.P.findViewById(R.id.music_seek);
        this.o = (TextView) this.P.findViewById(R.id.music_time);
        this.p = (TextView) this.P.findViewById(R.id.music_duration);
        this.q = (BaseImageButton) this.P.findViewById(R.id.music_prev);
        this.r = (BaseImageButton) this.P.findViewById(R.id.music_play);
        this.s = (BaseImageButton) this.P.findViewById(R.id.music_play_1);
        this.w = (BaseImageButton) this.P.findViewById(R.id.music_next);
        this.t = (BaseImageButton) this.P.findViewById(R.id.ib_play_music_model);
        this.y = (LinearLayout) this.P.findViewById(R.id.ll_music_seek);
        this.z = (RelativeLayout) this.P.findViewById(R.id.ll_universal_bg);
        this.A = (LinearLayout) this.P.findViewById(R.id.ll_app_list_bg);
        this.B = (BaseImageButton) this.P.findViewById(R.id.bib_music_pause);
        this.C = (ImageView) this.P.findViewById(R.id.iv_previous_song);
        this.D = (ImageView) this.P.findViewById(R.id.iv_next_song);
        this.L = (TextView) this.P.findViewById(R.id.tv_low_volume_prompt);
        this.u = (ProgressBar) this.P.findViewById(R.id.music_loading);
        this.v = (ProgressBar) this.P.findViewById(R.id.music_loading_1);
        this.x = (RelativeLayout) this.P.findViewById(R.id.relativelayout);
        this.F = this.P.findViewById(R.id.view_hide);
        this.u.setVisibility(4);
        this.v.setVisibility(4);
        this.L.setVisibility(8);
        this.M = (LinearLayout) this.P.findViewById(R.id.ll_sensitivity_tip);
        this.N = (ImageView) this.P.findViewById(R.id.iv_sensitivity_tip_close);
        MusicControl.h0().G(false);
        this.r.setVisibility(0);
        this.s.setVisibility(0);
        this.E = this.P.findViewById(R.id.confirm_from_layer);
        this.G = this.P.findViewById(R.id.music_create_layout_pop);
        SlideAndDragListView slideAndDragListView = (SlideAndDragListView) this.P.findViewById(R.id.music_playlist_add_list);
        this.K = slideAndDragListView;
        slideAndDragListView.setBackgroundColor(th4.b(baseActivity, R.color.tab_bg));
        this.b.setOnClickListener(new a());
        this.c.setOnClickListener(new b());
        this.e.setOnClickListener(new c());
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.l.setOnSeekBarChangeListener(this);
        this.n.setOnSeekBarChangeListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.K.setMenu(new yu3(false, 0));
        this.K.setOnItemClickListener(new d());
        this.l.setProgress(MusicControl.h0().k0());
        MusicControl.h0().x0(baseActivity, fVar);
        if (MusicControl.h0().O()) {
            k();
        }
        MusicControl.h0().I0();
        MusicControl.h0().g0(false);
    }

    public void e() {
        R = true;
    }

    @Override // com.wear.main.closeRange.music.MusicControl.h
    public void e1(i12 i12Var) {
        if (R) {
            int iB = i12Var.b();
            if (iB == 3) {
                v(i12Var.a());
            } else {
                if (iB != 4) {
                    return;
                }
                p(i12Var.a());
            }
        }
    }

    public void f() {
        MusicControl.h0().A0(true);
        if (R) {
            this.r.setVisibility(4);
            this.s.setVisibility(4);
            this.u.setVisibility(0);
            this.v.setVisibility(0);
        }
    }

    public void g() {
        if (R) {
            this.r.setVisibility(0);
            this.s.setVisibility(0);
            this.u.setVisibility(4);
            this.v.setVisibility(4);
        }
    }

    public void h() {
        if (R) {
            this.f.i();
        }
    }

    public void i(boolean z) {
        MusicControl.h0().A0(z);
    }

    public void j(BaseActivity baseActivity, View view, View view2, MusicControl.f fVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (baseActivity.getClass().getName().equals(b().getClass().getName())) {
            MusicControl.h0().I0();
        } else {
            d(baseActivity, view, view2, fVar);
        }
    }

    public void k() {
        if (R) {
            this.f.i();
        }
    }

    public void l() {
        if (R) {
            this.u.setVisibility(4);
            this.v.setVisibility(4);
        }
    }

    public void m() {
        MusicControl.h0().A0(true);
        if (R) {
            this.n.setProgress(0);
            this.m.setProgress(0);
            this.o.setText("0:00");
        }
    }

    public void n() {
        if (R) {
            this.n.setProgress(0);
            this.m.setProgress(0);
        }
    }

    public void o(BaseActivity baseActivity) {
        this.O = (Activity) new WeakReference(baseActivity).get();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (R) {
            if (view.getId() == R.id.music_create_layout_pop) {
                this.E.setVisibility(8);
                pj3.o(this.O, CreateMusicPlaylistActivity.class, 24);
                return;
            }
            if (MusicControl.h0().L()) {
                return;
            }
            switch (view.getId()) {
                case R.id.bib_music_pause /* 2131362143 */:
                case R.id.music_play /* 2131363840 */:
                case R.id.music_play_1 /* 2131363841 */:
                    MusicControl.h0().X();
                    MusicControl.h0().g0(false);
                    break;
                case R.id.confirm_from_layer /* 2131362413 */:
                    this.E.setVisibility(8);
                    MusicControl.h0().h = null;
                    break;
                case R.id.ib_play_music_model /* 2131362947 */:
                    MusicControl.h0().y0(false);
                    break;
                case R.id.iv_next_song /* 2131363220 */:
                case R.id.music_next /* 2131363839 */:
                    if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() == 2) {
                        sg3.m(R.string.notification_switch_songs);
                        break;
                    } else {
                        MusicControl.h0().W();
                        break;
                    }
                case R.id.iv_previous_song /* 2131363266 */:
                case R.id.music_prev /* 2131363857 */:
                    if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() == 2) {
                        sg3.m(R.string.notification_switch_songs);
                        break;
                    } else {
                        MusicControl.h0().Y();
                        break;
                    }
                    break;
                case R.id.iv_sensitivity_tip_close /* 2131363296 */:
                    x(false);
                    ke3.c("function_sensitivity_replaced_music");
                    break;
                case R.id.view_hide /* 2131365620 */:
                    if (this.b.getVisibility() == 0) {
                        this.b.setVisibility(8);
                        x(false);
                        this.c.setVisibility(0);
                    }
                    if (this.c.getVisibility() != 0) {
                        this.x.setBackgroundColor(b().getResources().getColor(R.color.bg_relativelayout_000));
                        this.F.setVisibility(0);
                        break;
                    } else {
                        this.x.setBackgroundColor(b().getResources().getColor(R.color.transparent));
                        this.F.setVisibility(8);
                        break;
                    }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MusicPlayEvent musicPlayEvent) {
        if (MusicControl.h0().O()) {
            if (musicPlayEvent.isPause() || musicPlayEvent.isPatternPause()) {
                MusicControl.h0().t0(false);
                cj3.f().c(true);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int id = seekBar.getId();
        if (id == R.id.music_seek) {
            this.o.setText(WearUtils.Q(i / 1000));
        } else {
            if (id != R.id.sensitivity_seek) {
                return;
            }
            MusicControl.h0().F = i;
            rd3.f().D(i);
            eg3.i(WearUtils.x, "sensitivity_seek", Integer.valueOf(i));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() != R.id.music_seek) {
            return;
        }
        MusicControl.h0().v = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) throws IllegalStateException {
        if (seekBar != null && seekBar.getId() == R.id.music_seek) {
            MusicControl.h0().v = false;
            MusicControl.h0().D0(seekBar);
        }
    }

    public void p(int i) {
        BaseImageButton baseImageButton = this.t;
        if (baseImageButton != null && R) {
            if (i == 1) {
                baseImageButton.setImageResource(R.drawable.icon_music_panel_random);
            } else if (i != 2) {
                baseImageButton.setImageResource(R.drawable.icon_music_panel_loopplay);
            } else {
                baseImageButton.setImageResource(R.drawable.icon_music_panel_singleloop);
            }
        }
    }

    public void q(int i) {
        LinearLayout linearLayout;
        if (i <= 0 || (linearLayout = this.d) == null) {
            return;
        }
        linearLayout.setBackgroundResource(i);
    }

    public void r(boolean z) {
        LinearLayout linearLayout = this.y;
        if (linearLayout != null) {
            if (z) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void s(boolean z) {
        if (R) {
            String string = this.r.getTag() != null ? this.r.getTag().toString() : "";
            String string2 = this.s.getTag() != null ? this.s.getTag().toString() : "";
            String string3 = this.B.getTag() != null ? this.B.getTag().toString() : "";
            String str = "setPlayIconStatus: " + z + "   Tag1=" + string + "   Tag2=" + string2;
            if (!WearUtils.e1(string)) {
                if (string.equals("s") && string2.equals("s") && string3.equals("s") && z) {
                    return;
                }
                if (string.equals("p") && string2.equals("p") && string3.equals("p") && !z) {
                    return;
                }
            }
            if (z) {
                this.r.setTag("s");
                this.s.setTag("s");
                this.B.setTag("s");
                this.r.setBackgroundResource(R.drawable.toolbar_icon_music_playbig);
                this.B.setBackgroundResource(R.drawable.pattern_play_play);
                this.s.setBackgroundResource(R.drawable.music_minibar_play_new);
                return;
            }
            this.r.setTag("p");
            this.s.setTag("p");
            this.B.setTag("p");
            this.r.setBackgroundResource(R.drawable.toolbar_icon_music_pausebig);
            this.B.setBackgroundResource(R.drawable.pattern_play_pause);
            this.s.setBackgroundResource(R.drawable.music_minibar_pause_new);
        }
    }

    public void t() {
        if (!R || this.r == null || this.s == null || this.B == null) {
            return;
        }
        MusicControl.h0().A0(true);
        this.f.j();
    }

    public void u() {
        if (!R || this.r == null || this.s == null || this.B == null) {
            return;
        }
        this.f.j();
    }

    public void v(int i) {
        if (R) {
            this.n.setProgress(i);
            this.m.setProgress(i);
            this.o.setText(WearUtils.Q(i / 1000));
        }
    }

    public void w() {
        if (R) {
            this.n.setProgress((int) MusicControl.h0().s);
            this.m.setProgress((int) MusicControl.h0().s);
        }
    }

    public final void x(boolean z) {
        if (z) {
            this.M.setVisibility(ke3.b("new_feature", "function_sensitivity_replaced_music", false) ? 0 : 8);
        } else {
            this.M.setVisibility(8);
        }
    }

    public void y(g12 g12Var, Music music) {
        if (R) {
            this.E.setVisibility(0);
            MusicControl.h0().h = music;
            jk1 jk1Var = new jk1(g12Var, 1);
            this.Q = jk1Var;
            this.K.setAdapter((ListAdapter) jk1Var);
            this.Q.b(MusicControl.h0().A());
            this.Q.notifyDataSetChanged();
        }
    }

    public void z() {
        if (R) {
            this.g.setText(MusicControl.h0().f.getTitle());
            this.j.setText(MusicControl.h0().f.getTitle());
            this.h.setText(MusicControl.h0().f.getArtist());
            this.k.setText(MusicControl.h0().f.getArtist());
            this.p.setText(WearUtils.Q(MusicControl.h0().f.getDuration() / 1000));
            String imageUrl = "content://media/external/audio/albumart/" + MusicControl.h0().f.getAlbumId();
            if (MusicControl.h0().f.getMusicType() == 1) {
                imageUrl = MusicControl.h0().f.getImageUrl();
            }
            if (!WearUtils.e1(imageUrl) && MusicControl.h0().f.getAlbumId() > 0) {
                ImageLoader.getInstance().displayImage(imageUrl, this.f, new e());
            } else if (MusicControl.h0().f.getBitmap() != null) {
                this.f.setImageBitmap(MusicControl.h0().f.getBitmap());
                this.i.setImageBitmap(MusicControl.h0().f.getBitmap());
            } else {
                this.f.setImageResource(R.drawable.content_icon_music_cover);
                this.i.setImageResource(R.drawable.content_icon_music_cover);
            }
            n();
            this.n.setMax(MusicControl.h0().f.getDuration());
            this.m.setMax(MusicControl.h0().f.getDuration());
            p(MusicControl.h0().i0());
        }
    }
}
