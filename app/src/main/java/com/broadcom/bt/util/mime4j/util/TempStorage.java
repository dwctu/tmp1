package com.broadcom.bt.util.mime4j.util;

import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class TempStorage {
    private static TempStorage inst;
    private static Log log = LogFactory.getLog(TempStorage.class);

    static {
        inst = null;
        String property = System.getProperty("com.broadcom.bt.util.mime4j.tempStorage");
        try {
            if (inst != null) {
                inst = (TempStorage) Class.forName(property).newInstance();
            }
        } catch (Throwable th) {
            log.warn("Unable to create or instantiate TempStorage class '" + property + "' using SimpleTempStorage instead", th);
        }
        if (inst == null) {
            inst = new SimpleTempStorage();
        }
    }

    public static TempStorage getInstance() {
        return inst;
    }

    public static void setInstance(TempStorage tempStorage) {
        Objects.requireNonNull(tempStorage, "inst");
        inst = tempStorage;
    }

    public abstract TempPath getRootTempPath();
}
