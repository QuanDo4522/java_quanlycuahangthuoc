/*
Đây là code của Quân Đỗ
*/
package btljava;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class HoaDon implements  Serializable{
    private String mahd, ngaylap ,makh  , manv , mat ;
    private int somh,sl;
    private int a[];
    DSKhachHang danhsachKH = new DSKhachHang();
    DSNhanVien danhsachNV = new DSNhanVien();
    DSThuoc danhsachSP = new DSThuoc();
    ArrayList<Thuoc> dst;

    public HoaDon() {
    }

    public HoaDon(String mahd, String ngaylap, String makh, String manv, String mat, int somh, int sl, int[] a) {
        this.mahd = mahd;
        this.ngaylap = ngaylap;
        this.makh = makh;
        this.manv = manv;
        this.mat = mat;
        this.somh = somh;
        this.sl = sl;
        this.a = a;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public int getSomh() {
        return somh;
    }

    public void setSomh(int somh) {
        this.somh = somh;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public void nhaphd() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã hóa đơn: "); mahd=sc.nextLine();
        System.out.print("Ngày lập: "); ngaylap=sc.nextLine();
        System.out.print("Mã khách hàng : ");
        while(true)
        {
            makh=sc.nextLine();
            if(danhsachKH.timKHTheoMa(makh))
            {
                break;
            }
            else
                System.out.print("Mã khách hàng không tồn tại.Nhập lại: ");
        }
        System.out.print("Mã nhân viên : ");
        while(true)
        {
            manv=sc.nextLine();
            if(danhsachNV.timNVTheoMa(manv))
            {
                break;
            }
            else
                System.out.print("Mã nhân viên không tồn tại.Nhập lại: ");
        }
        System.out.print("\nSố Thuốc: ");
        somh=sc.nextInt();
        sc.nextLine();
        dst=new ArrayList<>(somh);
        a=new int[somh];
        for(int i=0;i<somh;i++) {
            System.out.print("\nNhập thuốc thứ "+(i+1) + " có mã là : ");
            while(true)
            {
                mat=sc.nextLine();
                if(danhsachSP.timSPTheoMa(mat)!= null)
                {
                    System.out.print("Nhập số lượng thuốc là :"); a[i]=sc.nextInt();
                    sc.nextLine();
                    dst.add(danhsachSP.timSPTheoMa(mat));
                    break;
                }else
                    System.out.print("Mã thuốc không tồn tại.Nhập lại :");
            }
        }
    }

    public void hienhd() {
        System.out.println("\nMã hóa đơn: "+mahd);
        System.out.println("Ngày lập: "+ngaylap);
        System.out.println("Mã khách hàng: "+makh);
        System.out.println("Mã nhân viên: "+manv);
        System.out.println("Số mặt hàng: "+somh);
        System.out.println("Danh sách mặt hàng: ");
        for(int i=0;i<dst.size();++i) {
            dst.get(i).hienT();
            System.out.println("Số lượng :" +a[i]);
        }
        System.out.println("Tổng giá trị hóa đơn là : "+ tinhtong() +" đ");
        System.out.println("\n_______________");
    }

    public int tinhtong() {
        int tong=0;
        for(int i=0;i<dst.size();++i) {
            tong+=(dst.get(i).getGiaban()*a[i]);
        }
        return tong;
    }
   }
