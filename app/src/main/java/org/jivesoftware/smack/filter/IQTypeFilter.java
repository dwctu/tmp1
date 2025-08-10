package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.Objects;

/* loaded from: classes5.dex */
public class IQTypeFilter extends FlexibleStanzaTypeFilter<IQ> {
    public static final StanzaFilter ERROR;
    public static final StanzaFilter GET;
    public static final StanzaFilter GET_OR_SET;
    public static final StanzaFilter RESULT;
    public static final StanzaFilter SET;
    private final IQ.Type type;

    static {
        IQTypeFilter iQTypeFilter = new IQTypeFilter(IQ.Type.get);
        GET = iQTypeFilter;
        IQTypeFilter iQTypeFilter2 = new IQTypeFilter(IQ.Type.set);
        SET = iQTypeFilter2;
        RESULT = new IQTypeFilter(IQ.Type.result);
        ERROR = new IQTypeFilter(IQ.Type.error);
        GET_OR_SET = new OrFilter(iQTypeFilter, iQTypeFilter2);
    }

    private IQTypeFilter(IQ.Type type) {
        super(IQ.class);
        this.type = (IQ.Type) Objects.requireNonNull(type, "Type must not be null");
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public String toString() {
        return getClass().getSimpleName() + ": type=" + this.type;
    }

    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(IQ iq) {
        return iq.getType() == this.type;
    }
}
