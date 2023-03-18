/*
Đây là code của Quân Đỗ
*/
package btljava;

import java.io.Serializable;
import java.util.Scanner;

public class KhachHang extends Nguoi implements Serializable {
    String SDT;

    public KhachHang()
    {
        super();
    }

    public KhachHang(String maNguoi, String tenNguoi, String ngaySinh, String gioiTinh, String diaChi, String SDT) {
        super(maNguoi, tenNguoi, ngaySinh, gioiTinh, diaChi);
        this.SDT = SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getSDT() {
        return SDT;
    }

    public void nhapKH(){
        Scanner sc = new Scanner(System.in);
        super.nhapNg();
        System.out.print(" Nhap so dien thoai : ");
        SDT = sc.nextLine();
    }

    @Override
    public String toString() {
        return "KhachHang { "+super.toString() +
                ", SDT ='" + SDT + '\'' +
                '}';
    }
    public void hienKH(){
        System.out.println(toString());
    }
}

