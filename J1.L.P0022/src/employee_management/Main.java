package employee_management;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int choice = UtilityClass.printMenu();
            if (choice == 8) {
                break;
            } else {
                switch (choice) {
                    case 1 -> UtilityClass.createExp();
                    case 2 -> UtilityClass.createFresher();
                    case 3 -> UtilityClass.createIntern();
                    case 4 -> UtilityClass.search();
                    case 5 -> UtilityClass.updateEmployee();
                    case 6 -> UtilityClass.printListCandidate();
                    case 7 -> {
                        try {
                            UtilityClass.outPutEmployeesToFile();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    default -> System.out.println("Please choose from 1 to 8!\n");
                }
            }
        }
    }
}

