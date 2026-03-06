package InputJava;
import java.io.*;
class Input1 {
    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Masukkan Nama Anda : ");
        str = br.readLine();

        System.out.println("Hello " + str);
    }
}
