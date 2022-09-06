package employee_management;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Employee {
    private Long ID;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String address;
    private String phone;
    private String email;
    private int type;

    private int count;

    private List<employee_management.Certificate> listCertificate;
    public Employee(String firstName, String lastName, String birthDate, String address, String phone, String email, int type) {
        this.ID = this.IdGenerator();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    private Long IdGenerator() {
        return Math.abs(ThreadLocalRandom.current().nextLong(100000000));
    }


    /**
     * get field
     *
     * @return ID
     */
    public Long getID() {
        return this.ID;
    }


    /**
     * get field
     *
     * @return firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * set field
     *
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get field
     *
     * @return lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * set field
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get field
     *
     * @return birthDate
     */
    public String getBirthDate() {
        return this.birthDate;
    }

    /**
     * set field
     *
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * get field
     *
     * @return address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * set field
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get field
     *
     * @return phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * set field
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * get field
     *
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set field
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get field
     *
     * @return type
     */
    public int getType() {
        return this.type;
    }

    /**
     * set field
     *
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public abstract String showInfo();

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", count=" + count +
                ", listCertificate=" + listCertificate +
                "} => ";
    }

    public List<Certificate> getListCertificate() {
        return listCertificate;
    }

    public void setListCertificate(List<Certificate> listCertificate) {
        this.listCertificate = listCertificate;
    }

    public String getName(){
        return this.getFirstName() + " " + this.getLastName();
    }
}
