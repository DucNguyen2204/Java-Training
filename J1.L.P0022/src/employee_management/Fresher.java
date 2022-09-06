package employee_management;

public class Fresher extends Employee {
    private String gradDate;
    private String gradRank;
    private String university;

    public Fresher(String firstName, String lastName, String birthDate,
                   String address, String phone, String email, int type, String gradDate, String gradRank, String university) {
        super(firstName, lastName, birthDate, address, phone, email, type);
        this.gradDate = gradDate;
        this.gradRank = gradRank;
        this.university = university;
    }


    /**
     * get field
     *
     * @return gradDate
     */
    public String getGradDate() {
        return this.gradDate;
    }

    /**
     * set field
     */
    public void setGradDate(String gradDate) {
        this.gradDate = gradDate;
    }

    /**
     * get field
     *
     * @return gradRank
     */
    public String getGradRank() {
        return this.gradRank;
    }

    /**
     * set field
     *
     * @param gradRank
     */
    public void setGradRank(String gradRank) {
        this.gradRank = gradRank;
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
     * @param university
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "gradDate='" + gradDate + '\'' +
                ", gradRank='" + gradRank + '\'' +
                ", university='" + university + '\'' +
                '}';
    }

    @Override
    public String showInfo() {
        return super.toString() + this.toString();
    }
}
