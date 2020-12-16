import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        if (N <= 100 && N >= 86) {
            System.out.print("A");
        } else if (N <= 85 && N >= 61) {
            System.out.print("B");
        } else if (N <= 60 && N >= 36) {
            System.out.print("C");
        } else if (N <= 35 && N >= 1) {
            System.out.print("D");
        } else if (N == 0) {
            System.out.print("E");
        }
        System.out.println();
        scan.close();
    }

}
