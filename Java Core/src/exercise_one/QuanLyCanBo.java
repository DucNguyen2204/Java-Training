package exercise_one;

public class QuanLyCanBo {
    public static void main(String[] args) {
        while (true) {
            int choice = CanBoManager.printMenu();
            if (choice == 4) {
                break;
            } else {
                switch (choice) {
                    case 1 -> CanBoManager.addNew();
                    case 2 -> CanBoManager.findByName();
                    case 3 -> CanBoManager.reportList();
                }
            }
        }
    }
}

