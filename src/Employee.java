public class Employee {
    private String fullName; //ФИО сотрудника
    private int departmentNumber; //номер отдела
    private double salary; //зарплата
    private static int idCount = 0;
    private int id; // счетчик

    public Employee(String fullName, int departmentNumber, double salary) { //создаем конструктор для всех полей
        this.fullName = fullName;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
        this.id = idCount;
        idCount++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getIdCount() {
        return idCount;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "ID сотрудника - " + this.id + ", ФИО сотрудника - " + this.fullName + ", номер отдела - "
                + this.departmentNumber + ", зарплата - " + this.salary + " рублей";
    }
}
