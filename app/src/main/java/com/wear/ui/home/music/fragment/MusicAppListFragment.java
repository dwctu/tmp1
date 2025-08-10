package com.wear.ui.home.music.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.backgroundservice.service.MediaControllerService;
import com.wear.bean.HomeMusicBean;
import com.wear.bean.Music;
import com.wear.bean.MusicAPPBean;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.MusicPlaylistItems;
import com.wear.bean.SongInformation;
import com.wear.main.BaseFragment;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.home.music.NewMusicActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.SelectPlayerDialog;
import dc.ah4;
import dc.eg3;
import dc.h43;
import dc.j43;
import dc.k12;
import dc.q61;
import dc.rd3;
import dc.u51;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class MusicAppListFragment extends BaseFragment implements View.OnClickListener, j43, h43 {
    public Unbinder k;
    public NewMusicActivity m;

    @BindView(R.id.iv_has_permission1)
    public ImageView mIvHasPermission1;

    @BindView(R.id.iv_has_permission2)
    public ImageView mIvHasPermission2;

    @BindView(R.id.iv_music_image)
    public ImageView mIvMusicImage;

    @BindView(R.id.ll_app_name)
    public LinearLayout mLlAppName;

    @BindView(R.id.ll_applogo_vibrate)
    public LinearLayout mLlApplogoVibrate;

    @BindView(R.id.ll_music_appname_1)
    public LinearLayout mLlMusicAppName1;

    @BindView(R.id.ll_app_name_more)
    public LinearLayout mLlMusicAppNameMore;

    @BindView(R.id.ll_start_page)
    public LinearLayout mLlStartPage;

    @BindView(R.id.nestedscrollview_music)
    public NestedScrollView mNestedScrollviewMusic;

    @BindView(R.id.tv_already_opened)
    public TextView mTvAlreadyOpened;

    @BindView(R.id.tv_music_how)
    public TextView mTvMusicHow;

    @BindView(R.id.tv_music_name)
    public TextView mTvMusicName;

    @BindView(R.id.tv_music_souc)
    public TextView mTvMusicSouc;

    @BindView(R.id.tv_set_up_now)
    public TextView mTvSetUpNow;

    @BindView(R.id.tv_step_one)
    public TextView mTvStepOne;

    @BindView(R.id.tv_step_three)
    public TextView mTvStepThree;

    @BindView(R.id.tv_step_two)
    public TextView mTvStepTwo;

    @BindView(R.id.music_applogo_1)
    public ImageView musicApplogo1;

    @BindView(R.id.music_applogo_vibrate)
    public ImageView musicApplogoVibrate;

    @BindView(R.id.music_appname_1)
    public TextView musicAppname1;

    @BindView(R.id.music_appname_more)
    public TextView musicAppnameMrore;
    public String l = "com.wear.backgroundservice.service.MusicCaptureService";
    public List<MusicAPPBean> n = new ArrayList();
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public boolean r = true;
    public MusicPlaylist s = new MusicPlaylist();
    public Handler t = new Handler(Looper.getMainLooper());
    public MusicAPPBean u = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            rd3.f().t(MusicAppListFragment.this.u.getPackageName());
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MusicAppListFragment.this.i0();
        }
    }

    public class c implements u51 {
        public c() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            MusicAppListFragment.this.m.G4(0);
            if (z && MusicAppListFragment.this.r) {
                MusicAppListFragment.this.c0();
            }
            MusicAppListFragment.this.r = z;
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                MusicAppListFragment.this.s.getItemsList().size();
            }
        }
    }

    public class d implements SelectPlayerDialog.d {
        public d() {
        }

        @Override // com.wear.widget.SelectPlayerDialog.d
        public void a(MusicAPPBean musicAPPBean) {
            MusicAppListFragment.this.u = musicAPPBean;
            MusicAppListFragment.this.mTvMusicName.setText(String.format(ah4.e(R.string.des_vibrating_music_app), MusicAppListFragment.this.u.getLabel()));
            MusicAppListFragment musicAppListFragment = MusicAppListFragment.this;
            musicAppListFragment.musicAppname1.setText(musicAppListFragment.u.getLabel());
            if (MusicAppListFragment.this.u.getImageLogo() != null) {
                MusicAppListFragment musicAppListFragment2 = MusicAppListFragment.this;
                musicAppListFragment2.musicApplogoVibrate.setImageDrawable(musicAppListFragment2.u.getImageLogo());
                MusicAppListFragment musicAppListFragment3 = MusicAppListFragment.this;
                musicAppListFragment3.musicApplogo1.setImageDrawable(musicAppListFragment3.u.getImageLogo());
            } else if (MusicAppListFragment.this.u.getIconLogo().intValue() > 0) {
                MusicAppListFragment musicAppListFragment4 = MusicAppListFragment.this;
                musicAppListFragment4.musicApplogoVibrate.setImageDrawable(musicAppListFragment4.m.getDrawable(MusicAppListFragment.this.u.getIconLogo().intValue()));
                MusicAppListFragment musicAppListFragment5 = MusicAppListFragment.this;
                musicAppListFragment5.musicApplogo1.setImageDrawable(musicAppListFragment5.m.getDrawable(MusicAppListFragment.this.u.getIconLogo().intValue()));
            }
            eg3.i(MusicAppListFragment.this.getContext(), rd3.n, new Gson().toJson(MusicAppListFragment.this.u));
        }
    }

    @Override // dc.j43
    public void b(SongInformation songInformation) {
        MusicPlaylistItems musicPlaylistItems = new MusicPlaylistItems();
        musicPlaylistItems.setMusic(songInformation);
        ArrayList arrayList = new ArrayList();
        arrayList.add(musicPlaylistItems);
        this.s.setItemsList(arrayList);
        k12.m.e();
        Music music = this.s.getMusics().get(0);
        if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() == 2) {
            if (!TextUtils.isEmpty(music.getTitle()) && music.getDuration() != -1 && rd3.f().o()) {
                MusicControl.h0().N0(music);
            }
            EventBus.getDefault().post(new HomeMusicBean(13));
            j0();
        } else if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() != 2 && !MusicControl.h0().d.h()) {
            MusicControl.h0().N0(music);
            EventBus.getDefault().post(new HomeMusicBean(13));
            j0();
        }
        if (rd3.f().n()) {
            rd3.f().z(true);
            k12.m.s(false);
        } else {
            rd3.f().z(false);
            k12.m.s(true);
        }
        MusicAPPBean musicAPPBean = this.u;
        if (musicAPPBean != null && musicAPPBean.getImageLogo() != null) {
            this.musicApplogoVibrate.setImageDrawable(this.u.getImageLogo());
            this.musicApplogo1.setImageDrawable(this.u.getImageLogo());
        } else if (this.u.getIconLogo().intValue() > 0) {
            this.musicApplogoVibrate.setImageDrawable(this.m.getDrawable(this.u.getIconLogo().intValue()));
            this.musicApplogo1.setImageDrawable(this.m.getDrawable(this.u.getIconLogo().intValue()));
        }
        this.mTvMusicName.setText(String.format(ah4.e(R.string.des_vibrating_music_app), this.u.getLabel()));
    }

    public final void c0() {
        if (this.m == null) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.m.getPackageName(), null));
        startActivity(intent);
    }

    public void d0() {
        this.mLlApplogoVibrate.setVisibility(8);
        this.mTvMusicSouc.setVisibility(8);
        this.mLlAppName.setVisibility(0);
        this.mTvMusicHow.setVisibility(0);
        this.mTvStepOne.setVisibility(0);
        this.mTvStepTwo.setVisibility(0);
        this.mTvStepThree.setVisibility(0);
    }

    public final Boolean e0() {
        return Boolean.valueOf(q61.f(this.m, "android.permission.RECORD_AUDIO"));
    }

    public final void f0() {
        q61 q61VarN = q61.n(this);
        q61VarN.h("android.permission.RECORD_AUDIO");
        q61VarN.j(new c());
    }

    public void g0() {
        if (TextUtils.isEmpty(eg3.h(getContext(), rd3.n, ""))) {
            this.u = rd3.f().h();
        } else {
            MusicAPPBean musicAPPBean = (MusicAPPBean) new Gson().fromJson(eg3.h(getContext(), rd3.n, ""), MusicAPPBean.class);
            this.u = musicAPPBean;
            if (!musicAPPBean.getIsSupport().booleanValue()) {
                this.u = rd3.f().h();
            }
            for (MusicAPPBean musicAPPBean2 : this.n) {
                if (TextUtils.equals(musicAPPBean2.getPackageName(), this.u.getPackageName())) {
                    this.u.setImageLogo(musicAPPBean2.getImageLogo());
                }
            }
        }
        MusicAPPBean musicAPPBean3 = this.u;
        if (musicAPPBean3 == null || WearUtils.e1(musicAPPBean3.getPackageName())) {
            this.mLlMusicAppName1.setVisibility(8);
        } else {
            this.mLlMusicAppName1.setVisibility(0);
        }
        if (this.o) {
            this.mLlAppName.setVisibility(8);
            this.mLlAppName.setTag("1");
        } else {
            String str = (String) this.mLlAppName.getTag();
            if ((str == null || !TextUtils.equals("1", str)) && this.mLlAppName.getVisibility() != 0) {
                this.mLlAppName.setVisibility(0);
            }
        }
        MusicAPPBean musicAPPBean4 = this.u;
        if (musicAPPBean4 == null) {
            this.mLlMusicAppName1.setVisibility(8);
            return;
        }
        this.musicAppname1.setText(musicAPPBean4.getLabel());
        if (this.u.getImageLogo() != null) {
            this.musicApplogo1.setImageDrawable(this.u.getImageLogo());
            this.musicApplogoVibrate.setImageDrawable(this.u.getImageLogo());
        } else if (this.u.getIconLogo().intValue() > 0) {
            this.musicApplogo1.setImageDrawable(this.m.getDrawable(this.u.getIconLogo().intValue()));
            this.musicApplogoVibrate.setImageDrawable(this.m.getDrawable(this.u.getIconLogo().intValue()));
        }
    }

    public void h0(int i) {
    }

    public void i0() {
        MusicAPPBean musicAPPBean = this.u;
        SelectPlayerDialog selectPlayerDialog = new SelectPlayerDialog(getActivity(), musicAPPBean != null ? musicAPPBean.getPackageName() : "");
        selectPlayerDialog.e(new d());
        selectPlayerDialog.show();
    }

    public synchronized void j0() {
        if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 2) {
            this.m.findViewById(R.id.music_control_bar).setVisibility(8);
        } else {
            NewMusicActivity newMusicActivity = this.m;
            if (newMusicActivity != null) {
                newMusicActivity.findViewById(R.id.music_control_bar).setVisibility(0);
            }
            k12.m.e();
            MusicControl.h0().G0();
            MusicControl.h0().F0();
        }
    }

    public void k0() {
        if (rd3.f().e()) {
            if ((MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 2) && !MusicControl.h0().d.h()) {
                k12.m.e();
                if (rd3.f().i() == null || rd3.f().i() == null) {
                    return;
                }
                MusicPlaylistItems musicPlaylistItems = new MusicPlaylistItems();
                musicPlaylistItems.setMusic(rd3.f().i());
                ArrayList arrayList = new ArrayList();
                arrayList.add(musicPlaylistItems);
                this.s.setItemsList(arrayList);
                MusicControl.h0().N0(((MusicPlaylistItems) arrayList.get(0)).getMusic());
                rd3.f().B(true);
                rd3.f().z(true);
                k12.m.s(false);
                EventBus.getDefault().post(new HomeMusicBean(13));
                j0();
                EventBus.getDefault().post(2);
            }
        }
    }

    public final void l0() {
        this.m.startActivityForResult(((MediaProjectionManager) this.m.getSystemService("media_projection")).createScreenCaptureIntent(), 13);
    }

    public void m0() {
        if (!this.o) {
            this.mLlApplogoVibrate.setVisibility(8);
            this.mLlAppName.setVisibility(0);
            this.mTvMusicSouc.setVisibility(8);
            this.mTvMusicHow.setVisibility(0);
            this.mTvStepOne.setVisibility(0);
            this.mTvStepTwo.setVisibility(0);
            this.mTvStepThree.setVisibility(0);
            return;
        }
        this.mLlApplogoVibrate.setVisibility(0);
        this.mLlAppName.setVisibility(8);
        this.mTvMusicSouc.setVisibility(0);
        this.mTvAlreadyOpened.setVisibility(8);
        this.mTvMusicHow.setVisibility(8);
        this.mTvStepOne.setVisibility(8);
        this.mTvStepTwo.setVisibility(8);
        this.mTvStepThree.setVisibility(8);
    }

    public void n0() {
        this.m.startService(new Intent(getActivity(), (Class<?>) MediaControllerService.class));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_already_opened) {
            if (rd3.f().v(this.l, this.m)) {
                return;
            }
            n0();
            l0();
            this.mTvAlreadyOpened.setVisibility(8);
            return;
        }
        if (id != R.id.tv_set_up_now) {
            return;
        }
        if (!this.p) {
            rd3.s(getActivity());
        }
        if (this.q) {
            return;
        }
        f0();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.m = (NewMusicActivity) getActivity();
        M((MyApplication) getActivity().getApplication());
        View viewInflate = layoutInflater.inflate(R.layout.fragment_music_applist, (ViewGroup) null);
        this.k = ButterKnife.bind(this, viewInflate);
        if (rd3.f().g().size() > 0) {
            this.n.addAll(rd3.f().g());
        }
        g0();
        this.mLlMusicAppName1.setOnClickListener(new a());
        this.mLlMusicAppNameMore.setOnClickListener(new b());
        this.mTvSetUpNow.setOnClickListener(this);
        this.mTvAlreadyOpened.setOnClickListener(this);
        d0();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void onResume() {
        super.onResume();
        if (rd3.m(getActivity())) {
            this.p = true;
            this.mIvHasPermission1.setVisibility(0);
        } else {
            this.p = false;
            this.mIvHasPermission1.setVisibility(8);
        }
        if (this.p && e0().booleanValue()) {
            this.mLlStartPage.setVisibility(8);
            this.mNestedScrollviewMusic.setVisibility(0);
        } else {
            this.mLlStartPage.setVisibility(0);
            this.mNestedScrollviewMusic.setVisibility(8);
        }
        if (rd3.f().p(this.m)) {
            this.mTvAlreadyOpened.setVisibility(8);
        } else {
            this.mTvAlreadyOpened.setVisibility(0);
        }
        rd3.f().A(this);
        rd3.f().x(this);
        if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() == 2 && rd3.f().n()) {
            rd3.f().z(true);
        }
        if (!rd3.f().c(this.u.getPackageName())) {
            this.u = null;
            g0();
            return;
        }
        MusicAPPBean musicAPPBean = this.u;
        if (musicAPPBean == null) {
            return;
        }
        if (musicAPPBean.getImageLogo() != null) {
            this.musicApplogoVibrate.setImageDrawable(this.u.getImageLogo());
            this.musicApplogo1.setImageDrawable(this.u.getImageLogo());
        } else if (this.u.getIconLogo().intValue() > 0) {
            this.musicApplogoVibrate.setImageDrawable(this.m.getDrawable(this.u.getIconLogo().intValue()));
            this.musicApplogo1.setImageDrawable(this.m.getDrawable(this.u.getIconLogo().intValue()));
        }
        this.mTvMusicName.setText(String.format(ah4.e(R.string.des_vibrating_music_app), this.u.getLabel()));
    }

    @Override // dc.h43
    public void p(boolean z) {
        this.o = z;
        this.t.post(new Runnable() { // from class: dc.n43
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m0();
            }
        });
    }
}
