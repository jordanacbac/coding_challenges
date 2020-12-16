import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int res = 0;
            int U = 0;
            int V = 0;
            int W = 0;
            int K = 0;
            double[][][] A = new double[N][N][N];
            Double inf = Double.POSITIVE_INFINITY;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        A[i][j][k] = inf;
                    }
                }
            }
            for (int i = M; i > 0; i--) {
                U = scan.nextInt();
                U--;
                V = scan.nextInt();
                V--;
                W = scan.nextInt();
                A[0][U][V] = (double) W;
                A[0][V][U] = (double) W;
                A[0][U][U] = 0;
                A[0][V][V] = 0;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < N; l++) {
                            A[i][k][l] = Math.min(A[0][k][l], Math.min(A[i][k][l], A[i][k][j] + A[i][j][l]));
                        }
                    }
                }
            }
            int Q = scan.nextInt();
            for (int i = Q; i > 0; i--) {
                U = scan.nextInt();
                U--;
                V = scan.nextInt();
                V--;
                K = scan.nextInt();
                K--;
                if (A[K][U][V] == inf) {
                    res = -1;
                } else {
                    res = (int) A[K][U][V];
                }
                System.out.println(res);
            }
        }
        scan.close();
    }

}
