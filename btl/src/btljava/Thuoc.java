/*
Đây là code của Quân Đỗ
*/
package btljava;

import java.io.Serializable;
import java.util.Scanner;

public class Thuoc implements Serializable {
    private String mat;
    private String mancc;
    private String tent;
     float giaban;

    public Thuoc() {
    }

    public Thuoc(String mat, String mancc, String tent, float giaban) {
        this.mat = mat;
        this.mancc = mancc;
        this.tent = tent;
        this.giaban = giaban;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getTent() {
        return tent;
    }

    public void setTent(String tent) {
        this.tent = tent;
    }

    public float getGiaban() {
        return giaban;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public void nhapT() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mã Thuốc:");
        mat=sc.nextLine();
        System.out.print("Mã Nhà Cung Cấp:");
        mancc=sc.nextLine();
        System.out.print("Tên Thuốc:");
        tent=sc.nextLine();
        while(true) {
            try {
                System.out.print("Giá Bán :");
                giaban=sc.nextFloat();
                if( giaban<0 ) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.print("Nhập sai giá trị nhập lại :\n");
                sc.nextLine();
            }
        }
    }

    @Override
    public String toString() {
        return "Thuoc { " +
                "mat ='" + mat + '\'' +
                ", mancc ='" + mancc + '\'' +
                ", tent ='" + tent + '\'' +
                ", giaban =" + giaban +
                '}';
    }

    public void hienT() {
        System.out.println(toString());
    }

}

