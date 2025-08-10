package dc;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/* compiled from: RequiresParseDetailAspect.java */
@Aspect
/* loaded from: classes2.dex */
public class j41 {
    public static /* synthetic */ Throwable a;
    public static final /* synthetic */ j41 b = null;

    static {
        try {
            a();
        } catch (Throwable th) {
            a = th;
        }
    }

    public static /* synthetic */ void a() {
        b = new j41();
    }

    public static j41 b() {
        j41 j41Var = b;
        if (j41Var != null) {
            return j41Var;
        }
        throw new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", a);
    }

    @Before("this(com.googlecode.mp4parser.AbstractBox) && ((execution(public * * (..)) && !( execution(* parseDetails()) || execution(* getNumOfBytesToFirstChild()) || execution(* getType()) || execution(* isParsed()) || execution(* getHeader(*)) || execution(* parse()) || execution(* getBox(*)) || execution(* getSize()) || execution(* getOffset()) || execution(* parseDetails()) || execution(* _parseDetails(*)) || execution(* parse(*,*,*,*)) || execution(* getIsoFile()) || execution(* getParent()) || execution(* setParent(*)) || execution(* getUserType()) || execution(* setUserType(*))) && !@annotation(com.googlecode.mp4parser.annotations.DoNotParseDetail)) || @annotation(com.googlecode.mp4parser.annotations.ParseDetail))")
    public void c(JoinPoint joinPoint) {
        if (joinPoint.getTarget() instanceof e41) {
            if (((e41) joinPoint.getTarget()).j()) {
                return;
            }
            ((e41) joinPoint.getTarget()).l();
        } else {
            throw new RuntimeException("Only methods in subclasses of " + e41.class.getName() + " can  be annotated with ParseDetail");
        }
    }
}
