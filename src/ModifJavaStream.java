import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ModifJavaStream {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("D:\\Semester 4\\Pemograman Jaringan\\javastream\\src", true);
            Scanner s = new Scanner(System.in);
            System.out.println("Masukkan kalimat =");
            String data = s.nextLine();
            os.write(("\n" + data).getBytes());
            os.flush();
            os.close();
            System.out.println("Pengiriman Data Berhasil");
        } catch (Exception e) {
            System.err.println("Pengiriman Data Tidak Berhasil");
        }
    }
}
