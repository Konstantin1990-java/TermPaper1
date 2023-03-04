
public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public Employee[] getEmployees() {
        return employees;
    }

    /*Очень сложно
     a. Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив).
     Нужно найти свободную ячейку в массиве и добавить нового сотрудника в нее.
     Искать нужно всегда с начала, так как возможно добавление в ячейку удаленных ранее сотрудников.
     */
    public void addEmployee(String fullName) {
        if (size >= employees.length) {
            System.out.println("Нульзя добавить сотрудника, закончились вакансии ");
            return;
        }
        int departmentNumber = (int) (Math.random() * 5 + 1); // случайное число от 1 до 5
        double salary = Math.random() * 250000 + 30000; // случайное число от 30_000 до 250_000
        Employee newEmployee = new Employee(fullName, departmentNumber, salary);
        employees[size++] = newEmployee;

    }

    // b. Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве).
    public void removeEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                System.out.println(employees[i].getFullName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
            }
            return;
        }
    }

    /* 5.  Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
       a. Изменить зарплату.*/
    public void changeEmployeeSalary(String fullName) {
        for (Employee employee : employees)
            if (employee == null) {
                return;
            } else if (employee.getFullName().equals(fullName)) {
                double salary = employee.getSalary() + Math.random() * 10000 + 1000;
                employee.setSalary(salary);
            }

    }

    // b. Изменить отдел.
    public void changeEmployeeDepartmentNumber(String fullName) {
        for (Employee employee : employees) {
            if (employee == null) {
                return;
            } else if (employee.getFullName().equals(fullName)) {
                int departmentNumber = (int) (Math.random() * 5 + 1);
                employee.setDepartmentNumber(departmentNumber);
            }
        }
    }

    // 6. Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
    public void printEmployeesByDepartment(Employee[] employee) {
        for (Employee value : employee) {
            if (value == null) {
                return;
            } else {
                System.out.println("Номер отдела сотрудника - " + value.getDepartmentNumber()
                        + ", ФИО сотрудника - " + value.getFullName());
            }
        }
    }

    // Базовая сложность
    /* a. Получить список всех сотрудников со всеми имеющимися по
            ним данными (вывести в консоль значения всех полей (toString)).*/
    public void printEmployee(Employee[] employee) {
        for (Employee value : employee) {
            System.out.println(value);
        }
    }

    /* b. Посчитать сумму затрат на зарплаты в месяц.*/
    public double calculateTotalSalaryInTheMonth(Employee[] employee) {
        double sum = 0;
        for (Employee value : employee) {
            if (value == null) {
                break;
            } else {
                sum = sum + value.getSalary();
            }
        }
        return sum;
    }

    /* c. Найти сотрудника с минимальной зарплатой. */
    public String findEmployeeWithMinSalary(Employee[] employee) {
        double minSalary = Double.MAX_VALUE;
        String name = null;
        for (Employee value : employee) {
            if (value == null) {
                break;
            } else if (value.getSalary() < minSalary) {
                minSalary = value.getSalary();
                name = value.getFullName();
            }
        }
        return name;
    }

    /* d. Найти сотрудника с максимальной зарплатой */
    public String findEmployeeWithMaxSalary(Employee[] employee) {
        double maxSalary = Double.MIN_VALUE;
        String name = null;
        for (Employee value : employee) {
            if (value == null) {
                break;
            } else if (value.getSalary() > maxSalary) {
                maxSalary = value.getSalary();
                name = value.getFullName();
            }
        }
        return name;
    }

    /* e. Подсчитать среднее значение зарплат */
    public double calculateAverageSalary(Employee[] employee) {
        int count = 0;
        double sum = 0;
        for (Employee value : employee) {
            if (value == null) {
                break;
            } else {
                sum = sum + value.getSalary();
                count++;
            }
        }

        return sum / count;
    }

    /* f. Получить Ф. И. О. всех сотрудников (вывести в консоль). */
    public void printFullNameOfAllEmployees(Employee[] employee) {
        System.out.println("Список всех сотрудников:");
        for (Employee value : employee) {
            if (value == null) {
                return;
            } else {
                System.out.println(value.getFullName());
            }
        }
    }

    //повышеная сложность

    /* 1. Проиндексировать зарплату (вызвать изменение зарплат
     у всех сотрудников  на величину аргумента в %).
     */
    public void changeSalaryEmployee(Employee[] employee, int indexSalary) {
        double newSalary;
        for (Employee value : employee) {
            if (value == null) {
                return;
            } else {
                newSalary = value.getSalary() / 100 * indexSalary + value.getSalary();
                value.setSalary(newSalary);
            }
        }
    }

    /* 2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
          Логика действий будет следующей: все 6 методов есть в заданиях базовой сложности,
          только не хватает параметра отдела поэтому имена медодов не буду менять, а просто
          в параметрах всех методов добавлю "int departmentNumber" и изменю немного логику методов

       a. Сотрудника с минимальной зарплатой. */
    public String findEmployeeWithMinSalary(Employee[] employee, int departmentNumber) {

        double minSalary = Double.MAX_VALUE;
        String name = null;
        for (Employee value : employee) {
            if (value == null) {
                break;
            } else if (value.getDepartmentNumber() == departmentNumber && value.getSalary() < minSalary) {
                minSalary = value.getSalary();
                name = value.getFullName();
            }
        }
        return name;
    }

    /* b. Сотрудника с максимальной зарплатой. */
    public String findEmployeeWithMaxSalary(Employee[] employee, int departmentNumber) { //Найти сотрудника с максимальной зарплатой
        double maxSalary = Double.MIN_VALUE;
        String name = null;
        for (Employee value : employee) {
            if (value == null) {
                break;
            } else if (value.getDepartmentNumber() == departmentNumber && value.getSalary() > maxSalary) {
                maxSalary = value.getSalary();
                name = value.getFullName();
            }
        }
        return name;
    }

    /* c. Сумму затрат на зарплату по отделу. */
    public double calculateTotalSalaryInTheMonth(Employee[] employee, int departmentNumber) { //Посчитать сумму затрат на зарплаты в месяц
        double sum = 0;
        for (Employee value : employee) {
            if (value == null) {
                break;
            } else if (value.getDepartmentNumber() == departmentNumber) {
                sum = sum + value.getSalary();
            }
        }
        return sum;
    }

    /* d. Среднюю зарплату по отделу */
    public double calculateAverageSalary(Employee[] employee, int departmentNumber) {
        double sum = 0;
        int count = 0;
        for (Employee value : employee) {
            if (value == null) {
                break;
            } else if (value.getDepartmentNumber() == departmentNumber) {
                sum = sum + value.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    /* e. Проиндексировать зарплату всех сотрудников отдела на процент,
          который приходит в качестве параметра.*/
    public void changeSalaryEmployee(Employee[] employee, int indexSalary, int departmentNumber) { //Проиндексировать зарплату
        double newSalary;
        for (Employee value : employee) {
            if (value == null) {
                return;
            } else if (value.getDepartmentNumber() == departmentNumber) {
                newSalary = value.getSalary() / 100 * indexSalary + value.getSalary();
                value.setSalary(newSalary);
            }
        }
    }

    /* f. Напечатать всех сотрудников отдела (все данные, кроме отдела). */
    public void printEmployee(Employee[] employee, int departmentNumber) {
        for (Employee value : employee) {
            if (value == null) {
                return;
            } else if (value.getDepartmentNumber() == departmentNumber) {
                System.out.println("ID сотрудника - " + value.getId()
                        + " ФИО - " + value.getFullName()
                        + ", зарплата - " + value.getSalary());
            }
        }
    }

    /*  3. Получить в качестве параметра число и найти:

        a. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль) */
    public void printEmployeeWithLessSalaryNumber(Employee[] employee, int number) {
        for (Employee value : employee) {
            if (value == null) {
                return;
            } else if (value.getSalary() < number) {
                System.out.println("ID сотрудника - " + value.getId()
                        + " ФИО - " + value.getFullName()
                        + ", зарплата - " + value.getSalary());
            }
        }
    }

    /* b. Всех сотрудников с зарплатой больше (или равно) числа
          (вывести id, Ф. И. О. и зарплатой в консоль).*/
    public void printEmployeeWithMoreSalaryNumber(Employee[] employee, int number) {
        for (Employee value : employee) {
            if (value == null) {
                return;
            } else if (value.getSalary() >= number) {
                System.out.println("ID сотрудника - " + value.getId()
                        + " ФИО - " + value.getFullName()
                        + ", зарплата - " + value.getSalary());
            }
        }
    }


}
