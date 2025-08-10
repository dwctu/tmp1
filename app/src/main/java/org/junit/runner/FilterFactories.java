package org.junit.runner;

import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runner.manipulation.Filter;

/* loaded from: classes5.dex */
public class FilterFactories {
    public static Filter createFilter(String str, FilterFactoryParams filterFactoryParams) throws FilterFactory.FilterNotCreatedException {
        return createFilterFactory(str).createFilter(filterFactoryParams);
    }

    public static FilterFactory createFilterFactory(String str) throws FilterFactory.FilterNotCreatedException {
        try {
            return createFilterFactory((Class<? extends FilterFactory>) Classes.getClass(str).asSubclass(FilterFactory.class));
        } catch (Exception e) {
            throw new FilterFactory.FilterNotCreatedException(e);
        }
    }

    public static Filter createFilterFromFilterSpec(Request request, String str) throws FilterFactory.FilterNotCreatedException {
        Description description = request.getRunner().getDescription();
        String[] strArrSplit = str.contains("=") ? str.split("=", 2) : new String[]{str, ""};
        return createFilter(strArrSplit[0], new FilterFactoryParams(description, strArrSplit[1]));
    }

    public static Filter createFilter(Class<? extends FilterFactory> cls, FilterFactoryParams filterFactoryParams) throws FilterFactory.FilterNotCreatedException {
        return createFilterFactory(cls).createFilter(filterFactoryParams);
    }

    public static FilterFactory createFilterFactory(Class<? extends FilterFactory> cls) throws FilterFactory.FilterNotCreatedException {
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new FilterFactory.FilterNotCreatedException(e);
        }
    }
}
