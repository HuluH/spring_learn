package com.test;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Reflection2 {
    public static void main(String[] args) {
        try {
            Test test = Test.class.newInstance();
            Scanner scanner = new Scanner(System.in);

            String s = scanner.nextLine();
            Integer a = Integer.valueOf(scanner.nextLine());
            Integer b = Integer.valueOf(scanner.nextLine());
            Method m = Test.class.getDeclaredMethod(s,Integer.class,Integer.class);
            System.out.println(m.invoke(test,a,b));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
