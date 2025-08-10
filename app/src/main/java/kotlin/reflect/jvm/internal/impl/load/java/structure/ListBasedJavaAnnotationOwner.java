package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: javaElements.kt */
/* loaded from: classes4.dex */
public interface ListBasedJavaAnnotationOwner extends JavaAnnotationOwner {

    /* compiled from: javaElements.kt */
    public static final class DefaultImpls {
        @Nullable
        public static JavaAnnotation findAnnotation(@NotNull ListBasedJavaAnnotationOwner listBasedJavaAnnotationOwner, @NotNull FqName fqName) {
            Object obj;
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Iterator<T> it = listBasedJavaAnnotationOwner.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ClassId classId = ((JavaAnnotation) next).getClassId();
                if (Intrinsics.areEqual(classId != null ? classId.asSingleFqName() : null, fqName)) {
                    obj = next;
                    break;
                }
            }
            return (JavaAnnotation) obj;
        }
    }
}
