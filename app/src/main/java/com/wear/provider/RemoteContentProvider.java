package com.wear.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.wear.bean.Toy;
import com.wear.bean.ToyPinStatusBean;
import com.wear.bean.ToyRename;
import com.wear.bean.controlmutlitoys.ToyDSLocalEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.DatabaseHelper;
import com.wear.dao.ToyPinStatusDao;
import com.wear.dao.ToyRenameDao;
import com.wear.util.WearUtils;
import dc.aj2;
import dc.bq2;
import dc.cc0;
import dc.jb0;
import dc.mp1;
import dc.nb0;
import dc.ng3;
import dc.pc1;
import dc.rp1;
import dc.xc1;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* loaded from: classes3.dex */
public class RemoteContentProvider extends ContentProvider {
    public static final String c = RemoteContentProvider.class.getSimpleName();
    public UriMatcher a;
    public SQLiteDatabase b;

    static {
        Uri.parse("content://com.lovense.wear.RemoteContentProvider/tb_toy");
    }

    public final String a(Toy toy, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("toy_mac", (Object) toy.getAddress().replace(SignatureImpl.INNER_SEP, ""));
        jSONObject.put("connected_app", (Object) str);
        return jSONObject.toJSONString();
    }

    public final void b(ContentValues contentValues, String[] strArr) {
        if (strArr == null || strArr.length == 0 || !contentValues.containsKey("connectApp")) {
            return;
        }
        Integer asInteger = contentValues.getAsInteger("connectApp");
        String str = strArr[0];
        pc1 pc1Var = pc1.a;
        ConcurrentHashMap<String, Toy> concurrentHashMapG = pc1Var.g();
        Toy toyFindByAddress = concurrentHashMapG.containsKey(str) ? concurrentHashMapG.get(str) : DaoUtils.getToyDao().findByAddress(str);
        if (toyFindByAddress == null) {
            return;
        }
        if (asInteger.intValue() == -1) {
            toyFindByAddress.setConnectApp(asInteger.intValue());
            EventBus.getDefault().post(new xc1(str, toyFindByAddress.getStatus()));
            return;
        }
        String asString = contentValues.getAsString("formApp");
        if (toyFindByAddress.isSelect() && toyFindByAddress.getStatus() == 1) {
            rp1.s(a(toyFindByAddress, asString));
            aj2.b(str, cc0.DISCONNECTED);
        }
        toyFindByAddress.setIsSelect(0);
        toyFindByAddress.setStatus(-1);
        pc1Var.E(toyFindByAddress);
        pc1Var.disconnect(str);
        pc1Var.v0(str);
        toyFindByAddress.setDisConnectType(5);
        toyFindByAddress.setRealDeviceType(false);
        toyFindByAddress.setIsLongRange(0);
        toyFindByAddress.setConnectApp(asInteger.intValue());
        toyFindByAddress.setFormApp(asString);
        DaoUtils.getToyDao().update(toyFindByAddress);
        EventBus.getDefault().post(new ToyDSLocalEvent());
        EventBus.getDefault().post(new xc1(str, -1));
    }

    public final Uri c(Uri uri) {
        if (uri == null || uri.getAuthority() == null || !uri.getAuthority().equals("com.lovense.wear.RemoteContentProvider")) {
            return null;
        }
        Uri uriA = bq2.a(uri);
        String str = "checkURI: " + uriA;
        return uriA;
    }

