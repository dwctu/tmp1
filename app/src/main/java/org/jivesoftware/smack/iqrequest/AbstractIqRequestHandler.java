package org.jivesoftware.smack.iqrequest;

import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public abstract class AbstractIqRequestHandler implements IQRequestHandler {
    private final String element;
    private final IQRequestHandler.Mode mode;
    private final String namespace;
    private final IQ.Type type;

    /* renamed from: org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        static {
            int[] iArr = new int[IQ.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = iArr;
            try {
                iArr[IQ.Type.set.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[IQ.Type.get.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public AbstractIqRequestHandler(String str, String str2, IQ.Type type, IQRequestHandler.Mode mode) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[type.ordinal()];
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("Only get and set IQ type allowed");
        }
        this.element = str;
        this.namespace = str2;
        this.type = type;
        this.mode = mode;
    }

    @Override // org.jivesoftware.smack.iqrequest.IQRequestHandler
    public String getElement() {
        return this.element;
    }

    @Override // org.jivesoftware.smack.iqrequest.IQRequestHandler
    public IQRequestHandler.Mode getMode() {
        return this.mode;
    }

    @Override // org.jivesoftware.smack.iqrequest.IQRequestHandler
    public String getNamespace() {
        return this.namespace;
    }

    @Override // org.jivesoftware.smack.iqrequest.IQRequestHandler
    public IQ.Type getType() {
        return this.type;
    }

    @Override // org.jivesoftware.smack.iqrequest.IQRequestHandler
    public abstract IQ handleIQRequest(IQ iq);
}
