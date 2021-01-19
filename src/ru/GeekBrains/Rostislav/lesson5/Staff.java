package ru.GeekBrains.Rostislav.lesson5;

public class Staff {
    private String name;
    private String surname;
    private String position;
    private String email;
    private String phone_number;
    private int salary;
    private int age;

    public Staff(String name, String surname, String position, String email, String phone_number, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
    }
    public void printInfoEmployee() {
        System.out.println("Имя: " + name + " Фамилия: " + surname + "; Должность: " + position + "; email: " + email + "; Телефон: " + phone_number + "; Зарплата: " + salary + "; Возраст: " + age);
    }
    public static void main(String[] args) {
        Staff[] ArrayStaff = new Staff[5];
        ArrayStaff[0] = new Staff("Vasilii", "Petrov", "Doctor", "vass@mail.ru", "89162563178", 20000, 42);
        ArrayStaff[1] = new Staff("Djonny", "Depp", "actor","depp@gmail.com", "84956566468", 860000, 53);
        ArrayStaff[2] = new Staff("Leo", "Messi", "footballer", "leopoldvyhodi@ya.ru", "84991284756", 98000, 30);
        ArrayStaff[3] = new Staff("Kolyan", "Pupkin", "king", "king@glavnyi.ru", "89999999999", 999999999, 76);
        ArrayStaff[4] = new Staff("Marpha", "Evlampievna", "milkmaid", "marpha@korova.com", "8454925634", 111, 83);

        for (int i = 0; i < ArrayStaff.length; i++) {
            if(ArrayStaff[i].age > 40) {
                ArrayStaff[i].printInfoEmployee();
            }
        }
    }
}
