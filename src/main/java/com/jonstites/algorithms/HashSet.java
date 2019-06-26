package com.jonstites.algorithms;

import java.util.ArrayList;

public class HashSet<T> {
    private int size;
    private ArrayList<ArrayList<T>> data;

    public HashSet() {
        this.size = 0;
        this.data = new ArrayList<>();
        this.data.add(new ArrayList<>());
    }

    public boolean add(T item) {

        if (this.size + 1 > this.data.size()) {
            ArrayList<ArrayList<T>> oldData = this.data;

            int newLength = this.data.size() * 2 + 1;
            this.data = new ArrayList<>();
            this.size = 0;
            for (int i=0; i < newLength; i++) {
                this.data.add(new ArrayList<>());
            }

            for (ArrayList<T> list: oldData) {
                for (T item2: list) {
                    add(item2);
                }
            }
        }

        int index = this.indexOf(item);
        for (T item2: this.data.get(index)) {
            if (item2.equals(item)) {
                return false;
            }
        }

        this.data.get(index).add(item);
        this.size += 1;
        return true;
    }

    int indexOf(T item) {
        return item.hashCode() % this.data.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean contains(T item) {
        int index = indexOf(item);

        for (T item2: this.data.get(index)) {
            if (item2.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(T item) {
        int index = indexOf(item);
        boolean removed = this.data.get(index).remove(item);
        if (removed) {
            this.size -= 1;
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.data = new ArrayList<>();
        this.data.add(new ArrayList<>());
        this.size = 0;
    }
}