package dc;

import com.wear.bean.Toy;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: IToyDao.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0017"}, d2 = {"Lcom/wear/component/dxtoy/db/interfaces/IToyDao;", "", "add", "", "t", "Lcom/wear/bean/Toy;", "clearTable", "delT", "existToyByEmail", "", "email", "", MultipleAddresses.Address.ELEMENT, "findAll", "", "findByAddress", "findByEmail", DiscoverItems.Item.UPDATE_ACTION, "ts", "updateLedSetting", StreamManagement.Enable.ELEMENT, "", "updateOrAdd", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface us1 {
    void add(@NotNull Toy t);

    void clearTable();

    void delT(@NotNull Toy t);

    boolean existToyByEmail(@Nullable String email, @NotNull String address);

    @NotNull
    List<Toy> findAll();

    @Nullable
    Toy findByAddress(@NotNull String address);

    @NotNull
    List<Toy> findByEmail(@Nullable String email);

    void update(@NotNull Toy t);

    void update(@NotNull List<? extends Toy> ts);

    void updateLedSetting(@NotNull String address, int enable);

    void updateOrAdd(@NotNull Toy t);
}
