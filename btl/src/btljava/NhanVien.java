/*
Đây là code của Quân Đỗ
*/
package btljava;
import btljava.Nguoi;

import java.io.Serializable;
import java.util.Scanner;

public class NhanVien extends Nguoi implements Serializable{
   private float Lcb;
   private float Hsl;

    public NhanVien(){
        super();
    }

    public NhanVien(String maNguoi, String tenNguoi, String ngaySinh, String gioiTinh, String diaChi, float lcb, float hsl) {
        super(maNguoi, tenNguoi, ngaySinh, gioiTinh, diaChi);
        Lcb = lcb;
        Hsl = hsl;
    }

    public void setLcb(float Lcb) {
        this.Lcb = Lcb;
    }

    public void setHsl(float Hsl) {
        this.Hsl = Hsl;
    }

    public float getLcb() {
        return Lcb;
    }

    public float getHsl() {
        return Hsl;
    }

    public void nhapNV(){
        Scanner sc=new Scanner(System.in);
        super.nhapNg();
        System.out.print("  Nhap luong co ban : ");
        Lcb = sc.nextFloat();
        System.out.print("  Nhap he so luong : ");
        Hsl = sc.nextFloat();
    }

    @Override
    public String toString() {
        return "NhanVien { " + super.toString()+
                ", Lcb =" + Lcb +
                ", Hsl =" + Hsl +
                ", Luong =" + TinhLuong() +
                '}';
    }

    public void hienNV(){
        System.out.println(toString());
    }

    public float TinhLuong()
    {
        return Hsl*Lcb;
    }
}
