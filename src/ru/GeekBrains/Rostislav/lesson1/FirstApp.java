package ru.GeekBrains.Rostislav.lesson1;

public class FirstApp {
    public static void main(String[] args)
    {
        //ДЗ п.1 Создать пустой проект в IntelliJ IDEA и прописать метод main().
        // к этой строке уже сделано :)

        // операторы ввода из консоли пока не учили, поэтому значения задаю здесь :)

        //ДЗ п.2
        byte a = -95;
        short b = 1226;
        int c = 23148;
        long d = 856565433L;
        float e = 45.123f;
        double f = 457.15689;
        boolean g = true;
        char h = '#';
        String j = "строка произвольная";
        System.out.println("Результат выполнения п.2 ДЗ");
        System.out.println("Созданы переменные следующих типов и инициалированы соответствующими значениями");
        System.out.println("byte a = " + a);
        System.out.println("short b = " + b);
        System.out.println("int c = " + c);
        System.out.println("long d = " + d);
        System.out.println("float e = " + e);
        System.out.println("double f = " + f);
        System.out.println("boolean g = " + g);
        System.out.println("char h = " + h);
        System.out.println("String j = " + j);
        System.out.println(); // Как по другому вставлять пустые строки при выводе в консоль?

        //ДЗ п.3
        System.out.println("Результат вычисления п.3 ДЗ");
        System.out.println(arithmetic(1.2f,4.5f,-89.6f,4.1f));
        System.out.println();

        //ДЗ п.4
        System.out.println("Выполнение п.4 ДЗ");
        System.out.println("Проверка, что сумма чисел >= 10, но <= 20");
        int m = 8;
        int n = 7;
        System.out.println("Результат проверки " + summ(m,n));
        System.out.println();

        //ДЗ п.5
        System.out.println("Выполнение п.5 ДЗ");
        System.out.println("Проверка знака числа");
        int l = -12;
        isItPositive (l);
        System.out.println();

        //ДЗ п.6
        System.out.println("Выполнение п.6 ДЗ");
        int r = 89;
        System.out.println("Переданное число отрицательное? " + isItNegative(r));
        System.out.println();

        //ДЗ п.7
        System.out.println("Выполнение п.7 ДЗ");
        String name = "Коля";
        helloX(name);
        System.out.println();

        //ДЗ п.8
        System.out.println("Выполнение п.8 ДЗ");
        int year = 1764;
        isItLeapYear(year);
        }

    //ДЗ п.3
    public static float arithmetic (float a, float b, float c, float d)
    {
        return a*(b+(c/d));
    }

    //ДЗ п.4
    public static boolean summ (int a, int b)
    {
        if(a+b>=10 && a+b<=20) return true;

        else return false;
    }

    //ДЗ п.5
    public static void isItPositive (int a)
    {
        if(a>=0)
        {
            System.out.println("Передано положительное число");
        } else
            System.out.println("Передано отрицательное число");
    }

    //ДЗ п.6
    public static boolean isItNegative (int b)
    {
        if(b<0) return true;
         else
            return false;
    }

    //ДЗ п.7
    public static void helloX (String name)
    {
        System.out.println("Привет, " + name + "!");
    }

    //ДЗ п.8
    public static void isItLeapYear (int year)
    {
        boolean s = true; //для удобного выхода изнутри цикла
        int j = 0; //для проверки через 100 и 400 лет
        int i = 0; //для проверки через 4 года
        while (i<=year) // проверка високосности от 0 года до заданного (нулевой - високосный)
        {
           if(i==year) // проверка високосности без "поправок"
           {
               if(j % 25 == 0 && j % 100 != 0) // учет исключений через 100 и 400 лет (каждые 4 года j увеличивается на 1)
               {
                   System.out.println(year + " год не високосный"); // сработало исключение
                   s = false;
                   break;
               }
               System.out.println(year + " год високосный!"); // нет исключений
               s = false;
               break;
           } else
               i+=4; // от нулевого високосного года прибавляем по 4 года за цикл
                j++; // для учета исключений
        }
        if(s)   // если перебор всех високосных годов не дал совпадения с заданным
        {
            System.out.println(year + " год не високосный");
        }

    }
}
