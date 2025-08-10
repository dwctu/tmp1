package com.wear.main.longDistance;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.activity.qrcode.QRCodeActivity;
import com.wear.adapter.longdistance.MessageNewSelectAdapter;
import com.wear.bean.Group;
import com.wear.bean.User;
import com.wear.bean.event.ClearChatViewFriendIdEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.CommunMessageDao;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.EntityUnSupport;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.ChatEditText;
import com.wear.widget.CustomSwipeRefreshLayout;
import com.wear.widget.EmojisToastView;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.be3;
import dc.cg3;
import dc.ch3;
import dc.cs3;
import dc.e82;
import dc.ep1;
import dc.gg3;
import dc.ie3;
import dc.is3;
import dc.nz1;
import dc.ta2;
import dc.xb2;
import dc.ye3;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class ChatHistorySelectActivity extends QRCodeActivity implements View.OnClickListener, CustomSwipeRefreshLayout.a, xb2, ta2, ie3.m {
    public static HashMap<String, CommunMessage> O = new HashMap<>();
    public static String P = "isGroup";
    public Group B;
    public View D;
    public e82 F;
    public ChatEditText G;
    public int K;
    public Gson M;
    public MyActionBar m;
    public ImageView n;
    public View o;
    public RecyclerView p;
    public MessageNewSelectAdapter q;
    public LinearLayoutManager s;
    public CustomSwipeRefreshLayout t;
    public String x;
    public String y;
    public User z;
    public List<CommunMessage> u = new ArrayList();
    public List<CommunMessage> v = new ArrayList();
    public int w = 0;
    public String A = "";
    public boolean C = true;
    public ie3 E = new ie3();
    public HashMap<String, String> L = null;
    public List<MessageType> N = new ArrayList();

    public class a implements is3.d {
        public a(ChatHistorySelectActivity chatHistorySelectActivity) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
        }
    }

    public class b implements Comparator<HashMap<String, Object>> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(HashMap<String, Object> map, HashMap<String, Object> map2) {
            return ((Date) map.get("created")).getTime() > ((Date) map2.get("created")).getTime() ? 1 : -1;
        }
    }

    public class c implements MyActionBar.f {
        public c() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ChatHistorySelectActivity.this.finish();
        }
    }

    public class d implements MyActionBar.f {
        public d() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ArrayList arrayList = new ArrayList();
            for (CommunMessage communMessage : ChatHistorySelectActivity.O.values()) {
                HashMap map = new HashMap();
                if (communMessage.getType() == MessageType.chat) {
                    map.put("text", ((EntityChat) communMessage.getDataBean()).getText());
                } else if (communMessage.getType() == MessageType.picture) {
                    EntityPicture entityPicture = (EntityPicture) communMessage.getDataBean();
                    map.put(XHTMLText.H, Double.valueOf(entityPicture.getH()));
                    map.put(ImagesContract.URL, entityPicture.getUrl());
                    map.put("w", Double.valueOf(entityPicture.getW()));
                }
                map.put("created", communMessage.getCreated());
                map.put("localCreated", be3.a.format(communMessage.getCreated()));
                map.put("from", communMessage.getFrom());
                map.put("to", communMessage.getTo());
                map.put("type", communMessage.getType());
                arrayList.add(map);
            }
            ChatHistorySelectActivity.J5(arrayList);
            String json = ChatHistorySelectActivity.this.M.toJson(arrayList);
            String str = "ChatHistory_Result =  " + json;
            Intent intent = new Intent();
            intent.putExtra("result", json);
            intent.putExtra("number", arrayList.size());
            ChatHistorySelectActivity.this.setResult(-1, intent);
            WearUtils.L.clear();
            WearUtils.L.putAll(ChatHistorySelectActivity.O);
            ChatHistorySelectActivity.this.finish();
        }
    }

    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            ChatHistorySelectActivity chatHistorySelectActivity = ChatHistorySelectActivity.this;
            chatHistorySelectActivity.C = false;
            if (i == 0) {
                int iFindLastCompletelyVisibleItemPosition = chatHistorySelectActivity.s.findLastCompletelyVisibleItemPosition();
                ChatHistorySelectActivity.this.s.findFirstVisibleItemPosition();
                if (iFindLastCompletelyVisibleItemPosition == ChatHistorySelectActivity.this.s.getItemCount() - 1) {
                    ChatHistorySelectActivity.this.C = true;
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public class f implements SwipeRefreshLayout.OnRefreshListener {
        public f() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            CommunMessageDao communMessageDao = DaoUtils.getCommunMessageDao();
            String strP = WearUtils.y.p();
            String strK0 = ChatHistorySelectActivity.this.K == 1 ? WearUtils.k0(ChatHistorySelectActivity.this.A) : ChatHistorySelectActivity.this.y;
            ChatHistorySelectActivity chatHistorySelectActivity = ChatHistorySelectActivity.this;
            List<CommunMessage> listFindMessageByTypeAndHours = communMessageDao.findMessageByTypeAndHours(strP, strK0, chatHistorySelectActivity.N, ChatHistorySelectActivity.x5(chatHistorySelectActivity), 10);
            Collections.reverse(listFindMessageByTypeAndHours);
            ArrayList arrayList = new ArrayList();
            for (CommunMessage communMessage : listFindMessageByTypeAndHours) {
                if (!be3.E(communMessage.getCreated(), communMessage.getSendStatus())) {
                    communMessage.setDataBean(communMessage.syncDecryptBean());
                    arrayList.add(communMessage);
                }
            }
            ChatHistorySelectActivity.this.u.addAll(0, EntityUnSupport.filterMessages(arrayList));
            ChatHistorySelectActivity.this.t.setRefreshing(false);
            ChatHistorySelectActivity.this.notifyDataSetChanged();
            if (listFindMessageByTypeAndHours.size() >= 10) {
                ChatHistorySelectActivity.this.p.scrollToPosition(9);
            } else {
                ChatHistorySelectActivity.this.t.setEnabled(false);
                ChatHistorySelectActivity.this.p.scrollToPosition(listFindMessageByTypeAndHours.size() - 1);
            }
        }
    }

    public class g extends SimpleImageLoadingListener {
        public g() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                ChatHistorySelectActivity.this.n.setImageBitmap(bitmap);
                ChatHistorySelectActivity.this.N5();
            }
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ CommunMessage a;

        public h(CommunMessage communMessage) {
            this.a = communMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatHistorySelectActivity.this.application.f0()) {
                ChatHistorySelectActivity.this.v.add(this.a);
                return;
            }
            ChatHistorySelectActivity.this.v.clear();
            String str = "listViewAddItem result:" + ChatHistorySelectActivity.this.u.add(this.a) + " -" + ChatHistorySelectActivity.this.application.g0() + " =" + ChatHistorySelectActivity.this.application.f0();
            ChatHistorySelectActivity.this.notifyDataSetChanged();
            ChatHistorySelectActivity.this.M5();
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatHistorySelectActivity.this.isFinishing() || ChatHistorySelectActivity.this.isDestroyed()) {
                return;
            }
            ChatHistorySelectActivity.this.q.notifyDataSetChanged();
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LinearLayoutManager linearLayoutManager = ChatHistorySelectActivity.this.s;
                if (linearLayoutManager != null) {
                    if (linearLayoutManager.getItemCount() > 0) {
                        ChatHistorySelectActivity.this.H1(true);
                    }
                    if (ChatHistorySelectActivity.this.s.getItemCount() > 0) {
                        LinearLayoutManager linearLayoutManager2 = ChatHistorySelectActivity.this.s;
                        linearLayoutManager2.scrollToPosition(linearLayoutManager2.getItemCount() - 1);
                    }
                }
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    public static List<HashMap<String, Object>> J5(List<HashMap<String, Object>> list) {
        Collections.sort(list, new b());
        return list;
    }

    public static /* synthetic */ int x5(ChatHistorySelectActivity chatHistorySelectActivity) {
        int i2 = chatHistorySelectActivity.w + 1;
        chatHistorySelectActivity.w = i2;
        return i2;
    }

    @Override // dc.sa2
    public void A0(CommunMessage communMessage, int i2) {
    }

    @Override // dc.sa2
    public IPeopleInfo C() {
        return this.K == 1 ? this.B : this.z;
    }

    @Override // dc.sa2
    public void C2(CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public boolean E() {
        return false;
    }

    @Override // dc.xb2
    public void E0(CommunMessage communMessage) {
        if (TextUtils.isEmpty(this.y) || communMessage == null) {
            return;
        }
        if (this.y.equals(communMessage.getFrom()) || this.y.equals(communMessage.getTo())) {
            runOnMainThread(new h(communMessage));
        }
    }

    @Override // com.wear.widget.CustomSwipeRefreshLayout.a
    public boolean E2() {
        return !this.C;
    }

    public final void F5() {
        this.L = DaoUtils.getMessageHideDao().getHidesToMap(WearUtils.y.p(), this.K == 1 ? WearUtils.k0(this.A) : this.y);
        G5();
    }

    public final void G5() {
        this.w = 0;
        this.N.add(MessageType.chat);
        this.N.add(MessageType.picture);
        List<CommunMessage> listFindMessageByTypeAndHours = DaoUtils.getCommunMessageDao().findMessageByTypeAndHours(WearUtils.y.p(), this.K == 1 ? WearUtils.k0(this.A) : this.y, this.N, 0, 10);
        if (listFindMessageByTypeAndHours == null) {
            listFindMessageByTypeAndHours = new ArrayList<>();
        }
        if (listFindMessageByTypeAndHours.size() < 10) {
            this.t.setEnabled(false);
        }
        Collections.reverse(listFindMessageByTypeAndHours);
        ArrayList arrayList = new ArrayList();
        for (CommunMessage communMessage : listFindMessageByTypeAndHours) {
            if (communMessage.getSendStatus() == 0) {
                communMessage.setDataBean(communMessage.syncDecryptBean());
                arrayList.add(communMessage);
            }
        }
        this.u.clear();
        this.u.addAll(0, EntityUnSupport.filterMessages(arrayList));
        this.q.notifyDataSetChanged();
        M5();
    }

    @Override // dc.sa2
    public boolean H1(boolean z) {
        View childAt;
        boolean z2 = (this.s.findLastVisibleItemPosition() == this.s.getItemCount() - 1 || this.s.findLastVisibleItemPosition() == this.s.getItemCount()) && ((childAt = this.p.getChildAt(this.s.findLastVisibleItemPosition() - this.s.findFirstVisibleItemPosition())) == null || this.p.getHeight() >= childAt.getBottom());
        if (z) {
            if (this.s.getItemCount() >= 10) {
                if (!this.s.getStackFromEnd()) {
                    this.s.setStackFromEnd(true);
                }
            } else if (this.s.findLastVisibleItemPosition() == -1 || this.s.findFirstVisibleItemPosition() == 0) {
                this.s.setStackFromEnd(false);
            } else if (!z2 || this.s.findLastVisibleItemPosition() <= 0) {
                if (z2) {
                    this.s.setStackFromEnd(false);
                } else if (!this.s.getStackFromEnd()) {
                    this.s.setStackFromEnd(true);
                }
            } else if (!this.s.getStackFromEnd()) {
                this.s.setStackFromEnd(true);
            }
        }
        return z2;
    }

    @Override // dc.sa2
    public View H2(String str) {
        return null;
    }

    @Override // dc.sa2
    public void H3(CommunMessage communMessage, EntityShortVideo entityShortVideo) {
    }

    public final void H5(String str) {
        this.A = getIntent().getStringExtra("roomId");
        Group groupK = ch3.n().k(WearUtils.A0(this.A));
        this.B = groupK;
        if (groupK != null) {
            ch3.n().u();
            this.m.setTitle(getString(R.string.select_chat_history_title));
        } else {
            if (ch3.n().u() == null) {
                ye3.I("wipeMemoryError", "ChatRoomActivity");
            }
            finish();
        }
    }

    @Override // com.wear.widget.CustomSwipeRefreshLayout.a
    public boolean I2(MotionEvent motionEvent) {
        return true;
    }

    public final void I5(String str) {
        Intent intent = getIntent();
        if (WearUtils.e1(str)) {
            str = intent.getStringExtra("userId");
        }
        this.x = str;
        this.y = WearUtils.i0(str);
        User userV = WearUtils.y.v(this.x);
        this.z = userV;
        if (userV == null) {
            return;
        }
        userV.setAddMessage(false);
        this.m.setTitle(getString(R.string.select_chat_history_title));
    }

    @Override // dc.sa2
    public void K() {
    }

    public void K5(String str) {
        MyApplication.v0(null);
        I5(str);
        F5();
    }

    public void L5(String str) {
        MyApplication.v0(null);
        H5(str);
        F5();
    }

    @Override // dc.sa2
    public void M(EntityPattern entityPattern) {
    }

    public final void M5() {
        runOnMainThread(new j());
    }

    public final void N5() {
        int i2 = MyApplication.m0;
        if (i2 == 0) {
            if (MyApplication.l0) {
                this.o.setVisibility(0);
                return;
            } else {
                this.o.setVisibility(8);
                return;
            }
        }
        if (i2 == 2) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    @Override // dc.xb2
    public boolean O3(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(this.y) || str.equals(this.x);
    }

    @Override // dc.sa2
    public void P() {
    }

    @Override // dc.sa2
    public void Q1(HashMap<String, String> map) {
        this.L = map;
    }

    @Override // dc.sa2
    public void R2(int i2, CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public void T0(CommunMessage communMessage) {
    }

    @Override // dc.sa2
    public HashMap<String, GifImageView> U3() {
        return null;
    }

    @Override // dc.ta2
    public void V(CommunMessage communMessage, int i2) {
        if (O.containsKey(communMessage.getId())) {
            O.remove(communMessage.getId());
        } else {
            if (O.size() >= 50) {
                is3.b bVar = new is3.b(this.activity);
                bVar.o(ah4.e(R.string.common_ok));
                bVar.p(getString(R.string.notification_too_many_message));
                bVar.k(R.layout.dialog_default_ok_new);
                bVar.d(new a(this));
                cs3.h(bVar).show();
                return;
            }
            O.put(communMessage.getId(), communMessage);
        }
        this.q.notifyItemChanged(i2, "isSelected");
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
        String str = this.y;
        return str == null ? "" : str;
    }

    @Override // dc.xb2
    public void c0(String str, String str2) {
    }

    @Override // dc.sa2
    public List<CommunMessage> d0() {
        return this.u;
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

    @Override // dc.xb2
    public void notifyDataSetChanged() {
        runOnMainThread(new i());
    }

    @Override // dc.sa2
    public boolean o() {
        return false;
    }

    @Override // dc.ie3.m
    public void o2(File file, String str, String str2, String str3) {
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.wear.BaseActivity, dc.cs3.b
    public void onCancel() {
        super.onCancel();
        ep1.b().m(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(Integer.MIN_VALUE, Integer.MIN_VALUE);
        setContentView(R.layout.long_chat_history_select);
        be3.J();
        setCurrentScreen(this, "long_distance_chat_screen_view", ChatHistorySelectActivity.class.getSimpleName());
        EventBus.getDefault().register(this);
        this.M = new Gson();
        this.K = getIntent().getIntExtra(P, 0);
        O.clear();
        if (WearUtils.L.size() > 0) {
            O.putAll(WearUtils.L);
        }
        findViewById(R.id.screan_root_layout);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.m = myActionBar;
        myActionBar.setBackAction(R.string.common_cancel, new c());
        this.m.setYesAction(R.string.common_done, new d());
        this.m.getYesBtn().setEnabled(true);
        View viewFindViewById = this.m.findViewById(R.id.rl_actionbar_back);
        this.D = viewFindViewById;
        viewFindViewById.setVisibility(0);
        WearUtils.y.u();
        this.G = (ChatEditText) findViewById(R.id.chat_message);
        this.E.w(this, this, findViewById(R.id.chat_emojis_panel), this.G, (EmojisToastView) findViewById(R.id.chat_emojis_tosat_layer));
        e82 e82Var = new e82(this, this, null, this.E);
        this.F = e82Var;
        this.q = new MessageNewSelectAdapter(this.u, this, this, e82Var, this.E);
        this.n = (ImageView) findViewById(R.id.chat_background);
        this.o = findViewById(R.id.v_glass);
        this.p = (RecyclerView) findViewById(R.id.chat_message_list);
        CustomSwipeRefreshLayout customSwipeRefreshLayout = (CustomSwipeRefreshLayout) findViewById(R.id.swipe_refresh_message);
        this.t = customSwipeRefreshLayout;
        customSwipeRefreshLayout.setListener(this);
        this.s = cg3.f(this.p, this.q);
        this.p.addOnScrollListener(new e());
        this.t.setOnRefreshListener(new f());
        this.t.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        if (this.K == 1) {
            L5(null);
        } else {
            K5(null);
        }
    }

    @Override // com.wear.activity.qrcode.QRCodeActivity, com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        this.m.s();
        this.u.clear();
        this.q = null;
        this.p = null;
        System.gc();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ClearChatViewFriendIdEvent clearChatViewFriendIdEvent) {
        String str = this.x;
        if (str == null || !str.equals(clearChatViewFriendIdEvent.clearChatViewFriendId)) {
            return;
        }
        this.u.clear();
        this.v.clear();
        this.q.notifyDataSetChanged();
        G5();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        WearUtils.y.u();
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        if (this.M == null) {
            this.M = new Gson();
        }
        int intExtra = intent.getIntExtra(P, 0);
        this.K = intExtra;
        if (intExtra == 1) {
            K5(intent.getStringExtra("roomId"));
        } else {
            K5(intent.getStringExtra("userId"));
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.wear.xmpp.FragmentStateLossActivity, com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.application.r0(this.x);
        MyApplication.N().q0(this);
        if (this.v.size() > 0) {
            for (CommunMessage communMessage : this.v) {
                communMessage.setDataBean(communMessage.syncDecryptBean());
            }
            for (CommunMessage communMessage2 : this.v) {
                boolean z = false;
                Iterator<CommunMessage> it = this.u.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getId().equals(communMessage2.getId())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z) {
                    this.u.add(communMessage2);
                }
            }
            this.q.notifyDataSetChanged();
            this.v.clear();
        }
        File fileN = !WearUtils.e1(this.x) ? WearUtils.N(WearUtils.y.v(this.x)) : WearUtils.N(this.B);
        if (fileN.exists() && (WearUtils.e1(this.x) ? this.B != null : this.z != null)) {
            ImageLoader.getInstance().loadImage(Uri.fromFile(fileN).toString(), new ImageSize(gg3.e(this), gg3.c(this)), new g());
        } else {
            nz1.e().k(this.n);
            N5();
        }
    }

    @Override // dc.sa2
    public void q() {
    }

    @Override // dc.sa2
    public HashMap<String, String> r() {
        return this.L;
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
