import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        System.out.println(Long.parseLong(a) + Long.parseLong(b) - Long.parseLong(c));
        System.out.println(Long.parseLong(a+b) - Long.parseLong(c));
    }
}
