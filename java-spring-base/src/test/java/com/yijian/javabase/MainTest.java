package com.yijian.javabase;

/**
 * @author: yaojinhua
 * @date: 2021/4/30 16:42
 * @description:
 */
public class MainTest {


    public static void main(String[] args) throws Exception {


        //
        //ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        //Car car = (Car) classPathXmlApplicationContext.getBean("car");
        //Car car1 = (Car) classPathXmlApplicationContext.getBean("car1");
        //
        //System.out.println(car == car1);

        for (int i = 0; i < 1; i++) {
            System.out.println(i);
        }
        int dividend = 21794711, divisor = 1024 * 1024 * 4;

        int quotient = dividend / divisor;

        int remainder = dividend % divisor;


        System.out.println("商 = " + quotient);

        System.out.println("余数 = " + remainder);
        Long offset = 10l;

        for (int i = 0; i < 5; i++) {
            test(offset);
            offset = offset + 10;
        }


        System.out.println(offset);


        int i = 0;
        for (int j = 0; j < i; j++) {
            System.out.println("ccc" + j);
        }





        double first = 3.2d;
        int second = (int)first + 2;
        System.out.println("second" + second);



        // 创建对象的几种方式

        // new 关键字

        //
        //System.out.println(LocalDate.now(ZoneId.systemDefault()));
        //System.out.println(LocalTime.now(ZoneId.systemDefault()));
        //System.out.println(LocalDateTime.now(ZoneId.systemDefault()));
        //
        //System.out.println(OffsetTime.now(ZoneId.systemDefault()));
        //System.out.println(OffsetDateTime.now(ZoneId.systemDefault()));
        //System.out.println(ZonedDateTime.now(ZoneId.systemDefault()));
        //
        //System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()));
        //System.out.println(DateTimeFormatter.ISO_LOCAL_TIME.format(LocalTime.now()));
        //System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
    }


    public static boolean test(Long offset) {
        System.out.println(offset);
        return false;
    }
}
