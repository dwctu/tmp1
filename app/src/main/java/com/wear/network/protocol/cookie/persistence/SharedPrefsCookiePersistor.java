package com.wear.network.protocol.cookie.persistence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import dc.ic4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes3.dex */
public class SharedPrefsCookiePersistor implements CookiePersistor {
    private final SharedPreferences sharedPreferences;

    public SharedPrefsCookiePersistor(Context context) {
        this(context.getSharedPreferences("CookiePersistence", 0));
    }

    private static String createCookieKey(ic4 ic4Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(ic4Var.r() ? "https" : "http");
        sb.append("://");
        sb.append(ic4Var.b());
        sb.append(ic4Var.o());
        sb.append("|");
        sb.append(ic4Var.h());
        return sb.toString();
    }

    @Override // com.wear.network.protocol.cookie.persistence.CookiePersistor
    public void clear() {
        this.sharedPreferences.edit().clear().commit();
    }

    @Override // com.wear.network.protocol.cookie.persistence.CookiePersistor
    public List<ic4> loadAll() {
        ArrayList arrayList = new ArrayList(this.sharedPreferences.getAll().size());
        Iterator<Map.Entry<String, ?>> it = this.sharedPreferences.getAll().entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(new SerializableCookie().decode((String) it.next().getValue()));
        }
        return arrayList;
    }

    @Override // com.wear.network.protocol.cookie.persistence.CookiePersistor
    public void removeAll(Collection<ic4> collection) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        Iterator<ic4> it = collection.iterator();
        while (it.hasNext()) {
            editorEdit.remove(createCookieKey(it.next()));
        }
        editorEdit.commit();
    }

    @Override // com.wear.network.protocol.cookie.persistence.CookiePersistor
    public void saveAll(Collection<ic4> collection) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        for (ic4 ic4Var : collection) {
            editorEdit.putString(createCookieKey(ic4Var), new SerializableCookie().encode(ic4Var));
        }
        editorEdit.commit();
    }

    public SharedPrefsCookiePersistor(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
}
