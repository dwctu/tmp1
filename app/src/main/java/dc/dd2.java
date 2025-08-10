package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.wear.bean.MessageHideMig;
import com.wear.bean.MessageUnReadMig;
import com.wear.bean.migrate.MigrateAdapterBean;
import com.wear.bean.migrate.MigrateMsgsTsBean;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.CommunMessageMig;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityBurnPicture;
import com.wear.protocol.EntityBurnShortVideo;
import com.wear.protocol.EntityPattern;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: MsgClientUtils.java */
/* loaded from: classes3.dex */
public class dd2 extends fd2 {
    public static dd2 r = null;
    public static boolean s = false;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public String j;
    public String o;
    public Disposable p;
    public l q;
    public int a = 0;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;

    /* compiled from: MsgClientUtils.java */
    public class a implements Observer<Long> {
        public a() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Long l) {
            dd2.this.L();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            dd2.this.p = disposable;
        }
    }

    /* compiled from: MsgClientUtils.java */
    public static /* synthetic */ class b {
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

    /* compiled from: MsgClientUtils.java */
    public class c implements Observer<Boolean> {
        public c() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Boolean bool) {
            String str = "receiveMsgs onNext isSuc: " + bool;
            if (dd2.this.h != 1) {
                dd2.this.m = bool.booleanValue();
                dd2.this.k = false;
                if (dd2.this.q != null && bool.booleanValue() && !dd2.this.l) {
                    dd2.this.q.B(new MigrateMsgsTsBean(dd2.this.f, dd2.this.m & dd2.this.n, dd2.this.g));
                }
            } else if (dd2.this.q != null && bool.booleanValue()) {
                dd2.this.q.B(new MigrateMsgsTsBean(dd2.this.f, bool.booleanValue(), dd2.this.g));
            }
            if (!bool.booleanValue()) {
                throw new RuntimeException("消息处理异常");
            }
            if (dd2.this.h == 1) {
                dd2.this.i = false;
            }
            if (dd2.this.h != 1 || dd2.this.q == null) {
                return;
            }
            dd2.this.q.E(bool.booleanValue());
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

    /* compiled from: MsgClientUtils.java */
    public class d implements ObservableOnSubscribe<Boolean> {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ int d;

        public d(String str, int i, byte[] bArr, int i2) {
            this.a = str;
            this.b = i;
            this.c = bArr;
            this.d = i2;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
            try {
                if (dd2.this.h == 1) {
                    dd2.this.i = true;
                } else {
                    dd2.this.k = true;
                }
                String strH = nd3.h(this.a);
                if (dd2.this.h == 0) {
                    if (this.b == 0) {
                        dd2.this.U(this.c);
                    }
                    dd2.this.T(strH, this.b);
                } else {
                    dd2.this.f = this.d;
                    dd2.this.U(this.c);
                    dd2.this.V(strH);
                }
                observableEmitter.onNext(Boolean.TRUE);
            } catch (Exception e) {
                e.printStackTrace();
                observableEmitter.onNext(Boolean.FALSE);
            }
        }
    }

    /* compiled from: MsgClientUtils.java */
    public class e implements Observer<Boolean> {
        public e() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Boolean bool) {
            String str = "receiveFiles onNext isSuc: " + bool;
            dd2.this.n = bool.booleanValue();
            dd2.this.l = false;
            if (dd2.this.q != null && bool.booleanValue() && !dd2.this.k) {
                dd2.this.q.B(new MigrateMsgsTsBean(dd2.this.f, dd2.this.m & dd2.this.n, dd2.this.g));
            }
            if (!bool.booleanValue()) {
                throw new RuntimeException("消息处理异常");
            }
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

    /* compiled from: MsgClientUtils.java */
    public class f implements ObservableOnSubscribe<Boolean> {
        public final /* synthetic */ byte[] a;

        public f(byte[] bArr) {
            this.a = bArr;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
            try {
                if (dd2.this.h == 0) {
                    dd2.this.l = true;
                    dd2.this.U(this.a);
                }
                observableEmitter.onNext(Boolean.TRUE);
            } catch (Exception e) {
                e.printStackTrace();
                observableEmitter.onNext(Boolean.FALSE);
            }
        }
    }

    /* compiled from: MsgClientUtils.java */
    public class g extends TypeToken<List<CommunMessageMig>> {
        public g(dd2 dd2Var) {
        }
    }

    /* compiled from: MsgClientUtils.java */
    public class h extends TypeToken<List<MessageUnReadMig>> {
        public h(dd2 dd2Var) {
        }
    }

    /* compiled from: MsgClientUtils.java */
    public class i extends TypeToken<List<MessageHideMig>> {
        public i(dd2 dd2Var) {
        }
    }

    /* compiled from: MsgClientUtils.java */
    public class j extends TypeToken<List<MigrateAdapterBean>> {
        public j(dd2 dd2Var) {
        }
    }

    /* compiled from: MsgClientUtils.java */
    public class k implements Runnable {
        public final /* synthetic */ boolean a;

        public k(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            try {
                if (dd2.s) {
                    return;
                }
                boolean unused = dd2.s = true;
                if (!this.a) {
                    Thread.sleep(10000L);
                }
                String value = DaoUtils.getTestValueDao().getValue(TestValueDao.CHAT_MIGRATE_KEY, TestValueDao.CHAT_MIGRATE_TYPE);
                if ("1".equals(value)) {
                    dd2.this.N();
                } else if ("2".equals(value)) {
                    dd2.this.M();
                } else {
                    dd2.this.A();
                }
                boolean unused2 = dd2.s = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: MsgClientUtils.java */
    public interface l {
        void A(String str);

        void B(MigrateMsgsTsBean migrateMsgsTsBean);

        void C(boolean z);

        void D(boolean z);

        void E(boolean z);
    }

    public static synchronized dd2 F() {
        if (r == null) {
            synchronized (dd2.class) {
                r = new dd2();
            }
        }
        return r;
    }

    public final void A() {
        if (WearUtils.e1(this.o)) {
            I();
        }
        a(this.o);
    }

    public void B() {
        this.o = WearUtils.T("migTemp/client").getAbsolutePath();
        WearUtils.T("mic");
        WearUtils.T("video");
    }

    public boolean C(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        boolean zC = true;
        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
            if (fileArrListFiles[i2].isFile()) {
                zC = D(fileArrListFiles[i2].getAbsolutePath());
                if (!zC) {
                    break;
                }
            } else {
                zC = C(fileArrListFiles[i2].getAbsolutePath());
                if (!zC) {
                    break;
                }
            }
        }
        if (zC) {
            return file.delete();
        }
        return false;
    }

    public boolean D(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public int E() {
        return this.a;
    }

    public int G() {
        return this.f;
    }

    public int H() {
        return this.g;
    }

    public String I() {
        if (WearUtils.e1(this.o)) {
            this.o = WearUtils.T("migTemp/client").getAbsolutePath();
        }
        return this.o;
    }

    public int J() {
        return this.b;
    }

    public int K() {
        return this.h;
    }

    public final void L() {
        float f2 = (this.e + 0.0f) / (this.d + 0.0f);
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        String str = (Math.round(f2 * 1000.0f) / 10.0f) + "%";
        String str2 = "getUnzipProgress progress: " + str;
        l lVar = this.q;
        if (lVar != null) {
            lVar.A(str);
        }
    }

    public final void M() {
        A();
        z();
        e0(false);
    }

    public final void N() {
        try {
            this.e = 0;
            d0();
            b0();
            A();
            df3.e().i();
            e0(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void O() {
        this.a = 0;
        this.j = "";
    }

    public boolean P() {
        String value = DaoUtils.getTestValueDao().getValue(TestValueDao.CHAT_MIGRATE_KEY, TestValueDao.CHAT_MIGRATE_TYPE);
        if (!"1".equals(value) && !"2".equals(value)) {
            return false;
        }
        y(true);
        return true;
    }

    public boolean Q() {
        return this.i;
    }

    public void R(byte[] bArr) {
        Observable.create(new f(bArr)).subscribeOn(Schedulers.io()).observeOn(Schedulers.trampoline()).subscribe(new e());
    }

    public void S(int i2, String str, byte[] bArr, int i3) {
        Observable.create(new d(str, i3, bArr, i2)).subscribeOn(Schedulers.io()).observeOn(Schedulers.trampoline()).subscribe(new c());
    }

    public void T(String str, int i2) {
        if (WearUtils.e1(str)) {
            return;
        }
        Gson gsonCreate = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss SSS").create();
        if (i2 == 0) {
            List<CommunMessageMig> list = (List) gsonCreate.fromJson(str, new g(this).getType());
            if (list == null || list.size() <= 0) {
                return;
            }
            String str2 = "saveMsg listComMigs.size: " + list.size();
            DaoUtils.getCommunMessageMigDao().add(list);
            this.a += list.size();
            return;
        }
        if (i2 == 1) {
            List<MessageUnReadMig> list2 = (List) gsonCreate.fromJson(str, new h(this).getType());
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            String str3 = "saveMsg listUnreadMigs.size: " + list2.size();
            DaoUtils.getMessageUnReadMigDao().add(list2);
            this.a += list2.size();
            return;
        }
        List<MessageHideMig> list3 = (List) gsonCreate.fromJson(str, new i(this).getType());
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        String str4 = "saveMsg listHideMigs.size: " + list3.size();
        DaoUtils.getMessageHideMigDao().add(list3);
        this.a += list3.size();
    }

    public void U(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            byte[] bArrD = oe3.d(bArr);
            File file = new File(this.o + File.separator + WearUtils.E() + "mzp");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            new BufferedOutputStream(fileOutputStream).write(bArrD);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("消息迁移--saveMsgFile", e2));
        }
    }

    public void V(String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        List list = (List) new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss SSS").create().fromJson(str, new j(this).getType());
        if (list == null || list.size() <= 0) {
            this.g = 0;
            return;
        }
        this.g = list.size();
        String str2 = "saveMsg listComMigs.size: " + list.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w((MigrateAdapterBean) it.next());
        }
    }

    public void W(l lVar) {
        this.q = lVar;
    }

    public void X(int i2) {
        this.b = i2;
    }

    public void Y(boolean z) {
        this.i = z;
    }

    public void Z(int i2) {
        this.h = i2;
    }

    public boolean a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile() ? D(str) : C(str);
        }
        return false;
    }

    public final void a0() {
        x();
        Observable.interval(0L, 500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public final void b0() {
        while (true) {
            try {
                List<CommunMessageMig> listFindPageMsgs = DaoUtils.getCommunMessageMigDao().findPageMsgs(0, 100);
                if (listFindPageMsgs != null && listFindPageMsgs.size() > 0) {
                    for (CommunMessageMig communMessageMig : listFindPageMsgs) {
                        switch (b.a[communMessageMig.getType().ordinal()]) {
                            case 1:
                                EntityPattern entityPattern = (EntityPattern) communMessageMig.syncDecryptBean();
                                String localUrl = entityPattern.getLocalUrl();
                                if (WearUtils.e1(localUrl)) {
                                    break;
                                } else {
                                    String strU = nd3.u(localUrl);
                                    if (!WearUtils.e1(strU)) {
                                        entityPattern.setLocalUrl(strU);
                                        communMessageMig.sendEntity(entityPattern);
                                    }
                                    File file = new File(localUrl);
                                    if (file.exists()) {
                                        break;
                                    } else {
                                        String strSubstring = localUrl.substring(localUrl.lastIndexOf("/") + 1);
                                        if (WearUtils.e1(strSubstring)) {
                                            break;
                                        } else {
                                            File file2 = new File(this.o + "/" + strSubstring);
                                            if (file2.exists()) {
                                                WearUtils.q(file2, file);
                                                file2.delete();
                                                break;
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }
                            case 2:
                                String localUrl2 = ((EntityAudio) communMessageMig.syncDecryptBean()).getLocalUrl();
                                if (WearUtils.e1(localUrl2)) {
                                    break;
                                } else {
                                    File file3 = new File(localUrl2);
                                    if (file3.exists()) {
                                        break;
                                    } else {
                                        String strSubstring2 = localUrl2.substring(localUrl2.lastIndexOf("/") + 1);
                                        if (WearUtils.e1(strSubstring2)) {
                                            break;
                                        } else {
                                            File file4 = new File(this.o + "/" + strSubstring2);
                                            if (file4.exists()) {
                                                WearUtils.q(file4, file3);
                                                file4.delete();
                                                break;
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }
                            case 3:
                            case 4:
                                String localUrl3 = ((EntityPicture) communMessageMig.syncDecryptBean()).getLocalUrl();
                                if (WearUtils.e1(localUrl3)) {
                                    break;
                                } else {
                                    File fileZ = WearUtils.Z(localUrl3);
                                    if (!fileZ.exists()) {
                                        fileZ = WearUtils.a0(localUrl3);
                                    }
                                    if (!fileZ.exists()) {
                                        fileZ = WearUtils.c0(localUrl3);
                                    }
                                    if (fileZ.exists()) {
                                        break;
                                    } else {
                                        String strSubstring3 = localUrl3.substring(localUrl3.lastIndexOf("/") + 1);
                                        if (WearUtils.e1(strSubstring3)) {
                                            break;
                                        } else {
                                            File file5 = new File(this.o + "/" + strSubstring3);
                                            if (file5.exists()) {
                                                WearUtils.q(file5, fileZ);
                                                file5.delete();
                                                break;
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }
                            case 5:
                            case 6:
                                EntityShortVideo entityShortVideo = (EntityShortVideo) communMessageMig.syncDecryptBean();
                                String picLocalUrl = entityShortVideo.getPicLocalUrl();
                                if (!WearUtils.e1(picLocalUrl)) {
                                    File fileC0 = WearUtils.c0(picLocalUrl);
                                    if (!fileC0.exists()) {
                                        String strSubstring4 = picLocalUrl.substring(picLocalUrl.lastIndexOf("/") + 1);
                                        if (!WearUtils.e1(strSubstring4)) {
                                            File file6 = new File(this.o + "/" + strSubstring4);
                                            if (file6.exists()) {
                                                WearUtils.q(file6, fileC0);
                                                file6.delete();
                                            }
                                        }
                                    }
                                }
                                String videoLocalUrl = entityShortVideo.getVideoLocalUrl();
                                if (WearUtils.e1(videoLocalUrl)) {
                                    break;
                                } else {
                                    File file7 = new File(videoLocalUrl);
                                    if (file7.exists()) {
                                        break;
                                    } else {
                                        String strSubstring5 = videoLocalUrl.substring(videoLocalUrl.lastIndexOf("/") + 1);
                                        if (WearUtils.e1(strSubstring5)) {
                                            break;
                                        } else {
                                            File file8 = new File(this.o + "/" + strSubstring5);
                                            if (file8.exists()) {
                                                WearUtils.q(file8, file7);
                                                file8.delete();
                                                break;
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }
                        }
                        DaoUtils.getCommunMessageDao().addIfNotExist((CommunMessage) communMessageMig);
                        DaoUtils.getCommunMessageMigDao().delT(communMessageMig);
                        this.e++;
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
        while (true) {
            List<MessageUnReadMig> listFindPageMsgs2 = DaoUtils.getMessageUnReadMigDao().findPageMsgs(0, 100);
            if (listFindPageMsgs2 != null && listFindPageMsgs2.size() > 0) {
                for (MessageUnReadMig messageUnReadMig : listFindPageMsgs2) {
                    DaoUtils.getMessageUnReadDao().addIfNotExist(messageUnReadMig);
                    DaoUtils.getMessageUnReadMigDao().delT(messageUnReadMig);
                }
            }
        }
        while (true) {
            List<MessageHideMig> listFindPageMsgs3 = DaoUtils.getMessageHideMigDao().findPageMsgs(0, 100);
            if (listFindPageMsgs3 == null || listFindPageMsgs3.size() <= 0) {
                return;
            }
            for (MessageHideMig messageHideMig : listFindPageMsgs3) {
                DaoUtils.getMessageHideDao().addIfNotExist(messageHideMig);
                DaoUtils.getMessageHideMigDao().delT(messageHideMig);
            }
        }
    }

    public void c0() {
        this.a = 0;
        DaoUtils.getTestValueDao().save(TestValueDao.CHAT_MIGRATE_KEY, "1", TestValueDao.CHAT_MIGRATE_TYPE);
        l lVar = this.q;
        if (lVar != null) {
            lVar.C(true);
        }
        N();
    }

    public final void d0() {
        try {
            File file = new File(I());
            if (!file.exists()) {
                this.d = this.b;
                a0();
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            this.c = length;
            this.d = length + this.b;
            a0();
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                this.e++;
                String name = file2.getName();
                if (!WearUtils.e1(name) && name.endsWith("mzp")) {
                    try {
                        hh3.b(file2, file, true);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception e3) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable("消息迁移--unZipFile", e3));
        }
    }

    public final void e0(boolean z) {
        x();
        l lVar = this.q;
        if (lVar != null) {
            lVar.D(z);
        }
        DaoUtils.getTestValueDao().save(TestValueDao.CHAT_MIGRATE_KEY, "0", TestValueDao.CHAT_MIGRATE_TYPE);
    }

    public final void w(MigrateAdapterBean migrateAdapterBean) {
        MessageType messageTypeFromString;
        try {
            String id = migrateAdapterBean.getId();
            String type = migrateAdapterBean.getType();
            if (WearUtils.e1(type) || (messageTypeFromString = MessageType.fromString(type)) == null) {
                return;
            }
            CommunMessageMig communMessageMig = new CommunMessageMig();
            String strReplaceAll = migrateAdapterBean.getFrom().replaceAll("/wearable", "");
            String strReplaceAll2 = migrateAdapterBean.getTo().replaceAll("/wearable", "");
            String roomMsgId = migrateAdapterBean.getRoomMsgId();
            if (!WearUtils.e1(roomMsgId)) {
                if (WearUtils.e1(this.j)) {
                    this.j = WearUtils.y.p();
                }
                if (!this.j.equals(strReplaceAll)) {
                    strReplaceAll2 = this.j;
                    strReplaceAll = strReplaceAll2;
                }
            }
            communMessageMig.setFrom(strReplaceAll);
            communMessageMig.setTo(strReplaceAll2);
            if (!migrateAdapterBean.isRead()) {
                MessageUnReadMig messageUnReadMig = new MessageUnReadMig();
                messageUnReadMig.setId(migrateAdapterBean.getId());
                messageUnReadMig.setOwnerJid(this.j);
                messageUnReadMig.setFriendJid(this.j.equals(strReplaceAll) ? strReplaceAll2 : strReplaceAll);
                messageUnReadMig.setCreated(migrateAdapterBean.getCreated());
                messageUnReadMig.setEncrypt(true);
                DaoUtils.getMessageUnReadMigDao().addIfNotExist(messageUnReadMig);
            }
            if (migrateAdapterBean.isBlur()) {
                MessageHideMig messageHideMig = new MessageHideMig();
                messageHideMig.setId(migrateAdapterBean.getId());
                messageHideMig.setOwnerJid(this.j);
                if (this.j.equals(strReplaceAll)) {
                    strReplaceAll = strReplaceAll2;
                }
                messageHideMig.setFriendJid(strReplaceAll);
                messageHideMig.setCreated(migrateAdapterBean.getCreated());
                messageHideMig.setEncrypt(true);
                DaoUtils.getMessageHideMigDao().addIfNotExist(messageHideMig);
            }
            communMessageMig.setId(id);
            communMessageMig.setUserId(WearUtils.i0(migrateAdapterBean.getEmail()));
            communMessageMig.setType(messageTypeFromString);
            String data = migrateAdapterBean.getData();
            switch (b.a[messageTypeFromString.ordinal()]) {
                case 1:
                    EntityPattern entityPattern = (EntityPattern) WearUtils.A.fromJson(data, EntityPattern.class);
                    String localUrl = entityPattern.getLocalUrl();
                    String strSubstring = id + PSOProgramService.LogExt;
                    if (!WearUtils.e1(localUrl)) {
                        strSubstring = localUrl.substring(localUrl.lastIndexOf("/") + 1);
                    }
                    entityPattern.setLocalUrl(nd3.u(WearUtils.y0() + "/" + strSubstring));
                    data = WearUtils.A.toJson(entityPattern);
                    break;
                case 2:
                    EntityAudio entityAudio = (EntityAudio) WearUtils.A.fromJson(data, EntityAudio.class);
                    String localUrl2 = entityAudio.getLocalUrl();
                    String strSubstring2 = id + ".m4a";
                    if (!WearUtils.e1(localUrl2)) {
                        strSubstring2 = localUrl2.substring(localUrl2.lastIndexOf("/") + 1);
                    }
                    entityAudio.setLocalUrl(WearUtils.T("mic").getAbsolutePath() + "/" + strSubstring2);
                    data = WearUtils.A.toJson(entityAudio);
                    break;
                case 3:
                    EntityPicture entityPicture = (EntityPicture) WearUtils.A.fromJson(data, EntityPicture.class);
                    String strSubstring3 = id + ".jpg";
                    String localUrl3 = entityPicture.getLocalUrl();
                    if (!WearUtils.e1(localUrl3)) {
                        strSubstring3 = localUrl3.substring(localUrl3.lastIndexOf("/") + 1);
                    }
                    entityPicture.setLocalUrl(strSubstring3);
                    data = WearUtils.A.toJson(entityPicture);
                    break;
                case 4:
                    EntityBurnPicture entityBurnPicture = (EntityBurnPicture) WearUtils.A.fromJson(data, EntityBurnPicture.class);
                    String strSubstring4 = id + ".jpg";
                    String localUrl4 = entityBurnPicture.getLocalUrl();
                    if (!WearUtils.e1(localUrl4)) {
                        strSubstring4 = localUrl4.substring(localUrl4.lastIndexOf("/") + 1);
                    }
                    entityBurnPicture.setLocalUrl(strSubstring4);
                    data = WearUtils.A.toJson(entityBurnPicture);
                    break;
                case 5:
                    EntityShortVideo entityShortVideo = (EntityShortVideo) WearUtils.A.fromJson(data, EntityShortVideo.class);
                    String strSubstring5 = id + ".jpg";
                    String picLocalUrl = entityShortVideo.getPicLocalUrl();
                    if (!WearUtils.e1(picLocalUrl)) {
                        strSubstring5 = picLocalUrl.substring(picLocalUrl.lastIndexOf("/") + 1);
                    }
                    entityShortVideo.setPicLocalUrl(strSubstring5);
                    String strSubstring6 = id + ".mp4";
                    String videoLocalUrl = entityShortVideo.getVideoLocalUrl();
                    if (!WearUtils.e1(videoLocalUrl)) {
                        strSubstring6 = videoLocalUrl.substring(videoLocalUrl.lastIndexOf("/") + 1);
                    }
                    entityShortVideo.setVideoLocalUrl(WearUtils.T("video").getAbsolutePath() + "/" + strSubstring6);
                    data = WearUtils.A.toJson(entityShortVideo);
                    break;
                case 6:
                    EntityBurnShortVideo entityBurnShortVideo = (EntityBurnShortVideo) WearUtils.A.fromJson(data, EntityBurnShortVideo.class);
                    String strSubstring7 = id + ".jpg";
                    String picLocalUrl2 = entityBurnShortVideo.getPicLocalUrl();
                    if (!WearUtils.e1(picLocalUrl2)) {
                        strSubstring7 = picLocalUrl2.substring(picLocalUrl2.lastIndexOf("/") + 1);
                    }
                    entityBurnShortVideo.setPicLocalUrl(strSubstring7);
                    String strSubstring8 = id + ".mp4";
                    String videoLocalUrl2 = entityBurnShortVideo.getVideoLocalUrl();
                    if (!WearUtils.e1(videoLocalUrl2)) {
                        strSubstring8 = videoLocalUrl2.substring(videoLocalUrl2.lastIndexOf("/") + 1);
                    }
                    entityBurnShortVideo.setVideoLocalUrl(WearUtils.T("video").getAbsolutePath() + "/" + strSubstring8);
                    data = WearUtils.A.toJson(entityBurnShortVideo);
                    break;
            }
            communMessageMig.setData(CommunMessage.encryp(data));
            communMessageMig.setCreated(migrateAdapterBean.getCreated());
            communMessageMig.setSendType(migrateAdapterBean.getSendType());
            int sendStatus = migrateAdapterBean.getSendStatus();
            if (sendStatus == 7) {
                sendStatus = 4;
            }
            communMessageMig.setSendStatus(sendStatus);
            communMessageMig.setReceiveId(migrateAdapterBean.getReceiveId());
            communMessageMig.setMsgId(roomMsgId);
            String realFrom = migrateAdapterBean.getRealFrom();
            if (!WearUtils.e1(realFrom)) {
                realFrom = realFrom.replace("/wearable", "");
            }
            communMessageMig.setRealFrom(realFrom);
            communMessageMig.setRealFromNickName(migrateAdapterBean.getRealFromNickName());
            communMessageMig.setRealFromPhoto(migrateAdapterBean.getRealFromPhoto());
            communMessageMig.setShowEmojiAnim(migrateAdapterBean.isShowEmojiAnim());
            communMessageMig.setReplyData(migrateAdapterBean.getReplyData());
            communMessageMig.setStatus(migrateAdapterBean.getStatus());
            communMessageMig.setV(migrateAdapterBean.getV());
            communMessageMig.setEncrypt(true);
            if (DaoUtils.getCommunMessageMigDao().addIfNotExistEt(communMessageMig)) {
                this.a++;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void x() {
        Disposable disposable = this.p;
        if (disposable != null) {
            disposable.dispose();
            this.p = null;
        }
    }

    public void y(boolean z) {
        vg3.b().a(new k(z));
    }

    public final void z() {
        DaoUtils.getCommunMessageMigDao().deleteAll();
        DaoUtils.getMessageUnReadMigDao().deleteAll();
        DaoUtils.getMessageHideMigDao().deleteAll();
    }
}
