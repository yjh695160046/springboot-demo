package com.yijian.javabase.main.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/20 16:22
 * @description: ArrayList底层源码分析
 */
public class ArrayListDemo {
    /**
     * 1.基本概念
     * 继承体系 extends AbstractList<E> implements List<E>, RandomAccess(标志位接口 快速随机访问 get(int index)),
     * Cloneable(该类的对象是允许被克隆的 ),
     * java.io.Serializable(序列化接口)
     * 底层数据结构是数组  查询快(数组优势可通过下标直接取出数据) 、增删慢（极端情况下会将大量的元素进行移位 效率低下）
     */
    public static void main(String[] args) {
        // 无参构造方法 构建了一个长度为10的空数组 Object[] elementData = {};
//        ArrayList<String> arrayList = new ArrayList<>();
        /*
            add():
               add(E e)是ArrayList的核心方法，用于添加元素至列表的末尾
               核心源码解读：
                public boolean add(E e) {
                   // 添加元素之前 要确保数组的容量大小 保证在往ArrayList插入数据时数组不会越界 并实现自动扩容
                   // size参数是未添加元素前的数组中元素数量
                       ensureCapacityInternal(size + 1);  // Increments modCount!!
                   elementData[size++] = e;
                   return true;
                }
                // minCapacity 最小容量 代表含义时执行add操作后数组中元素数量
                private void ensureCapacityInternal(int minCapacity) {
                    ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
                }
                // 计算数组容量 如果当前数组为空 则直接返回DEFAULT_CAPACITY(默认底层数组长度为10)和 minCapacity的最大值 或者返回minCapacity
                private static int calculateCapacity(Object[] elementData, int minCapacity) {
                    // private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
                    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                        return Math.max(DEFAULT_CAPACITY, minCapacity);
                    }
                    // 返回最小容量
                    return minCapacity;
                }

                private void ensureExplicitCapacity(int minCapacity) {
                   // modCount 字段记录ArrayList 被改过多少次 新增删除都算是一种更改
                    modCount++;
                   // overflow-conscious code 扩容操作时有内存溢出的代码
                   // 如果数组元素个数等于数组长度  则进行扩容操作
                   注意点：如果当前数组元素为空 则 minCapacity = 1 而 elementData.length = 0 为ture 初始化扩容 数组长度为10
                   if (minCapacity - elementData.length > 0)
                      grow(minCapacity);
                }
                // 核心逻辑：新的数组长度 = 旧数组长度 + 旧数组长度/2  即每次扩容1.5倍
                private void grow(int minCapacity) {
                   // overflow-conscious code
                   int oldCapacity = elementData.length;
                   // 这里的右移一位相当于除以2
                   int newCapacity = oldCapacity + (oldCapacity >> 1); // 10 + 5
                   // add()和add()都会调用ensureCapacityInternal(), add()是添加一个数组 如果添加的数组元素很多
                       举个例子：
                            ArrayList的默认长度是10 扩容一次之后是15 假设传入之后的数值元素有10个 那么一次扩容还是满足不了
                            这种情况下就直接把minCapacity 赋值给newCapacity
                   if (newCapacity - minCapacity < 0)
                       newCapacity = minCapacity;
                   极端情况 addAll塞入Integer.MAX_VALUE个元素 那么将进行hugeCapacity()处理
                   if (newCapacity - MAX_ARRAY_SIZE > 0)
                       newCapacity = hugeCapacity(minCapacity);
                    // minCapacity is usually close to size, so this is a win:
                    // 真正的扩容java.util中的Arrays.copyOf()
                    elementData = Arrays.copyOf(elementData, newCapacity);
               }
               // 如果溢出直接抛异常 其次保证其容量不会超过Integer.MAX_VALUE
               private static int hugeCapacity(int minCapacity) {
                 if (minCapacity < 0) // overflow
                     throw new OutOfMemoryError();
                 return (minCapacity > MAX_ARRAY_SIZE) ?
                    Integer.MAX_VALUE :
                    MAX_ARRAY_SIZE;
                }

         */
//        arrayList.add("11");
//        arrayList.add("22");
//        arrayList.add("33");
//        arrayList.addAll(new ArrayList<>());
//        createArray();
//        test();
//        String[] elementData = new String[10];
//        int size = 0;
//        String e = ""; github
//        for (int i = 0; i < 10; i++) {
//            size = i;
//            e = i + "";
//        }
//        elementData[size++] = e;
//        System.out.println(size);
//        for (Object elementDatum : elementData) {
//            System.out.println(elementDatum);
//        }
        ArrayList<String> list = new ArrayList<>(1);
        list.add("1");
        list.add("2");
        System.out.println(list.size());


    }

    /**
     * 创建数组 数组缺陷 长度固定
     */
    public static void createArray() {
        // 错误格式1
        // Integer array[] = new Integer[3]{11,22,33};
        // 正确格式
        Integer array[] = new Integer[]{11, 22, 33};
        // 简化写法 定义一个空数组 内存空间已开辟
        Integer array1[] = {};
        Integer[] array2 = new Integer[10];
        System.out.println(array1.length);

    }

    /**
     * array线程不安全体现在添加元素时
     */
    public static void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        List<String> array = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> array.add(Thread.currentThread().getName()));
        }
        System.out.println(array);
        executorService.shutdown();
    }


}
