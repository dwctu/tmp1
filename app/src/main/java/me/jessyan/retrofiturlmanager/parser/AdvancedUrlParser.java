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
public class AdvancedUrlParser implements UrlParser {
    private Cache<String, String> mCache;
    private RetrofitUrlManager mRetrofitUrlManager;

    private String getKey(rc4 rc4Var, rc4 rc4Var2) {
        return rc4Var.h() + rc4Var2.h() + this.mRetrofitUrlManager.getPathSize();
    }

    @Override // me.jessyan.retrofiturlmanager.parser.UrlParser
    public void init(RetrofitUrlManager retrofitUrlManager) {
        this.mRetrofitUrlManager = retrofitUrlManager;
        this.mCache = new LruCache(100);
    }

    @Override // me.jessyan.retrofiturlmanager.parser.UrlParser
    public rc4 parseUrl(rc4 rc4Var, rc4 rc4Var2) {
        if (rc4Var == null) {
            return rc4Var2;
        }
        rc4.a aVarQ = rc4Var2.q();
        if (TextUtils.isEmpty(this.mCache.get(getKey(rc4Var, rc4Var2)))) {
            for (int i = 0; i < rc4Var2.v(); i++) {
                aVarQ.u(0);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(rc4Var.i());
            if (rc4Var2.v() > this.mRetrofitUrlManager.getPathSize()) {
                List<String> listI = rc4Var2.i();
                for (int pathSize = this.mRetrofitUrlManager.getPathSize(); pathSize < listI.size(); pathSize++) {
                    arrayList.add(listI.get(pathSize));
                }
            } else if (rc4Var2.v() < this.mRetrofitUrlManager.getPathSize()) {
                throw new IllegalArgumentException(String.format("Your final path is %s, but the baseUrl of your RetrofitUrlManager#startAdvancedModel is %s", rc4Var2.G() + "://" + rc4Var2.n() + rc4Var2.h(), this.mRetrofitUrlManager.getBaseUrl().G() + "://" + this.mRetrofitUrlManager.getBaseUrl().n() + this.mRetrofitUrlManager.getBaseUrl().h()));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVarQ.a((String) it.next());
            }
        } else {
            aVarQ.g(this.mCache.get(getKey(rc4Var, rc4Var2)));
        }
        aVarQ.w(rc4Var.G());
        aVarQ.j(rc4Var.n());
        aVarQ.q(rc4Var.B());
        rc4 rc4VarD = aVarQ.d();
        if (TextUtils.isEmpty(this.mCache.get(getKey(rc4Var, rc4Var2)))) {
            this.mCache.put(getKey(rc4Var, rc4Var2), rc4VarD.h());
        }
        return rc4VarD;
    }
}
