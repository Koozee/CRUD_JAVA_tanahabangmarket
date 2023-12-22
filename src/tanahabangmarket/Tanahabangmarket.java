package tanahabangmarket;

import java.sql.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tanahabangmarket {

    static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/tanahabangmarket";
    static final String username = "root";
    static final String password = "";
    static Connection Conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            Class.forName(JDBC_Driver);
            Conn = DriverManager.getConnection(DB_URL, username, password);
            stmt = Conn.createStatement();
            String dbid;
            String dbname;
            String dbnohp;
            String dbemail;
            String dbpass;
            String loop = " ";
            String querry;
            do {
                System.out.println("Selamat Datang di Tanah Abang Market");
                System.out.println("------------------------------------");
                System.out.println("1. Buat Akun Baru \n2. Beli Barang");
                System.out.println("3. Pengaturan Akun \n4. Hapus Akun");
                System.out.println("5. Detail");
                System.out.print("Silahkan Pilih Menu Navigasi: ");
                int menu = input.nextInt();
                input.nextLine();
                switch (menu) {
                    case 1:
                        //insert data 
                        System.out.println("Daftar Akun Tanah Abang Market");
                        System.out.println("--------------------------------");
                        System.out.print("Masukkan ID: TA-");
                        String ID = "TA-" + input.nextLine().trim();
                        System.out.print("Masukkan Username: ");
                        String name = input.nextLine().trim();
                        System.out.print("Masukkan Nomor HP: ");
                        int nohp = input.nextInt();
                        input.nextLine();
                        System.out.print("Masukkan Email: ");
                        String email = input.nextLine().trim();
                        System.out.print("Masukkan Password: ");
                        String pass = input.nextLine().trim();
                        String sqli = "INSERT INTO `users`(`ID`, `name`, `no_hp`, `email`, `password`)" + "VALUES ('" + ID + "','" + name + "','" + nohp + "','" + email + "','" + pass + "')";
                        stmt.execute(sqli);
                        System.out.println("\nBerhasil menambah akun");
                        System.out.println("Detail Akun: ");
                        System.out.println("-------------------------------");
                        System.out.println("ID: " + ID);
                        System.out.println("Username: " + name);
                        System.out.println("No HP: " + nohp);
                        System.out.println("Email: " + email);
                        System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                        loop = input.nextLine();
                        //end insert data
                        break;

                    case 2:
                        //buy product
                        LocalDateTime localDateTime = LocalDateTime.now();
                        // Format tanggal dan waktu
                        DateTimeFormatter formattime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String formattedDateTime = localDateTime.format(formattime);
                        // Generate Random String
                        String generatedId = java.util.UUID.randomUUID().toString();
                        //buy product
                        System.out.print("Masukkan ID Akun Anda: TA-");
                        ID = "TA-" + input.nextLine().trim();
                        querry = "SELECT * FROM users WHERE ID=?";
                        String buyquerry = "INSERT INTO transanction(transanction_id, ID, product_id, create_date) VALUES (?, ?, ?, ?)";

                        try (PreparedStatement userpreparedStatement = Conn.prepareStatement(querry)) {
                            userpreparedStatement.setString(1, ID);
                            rs = userpreparedStatement.executeQuery();
                            if (rs.next()) { // Periksa apakah ada setidaknya satu baris dalam hasil set
                                System.out.println("1. Smart Mirror \n2. PDH HMPSTI JOSS");
                                System.out.println("3. Sepatu Mirror \n4. Kacamata XRay");
                                System.out.println("----------------------------------------");
                                System.out.print("Silahkan Pilih Barang Yang Mau Dibeli: ");
                                int buys = input.nextInt();
                                input.nextLine();
                                //product 1
                                if (buys == 1) {
                                    try (PreparedStatement preparedStatement1 = Conn.prepareStatement(buyquerry)) {

                                        String buy = Integer.toString(buys);
                                        preparedStatement1.setString(1, generatedId);
                                        preparedStatement1.setString(2, ID);
                                        preparedStatement1.setString(3, buy);
                                        preparedStatement1.setString(4, formattedDateTime);
                                        System.out.print("Konfirmasi Peembelian Barang Smart Mirror? (Y/N)");
                                        String confirmbuy = input.nextLine();
                                        if (confirmbuy.equalsIgnoreCase("Y")) {
                                            preparedStatement1.executeUpdate();
                                            System.out.println("Berhasil Membeli Smart Mirror");
                                            System.out.println("\nTransanction ID: " + generatedId);
                                            System.out.println("Silahkan Cek Ke Bagian Menu Detail Untuk Melihat Detail Transaksi Pembelian");
                                            System.out.println("------------------------------------");
                                        } else {
                                            System.out.println("Batal Membeli Barang");
                                        }
                                        System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                                        loop = input.nextLine();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                //product 2
                                if (buys == 2) {
                                    try (PreparedStatement preparedStatement2 = Conn.prepareStatement(buyquerry)) {

                                        String buy = Integer.toString(buys);
                                        preparedStatement2.setString(1, generatedId);
                                        preparedStatement2.setString(2, ID);
                                        preparedStatement2.setString(3, buy);
                                        preparedStatement2.setString(4, formattedDateTime);
                                        System.out.print("Konfirmasi Peembelian Barang PDH HMPSTI JOSS Rejeki? (Y/N)");
                                        String confirmbuy = input.nextLine();
                                        if (confirmbuy.equalsIgnoreCase("Y")) {
                                            preparedStatement2.executeUpdate();
                                            System.out.println("Berhasil Membeli PDH HMPSTI JOSS");
                                            System.out.println("\nTransanction ID: " + generatedId);
                                            System.out.println("Silahkan Cek Ke Bagian Menu Detail Untuk Melihat Detail Transaksi Pembelian");
                                            System.out.println("------------------------------------");
                                        } else {
                                            System.out.println("Batal Membeli Barang");
                                        }
                                        System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                                        loop = input.nextLine();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                //product 3
                                if (buys == 3) {
                                    try (PreparedStatement preparedStatement3 = Conn.prepareStatement(buyquerry)) {

                                        String buy = Integer.toString(buys);
                                        preparedStatement3.setString(1, generatedId);
                                        preparedStatement3.setString(2, ID);
                                        preparedStatement3.setString(3, buy);
                                        preparedStatement3.setString(4, formattedDateTime);
                                        System.out.print("Konfirmasi Peembelian Barang Sepatu Super? (Y/N)");
                                        String confirmbuy = input.nextLine();
                                        if (confirmbuy.equalsIgnoreCase("Y")) {
                                            preparedStatement3.executeUpdate();
                                            System.out.println("Berhasil Membeli Sepatu Super");
                                            System.out.println("\nTransanction ID: " + generatedId);
                                            System.out.println("Silahkan Cek Ke Bagian Menu Detail Untuk Melihat Detail Transaksi Pembelian");
                                            System.out.println("------------------------------------");
                                        } else {
                                            System.out.println("Batal Membeli Barang");
                                        }
                                        System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                                        loop = input.nextLine();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                //product4
                                if (buys == 4) {
                                    try (PreparedStatement preparedStatement4 = Conn.prepareStatement(buyquerry)) {

                                        String buy = Integer.toString(buys);
                                        preparedStatement4.setString(1, generatedId);
                                        preparedStatement4.setString(2, ID);
                                        preparedStatement4.setString(3, buy);
                                        preparedStatement4.setString(4, formattedDateTime);
                                        System.out.print("Konfirmasi Peembelian Barang Kacamata XRay? (Y/N)");
                                        String confirmbuy = input.nextLine();
                                        if (confirmbuy.equalsIgnoreCase("Y")) {
                                            preparedStatement4.executeUpdate();
                                            System.out.println("Berhasil Membeli Kacamata XRay");
                                            System.out.println("\nTransanction ID: " + generatedId);
                                            System.out.println("Silahkan Cek Ke Bagian Menu Detail Untuk Melihat Detail Transaksi Pembelian");
                                            System.out.println("------------------------------------");
                                        } else {
                                            System.out.println("Batal Membeli Barang");
                                        }
                                        System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                                        loop = input.nextLine();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                System.out.println("ID tidak ditemukan dalam database");
                                System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                                loop = input.nextLine();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;

                    //end buy product
                    case 3:
                        //update DB
                        System.out.println("Ubah Data Akun Tanah Abang Market");
                        System.out.print("Masukkan  ID Anda: TA-");
                        ID = "TA-" + input.nextLine().trim();
                        querry = "SELECT * FROM users WHERE ID=?";
                        String passcheck;

                        try (PreparedStatement preparedStatement = Conn.prepareStatement(querry)) {
                            preparedStatement.setString(1, ID);
                            rs = preparedStatement.executeQuery();

                            if (rs.next()) { // Periksa apakah ada setidaknya satu baris dalam hasil set
                                dbname = rs.getString("name");
                                dbnohp = rs.getString("no_hp");
                                dbemail = rs.getString("email");
                                dbpass = rs.getString("password");
                                System.out.println("Detail Akun Ditemukan: ");
                                System.out.println("-------------------------------");
                                System.out.println("ID: " + ID);
                                System.out.println("Username: " + dbname);
                                System.out.println("No HP: " + dbnohp);
                                System.out.println("Email: " + dbemail);
                                System.out.println("Masukkan Perubahan Data Akun: ");
                                System.out.print("Masukkan Username Baru: ");
                                String nameupdate = input.nextLine().trim();
                                System.out.print("Masukkan No Handphone Baru: ");
                                String nohpupdate = input.nextLine().trim();
                                System.out.print("Masukkan Email Baru: ");
                                String emailupdate = input.nextLine().trim();
                                System.out.print("Masukkan Password Untuk Konfirmasi Perubahan: ");
                                passcheck = input.nextLine().trim();

                                if (passcheck.equals(dbpass)) {
                                    String sqlu = "UPDATE users SET name = '" + nameupdate + "', no_hp = '" + nohpupdate + "', email = '" + emailupdate + "' WHERE ID = '" + ID + "'";
                                    stmt.execute(sqlu);
                                    System.out.println("Data Akun Berhasil Diubah!");
                                    System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                                    loop = input.nextLine();
                                } else {
                                    System.out.println("Password Salah Gagal Update Data!");
                                    System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                                    loop = input.nextLine();
                                }
                            } else {
                                System.out.println("ID tidak ditemukan dalam database");
                                System.out.println("Kembali Ke Navigasi Awal? (Y/N)");
                                loop = input.nextLine();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //end update data
                        break;
                    case 4:
                        //delete data
                        System.out.println("Hapus Akun Tanah Abang Market");
                        System.out.println("-----------------------------------");
                        System.out.print("Masukkan ID Akun Yang Akan Dihapus: ");
                        ID = input.nextLine().trim();
                        querry = "SELECT * FROM users WHERE ID=?";

                        try (PreparedStatement preparedStatement = Conn.prepareStatement(querry)) {
                            preparedStatement.setString(1, ID);
                            rs = preparedStatement.executeQuery();

                            if (rs.next()) { // Periksa apakah ada setidaknya satu baris dalam hasil set
                                dbname = rs.getString("name");
                                dbnohp = rs.getString("no_hp");
                                dbemail = rs.getString("email");
                                dbpass = rs.getString("password");
                                System.out.println("Detail Akun: ");
                                System.out.println("-------------------------------");
                                System.out.println("ID: " + ID);
                                System.out.println("Username: " + dbname);
                                System.out.println("No HP: " + dbnohp);
                                System.out.println("Email: " + dbemail);
                                System.out.print("Masukkan Password Untuk Konfirmasi Pengahapusan: ");
                                passcheck = input.nextLine().trim();
                                if (passcheck.equals(dbpass)) {
                                    String sqld = "DELETE FROM users WHERE ID = '" + ID + "'";
                                    System.out.println("Akun Username " + dbname + "('" + ID + "')" + "" + " Berhasil Dihapus!");
                                    stmt.execute(sqld);
                                    System.out.println("Kembali Ke Navigasi Awal? (Y/N)");
                                    loop = input.nextLine();
                                } else {
                                    System.out.println("Password Salah Gagal Hapus Akun!");
                                    System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                                    loop = input.nextLine();
                                }
                            } else {
                                System.out.println("ID tidak ditemukan dalam database");
                                System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                                loop = input.nextLine();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //end delete data
                        break;
                    case 5:
                        // read data
                        System.out.println("1. Data Akun Tanah Abang Market \n2. Data Transaksi");
                        System.out.print("Silahkan Pilih Data Yang Ingin Ditampilkan :");
                        int reads = input.nextInt();
                        input.nextLine();
                        //detail akun
                        if (reads == 1) {
                            System.out.println("Silahkan Masukkan ID/ Username yang akan ditampilkan: ");
                            System.out.print("ID: TA-");
                            String readbyid = "TA-" + input.nextLine().trim();
                            System.out.print("Username: ");
                            String readbyname = input.nextLine().trim();
                            String sqlr = "SELECT ID, name, no_hp, email FROM `users` WHERE ID='" + readbyid + "' OR name= '" + readbyname + "'";
                            rs = stmt.executeQuery(sqlr);
                            if (rs.next()) {
                                dbid = rs.getString("ID");
                                dbname = rs.getString("name");
                                dbnohp = rs.getString("no_hp");
                                dbemail = rs.getString("email");
                                System.out.println("Detail Akun");
                                System.out.println("---------------------");
                                System.out.println("ID: " + dbid + "\nUsername: " + dbname + "\nNo HP: " + dbnohp + "\nEmail: " + dbemail);
                            } else {
                                System.out.println("Data Akun Tidak Ditemukan");
                            }
                            System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                            loop = input.nextLine();

                        }
                        //detail transaksi
                        if (reads == 2) {
                            System.out.println("Silahkan Masukkan ID Transaksi: ");
                            String readtrans = input.nextLine();
                            String sqlrt = "SELECT transanction_id, users.ID, username.name, products.product_id, pn.name_product, prc.price, create_date FROM transanction JOIN users ON transanction.ID = users.ID JOIN users AS username ON transanction.ID = username.ID JOIN products ON transanction.product_id = products.product_id JOIN products AS pn ON transanction.product_id = pn.product_id JOIN products AS prc ON transanction.product_id = prc.product_id WHERE transanction_id='" + readtrans + "'";
                            rs = stmt.executeQuery(sqlrt);
                            if (rs.next()) {
                                String dbtid = rs.getString("transanction_id");
                                dbid = rs.getString("ID");
                                dbname = rs.getString("name");
                                String dbproductid = rs.getString("product_id");
                                String dbnameproduct = rs.getString("name_product");
                                String dbprice = rs.getString("price");
                                String createdate = rs.getString("create_date");
                                System.out.println("Detail Transaksi");
                                System.out.println("---------------------");
                                System.out.println("Transaction ID: " + dbtid + "\nID: " + dbid + "\nUsername: " + dbname + "\nProduct ID: "
                                        + dbproductid + "\nName Product: " + dbnameproduct
                                        + "\nPrice: Rp. " + dbprice + "\nCreate Date: " + createdate);
                            } else {
                                System.out.println("\nData Transaksi Tidak Ditemukan");
                            }
                            System.out.println("\nKembali Ke Navigasi Awal? (Y/N)");
                            loop = input.nextLine();

                        }
                        break;
                    // end read
                    default:
                        System.out.println("Pilihan Invalid");
                }
            } while (loop.equalsIgnoreCase("Y"));

            Conn.close();
            stmt.close();
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
