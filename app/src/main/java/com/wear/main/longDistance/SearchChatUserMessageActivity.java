package com.wear.main.longDistance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.activity.qrcode.QRCodeActivity;
import com.wear.adapter.longdistance.SearchChatUserMessageAdapter;
import com.wear.bean.event.ChatPictureEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.DaoUtils;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.MessageType;
import com.wear.ui.longDistance.video.VideoPlayerActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.iwatcher.ImageWatcher;
import dc.cg3;
import dc.ch3;
import dc.e82;
import dc.gg3;
import dc.h12;
import dc.na2;
import dc.pj3;
import dc.sa2;
import dc.so3;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class SearchChatUserMessageActivity extends QRCodeActivity implements SearchChatUserMessageAdapter.j, sa2 {
    public boolean A;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;
    public boolean s;
    public IPeopleInfo t;

    @BindView(R.id.tv_no_result)
    public TextView tv_no_result;
    public LinearLayoutManager u;
    public List<CommunMessage> v;

    @BindView(R.id.v_image_watcher)
    public ImageWatcher vImageWatcher;
    public SearchChatUserMessageAdapter w;
    public e82 x;
    public HashMap z;
    public so3 y = new so3();
    public int B = 0;
    public int C = 10;

    public class a implements ImageWatcher.i {

        /* renamed from: com.wear.main.longDistance.SearchChatUserMessageActivity$a$a, reason: collision with other inner class name */
        public class C0123a extends SimpleImageLoadingListener {
            public final /* synthetic */ ImageWatcher.g a;

            public C0123a(a aVar, ImageWatcher.g gVar) {
                this.a = gVar;
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                this.a.b(bitmap);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                this.a.a(null);
            }
        }

        public a(SearchChatUserMessageActivity searchChatUserMessageActivity) {
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.i
        public void a(Context context, String str, ImageWatcher.g gVar) {
            ImageLoader.getInstance().loadImage(str, MyApplication.Y, new C0123a(this, gVar));
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (SearchChatUserMessageActivity.this.u.findLastVisibleItemPosition() < SearchChatUserMessageActivity.this.v.size() - 3 || i2 <= 0 || SearchChatUserMessageActivity.this.A) {
                return;
            }
            SearchChatUserMessageActivity.this.F5();
        }
    }

    public class c implements Consumer<List<CommunMessage>> {
        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<CommunMessage> list) throws Exception {
            SearchChatUserMessageActivity.this.v.addAll(list);
            SearchChatUserMessageActivity.this.w.notifyItemRangeInserted(SearchChatUserMessageActivity.this.v.size() - list.size(), list.size());
            SearchChatUserMessageActivity searchChatUserMessageActivity = SearchChatUserMessageActivity.this;
            searchChatUserMessageActivity.tv_no_result.setVisibility(searchChatUserMessageActivity.v.isEmpty() ? 0 : 8);
            SearchChatUserMessageActivity searchChatUserMessageActivity2 = SearchChatUserMessageActivity.this;
            searchChatUserMessageActivity2.recyclerView.setVisibility(searchChatUserMessageActivity2.v.isEmpty() ? 8 : 0);
            SearchChatUserMessageActivity.this.A = false;
            SearchChatUserMessageActivity.z5(SearchChatUserMessageActivity.this);
        }
    }

    public class d implements ObservableOnSubscribe<List<CommunMessage>> {
        public d() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(@com.google.firebase.database.annotations.NotNull ObservableEmitter<List<CommunMessage>> observableEmitter) throws Exception {
            ArrayList arrayList = new ArrayList();
            arrayList.add(MessageType.chat);
            arrayList.add(MessageType.audio);
            arrayList.add(MessageType.picture);
            arrayList.add(MessageType.shortvideo);
            List<CommunMessage> listFindMessageByType = DaoUtils.getCommunMessageDao().findMessageByType(SearchChatUserMessageActivity.this.m, SearchChatUserMessageActivity.this.n, SearchChatUserMessageActivity.this.p, false, false, arrayList, SearchChatUserMessageActivity.this.B, SearchChatUserMessageActivity.this.C);
            if (listFindMessageByType == null) {
                observableEmitter.onNext(new ArrayList());
                return;
            }
            for (CommunMessage communMessage : listFindMessageByType) {
                communMessage.setDataBean(communMessage.syncDecryptBean());
            }
            observableEmitter.onNext(listFindMessageByType);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SearchChatUserMessageActivity.this.isFinishing() || SearchChatUserMessageActivity.this.isDestroyed()) {
                return;
            }
            SearchChatUserMessageActivity.this.w.notifyDataSetChanged();
            SearchChatUserMessageActivity searchChatUserMessageActivity = SearchChatUserMessageActivity.this;
            searchChatUserMessageActivity.tv_no_result.setVisibility(searchChatUserMessageActivity.v.isEmpty() ? 0 : 8);
            SearchChatUserMessageActivity searchChatUserMessageActivity2 = SearchChatUserMessageActivity.this;
            searchChatUserMessageActivity2.recyclerView.setVisibility(searchChatUserMessageActivity2.v.isEmpty() ? 8 : 0);
        }
    }

    public static /* synthetic */ int z5(SearchChatUserMessageActivity searchChatUserMessageActivity) {
        int i = searchChatUserMessageActivity.B;
        searchChatUserMessageActivity.B = i + 1;
        return i;
    }

    @Override // dc.sa2
    public void A0(CommunMessage communMessage, int i) {
    }

    @Override // dc.sa2
    public IPeopleInfo C() {
        return WearUtils.y.v(this.o);
    }

    @Override // dc.sa2
    public void C2(CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public boolean E() {
        return false;
    }

    public final void E5() {
        ArrayList arrayList = new ArrayList();
        this.v = arrayList;
        SearchChatUserMessageAdapter searchChatUserMessageAdapter = new SearchChatUserMessageAdapter(this, this.t, this.y, arrayList, this.x, !TextUtils.isEmpty(this.p), this);
        this.w = searchChatUserMessageAdapter;
        this.u = cg3.f(this.recyclerView, searchChatUserMessageAdapter);
        ImageWatcher imageWatcher = (ImageWatcher) findViewById(R.id.v_image_watcher);
        this.vImageWatcher = imageWatcher;
        imageWatcher.setTranslucentStatus(gg3.g(this));
        this.vImageWatcher.setErrorImageRes(R.drawable.error_picture);
        this.vImageWatcher.setLoader(new a(this));
        this.recyclerView.addOnScrollListener(new b());
    }

    @SuppressLint({"CheckResult"})
    public final void F5() {
        this.A = true;
        Observable.create(new d()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c());
    }

    @Override // dc.sa2
    public boolean H1(boolean z) {
        return false;
    }

    @Override // dc.sa2
    public View H2(String str) {
        return this.w.E(str);
    }

    @Override // dc.sa2
    public void H3(CommunMessage communMessage, EntityShortVideo entityShortVideo) {
    }

    @Override // dc.sa2
    public void K() {
    }

    @Override // dc.sa2
    public void M(EntityPattern entityPattern) {
    }

    @Override // dc.sa2
    public void P() {
    }

    @Override // dc.sa2
    public void Q1(HashMap<String, String> map) {
        this.z = map;
    }

    @Override // dc.sa2
    public void R2(int i, CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public void T0(CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public HashMap<String, GifImageView> U3() {
        return this.w.D();
    }

    @Override // dc.sa2
    public void W3() {
    }

    @Override // dc.sa2
    public void X2() {
    }

    @Override // dc.sa2
    public void Z2() {
    }

    @Override // dc.sa2
    public void Z3() {
    }

    @Override // dc.sa2
    public String b0() {
        return null;
    }

    @Override // com.wear.adapter.longdistance.SearchChatUserMessageAdapter.j
    public void c(CommunMessage communMessage) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("searchMessage", communMessage);
        if (this.s) {
            bundle.putString("roomId", this.q);
            pj3.g(this, ChatRoomActivity.class, bundle);
        } else {
            bundle.putString("userId", this.o);
            pj3.g(this, ChatActivity.class, bundle);
        }
    }

    @Override // dc.sa2
    public List<CommunMessage> d0() {
        return this.v;
    }

    @Override // dc.sa2
    public String getUserName() {
        return null;
    }

    public final void init() {
        this.z = DaoUtils.getMessageHideDao().getHidesToMap(WearUtils.y.p(), WearUtils.j0(this.s ? this.q : this.o));
        e82 e82Var = new e82(this, this, this.y, null);
        this.x = e82Var;
        e82Var.Y(false);
        this.x.Z(true);
        if (this.s) {
            this.t = ch3.n().k(WearUtils.A0(this.q));
        } else {
            this.t = WearUtils.y.v(this.o);
        }
    }

    @Override // dc.sa2
    public void m2(CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public void n() {
    }

    @Override // dc.sa2, dc.xb2
    public void notifyDataSetChanged() {
        runOnMainThread(new e());
    }

    @Override // dc.sa2
    public boolean o() {
        return false;
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_chat_user_message);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        if (getIntent().getExtras() != null) {
            this.m = getIntent().getExtras().getString("fromJid");
            this.n = getIntent().getExtras().getString("toJid");
            this.o = getIntent().getExtras().getString("userId");
            this.p = getIntent().getExtras().getString("realFromJid");
            this.q = getIntent().getExtras().getString("roomId");
            this.s = !TextUtils.isEmpty(r2);
        }
        init();
        E5();
        F5();
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws IllegalStateException {
        super.onDestroy();
        so3 so3Var = this.y;
        if (so3Var != null && so3Var.s()) {
            MusicControl.h0();
            h12.D.isPlayAudio = false;
            this.y.G();
            this.y.x();
            this.y.F();
            if (!na2.m().i()) {
                this.application.G().u0();
            }
        }
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChatPictureEvent chatPictureEvent) {
        ArrayList<String> delIds;
        if (chatPictureEvent == null || (delIds = chatPictureEvent.getDelIds()) == null || delIds.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.v) {
            Iterator<String> it = delIds.iterator();
            while (it.hasNext()) {
                String next = it.next();
                for (CommunMessage communMessage : this.v) {
                    if (communMessage.getId().equals(next)) {
                        arrayList.add(communMessage);
                    }
                }
            }
            if (arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CommunMessage communMessage2 = (CommunMessage) it2.next();
                    this.x.j0(communMessage2);
                    this.x.x(communMessage2);
                }
            }
        }
    }

    @Override // dc.sa2
    public void q() {
    }

    @Override // dc.sa2
    public HashMap<String, String> r() {
        return this.z;
    }

    @Override // com.wear.adapter.longdistance.SearchChatUserMessageAdapter.j
    public void s2(CommunMessage communMessage) {
        if (communMessage.getType() == MessageType.picture) {
            this.x.f0(communMessage);
        } else if (communMessage.getType() == MessageType.shortvideo) {
            VideoPlayerActivity.u4(this, (EntityShortVideo) communMessage.getDataBean());
        }
    }

    @Override // dc.sa2
    public void s3(CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public void t() {
    }

    @Override // dc.sa2
    public void v() {
    }

    @Override // dc.sa2
    public void v1(CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public void x3(CommunMessage communMessage, Bitmap bitmap, ImageView imageView) {
    }
}
