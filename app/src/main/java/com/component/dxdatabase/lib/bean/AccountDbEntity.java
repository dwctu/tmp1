package com.component.dxdatabase.lib.bean;

import androidx.room.Entity;
import com.component.dxdatabase.lib.base.bean.DbBaseEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: AccountDbEntity.kt */
@Entity
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/component/dxdatabase/lib/bean/AccountDbEntity;", "Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;", "()V", "accountCode", "", "getAccountCode", "()Ljava/lang/String;", "setAccountCode", "(Ljava/lang/String;)V", "accountCodeMd5", "getAccountCodeMd5", "setAccountCodeMd5", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AccountDbEntity extends DbBaseEntity {

    @Nullable
    private String accountCode;

    @Nullable
    private String accountCodeMd5;

    @Nullable
    public final String getAccountCode() {
        return this.accountCode;
    }

    @Nullable
    public final String getAccountCodeMd5() {
        return this.accountCodeMd5;
    }

    public final void setAccountCode(@Nullable String str) {
        this.accountCode = str;
    }

    public final void setAccountCodeMd5(@Nullable String str) {
        this.accountCodeMd5 = str;
    }
}
