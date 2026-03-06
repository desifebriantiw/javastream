import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Javastream {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("D:/Coolyah/Kelas 2B Sem 4/Pemrograman Jaringan/praktek1.txt");
            Scanner s = new Scanner(System.in);
            System.out.println("Masukkan kalimat =");
            String data = s.nextLine();
            os.write(data.getBytes());
            os.flush();
            os.close();
            System.out.println("Pengiriman Data Berhasil");
        } catch (Exception e) {
            System.err.println("Pengiriman Data Tidak Berhasil");
        }
    }
}
