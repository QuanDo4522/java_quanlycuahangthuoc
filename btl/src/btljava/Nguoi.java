/*
Đây là code của Quân Đỗ
*/
package btljava;
import java.io.Serializable;
import java.util.Scanner;

public class Nguoi implements Serializable{
   private String MaNguoi;
   private String TenNguoi;
   private String NgaySinh;
   private String GioiTinh;
   private String DiaChi;

    public Nguoi() {

    }

    public Nguoi(String maNguoi, String tenNguoi, String ngaySinh, String gioiTinh, String diaChi) {
        MaNguoi = maNguoi;
        TenNguoi = tenNguoi;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        DiaChi = diaChi;
    }

    public String getMaNguoi() {
        return MaNguoi;
    }

    public void setMaNguoi(String maNguoi) {
        MaNguoi = maNguoi;
    }

    public String getTenNguoi() {
        return TenNguoi;
    }

    public void setTenNguoi(String tenNguoi) {
        TenNguoi = tenNguoi;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public void nhapNg(){
        Scanner sc=new Scanner(System.in);
        System.out.print("  Nhập mã người: ");
        MaNguoi = sc.nextLine();
        System.out.print("  Nhập tên người: ");
        TenNguoi = sc.nextLine();
        System.out.print("  Nhập ngày sinh: ");
        NgaySinh = sc.nextLine();
        System.out.print(" Nhập giới tính: ");
        GioiTinh = sc.nextLine();
        System.out.print(" Nhập địa chỉ: ");
        DiaChi = sc.nextLine();
    }

    @Override
    public String toString() {
        return
                " MaNguoi ='" + MaNguoi + '\'' +
                ", TenNguoi ='" + TenNguoi + '\'' +
                ", NgaySinh ='" + NgaySinh + '\'' +
                ", GioiTinh ='" + GioiTinh + '\'' +
                ", DiaChi ='" + DiaChi + '\'';
    }
}
