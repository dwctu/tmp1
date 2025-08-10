package dc;

import com.wear.bean.CheckProtocolBean;
import com.wear.bean.GalleryDetailsV2Bean;
import com.wear.bean.XRemoteAppUserBean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: XRemoteView.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\f\u001a\u00020\u0003H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H&J\u0014\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0014H&¨\u0006\u0016"}, d2 = {"Lcom/wear/ui/discover/xremote/view/XRemoteView;", "Lcom/wear/network/presenter/base/BaseView;", "argeeProtocolFail", "", "argeeProtocolSuccess", "onGetAppAccountFail", "onGetAppAccountListEmpty", "onGetAppAccountMessageFail", "onGetAppAccountSuccess", "data", "Lcom/wear/bean/XRemoteAppUserBean$DataBean;", "onGetAppAccountV2Success", "onGetAppcationError", "onGetAuthCode", "", "onGetAutoCodeFail", "onGetProtocol", "Lcom/wear/bean/CheckProtocolBean;", "onGetProtocolError", "onGetWhiteList", "Lcom/wear/bean/GalleryDetailsV2Bean;", "onGetWhiteListError", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface u23 extends ul2 {

    /* compiled from: XRemoteView.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(u23 u23Var, GalleryDetailsV2Bean galleryDetailsV2Bean, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onGetWhiteListError");
            }
            if ((i & 1) != 0) {
                galleryDetailsV2Bean = null;
            }
            u23Var.T(galleryDetailsV2Bean);
        }
    }

    void D0();

    void N0();

    void Q2(@Nullable XRemoteAppUserBean.DataBean dataBean);

    void S1();

    void T(@Nullable GalleryDetailsV2Bean galleryDetailsV2Bean);

    void V0();

    void Z();

    void b1(@NotNull CheckProtocolBean checkProtocolBean);

    void b2(@Nullable String str);

    void f3();

    void h1();

    void i3(@Nullable XRemoteAppUserBean.DataBean dataBean);

    void m3();

    void s0(@NotNull GalleryDetailsV2Bean galleryDetailsV2Bean);
}
