package com.wear.main.longDistance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.activity.qrcode.QRCodeActivity;
import com.wear.adapter.longdistance.SearchChatMediaAdapter;
import com.wear.bean.User;
import com.wear.bean.event.ChatRoomMessageReflashEvent;
import com.wear.bean.event.ForwardMessageEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.ContainBean;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.MessageType;
import com.wear.ui.longDistance.video.VideoPlayerActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.iwatcher.ImageWatcher;
import dc.ah4;
import dc.be3;
import dc.ch3;
import dc.e82;
import dc.gg3;
import dc.hf3;
import dc.hu3;
import dc.k93;
import dc.kg3;
import dc.pj3;
import dc.sa2;
import dc.sg3;
import dc.vg3;
import dc.zb2;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class SearchChatMediaActivity extends QRCodeActivity implements sa2 {
    public Calendar A;
    public boolean B;
    public int C;
    public int D;
    public e82 E;
    public HashMap F;

    @BindView(R.id.ll_bottom)
    public LinearLayout ll_bottom;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public List q;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;
    public SearchChatMediaAdapter s;
    public int t;

    @BindView(R.id.tv_label)
    public TextView tv_label;

    @BindView(R.id.tv_no_result)
    public TextView tv_no_result;

    @BindView(R.id.tv_preview)
    public TextView tv_preview;

    @BindView(R.id.tv_select)
    public TextView tv_select;

    @BindView(R.id.tv_send)
    public TextView tv_send;
    public int u;
    public int v;

    @BindView(R.id.v_image_watcher)
    public ImageWatcher vImageWatcher;
    public int w;
    public int x;
    public Calendar y;
    public Calendar z;

    public class a extends GridLayoutManager.SpanSizeLookup {
        public a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return SearchChatMediaActivity.this.q.get(i) instanceof String ? 4 : 1;
        }
    }

    public class b implements SearchChatMediaAdapter.b {
        public b() {
        }

        @Override // com.wear.adapter.longdistance.SearchChatMediaAdapter.b
        public void a() {
            SearchChatMediaActivity.this.f6();
        }

        @Override // com.wear.adapter.longdistance.SearchChatMediaAdapter.b
        public void b(int i) {
            SearchChatMediaActivity.this.X5(i);
        }

        @Override // com.wear.adapter.longdistance.SearchChatMediaAdapter.b
        public void c(CommunMessage communMessage) {
            SearchChatMediaActivity.this.O5(communMessage);
        }
    }

    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            String strI;
            int i3;
            super.onScrolled(recyclerView, i, i2);
            RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition());
            if (!(viewHolderFindViewHolderForLayoutPosition instanceof SearchChatMediaAdapter.MediaViewHolder)) {
                if (viewHolderFindViewHolderForLayoutPosition instanceof SearchChatMediaAdapter.LabelViewHolder) {
                    SearchChatMediaActivity.this.tv_label.setText(((TextView) viewHolderFindViewHolderForLayoutPosition.itemView).getText());
                    return;
                }
                return;
            }
            CommunMessage communMessage = (CommunMessage) viewHolderFindViewHolderForLayoutPosition.itemView.getTag(R.id.tag1);
            SearchChatMediaActivity.this.A.setTime(communMessage.getCreated());
            SearchChatMediaActivity searchChatMediaActivity = SearchChatMediaActivity.this;
            if (searchChatMediaActivity.T5(searchChatMediaActivity.A)) {
                i3 = R.string.search_chat_week;
            } else {
                SearchChatMediaActivity searchChatMediaActivity2 = SearchChatMediaActivity.this;
                if (!searchChatMediaActivity2.S5(searchChatMediaActivity2.A)) {
                    strI = be3.i(be3.c, communMessage.getCreated());
                    SearchChatMediaActivity.this.tv_label.setText(strI);
                }
                i3 = R.string.search_chat_month;
            }
            strI = ah4.e(i3);
            SearchChatMediaActivity.this.tv_label.setText(strI);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchChatMediaActivity searchChatMediaActivity = SearchChatMediaActivity.this;
            searchChatMediaActivity.t = searchChatMediaActivity.tv_label.getHeight();
            SearchChatMediaActivity searchChatMediaActivity2 = SearchChatMediaActivity.this;
            searchChatMediaActivity2.w = searchChatMediaActivity2.tv_label.getLeft();
            SearchChatMediaActivity searchChatMediaActivity3 = SearchChatMediaActivity.this;
            searchChatMediaActivity3.u = searchChatMediaActivity3.tv_label.getTop();
            SearchChatMediaActivity searchChatMediaActivity4 = SearchChatMediaActivity.this;
            searchChatMediaActivity4.x = searchChatMediaActivity4.tv_label.getRight();
            SearchChatMediaActivity searchChatMediaActivity5 = SearchChatMediaActivity.this;
            searchChatMediaActivity5.v = searchChatMediaActivity5.tv_label.getBottom();
        }
    }

    public class e implements ImageWatcher.i {

        public class a extends SimpleImageLoadingListener {
            public final /* synthetic */ ImageWatcher.g a;

            public a(e eVar, ImageWatcher.g gVar) {
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

        public e(SearchChatMediaActivity searchChatMediaActivity) {
        }

        @Override // com.wear.widget.iwatcher.ImageWatcher.i
        public void a(Context context, String str, ImageWatcher.g gVar) {
            ImageLoader.getInstance().loadImage(str, MyApplication.Y, new a(this, gVar));
        }
    }

    public class f implements Consumer<List> {
        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List list) throws Exception {
            SearchChatMediaActivity.this.dissDialog();
            SearchChatMediaActivity.this.q.clear();
            SearchChatMediaActivity.this.q.addAll(list);
            SearchChatMediaActivity.this.s.notifyDataSetChanged();
            SearchChatMediaActivity searchChatMediaActivity = SearchChatMediaActivity.this;
            searchChatMediaActivity.tv_no_result.setVisibility(searchChatMediaActivity.q.isEmpty() ? 0 : 8);
            SearchChatMediaActivity searchChatMediaActivity2 = SearchChatMediaActivity.this;
            searchChatMediaActivity2.recyclerView.setVisibility(searchChatMediaActivity2.q.isEmpty() ? 8 : 0);
            SearchChatMediaActivity searchChatMediaActivity3 = SearchChatMediaActivity.this;
            searchChatMediaActivity3.ll_bottom.setVisibility(searchChatMediaActivity3.q.isEmpty() ? 8 : 0);
            SearchChatMediaActivity searchChatMediaActivity4 = SearchChatMediaActivity.this;
            searchChatMediaActivity4.tv_select.setVisibility(searchChatMediaActivity4.q.isEmpty() ? 4 : 0);
            SearchChatMediaActivity.this.recyclerView.scrollToPosition(r4.q.size() - 1);
        }
    }

    public class g implements ObservableOnSubscribe<List> {
        public g() {
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x01be  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01da  */
        @Override // io.reactivex.ObservableOnSubscribe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void subscribe(@com.google.firebase.database.annotations.NotNull io.reactivex.ObservableEmitter<java.util.List> r13) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 579
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.main.longDistance.SearchChatMediaActivity.g.subscribe(io.reactivex.ObservableEmitter):void");
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchChatMediaActivity.this.B = false;
            SearchChatMediaActivity.this.tv_select.setText(ah4.e(R.string.common_select));
            SearchChatMediaActivity.this.s.r(SearchChatMediaActivity.this.B);
            SearchChatMediaActivity.this.f6();
            SearchChatMediaActivity.this.Y5();
        }
    }

    @Override // dc.sa2
    public void A0(CommunMessage communMessage, int i) {
    }

    @Override // dc.sa2
    public IPeopleInfo C() {
        return this.p ? WearUtils.y.v(this.o) : WearUtils.y.v(this.m);
    }

    @Override // dc.sa2
    public void C2(CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public boolean E() {
        return false;
    }

    @Override // dc.sa2
    public boolean H1(boolean z) {
        return false;
    }

    @Override // dc.sa2
    public View H2(String str) {
        return this.s.p(str);
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

    public final void O5(CommunMessage communMessage) {
        if (communMessage.getType() != MessageType.picture) {
            if (communMessage.getType() == MessageType.shortvideo) {
                VideoPlayerActivity.u4(this, (EntityShortVideo) communMessage.getDataBean());
                return;
            }
            return;
        }
        Intent intent = new Intent(this, (Class<?>) LongPictureEnlargeActivity.class);
        if (WearUtils.e1(this.m)) {
            intent.putExtra("extras_friend_id", this.o);
        } else {
            intent.putExtra("extras_friend_id", this.m);
        }
        intent.putExtra("notShow", true);
        intent.putExtra("can_long_click", false);
        intent.putExtra("extras_massage_id", communMessage.getId());
        startActivity(intent);
    }

    @Override // dc.sa2
    public void P() {
    }

    public final void P5(CommunMessage communMessage, CommunMessage communMessage2, String str) {
        this.D++;
        IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
        if (iPeopleInfoS != null && iPeopleInfoS.isFriend()) {
            ForwardMessageEvent forwardMessageEvent = new ForwardMessageEvent();
            forwardMessageEvent.friendId = iPeopleInfoS.getId();
            forwardMessageEvent.userMessage = communMessage;
            forwardMessageEvent.blockMessage = communMessage2;
            EventBus.getDefault().post(forwardMessageEvent);
        }
        if (this.D == this.C) {
            this.delayHandler.postDelayed(new h(), 1000L);
            if (iPeopleInfoS == null || !iPeopleInfoS.isGroup()) {
                return;
            }
            EventBus.getDefault().post(new ChatRoomMessageReflashEvent());
        }
    }

    @Override // dc.sa2
    public void Q1(HashMap<String, String> map) {
        this.F = map;
    }

    public final void Q5() {
        this.tv_preview.setAlpha(0.5f);
        this.tv_send.setAlpha(0.5f);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setSpanSizeLookup(new a());
        this.recyclerView.setLayoutManager(gridLayoutManager);
        ArrayList arrayList = new ArrayList();
        this.q = arrayList;
        SearchChatMediaAdapter searchChatMediaAdapter = new SearchChatMediaAdapter(this, arrayList);
        this.s = searchChatMediaAdapter;
        searchChatMediaAdapter.s(new b());
        this.recyclerView.setAdapter(this.s);
        this.recyclerView.addOnScrollListener(new c());
        this.tv_label.post(new d());
        ImageWatcher imageWatcher = (ImageWatcher) findViewById(R.id.v_image_watcher);
        this.vImageWatcher = imageWatcher;
        imageWatcher.setTranslucentStatus(gg3.g(this));
        this.vImageWatcher.setErrorImageRes(R.drawable.error_picture);
        this.vImageWatcher.setLoader(new e(this));
    }

    @Override // dc.sa2
    public void R2(int i, CommunMessage communMessage) {
    }

    public final boolean R5(Calendar calendar, Calendar calendar2) {
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2);
    }

    public final boolean S5(Calendar calendar) {
        return this.y.get(1) == calendar.get(1) && this.y.get(2) == calendar.get(2) && this.y.get(4) != calendar.get(4);
    }

    @Override // dc.sa2
    public void T0(CommunMessage communMessage) {
    }

    public final boolean T5(Calendar calendar) {
        return this.y.get(1) == calendar.get(1) && this.y.get(2) == calendar.get(2) && this.y.get(4) == calendar.get(4);
    }

    @Override // dc.sa2
    public HashMap<String, GifImageView> U3() {
        return this.s.o();
    }

    @Override // dc.sa2
    public void W3() {
    }

    public final boolean W5(CommunMessage communMessage) {
        return zb2.O().l0(communMessage);
    }

    @Override // dc.sa2
    public void X2() {
    }

    public final void X5(int i) {
        List<CommunMessage> listQ = this.s.q();
        if (listQ.isEmpty()) {
            return;
        }
        k93.a().d(listQ);
        Intent intent = new Intent(this, (Class<?>) SearchChatMediaPreviewActivity.class);
        intent.putExtra("imagePosition", i);
        startActivityForResult(intent, 1);
    }

    @SuppressLint({"CheckResult"})
    public final void Y5() {
        showDialog();
        Observable.create(new g()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f());
    }

    @Override // dc.sa2
    public void Z2() {
    }

    @Override // dc.sa2
    public void Z3() {
    }

    public final void Z5(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.D = 0;
        this.C = list.size();
        List<CommunMessage> listQ = this.s.q();
        if (listQ == null || listQ.isEmpty()) {
            return;
        }
        this.C *= listQ.size();
        showDialog();
        for (CommunMessage communMessage : listQ) {
            for (String str : list) {
                if (communMessage.getType() == MessageType.picture) {
                    d6(communMessage, str);
                } else if (communMessage.getType() == MessageType.shortvideo) {
                    e6(communMessage, str);
                }
            }
        }
    }

    public final void a6(DataEntityAbstract dataEntityAbstract, String str) {
        IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str));
        if (iPeopleInfoS != null) {
            boolean z = true;
            boolean z2 = false;
            if (iPeopleInfoS.isGroup()) {
                if (!hf3.d(this)) {
                    sg3.i(this, R.string.common_settingTip);
                    c6(dataEntityAbstract, str);
                    z = false;
                }
                if (!MyApplication.P || hu3.x() == null) {
                    sg3.i(this, R.string.message_send_error);
                    c6(dataEntityAbstract, str);
                } else {
                    z2 = z;
                }
                if (z2) {
                    zb2.O().H0(str, dataEntityAbstract, true, false, null);
                }
                P5(null, null, str);
                return;
            }
            CommunMessage communMessage = new CommunMessage();
            communMessage.setFrom(WearUtils.y.p());
            communMessage.setTo(str);
            communMessage.setUserId(WearUtils.y.p());
            communMessage.sendEntity(dataEntityAbstract);
            communMessage.setId(WearUtils.E());
            communMessage.setSendStatus(2);
            User user = (User) iPeopleInfoS;
            if (user.isDateIng()) {
                communMessage.setSendType(2);
            }
            if (!hf3.d(this)) {
                sg3.i(this, R.string.common_settingTip);
                communMessage.sendFail();
                z = false;
            }
            if (!MyApplication.P || hu3.x() == null) {
                sg3.i(this, R.string.message_send_error);
                communMessage.sendFail();
            } else {
                z2 = z;
            }
            if (W5(communMessage)) {
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            }
            if (z2) {
                b6(communMessage, user);
            } else {
                P5(communMessage, null, str);
            }
        }
    }

    @Override // dc.sa2
    public String b0() {
        return null;
    }

    public final void b6(CommunMessage communMessage, User user) {
        CommunMessage communMessageI;
        if (user.isDeleteByFriend() && !user.isDateIng()) {
            hu3.m(communMessage, true);
            hu3.j(communMessage);
            communMessage.sendFail();
            if (W5(communMessage)) {
                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            }
        } else {
            if (WearUtils.x.i.D(user.getUserJid(), true)) {
                communMessageI = hu3.i(communMessage);
                final ContainBean containBean = new ContainBean(communMessage);
                vg3.b().a(new Runnable() { // from class: dc.b82
                    @Override // java.lang.Runnable
                    public final void run() {
                        hu3.f0(containBean);
                    }
                });
                P5(communMessage, communMessageI, user.getUserJid());
            }
            if (user.canSendMsg()) {
                final ContainBean containBean2 = new ContainBean(communMessage);
                vg3.b().a(new Runnable() { // from class: dc.c82
                    @Override // java.lang.Runnable
                    public final void run() {
                        hu3.f0(containBean2);
                    }
                });
            }
        }
        communMessageI = null;
        P5(communMessage, communMessageI, user.getUserJid());
    }

    public final void c6(DataEntityAbstract dataEntityAbstract, String str) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(str);
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        communMessage.setUserId(communMessage.getFrom());
        communMessage.setSendStatus(4);
        if (W5(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
        }
    }

    @Override // dc.sa2
    public List<CommunMessage> d0() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.q) {
            if (obj instanceof CommunMessage) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void d6(CommunMessage communMessage, String str) {
        EntityPicture entityPicture = (EntityPicture) communMessage.getDataBean();
        EntityPicture entityPicture2 = new EntityPicture();
        entityPicture2.setLocalUrl(entityPicture.getLocalUrl());
        entityPicture2.setUrl(entityPicture.getUrl());
        entityPicture2.setH(entityPicture.getH());
        entityPicture2.setW(entityPicture.getW());
        entityPicture2.setType(entityPicture.getType());
        entityPicture2.setFileMd5(entityPicture.getFileMd5());
        a6(entityPicture2, str);
    }

    public final void e6(CommunMessage communMessage, String str) {
        EntityShortVideo entityShortVideo = (EntityShortVideo) communMessage.getDataBean();
        EntityShortVideo entityShortVideo2 = new EntityShortVideo();
        entityShortVideo2.setPicLocalUrl(entityShortVideo.getPicLocalUrl());
        entityShortVideo2.setPicUrl(entityShortVideo.getPicUrl());
        entityShortVideo2.setPicH(entityShortVideo.getPicH());
        entityShortVideo2.setPicW(entityShortVideo.getPicW());
        entityShortVideo2.setVideoLocalUrl(entityShortVideo.getVideoLocalUrl());
        entityShortVideo2.setVideoUrl(entityShortVideo.getVideoUrl());
        entityShortVideo2.setVideoH(entityShortVideo.getVideoH());
        entityShortVideo2.setVideoW(entityShortVideo.getVideoW());
        entityShortVideo2.setDuration(entityShortVideo.getDuration());
        entityShortVideo2.setSize(entityShortVideo.getSize());
        a6(entityShortVideo2, str);
    }

    public final void f6() {
        int size = this.s.q().size();
        if (size == 0) {
            this.tv_send.setEnabled(false);
            this.tv_preview.setEnabled(false);
            this.tv_send.setText(ah4.e(R.string.common_send));
            this.tv_send.setAlpha(0.5f);
            this.tv_preview.setAlpha(0.5f);
            return;
        }
        if (size < 9) {
            this.tv_send.setEnabled(true);
            this.tv_preview.setEnabled(true);
            this.tv_send.setText(String.format(ah4.e(R.string.confirm_msg2), Integer.valueOf(size)));
            this.tv_send.setAlpha(1.0f);
            this.tv_preview.setAlpha(1.0f);
            return;
        }
        if (size == 9) {
            this.tv_send.setEnabled(true);
            this.tv_preview.setEnabled(true);
            this.tv_send.setText(String.format(getString(R.string.confirm_msg2), Integer.valueOf(size)));
            this.tv_send.setAlpha(1.0f);
            this.tv_preview.setAlpha(1.0f);
        }
    }

    @Override // dc.sa2
    public String getUserName() {
        return null;
    }

    @Override // dc.sa2
    public void m2(CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public void n() {
    }

    @Override // dc.sa2, dc.xb2
    public void notifyDataSetChanged() {
    }

    @Override // dc.sa2
    public boolean o() {
        return false;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i == 2 && i2 == -1) {
                Z5(intent.getStringArrayListExtra("userJids"));
                return;
            }
            return;
        }
        this.s.t(k93.a().b());
        if (i2 == 0) {
            f6();
        } else if (i2 == -1) {
            pj3.o(this, SelectChatActivity.class, 2);
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_select, R.id.tv_preview, R.id.tv_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back /* 2131363096 */:
                finish();
                break;
            case R.id.tv_preview /* 2131365251 */:
                X5(0);
                break;
            case R.id.tv_select /* 2131365292 */:
                if (!this.q.isEmpty()) {
                    boolean z = !this.B;
                    this.B = z;
                    this.tv_select.setText(ah4.e(z ? R.string.common_cancel : R.string.common_select));
                    this.s.r(this.B);
                    f6();
                    break;
                }
                break;
            case R.id.tv_send /* 2131365298 */:
                pj3.o(this, SelectChatActivity.class, 2);
                break;
        }
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_chat_media);
        ButterKnife.bind(this);
        if (getIntent().getExtras() != null) {
            String string = getIntent().getExtras().getString("userId");
            this.m = string;
            this.n = WearUtils.i0(string);
            this.o = getIntent().getExtras().getString("roomId");
            this.p = !TextUtils.isEmpty(r4);
        }
        Calendar calendar = Calendar.getInstance();
        this.y = calendar;
        calendar.setFirstDayOfWeek(1);
        Calendar calendar2 = Calendar.getInstance();
        this.A = calendar2;
        calendar2.setFirstDayOfWeek(1);
        this.F = DaoUtils.getMessageHideDao().getHidesToMap(WearUtils.y.p(), this.p ? WearUtils.j0(this.o) : this.n);
        e82 e82Var = new e82(this, this, null, null);
        this.E = e82Var;
        e82Var.Y(false);
        this.E.Z(true);
        Q5();
        Y5();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        kg3.b(this, true);
        MyApplication.N().q0(this);
    }

    @Override // dc.sa2
    public void q() {
    }

    @Override // dc.sa2
    public HashMap<String, String> r() {
        return this.F;
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
