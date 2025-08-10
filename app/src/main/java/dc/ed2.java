package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wear.bean.Account;
import com.wear.bean.MessageHide;
import com.wear.bean.MessageUnRead;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.migrate.MigrateAdapterBean;
import com.wear.bean.migrate.MigrateFileBean;
import com.wear.bean.migrate.MigrateSendMsgsBean;
import com.wear.bean.migrate.MigrateSocketBean;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: MsgServerUtils.java */
/* loaded from: classes3.dex */
public class ed2 extends fd2 {
    public static ed2 J;
    public long A;
    public int B;
    public List<String> C;
    public List<MessageType> D;
    public String E;
    public String F;
    public HashMap<String, String> G;
    public Account H;
    public d I;
    public List<CommunMessage> a;
    public List<CommunMessage> b;
    public List<MigrateAdapterBean> c;
    public List<MigrateFileBean> d;
    public List<MessageUnRead> g;
    public List<MessageHide> h;
    public byte[] i;
    public byte[] j;
    public MigrateSendMsgsBean k;
    public MigrateSendMsgsBean l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public int r;
    public int s;
    public String t;
    public String u;
    public List<IPeopleInfo> v;
    public long w;
    public long x;
    public long y;
    public long z;
    public int e = 0;
    public int f = 0;
    public int q = 100;

    /* compiled from: MsgServerUtils.java */
    public class a implements Observer<Boolean> {
        public a() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Boolean bool) {
            String str = "onNext isSuc: " + bool;
            ed2.this.o = false;
            if (!bool.booleanValue() || ed2.this.p) {
                return;
            }
            ed2.this.K();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    /* compiled from: MsgServerUtils.java */
    public class b implements ObservableOnSubscribe<Boolean> {
        public b() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
            try {
                ed2.this.o = true;
                String str = "getMsgs curGetMsgsIndex: " + ed2.this.e;
                if (ed2.this.B == 0) {
                    ed2 ed2Var = ed2.this;
                    ed2Var.D(ed2Var.e);
                    ed2.this.w();
                    if (ed2.this.s == 1) {
                        ed2.this.q();
                        ed2.this.n();
                    }
                    ed2.this.u(0);
                } else if (ed2.this.B == 1) {
                    ed2.this.E((int) (r0.e - ed2.this.y));
                    ed2.this.u(1);
                } else {
                    ed2.this.C((int) ((r0.e - ed2.this.y) - ed2.this.z));
                    ed2.this.u(2);
                }
                observableEmitter.onNext(Boolean.TRUE);
            } catch (Exception e) {
                e.printStackTrace();
                observableEmitter.onNext(Boolean.FALSE);
            }
        }
    }

    /* compiled from: MsgServerUtils.java */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.pattern.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.audio.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.picture.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.burnpicture.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MessageType.shortvideo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MessageType.burnvideo.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: MsgServerUtils.java */
    public interface d {
        void j();

        void k(byte[] bArr);

        void l();

        void m(String str);
    }

    public static synchronized ed2 x() {
        if (J == null) {
            synchronized (ed2.class) {
                J = new ed2();
            }
        }
        return J;
    }

    public final void A() {
        Observable.create(new b()).subscribeOn(Schedulers.io()).observeOn(Schedulers.trampoline()).subscribe(new a());
    }

    public final void B() {
    }

    public void C(int i) {
        List<MessageHide> list = this.h;
        if (list != null) {
            list.clear();
        } else {
            this.h = new ArrayList();
        }
        this.h.addAll(DaoUtils.getMessageHideDao().findPageMsgs(this.t, this.v, i, this.q));
        if (this.h == null) {
            this.h = new ArrayList();
        }
        this.e += this.h.size();
        String str = "getPageHideMsgs messageHideList.size: " + this.h.size() + ",curGetMsgsIndex:" + this.e;
    }

    public void D(int i) {
        List<CommunMessage> list = this.a;
        if (list != null) {
            list.clear();
        } else {
            this.a = new ArrayList();
        }
        this.a.addAll(DaoUtils.getCommunMessageDao().findPageMsgs(this.t, y(), i, this.q, this.s));
        String str = "getMsgs communMessagePageList.size: " + this.a.size();
    }

