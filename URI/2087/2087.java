import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String texto;
        boolean flag = false;
        List<String> lista = new ArrayList<String>();
        int N = scan.nextInt();
        while (N != 0) {
            for (int i = 0; i < N; i++) {
                texto = scan.next();
                lista.add(texto);
            }
            Collections.sort(lista);
            for (int i = 0; i < lista.size() - 1; i++) {
                if (lista.get(i).length() <= lista.get(i + 1).length()) {
                    if (lista.get(i).equals(lista.get(i + 1).substring(0, lista.get(i).length()))) {
                        System.out.println("Conjunto Ruim");
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) System.out.println("Conjunto Bom");
            flag = false;
            lista.clear();
            N = scan.nextInt();
        }
        scan.close();
    }

}
