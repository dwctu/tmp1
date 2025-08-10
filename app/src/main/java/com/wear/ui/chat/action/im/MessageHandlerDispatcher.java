package com.wear.ui.chat.action.im;

import android.util.SparseArray;
import com.wear.bean.chat.ChatMessage;
import com.wear.bean.chat.Message;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.iqregister.packet.Registration;

/* compiled from: MessageHandlerDispatcher.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/wear/ui/chat/action/im/MessageHandlerDispatcher;", "", "()V", "TAG", "", "commanders", "Landroid/util/SparseArray;", "Lcom/wear/ui/chat/action/im/Commander;", "invoke", "", "cmd", "", "message", "Lcom/wear/bean/chat/ChatMessage;", Registration.Feature.ELEMENT, "o", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MessageHandlerDispatcher {

    @NotNull
    public static final MessageHandlerDispatcher INSTANCE = new MessageHandlerDispatcher();

    @NotNull
    private static final String TAG;

    @NotNull
    private static final SparseArray<Commander> commanders;

    static {
        String simpleName = MessageHandlerDispatcher.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "MessageHandlerDispatcher::class.java.simpleName");
        TAG = simpleName;
        commanders = new SparseArray<>();
    }

    private MessageHandlerDispatcher() {
    }

    public final void invoke(int cmd, @NotNull ChatMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        SparseArray<Commander> sparseArray = commanders;
        Commander commander = sparseArray.get(cmd);
        if (commander == null || !Message.INSTANCE.getSupportType().contains(Integer.valueOf(cmd))) {
            String str = "invoke: 没有协议号 CustomTypeMessage (" + cmd + ')';
            commander = sparseArray.get(-1);
        }
        Object[] objArr = null;
        if (commander.getParameterTypes() != null) {
            Intrinsics.checkNotNull(commander);
            Class<?>[] parameterTypes = commander.getParameterTypes();
            Intrinsics.checkNotNull(parameterTypes);
            if (parameterTypes.length == 1) {
                objArr = new Object[1];
                for (int i = 0; i < 1; i++) {
                    objArr[i] = 0;
                }
                String str2 = "invoke: MessageHandlerDispatcher() 接收 ... invoke() --> cmd = " + cmd + " , result = " + message;
                Class<?>[] parameterTypes2 = commander.getParameterTypes();
                Intrinsics.checkNotNull(parameterTypes2);
                if (Intrinsics.areEqual(ArraysKt___ArraysKt.first(parameterTypes2), ChatMessage.class)) {
                    objArr[0] = message;
                }
            }
        }
        if (objArr != null) {
            commander.getMethod().invoke(commander.getO(), Arrays.copyOf(objArr, objArr.length));
        } else {
            commander.getMethod().invoke(commander.getO(), new Object[0]);
        }
    }

    public final void register(@NotNull Object o) throws SecurityException {
        Intrinsics.checkNotNullParameter(o, "o");
        Method[] methods = o.getClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "methods");
        for (Method method : methods) {
            CMD cmd = (CMD) method.getAnnotation(CMD.class);
            if (cmd != null) {
                SparseArray<Commander> sparseArray = commanders;
                if (sparseArray.get(cmd.id()) == null) {
                    int iId = cmd.id();
                    Intrinsics.checkNotNullExpressionValue(method, "method");
                    sparseArray.put(iId, new Commander(o, method));
                }
            }
        }
    }
}
