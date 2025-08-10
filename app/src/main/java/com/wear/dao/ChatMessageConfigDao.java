package com.wear.dao;

import com.google.firebase.messaging.Constants;
import com.j256.ormlite.dao.Dao;
import com.wear.bean.chat.MessageConfig;
import java.sql.SQLException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatMessageConfigDao.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0006R)\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/wear/dao/ChatMessageConfigDao;", "", "()V", "dao", "Lcom/j256/ormlite/dao/Dao;", "Lcom/wear/bean/chat/MessageConfig;", "", "getDao", "()Lcom/j256/ormlite/dao/Dao;", "dao$delegate", "Lkotlin/Lazy;", "add", "", "messageConfig", "checkDao", "", "isEmojisAnimationPlayed", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "queryForMessageId", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatMessageConfigDao {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = ChatMessageDao.class.getSimpleName();

    /* renamed from: dao$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dao = LazyKt__LazyJVMKt.lazy(new Function0<Dao<MessageConfig, String>>() { // from class: com.wear.dao.ChatMessageConfigDao$dao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Dao<MessageConfig, String> invoke() throws SQLException {
            Dao<MessageConfig, String> dao = DatabaseHelper.getHelper().getDao(MessageConfig.class);
            if (dao instanceof Dao) {
                return dao;
            }
            return null;
        }
    });

    /* compiled from: ChatMessageConfigDao.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wear/dao/ChatMessageConfigDao$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return ChatMessageConfigDao.TAG;
        }
    }

    private final boolean checkDao() {
        if (getDao() != null) {
            return false;
        }
        ChatMessageDao.INSTANCE.getTAG();
        return true;
    }

    private final Dao<MessageConfig, String> getDao() {
        return (Dao) this.dao.getValue();
    }

    public final void add(@NotNull MessageConfig messageConfig) throws SQLException {
        Dao<MessageConfig, String> dao;
        Intrinsics.checkNotNullParameter(messageConfig, "messageConfig");
        if (checkDao() || (dao = getDao()) == null) {
            return;
        }
        if (dao.idExists(messageConfig.getMessageId())) {
            dao.update((Dao<MessageConfig, String>) messageConfig);
        } else {
            dao.create(messageConfig);
        }
    }

    public final boolean isEmojisAnimationPlayed(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (getDao() == null) {
            return false;
        }
        Dao<MessageConfig, String> dao = getDao();
        Intrinsics.checkNotNull(dao);
        if (dao.idExists(messageId)) {
            return false;
        }
        Dao<MessageConfig, String> dao2 = getDao();
        Intrinsics.checkNotNull(dao2);
        return dao2.queryForId(messageId).getIsShowEmojiAnimation();
    }

    @Nullable
    public final MessageConfig queryForMessageId(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Dao<MessageConfig, String> dao = getDao();
        if (dao != null) {
            return dao.queryForId(messageId);
        }
        return null;
    }
}
