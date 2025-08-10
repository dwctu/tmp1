package com.wear.bean;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class PatternsHiddenDataBean {
    private int currentPage;
    private List<Map> pageItems;
    private int pageSize;
    private int totalItems;
    private int totalPages;

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<Map> getPageItems() {
        return this.pageItems;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalItems() {
        return this.totalItems;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setPageItems(List<Map> list) {
        this.pageItems = list;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public void setTotalItems(int i) {
        this.totalItems = i;
    }

    public void setTotalPages(int i) {
        this.totalPages = i;
    }
}
