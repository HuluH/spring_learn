package com.test;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Reflection {

    public static void main(String[] args) {
        try {
            Object object = Test.class.newInstance();

            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();

            Method m;
            if (str.equals("h")) {
                m = Test.class.getDeclaredMethod("sayh");
            } else if (str.equals("w")) {
                m = Test.class.getDeclaredMethod("sayW");
            }else
                return;

            m.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

