public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        /* создаем массив employee для удобства работы
        с методами класса EmployeeBook
         */
        Employee[] employee = employeeBook.getEmployees();
        // добавляем сотрудников
        System.out.println("добавляем сотрудников");
        employeeBook.addEmployee("Иванов Владимир Иванович");
        employeeBook.addEmployee("Иванов Сергей Иванович");
        employeeBook.addEmployee("Иванов Петр Иванович");
        employeeBook.addEmployee("Иванов Василий Иванович");
        employeeBook.addEmployee("Иванов Матвей Иванович");
        employeeBook.addEmployee("Иванов Евгений Иванович");
        employeeBook.addEmployee("Иванов Иван Иванович");
        // удаляем сотрудника
        System.out.println("***************");
        System.out.println("удаляем сотрудника Иванов Иван Иванович ");
        employeeBook.removeEmployee("Иванов Иван Иванович");
        //добавляем зарплату сотруднику
        System.out.println("***************");
        System.out.println("добавляем зарплату сотруднику Иванов Сергей Иванович");
        employeeBook.changeEmployeeSalary("Иванов Сергей Иванович");
        // изменяем отдел
        System.out.println("***************");
        System.out.println("изменяем отдел сотруднику Иванов Сергей Иванович ");
        employeeBook.changeEmployeeDepartmentNumber("Иванов Сергей Иванович");
        // получаем ФИО всех сотрудников по отделам
        System.out.println("***************");
        System.out.println("получаем ФИО всех сотрудников по отделам");
        employeeBook.printEmployeesByDepartment(employee);
        // Получаем список всех сотрудников со всеми имеющимися по ним данными
        System.out.println("***************");
        System.out.println("Получаем список всех сотрудников со всеми имеющимися по ним данными");
        employeeBook.printEmployee(employee);
        // считаем сумму затрат на зарплаты в месяц
        System.out.println("***************");
        System.out.println(" сумма затрат на зарплаты в месяц "
                + employeeBook.calculateTotalSalaryInTheMonth(employee));
        // ищем сотрудника с минимальной зарплатой
        System.out.println("***************");
        System.out.println("сотрудник с минимальной зарплатой "
                + employeeBook.findEmployeeWithMinSalary(employee));
        // ищем сотрудника с максимальной зарплатой
        System.out.println("***************");
        System.out.println("сотрудник с максимальной зарплатой " + employeeBook.findEmployeeWithMaxSalary(employee));
        // считаем среднее значение зарплат
        System.out.println("***************");
        System.out.println("среднее значение зарплат "
                + employeeBook.calculateAverageSalary(employee));
        //Получить Ф. И. О. всех сотрудников (вывести в консоль)
        System.out.println("***************");
        System.out.println("выводим в консоль ФИО всех сотрудников");
        employeeBook.printFullNameOfAllEmployees(employee);
        // индексируем зарплату всех сотрудников на 10%
        System.out.println("***************");
        System.out.println("индексируем зарплату всех сотрудников на 10%");
        employeeBook.changeSalaryEmployee(employee, 10);
        // Сотрудника с минимальной зарплатой в отделе
        System.out.println("***************");
        System.out.println("Сотрудник с минимальной зарплатой в 3 отделе "
                + employeeBook.findEmployeeWithMinSalary(employee, 3));
        // Сотрудника с максимальной зарплатой в отделе
        System.out.println("***************");
        System.out.println("Сотрудник с максимальной зарплатой в 3 отделе "
                + employeeBook.findEmployeeWithMaxSalary(employee, 3));
        // посчитать сумму затрат на зарплату по отделу 4
        System.out.println("***************");
        System.out.println("сумма затрат на зарплату по 4 отделу "
                + employeeBook.calculateTotalSalaryInTheMonth(employee, 4));
        // посчитать среднюю зарплату по 1 отделу
        System.out.println("***************");
        System.out.println("средняя зарплата по 1 отделу "
                + employeeBook.calculateAverageSalary(employee, 1));
        //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра
        System.out.println("***************");
        System.out.println("индексируем зарплату 2 отдела на 10%");
        employeeBook.changeSalaryEmployee(employee, 2, 10);
        //Напечатать всех сотрудников отдела (все данные, кроме отдела)
        System.out.println("***************");
        System.out.println("Напечатать всех сотрудников 3 отдела (все данные, кроме отдела)");
        employeeBook.printEmployee(employee, 3);
        // выводим в консоль всех сотрудников с зарплатой меньше 140_000 (вывести id, ФИО и зарплату)
        System.out.println("***************");
        System.out.println("выводим в консоль всех сотрудников с зарплатой меньше 140_000 (вывести id, ФИО и зарплату)");
        employeeBook.printEmployeeWithLessSalaryNumber(employee, 140000);
        //выводим в консоль всех сотрудников с зарплатой ,больше 140_000 (вывести id, ФИО и зарплату)
        System.out.println("***************");
        System.out.println("выводим в консоль всех сотрудников с зарплатой ,больше 140_000 (вывести id, ФИО и зарплату)");
        employeeBook.printEmployeeWithMoreSalaryNumber(employee, 140000);
    }
}