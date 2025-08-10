package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.Index;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes2.dex */
public final class QuerySpec {
    private final QueryParams params;
    private final Path path;

    public QuerySpec(Path path, QueryParams queryParams) {
        this.path = path;
        this.params = queryParams;
    }

    public static QuerySpec defaultQueryAtPath(Path path) {
        return new QuerySpec(path, QueryParams.DEFAULT_PARAMS);
    }

    public static QuerySpec fromPathAndQueryObject(Path path, Map<String, Object> map) {
        return new QuerySpec(path, QueryParams.fromQueryObject(map));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || QuerySpec.class != obj.getClass()) {
            return false;
        }
        QuerySpec querySpec = (QuerySpec) obj;
        return this.path.equals(querySpec.path) && this.params.equals(querySpec.params);
    }

    public Index getIndex() {
        return this.params.getIndex();
    }

    public QueryParams getParams() {
        return this.params;
    }

    public Path getPath() {
        return this.path;
    }

    public int hashCode() {
        return (this.path.hashCode() * 31) + this.params.hashCode();
    }

    public boolean isDefault() {
        return this.params.isDefault();
    }

    public boolean loadsAllData() {
        return this.params.loadsAllData();
    }

    public String toString() {
        return this.path + SignatureImpl.INNER_SEP + this.params;
    }
}
