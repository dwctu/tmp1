package me.jessyan.retrofiturlmanager.parser;

import android.text.TextUtils;
import dc.rc4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import me.jessyan.retrofiturlmanager.cache.Cache;
import me.jessyan.retrofiturlmanager.cache.LruCache;

/* loaded from: classes5.dex */
public class SuperUrlParser implements UrlParser {
    private Cache<String, String> mCache;
    private RetrofitUrlManager mRetrofitUrlManager;

    private String getKey(rc4 rc4Var, rc4 rc4Var2, int i) {
        return rc4Var.h() + rc4Var2.h() + i;
    }

    private int resolvePathSize(rc4 rc4Var, rc4.a aVar) throws NumberFormatException {
        String strL = rc4Var.l();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        if (strL.indexOf("#") == -1) {
            String[] strArrSplit = strL.split("=");
            if (strArrSplit.length > 1) {
                i = Integer.parseInt(strArrSplit[1]);
            }
        } else if (strL.indexOf(RetrofitUrlManager.IDENTIFICATION_PATH_SIZE) == -1) {
            int iIndexOf = strL.indexOf("#");
            stringBuffer.append(strL.substring(iIndexOf + 1, strL.length()));
            String[] strArrSplit2 = strL.substring(0, iIndexOf).split("=");
            if (strArrSplit2.length > 1) {
                i = Integer.parseInt(strArrSplit2[1]);
            }
        } else {
            String[] strArrSplit3 = strL.split(RetrofitUrlManager.IDENTIFICATION_PATH_SIZE);
            stringBuffer.append(strArrSplit3[0]);
            if (strArrSplit3.length > 1) {
                int iIndexOf2 = strArrSplit3[1].indexOf("#");
                if (iIndexOf2 != -1) {
                    stringBuffer.append(strArrSplit3[1].substring(iIndexOf2, strArrSplit3[1].length()));
                    String strSubstring = strArrSplit3[1].substring(0, iIndexOf2);
                    if (!TextUtils.isEmpty(strSubstring)) {
                        i = Integer.parseInt(strSubstring);
                    }
                } else {
                    i = Integer.parseInt(strArrSplit3[1]);
                }
            }
        }
        if (TextUtils.isEmpty(stringBuffer.toString())) {
            aVar.i(null);
        } else {
            aVar.i(stringBuffer.toString());
        }
        return i;
    }

    @Override // me.jessyan.retrofiturlmanager.parser.UrlParser
    public void init(RetrofitUrlManager retrofitUrlManager) {
        this.mRetrofitUrlManager = retrofitUrlManager;
        this.mCache = new LruCache(100);
    }

    @Override // me.jessyan.retrofiturlmanager.parser.UrlParser
    public rc4 parseUrl(rc4 rc4Var, rc4 rc4Var2) throws NumberFormatException {
        if (rc4Var == null) {
            return rc4Var2;
        }
        rc4.a aVarQ = rc4Var2.q();
        int iResolvePathSize = resolvePathSize(rc4Var2, aVarQ);
        if (TextUtils.isEmpty(this.mCache.get(getKey(rc4Var, rc4Var2, iResolvePathSize)))) {
            for (int i = 0; i < rc4Var2.v(); i++) {
                aVarQ.u(0);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(rc4Var.i());
            if (rc4Var2.v() > iResolvePathSize) {
                List<String> listI = rc4Var2.i();
                for (int i2 = iResolvePathSize; i2 < listI.size(); i2++) {
                    arrayList.add(listI.get(i2));
                }
            } else if (rc4Var2.v() < iResolvePathSize) {
                throw new IllegalArgumentException(String.format("Your final path is %s, the pathSize = %d, but the #baseurl_path_size = %d, #baseurl_path_size must be less than or equal to pathSize of the final path", rc4Var2.G() + "://" + rc4Var2.n() + rc4Var2.h(), Integer.valueOf(rc4Var2.v()), Integer.valueOf(iResolvePathSize)));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVarQ.a((String) it.next());
            }
        } else {
            aVarQ.g(this.mCache.get(getKey(rc4Var, rc4Var2, iResolvePathSize)));
        }
        aVarQ.w(rc4Var.G());
        aVarQ.j(rc4Var.n());
        aVarQ.q(rc4Var.B());
        rc4 rc4VarD = aVarQ.d();
        if (TextUtils.isEmpty(this.mCache.get(getKey(rc4Var, rc4Var2, iResolvePathSize)))) {
            this.mCache.put(getKey(rc4Var, rc4Var2, iResolvePathSize), rc4VarD.h());
        }
        return rc4VarD;
    }
}
