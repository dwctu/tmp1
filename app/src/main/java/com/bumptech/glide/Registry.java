package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import dc.Cdo;
import dc.ch;
import dc.dh;
import dc.eo;
import dc.fn;
import dc.fo;
import dc.gn;
import dc.go;
import dc.hi;
import dc.ho;
import dc.io;
import dc.jh;
import dc.kh;
import dc.lk;
import dc.mk;
import dc.nk;
import dc.ri;
import dc.ti;
import dc.vg;
import dc.xp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Registry {
    public final nk a;
    public final Cdo b;
    public final ho c;
    public final io d;
    public final kh e;
    public final gn f;
    public final eo g;
    public final go h = new go();
    public final fo i = new fo();
    public final Pools.Pool<List<Throwable>> j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m, @NonNull List<lk<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> poolE = xp.e();
        this.j = poolE;
        this.a = new nk(poolE);
        this.b = new Cdo();
        this.c = new ho();
        this.d = new io();
        this.e = new kh();
        this.f = new gn();
        this.g = new eo();
        u(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull vg<Data> vgVar) {
        this.b.a(cls, vgVar);
        return this;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull dh<TResource> dhVar) {
        this.d.a(cls, dhVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ch<Data, TResource> chVar) {
        e("legacy_append", cls, cls2, chVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull mk<Model, Data> mkVar) {
        this.a.a(cls, cls2, mkVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ch<Data, TResource> chVar) {
        this.c.a(str, chVar, cls, cls2);
        return this;
    }

    @NonNull
    public final <Data, TResource, Transcode> List<hi<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.c.d(cls, cls2)) {
            for (Class cls5 : this.f.b(cls4, cls3)) {
                arrayList.add(new hi(cls, cls4, cls5, this.c.b(cls, cls4), this.f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> listB = this.g.b();
        if (listB.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listB;
    }

    @Nullable
    public <Data, TResource, Transcode> ri<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ri<Data, TResource, Transcode> riVarA = this.i.a(cls, cls2, cls3);
        if (this.i.c(riVarA)) {
            return null;
        }
        if (riVarA == null) {
            List<hi<Data, TResource, Transcode>> listF = f(cls, cls2, cls3);
            riVarA = listF.isEmpty() ? null : new ri<>(cls, cls2, cls3, listF, this.j);
            this.i.d(cls, cls2, cls3, riVarA);
        }
        return riVarA;
    }

    @NonNull
    public <Model> List<lk<Model, ?>> i(@NonNull Model model) {
        return this.a.d(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> listA = this.h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.c.d(it.next(), cls2)) {
                    if (!this.f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    @NonNull
    public <X> dh<X> k(@NonNull ti<X> tiVar) throws NoResultEncoderAvailableException {
        dh<X> dhVarB = this.d.b(tiVar.c());
        if (dhVarB != null) {
            return dhVarB;
        }
        throw new NoResultEncoderAvailableException(tiVar.c());
    }

    @NonNull
    public <X> jh<X> l(@NonNull X x) {
        return this.e.a(x);
    }

    @NonNull
    public <X> vg<X> m(@NonNull X x) throws NoSourceEncoderAvailableException {
        vg<X> vgVarB = this.b.b(x.getClass());
        if (vgVarB != null) {
            return vgVarB;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean n(@NonNull ti<?> tiVar) {
        return this.d.b(tiVar.c()) != null;
    }

    @NonNull
    public <TResource> Registry o(@NonNull Class<TResource> cls, @NonNull dh<TResource> dhVar) {
        this.d.c(cls, dhVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry p(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ch<Data, TResource> chVar) {
        q("legacy_prepend_all", cls, cls2, chVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry q(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull ch<Data, TResource> chVar) {
        this.c.e(str, chVar, cls, cls2);
        return this;
    }

    @NonNull
    public Registry r(@NonNull ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry s(@NonNull jh.a<?> aVar) {
        this.e.b(aVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry t(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull fn<TResource, Transcode> fnVar) {
        this.f.c(cls, cls2, fnVar);
        return this;
    }

    @NonNull
    public final Registry u(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.c.f(arrayList);
        return this;
    }
}
