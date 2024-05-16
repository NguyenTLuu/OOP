abstract class Employee {
    protected String employeeId;
    protected String employeeName;
    protected int yearOfBirth;
    protected String address;
    protected String phone;

    public Employee(String employeeId, String employeeName, int yearOfBirth, String address, String phone) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.phone = phone;
    }

    public Employee() {

    }

    public abstract String getInfo();

    public abstract float getSalary();
}
