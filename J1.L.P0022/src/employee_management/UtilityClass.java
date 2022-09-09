package employee_management;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public final class UtilityClass {
    public static List<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String format = "%8s%-25s%n";

    private UtilityClass() {
        throw new UnsupportedOperationException("Utility Class cannot be instantiated");
    }

    public static int printMenu() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.printf(format, "", "1. Experience");
        System.out.printf(format, "", "2. Fresher");
        System.out.printf(format, "", "3. Internship");
        System.out.printf(format, "", "4. Searching");
        System.out.printf(format, "", "5. Update");
        System.out.printf(format, "", "6. Report");
        System.out.printf(format, "", "7. Report to file");
        System.out.printf(format, "", "8. Exit");
        System.out.println(" (Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program).");
        return scanner.nextInt();
    }

    public static void printListCandidate() {
        if (employees.size() > 0) {
            System.out.println("List of Candidate");
            System.out.println("==========EXPERIENCE CANDIDATE==========");
            employees.forEach(employee -> {
                if (employee instanceof Experience)
                    System.out.println(employee.showInfo());
            });
            System.out.println("==========FRESHER CANDIDATE==========");
            employees.forEach(employee -> {
                if (employee instanceof Fresher)
                    System.out.println(employee.showInfo());
            });
            System.out.println("==========INTERNSHIP CANDIDATE==========");
            employees.forEach(employee -> {
                if (employee instanceof Internship)
                    System.out.println(employee.showInfo());
            });
        }
    }

    public static void outPutEmployeesToFile() throws IOException {
        boolean result = Files.deleteIfExists(Path.of("employee_list.txt"));
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("employee_list.txt"), "utf-8"))) {

            if (employees.size() > 0) {
                writer.write("List of Candidate\n");
                writer.write("==========EXPERIENCE CANDIDATE==========\n");
                employees.forEach(employee -> {
                    if (employee instanceof Experience) {
                        try {
                            writer.write(employee.showInfo() + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                writer.write("==========FRESHER CANDIDATE==========\n");
                employees.forEach(employee -> {
                    if (employee instanceof Fresher) {
                        try {
                            writer.write(employee.showInfo() + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                writer.write("==========INTERNSHIP CANDIDATE==========\n");
                employees.forEach(employee -> {
                    if (employee instanceof Internship) {
                        try {
                            writer.write(employee.showInfo() + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createExp() {
        scanner.nextLine();
        String option = "";
        while (!option.equalsIgnoreCase("n")) {
            Map<String, String> basicInfo = gatherBasicInfo();
            int yearExp;
            do {
                System.out.println("Please enter year of experience (0-100): ");
                yearExp = Integer.parseInt(scanner.nextLine());
            } while (yearExp < 0 || yearExp > 100);

            System.out.println("Please enter your professional skill: ");
            String proSkill = scanner.nextLine();
            Employee e = new Experience(basicInfo.get("firstName"), basicInfo.get("lastName"), basicInfo.get("birthDate"), basicInfo.get("address"), basicInfo.get("phone"), basicInfo.get("email"), 0, yearExp, proSkill);
            e.setListCertificate(addCertificate());
            employees.add(e);
            System.out.println("Do you want to continue (y/n) ?");
            option = scanner.nextLine();
        }
    }

    public static void createFresher() {
        scanner.nextLine();
        String option = "";
        while (!option.equalsIgnoreCase("n")) {
            Map<String, String> basicInfo = gatherBasicInfo();
            System.out.println("Please enter your graduation date (year): ");
            String gradDate = scanner.nextLine();
            System.out.println("Please enter your university: ");
            String university = scanner.nextLine();
            String rankGrad = null;
            do {
                System.out.println("Please enter your rank of graduation: ");
                System.out.printf(format, "", "1. Excellence");
                System.out.printf(format, "", "2. Good");
                System.out.printf(format, "", "3. Fair");
                System.out.printf(format, "", "4. Poor");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> rankGrad = "Excellence";
                    case 2 -> rankGrad = "Good";
                    case 3 -> rankGrad = "Fair";
                    case 4 -> rankGrad = "Poor";
                    default -> System.out.println("Invalid rank!");
                }
            } while (!Validator.checkRank(rankGrad));
            scanner.nextLine();
            Employee f = new Fresher(basicInfo.get("firstName"), basicInfo.get("lastName"), basicInfo.get("birthDate"), basicInfo.get("address"), basicInfo.get("phone"), basicInfo.get("email"), 1, gradDate, rankGrad, university);
            f.setListCertificate(addCertificate());
            employees.add(f);
            System.out.println("Do you want to continue (y/n) ?");
            option = scanner.nextLine();
        }
    }

    public static void createIntern() {
        scanner.nextLine();
        String option = "";
        while (!option.equalsIgnoreCase("n")) {
            Map<String, String> basicInfo = gatherBasicInfo();
            System.out.println("Please enter your major: ");
            String major = scanner.nextLine();
            System.out.println("Please enter your semester: ");
            String semester = scanner.nextLine();
            System.out.println("Please enter your University: ");
            String university = scanner.nextLine();
            Employee i = new Internship(basicInfo.get("firstName"), basicInfo.get("lastName"), basicInfo.get("birthDate"), basicInfo.get("address"), basicInfo.get("phone"), basicInfo.get("email"), 2, major, semester, university);
            i.setListCertificate(addCertificate());
            employees.add(i);
            System.out.println("Do you want to continue (y/n) ?");
            option = scanner.nextLine();
        }
    }

    private static List<Certificate> addCertificate() {
        List<Certificate> certificates = new ArrayList<>();
        String option = "";
        while (!option.equalsIgnoreCase("n")) {
            System.out.println("Please enter certificate name: ");
            String certificateName = scanner.nextLine();
            System.out.println("Please enter certificateRank: ");
            String certificateRank = scanner.nextLine();
            System.out.println("Please enter certificate date: ");
            String date = scanner.nextLine();
            Certificate c = new Certificate(certificateName, certificateRank, date);
            certificates.add(c);
            System.out.println("Do you have more certificates to add (y/n): ");
            option = scanner.nextLine();
        }
        return certificates;
    }

    public static void search() {
        scanner.nextLine();
        System.out.println("Input candidate's name (First or Last name): ");
        String name = scanner.nextLine();
        System.out.println("Input candidate type (0-2): ");
        int type = scanner.nextInt();
        List<Employee> result = employees.stream().filter(employee -> employee.getName().toLowerCase().contains(name.toLowerCase()) && employee.getType() == type).toList();
        result.forEach(employee -> System.out.println(employee.getID() + "|" + employee.getName() + "|" + employee.getBirthDate() + "|" + employee.getAddress() + "|" + employee.getPhone() + "|" + employee.getEmail() + "|" + employee.getType()));
    }

    private static Map<String, String> gatherBasicInfo() {
        Map<String, String> answers = new HashMap<>();
        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();
        String birthDate = null;
        String email = null;
        String phone = null;
        while (true) {
            System.out.println("Please enter your birth date: ");
            birthDate = scanner.nextLine();
            try {
                if (Validator.checkBirthDate(birthDate)) {
                    answers.put("birthDate", birthDate);
                    break;
                }
            } catch (BirthDayException e) {
                System.err.println(e);
            }
        }
        System.out.println("Please enter your address: ");
        String address = scanner.nextLine();
        while (true) {
            System.out.println("Please enter your phone number (starts with 03/09/06) : ");
            phone = scanner.nextLine();
            try {
                if (Validator.checkPhone(phone)) {
                    answers.put("phone", phone);
                    break;
                }
            } catch (PhoneException e) {
                System.err.println(e);
            }
        }

        while (true) {
            System.out.println("Please enter your email: ");
            email = scanner.nextLine();
            try {
                if (Validator.checkEmail(email)) {
                    answers.put("email", email);
                    break;
                }
            } catch (EmailException e) {
                System.err.println(e);
            }

        }

        answers.put("firstName", firstName);
        answers.put("lastName", lastName);
        answers.put("address", address);

        return answers;
    }


    public static void updateEmployee() {
        scanner.nextLine();
        System.out.println("Please enter employee's id: ");
        long id = Long.parseLong(scanner.nextLine());
        Optional<Employee> e = employees.stream().filter(employee ->
                employee.getID() == id).findAny();
        e.ifPresent(employee -> {
            System.out.println(employee.showInfo());
            System.out.println("Please enter options: ");
            System.out.printf(format, "", "1. Remove");
            System.out.printf(format, "", "2. Update");
            int option = scanner.nextInt();
            if (option == 1) {
                employees.remove(employee);
            } else if (option == 2) {
                int choice = printUpdateMenu();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Please enter your first name: ");
                        String firstName = scanner.nextLine();
                        System.out.println("Please enter your last name: ");
                        String lastName = scanner.nextLine();
                        employee.setFirstName(firstName);
                        employee.setLastName(lastName);
                    }
                    case 2 -> {
                        String birthDate = null;
                        while (!Validator.checkBirthDate(birthDate)) {
                            System.out.println("Please enter your birth date: ");
                            birthDate = scanner.nextLine();
                            if (Validator.checkBirthDate(birthDate)) employee.setBirthDate(birthDate);
                            else System.out.println("Invalid birth date");
                        }
                    }
                    case 3 -> {
                        System.out.println("Please enter your address: ");
                        String address = scanner.nextLine();
                        employee.setAddress(address);
                    }

                    case 4 -> {
                        String phone = null;
                        while (true) {
                            System.out.println("Please enter your phone number: ");
                            phone = scanner.nextLine();
                            try {
                                if (Validator.checkPhone(phone)) {
                                    employee.setPhone(phone);
                                    break;
                                }
                            } catch (PhoneException ex) {
                                System.err.println(ex);
                            }
                        }
                    }
                    case 5 -> {
                        String email = null;
                        while (!Validator.checkEmail(email)) {
                            System.out.println("Please enter your email: ");
                            email = scanner.nextLine();
                            if (Validator.checkEmail(email)) employee.setEmail(email);
                            else System.out.println("Invalid Email");
                        }
                    }
                }
                if (employee instanceof Experience) {
                    int yearExp;
                    do {
                        System.out.println("Please enter year of experience (0-100): ");
                        yearExp = Integer.parseInt(scanner.nextLine());
                    } while (yearExp < 0 || yearExp > 100);

                    System.out.println("Please enter your professional skill: ");
                    String proSkill = scanner.nextLine();
                    ((Experience) employee).setExpYear(yearExp);
                    ((Experience) employee).setProSkill(proSkill);
                } else if (employee instanceof Fresher) {
                    System.out.println("Please enter your graduation date (year): ");
                    String gradDate = scanner.nextLine();
                    System.out.println("Please enter your university: ");
                    String university = scanner.nextLine();
                    String rankGrad = null;
                    do {
                        System.out.println("Please enter your rank of graduation: ");
                        System.out.printf(format, "", "1. Excellence");
                        System.out.printf(format, "", "2. Good");
                        System.out.printf(format, "", "3. Fair");
                        System.out.printf(format, "", "4. Poor");
                        int rank = scanner.nextInt();
                        switch (rank) {
                            case 1 -> rankGrad = "Excellence";
                            case 2 -> rankGrad = "Good";
                            case 3 -> rankGrad = "Fair";
                            case 4 -> rankGrad = "Poor";
                            default -> System.out.println("Invalid rank!");
                        }
                    } while (!Validator.checkRank(rankGrad));
                    ((Fresher) employee).setGradDate(gradDate);
                    ((Fresher) employee).setGradRank(rankGrad);
                } else {
                    System.out.println("Please enter your major: ");
                    String major = scanner.nextLine();
                    System.out.println("Please enter your semester: ");
                    String semester = scanner.nextLine();
                    System.out.println("Please enter your University: ");
                    String university = scanner.nextLine();
                    ((Internship) employee).setMajor(major);
                    ((Internship) employee).setSemester(semester);
                    ((Internship) employee).setUniversity(university);

                }
            }
        });
    }

    private static int printUpdateMenu() {
        System.out.println("Please choose what you would like to update: ");
        System.out.printf(format, "", "1. Name");
        System.out.printf(format, "", "2. Birth Year");
        System.out.printf(format, "", "3. Address");
        System.out.printf(format, "", "4. Phone");
        System.out.printf(format, "", "5. Email");
        System.out.printf(format, "", "6. Certificate");
        return scanner.nextInt();
    }
}

