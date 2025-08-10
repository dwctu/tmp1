package com.wear.bean;

import java.util.LinkedList;

/* loaded from: classes3.dex */
public class LimitQueue<E> {
    private int limit;
    private LinkedList<E> queue = new LinkedList<>();

    public LimitQueue(int i) {
        this.limit = i;
    }

    public E get(int i) {
        return this.queue.get(i);
    }

    public E getFirst() {
        return this.queue.getFirst();
    }

    public E getLast() {
        return this.queue.getLast();
    }

    public int getLimit() {
        return this.limit;
    }

    public LinkedList<E> getQueue() {
        return this.queue;
    }

    public void offer(E e) {
        if (this.queue.size() >= this.limit) {
            this.queue.poll();
        }
        this.queue.offer(e);
    }

    public int size() {
        return this.queue.size();
    }
}
