package com.yijian.job.config;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/9 10:52
 * @Description:
 */
public final class ListSplitter<E> implements Iterable<List<E>> {
    private final List<E> list;
    private final int batch;

    private final List<List<E>> internalList = new ArrayList<>();

    public ListSplitter(List<E> list, int batch) {
        this.list = list;
        this.batch = batch;
        init();
    }

    private void init() {
        List<E> tmpList = new ArrayList<>(this.list);
        while (tmpList.size() > batch) {
            internalList.add(tmpList.subList(0, batch));
            tmpList = tmpList.subList(batch, tmpList.size());
        }
        if (tmpList.size() > 0) {
            internalList.add(tmpList);
        }
    }

    @Nonnull
    @Override
    public Iterator<List<E>> iterator() {
        return this.internalList.iterator();
    }
}