package org.jivesoftware.smack.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.util.Objects;

/* loaded from: classes5.dex */
public abstract class AbstractListFilter implements StanzaFilter {
    public final List<StanzaFilter> filters;

    public AbstractListFilter() {
        this.filters = new ArrayList();
    }

    public void addFilter(StanzaFilter stanzaFilter) {
        Objects.requireNonNull(stanzaFilter, "Parameter must not be null.");
        this.filters.add(stanzaFilter);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(": (");
        Iterator<StanzaFilter> it = this.filters.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public AbstractListFilter(StanzaFilter... stanzaFilterArr) {
        Objects.requireNonNull(stanzaFilterArr, "Parameter must not be null.");
        for (StanzaFilter stanzaFilter : stanzaFilterArr) {
            Objects.requireNonNull(stanzaFilter, "Parameter must not be null.");
        }
        this.filters = new ArrayList(Arrays.asList(stanzaFilterArr));
    }
}
