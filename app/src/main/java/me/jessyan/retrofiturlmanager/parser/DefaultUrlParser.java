package me.jessyan.retrofiturlmanager.parser;

import dc.rc4;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

/* loaded from: classes5.dex */
public class DefaultUrlParser implements UrlParser {
    private volatile UrlParser mAdvancedUrlParser;
    private UrlParser mDomainUrlParser;
    private RetrofitUrlManager mRetrofitUrlManager;
    private volatile UrlParser mSuperUrlParser;

    @Override // me.jessyan.retrofiturlmanager.parser.UrlParser
    public void init(RetrofitUrlManager retrofitUrlManager) {
        this.mRetrofitUrlManager = retrofitUrlManager;
        DomainUrlParser domainUrlParser = new DomainUrlParser();
        this.mDomainUrlParser = domainUrlParser;
        domainUrlParser.init(retrofitUrlManager);
    }

    @Override // me.jessyan.retrofiturlmanager.parser.UrlParser
    public rc4 parseUrl(rc4 rc4Var, rc4 rc4Var2) {
        if (rc4Var == null) {
            return rc4Var2;
        }
        if (rc4Var2.toString().contains(RetrofitUrlManager.IDENTIFICATION_PATH_SIZE)) {
            if (this.mSuperUrlParser == null) {
                synchronized (this) {
                    if (this.mSuperUrlParser == null) {
                        this.mSuperUrlParser = new SuperUrlParser();
                        this.mSuperUrlParser.init(this.mRetrofitUrlManager);
                    }
                }
            }
            return this.mSuperUrlParser.parseUrl(rc4Var, rc4Var2);
        }
        if (!this.mRetrofitUrlManager.isAdvancedModel()) {
            return this.mDomainUrlParser.parseUrl(rc4Var, rc4Var2);
        }
        if (this.mAdvancedUrlParser == null) {
            synchronized (this) {
                if (this.mAdvancedUrlParser == null) {
                    this.mAdvancedUrlParser = new AdvancedUrlParser();
                    this.mAdvancedUrlParser.init(this.mRetrofitUrlManager);
                }
            }
        }
        return this.mAdvancedUrlParser.parseUrl(rc4Var, rc4Var2);
    }
}
