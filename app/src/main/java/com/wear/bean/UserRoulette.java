package com.wear.bean;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.bean.chat.ToyInfo;
import com.wear.bean.handlerbean.IPeopleInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserRoulette.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/wear/bean/UserRoulette;", "Lcom/wear/bean/User;", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "userToy", "", "Lcom/wear/bean/chat/ToyInfo;", "userCode", "", "(Ljava/util/List;Ljava/lang/String;)V", "getId", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UserRoulette extends User implements IPeopleInfo {
    public UserRoulette(@Nullable List<ToyInfo> list, @NotNull String userCode) {
        Object objM86constructorimpl;
        Intrinsics.checkNotNullParameter(userCode, "userCode");
        setUserCode(userCode);
        try {
            Result.Companion companion = Result.INSTANCE;
            updateSyncLinkToy(list);
            objM86constructorimpl = Result.m86constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM86constructorimpl = Result.m86constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM89exceptionOrNullimpl = Result.m89exceptionOrNullimpl(objM86constructorimpl);
        if (thM89exceptionOrNullimpl != null) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable("updateSyncLinkToy 异常, " + userCode, thM89exceptionOrNullimpl));
        }
        setSupportLdrTouchPanel(true);
    }

    @Override // com.wear.bean.User, com.wear.bean.BaseEntity
    @Nullable
    public String getId() {
        return getUserCode();
    }
}
