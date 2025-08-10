package com.wear.dao;

import com.j256.ormlite.dao.Dao;
import com.wear.bean.chat.RouletteUser;
import java.sql.SQLException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteUserDao.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fR)\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/wear/dao/RouletteUserDao;", "", "()V", "dao", "Lcom/j256/ormlite/dao/Dao;", "Lcom/wear/bean/chat/RouletteUser;", "", "getDao", "()Lcom/j256/ormlite/dao/Dao;", "dao$delegate", "Lkotlin/Lazy;", "add", "", "rouletteUser", "checkDao", "", "delete", "friendId", "findRouletteUser", "isOfflineBefore", "updateOfflineBefore", "flag", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteUserDao {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = RouletteUserDao.class.getSimpleName();

    /* renamed from: dao$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dao = LazyKt__LazyJVMKt.lazy(new Function0<Dao<RouletteUser, String>>() { // from class: com.wear.dao.RouletteUserDao$dao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Dao<RouletteUser, String> invoke() throws SQLException {
            Dao<RouletteUser, String> dao = DatabaseHelper.getHelper().getDao(RouletteUser.class);
            if (dao instanceof Dao) {
                return dao;
            }
            return null;
        }
    });

    /* compiled from: RouletteUserDao.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wear/dao/RouletteUserDao$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return RouletteUserDao.TAG;
        }
    }

    private final boolean checkDao() {
        if (getDao() != null) {
            return false;
        }
        ChatMessageDao.INSTANCE.getTAG();
        return true;
    }

    private final Dao<RouletteUser, String> getDao() {
        return (Dao) this.dao.getValue();
    }

    public final void add(@NotNull RouletteUser rouletteUser) {
        Dao<RouletteUser, String> dao;
        Intrinsics.checkNotNullParameter(rouletteUser, "rouletteUser");
        if (checkDao() || (dao = getDao()) == null) {
            return;
        }
        if (dao.idExists(rouletteUser.getFriendId())) {
            dao.update((Dao<RouletteUser, String>) rouletteUser);
        } else {
            rouletteUser.setOfflineBefore(true);
            dao.create(rouletteUser);
        }
    }

    public final void delete(@NotNull String friendId) {
        Intrinsics.checkNotNullParameter(friendId, "friendId");
        Dao<RouletteUser, String> dao = getDao();
        if (dao != null) {
            dao.deleteById(friendId);
        }
    }

    @Nullable
    public final RouletteUser findRouletteUser(@Nullable String friendId) {
        Dao<RouletteUser, String> dao;
        if (checkDao()) {
            return null;
        }
        if ((friendId == null || friendId.length() == 0) || (dao = getDao()) == null) {
            return null;
        }
        return dao.queryForId(friendId);
    }

    public final boolean isOfflineBefore(@NotNull String friendId) {
        Intrinsics.checkNotNullParameter(friendId, "friendId");
        RouletteUser rouletteUserFindRouletteUser = findRouletteUser(friendId);
        if (rouletteUserFindRouletteUser != null) {
            return rouletteUserFindRouletteUser.getIsOfflineBefore();
        }
        return false;
    }

    public final void updateOfflineBefore(@NotNull String friendId, boolean flag) {
        Intrinsics.checkNotNullParameter(friendId, "friendId");
        RouletteUser rouletteUserFindRouletteUser = findRouletteUser(friendId);
        if (rouletteUserFindRouletteUser != null) {
            rouletteUserFindRouletteUser.setOfflineBefore(flag);
            add(rouletteUserFindRouletteUser);
        }
    }
}
