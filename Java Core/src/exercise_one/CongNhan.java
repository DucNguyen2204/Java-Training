package exercise_one;

public class CongNhan extends CanBo {
    int bac;

    public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        if (bac > 10 || bac < 0){
            throw new RuntimeException("Bậc của Công nhân chỉ chấp nhận từ 1 - 10");
        }
        this.bac = bac;
    }
}
