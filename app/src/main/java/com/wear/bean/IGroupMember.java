package com.wear.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: IGroupMember.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/wear/bean/IGroupMember;", "", "itemViewType", "", "getItemViewType", "()I", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface IGroupMember {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_MEMBER_ADMIN = 1;
    public static final int TYPE_MEMBER_REQUEST = 2;

    /* compiled from: IGroupMember.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/wear/bean/IGroupMember$Companion;", "", "()V", "TYPE_HEADER", "", "TYPE_MEMBER_ADMIN", "TYPE_MEMBER_REQUEST", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int TYPE_HEADER = 0;
        public static final int TYPE_MEMBER_ADMIN = 1;
        public static final int TYPE_MEMBER_REQUEST = 2;

        private Companion() {
        }
    }

    int getItemViewType();
}
