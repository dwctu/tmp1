package dc;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.wear.bean.Toy;
import com.wear.bean.ToyPinStatusBean;
import com.wear.bean.ToyRename;
import com.wear.dao.DaoUtils;
import com.wear.dao.ToyDao;
import com.wear.dao.ToyPinStatusDao;
import com.wear.dao.ToyRenameDao;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleService;

/* compiled from: SyncToysUtils.java */
/* loaded from: classes4.dex */
public class qg3 {
    public static final Uri a = Uri.parse("content://com.lovense.vibemate.provider.VbTopContentProvider/TOY_RENAME");
    public static final Uri b = Uri.parse("content://com.lovense.vibemate.provider.VbTopContentProvider/TOY");
    public static final Uri c = Uri.parse("content://com.lovense.vibemate.provider.VbTopContentProvider/TOY_PIN_STATUS_BEAN");

    public static Toy a(Cursor cursor) {
        Toy toy = new Toy();
        String string = cursor.getString(cursor.getColumnIndexOrThrow(BleService.EXTRA_ADDR));
        toy.setId(string + WearUtils.y.r());
        toy.setAddress(string);
        toy.setType(cursor.getString(cursor.getColumnIndexOrThrow("TYPE")));
        toy.setVersion(Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("VERSION"))));
        toy.setName(cursor.getString(cursor.getColumnIndexOrThrow("NAME")));
        toy.setFormApp(cursor.getString(cursor.getColumnIndexOrThrow("FORM_APP")));
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("CONNECT_APP"));
        toy.setConnectApp(i);
        toy.setUuid(cursor.getString(cursor.getColumnIndexOrThrow(BleService.EXTRA_UUID)));
        toy.setDeviceType(cursor.getString(cursor.getColumnIndexOrThrow("DEVICE_TYPE")));
        toy.setUpdateTime(cursor.getLong(cursor.getColumnIndexOrThrow("UPDATE_TIME")));
        if (i == -1) {
            toy.setIsSelect(1);
            toy.setFormApp("Lovense Remote");
        }
        return toy;
    }

    public static void b(Toy toy) {
        ContentResolver contentResolver = WearUtils.x.getContentResolver();
        Uri uri = b;
        c(uri);
        if (contentResolver.getType(uri) == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(BleService.EXTRA_ADDR, toy.getAddress());
        contentValues.put("TYPE", toy.getType());
        contentValues.put("VERSION", toy.getVersion());
        contentValues.put("NAME", toy.getName());
        contentValues.put("FORM_APP", "Lovense Remote");
        contentValues.put("CONNECT_APP", Integer.valueOf(toy.getStatus()));
        contentValues.put("DEVICE_TYPE", toy.getDeviceType());
        contentValues.put(BleService.EXTRA_UUID, toy.getUuid());
        contentValues.put("UPDATE_TIME", Long.valueOf(System.currentTimeMillis()));
        contentResolver.insert(uri, contentValues);
    }

    public static Uri c(Uri uri) {
        return uri;
    }

    public static void d(String str) {
        ContentResolver contentResolver = WearUtils.x.getContentResolver();
        Uri uri = b;
        c(uri);
        if (contentResolver.getType(uri) != null) {
            contentResolver.delete(uri, "ADDRESS = ?", new String[]{str});
        }
    }

    public static void e(Context context, String str) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = c;
        c(uri);
        if (contentResolver.getType(uri) == null) {
            return;
        }
        contentResolver.delete(uri, "ADDRESS = ?", new String[]{str});
    }

    public static void f(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        g(contentResolver);
        i(contentResolver);
        h(contentResolver);
    }

    public static int g(ContentResolver contentResolver) {
        Cursor cursorQuery;
        Uri uri = b;
        c(uri);
        if (contentResolver.getType(uri) == null || (cursorQuery = contentResolver.query(uri, null, null, null, null)) == null) {
            return -1;
        }
        ToyDao toyDao = DaoUtils.getToyDao();
        int i = 0;
        while (cursorQuery.moveToNext()) {
            Toy toyFindByAddress = toyDao.findByAddress(cursorQuery.getString(cursorQuery.getColumnIndex(BleService.EXTRA_ADDR)));
            if (toyFindByAddress == null) {
                Toy toyA = a(cursorQuery);
                String str = "createToyBean:" + toyA.getAddress() + " " + toyA.getName() + " " + toyA.getType();
                toyDao.add(toyA);
            } else {
                k(toyFindByAddress, cursorQuery, toyDao);
                String str2 = "updateToyBean:" + toyFindByAddress.getAddress() + " " + toyFindByAddress.getName() + " " + toyFindByAddress.getType();
            }
            i++;
        }
        cursorQuery.close();
        return i;
    }

    public static void h(ContentResolver contentResolver) {
        Cursor cursorQuery;
        Uri uri = c;
        c(uri);
        if (contentResolver.getType(uri) == null || (cursorQuery = contentResolver.query(uri, null, null, null, null)) == null) {
            return;
        }
        ToyPinStatusDao toyPinStatusDao = DaoUtils.getToyPinStatusDao();
        while (cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(BleService.EXTRA_ADDR));
            long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("UPDATE_TIME"));
            ToyPinStatusBean toyPinStatusBeanFindToyPinStatus = toyPinStatusDao.findToyPinStatus(string);
            if (toyPinStatusBeanFindToyPinStatus == null) {
                ToyPinStatusBean toyPinStatusBean = new ToyPinStatusBean(string, 0);
                toyPinStatusBean.setUpdateTime(j);
                toyPinStatusDao.add((ToyPinStatusDao) toyPinStatusBean);
            } else if (toyPinStatusBeanFindToyPinStatus.getUpdateTime() < j) {
                toyPinStatusBeanFindToyPinStatus.setUpdateTime(j);
                toyPinStatusDao.update((ToyPinStatusDao) toyPinStatusBeanFindToyPinStatus);
            }
        }
        cursorQuery.close();
    }

    public static void i(ContentResolver contentResolver) {
        Cursor cursorQuery;
        Uri uri = a;
        c(uri);
        if (contentResolver.getType(uri) == null || (cursorQuery = contentResolver.query(uri, null, null, null, null)) == null) {
            return;
        }
        ToyRenameDao toyRenameDao = DaoUtils.getToyRenameDao();
        while (cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(cursorQuery.getColumnIndex(BleService.EXTRA_ADDR));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("FORM_APP"));
            String string3 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("NAME"));
            long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("UPDATE_TIME"));
            ToyRename toyRenameFindToyRenameByAddress = toyRenameDao.findToyRenameByAddress(string);
            if (toyRenameFindToyRenameByAddress == null) {
                ToyRename toyRename = new ToyRename();
                toyRename.setAddress(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(BleService.EXTRA_ADDR)));
                toyRename.setEmail(WearUtils.y.r());
                toyRename.setName(string3);
                toyRename.setFormApp(string2);
                toyRename.setUpdateTime(j);
                toyRenameDao.add((ToyRenameDao) toyRename);
            } else if (!toyRenameFindToyRenameByAddress.getName().equals(string3) && toyRenameFindToyRenameByAddress.getUpdateTime() < j) {
                toyRenameFindToyRenameByAddress.setUpdateTime(j);
                toyRenameFindToyRenameByAddress.setName(string3);
                toyRenameFindToyRenameByAddress.setFormApp(string2);
                toyRenameDao.update((ToyRenameDao) toyRenameFindToyRenameByAddress);
            }
        }
        cursorQuery.close();
    }

    public static void j(Context context, Toy toy) {
        if (context == null) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = b;
        c(uri);
        if (contentResolver.getType(uri) == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(BleService.EXTRA_ADDR, ng3.e(toy.getAddress()));
            contentValues.put("TYPE", ng3.e(toy.getType()));
            contentValues.put("VERSION", toy.getVersion());
            contentValues.put("NAME", ng3.e(toy.getName()));
            contentValues.put("FORM_APP", ng3.e(toy.getFormApp()));
            contentValues.put("CONNECT_APP", Integer.valueOf(toy.getConnectApp()));
            contentValues.put("DEVICE_TYPE", ng3.e(toy.getDeviceType()));
            contentValues.put(BleService.EXTRA_UUID, ng3.e(toy.getUuid()));
            contentValues.put("UPDATE_TIME", Long.valueOf(System.currentTimeMillis()));
            contentResolver.update(uri, contentValues, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void k(Toy toy, Cursor cursor, ToyDao toyDao) {
        long j = cursor.getLong(cursor.getColumnIndexOrThrow("UPDATE_TIME"));
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("CONNECT_APP"));
        String string = cursor.getString(cursor.getColumnIndexOrThrow("FORM_APP"));
        if ("Lovense Remote".equals(string) || toy.getUpdateTime() >= j) {
            return;
        }
        toy.setUpdateTime(j);
        toy.setConnectApp(i);
        toy.setFormApp(string);
        toy.setUuid(cursor.getString(cursor.getColumnIndexOrThrow(BleService.EXTRA_UUID)));
        toy.setStatus(-1);
        toy.setIsSelect(0);
        if (i == -1) {
            toy.setIsSelect(1);
            toy.setFormApp("Lovense Remote");
        }
        if (i == 1) {
            toy.setConnectType(0);
            toy.setStatus(-1);
        }
        toyDao.update(toy);
        pc1.a.g().put(toy.getAddress(), toy);
    }
}
