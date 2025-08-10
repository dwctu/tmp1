package com.wear.dao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wear.bean.ToyType;
import dc.mp1;
import dc.rs1;
import dc.ts1;
import dc.vs1;
import java.util.List;

/* loaded from: classes3.dex */
public class ToyTypeDao implements vs1 {
    private vs1 toyTypeDao;

    public ToyTypeDao() {
        resetUseNew(mp1.h());
    }

    @Override // dc.vs1
    public void add(@NonNull ToyType toyType) {
        this.toyTypeDao.add(toyType);
    }

    @Override // dc.vs1
    public void clearTable() {
        this.toyTypeDao.clearTable();
    }

    @Override // dc.vs1
    @Nullable
    public List<ToyType> findAll() {
        return this.toyTypeDao.findAll();
    }

    @Override // dc.vs1
    @Nullable
    public ToyType findToyType(@NonNull String str) {
        return this.toyTypeDao.findToyType(str);
    }

    @Override // dc.vs1
    public boolean isExistToyType(@NonNull String str) {
        return this.toyTypeDao.isExistToyType(str);
    }

    public void resetUseNew(boolean z) {
        if (z) {
            this.toyTypeDao = new rs1();
        } else {
            this.toyTypeDao = new ts1();
        }
    }

    @Override // dc.vs1
    public int totalNumber() {
        return this.toyTypeDao.totalNumber();
    }

    @Override // dc.vs1
    public void update(@NonNull ToyType toyType) {
        this.toyTypeDao.update(toyType);
    }
}
