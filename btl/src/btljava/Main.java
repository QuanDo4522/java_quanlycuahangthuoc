/*
Đây là code của Quân Đỗ
*/
package btljava;

import btljava.DSHoaDon;
import btljava.DSKhachHang;
import btljava.DSNhanVien;
import btljava.DSThuoc;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static DSNhanVien nv = new DSNhanVien();
    static DSKhachHang kh = new DSKhachHang();
    static DSHoaDon hd = new DSHoaDon();
    static DSThuoc t = new DSThuoc();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int chon=10;
        while(chon!=0) {
            menu();
            System.out.print("\nNHẬP LỰA CHỌN: "); chon = sc.nextInt();
            switch(chon) {
                case 1:
                    MenuNV();
                 break;
                case 2:
                    MenuKH();
                 break;
                case 3:
                    MenuSP();
                 break;
                case 4:
                    MenuHD();
                 break;
                case 0:
                    System.out.println("_____THANK YOU FOR CHOOSING____");
                 break;
                default: System.out.println("KHÔNG CÓ LỰA CHỌN VỪA NHẬP. MỜI NHẬP LẠI.");
            }
        }
    }
    public static void menu(){
        System.out.println( "\n_________ĐỐI TƯỢNG CẦN XỬ LÍ_________"
                + "\n            1. NH N VIÊN"
                + "\n            2. KHÁCH HÀNG"
                + "\n            3. THUỐC"
                + "\n            4. HÓA ĐƠN"
                + "\n      0. Kết thúc chương trình!"
                +"");
    }
    public static void MenuNV() throws IOException {
        Scanner sc = new Scanner(System.in);
        int choose;
        do{
        System.out.println( "\n_______NH N VIÊN_______"
                + "\n1. Nhập danh sách nhân viên"
                + "\n2. Hiện danh sách nhân viên"
                + "\n3. Ghi ds Nhân Viên vào file"
                + "\n4. Đọc ds Nhân Viên từ file hiện ra màn hình"
                + "\n5. Thêm nhân viên"
                + "\n6. Tổng lương của các nhân viên"
                + "\n7. Sắp xếp nhân viên theo tên "
                + "\n8. Tìm nhân viên theo tên"
                + "\n0. Quay lại menu đối tượng!"
                +"");
            System.out.println("NHẬP LỰA CHỌN: ");  choose = sc.nextInt();
            switch(choose) {
                case 1:
                    nv.nhapDSNV();
                break;
                case 2:
                    nv.hienDSNV();
                break;
                case 3:
                    nv.ghifile();
                break;
                case 4:
                    nv.docfile();
                    nv.hienDSNV();
                break;
                case 5:
                    nv.themnv();
                    break;
                case 6:
                    nv.TongLuong();
                break;
                case 7:
                    nv.SapXepNVten();
                break;
                case 8:
                    nv.timNVTheoTen();
                break;
                case 0:
                    System.out.println("        ______________________________");
                break;
                default:
                    System.out.println("KHÔNG CÓ LỰA CHỌN VỪA NHẬP. MỜI NHẬP LẠI.");
            }
        }while (choose!=0);
    }
    public static void MenuKH() throws IOException {
        Scanner sc = new Scanner(System.in);
        int choose;
        do{
        System.out.println( "\n_______KHÁCH HÀNG_______"
                + "\n1. Nhập danh sách khách hàng"
                + "\n2. Hiện danh sách khách hàng"
                + "\n3. Ghi ds Khách Hàng vào file"
                + "\n4. Đọc ds Khách Hàng từ file hiện ra màn hình"
                + "\n5. Thêm khách hàng"
                + "\n6. Tìm khách hàng theo tên"
                + "\n0. Quay lại mennu đối tượng!"
                +"");
            System.out.print("NHẬP LỰA CHỌN: "); choose = sc.nextInt();
            switch(choose) {
                case 1:
                    kh.nhapDSKH();
                 break;
                case 2:
                    kh.hienDSKH();
                 break;
                case 3:
                    kh.ghifile();
                 break;
                case 4:
                    kh.docfile();
                    kh.hienDSKH();
                  break;
                case 5:
                    kh.themkh();
                    break;
                case 6:
                    kh.timKHTheoTen();
                 break;
                case 0:
                    System.out.println("        ____________________________");
                 break;
                default: System.out.println("KHÔNG CÓ LỰA CHỌN VỪA NHẬP. MỜI NHẬP LẠI.");
            }
        }while (choose!=0);
    }
    public static void MenuSP() throws IOException {
        Scanner sc = new Scanner(System.in);
        int choose;
        do{
        System.out.println( "\n_______THUỐC_______"
                + "\n1. Nhập danh sách thuốc"
                + "\n2. Hiện danh sách thuốc"
                + "\n3. Ghi ds thuốc vào file"
                + "\n4. Đọc ds thuốc từ file ra màn hình"
                + "\n5. Thêm thuốc"
                + "\n6. Tìm thuốc theo mã"
                + "\n0. Quay lại menu đối tượng!"
                +"");
            System.out.print("NHẬP LỰA CHỌN: "); choose = sc.nextInt();
            switch(choose) {
                case 1:
                    t.nhapDST();
                 break;
                case 2:
                    t.hienDST();
                 break;
                case 3:
                    t.ghifile();
                 break;
                case 4:
                    t.docfile();
                    t.hienDST();
                 break;
                case 5:
                    t.themt();
                    break;
                case 6:
                    t.timThuoctheoMa();
                 break;
                case 0:
                    System.out.println("        _________________________________");
                 break;
                default: System.out.println("KHÔNG CÓ LỰA CHỌN VỪA NHẬP. MỜI NHẬP LẠI.");
            }
        }while (choose!=0);
    }
    public static void MenuHD() throws Exception {
        Scanner sc = new Scanner(System.in);
        int choose;
        do{
        System.out.println( "\n_______HÓA ĐƠN_______"
                + "\n1. Nhập danh sách hóa đơn"
                + "\n2. Hiện danh sách hóa đơn"
                + "\n3. Ghi ds Hóa Đơn vào file"
                + "\n4. Đọc ds Hóa Đơn từ file hiện ra màn hình"
                + "\n5. Tìm kiếm hóa đơn theo mã"
                + "\n6. Tổng tiền các hóa đơn"
                + "\n7. Sắp xếp tổng tiền hóa đơn tăng dần"
                + "\n8. Xoá hóa đơn theo mã"
                + "\n9. Thêm hóa đơn"
                + "\n10. Danh sách hóa đơn có giá trị trên 100000đ"
                + "\n0. Quay lại menu đối tượng!"
                + "");
            System.out.print("NHẬP LỰA CHỌN: "); choose = sc.nextInt();
            switch(choose) {
                case 1:
                    hd.nhapDSHD();
                 break;
                case 2:
                    hd.hienDSHD();
                 break;
                case 3:
                    hd.ghifile();
                 break;
                case 4:
                   hd.docfile();
                   hd.hienDSHD();
                 break;
                case 5:
                    hd.timkiem();
                    break;
                case 6:
                    hd.tinhtong();
                 break;
                case 7:
                    hd.sapxep();
                 break;
                case 8:
                    hd.xoa();
                 break;
                case 9:
                    hd.them();
                 break;
                case 10:
                    hd.loctren100k();
                 break;
                case 0:
                    System.out.println("        ______________________________");
                 break;
                default: System.out.println("KHÔNG CÓ LỰA CHỌN VỪA NHẬP. MỜI NHẬP LẠI.");
            }
        }while (choose!=0);
    }
}

