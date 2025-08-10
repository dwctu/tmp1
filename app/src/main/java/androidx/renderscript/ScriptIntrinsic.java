package androidx.renderscript;

/* loaded from: classes.dex */
public abstract class ScriptIntrinsic extends Script {
    public ScriptIntrinsic(long j, RenderScript renderScript) {
        super(j, renderScript);
        if (j == 0) {
            throw new RSRuntimeException("Loading of ScriptIntrinsic failed.");
        }
    }
}
