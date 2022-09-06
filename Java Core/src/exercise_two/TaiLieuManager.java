package exercise_two;

import exercise_one.CanBo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public final class TaiLieuManager {

    public static List<TaiLieu> taiLieuList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String format = "%8s%-25s%n";

    /**
     * Prints the management board with options
     *
     * @return option chosen by user
     */
    public static int printMenu() {
        System.out.println("Xin hãy chọn chức năng quản lý bên dưới: ");
        System.out.printf(format, "", "1. Thêm mới tài liệu");
        System.out.printf(format, "", "2. Xóa tài liệu");
        System.out.printf(format, "", "3. Hiện thị thông tin tài liệu");
        System.out.printf(format, "", "4. Tìm kiếm theo loại");
        System.out.printf(format, "", "5. Thoát chương trình");
        return scanner.nextInt();
    }

    public static int printType(){
        System.out.println("Xin hãy chọn loại tài liệu: ");
        System.out.printf(format, "", "1. Sách");
        System.out.printf(format, "", "2. Tạp chí");
        System.out.printf(format, "", "3. Báo");
        return scanner.nextInt();
    }

    public static void addNew(){
        scanner.nextLine();
        TaiLieu t = null;
        System.out.println("Xin hãy nhập mã tài liệu: ");
        String maTaiLieu = scanner.nextLine();
        System.out.println("Xin hãy nhập nhà xuất bản: ");
        String nhaXuatBan = scanner.nextLine();
        System.out.println("Xin hãy nhập số bản phát hành: ");
        int soBanPhatHanh = Integer.parseInt(scanner.nextLine());
        int option = printType();
        scanner.nextLine();
        switch (option){
            case 1 -> {
                System.out.println("Xin hãy điền tên tác giả: ");
                String tenTacGia = scanner.nextLine();
                System.out.println("Xin hãy điền số trang: ");
                int soTrang = Integer.parseInt(scanner.nextLine());
                t = new Sach(maTaiLieu, nhaXuatBan, soBanPhatHanh, tenTacGia, soTrang);
            }
            case 2 -> {
                System.out.println("Xin hãy điền số phát hành: ");
                int soPhatHanh = Integer.parseInt(scanner.nextLine());
                System.out.println("Xin hãy điền số tháng phát hành: ");
                int thangPhatHanh = Integer.parseInt(scanner.nextLine());
                t = new TapChi(maTaiLieu, nhaXuatBan, soBanPhatHanh, soPhatHanh, thangPhatHanh);
            }
            case 3 -> {
                System.out.println("Xin hãy điền ngày phát hành: ");
                String ngayPhatHanh = scanner.nextLine();
                t = new Bao(maTaiLieu, nhaXuatBan, soBanPhatHanh, ngayPhatHanh);
            }
        }
        if (t != null) taiLieuList.add(t);
    }

    public static void remove(){
        scanner.nextLine();
        System.out.println("Xin hãy nhập mã tài liệu cần xóa: ");
        String maTaiLieu = scanner.nextLine();
        Iterator<TaiLieu> iterator = taiLieuList.iterator();
        while(iterator.hasNext()){
            if (iterator.next().getMaTaiLieu().equals(maTaiLieu)) iterator.remove();
        }
    }

    public static void reportList(){
        scanner.nextLine();
        if (taiLieuList.size() != 0) {
            taiLieuList.forEach(taiLieu -> {
                System.out.print(taiLieu.getMaTaiLieu() + "|"
                        + taiLieu.getNhaXuatBan() + "|" + taiLieu.getSoBanPhatHanh() + "|");
                if (taiLieu instanceof Sach) System.out.println("Sach");
                else if (taiLieu instanceof TapChi) System.out.println("Tap Chi");
                else System.out.println("Bao");
                System.out.println();
            });
        }else{
            System.out.println("Chưa có tài liệu nào!!!");
        }
    }

    public static void findByType(){
        int option = printType();
        scanner.nextLine();

        switch (option){
            case 1 -> taiLieuList.forEach(taiLieu -> {
                if (taiLieu instanceof Sach) System.out.println(taiLieu.getMaTaiLieu() + "|"
                        + taiLieu.getNhaXuatBan() + "|" + taiLieu.getSoBanPhatHanh() + "|Sach");
            });

            case 2 -> taiLieuList.forEach(taiLieu -> {
                if (taiLieu instanceof TapChi) System.out.println(taiLieu.getMaTaiLieu() + "|"
                        + taiLieu.getNhaXuatBan() + "|" + taiLieu.getSoBanPhatHanh() + "|Tap Chi");
            });

            case 3 -> taiLieuList.forEach(taiLieu -> {
                if (taiLieu instanceof Bao) System.out.println(taiLieu.getMaTaiLieu() + "|"
                        + taiLieu.getNhaXuatBan() + "|" + taiLieu.getSoBanPhatHanh() + "|Bao");
            });

            default -> System.out.println("Xin háy nhập từ 1 - 3");

        }
    }
}
