package com.yijian.javabase.collection;

import java.util.AbstractList;

/**
 * @author: yxyaojinhua
 * @date: 2022/2/11 17:08
 * @description:
 */
public class AbstractListList1 extends AbstractList {
    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(int index, Object element) {
        super.add(index, element);
    }

    public static void main(String[] args) {
        AbstractListList1 list1 = new AbstractListList1();

        list1.replaceAll(o -> 1);



    }
}
