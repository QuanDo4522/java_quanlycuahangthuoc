/*
Đây là code của Quân Đỗ
*/
package btljava;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DSHoaDon implements Serializable
{
    ArrayList<HoaDon> dshd=new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public DSHoaDon() {
    }
    public void nhapDSHD() throws IOException, ClassNotFoundException
    {
        int  n;
        System.out.print("\nNhập số hóa đơn:");
        n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            HoaDon hd = new HoaDon();
            System.out.println("\nNhập hóa đơn thứ "+(i+1));
            hd.nhaphd();
            dshd.add(hd);
        }
    }
    public void ghifile() throws IOException {
        FileOutputStream out = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            out = new FileOutputStream("hoadon.dat");
            objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(dshd);
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
            in = new FileInputStream("hoadon.dat");
            inputStream = new ObjectInputStream(in);
            dshd = (ArrayList<HoaDon>) inputStream.readObject();
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
    public void hienDSHD()
    {
        System.out.println("___DANH SÁCH HÓA ĐƠN___");
        for(HoaDon hd : dshd)
        {
            hd.hienhd();
        }
    }
    public void timkiem() throws IOException {
        String mhd;
        int k=0;
        System.out.print("Nhập mã hóa đơn muốn tìm: ");
        mhd=sc.nextLine();
        docfile();
        for(HoaDon hd:dshd) {
            if(hd.getMahd().equals(mhd)) {
                System.out.println("\nThông tin hóa đơn cần tìm:");
                System.out.print("_______________");
                k=1;
                hd.hienhd();
                break;
            }
        }
        if(k==0) System.out.println("\n<Không có hóa đơn cần tìm kiếm !>");
    }
    public void tinhtong() {
        int tong=0;
        for(HoaDon hd:dshd) {
            tong+=hd.tinhtong();
        }
        System.out.println("Tổng tiền các hóa đơn: "+tong+ " đ");
    }

    public void sapxep() {
        System.out.println("\nSắp xếp theo tổng tiền tăng dần: ");
        Collections.sort(dshd, new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon t0, HoaDon t1) {
                if(t0.tinhtong()==t1.tinhtong()) return 0;
                else if(t0.tinhtong()>t1.tinhtong()) return 1;
                return -1;
            }
        });
             hienDSHD();
    }

    public void xoa() {
        String x;
        int i,k=0;
        System.out.println("Nhập mã hóa đơn muốn xóa: ");
        x=sc.nextLine();
        for(i=0;i<dshd.size();i++) {
            if(dshd.get(i).getMahd().equals(x)) {
                dshd.remove(i);
                k=1;
                break;
            }
        }
        if(k==0) System.out.println("<Không có mã hóa đơn cần tìm !>");
        else {
            System.out.println("___Danh sách sau khi xóa___");
            hienDSHD();
        }
    }
    public void them() throws IOException, ClassNotFoundException {
        docfile();
        System.out.println("Nhập thông tin hóa đơn cần thêm");
        HoaDon hd = new HoaDon();
        hd.nhaphd();
        dshd.add(hd);
        System.out.println("_____Đã thêm____");
    }

    public void loctren100k() {
        int k=0;
        System.out.println("Danh sách hóa đơn có tổng giá trị trên 100000đ:\n");
        for(HoaDon hd:dshd)
            if(hd.tinhtong()>100000) {
                System.out.println("\n----------------------------");
                k=1;
                hd.hienhd();
            }
        if (k==0) System.out.println("<Không có hóa đơn trên 100000đ>");
    }
    public boolean timHDTheoMa(String maHD) throws IOException
    {
        docfile();
        for (HoaDon x: dshd) {
            if(x.getMahd().equals(maHD)) {
                return true;
            }
        }
        return false;
    }
}
