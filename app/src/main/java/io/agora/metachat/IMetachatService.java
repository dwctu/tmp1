package io.agora.metachat;

import io.agora.metachat.internal.MetachatServiceImpl;

/* loaded from: classes4.dex */
public abstract class IMetachatService {
    private static IMetachatService mInstance;

    public static synchronized IMetachatService create() {
        if (mInstance == null) {
            mInstance = new MetachatServiceImpl();
        }
        return mInstance;
    }

    public static synchronized void destroy() {
        IMetachatService iMetachatService = mInstance;
        if (iMetachatService == null) {
            return;
        }
        iMetachatService.release();
        mInstance = null;
    }

    public abstract int addEventHandler(IMetachatEventHandler iMetachatEventHandler);

    public abstract int cancelDownloadScene(long j);

    public abstract int cleanScene(long j);

    public abstract int createScene(MetachatSceneConfig metachatSceneConfig);

    public abstract int downloadScene(long j);

    public abstract int getSceneInfos();

    public abstract int initialize(MetachatConfig metachatConfig);

    public abstract int isSceneDownloaded(long j);

    public abstract int release();

    public abstract int removeEventHandler(IMetachatEventHandler iMetachatEventHandler);

    public abstract int renewToken(String str);
}
