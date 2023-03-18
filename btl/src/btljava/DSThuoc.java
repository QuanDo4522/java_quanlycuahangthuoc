/*
Đây là code của Quân Đỗ
*/
package btljava;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DSThuoc implements Serializable{
    ArrayList<Thuoc> dst= new ArrayList<>();
    public DSThuoc() {
    }
    public void nhapDST()
    {
        int  n;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhập số thuốc: ");
        n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            Thuoc x = new Thuoc();
            System.out.println("\nNhập thuốc thứ "+(i+1));
            x.nhapT();
            dst.add(x);
        }
    }

    public void ghifile() throws IOException{
        FileOutputStream out = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            out = new FileOutputStream("thuoc.dat");
            objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(dst);
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
            in = new FileInputStream("thuoc.dat");
            inputStream = new ObjectInputStream(in);
            dst = (ArrayList<Thuoc>) inputStream.readObject();
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
    public void hienDST() {
        System.out.println("___DANH SÁCH THUỐC___");
        for(Thuoc x : dst)
        {
            x.hienT();
        }
    }
    public void themt() throws IOException {
        docfile();
        System.out.println("Thông tin Thuốc cần thêm là :");
        Thuoc t=new Thuoc();
        t.nhapT();
        dst.add(t);
        System.out.println(" _____Đã thêm____");
    }

    public void timThuoctheoMa() throws IOException {
        int k=0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập mã thuốc cần tìm:");
        String mat=sc.nextLine();
        docfile();
        System.out.println("Hiện mã Thuốc cần tìm\n");
        for (Thuoc x: dst) {
            if(x.getMat().equalsIgnoreCase(mat)) {
                x.hienT();
                k=1;
                System.out.println();
            }
        }
        if(k==0) System.out.println("<Không có mã Thuốc cần tìm !>");
    }
    public Thuoc timSPTheoMa(String mat) throws IOException
    {
        docfile();
        for(Thuoc x: dst)
        {
            if(x.getMat().equals(mat))
            {
                return x;
            }
        }
        return null;
    }
}
