package dc;

import com.wear.bean.ToyType;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: IToyTypeDao.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/wear/component/dxtoy/db/interfaces/IToyTypeDao;", "", "add", "", "t", "Lcom/wear/bean/ToyType;", "clearTable", "findAll", "", "findToyType", MultipleAddresses.Address.ELEMENT, "", "isExistToyType", "", "totalNumber", "", DiscoverItems.Item.UPDATE_ACTION, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface vs1 {
    void add(@NotNull ToyType t);

    void clearTable();

    @Nullable
    List<ToyType> findAll();

    @Nullable
    ToyType findToyType(@NotNull String address);

    boolean isExistToyType(@NotNull String address);

    int totalNumber();

    void update(@NotNull ToyType t);
}
