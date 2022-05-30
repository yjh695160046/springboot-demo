package com.yijian.javabase.collection;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author: yxyaojinhua
 * @date: 2022/2/11 16:10
 * @description:  实现AbstractCollection 保证不可变集合
 */
public class NotChangeCollection extends AbstractCollection {

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String[] args) {
        Collection notChangeCollection = new NotChangeCollection();
        Iterator iterator = notChangeCollection.iterator();
        boolean b = iterator.hasNext();
        System.out.println(b);
    }
}
