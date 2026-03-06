import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Menyalin File ===");
        System.out.print("Masukkan nama file sumber: ");
        String sumber = sc.nextLine();

        System.out.print("Masukkan nama file tujuan: ");
        String tujuan = sc.nextLine();

        try (
                FileInputStream fis = new FileInputStream(sumber);
                FileOutputStream fos = new FileOutputStream(tujuan)
        ) {
            int data;

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File berhasil disalin!");
        } catch (IOException e) {
            System.out.println("Terjadi error: " + e.getMessage());
        }
    }
}
