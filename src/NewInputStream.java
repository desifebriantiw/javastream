import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class NewInputStream {
    public static void main(String[] args) {
        try {
            InputStream ia=new FileInputStream("D:\\Semester 4\\Pemograman Jaringan\\javastream\\src");
            int data=ia.read();
            while (data!=-1){
                System.out.println((char)data);
//               System.out.println(data);
                data=ia.read();

            }
        } catch (Exception e) {

        }
    }
}