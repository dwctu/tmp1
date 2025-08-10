package com.wear.dao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wear.bean.Toy;
import dc.mp1;
import dc.qs1;
import dc.ss1;
import dc.us1;
import java.util.List;

/* loaded from: classes3.dex */
public class ToyDao implements us1 {
    private us1 toyDao;

    public ToyDao() {
        resetUseNew(mp1.h());
    }

    @Override // dc.us1
    public void add(@NonNull Toy toy) {
        this.toyDao.add(toy);
    }

    @Override // dc.us1
    public void clearTable() {
        this.toyDao.clearTable();
    }

    @Override // dc.us1
    public void delT(@NonNull Toy toy) {
        this.toyDao.delT(toy);
    }

    @Override // dc.us1
    public boolean existToyByEmail(@Nullable String str, @NonNull String str2) {
        return this.toyDao.existToyByEmail(str, str2);
    }

    @Override // dc.us1
    @Nullable
    public List<Toy> findAll() {
        return this.toyDao.findAll();
    }

    @Override // dc.us1
    @Nullable
    public Toy findByAddress(@NonNull String str) {
        return this.toyDao.findByAddress(str);
    }

    @Override // dc.us1
    @Nullable
    public List<Toy> findByEmail(@Nullable String str) {
        return this.toyDao.findByEmail(str);
    }

    public us1 getToyDao() {
        return this.toyDao;
    }

    public void resetUseNew(boolean z) {
        if (z) {
            this.toyDao = new qs1();
        } else {
            this.toyDao = new ss1();
        }
    }

    @Override // dc.us1
    public void update(@NonNull Toy toy) {
        this.toyDao.update(toy);
    }

    @Override // dc.us1
    public void updateLedSetting(@NonNull String str, int i) {
        this.toyDao.updateLedSetting(str, i);
    }

    @Override // dc.us1
    public void updateOrAdd(@NonNull Toy toy) {
        this.toyDao.updateOrAdd(toy);
    }

    @Override // dc.us1
    public void update(@NonNull List<? extends Toy> list) {
        this.toyDao.update(list);
    }
}
