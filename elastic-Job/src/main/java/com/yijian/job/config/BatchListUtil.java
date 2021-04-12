package com.yijian.job.config;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/9 10:33
 * @Description:
 */
public class BatchListUtil<E> {

    /**
     * 把list分成多个批次
     * @param list 集合
     * @param batchSize 批次大小
     * @return Map<Integer,List<E>>
     */
    public  Map<Integer, List<E>> batchList(List<E> list, int batchSize){
        Map<Integer,List<E>> itemMap = new HashMap<>();
        itemMap.put(1, new ArrayList<E>());
        for(E e : list){
            List<E> batchList= itemMap.get(itemMap.size());
            if(batchList.size() == batchSize){//当list满足批次数量，新建一个list存放后面的数据
                batchList = new ArrayList<E>();
                itemMap.put(itemMap.size()+1, batchList);
            }
            batchList.add(e);
        }
        return itemMap;
    }

    public static void main(String[] args) {

        //List<Integer> asList = Arrays.asList(2, 2, 2, 2, 2, 2, 2, 22, 2, 2, 2);
        List<Integer> intList = Lists.newArrayList(1, 2, 33, 43, 5, 63, 7, 8,13, 23, 3, 43, 53, 6, 37, 8);
        final List<Long> longs = new ArrayList<>();
        //Map<Integer, List<Integer>> groups =
        //        intList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 3));
        //List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());
        //System.out.println(subSets);
        //System.out.println(splitList(intList, 3));
        IntStream.range(0, 2).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                longs.add((long) value);
            }
        });
        //ListSplitter<Long> listSplitter = new ListSplitter<>(longs ,3);
        //for (List<Long> longList : listSplitter) {
        //    System.out.println(longList);
        //}
      //  System.out.println(averageAssign(longs, 3));

        for (int i = 0; i <10 ; i++) {
            System.out.println(beforeDayByNowDay(i * -1));
        }
    }

    static List<List<Integer>> splitList(List<Integer> list , int groupSize){
        return  Lists.partition(list, groupSize); // 使用guava进行分组
    }

    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = source.size() % n;  //(先计算出余数)
        int number = source.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }


    public static String beforeDayByNowDay(int i){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, i); //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
}
