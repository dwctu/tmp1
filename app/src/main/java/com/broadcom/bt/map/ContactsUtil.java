package com.broadcom.bt.map;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.broadcom.bt.util.DBUtil;

/* loaded from: classes.dex */
public class ContactsUtil {
    private static final int COL_DISPLAY_NAME = 3;
    private static final int COL_FAMILY_NAME = 2;
    private static final int COL_GIVEN_NAME = 0;
    private static final int COL_MIDDLE_NAME = 1;
    private static final boolean DBG = true;
    private static final String[] OWNER_NUMBER_PROJ = {"data1"};
    private static final String[] PERSON_NAME_INFO_PROJ = {"data2", "data5", "data3", "data1"};
    private static final String QUERY_PERSION_BY_LOOKUP_KEY = "mimetype = 'vnd.android.cursor.item/name' AND lookup = ?";
    private static final String QUERY_PERSON_BY_CONTACT_ID = "mimetype = 'vnd.android.cursor.item/name' AND contact_id = ?";
    private static final String TAG = "BtMap.ContactsUtil";

    public static boolean contactMatchesFilter(PersonInfo personInfo, String str) {
        String displayName;
        return (personInfo == null || (displayName = personInfo.getDisplayName()) == null || !displayName.contains(str)) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getContactLookupKeyByNumber(android.content.ContentResolver r9, java.lang.String r10) {
        /*
            r0 = 0
            if (r10 == 0) goto L5a
            java.lang.String r1 = r10.trim()
            int r1 = r1.length()
            if (r1 != 0) goto Le
            goto L5a
        Le:
            android.net.Uri r1 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI
            java.lang.String r2 = android.net.Uri.encode(r10)
            android.net.Uri r4 = android.net.Uri.withAppendedPath(r1, r2)
            java.lang.String r1 = "lookup"
            java.lang.String[] r5 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L32
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r9
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L32
            boolean r1 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L43
            r1 = 0
            java.lang.String r0 = r9.getString(r1)     // Catch: java.lang.Throwable -> L33
            goto L43
        L32:
            r9 = r0
        L33:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to get contact lookup uri for phone:"
            r1.append(r2)
            r1.append(r10)
            r1.toString()
        L43:
            if (r9 == 0) goto L48
            r9.close()
        L48:
            if (r0 != 0) goto L5a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "Contact not found with number:"
            r9.append(r1)
            r9.append(r10)
            r9.toString()
        L5a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.broadcom.bt.map.ContactsUtil.getContactLookupKeyByNumber(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    public static PersonInfo getOwnerInfo() {
        return null;
    }

    public static PersonInfo getOwnerInfo(ContentResolver contentResolver) {
        Cursor cursorQuery;
        PersonInfo personInfo = null;
        try {
            cursorQuery = contentResolver.query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), PERSON_NAME_INFO_PROJ, "mimetype = 'vnd.android.cursor.item/name'", null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    PersonInfo personInfo2 = new PersonInfo();
                    try {
                        personInfo2.mGivenName = cursorQuery.getString(0);
                        personInfo2.mMiddleName = cursorQuery.getString(1);
                        personInfo2.mFamilyName = cursorQuery.getString(2);
                        personInfo2.mDisplayName = cursorQuery.getString(3);
                    } catch (Throwable unused) {
                    }
                    personInfo = personInfo2;
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        DBUtil.safeClose(cursorQuery);
        return personInfo;
    }

    public static String getOwnerNumber(ContentResolver contentResolver, int i) {
        Cursor cursorQuery;
        String string = null;
        try {
            cursorQuery = contentResolver.query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), OWNER_NUMBER_PROJ, "mimetype = 'vnd.android.cursor.item/phone_v2' AND data2= ?", new String[]{String.valueOf(i)}, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    string = cursorQuery.getString(0);
                    String str = "getOwnerNumber(): returned " + string;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        DBUtil.safeClose(cursorQuery);
        return string;
    }

    public static PersonInfo getPersonInfo(ContentResolver contentResolver, String str, String[] strArr) {
        Cursor cursorQuery;
        PersonInfo personInfo = null;
        try {
            cursorQuery = contentResolver.query(ContactsContract.Data.CONTENT_URI, PERSON_NAME_INFO_PROJ, str, strArr, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    PersonInfo personInfo2 = new PersonInfo();
                    try {
                        personInfo2.mGivenName = cursorQuery.getString(0);
                        personInfo2.mMiddleName = cursorQuery.getString(1);
                        personInfo2.mFamilyName = cursorQuery.getString(2);
                        personInfo2.mDisplayName = cursorQuery.getString(3);
                    } catch (Throwable unused) {
                    }
                    personInfo = personInfo2;
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        DBUtil.safeClose(cursorQuery);
        return personInfo;
    }

    public static PersonInfo getPersonInfoByContactId(ContentResolver contentResolver, String str) {
        if (str == null) {
            return null;
        }
        return getPersonInfo(contentResolver, QUERY_PERSON_BY_CONTACT_ID, new String[]{str});
    }

    public static PersonInfo getPersonInfoByPhoneNo(ContentResolver contentResolver, String str) {
        String contactLookupKeyByNumber = getContactLookupKeyByNumber(contentResolver, str);
        if (contactLookupKeyByNumber == null) {
            return null;
        }
        return getPersonInfo(contentResolver, QUERY_PERSION_BY_LOOKUP_KEY, new String[]{contactLookupKeyByNumber});
    }

    public static boolean ownerMatchesFilter(ContentResolver contentResolver, String str) {
        String displayName;
        boolean z = false;
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), PERSON_NAME_INFO_PROJ, "mimetype = 'vnd.android.cursor.item/name'", null, null);
            if (cursorQuery.moveToFirst() && (displayName = PersonInfo.getDisplayName(cursorQuery.getString(3), cursorQuery.getString(0), cursorQuery.getString(1), cursorQuery.getString(2))) != null) {
                if (displayName.contains(str)) {
                    z = true;
                }
            }
        } catch (Throwable unused) {
        }
        DBUtil.safeClose(cursorQuery);
        return z;
    }
}
