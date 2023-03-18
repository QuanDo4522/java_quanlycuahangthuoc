/*
Đây là code của Quân Đỗ
*/
package btljava;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DSNhanVien implements Serializable {
    ArrayList<NhanVien> dsnv= new ArrayList<>(); ;
    public DSNhanVien()
    {
    }
    public void nhapDSNV()
    {
        int  n;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập số nhân viên:");
        n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            NhanVien x = new NhanVien();
            System.out.println("\nNhập nhân viên thứ "+(i+1));
            x.nhapNV();
            dsnv.add(x);
        }
    }
    public void ghifile() throws FileNotFoundException, IOException{
        FileOutputStream out = null;
        ObjectOutputStream object = null;
        try {
            out = new FileOutputStream("nhanvien.dat");
            object = new ObjectOutputStream(out);
            object.writeObject(dsnv);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (object != null) {
                object.close();
            }
        }
        System.err.println("ghi file thành công");
    }
    public void docfile() throws IOException {

        FileInputStream in = null;
        ObjectInputStream inputStream = null;
        try {
            in = new FileInputStream("nhanvien.dat");
            inputStream = new ObjectInputStream(in);
            dsnv = (ArrayList<NhanVien>) inputStream.readObject();
        } catch (Exception e) {

        } finally {
            if (in != null) {
                in.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
    public void hienDSNV()
    {
        System.out.println("___DANH SÁCH NH N VIÊN___");
        for(NhanVien x : dsnv)
        {
            x.hienNV();
        }
    }
    public void themnv() throws IOException {
        docfile();
        System.out.println("Thông tin Nhân Viên cần thêm là :");
        NhanVien nv=new NhanVien();
        nv.nhapNV();
        dsnv.add(nv);
        System.out.println(" _____Đã thêm____");
    }

    public void TongLuong()
    {
        float sum = 0;
        for (NhanVien x : dsnv) {
            sum = sum + x.TinhLuong();
        }
        System.out.println("\n Tong tien cua cac nhan vien la:" +sum +" đ");
    }
    public void SapXepNVten(){
        System.out.println("\n Danh sach nhan vien sau khi sap xep theo ten la :");
        Collections.sort(dsnv,new Comparator<NhanVien>(){
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                return nv1.getTenNguoi().compareTo(nv2.getTenNguoi());
            }
        });
        hienDSNV();
    }

    public void timNVTheoTen() throws IOException {
        int k=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập nhân viên cần tìm : ");
        String Ten = sc.nextLine();
        docfile();
        System.out.println("Hiện Nhân Viên cần tìm :\n");
        for(NhanVien x: dsnv)
        {
            if(x.getTenNguoi().equalsIgnoreCase(Ten))
            {
                x.hienNV();
                k=1;
                System.out.println();
            }
        }
        if(k==0) System.out.println("<Không có nhân viên nào tên vậy !>");
    }

    public boolean timNVTheoMa(String manv) throws IOException {
        docfile();
        for(NhanVien x: dsnv)
        {
            if(x.getMaNguoi().equals(manv))
            {
                return true;
            }
        }
        return false;
    }
}

