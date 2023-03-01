public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Степан Васильевич", 1, 45000);
        employees[1] = new Employee("Петров Семен Николаевич", 3, 50000);
        employees[2] = new Employee("Сидоров Илья Савельевич", 5, 34000);
        employees[3] = new Employee("Шатунов Сергей Матвеевич", 4, 67854);
        employees[4] = new Employee("Кузнецов Максим Петрович", 2, 98544);
        employees[5] = new Employee("Антипина Фнна Витальевна", 2, 49858);
        employees[6] = new Employee("Володин Николай Владимирович", 5, 123000);
        employees[7] = new Employee("Сиюткина Мария Григорьевна", 1, 78000);
        employees[8] = new Employee("Улыбина Татьяна Павловна", 3, 96000);
        employees[9] = new Employee("Мартынов Георгий Иванович ", 1, 150900);
        System.out.println("Базовая сложность");
        printEmployee(employees);
        System.out.println("***************");
        System.out.println("Сумма затрат на зарплаты в месяц составляет "
                + calculateTotalSalaryInTheMonth(employees) + " рублей");
        System.out.println("***************");
        System.out.println("Самую маленькую зарплату получает: " + findEmployeeWithMinSalary(employees));
        System.out.println("***************");
        System.out.println("Самую большую зарплату получает: " + findEmployeeWithMaxSalary(employees));
        System.out.println("***************");
        System.out.println("Среднее значение зарплат за месяц составляет "
                + calculateAverageSalary(employees) + " рублей");
        System.out.println("***************");
        printFullNameOfAllEmployees(employees);
        System.out.println("***************");
        System.out.println("Повышеная сложность");
        changeSalaryEmployee(employees, 10); // проиндексировали зарплату у всех сотрудников на 10%
        System.out.println("Самую маленькую зарплату из 3-го отдела получает "
                + findEmployeeWithMinSalary(employees, 3));
        System.out.println("***************");
        System.out.println("Самую большую зарплату из 3-го отдела получает "
                + findEmployeeWithMaxSalary(employees, 3));
        System.out.println("***************");
        System.out.println("Сумма затрат на зарплаты 1-го отдела в месяц составляет "
                + calculateTotalSalaryInTheMonth(employees, 1) + " рублей");
        System.out.println("***************");
        System.out.println("Среднее значение зарплат 1-го отдела за месяц составляет "
                + calculateAverageSalary(employees, 1) + " рублей");
        System.out.println("***************");
        changeSalaryEmployee(employees, 10, 2); //проиндексировали зарплаты 2 отдела на 10%
        printEmployee(employees, 3); // выводим в консоль инфу о сотрудниках 3-го отдела
        System.out.println("***************");
        printEmployeeWithLessSalaryNumber(employees, 50000);//выводим в консоль инфу о сотрудниках
        // с зарплатой меньше 50000
        System.out.println("***************");
        printEmployeeWithMoreSalaryNumber(employees, 50000);//выводим в консоль инфу о сотрудниках
        // с зарплатой больше или равно 50000
    }

    //базовая сложность

    /* a. Получить список всех сотрудников со всеми имеющимися по
       ним данными (вывести в консоль значения всех полей (toString)).*/
    public static void printEmployee(Employee[] employee) {
        for (Employee value : employee) {
            System.out.println(value);
        }
    }

    /* b. Посчитать сумму затрат на зарплаты в месяц.*/
    public static double calculateTotalSalaryInTheMonth(Employee[] employee) {
        double sum = 0;
        for (Employee value : employee) {
            sum = sum + value.getSalary();
        }
        return sum;
    }

    /* c. Найти сотрудника с минимальной зарплатой. */
    public static String findEmployeeWithMinSalary(Employee[] employee) {
        double minSalary = Double.MAX_VALUE;
        String name = null;
        for (Employee value : employee) {
            if (value.getSalary() < minSalary) {
                minSalary = value.getSalary();
                name = value.getFullName();
            }
        }
        return name;
    }

    /* d. Найти сотрудника с максимальной зарплатой */
    public static String findEmployeeWithMaxSalary(Employee[] employee) {
        double maxSalary = Double.MIN_VALUE;
        String name = null;
        for (Employee value : employee) {
            if (value.getSalary() > maxSalary) {
                maxSalary = value.getSalary();
                name = value.getFullName();
            }
        }
        return name;
    }

    /* e. Подсчитать среднее значение зарплат */
    public static double calculateAverageSalary(Employee[] employee) {
        return calculateTotalSalaryInTheMonth(employee) / Employee.getIdCount();
    }

    /* f. Получить Ф. И. О. всех сотрудников (вывести в консоль). */
    public static void printFullNameOfAllEmployees(Employee[] employee) {
        System.out.println("Список всех сотрудников:");
        for (Employee value : employee) {
            System.out.println(value.getFullName());
        }
    }

    //повышеная сложность

    /* 1. Проиндексировать зарплату (вызвать изменение зарплат
     у всех сотрудников  на величину аргумента в %).
     */
    public static void changeSalaryEmployee(Employee[] employee, int indexSalary) {
        double newSalary;
        for (Employee value : employee) {
            newSalary = value.getSalary() / 100 * indexSalary + value.getSalary();
            value.setSalary(newSalary);
        }
    }

    /* 2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
          Логика действий будет следующей: все 6 методов есть в заданиях базовой сложности,
          только не хватает параметра отдела поэтому имена медодов не буду менять, а просто
          в параметрах всех методов добавлю "int departmentNumber" и изменю немного логику методов

       a. Сотрудника с минимальной зарплатой. */
    public static String findEmployeeWithMinSalary(Employee[] employee, int departmentNumber) {

        double minSalary = Double.MAX_VALUE;
        String name = null;
        for (Employee value : employee) {
            if (value.getDepartmentNumber() == departmentNumber && value.getSalary() < minSalary) {
                minSalary = value.getSalary();
                name = value.getFullName();
            }
        }
        return name;
    }

    /* b. Сотрудника с максимальной зарплатой. */
    public static String findEmployeeWithMaxSalary(Employee[] employee, int departmentNumber) { //Найти сотрудника с максимальной зарплатой
        double maxSalary = Double.MIN_VALUE;
        String name = null;
        for (Employee value : employee) {
            if (value.getDepartmentNumber() == departmentNumber && value.getSalary() > maxSalary) {
                maxSalary = value.getSalary();
                name = value.getFullName();
            }
        }
        return name;
    }

    /* c. Сумму затрат на зарплату по отделу. */
    public static double calculateTotalSalaryInTheMonth(Employee[] employee, int departmentNumber) { //Посчитать сумму затрат на зарплаты в месяц
        double sum = 0;
        for (Employee value : employee) {
            if (value.getDepartmentNumber() == departmentNumber) {
                sum = sum + value.getSalary();
            }
        }
        return sum;
    }

    /* d. Среднюю зарплату по отделу */
    public static double calculateAverageSalary(Employee[] employee, int departmentNumber) {
        double sum = 0;
        int count = 0;
        for (Employee value : employee) {
            if (value.getDepartmentNumber() == departmentNumber) {
                sum = sum + value.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    /* e. Проиндексировать зарплату всех сотрудников отдела на процент,
          который приходит в качестве параметра.*/
    public static void changeSalaryEmployee(Employee[] employee, int indexSalary, int departmentNumber) { //Проиндексировать зарплату
        double newSalary;
        for (Employee value : employee) {
            if (value.getDepartmentNumber() == departmentNumber) {
                newSalary = value.getSalary() / 100 * indexSalary + value.getSalary();
                value.setSalary(newSalary);
            }
        }
    }

    /* f. Напечатать всех сотрудников отдела (все данные, кроме отдела). */
    public static void printEmployee(Employee[] employee, int departmentNumber) {
        for (Employee value : employee) {
            if (value.getDepartmentNumber() == departmentNumber) {
                System.out.println("ID сотрудника - " + value.getId()
                        + " ФИО - " + value.getFullName()
                        + ", зарплата - " + value.getSalary());
            }
        }
    }

    /*  3. Получить в качестве параметра число и найти:

        a. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль) */
    public static void printEmployeeWithLessSalaryNumber(Employee[] employee, int number) {
        for (Employee value : employee) {
            if (value.getSalary() < number) {
                System.out.println("ID сотрудника - " + value.getId()
                        + " ФИО - " + value.getFullName()
                        + ", номер отдела - " + value.getDepartmentNumber()
                        + ", зарплата - " + value.getSalary());
            }
        }
    }

    /* b. Всех сотрудников с зарплатой больше (или равно) числа
          (вывести id, Ф. И. О. и зарплатой в консоль).*/
    public static void printEmployeeWithMoreSalaryNumber(Employee[] employee, int number) {
        for (Employee value : employee) {
            if (value.getSalary() >= number) {
                System.out.println("ID сотрудника - " + value.getId()
                        + " ФИО - " + value.getFullName()
                        + ", номер отдела - " + value.getDepartmentNumber()
                        + ", зарплата - " + value.getSalary());
            }
        }
    }


}