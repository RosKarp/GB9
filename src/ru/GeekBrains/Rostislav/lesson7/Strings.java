package ru.GeekBrains.Rostislav.lesson7;

public class Strings {

    public static void main(String[] args) {
        testString("I like Java!!!");
    }

    private static void testString(String a) {

        // 7.а
            System.out.println(a);

        // 7.б
            System.out.println(a.charAt(a.length() - 1));

        // 7.в
            System.out.println(a.endsWith("!!!"));

        // 7.г
            System.out.println(a.startsWith("I like"));

        // 7.д
            System.out.println(a.contains("Java"));

        // 7.е
            System.out.println(a.indexOf("Java"));

        // 7.ж
            System.out.println(a.replace('a','o'));

        // 7.з
            System.out.println(a.toUpperCase());

        // 7.и
            System.out.println(a.toLowerCase());

        //7.к
            String subStr = "Java";
            int beginIndex = a.indexOf(subStr);
            int endIndex = beginIndex + subStr.length();
        System.out.println(a.substring(beginIndex, endIndex));
        // Ввиду острой нехватки времени комментарии не писал, извините.
    }
}
