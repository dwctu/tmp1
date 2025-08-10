package dc;

import android.content.Context;
import com.wear.util.MyApplication;
import dagger.Module;
import dagger.Provides;

/* compiled from: AppModule.java */
@Module
/* loaded from: classes3.dex */
public class ml2 {
    public MyApplication a;

    public ml2(MyApplication myApplication) {
        this.a = myApplication;
    }

    @Provides
    public Context a() {
        return this.a.getApplicationContext();
    }
}
