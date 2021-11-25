import java.io.*;

public class Merge {
    public static void merge(InputStream f1, InputStream f2, OutputStream f3) throws IOException {
        InputStream input1 = new BufferedInputStream(f1);
        InputStream input2 = new BufferedInputStream(f2);
        BufferedOutputStream input3 = new BufferedOutputStream(f3);
        byte[] data = new byte[2000];
        int n = -1;
        while ((n = f1.read(data)) != -1) {
            input3.write(data, 0, n);
        }
        while ((n = f2.read(data)) != -1) {
            input3.write(data, 0, n);
        }
        input3.flush();
        input1.close();
        input2.close();
        input3.close();
    }

    public static void main(String[] args) throws IOException {
        String f1 = "f1.txt";
        String f2 = "f2.txt";
        String f3 = "f3.txt";
        merge(new FileInputStream(f1), new FileInputStream(f2), new FileOutputStream(f3, true));
    }
}
