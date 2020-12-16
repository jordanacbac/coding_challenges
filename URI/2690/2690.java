import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    private static String readLine(Scanner scan) {
        String line = scan.nextLine();
        while (line.isEmpty()) {
            line = scan.nextLine();
        }
        return line.replaceAll(" ","");
    }

    public static void main(String[] args) throws IOException {
        Map<Character, Integer> encode = new HashMap<Character, Integer>();
        encode.put('G', 0); encode.put('Q', 0); encode.put('a', 0); encode.put('k', 0); encode.put('u', 0);
        encode.put('I', 1); encode.put('S', 1); encode.put('b', 1); encode.put('l', 1); encode.put('v', 1);
        encode.put('E', 2); encode.put('O', 2); encode.put('Y', 2); encode.put('c', 2); encode.put('m', 2); encode.put('w', 2);
        encode.put('F', 3); encode.put('P', 3); encode.put('Z', 3); encode.put('d', 3); encode.put('n', 3); encode.put('x', 3);
        encode.put('J', 4); encode.put('T', 4); encode.put('e', 4); encode.put('o', 4); encode.put('y', 4);
        encode.put('D', 5); encode.put('N', 5); encode.put('X', 5); encode.put('f', 5); encode.put('p', 5); encode.put('z', 5);
        encode.put('A', 6); encode.put('K', 6); encode.put('U', 6); encode.put('g', 6); encode.put('q', 6);
        encode.put('C', 7); encode.put('M', 7); encode.put('W', 7); encode.put('h', 7); encode.put('r', 7);
        encode.put('B', 8); encode.put('L', 8); encode.put('V', 8); encode.put('i', 8); encode.put('s', 8);
        encode.put('H', 9); encode.put('R', 9); encode.put('j', 9); encode.put('t', 9);
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for(int i = 0; i < N; i++) {
            String pass = readLine(scan);
            for (int j = 0; j < pass.length(); j++) {
                if(j == 12) break;
                System.out.print(encode.get(pass.charAt(j)));
            }
            if(i != N) System.out.println();
        }
        scan.close();
        return;
    }
    
}
