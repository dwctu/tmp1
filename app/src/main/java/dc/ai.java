package dc;

/* compiled from: CallbackException.java */
/* loaded from: classes.dex */
public final class ai extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    public ai(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
