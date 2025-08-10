package dc;

import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.component.dxtoy.core.datacenter.db.manager.DbToy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DbToyMigration.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/component/dxtoy/core/datacenter/db/manager/DbToyMigration;", "", "()V", "getBuild", "Lcom/component/dxtoy/core/datacenter/db/manager/DbToy;", "dbPath", "", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class lb0 {
    @JvmStatic
    @NotNull
    public static final DbToy a(@Nullable String str) {
        Application applicationA = ve0.a();
        if (str == null) {
            str = "dxToy.db";
        }
        RoomDatabase roomDatabaseBuild = Room.databaseBuilder(applicationA, DbToy.class, str).allowMainThreadQueries().build();
        Intrinsics.checkNotNullExpressionValue(roomDatabaseBuild, "databaseBuilder(Utils.ge…es()\n            .build()");
        return (DbToy) roomDatabaseBuild;
    }
}
