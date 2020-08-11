import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[] preco;
        int[] custo;
        int indice;
        int quantidade;
        for (int i = 0; i < T; i++) {
            int D = scan.nextInt();
            int I = scan.nextInt();
            int B = scan.nextInt();
            preco = new int[I];
            for (int j = 0; j < I; j++) {
                preco[j] = scan.nextInt();
            }
            custo = new int[B];
            for (int j = 0; j < B; j++) {
                int numIngredientes = scan.nextInt();
                for (int k = 0; k < numIngredientes; k++) {
                    indice = scan.nextInt();
                    quantidade = scan.nextInt();
                    custo[j] = custo[j] + (preco[indice] * quantidade);
                }
            }
            Arrays.sort(custo);
            System.out.println(D / custo[0]);
        }
        scan.close();
    }

}
