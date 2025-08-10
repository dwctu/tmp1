package com.android.vending.expansion.zipfile;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.j256.ormlite.field.FieldType;
import dc.ie;
import dc.je;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class APEZProvider extends ContentProvider {
    public static final String[] c = {FieldType.FOREIGN_ID_FIELD_SUFFIX, "ZPFN", "ZFIL", "ZMOD", "ZCRC", "ZCOL", "ZUNL", "ZTYP"};
    public static final int[] d = {0, 1, 2, 3, 4, 5, 6, 7};
    public je a;
    public boolean b;

    public abstract String a();

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        b();
        return super.applyBatch(arrayList);
    }

    public final boolean b() {
        int i;
        if (!this.b) {
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(a(), 128);
            try {
                int i2 = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                String[] strArr = null;
                Bundle bundle = providerInfoResolveContentProvider.metaData;
                if (bundle != null) {
                    int i3 = bundle.getInt("mainVersion", i2);
                    int i4 = providerInfoResolveContentProvider.metaData.getInt("patchVersion", i2);
                    String string = providerInfoResolveContentProvider.metaData.getString("mainFilename");
                    if (string != null) {
                        String string2 = providerInfoResolveContentProvider.metaData.getString("patchFilename");
                        strArr = string2 != null ? new String[]{string, string2} : new String[]{string};
                    }
                    i = i4;
                    i2 = i3;
                } else {
                    i = i2;
                }
                try {
                    if (strArr == null) {
                        this.a = ie.b(context, i2, i);
                    } else {
                        this.a = ie.c(strArr);
                    }
                    this.b = true;
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.item/asset";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        b();
        String encodedPath = uri.getEncodedPath();
        if (encodedPath.startsWith("/")) {
            encodedPath = encodedPath.substring(1);
        }
        return this.a.c(encodedPath);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        b();
        AssetFileDescriptor assetFileDescriptorOpenAssetFile = openAssetFile(uri, str);
        if (assetFileDescriptorOpenAssetFile != null) {
            return assetFileDescriptorOpenAssetFile.getParcelFileDescriptor();
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int[] iArr;
        b();
        je jeVar = this.a;
        je.a[] aVarArrB = jeVar == null ? new je.a[0] : jeVar.b();
        if (strArr == null) {
            iArr = d;
            strArr = c;
        } else {
            int length = strArr.length;
            iArr = new int[length];
            for (int i = 0; i < length; i++) {
                if (strArr[i].equals(FieldType.FOREIGN_ID_FIELD_SUFFIX)) {
                    iArr[i] = 0;
                } else if (strArr[i].equals("ZPFN")) {
                    iArr[i] = 1;
                } else if (strArr[i].equals("ZFIL")) {
                    iArr[i] = 2;
                } else if (strArr[i].equals("ZMOD")) {
                    iArr[i] = 3;
                } else if (strArr[i].equals("ZCRC")) {
                    iArr[i] = 4;
                } else if (strArr[i].equals("ZCOL")) {
                    iArr[i] = 5;
                } else if (strArr[i].equals("ZUNL")) {
                    iArr[i] = 6;
                } else {
                    if (!strArr[i].equals("ZTYP")) {
                        throw new RuntimeException();
                    }
                    iArr[i] = 7;
                }
            }
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr, aVarArrB.length);
        int length2 = iArr.length;
        for (je.a aVar : aVarArrB) {
            MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
            for (int i2 = 0; i2 < length2; i2++) {
                switch (iArr[i2]) {
                    case 0:
                        rowBuilderNewRow.add(Integer.valueOf(i2));
                        break;
                    case 1:
                        rowBuilderNewRow.add(aVar.b);
                        break;
                    case 2:
                        rowBuilderNewRow.add(aVar.d());
                        break;
                    case 3:
                        rowBuilderNewRow.add(Long.valueOf(aVar.f));
                        break;
                    case 4:
                        rowBuilderNewRow.add(Long.valueOf(aVar.g));
                        break;
                    case 5:
                        rowBuilderNewRow.add(Long.valueOf(aVar.h));
                        break;
                    case 6:
                        rowBuilderNewRow.add(Long.valueOf(aVar.i));
                        break;
                    case 7:
                        rowBuilderNewRow.add(Integer.valueOf(aVar.e));
                        break;
                }
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
