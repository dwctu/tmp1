package com.component.dxdatabase.lib.base.bean;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DbBaseEntity.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00048FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;", "", "()V", "created", "Ljava/util/Date;", "getCreated", "()Ljava/util/Date;", "setCreated", "(Ljava/util/Date;)V", "value", "", TtmlNode.ATTR_ID, "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "updated", "getUpdated", "setUpdated", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class DbBaseEntity {

    @Nullable
    private Date created;

    @NonNull
    @PrimaryKey
    @NotNull
    private String id = "";

    @Nullable
    private Date updated;

    @Nullable
    public final Date getCreated() {
        if (this.created == null) {
            this.created = new Date();
        }
        return this.created;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Date getUpdated() {
        if (this.updated == null) {
            this.updated = new Date();
        }
        return this.updated;
    }

    public final void setCreated(@Nullable Date date) {
        this.created = date;
    }

    public final void setId(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.id = value;
        if (getCreated() == null) {
            this.created = new Date();
        }
    }

    public final void setUpdated(@Nullable Date date) {
        this.updated = date;
    }
}
