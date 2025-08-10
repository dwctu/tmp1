package com.wear.ui.longDistance.imagepicker.ui;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.BaseAdapter;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.ui.longDistance.video.adapter.ImagePreViewBtmAdapter;
import com.wear.ui.longDistance.video.adapter.VideoRecyclerViewAdapter;
import com.wear.ui.longDistance.video.component.CompleteViewImagePicker;
import com.wear.ui.longDistance.video.component.VodControlViewImagePicker;
import com.wear.ui.longDistance.video.player.MyVideoView;
import dc.fa3;
import dc.g93;
import dc.ga3;
import dc.ia3;
import dc.k93;
import dc.n93;
import dc.zj4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import xyz.doikki.videocontroller.StandardVideoController;
import xyz.doikki.videocontroller.component.TitleView;
import xyz.doikki.videoplayer.player.BaseVideoView;

/* loaded from: classes4.dex */
public class ImagePreViewActivity extends BaseActivity implements fa3, ga3 {
    public LinearLayoutManager a;
    public LinearLayoutManager b;
    public VideoRecyclerViewAdapter c;
    public ImagePreViewBtmAdapter d;
    public MyVideoView e;
    public StandardVideoController f;
    public CompleteViewImagePicker g;
    public TitleView h;
    public int j;
    public ImagePreViewActivity k;
    public TextView n;
    public LinearLayout o;
    public ImageView p;
    public RecyclerView q;
    public RecyclerView s;
    public PagerSnapHelper t;
    public PagerSnapHelper u;
    public LinearLayout v;
    public RelativeLayout w;
    public VodControlViewImagePicker x;
    public int i = -1;
    public List<MediaFile> l = new ArrayList();
    public int m = 0;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePreViewActivity.this.setResult(-1, new Intent());
            ImagePreViewActivity.this.finish();
        }
    }

    public class b implements BaseAdapter.b<MediaFile> {
        public b() {
        }

        @Override // com.wear.adapter.BaseAdapter.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void a0(MediaFile mediaFile, int i, View view) {
            n93.b().c(i);
            ImagePreViewActivity.this.m = i;
            ImagePreViewActivity imagePreViewActivity = ImagePreViewActivity.this;
            imagePreViewActivity.P4(((MediaFile) imagePreViewActivity.l.get(i)).f());
            ImagePreViewActivity.this.d.notifyDataSetChanged();
            ImagePreViewActivity.this.s.scrollToPosition(i);
        }
    }

    public class c implements RecyclerView.OnChildAttachStateChangeListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(@NonNull View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(@NonNull View view) throws IOException {
            MyVideoView myVideoView;
            View childAt = ((FrameLayout) view.findViewById(R.id.player_container)).getChildAt(0);
            if (childAt == null || childAt != (myVideoView = ImagePreViewActivity.this.e) || myVideoView.c()) {
                return;
            }
            ImagePreViewActivity.this.L4();
        }
    }

    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i != 0 || recyclerView == null || recyclerView.getChildCount() <= 0) {
                return;
            }
            try {
                ImagePreViewActivity imagePreViewActivity = ImagePreViewActivity.this;
                imagePreViewActivity.m = ((RecyclerView.LayoutParams) imagePreViewActivity.t.findSnapView(recyclerView.getLayoutManager()).getLayoutParams()).getViewAdapterPosition();
                ImagePreViewActivity imagePreViewActivity2 = ImagePreViewActivity.this;
                imagePreViewActivity2.P4(((MediaFile) imagePreViewActivity2.l.get(ImagePreViewActivity.this.m)).f());
                ImagePreViewActivity.this.M4(1);
                n93.b().c(ImagePreViewActivity.this.m);
                ImagePreViewActivity.this.d.notifyDataSetChanged();
                ImagePreViewActivity.this.q.scrollToPosition(ImagePreViewActivity.this.m);
            } catch (Exception unused) {
            }
        }
    }

    public class e extends BaseVideoView.b {
        public e() {
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.a
        public void a(int i) {
            if (i == 0) {
                ia3.a(ImagePreViewActivity.this.e);
                ImagePreViewActivity imagePreViewActivity = ImagePreViewActivity.this;
                imagePreViewActivity.j = imagePreViewActivity.i;
                imagePreViewActivity.i = -1;
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePreViewActivity.this.M4(0);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePreViewActivity.this.M4(0);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePreViewActivity.this.M4(0);
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePreViewActivity.this.finish();
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g93.c().b(((MediaFile) ImagePreViewActivity.this.l.get(ImagePreViewActivity.this.m)).f(), (MediaFile) ImagePreViewActivity.this.l.get(ImagePreViewActivity.this.m))) {
                ImagePreViewActivity imagePreViewActivity = ImagePreViewActivity.this;
                imagePreViewActivity.P4(((MediaFile) imagePreViewActivity.l.get(ImagePreViewActivity.this.m)).f());
                ImagePreViewActivity.this.O4();
                ImagePreViewActivity imagePreViewActivity2 = ImagePreViewActivity.this;
                imagePreViewActivity2.d.notifyItemChanged(imagePreViewActivity2.m);
            }
        }
    }

    public void C4() {
        List<MediaFile> listC = k93.a().c();
        if (listC == null || listC.size() == 0) {
            return;
        }
        this.c.n(listC);
        int intExtra = getIntent().getIntExtra("imagePosition", 0);
        this.m = intExtra;
        this.s.scrollToPosition(intExtra);
        this.q.scrollToPosition(this.m);
        n93.b().c(this.m);
        if (this.m < 0) {
            this.m = 0;
        }
        P4(this.l.get(this.m).f());
        O4();
    }

    public void D4() {
        findViewById(R.id.iv_actionBar_back).setOnClickListener(new i());
        this.o.setOnClickListener(new j());
        this.n.setOnClickListener(new a());
    }

    public final void E4() throws IllegalStateException {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.k);
        this.a = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.q.setLayoutManager(this.a);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.u = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this.q);
        ImagePreViewBtmAdapter imagePreViewBtmAdapter = new ImagePreViewBtmAdapter(this.l, R.layout.item_preview);
        this.d = imagePreViewBtmAdapter;
        imagePreViewBtmAdapter.s(new b());
        this.q.setItemViewCacheSize(9);
        this.q.setAdapter(this.d);
    }

    public final void F4() throws IllegalStateException {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.k);
        this.b = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.s.setLayoutManager(this.b);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.t = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this.s);
        VideoRecyclerViewAdapter videoRecyclerViewAdapter = new VideoRecyclerViewAdapter(this.l);
        this.c = videoRecyclerViewAdapter;
        videoRecyclerViewAdapter.q(this);
        this.c.r(this);
        this.s.setAdapter(this.c);
        this.s.addOnChildAttachStateChangeListener(new c());
        this.s.addOnScrollListener(new d());
    }

    public void G4() {
        MyVideoView myVideoView = new MyVideoView(this.k);
        this.e = myVideoView;
        myVideoView.setOnStateChangeListener(new e());
        this.f = new StandardVideoController(this.k);
        CompleteViewImagePicker completeViewImagePicker = new CompleteViewImagePicker(this.k);
        this.g = completeViewImagePicker;
        this.f.l(completeViewImagePicker);
        this.g.setOnClickListener(new f());
        VodControlViewImagePicker vodControlViewImagePicker = new VodControlViewImagePicker(this);
        this.x = vodControlViewImagePicker;
        vodControlViewImagePicker.k(false);
        this.x.setOnClickListener(new g());
        this.f.l(this.x);
        TitleView titleView = new TitleView(this.k);
        this.h = titleView;
        this.f.l(titleView);
        this.f.setEnableOrientation(false);
        this.f.setDoubleTapTogglePlayEnabled(false);
        this.e.setVideoController(this.f);
        this.f.setOnClickListener(new h());
    }

    public void H4() throws IllegalStateException {
        this.n = (TextView) findViewById(R.id.ac_preview_tv_send);
        this.o = (LinearLayout) findViewById(R.id.ll_pre_select);
        this.p = (ImageView) findViewById(R.id.iv_item_check);
        this.q = (RecyclerView) findViewById(R.id.rv_preview);
        this.s = (RecyclerView) findViewById(R.id.rv_preview_full);
        this.w = (RelativeLayout) findViewById(R.id.layout_actionBar);
        this.v = (LinearLayout) findViewById(R.id.rl_main_bottom);
        G4();
        F4();
        E4();
    }

    public final boolean I4(MediaFile mediaFile) {
        return mediaFile.b() > 0;
    }

    public final void J4(Uri uri) {
        this.e.setUrl(uri.toString());
    }

    public final void K4(String str) {
        this.e.setUrl("file://" + str);
    }

    public final void L4() throws IOException {
        this.e.u();
        if (this.e.c()) {
            this.e.f();
        }
        if (this.k.getRequestedOrientation() != 1) {
            this.k.setRequestedOrientation(1);
        }
        this.i = -1;
    }

    public final void M4(int i2) {
        if (i2 != 0) {
            this.q.setVisibility(i2 == 1 ? 0 : 4);
            this.v.setVisibility(i2 == 1 ? 0 : 4);
            this.w.setVisibility(i2 == 1 ? 0 : 4);
        } else {
            RecyclerView recyclerView = this.q;
            recyclerView.setVisibility(recyclerView.getVisibility() == 0 ? 4 : 0);
            LinearLayout linearLayout = this.v;
            linearLayout.setVisibility(linearLayout.getVisibility() == 0 ? 4 : 0);
            RelativeLayout relativeLayout = this.w;
            relativeLayout.setVisibility(relativeLayout.getVisibility() != 0 ? 0 : 4);
        }
    }

    public void N4(int i2) throws IOException {
        int i3 = this.i;
        if (i3 == i2) {
            return;
        }
        if (i3 != -1) {
            L4();
        }
        MediaFile mediaFile = this.l.get(i2);
        if (Build.VERSION.SDK_INT >= 29) {
            J4(ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, mediaFile.e()));
        } else {
            K4(mediaFile.f());
        }
        View viewFindViewByPosition = this.b.findViewByPosition(i2);
        if (viewFindViewByPosition == null) {
            return;
        }
        VideoRecyclerViewAdapter.VideoHolder videoHolder = (VideoRecyclerViewAdapter.VideoHolder) viewFindViewByPosition.getTag();
        this.f.j(videoHolder.d, true);
        ia3.a(this.e);
        videoHolder.b.addView(this.e, 0);
        zj4.d().a(this.e, "list");
        this.e.start();
        this.i = i2;
    }

    public final void O4() {
        int iD = g93.c().d();
        int size = g93.c().e().size();
        if (size == 0) {
            this.n.setAlpha(0.5f);
            this.n.setEnabled(false);
            this.n.setText(getString(R.string.confirm));
        } else if (size < iD) {
            this.n.setAlpha(1.0f);
            this.n.setEnabled(true);
            this.n.setText(String.format(getString(R.string.confirm_msg2), Integer.valueOf(size)));
        } else if (size == iD) {
            this.n.setAlpha(1.0f);
            this.n.setEnabled(true);
            this.n.setText(String.format(getString(R.string.confirm_msg2), Integer.valueOf(size)));
        }
    }

    public final void P4(String str) {
        if (g93.c().i(str)) {
            this.p.setImageDrawable(getResources().getDrawable(R.drawable.icon_image_checked));
        } else {
            this.p.setImageDrawable(getResources().getDrawable(R.drawable.picture_choose_cancel));
        }
        O4();
    }

    @Override // dc.ga3
    public void a(int i2) {
        M4(0);
    }

    @Override // dc.fa3
    public void m1(View view, int i2) throws IOException {
        if (I4(this.l.get(i2))) {
            switch (view.getId()) {
                case R.id.player_container /* 2131364118 */:
                case R.id.prepare_view /* 2131364134 */:
                case R.id.start_play /* 2131364623 */:
                case R.id.thumb /* 2131364742 */:
                    N4(i2);
                    break;
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalStateException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_preview_image);
        ButterKnife.bind(this);
        this.k = this;
        H4();
        D4();
        C4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws IOException {
        super.onDestroy();
        n93.b().c(0);
        MyVideoView myVideoView = this.e;
        if (myVideoView != null) {
            myVideoView.u();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MyVideoView myVideoView = this.e;
        if (myVideoView != null) {
            myVideoView.pause();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MyVideoView myVideoView = this.e;
        if (myVideoView != null) {
            myVideoView.w();
        }
    }
}
