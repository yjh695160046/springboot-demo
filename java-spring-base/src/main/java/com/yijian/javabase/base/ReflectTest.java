package com.yijian.javabase.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: yxyaojinhua
 * @date: 2022/2/15 15:01
 * @description:
 */
public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Customer> customerClass = Customer.class;
        Constructor<?>[] constructors = customerClass.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
        Constructor<Customer> constructor1 = customerClass.getConstructor();
        System.out.println(constructor1);
//        Constructor<Customer> constructor2 = customerClass.getConstructor(Integer.class, String.class);
//        System.out.println(constructor2);

        System.out.println(customerClass.getDeclaredConstructor(String.class));

//      ----------
        Method[] methods = customerClass.getMethods();
        Arrays.stream(methods).forEach(System.out::println);
        System.out.println(customerClass.getMethod("notify"));

        System.out.println(customerClass.getDeclaredMethod("test", String.class));


        Field[] fields = customerClass.getFields();
        Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));
        System.out.println(customerClass.getField("name1").getName());

        Arrays.stream(customerClass.getDeclaredFields()).forEach(System.out::println);
        Annotation[] annotations = customerClass.getDeclaredAnnotations();
        Arrays.stream(annotations).forEach(annotation -> System.out.println(annotation.getClass()));

        Class<Integer> clazz = Integer.class;
        System.out.println(clazz.getMethods().length);

        // 获取时无序数组
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            if (constructor.getParameterCount() == 0){
                System.out.println(constructor.newInstance());
            }
            if (constructor.getParameterCount() == 1){
//                 && !constructor.getParameterTypes()
            }
        }
        Customer customer = constructor1.newInstance();
//        for (Method method : customerClass.getDeclaredMethods()) {
//            int parameterCount = method.getParameterCount();
//            if(parameterCount == 1 && method.getName().equals("test")){
//                method.setAccessible(true);
//                method.invoke(customer);
//            }
//
//        }
        Method test = customerClass.getDeclaredMethod("test", String.class);
        test.setAccessible(true);
        test.invoke(customer, "1");
        customerClass.getDeclaredMethod("test");
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer extends FuPerson {

    private Integer age;

    private String name;
    public String name1;
    public final String name2 = "2";

    private Customer(Integer age) {
        this.age = age;
    }
    protected Customer(String name) {
        this.name = name;
    }
    private void test(String test) {
        System.out.println(test);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class FuPerson {

    private Double personage;

    private Long personName;
    public Long personName1;

    private FuPerson(Double personage) {
        this.personage = personage;
    }
    private void fuPersonTest() {
        System.out.println("FuPerson test");
    }
}
