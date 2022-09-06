package employee_management;

public class Internship extends Employee {
    private String major;
    private String semester;
    private String university;

    public Internship(String firstName, String lastName, String birthDate,
                      String address, String phone, String email, int type, String major, String semester, String university) {
        super(firstName, lastName, birthDate, address, phone, email, type);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }


    /**
     * get field
     *
     * @return major
     */
    public String getMajor() {
        return this.major;
    }

    /**
     * set field
     *
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * get field
     *
     * @return semester
     */
    public String getSemester() {
        return this.semester;
    }

    /**
     * set field
     *
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * get field
     *
     * @return university
     */
    public String getUniversity() {
        return this.university;
    }

    /**
     * set field
     *
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String showInfo() {
        return super.toString() + this.toString();
    }

    @Override
    public String toString() {
        return "Internship{" +
                "major='" + major + '\'' +
                ", semester='" + semester + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}
