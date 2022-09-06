package exercise_two;


import java.util.Optional;

public class QuanLyTaiLieu {
    public static void main(String[] args) {
        while (true) {
            int choice = TaiLieuManager.printMenu();
            if (choice == 5) {
                break;
            } else {
                switch (choice) {
                    case 1 -> TaiLieuManager.addNew();
                    case 2 -> TaiLieuManager.remove();
                    case 3 -> TaiLieuManager.reportList();
                    case 4 -> TaiLieuManager.findByType();
                }
            }
        }
//        String str = null;
//        String name = Optional.ofNullable(str).orElseThrow(() -> new RuntimeException());
    }
}
