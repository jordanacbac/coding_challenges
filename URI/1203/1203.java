import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int R;
        int K;
        int temp;
        int[] vertices;
        int[] respostas;
        while (scan.hasNext()) {
            R = scan.nextInt();
            K = scan.nextInt();
            vertices = new int[R];
            respostas = new int[K + 1];
            //Zera todos os valores do vetor.
            for (int i = 0; i < vertices.length; i++) {
                vertices[i] = 0;
            }
            //Insere o grau de cada vertice.
            for (int i = 0; i < K; i++) {
                temp = scan.nextInt();
                vertices[temp - 1]++;
                temp = scan.nextInt();
                vertices[temp - 1]++;
            }
            respostas[0] = 1;
            for (int i = 0; i < vertices.length; i++) {
                for (int j = K; j >= vertices[i]; j--) {
                    if (respostas[j - vertices[i]] == 1) respostas[j] = 1;
                }
            }
            //Verifica se é possível atender os critérios do problema.
            if (respostas[K] == 1) {
                System.out.println("S");
            } else {
                System.out.println("N");
            }
        }
        scan.close();
    }

}
