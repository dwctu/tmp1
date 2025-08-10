package com.wear.main.longDistance;

import android.os.Bundle;
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
import com.wear.adapter.longdistance.SearchChatMediaPreviewAdapter;
import com.wear.adapter.longdistance.SearchChatMediaPreviewFullAdapter;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.MessageType;
import com.wear.ui.longDistance.video.component.CompleteViewImagePicker;
import com.wear.ui.longDistance.video.component.VodControlViewImagePicker;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.fa3;
import dc.ga3;
import dc.ia3;
import dc.k93;
import dc.n93;
import dc.zj4;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import xyz.doikki.videocontroller.StandardVideoController;
import xyz.doikki.videocontroller.component.TitleView;
import xyz.doikki.videoplayer.player.BaseVideoView;

/* loaded from: classes3.dex */
public class SearchChatMediaPreviewActivity extends BaseActivity implements fa3, ga3 {
    public TextView d;
    public LinearLayout e;
    public ImageView f;
    public RecyclerView g;
    public RecyclerView h;
    public LinearLayoutManager i;
    public LinearLayoutManager j;
    public SearchChatMediaPreviewFullAdapter k;
    public SearchChatMediaPreviewAdapter l;
    public MyVideoView m;
    public StandardVideoController n;
    public CompleteViewImagePicker o;
    public TitleView p;
    public int s;
    public PagerSnapHelper t;
    public PagerSnapHelper u;
    public LinearLayout v;
    public RelativeLayout w;
    public VodControlViewImagePicker x;
    public List<CommunMessage> a = new ArrayList();
    public List<CommunMessage> b = new ArrayList();
    public int c = 0;
    public int q = -1;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchChatMediaPreviewActivity.this.setResult(-1);
            k93.a().d(SearchChatMediaPreviewActivity.this.b);
            SearchChatMediaPreviewActivity.this.finish();
        }
    }

    public class b implements BaseAdapter.b<CommunMessage> {
        public b() {
        }

        @Override // com.wear.adapter.BaseAdapter.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void a0(CommunMessage communMessage, int i, View view) {
            n93.b().c(i);
            SearchChatMediaPreviewActivity.this.c = i;
            SearchChatMediaPreviewActivity.this.P4(communMessage);
            SearchChatMediaPreviewActivity.this.l.notifyDataSetChanged();
            SearchChatMediaPreviewActivity.this.h.scrollToPosition(i);
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
            if (childAt == null || childAt != (myVideoView = SearchChatMediaPreviewActivity.this.m) || myVideoView.c()) {
                return;
            }
            SearchChatMediaPreviewActivity.this.L4();
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
                SearchChatMediaPreviewActivity searchChatMediaPreviewActivity = SearchChatMediaPreviewActivity.this;
                searchChatMediaPreviewActivity.c = ((RecyclerView.LayoutParams) searchChatMediaPreviewActivity.t.findSnapView(recyclerView.getLayoutManager()).getLayoutParams()).getViewAdapterPosition();
                SearchChatMediaPreviewActivity searchChatMediaPreviewActivity2 = SearchChatMediaPreviewActivity.this;
                searchChatMediaPreviewActivity2.P4((CommunMessage) searchChatMediaPreviewActivity2.a.get(SearchChatMediaPreviewActivity.this.c));
                SearchChatMediaPreviewActivity.this.M4(1);
                n93.b().c(SearchChatMediaPreviewActivity.this.c);
                SearchChatMediaPreviewActivity.this.l.notifyDataSetChanged();
                SearchChatMediaPreviewActivity.this.g.scrollToPosition(SearchChatMediaPreviewActivity.this.c);
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
                ia3.a(SearchChatMediaPreviewActivity.this.m);
                SearchChatMediaPreviewActivity searchChatMediaPreviewActivity = SearchChatMediaPreviewActivity.this;
                searchChatMediaPreviewActivity.s = searchChatMediaPreviewActivity.q;
                searchChatMediaPreviewActivity.q = -1;
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchChatMediaPreviewActivity.this.M4(0);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchChatMediaPreviewActivity.this.M4(0);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchChatMediaPreviewActivity.this.M4(0);
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchChatMediaPreviewActivity.this.setResult(0);
            k93.a().d(SearchChatMediaPreviewActivity.this.b);
            SearchChatMediaPreviewActivity.this.finish();
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommunMessage communMessage = (CommunMessage) SearchChatMediaPreviewActivity.this.a.get(SearchChatMediaPreviewActivity.this.c);
            if (SearchChatMediaPreviewActivity.this.b.contains(communMessage)) {
                SearchChatMediaPreviewActivity.this.b.remove(communMessage);
            } else {
                SearchChatMediaPreviewActivity.this.b.add(communMessage);
            }
            SearchChatMediaPreviewActivity.this.P4(communMessage);
            SearchChatMediaPreviewActivity.this.O4();
            SearchChatMediaPreviewActivity.this.l.D(communMessage);
        }
    }

    public void D4() {
        List<CommunMessage> listB = k93.a().b();
        if (listB == null || listB.size() == 0) {
            return;
        }
        this.k.n(listB);
        this.b.addAll(listB);
        this.l.A(listB);
        int intExtra = getIntent().getIntExtra("imagePosition", 0);
        this.c = intExtra;
        this.h.scrollToPosition(intExtra);
        this.g.scrollToPosition(this.c);
        n93.b().c(this.c);
        P4(this.a.get(this.c));
        O4();
    }

    public void E4() {
        findViewById(R.id.iv_actionBar_back).setOnClickListener(new i());
        this.e.setOnClickListener(new j());
        this.d.setOnClickListener(new a());
    }

    public final void F4() throws IllegalStateException {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.i = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.g.setLayoutManager(this.i);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.u = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this.g);
        SearchChatMediaPreviewAdapter searchChatMediaPreviewAdapter = new SearchChatMediaPreviewAdapter(this.a, R.layout.item_preview);
        this.l = searchChatMediaPreviewAdapter;
        searchChatMediaPreviewAdapter.s(new b());
        this.g.setItemViewCacheSize(9);
        this.g.setAdapter(this.l);
    }

    public final void G4() throws IllegalStateException {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.j = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.h.setLayoutManager(this.j);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.t = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this.h);
        SearchChatMediaPreviewFullAdapter searchChatMediaPreviewFullAdapter = new SearchChatMediaPreviewFullAdapter(this, this.a);
        this.k = searchChatMediaPreviewFullAdapter;
        searchChatMediaPreviewFullAdapter.q(this);
        this.k.r(this);
        this.h.setAdapter(this.k);
        this.h.addOnChildAttachStateChangeListener(new c());
        this.h.addOnScrollListener(new d());
    }

    public void H4() {
        MyVideoView myVideoView = new MyVideoView(this);
        this.m = myVideoView;
        myVideoView.setOnStateChangeListener(new e());
        this.n = new StandardVideoController(this);
        CompleteViewImagePicker completeViewImagePicker = new CompleteViewImagePicker(this);
        this.o = completeViewImagePicker;
        this.n.l(completeViewImagePicker);
        this.o.setOnClickListener(new f());
        VodControlViewImagePicker vodControlViewImagePicker = new VodControlViewImagePicker(this);
        this.x = vodControlViewImagePicker;
        vodControlViewImagePicker.k(false);
        this.x.setOnClickListener(new g());
        this.n.l(this.x);
        TitleView titleView = new TitleView(this);
        this.p = titleView;
        this.n.l(titleView);
        this.n.setEnableOrientation(false);
        this.n.setDoubleTapTogglePlayEnabled(false);
        this.m.setVideoController(this.n);
        this.n.setOnClickListener(new h());
    }

    public void I4() throws IllegalStateException {
        this.d = (TextView) findViewById(R.id.ac_preview_tv_send);
        this.e = (LinearLayout) findViewById(R.id.ll_pre_select);
        this.f = (ImageView) findViewById(R.id.iv_item_check);
        this.g = (RecyclerView) findViewById(R.id.rv_preview);
        this.h = (RecyclerView) findViewById(R.id.rv_preview_full);
        this.w = (RelativeLayout) findViewById(R.id.layout_actionBar);
        this.v = (LinearLayout) findViewById(R.id.rl_main_bottom);
        H4();
        G4();
        F4();
    }

    public final boolean J4(CommunMessage communMessage) {
        return communMessage.getType() == MessageType.shortvideo;
    }

    public final void K4(String str) {
        this.m.setUrl(str);
    }

    public final void L4() throws IOException {
        this.m.u();
        if (this.m.c()) {
            this.m.f();
        }
        if (getRequestedOrientation() != 1) {
            setRequestedOrientation(1);
        }
        this.q = -1;
    }

    public final void M4(int i2) {
        if (i2 != 0) {
            this.g.setVisibility(i2 == 1 ? 0 : 4);
            this.v.setVisibility(i2 == 1 ? 0 : 4);
            this.w.setVisibility(i2 == 1 ? 0 : 4);
        } else {
            RecyclerView recyclerView = this.g;
            recyclerView.setVisibility(recyclerView.getVisibility() == 0 ? 4 : 0);
            LinearLayout linearLayout = this.v;
            linearLayout.setVisibility(linearLayout.getVisibility() == 0 ? 4 : 0);
            RelativeLayout relativeLayout = this.w;
            relativeLayout.setVisibility(relativeLayout.getVisibility() != 0 ? 0 : 4);
        }
    }

    public void N4(int i2) throws IOException {
        String videoLocalUrl;
        int i3 = this.q;
        if (i3 == i2) {
            return;
        }
        if (i3 != -1) {
            L4();
        }
        CommunMessage communMessage = this.a.get(i2);
        EntityShortVideo entityShortVideo = (EntityShortVideo) communMessage.getDataBean();
        if (ch3.n().s(WearUtils.g0(communMessage.getFrom())) != null) {
            videoLocalUrl = WearUtils.e + entityShortVideo.getVideoUrl();
        } else {
            videoLocalUrl = entityShortVideo.getVideoLocalUrl();
            if (!new File(videoLocalUrl).exists()) {
                videoLocalUrl = WearUtils.e + entityShortVideo.getVideoUrl();
            }
        }
        K4(videoLocalUrl);
        View viewFindViewByPosition = this.j.findViewByPosition(i2);
        if (viewFindViewByPosition == null) {
            return;
        }
        SearchChatMediaPreviewFullAdapter.VideoHolder videoHolder = (SearchChatMediaPreviewFullAdapter.VideoHolder) viewFindViewByPosition.getTag();
        this.n.j(videoHolder.e, true);
        ia3.a(this.m);
        videoHolder.b.addView(this.m, 0);
        zj4.d().a(this.m, "list");
        this.m.start();
        this.q = i2;
    }

    public final void O4() {
        int size = this.b.size();
        if (size == 0) {
            this.d.setEnabled(false);
            this.d.setText(getString(R.string.confirm));
            this.d.setAlpha(0.5f);
        } else if (size < 9) {
            this.d.setEnabled(true);
            this.d.setText(String.format(getString(R.string.confirm_msg2), Integer.valueOf(size)));
            this.d.setAlpha(1.0f);
        } else if (size == 9) {
            this.d.setEnabled(true);
            this.d.setText(String.format(getString(R.string.confirm_msg2), Integer.valueOf(size)));
            this.d.setAlpha(1.0f);
        }
    }

    public final void P4(CommunMessage communMessage) {
        if (this.b.contains(communMessage)) {
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.icon_image_checked));
        } else {
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.picture_choose_cancel));
        }
    }

    @Override // dc.ga3
    public void a(int i2) {
        M4(0);
    }

    @Override // dc.fa3
    public void m1(View view, int i2) throws IOException {
        if (J4(this.a.get(i2))) {
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
        I4();
        E4();
        D4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws IOException {
        super.onDestroy();
        n93.b().c(0);
        MyVideoView myVideoView = this.m;
        if (myVideoView != null) {
            myVideoView.u();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MyVideoView myVideoView = this.m;
        if (myVideoView != null) {
            myVideoView.pause();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MyVideoView myVideoView = this.m;
        if (myVideoView != null) {
            myVideoView.w();
        }
    }
}
