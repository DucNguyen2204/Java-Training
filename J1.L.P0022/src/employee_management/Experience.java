package employee_management;

public class Experience extends Employee {
    private int expYear;
    private String proSkill;


    public Experience(String firstName, String lastName, String birthDate,
                      String address, String phone, String email, int type, int expYear, String proSkill) {
        super(firstName, lastName, birthDate, address, phone, email, type);
        this.expYear = expYear;
        this.proSkill = proSkill;
    }


    /**
     * get field
     *
     * @return expYear
     */
    public int getExpYear() {
        return this.expYear;
    }

    /**
     * set field
     *
     * @param expYear
     */
    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    /**
     * get field
     *
     * @return proSkill
     */
    public String getProSkill() {
        return this.proSkill;
    }

    /**
     * set field
     *
     * @param proSkill
     */
    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expYear=" + expYear +
                ", proSkill='" + proSkill + '\'' +
                '}';
    }

    @Override
    public String showInfo() {
        return super.toString() + this.toString();
    }
}
