package dc;

import com.wear.main.account.login.LoginFragment;
import com.wear.ui.discover.DiscoverFragment;
import com.wear.ui.discover.pattern.PatternsItemFragment;
import com.wear.ui.home.pattern.fragment.MyPatternsFragment;
import dagger.Component;

/* compiled from: FragmentComponent.java */
@Component(dependencies = {gl2.class}, modules = {ol2.class})
/* loaded from: classes3.dex */
public interface kl2 {
    void a(LoginFragment loginFragment);

    void b(MyPatternsFragment myPatternsFragment);

    void c(PatternsItemFragment patternsItemFragment);

    void d(DiscoverFragment discoverFragment);
}
