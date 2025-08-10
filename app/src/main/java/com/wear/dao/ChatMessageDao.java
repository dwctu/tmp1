package com.wear.dao;

import com.google.firebase.messaging.Constants;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.wear.bean.chat.Message;
import java.sql.SQLException;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* compiled from: ChatMessageDao.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0006J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R)\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/wear/dao/ChatMessageDao;", "", "()V", "dao", "Lcom/j256/ormlite/dao/Dao;", "Lcom/wear/bean/chat/Message;", "", "getDao", "()Lcom/j256/ormlite/dao/Dao;", "dao$delegate", "Lkotlin/Lazy;", "add", "", "message", "checkDao", "", "deleteMessage", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "deleteMessagesFromUserAccountCode", "accountCode", "queryAll", "", "queryMessagesFromAccountCode", DataLayout.ELEMENT, "", "pageSize", "queryMessagesFromAccountCodeFilterText", "updateMessage", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatMessageDao {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = ChatMessageDao.class.getSimpleName();

    /* renamed from: dao$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dao = LazyKt__LazyJVMKt.lazy(new Function0<Dao<Message, String>>() { // from class: com.wear.dao.ChatMessageDao$dao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Dao<Message, String> invoke() throws SQLException {
            Dao<Message, String> dao = DatabaseHelper.getHelper().getDao(Message.class);
            if (dao instanceof Dao) {
                return dao;
            }
            return null;
        }
    });

    /* compiled from: ChatMessageDao.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wear/dao/ChatMessageDao$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return ChatMessageDao.TAG;
        }
    }

    private final boolean checkDao() {
        return getDao() == null;
    }

    private final Dao<Message, String> getDao() {
        return (Dao) this.dao.getValue();
    }

    public final void add(@NotNull Message message) throws SQLException {
        Dao<Message, String> dao;
        Intrinsics.checkNotNullParameter(message, "message");
        if (checkDao() || (dao = getDao()) == null) {
            return;
        }
        if (dao.idExists(message.getMessageId())) {
            dao.update((Dao<Message, String>) message);
        } else {
            dao.create(message);
        }
    }

    public final void deleteMessage(@NotNull String messageId) throws SQLException {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Dao<Message, String> dao = getDao();
        if (dao != null) {
            dao.deleteById(messageId);
        }
    }

    public final void deleteMessagesFromUserAccountCode(@NotNull String accountCode) throws SQLException {
        DeleteBuilder<Message, String> deleteBuilder;
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        Dao<Message, String> dao = getDao();
        if (dao == null || (deleteBuilder = dao.deleteBuilder()) == null) {
            return;
        }
        deleteBuilder.where().eq("from_account_id", accountCode).or().eq("to_account_id", accountCode);
        deleteBuilder.delete();
    }

    @NotNull
    public final List<Message> queryAll() throws SQLException {
        if (getDao() == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Dao<Message, String> dao = getDao();
        Intrinsics.checkNotNull(dao);
        List<Message> listQueryForAll = dao.queryForAll();
        Intrinsics.checkNotNullExpressionValue(listQueryForAll, "");
        CollectionsKt___CollectionsJvmKt.reverse(listQueryForAll);
        Intrinsics.checkNotNullExpressionValue(listQueryForAll, "dao!!.queryForAll().apply { reverse() }");
        return listQueryForAll;
    }

    @NotNull
    public final List<Message> queryMessagesFromAccountCode(@NotNull String accountCode, int page, int pageSize) throws SQLException {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        if (getDao() == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Dao<Message, String> dao = getDao();
        Intrinsics.checkNotNull(dao);
        QueryBuilder<Message, String> queryBuilder = dao.queryBuilder();
        queryBuilder.where().eq("from_account_id", accountCode).or().eq("to_account_id", accountCode);
        queryBuilder.orderBy("create_time", false).offset(page * pageSize).limit(pageSize);
        Dao<Message, String> dao2 = getDao();
        Intrinsics.checkNotNull(dao2);
        List<Message> listQuery = dao2.query(queryBuilder.prepare());
        Intrinsics.checkNotNullExpressionValue(listQuery, "");
        CollectionsKt___CollectionsJvmKt.reverse(listQuery);
        Intrinsics.checkNotNullExpressionValue(listQuery, "dao!!.query(queryBuilder…re()).apply { reverse() }");
        return listQuery;
    }

    @NotNull
    public final List<Message> queryMessagesFromAccountCodeFilterText(@NotNull String accountCode) throws SQLException {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        if (getDao() == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Dao<Message, String> dao = getDao();
        Intrinsics.checkNotNull(dao);
        QueryBuilder<Message, String> queryBuilder = dao.queryBuilder();
        queryBuilder.where().eq("from_account_id", accountCode).or().eq("to_account_id", accountCode).and().eq("type", 1);
        queryBuilder.orderBy("create_time", false);
        Dao<Message, String> dao2 = getDao();
        Intrinsics.checkNotNull(dao2);
        List<Message> listQuery = dao2.query(queryBuilder.prepare());
        Intrinsics.checkNotNullExpressionValue(listQuery, "");
        CollectionsKt___CollectionsJvmKt.reverse(listQuery);
        Intrinsics.checkNotNullExpressionValue(listQuery, "dao!!.query(queryBuilder…re()).apply { reverse() }");
        return listQuery;
    }

    public final void updateMessage(@NotNull Message message) throws SQLException {
        Intrinsics.checkNotNullParameter(message, "message");
        Dao<Message, String> dao = getDao();
        if (dao != null) {
            dao.update((Dao<Message, String>) message);
        }
    }
}
