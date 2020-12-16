import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        List<Integer> even = new ArrayList<Integer>();
        List<Integer> odd = new ArrayList<Integer>();
        int N = scan.nextInt();
        int number = 0;
        for (int i = 0; i < N; i++) {
            number = scan.nextInt();
            if (number % 2 == 0) {
                even.add(number);
            } else {
                odd.add(number);
            }
        }
        Collections.sort(even);
        Collections.sort(odd, Collections.reverseOrder());
        for (int i = 0; i < even.size(); i++) System.out.println(even.get(i));
        for (int i = 0; i < odd.size(); i++) System.out.println(odd.get(i));
        scan.close();
    }

}
