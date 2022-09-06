package exercise_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class CanBoManager {
    private CanBoManager() {
        throw new UnsupportedOperationException("Utility Class cannot be instantiated");
    }

    public static List<CanBo> canBoList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String format = "%8s%-25s%n";

    /**
     * Prints the management board with options
     *
     * @return option chosen by user
     */
    public static int printMenu() {
        System.out.println("Xin hãy chọn chức năng quản lý bên dưới: ");
        System.out.printf(format, "", "1. Tạo mới cán bộ");
        System.out.printf(format, "", "2. Tìm kiếm theo tên");
        System.out.printf(format, "", "3. Hiện thị thông tin cán bộ");
        System.out.printf(format, "", "4. Thoát chương trình");
        return scanner.nextInt();
    }

    public static int printType(){
        System.out.println("Xin hãy chọn loại cán bộ: ");
        System.out.printf(format, "", "1. Công nhân");
        System.out.printf(format, "", "2. Kỹ sư");
        System.out.printf(format, "", "3. Nhân viên");
        return scanner.nextInt();
    }
    public static void addNew(){
        CanBo c = null;
        scanner.nextLine();
        System.out.println("Xin hãy điền tên cán bộ: ");
        String hoTen = scanner.nextLine();
        System.out.println("Xin hãy điền tuổi cán bộ: ");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Xin hãy điền giới tính cán bộ: ");
        String gioiTinh = scanner.nextLine();
        System.out.println("Xin hãy điền địa chỉ cán bộ: ");
        String diaChi = scanner.nextLine();

        int option = printType();
        scanner.nextLine();
        switch (option){
            case 1 -> {
                System.out.println("Xin hãy điền cấp bậc của công nhân: ");
                int bac = Integer.parseInt(scanner.nextLine());
                c = new CongNhan(hoTen,tuoi,gioiTinh,diaChi,bac);
            }
            case 2 -> {
                System.out.println("Xin hãy điền ngành đào tạo của kỹ sư: ");
                String nganhDaoTao = scanner.nextLine();
                c = new KySu(hoTen,tuoi,gioiTinh,diaChi,nganhDaoTao);
            }
            case 3 -> {
                System.out.println("Xin hãy điền công việc của nhân viên: ");
                String congViec = scanner.nextLine();
                c = new NhanVien(hoTen,tuoi,gioiTinh,diaChi,congViec);
            }
            default -> {
                System.out.println("Xin háy nhập từ 1 - 3");
            }
        }
        if ( c!= null ) canBoList.add(c);
    }

    public static void findByName(){
        if (canBoList.size() != 0) {
            scanner.nextLine();
            System.out.println("Xin hãy nhập tên cán bộ bạn muốn tìm: ");
            String searchKeyword = scanner.nextLine().toLowerCase();
            List<CanBo> searchResult = canBoList.stream().filter(canBo -> canBo.getHoTen().toLowerCase().contains(searchKeyword)).toList();
            searchResult.forEach(canBo -> System.out.println(canBo.getHoTen() + "|" + canBo.getTuoi() + "|" + canBo.getGioiTinh()));
            System.out.println();
        } else {
            System.out.println("Chưa có cán bộ nào!!!");
        }
    }

    public static void reportList(){
        if (canBoList.size() != 0) {
            canBoList.forEach(canBo -> System.out.println(canBo.getHoTen() + "|" + canBo.getTuoi()
                    + "|" + canBo.getGioiTinh() + "|" + canBo.getDiaChi()));
            System.out.println();
        }else {
            System.out.println("Chưa có cán bộ nào!!!");
        }
    }
}
