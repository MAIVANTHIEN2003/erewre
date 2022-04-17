package Session11.Asissgnment1;

import java.sql.*;

public class QuanLy {
    public final static String connectionString = "jdbc:mysql://localhost:3306/quanlythuvien";
    public final static String user = "root";
    public final static String password = "";
    public static void main(String[]agrs){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString, user, password);
//            Quanlysach
            Statement stt = conn.createStatement();
            String txt_sql = "select * from quanlysach";
            ResultSet rs = stt.executeQuery(txt_sql);
            while (rs.next()){
                System.out.println(rs.getString("TenSach"));
                System.out.println(rs.getString("ViTri"));
            }
            String insert_sql = "insert into quanlysach (TenSach, ViTri) values('Java', 'Hang2')";
            stt.execute(insert_sql);
            String insert_sql1 = "insert into quanlysach (TenSach, ViTri) values('Sql', 'Cot4')";
            stt.execute(insert_sql1);

            //Quanlysinhvien
            Statement stt1 = conn.createStatement();
            String txt_sql1 = "select * from quanlysinhvien";
            ResultSet rs1 = stt1.executeQuery(txt_sql1);
            while (rs1.next()){
                System.out.println(rs1.getString("Ten"));
                System.out.println(rs1.getInt("MaSV"));
                System.out.println(rs1.getDate("Ngaysinh"));
                System.out.println(rs1.getInt("TenLop"));
            }
            String insert_sql2 = "insert into quanlysinhvien(Ten, MaSV,Ngaysinh, TenLop ) values ('Mai Van Thien',' 2108006', '2003/02/19', '2108')";
             stt1.execute(insert_sql2);

            //Quanlymuonsach

            Statement stt2 = conn.createStatement();
            String txt_sql2 = "select * from quanlymuonsach";
            ResultSet rs2 = stt2.executeQuery(txt_sql2);

            while (rs2.next()){
                System.out.println(rs2.getInt("NgayMuonSach"));
                System.out.println(rs2.getString("SoLuong"));
                System.out.println(rs2.getString("NgayTra"));
                System.out.println(rs2.getInt("MaSach"));
                System.out.println(rs2.getInt("LoaiSach"));
            }

            String insert_sql3 = "insert into quanlymuonsach(NgayMuonSach, SoLuong, NgayTra, MaSach, LoaiSach) values('2022/04/15', '5','2022/04/22', 'A20', 'Makesting')";
            stt2.execute(insert_sql3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
