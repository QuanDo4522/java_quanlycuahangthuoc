/*
Đây là code của Quân Đỗ
*/
package btljava;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DSKhachHang implements Serializable {
    ArrayList<KhachHang> dskh= new ArrayList<>();
    public DSKhachHang(){
    }
    public void nhapDSKH(){
        int  n;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập số khách hàng:");
        n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            KhachHang x = new KhachHang();
            System.out.println("\nNhập khách hàng thứ "+(i+1));
            x.nhapKH();
            dskh.add(x);
        }
    }

    public void ghifile() throws FileNotFoundException, IOException{
        FileOutputStream out = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            out = new FileOutputStream("khachhang.dat");
            objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(dskh);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }
        System.err.println("ghi file thành công");
    }
    public void docfile() throws IOException {
        FileInputStream in = null;
        ObjectInputStream inputStream = null;
        try {
            in = new FileInputStream("khachhang.dat");
            inputStream = new ObjectInputStream(in);
            dskh = (ArrayList<KhachHang>) inputStream.readObject();
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
    public void hienDSKH()
    {
        System.out.println("___DANH SÁCH KHÁCH HÀNG___");
        for(KhachHang x : dskh)
        {
            x.hienKH();
        }
    }
    public void themkh() throws IOException {
        docfile();
        System.out.println("Nhập thông tin khách hàng cần thêm :");
        KhachHang kh=new KhachHang();
        kh.nhapKH();
        dskh.add(kh);
        System.out.println(" _____Đã thêm____");
    }

    public void timKHTheoTen() throws IOException {
        int k=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên khách hàng cần tìm: ");
        String Ten = sc.nextLine();
        docfile();
        System.out.println("Hiện Khách Hàng cần tìm :\n");
        for(KhachHang x: dskh)
        {
            if(x.getTenNguoi().equalsIgnoreCase(Ten))
            {
                x.hienKH();
                k=1;
                System.out.println();
            }
        }
        if(k==0) System.out.println("<Không có tên khách hàng cần tìm !>");
    }
    public boolean timKHTheoMa(String maKH) throws IOException {
        docfile();
        for (KhachHang x: dskh) {
            if(x.getMaNguoi().equals(maKH)) {
                return true;
            }
        }
        return false;
    }

}