    public final Cursor d() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{MultipleAddresses.Address.ELEMENT, "type", "version", "name", "formApp", "connectApp", "deviceType", "uuid", "updateTime"});
        List<nb0> listC = jb0.e.c();
        if (listC != null && listC.size() > 0) {
            for (nb0 nb0Var : listC) {
                if (nb0Var.getIsUIInMyToyList()) {
                    matrixCursor.addRow(new Object[]{ng3.e(nb0Var.getMac()), ng3.e(nb0Var.h()), Integer.valueOf(nb0Var.getVersion()), ng3.e(nb0Var.e()), ng3.e(nb0Var.getFormApp()), Integer.valueOf(nb0Var.getOtherAppConnectState()), ng3.e(nb0Var.getDeviceType()), ng3.e(nb0Var.getUuid()), Long.valueOf(nb0Var.getUpdateTime())});
                }
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        Uri uriC = c(uri);
        if (uriC == null) {
            return 0;
        }
        synchronized (RemoteContentProvider.class) {
            if (this.a.match(uriC) == 1) {
                if (strArr != null && strArr.length != 0) {
                    if (mp1.h()) {
                        Toy toyQ = pc1.a.Q(strArr[0]);
                        if (toyQ != null) {
                            DaoUtils.getToyDao().delT(toyQ);
                        }
                    } else {
                        this.b.delete("tb_toy", str, strArr);
                    }
                    pc1.a.b0(strArr[0]);
                }
            } else if (this.a.match(uriC) == 2) {
                return this.b.delete("tb_toy_pin", str, strArr);
            }
            return 0;
        }
    }

    public final Uri e(@NonNull Uri uri, @NonNull ContentValues contentValues) {
        if (this.a.match(uri) != 1) {
            return null;
        }
        String asString = contentValues.getAsString(MultipleAddresses.Address.ELEMENT);
        if (TextUtils.isEmpty(asString)) {
            return null;
        }
        Toy toyFindByAddress = DaoUtils.getToyDao().findByAddress(asString);
        if (toyFindByAddress != null) {
            f(toyFindByAddress, contentValues);
            DaoUtils.getToyDao().update(toyFindByAddress);
            return null;
        }
        Toy toy = new Toy();
        f(toy, contentValues);
        pc1.a.u(toy);
        DaoUtils.getToyDao().add(toy);
        return null;
    }

    public final void f(Toy toy, ContentValues contentValues) {
        toy.setAddress(contentValues.getAsString(MultipleAddresses.Address.ELEMENT));
        toy.setType(contentValues.getAsString("type"));
        toy.setVersion(contentValues.getAsInteger("version"));
        toy.setName(contentValues.getAsString("name"));
        toy.setConnectApp(contentValues.getAsInteger("connectApp").intValue());
        toy.setFormApp(contentValues.getAsString("formApp"));
        toy.setUpdateTime(contentValues.getAsLong("updateTime").longValue());
        toy.setDeviceType(contentValues.getAsString("deviceType"));
        toy.setUuid(contentValues.getAsString("uuid"));
    }

    public final int g(ContentValues contentValues, String str, String[] strArr) {
        if (strArr != null && strArr.length != 0 && contentValues != null) {
            String str2 = strArr[0];
            if (DaoUtils.getToyPinStatusDao().findToyPinStatus(str2) != null) {
                return this.b.update("tb_toy_pin", contentValues, str, strArr);
            }
            ToyPinStatusBean toyPinStatusBean = new ToyPinStatusBean(str2, 0);
            toyPinStatusBean.setUpdateTime(contentValues.getAsLong("updateTime").longValue());
            toyPinStatusBean.setEncrypt(true);
            DaoUtils.getToyPinStatusDao().add((ToyPinStatusDao) toyPinStatusBean);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        Uri uriC = c(uri);
        if (uriC == null) {
            return null;
        }
        int iMatch = this.a.match(uriC);
        if (iMatch == 1) {
            return "vnd.android.cursor.dir/tb_toy";
        }
        if (iMatch == 2) {
            return "vnd.android.cursor.dir/tb_toy_pin";
        }
        if (iMatch != 3) {
            return null;
        }
        return "vnd.android.cursor.dir/tb_toy_rename";
    }

    public final void h(ContentValues contentValues, String[] strArr) {
        if (strArr == null || strArr.length == 0 || contentValues == null) {
            return;
        }
        String str = strArr[0];
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toy toyFindByAddress = DaoUtils.getToyDao().findByAddress(str);
        if (toyFindByAddress == null) {
            toyFindByAddress = new Toy();
            toyFindByAddress.setAddress(str);
        }
        toyFindByAddress.setType(contentValues.getAsString("type"));
        toyFindByAddress.setVersion(contentValues.getAsInteger("version"));
        toyFindByAddress.setName(contentValues.getAsString("name"));
        toyFindByAddress.setFormApp(contentValues.getAsString("formApp"));
        toyFindByAddress.setConnectApp(contentValues.getAsInteger("connectApp").intValue());
        toyFindByAddress.setDeviceType(contentValues.getAsString("deviceType"));
        toyFindByAddress.setUuid(contentValues.getAsString("uuid"));
        toyFindByAddress.setUpdateTime(contentValues.getAsLong("updateTime").longValue());
        DaoUtils.getToyDao().updateOrAdd(toyFindByAddress);
    }

    public final int i(ContentValues contentValues, String str, String[] strArr) {
        if (strArr != null && strArr.length != 0 && contentValues != null) {
            String str2 = strArr[0];
            ToyRename toyRenameFindToyRenameByAddress = DaoUtils.getToyRenameDao().findToyRenameByAddress(str2);
            String asString = contentValues.getAsString("formApp");
            if (toyRenameFindToyRenameByAddress != null) {
                return this.b.update("tb_toy_rename", contentValues, str, strArr);
            }
            ToyRename toyRename = new ToyRename();
            toyRename.setEmail(WearUtils.y.r());
            toyRename.setName(contentValues.getAsString("name"));
            toyRename.setUpdateTime(contentValues.getAsLong("updateTime").longValue());
            toyRename.setFormApp(asString);
            toyRename.setAddress(str2);
            DaoUtils.getToyRenameDao().add((ToyRenameDao) toyRename);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Uri uriE;
        if (contentValues == null) {
            return null;
        }
        String str = "insert : " + contentValues.toString();
        Uri uriC = c(uri);
        if (uriC == null) {
            return null;
        }
        synchronized (RemoteContentProvider.class) {
            uriE = e(uriC, contentValues);
        }
        return uriE;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.a = uriMatcher;
        uriMatcher.addURI("com.lovense.wear.RemoteContentProvider", "tb_toy", 1);
        this.a.addURI("com.lovense.wear.RemoteContentProvider", "tb_toy_rename", 3);
        this.a.addURI("com.lovense.wear.RemoteContentProvider", "tb_toy_pin", 2);
        this.b = DatabaseHelper.getHelper(getContext()).getWritableDatabase();
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Uri uriC = c(uri);
        Cursor cursorD = null;
        if (uriC == null) {
            return null;
        }
        synchronized (RemoteContentProvider.class) {
            DatabaseHelper helper = DatabaseHelper.getHelper();
            if (helper == null) {
                return null;
            }
            int iMatch = this.a.match(uriC);
            if (iMatch == 1) {
                cursorD = mp1.h() ? d() : helper.getReadableDatabase().rawQuery("SELECT * FROM tb_toy", null);
            } else if (iMatch == 2) {
                cursorD = helper.getReadableDatabase().rawQuery("SELECT * FROM tb_toy_pin", null);
            } else if (iMatch == 3) {
                cursorD = helper.getReadableDatabase().rawQuery("SELECT * FROM tb_toy_rename", null);
            }
            return cursorD;
        }
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String str2 = "update : " + uri + "\n + values = " + contentValues;
        Uri uriC = c(uri);
        if (uriC == null) {
            return 0;
        }
        synchronized (RemoteContentProvider.class) {
            if (this.a.match(uriC) == 1) {
                b(contentValues, strArr);
                if (mp1.h()) {
                    h(contentValues, strArr);
                    return 1;
                }
                return this.b.update("tb_toy", contentValues, str, strArr);
            }
            if (this.a.match(uriC) == 3) {
                return i(contentValues, str, strArr);
            }
            if (this.a.match(uriC) != 2) {
                return 0;
            }
            return g(contentValues, str, strArr);
        }
    }
}
