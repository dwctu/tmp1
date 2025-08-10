package dc;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzb;

/* compiled from: com.android.billingclient:billing@@5.0.0 */
/* loaded from: classes.dex */
public final class be {
    public int a;
    public String b;

    /* compiled from: com.android.billingclient:billing@@5.0.0 */
    public static class a {
        public int a;
        public String b = "";

        public /* synthetic */ a(fe feVar) {
        }

        @NonNull
        public be a() {
            be beVar = new be();
            beVar.a = this.a;
            beVar.b = this.b;
            return beVar;
        }

        @NonNull
        public a b(@NonNull String str) {
            this.b = str;
            return this;
        }

        @NonNull
        public a c(int i) {
            this.a = i;
            return this;
        }
    }

    @NonNull
    public static a b() {
        return new a(null);
    }

    public int a() {
        return this.a;
    }

    @NonNull
    public String toString() {
        return "Response Code: " + zzb.zzl(this.a) + ", Debug Message: " + this.b;
    }
}