    public void E(int i) {
        List<MessageUnRead> list = this.g;
        if (list != null) {
            list.clear();
        } else {
            this.g = new ArrayList();
        }
        this.g.addAll(DaoUtils.getMessageUnReadDao().findPageMsgs(this.t, this.v, i, this.q));
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.e += this.g.size();
        String str = "getPageUnReadMsgs messageUnReadList.size: " + this.g.size() + ",curGetMsgsIndex:" + this.e;
    }

    public int F() {
        return this.f;
    }

    public List<MessageType> G() {
        List<MessageType> list = this.D;
        if (list == null || list.size() <= 0) {
            ArrayList arrayList = new ArrayList();
            this.D = arrayList;
            arrayList.add(MessageType.chat);
            this.D.add(MessageType.pattern);
            this.D.add(MessageType.audio);
            this.D.add(MessageType.picture);
            this.D.add(MessageType.shortvideo);
            this.D.add(MessageType.wishlist);
            this.D.add(MessageType.burnpicture);
            this.D.add(MessageType.giftcard);
            this.D.add(MessageType.burnvideo);
            this.D.add(MessageType.vmsharecard);
        }
        return this.D;
    }

    public String H() {
        return this.u;
    }

    public final MigrateAdapterBean I(CommunMessage communMessage) {
        Account account;
        HashMap<String, String> map;
        MigrateAdapterBean migrateAdapterBean = new MigrateAdapterBean();
        try {
            communMessage.isEncrypt();
            String id = communMessage.getId();
            migrateAdapterBean.setId(id);
            String userId = communMessage.getUserId();
            migrateAdapterBean.setEmail(WearUtils.X(userId));
            String from = communMessage.getFrom();
            migrateAdapterBean.setFrom(from + "/wearable");
            migrateAdapterBean.setTo(communMessage.getTo() + "/wearable");
            MessageType type = communMessage.getType();
            migrateAdapterBean.setType(type.toString());
            String strDecrypt = CommunMessage.decrypt(communMessage.getData());
            if (MessageType.pattern == type) {
                EntityPattern entityPattern = (EntityPattern) WearUtils.A.fromJson(strDecrypt, EntityPattern.class);
                entityPattern.setLocalUrl(nd3.i(entityPattern.getLocalUrl()));
                strDecrypt = WearUtils.A.toJson(entityPattern);
            }
            migrateAdapterBean.setData(strDecrypt);
            long time = communMessage.getCreated().getTime();
            migrateAdapterBean.setCreated(communMessage.getCreated());
            migrateAdapterBean.setError(0);
            int sendStatus = communMessage.getSendStatus();
            migrateAdapterBean.setSend(sendStatus == 0);
            migrateAdapterBean.setRead(DaoUtils.getMessageUnReadDao().findIsUnread(id));
            migrateAdapterBean.setComing(false);
            migrateAdapterBean.setTimeStamp(time);
            migrateAdapterBean.setFriendName(communMessage.getRealFromNickName());
            migrateAdapterBean.setBlock(false);
            migrateAdapterBean.setBlur(DaoUtils.getMessageHideDao().findIsHide(id));
            migrateAdapterBean.setSendType(communMessage.getSendType());
            migrateAdapterBean.setMessageType("");
            if (sendStatus == 4) {
                sendStatus = 7;
            }
            migrateAdapterBean.setSendStatus(sendStatus);
            migrateAdapterBean.setReceiveId(communMessage.getReceiveId());
            String msgId = communMessage.getMsgId();
            migrateAdapterBean.setRoomMsgId(msgId);
            String realFrom = communMessage.getRealFrom();
            if (!WearUtils.e1(realFrom) && !realFrom.endsWith("/wearable")) {
                realFrom = realFrom + "/wearable";
            }
            migrateAdapterBean.setRealFrom(realFrom);
            String realFromPhoto = communMessage.getRealFromPhoto();
            String realFromNickName = communMessage.getRealFromNickName();
            if (!WearUtils.e1(msgId) && from.equals(this.t)) {
                if (WearUtils.e1(realFromPhoto) && (map = this.G) != null) {
                    realFromPhoto = map.get(userId);
                }
                if (WearUtils.e1(realFromNickName) && (account = this.H) != null) {
                    realFromNickName = account.getUserName();
                }
            }
            migrateAdapterBean.setRealFromPhoto(realFromPhoto);
            migrateAdapterBean.setRealFromNickName(realFromNickName);
            migrateAdapterBean.setAtMe(false);
            migrateAdapterBean.setShowEmojiAnim(communMessage.isShowEmojiAnim());
            migrateAdapterBean.setReplyData(communMessage.getReplyData());
            migrateAdapterBean.setStatus(communMessage.getStatus());
            migrateAdapterBean.setV(communMessage.getV());
            migrateAdapterBean.setEncrypt(communMessage.isEncrypt());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return migrateAdapterBean;
    }

    public final void J() {
        d dVar = this.I;
        if (dVar != null) {
            this.p = true;
            if (this.s != 0) {
                dVar.k(this.j);
            } else {
                dVar.k(this.l.getFileBytes());
                this.I.m(this.l.getMsgs());
            }
        }
    }

    public final void K() {
        if (this.s == 0) {
            this.l = (MigrateSendMsgsBean) WearUtils.w(this.k);
        } else {
            this.j = (byte[]) this.i.clone();
        }
        this.n = this.m;
        d dVar = this.I;
        if (dVar != null) {
            this.p = true;
            if (this.s == 0) {
                dVar.k(this.l.getFileBytes());
                this.I.m(this.l.getMsgs());
            } else {
                dVar.k(this.j);
            }
            String str = "sendMsgs curGetMsgsIndex: " + this.e;
            z();
        }
    }

    public final void L() {
        d dVar = this.I;
        if (dVar != null) {
            dVar.j();
        }
    }

    public void M(HashMap<String, String> map) {
        if (map != null) {
            this.G = (HashMap) WearUtils.w(map);
        } else {
            this.G = new HashMap<>();
        }
    }

    public void N(int i) {
        this.s = i;
    }

    public void O(Account account) {
        this.H = account;
    }

    public void P(List<IPeopleInfo> list) {
        this.v = list;
    }

    public void Q(d dVar) {
        this.I = dVar;
    }

    public void R(String str) {
        this.t = str;
    }

    public void S(String str) {
        this.u = str;
    }

    public void T(int i) {
        this.e = i;
        this.f = i;
        this.B = 0;
        this.b = new ArrayList();
        this.d = new ArrayList();
        this.p = false;
        o();
        if (this.f >= this.x) {
            L();
        } else {
            z();
        }
    }

    public void U(int i) {
        this.p = false;
        this.r = 0;
        int i2 = this.f + this.n;
        this.f = i2;
        if (this.o) {
            return;
        }
        if (i2 >= this.x) {
            L();
        } else {
            K();
        }
    }

    public void V() {
        this.p = false;
        int i = this.r + 1;
        this.r = i;
        if (i <= 3) {
            J();
        } else {
            W();
        }
    }

    public final void W() {
        d dVar = this.I;
        if (dVar != null) {
            dVar.l();
        }
    }

    public final String X(List<MigrateFileBean> list) {
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (MigrateFileBean migrateFileBean : list) {
                String localAbsolutePath = migrateFileBean.getLocalAbsolutePath();
                if (this.s == 1) {
                    String localAbsolutePathTemp = migrateFileBean.getLocalAbsolutePathTemp();
                    if (!WearUtils.e1(localAbsolutePathTemp) && new File(localAbsolutePathTemp).exists()) {
                        arrayList.add(localAbsolutePathTemp);
                        localAbsolutePath = localAbsolutePathTemp;
                    }
                }
                arrayList2.add(localAbsolutePath);
            }
            HashSet hashSet = new HashSet(arrayList2);
            arrayList2.clear();
            arrayList2.addAll(hashSet);
            if (arrayList2.size() > 0) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    if (file.exists()) {
                        arrayList3.add(file);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                String str = this.E + File.separator + "z";
                File file2 = new File(str);
                if (file2.exists()) {
                    file2.delete();
                }
                hh3.d(arrayList3, file2);
                if (arrayList.size() > 0) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        File file3 = new File((String) it2.next());
                        if (file3.exists()) {
                            file3.delete();
                        }
                    }
                }
                return str;
            }
        } catch (IOException e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("消息迁移--zipFiles", e));
        }
        if (arrayList.size() <= 0) {
            return "";
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            File file4 = new File((String) it3.next());
            if (file4.exists()) {
                file4.delete();
            }
        }
        return "";
    }

    public final String m(String str, String str2) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            String str3 = this.F + "/" + str2;
            File file2 = new File(str3);
            if (file2.exists()) {
                file2.delete();
            }
            WearUtils.q(file, file2);
            for (MigrateFileBean migrateFileBean : this.d) {
                if (str.equals(migrateFileBean.getLocalAbsolutePath())) {
                    migrateFileBean.setLocalAbsolutePathTemp(str3);
                }
            }
            return str3;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void n() {
        for (MigrateAdapterBean migrateAdapterBean : this.c) {
            String type = migrateAdapterBean.getType();
            type.hashCode();
            switch (type) {
                case "pattern":
                    EntityPattern entityPattern = (EntityPattern) WearUtils.A.fromJson(migrateAdapterBean.getData(), EntityPattern.class);
                    String localUrl = entityPattern.getLocalUrl();
                    if (WearUtils.e1(localUrl)) {
                        break;
                    } else {
                        String strSubstring = localUrl.substring(localUrl.lastIndexOf("/") + 1);
                        if (strSubstring.contains(".")) {
                            break;
                        } else {
                            String strM = m(localUrl, strSubstring + PSOProgramService.LogExt);
                            if (WearUtils.e1(strM)) {
                                break;
                            } else {
                                entityPattern.setLocalUrl(strM);
                                migrateAdapterBean.setData(WearUtils.A.toJson(entityPattern));
                                break;
                            }
                        }
                    }
                case "picture":
                case "burnpicture":
                    EntityPicture entityPicture = (EntityPicture) WearUtils.A.fromJson(migrateAdapterBean.getData(), EntityPicture.class);
                    String localUrl2 = entityPicture.getLocalUrl();
                    if (WearUtils.e1(localUrl2)) {
                        break;
                    } else {
                        File fileC0 = WearUtils.c0(localUrl2);
                        if (!fileC0.exists()) {
                            fileC0 = WearUtils.Z(localUrl2);
                        }
                        if (!fileC0.exists()) {
                            fileC0 = WearUtils.a0(localUrl2);
                        }
                        if (fileC0.exists()) {
                            String strSubstring2 = localUrl2.substring(localUrl2.lastIndexOf("/") + 1);
                            if (strSubstring2.contains(".")) {
                                break;
                            } else {
                                String strM2 = m(fileC0.getAbsolutePath(), strSubstring2 + ".jpg");
                                if (WearUtils.e1(strM2)) {
                                    break;
                                } else {
                                    entityPicture.setLocalUrl(strM2);
                                    migrateAdapterBean.setData(WearUtils.A.toJson(entityPicture));
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                case "audio":
                    EntityAudio entityAudio = (EntityAudio) WearUtils.A.fromJson(migrateAdapterBean.getData(), EntityAudio.class);
                    String localUrl3 = entityAudio.getLocalUrl();
                    if (WearUtils.e1(localUrl3)) {
                        break;
                    } else {
                        String strSubstring3 = localUrl3.substring(localUrl3.lastIndexOf("/") + 1);
                        if (strSubstring3.contains(".")) {
                            break;
                        } else {
                            String strM3 = m(localUrl3, strSubstring3 + ".m4a");
                            if (WearUtils.e1(strM3)) {
                                break;
                            } else {
                                entityAudio.setLocalUrl(strM3);
                                migrateAdapterBean.setData(WearUtils.A.toJson(entityAudio));
                                break;
                            }
                        }
                    }
                case "burnshortvideo":
                case "shortvideo":
                    EntityShortVideo entityShortVideo = (EntityShortVideo) WearUtils.A.fromJson(migrateAdapterBean.getData(), EntityShortVideo.class);
                    String picLocalUrl = entityShortVideo.getPicLocalUrl();
                    if (!WearUtils.e1(picLocalUrl)) {
                        File fileC02 = WearUtils.c0(picLocalUrl);
                        if (fileC02.exists()) {
                            String strSubstring4 = picLocalUrl.substring(picLocalUrl.lastIndexOf("/") + 1);
                            if (!strSubstring4.contains(".")) {
                                String strM4 = m(fileC02.getAbsolutePath(), strSubstring4 + ".jpg");
                                if (!WearUtils.e1(strM4)) {
                                    entityShortVideo.setPicLocalUrl(strM4);
                                    migrateAdapterBean.setData(WearUtils.A.toJson(entityShortVideo));
                                }
                            }
                        }
                    }
                    String videoLocalUrl = entityShortVideo.getVideoLocalUrl();
                    if (WearUtils.e1(videoLocalUrl)) {
                        break;
                    } else {
                        String strSubstring5 = videoLocalUrl.substring(videoLocalUrl.lastIndexOf("/") + 1);
                        if (strSubstring5.contains(".")) {
                            break;
                        } else {
                            String strM5 = m(videoLocalUrl, strSubstring5 + ".mp4");
                            if (WearUtils.e1(strM5)) {
                                break;
                            } else {
                                entityShortVideo.setVideoLocalUrl(strM5);
                                migrateAdapterBean.setData(WearUtils.A.toJson(entityShortVideo));
                                break;
                            }
                        }
                    }
            }
        }
    }

    public final void o() {
        List<String> list = this.C;
        if (list != null) {
            list.clear();
        }
    }

    public void p() {
        if (this.s == 1) {
            this.x = this.w;
        }
    }

    public final void q() {
        List<MigrateAdapterBean> list = this.c;
        if (list == null) {
            this.c = new ArrayList();
        } else {
            list.clear();
        }
        List<CommunMessage> list2 = this.b;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        Iterator<CommunMessage> it = this.b.iterator();
        while (it.hasNext()) {
            this.c.add(I(it.next()));
        }
    }

    public void r() {
        this.E = WearUtils.T("migTemp/server").getAbsolutePath();
        this.F = WearUtils.T("migTemp/server/suffix").getAbsolutePath();
        WearUtils.T("video").getAbsolutePath();
    }

    public long s() {
        this.y = DaoUtils.getCommunMessageDao().findAllMsgsNums(this.v, 0);
        this.z = DaoUtils.getMessageUnReadDao().findUnReadsNums(this.t, this.v);
        this.A = DaoUtils.getMessageHideDao().findHideNums(this.t, this.v);
        this.w = DaoUtils.getCommunMessageDao().findAllMsgsNums(this.v, 1);
        this.x = this.y + this.z + this.A;
        String str = "findAllMsgNums AllMsgNums: " + this.x + ", iosAllMsgNums:" + this.w;
        return this.x;
    }

    public long t() {
        return this.x;
    }

    public final void u(int i) throws IOException {
        String json;
        String strBuildMsgsTc;
        Runtime.getRuntime();
        byte[] bytes = "".getBytes();
        Gson gsonCreate = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss SSS").create();
        if (i == 0) {
            if (this.s == 0) {
                json = gsonCreate.toJson(this.b);
                this.m = this.b.size();
                this.b.clear();
            } else {
                json = gsonCreate.toJson(this.c);
                this.m = this.c.size();
                this.c.clear();
            }
            List<MigrateFileBean> list = this.d;
            if (list != null && list.size() > 0) {
                bytes = v(X(this.d));
                String str = "getBytes byteFiles.length: " + bytes.length;
            }
        } else if (i == 1) {
            json = gsonCreate.toJson(this.g);
            this.m = this.g.size();
            this.g.clear();
        } else {
            json = gsonCreate.toJson(this.h);
            this.m = this.h.size();
            this.h.clear();
        }
        try {
            String strT = nd3.t(json);
            String str2 = "getBytes enMsgs.length: " + strT.length();
            if (this.s == 0) {
                strBuildMsgsTc = MigrateSocketBean.Builder.buildMsgsTc(this.e, strT, "".getBytes(), this.B);
                String str3 = "getBytes strMig.length: " + strBuildMsgsTc.length();
            } else {
                strBuildMsgsTc = MigrateSocketBean.Builder.buildMsgsTc(this.e, strT, bytes, this.B);
                String str4 = "getBytes strMig.length: " + strBuildMsgsTc.length();
                this.i = oe3.b(strBuildMsgsTc, "ISO-8859-1");
                String str5 = "getBytes sendBytes.length: " + this.i.length;
            }
            if (this.s == 0) {
                this.k = new MigrateSendMsgsBean(strBuildMsgsTc, bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("消息迁移--getBytes OutOfMemoryError", e));
        }
    }

    public final byte[] v(String str) throws IOException {
        String str2 = "getFileBytes filePath: " + str;
        if (WearUtils.e1(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return oe3.c(bArr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("消息迁移--getFileBytes", e2));
            return null;
        }
    }

    public final void w() {
        try {
            List<MigrateFileBean> list = this.d;
            if (list == null) {
                this.d = new ArrayList();
            } else {
                list.clear();
            }
            List<CommunMessage> list2 = this.b;
            if (list2 == null) {
                this.b = new ArrayList();
            } else {
                list2.clear();
            }
            for (CommunMessage communMessage : this.a) {
                this.b.add(communMessage);
                this.e++;
                MessageType type = communMessage.getType();
                DataEntityAbstract dataEntityAbstractSyncDecryptBean = communMessage.syncDecryptBean();
                switch (c.a[communMessage.getType().ordinal()]) {
                    case 1:
                        String localUrl = ((EntityPattern) dataEntityAbstractSyncDecryptBean).getLocalUrl();
                        if (!WearUtils.e1(localUrl)) {
                            String strI = nd3.i(localUrl);
                            if (!WearUtils.e1(strI)) {
                                ((EntityPattern) dataEntityAbstractSyncDecryptBean).setLocalUrl(strI);
                                communMessage.setData(CommunMessage.encryp(WearUtils.A.toJson(dataEntityAbstractSyncDecryptBean)));
                            }
                            File file = new File(nd3.i(localUrl));
                            if (file.exists()) {
                                this.d.add(new MigrateFileBean(file.getAbsolutePath(), type));
                                break;
                            }
                        }
                        break;
                    case 2:
                        String localUrl2 = ((EntityAudio) dataEntityAbstractSyncDecryptBean).getLocalUrl();
                        if (!WearUtils.e1(localUrl2) && new File(localUrl2).exists()) {
                            this.d.add(new MigrateFileBean(localUrl2, type));
                            break;
                        }
                        break;
                    case 3:
                    case 4:
                        String localUrl3 = ((EntityPicture) dataEntityAbstractSyncDecryptBean).getLocalUrl();
                        if (!WearUtils.e1(localUrl3)) {
                            File fileC0 = WearUtils.c0(localUrl3);
                            if (!fileC0.exists()) {
                                fileC0 = WearUtils.Z(localUrl3);
                            }
                            if (!fileC0.exists()) {
                                fileC0 = WearUtils.a0(localUrl3);
                            }
                            if (fileC0.exists()) {
                                this.d.add(new MigrateFileBean(fileC0.getAbsolutePath(), type));
                                break;
                            }
                        }
                        break;
                    case 5:
                    case 6:
                        String picLocalUrl = ((EntityShortVideo) dataEntityAbstractSyncDecryptBean).getPicLocalUrl();
                        if (!WearUtils.e1(picLocalUrl)) {
                            File fileC02 = WearUtils.c0(picLocalUrl);
                            if (fileC02.exists()) {
                                this.d.add(new MigrateFileBean(fileC02.getAbsolutePath(), type));
                                break;
                            } else {
                                File file2 = new File(picLocalUrl);
                                if (file2.exists()) {
                                    ((EntityShortVideo) dataEntityAbstractSyncDecryptBean).setPicLocalUrl(picLocalUrl.substring(picLocalUrl.lastIndexOf("/") + 1));
                                    communMessage.sendEntity(dataEntityAbstractSyncDecryptBean);
                                    communMessage.setDataBean(null);
                                    this.d.add(new MigrateFileBean(file2.getAbsolutePath(), type));
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        continue;
                }
                if (this.d.size() >= 5) {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final List<String> y() {
        List<String> list = this.C;
        if (list == null || list.size() == 0) {
            this.C = new ArrayList();
            for (IPeopleInfo iPeopleInfo : this.v) {
                if (iPeopleInfo.isGroup()) {
                    String strK0 = WearUtils.k0(iPeopleInfo.getId());
                    if (!WearUtils.e1(strK0)) {
                        strK0 = nd3.p(strK0);
                    }
                    this.C.add(strK0);
                } else {
                    String strI0 = WearUtils.i0(iPeopleInfo.getId());
                    if (!WearUtils.e1(strI0)) {
                        strI0 = nd3.p(strI0);
                    }
                    this.C.add(strI0);
                }
            }
        }
        return this.C;
    }

    public final void z() {
        if (this.s == 0) {
            int i = this.e;
            long j = i;
            long j2 = this.y;
            if (j < j2) {
                this.B = 0;
            } else if (i >= j2 && i < this.z + j2) {
                this.B = 1;
            } else {
                if (i < j2 + this.z || i >= this.x) {
                    this.B = 99;
                    B();
                    return;
                }
                this.B = 2;
            }
        } else if (this.e >= this.y) {
            this.B = 99;
            B();
            return;
        }
        A();
    }
}
