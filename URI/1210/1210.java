import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int I;
    static int M;
    static int P;
    static int[] C;
    static int[] V;
    static int[][] matriz;

    //Calcula utilizando programação dinâmica.
    static int calcular(int i, int tempo) {
        if (i == N) return matriz[i][tempo] = 0;
        if (matriz[i][tempo] != -1) return matriz[i][tempo];
        if (tempo == M) return matriz[i][tempo] = calcular(i + 1, 1) + P - V[tempo - 1] + C[0];
        int valorA = calcular(i + 1, 1) + P - V[tempo - 1] + C[0];
        int valorB = calcular(i + 1, tempo + 1) + C[tempo];
        return matriz[i][tempo] = Math.min(valorA, valorB);
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        List<Integer> res;
        while (scan.hasNext()) {
            N = scan.nextInt();
            I = scan.nextInt();
            M = scan.nextInt();
            P = scan.nextInt();
            C = new int[2010];
            V = new int[2010];
            matriz = new int[2010][2010];
            res = new ArrayList<Integer>();
            //Carrega os custos de manutenção.
            for (int i = 0; i < M; i++) {
                C[i] = scan.nextInt();
            }
            //Carrega os valores de venda.
            for (int i = 0; i < M; i++) {
                V[i] = scan.nextInt();
            }
            //Inicia a matriz inteira com -1.
            for (int[] linha : matriz) {
                Arrays.fill(linha, -1);
            }
            int temp = calcular(0, I);
            System.out.println(temp);
            Arrays.fill(matriz[N], 0);
            temp = I;
            for (int i = 0; i < N; i++) {
                if (temp == M) {
                    res.add(i + 1);
                    temp = 1;
                } else {
                    int valorA = matriz[i + 1][1] + P - V[temp - 1] + C[0];
                    int valorB = matriz[i + 1][temp + 1] + C[temp];
                    if (valorA <= valorB) {
                        res.add(i + 1);
                        temp = 1;
                    } else {
                        temp++;
                    }
                }
            }
            if (res.size() == 0) {
                System.out.println(0);
                continue;
            }
            for (int i = 0; i < res.size(); i++) {
                if (i > 0) System.out.print(' ');
                System.out.print(res.get(i));
            }
            System.out.println();
        }
        scan.close();
    }

}
