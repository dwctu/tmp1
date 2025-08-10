package com.wear.main.longDistance;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.User;
import com.wear.bean.VMShareDataBean;
import com.wear.bean.event.ForwardMessageEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.official.OfficialAcount;
import com.wear.dao.DaoUtils;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.EntityVMShareCard;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SearchButton;
import dc.ah4;
import dc.ch3;
import dc.hf3;
import dc.hu3;
import dc.nd3;
import dc.nf3;
import dc.pj3;
import dc.pw2;
import dc.rf3;
import dc.rl1;
import dc.sg3;
import dc.t12;
import dc.tn2;
import dc.ye3;
import dc.zb2;
import dc.zn2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class ForwardMessageActivity extends BaseActivity {
    public SearchButton a;
    public MyActionBar d;
    public ListView e;
    public List<IPeopleInfo> f;
    public rl1 g;
    public VMShareDataBean h;
    public ProgressDialog i;
    public LinearLayout k;
    public LinearLayout l;
    public CommunMessage b = null;
    public Pattern c = null;
    public HashMap<String, IPeopleInfo> j = new HashMap<>();

    public class a implements MyActionBar.f {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(String str) {
            EntityChat entityChat;
            boolean z;
            for (String str2 : ForwardMessageActivity.this.j.keySet()) {
                IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
                if (iPeopleInfoS != null && !iPeopleInfoS.isExit()) {
                    if (WearUtils.e1(str)) {
                        entityChat = null;
                    } else {
                        EntityChat entityChat2 = new EntityChat();
                        entityChat2.setText(str);
                        entityChat = entityChat2;
                    }
                    EntityVMShareCard entityVMShareCard = new EntityVMShareCard();
                    entityVMShareCard.setCallbackUrl(ForwardMessageActivity.this.h.getCallbackUrl());
                    entityVMShareCard.setSubTitle(ForwardMessageActivity.this.h.getSubTitle());
                    entityVMShareCard.setTitle(ForwardMessageActivity.this.h.getTitle());
                    entityVMShareCard.setUrl(ForwardMessageActivity.this.h.getUrl());
                    entityVMShareCard.setCover(ForwardMessageActivity.this.h.getCover());
                    entityVMShareCard.setCallbackAppName(ForwardMessageActivity.this.h.getCallbackAppName());
                    entityVMShareCard.setDesc(ForwardMessageActivity.this.h.getDesc());
                    if (iPeopleInfoS.isGroup()) {
                        ye3.j("Choose chat", "vibemate_share_send_click", "click", "vibemate_share_send", "1", ForwardMessageActivity.this.h.getUrl(), str2, -1L);
                        zb2.O().H0(str2, entityVMShareCard, true, false, null);
                        if (entityChat != null) {
                            zb2.O().H0(str2, entityChat, true, false, null);
                        }
                    } else {
                        User user = (User) iPeopleInfoS;
                        ye3.j("Choose chat", "vibemate_share_send_click", "click", "vibemate_share_send", "0", ForwardMessageActivity.this.h.getUrl(), user.getRemoteAccountId(), -1L);
                        if (user.isDeleteByFriend()) {
                            CommunMessage communMessage = new CommunMessage();
                            communMessage.setFrom(WearUtils.y.p());
                            communMessage.setTo(str2);
                            communMessage.sendEntity(entityVMShareCard);
                            communMessage.setUserId(ch3.n().p());
                            communMessage.setId(WearUtils.E());
                            if (zb2.O().l0(communMessage)) {
                                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                            }
                            hu3.m(communMessage, true);
                            CommunMessage communMessageJ = hu3.j(communMessage);
                            ForwardMessageEvent forwardMessageEvent = new ForwardMessageEvent();
                            forwardMessageEvent.friendId = WearUtils.g0(str2);
                            forwardMessageEvent.userMessage = communMessage;
                            forwardMessageEvent.blockMessage = communMessageJ;
                            EventBus.getDefault().post(forwardMessageEvent);
                            z = true;
                        } else {
                            z = true;
                            hu3.i0(str2, entityVMShareCard, MessageType.vmsharecard, str, "", "", "", "");
                        }
                        if (entityChat != null) {
                            if (user.isDeleteByFriend()) {
                                CommunMessage communMessage2 = new CommunMessage();
                                communMessage2.setFrom(WearUtils.y.p());
                                communMessage2.setTo(str2);
                                communMessage2.sendEntity(entityChat);
                                communMessage2.setId(WearUtils.E());
                                communMessage2.setUserId(ch3.n().p());
                                communMessage2.setRealFrom(null);
                                if (zb2.O().l0(communMessage2)) {
                                    DaoUtils.getCommunMessageDao().updateOrAdd(communMessage2);
                                }
                                hu3.m(communMessage2, z);
                                CommunMessage communMessageJ2 = hu3.j(communMessage2);
                                ForwardMessageEvent forwardMessageEvent2 = new ForwardMessageEvent();
                                forwardMessageEvent2.friendId = WearUtils.g0(str2);
                                forwardMessageEvent2.userMessage = communMessage2;
                                forwardMessageEvent2.blockMessage = communMessageJ2;
                                EventBus.getDefault().post(forwardMessageEvent2);
                            } else {
                                zb2.O().D0(str2, entityChat, MessageType.chat, null, null, null, null, null);
                            }
                        }
                    }
                }
            }
            ForwardMessageActivity.this.finish();
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (ForwardMessageActivity.this.j.entrySet().size() == 0) {
                return;
            }
            if (ForwardMessageActivity.this.b == null) {
                if (ForwardMessageActivity.this.c != null) {
                    ForwardMessageActivity.this.I4();
                    return;
                } else {
                    if (ForwardMessageActivity.this.h != null) {
                        ArrayList arrayList = new ArrayList(ForwardMessageActivity.this.j.values());
                        ForwardMessageActivity forwardMessageActivity = ForwardMessageActivity.this;
                        new pw2(forwardMessageActivity, arrayList, forwardMessageActivity.h, new pw2.a() { // from class: dc.e62
                            @Override // dc.pw2.a
                            public final void a(String str) {
                                this.a.b(str);
                            }
                        }).show();
                        return;
                    }
                    return;
                }
            }
            int i = h.a[ForwardMessageActivity.this.b.getType().ordinal()];
            if (i == 1 || i == 2) {
                ForwardMessageActivity.this.H4(true);
                return;
            }
            if (i == 3) {
                ForwardMessageActivity.this.H4(false);
            } else if (i == 4) {
                ForwardMessageActivity.this.J4();
            } else {
                if (i != 5) {
                    return;
                }
                ForwardMessageActivity.this.L4();
            }
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ForwardMessageActivity.this.finish();
        }
    }

    public class c implements SearchButton.e {
        public c() {
        }

        @Override // com.wear.widget.SearchButton.e
        public void p3(String str) {
            ForwardMessageActivity.this.g.b(str);
            ForwardMessageActivity.this.P4(str);
            ForwardMessageActivity.this.notifyDataSetChanged();
        }
    }

    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            IPeopleInfo iPeopleInfoA = ForwardMessageActivity.this.g.getItem(i);
            if (ForwardMessageActivity.this.j.containsKey(iPeopleInfoA.getUserJid())) {
                ForwardMessageActivity.this.j.remove(iPeopleInfoA.getUserJid());
            } else {
                if (ForwardMessageActivity.this.b != null && ForwardMessageActivity.this.b.getType() == MessageType.giftcard && ForwardMessageActivity.this.j.size() > 0) {
                    ForwardMessageActivity.this.j.clear();
                }
                ForwardMessageActivity.this.j.put(iPeopleInfoA.getUserJid(), iPeopleInfoA);
            }
            ForwardMessageActivity.this.O4();
            ForwardMessageActivity.this.notifyDataSetChanged();
        }
    }

    public class e implements nf3.d {

        public class a implements zn2<String> {
            public final /* synthetic */ File a;

            public a(File file) {
                this.a = file;
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                EntityPattern entityPattern;
                if (WearUtils.e1(str)) {
                    ForwardMessageActivity.this.G4();
                    sg3.h(R.string.forward_failed);
                    return;
                }
                NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
                if (normalResponse == null) {
                    ForwardMessageActivity.this.G4();
                    sg3.h(R.string.forward_failed);
                    return;
                }
                if (!normalResponse.isResult() || WearUtils.e1(normalResponse.getMessage())) {
                    ForwardMessageActivity.this.G4();
                    sg3.h(R.string.forward_failed);
                    return;
                }
                String message = normalResponse.getMessage();
                String timer = ForwardMessageActivity.this.c.getTimer();
                String name = ForwardMessageActivity.this.c.getName();
                if (WearUtils.e1(name)) {
                    name = ah4.e(R.string.chat_pattern_by_create_default_name);
                }
                String toyTag = ForwardMessageActivity.this.c.getToyTag();
                String id = ForwardMessageActivity.this.c.getId();
                ForwardMessageActivity.this.addAnalyticsEventId("chat_pattern", null);
                EntityPattern entityPattern2 = new EntityPattern();
                entityPattern2.setFeature(toyTag);
                entityPattern2.setUrl(message);
                entityPattern2.setLocalUrl(nd3.u(this.a.getPath()));
                entityPattern2.setTime(CommunMessage.getTimeToSecond(timer));
                entityPattern2.setName(WearUtils.e1(name) ? ah4.e(R.string.chat_pattern_by_create_default_name) : name);
                for (String str2 : ForwardMessageActivity.this.j.keySet()) {
                    IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(str2));
                    if (iPeopleInfoS != null && !iPeopleInfoS.isExit()) {
                        if (iPeopleInfoS.isGroup()) {
                            zb2.O().H0(str2, entityPattern2, true, false, null);
                        } else if (((User) iPeopleInfoS).isDeleteByFriend()) {
                            CommunMessage communMessage = new CommunMessage();
                            communMessage.setFrom(WearUtils.y.p());
                            communMessage.setTo(str2);
                            communMessage.sendEntity(entityPattern2);
                            communMessage.setUserId(ch3.n().p());
                            communMessage.setId(WearUtils.E());
                            if (zb2.O().l0(communMessage)) {
                                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                            }
                            hu3.m(communMessage, true);
                            CommunMessage communMessageJ = hu3.j(communMessage);
                            ForwardMessageEvent forwardMessageEvent = new ForwardMessageEvent();
                            forwardMessageEvent.friendId = WearUtils.g0(str2);
                            forwardMessageEvent.userMessage = communMessage;
                            forwardMessageEvent.blockMessage = communMessageJ;
                            EventBus.getDefault().post(forwardMessageEvent);
                        } else {
                            entityPattern = entityPattern2;
                            hu3.i0(str2, entityPattern2, MessageType.pattern, name, message, timer, toyTag, id);
                            entityPattern2 = entityPattern;
                        }
                        entityPattern = entityPattern2;
                        entityPattern2 = entityPattern;
                    }
                }
                ForwardMessageActivity.this.G4();
                sg3.h(R.string.forward_successfully);
                ForwardMessageActivity.this.finish();
            }

            @Override // dc.zn2
            public void onError(NetException netException) {
                ForwardMessageActivity.this.G4();
                sg3.l(netException.getMessage());
            }
        }

        public e() {
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) throws IOException {
            if (WearUtils.e1(str)) {
                ForwardMessageActivity.this.G4();
                sg3.h(R.string.forward_failed);
                return;
            }
            if (rf3.o(str)) {
                str = rf3.r(str);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cache/");
            sb.append(!WearUtils.e1(ForwardMessageActivity.this.c.getId()) ? ForwardMessageActivity.this.c.getId() : WearUtils.E());
            String string = sb.toString();
            WearUtils.h2(str, string, false);
            File fileE0 = WearUtils.e0(string);
            if (fileE0 == null || !fileE0.exists()) {
                return;
            }
            tn2.x(WearUtils.x).A("/wear/chat/saveFile/pattern", fileE0, new HashMap(), new a(fileE0));
        }
    }

    public class f extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ EntityPicture b;

        public f(String str, EntityPicture entityPicture) {
            this.a = str;
            this.b = entityPicture;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            File file = ImageLoader.getInstance().getDiskCache().get(this.a);
            if (file.exists()) {
                ForwardMessageActivity.this.Q4(file, this.b.getType(), this.b.getFileMd5());
            } else {
                ForwardMessageActivity.this.G4();
                sg3.i(ForwardMessageActivity.this, R.string.forward_failed);
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ForwardMessageActivity.this.G4();
            sg3.i(ForwardMessageActivity.this, R.string.forward_failed);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class g implements zn2<String> {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ForwardMessageActivity.this.G4();
                if (WearUtils.e1(this.a)) {
                    ForwardMessageActivity.this.G4();
                    sg3.i(ForwardMessageActivity.this, R.string.forward_failed);
                    return;
                }
                NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(this.a, NormalResponse.class);
                if (!normalResponse.isResult()) {
                    ForwardMessageActivity.this.G4();
                    sg3.i(ForwardMessageActivity.this, R.string.forward_failed);
                    return;
                }
                EntityPicture entityPicture = new EntityPicture();
                entityPicture.setUrl(normalResponse.getMessage());
                entityPicture.setH(g.this.a.getHeight());
                entityPicture.setW(g.this.a.getWidth());
                entityPicture.setType(g.this.b);
                entityPicture.setFileMd5(g.this.c);
                for (String str : ForwardMessageActivity.this.j.keySet()) {
                    IPeopleInfo iPeopleInfo = ForwardMessageActivity.this.j.get(str);
                    if (iPeopleInfo != null && !iPeopleInfo.isExit()) {
                        if (iPeopleInfo.isGroup()) {
                            zb2.O().H0(str, entityPicture, true, false, null);
                        } else if (((User) iPeopleInfo).isDeleteByFriend()) {
                            CommunMessage communMessage = new CommunMessage();
                            communMessage.setFrom(WearUtils.y.p());
                            communMessage.setTo(str);
                            communMessage.sendEntity(entityPicture);
                            communMessage.setUserId(ch3.n().p());
                            communMessage.setId(WearUtils.E());
                            if (zb2.O().l0(communMessage)) {
                                DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                            }
                            hu3.m(communMessage, true);
                            CommunMessage communMessageJ = hu3.j(communMessage);
                            ForwardMessageEvent forwardMessageEvent = new ForwardMessageEvent();
                            forwardMessageEvent.friendId = WearUtils.g0(str);
                            forwardMessageEvent.userMessage = communMessage;
                            forwardMessageEvent.blockMessage = communMessageJ;
                            EventBus.getDefault().post(forwardMessageEvent);
                        } else {
                            zb2.O().D0(str, entityPicture, MessageType.picture, null, normalResponse.getMessage() + "?h=" + g.this.a.getHeight() + "&w=" + g.this.a.getWidth(), null, null, null);
                        }
                    }
                }
                ForwardMessageActivity.this.G4();
                if (!MyApplication.P || hu3.x() == null) {
                    sg3.h(R.string.forward_failed);
                } else {
                    sg3.h(R.string.forward_successfully);
                }
                ForwardMessageActivity.this.finish();
            }
        }

        public g(Bitmap bitmap, String str, String str2) {
            this.a = bitmap;
            this.b = str;
            this.c = str2;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            ForwardMessageActivity.this.runOnUiThread(new a(str));
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ForwardMessageActivity.this.G4();
            sg3.k(ForwardMessageActivity.this, netException.getMessage());
        }
    }

    public static /* synthetic */ class h {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.giftcard.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.wishlist.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.chat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.picture.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MessageType.shortvideo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public final void G4() {
        try {
            ProgressDialog progressDialog = this.i;
            if (progressDialog != null) {
                if (progressDialog.isShowing()) {
                    Context baseContext = ((ContextWrapper) this.i.getContext()).getBaseContext();
                    if (!(baseContext instanceof Activity)) {
                        this.i.dismiss();
                    } else if (!((Activity) baseContext).isFinishing() && !((Activity) baseContext).isDestroyed()) {
                        this.i.dismiss();
                    }
                }
                this.i = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void H4(boolean z) {
        DataEntityAbstract dataEntityAbstract;
        DataEntityAbstract dataBean = this.b.getDataBean();
        if (z) {
            dataEntityAbstract = dataBean;
        } else {
            String text = ((EntityChat) dataBean).getText();
            EntityChat entityChat = new EntityChat();
            entityChat.setText(text);
            dataEntityAbstract = entityChat;
        }
        for (String str : this.j.keySet()) {
            IPeopleInfo iPeopleInfo = this.j.get(str);
            if (iPeopleInfo != null && !iPeopleInfo.isExit()) {
                if (iPeopleInfo.isGroup()) {
                    zb2.O().H0(str, dataBean, true, false, null);
                    N4(dataBean.getEntityType(), iPeopleInfo);
                } else if (((User) iPeopleInfo).isDeleteByFriend()) {
                    CommunMessage communMessage = new CommunMessage();
                    communMessage.setFrom(WearUtils.y.p());
                    communMessage.setTo(str);
                    communMessage.sendEntity(dataEntityAbstract);
                    communMessage.setId(WearUtils.E());
                    communMessage.setUserId(ch3.n().p());
                    communMessage.setRealFrom(null);
                    if (zb2.O().l0(communMessage)) {
                        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                    }
                    hu3.m(communMessage, true);
                    CommunMessage communMessageJ = hu3.j(communMessage);
                    ForwardMessageEvent forwardMessageEvent = new ForwardMessageEvent();
                    forwardMessageEvent.friendId = WearUtils.g0(str);
                    forwardMessageEvent.userMessage = communMessage;
                    forwardMessageEvent.blockMessage = communMessageJ;
                    EventBus.getDefault().post(forwardMessageEvent);
                } else {
                    zb2.O().D0(str, dataEntityAbstract, MessageType.chat, null, null, null, null, null);
                    N4(dataBean.getEntityType(), iPeopleInfo);
                }
            }
        }
        if (!MyApplication.P || hu3.x() == null) {
            sg3.h(R.string.forward_failed);
        } else {
            sg3.h(R.string.forward_successfully);
        }
        if (z) {
            ye3.d("M0007", "");
        }
        finish();
    }

    public final void I4() {
        this.i = ProgressDialog.show(this, "", ah4.e(R.string.common_loading), true, true);
        nf3.b(this.c.getCdnPath(), new e());
    }

    public final void J4() {
        EntityPicture entityPicture = (EntityPicture) this.b.getDataBean();
        if (!WearUtils.e1(entityPicture.getLocalUrl())) {
            File file = new File(entityPicture.getLocalUrl());
            if (file.exists()) {
                this.i = ProgressDialog.show(this, "", ah4.e(R.string.common_loading), true, true);
                Q4(file, entityPicture.getType(), entityPicture.getFileMd5());
                return;
            }
        }
        if (WearUtils.e1(entityPicture.getUrl())) {
            sg3.i(this, R.string.chat_message_item_save_error);
            return;
        }
        String str = WearUtils.e + entityPicture.getUrl().replace("thum_", "");
        File file2 = ImageLoader.getInstance().getDiskCache().get(str);
        this.i = ProgressDialog.show(this, "", ah4.e(R.string.common_loading), true, true);
        if (file2.exists()) {
            Q4(file2, entityPicture.getType(), entityPicture.getFileMd5());
        } else {
            ImageLoader.getInstance().displayImage(str, new ImageView(this), MyApplication.Y, new f(str, entityPicture));
        }
    }

    public final void K4(EntityShortVideo entityShortVideo) {
        for (String str : this.j.keySet()) {
            IPeopleInfo iPeopleInfo = this.j.get(str);
            if (iPeopleInfo != null && !iPeopleInfo.isExit()) {
                if (iPeopleInfo.isGroup()) {
                    zb2.O().H0(str, entityShortVideo, true, false, null);
                } else if (((User) iPeopleInfo).isDeleteByFriend()) {
                    CommunMessage communMessage = new CommunMessage();
                    communMessage.setFrom(WearUtils.y.p());
                    communMessage.setTo(str);
                    communMessage.sendEntity(entityShortVideo);
                    communMessage.setUserId(ch3.n().p());
                    communMessage.setId(WearUtils.E());
                    if (zb2.O().l0(communMessage)) {
                        DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
                    }
                    hu3.m(communMessage, true);
                    CommunMessage communMessageJ = hu3.j(communMessage);
                    ForwardMessageEvent forwardMessageEvent = new ForwardMessageEvent();
                    forwardMessageEvent.friendId = WearUtils.g0(str);
                    forwardMessageEvent.userMessage = communMessage;
                    forwardMessageEvent.blockMessage = communMessageJ;
                    EventBus.getDefault().post(forwardMessageEvent);
                } else {
                    zb2.O().D0(str, entityShortVideo, MessageType.shortvideo, null, entityShortVideo.getVideoUrl(), null, null, null);
                }
            }
        }
        G4();
        if (!MyApplication.P || hu3.x() == null) {
            sg3.h(R.string.forward_failed);
        } else {
            sg3.h(R.string.forward_successfully);
        }
        finish();
    }

    public final void L4() {
        EntityShortVideo entityShortVideo = (EntityShortVideo) this.b.getDataBean();
        if (!hf3.d(this)) {
            sg3.i(this, R.string.common_settingTip);
            return;
        }
        if (!MyApplication.P || hu3.x() == null) {
            sg3.i(this, R.string.message_send_error);
        } else if (WearUtils.e1(entityShortVideo.getVideoUrl())) {
            sg3.i(this, R.string.chat_message_item_save_error);
        } else {
            this.i = ProgressDialog.show(this, "", ah4.e(R.string.common_loading), true, true);
            K4(entityShortVideo);
        }
    }

    public final void M4() {
    }

    public final void N4(MessageType messageType, IPeopleInfo iPeopleInfo) {
        if (messageType == MessageType.giftcard) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isFinishToLongDistance", true);
            if (iPeopleInfo.isGroup()) {
                bundle.putString("roomId", iPeopleInfo.getId());
                pj3.g(this, ChatRoomActivity.class, bundle);
            } else {
                bundle.putString("userId", iPeopleInfo.getId());
                pj3.g(this, ChatActivity.class, bundle);
            }
            HashMap map = new HashMap();
            map.put("type", "friends");
            ye3.d("M0014", WearUtils.A.toJson(map));
        }
    }

    public final void O4() {
        if (this.j.entrySet().size() == 0) {
            this.d.getYesBtn().setEnabled(false);
        } else {
            this.d.getYesBtn().setEnabled(true);
        }
    }

    public final void P4(String str) {
        this.f.clear();
        for (IPeopleInfo iPeopleInfo : WearUtils.y.h().values()) {
            if (!iPeopleInfo.isExit() && (TextUtils.isEmpty(str) || iPeopleInfo.showBykey(str))) {
                if (!(iPeopleInfo instanceof OfficialAcount) && iPeopleInfo.isShowInFriendsList() && !iPeopleInfo.isDateIng()) {
                    this.f.add(iPeopleInfo);
                }
            }
        }
        Collections.sort(this.f, new t12());
    }

    public final void Q4(File file, String str, String str2) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile != null) {
            M4();
            HashMap map = new HashMap();
            map.put(PSOProgramService.VS_Key, "1");
            tn2.x(WearUtils.x).A("/wear/chat/sendPic", file, map, new g(bitmapDecodeFile, str, str2));
        }
    }

    public final void notifyDataSetChanged() {
        this.g.notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.long_forward_message);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.d = myActionBar;
        myActionBar.setTitle(ah4.e(R.string.activity_forward));
        this.d.setYesAction(R.string.common_send, new a());
        this.d.setBackAction(new b());
        this.d.getYesBtn().setEnabled(false);
        this.b = (CommunMessage) getIntent().getExtras().getSerializable("choose_message");
        this.c = (Pattern) getIntent().getExtras().getSerializable("choose_pattern");
        VMShareDataBean vMShareDataBean = (VMShareDataBean) getIntent().getExtras().getSerializable("vshare_data");
        this.h = vMShareDataBean;
        if (vMShareDataBean != null) {
            ye3.j("Choose chat", "choose_chat_page_exposure", "exposure", "choose_chat_page", "", "1", "", -1L);
        }
        SearchButton searchButton = (SearchButton) findViewById(R.id.sb_search);
        this.a = searchButton;
        searchButton.setListener(new c());
        ListView listView = (ListView) findViewById(R.id.chat_list);
        this.e = listView;
        listView.setSelector(new ColorDrawable(0));
        this.k = (LinearLayout) findViewById(R.id.user_data_layout);
        this.l = (LinearLayout) findViewById(R.id.no_data_layout);
        this.f = new ArrayList();
        P4("");
        List<IPeopleInfo> list = this.f;
        if (list == null || list.size() == 0) {
            this.l.setVisibility(0);
            this.k.setVisibility(8);
        } else {
            this.l.setVisibility(8);
            this.k.setVisibility(0);
        }
        rl1 rl1Var = new rl1(this, this.j, this.f);
        this.g = rl1Var;
        this.e.setAdapter((ListAdapter) rl1Var);
        this.e.setOnItemClickListener(new d());
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.b();
    }
}
