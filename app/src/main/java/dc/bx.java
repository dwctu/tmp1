package dc;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.component.dxdatabase.lib.base.DbBaseDatabase;
import com.component.dxdatabase.lib.manager.DbCommon;
import dc.dx;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: DXDbManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0014\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007JQ\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00132\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0007¢\u0006\u0002\u0010\u0018JG\u0010\u0019\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00132\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0007¢\u0006\u0002\u0010\u001bJQ\u0010\u001c\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00132\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0003¢\u0006\u0002\u0010\u0018JG\u0010\u001e\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00132\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0007¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/component/dxdatabase/lib/manager/DXDbManager;", "", "()V", "DB_ACCOUNT_CODE_DEFAULT", "", "getAccountDatabasePath", "accountCode", "dbName", "getCommonDatabasePath", "getDatabasePath", "dir", "getDbCommon", "Lcom/component/dxdatabase/lib/manager/DbCommon;", "getDbUser", "Lcom/component/dxdatabase/lib/manager/DbUser;", "openDataBase", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/component/dxdatabase/lib/base/DbBaseDatabase;", "clz", "Ljava/lang/Class;", "invoker", "Lkotlin/Function1;", "Landroidx/room/RoomDatabase$Builder;", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Lcom/component/dxdatabase/lib/base/DbBaseDatabase;", "openDataBaseByPath", "dbPath", "(Ljava/lang/String;Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Lcom/component/dxdatabase/lib/base/DbBaseDatabase;", "openDataBaseInternal", "pwd", "openNoEncryptDataBase", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class bx {

    @NotNull
    public static final bx a = new bx();

    @JvmStatic
    @NotNull
    public static final DbCommon c() {
        return DbCommon.a.a();
    }

    @JvmStatic
    @NotNull
    public static final <T extends DbBaseDatabase> T d(@NotNull String dbPath, @NotNull Class<T> clz, @NotNull Function1<? super RoomDatabase.Builder<T>, Unit> invoker) {
        Intrinsics.checkNotNullParameter(dbPath, "dbPath");
        Intrinsics.checkNotNullParameter(clz, "clz");
        Intrinsics.checkNotNullParameter(invoker, "invoker");
        return (T) e(dbPath, xz.g(), clz, invoker);
    }

    @JvmStatic
    public static final <T extends DbBaseDatabase> T e(String str, String str2, Class<T> cls, Function1<? super RoomDatabase.Builder<T>, Unit> function1) throws Throwable {
        SupportFactory supportFactory;
        if (str2 == null || str2.length() == 0) {
            supportFactory = null;
        } else {
            SQLiteDatabase.l0(ve0.a());
            byte[] bytes = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            File file = new File(str);
            if (dx.b(file) == dx.a.UNENCRYPTED) {
                dx.a(ve0.a(), file, bytes);
            }
            supportFactory = new SupportFactory(bytes);
        }
        RoomDatabase.Builder builderAllowMainThreadQueries = Room.databaseBuilder(ve0.a(), cls, str).allowMainThreadQueries();
        Intrinsics.checkNotNullExpressionValue(builderAllowMainThreadQueries, "databaseBuilder(\n       ….allowMainThreadQueries()");
        if (supportFactory != null) {
            builderAllowMainThreadQueries.openHelperFactory(supportFactory);
            if (gd0.i()) {
                builderAllowMainThreadQueries.setJournalMode(RoomDatabase.JournalMode.TRUNCATE);
            }
        }
        function1.invoke(builderAllowMainThreadQueries);
        RoomDatabase roomDatabaseBuild = builderAllowMainThreadQueries.build();
        Intrinsics.checkNotNullExpressionValue(roomDatabaseBuild, "ret.build()");
        return (T) roomDatabaseBuild;
    }

    @NotNull
    public final String a(@NotNull String dbName) {
        Intrinsics.checkNotNullParameter(dbName, "dbName");
        return b(null, dbName);
    }

    public final String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null || str.length() == 0) {
            sb.append(ge0.i());
        } else {
            sb.append(ge0.h());
            sb.append(File.separator);
            sb.append(td0.c(str, ""));
        }
        sb.append(File.separator);
        sb.append(str2);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "pathBuilder.toString()");
        return string;
    }
}
