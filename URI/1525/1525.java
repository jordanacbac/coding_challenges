import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int N;
    static int M;
    static int K;
    static int[][] controle;
    static char[][] mapa;
    static Stack<Integer[]> pilha;

    public static char inverter(char seta) {
        if (seta == '>') return '<';
        if (seta == '<') return '>';
        if (seta == '^') return 'v';
        if (seta == 'v') return '^';
        return seta;
    }

    public static void colocaNaPilha(int x, int y, int ctrl, char esperado) {
        if (x < 0 || x >= N || y < 0 || y >= M) return;
        if (mapa[x][y] == esperado && ctrl < controle[x][y]) {
            controle[x][y] = ctrl;
            pilha.push(new Integer[] { x, y, ctrl });
        } else if (mapa[x][y] == inverter(esperado) && ctrl < controle[x][y] && ctrl < K) {
            controle[x][y] = ctrl + 1;
            pilha.push(new Integer[] { x, y, ctrl + 1 });
        }
    }

    public static boolean buscar(int linX, int colX) {
        colocaNaPilha(linX, colX, 0, 'x');
        while (!pilha.isEmpty()) {
            Integer[] coord = pilha.pop();
            if (coord[0] == N - 1 || coord[0] == 0 || coord[1] == M - 1 || coord[1] == 0) return true;
            colocaNaPilha(coord[0] - 1, coord[1], coord[2], 'v');
            colocaNaPilha(coord[0] + 1, coord[1], coord[2], '^');
            colocaNaPilha(coord[0], coord[1] - 1, coord[2], '>');
            colocaNaPilha(coord[0], coord[1] + 1, coord[2], '<');
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        while (N != 0) {
            int linX = 0;
            int colX = 0;
            String linha;
            controle = new int[N][M];
            mapa = new char[N][M];
            pilha = new Stack<Integer[]>();
            for (int[] i : controle) Arrays.fill(i, Integer.MAX_VALUE);
            for (int i = 0; i < N; i++) {
                linha = scan.next();
                for (int j = 0; j < M; j++) {
                    mapa[i][j] = linha.charAt(j);
                    if (mapa[i][j] == 'x') {
                        linX = i;
                        colX = j;
                    }
                }
            }
            if (buscar(linX, colX)) {
                System.out.println("Sim");
            } else {
                System.out.println("Nao");
            }
            N = scan.nextInt();
            M = scan.nextInt();
            K = scan.nextInt();
        }
        scan.close();
    }

}
