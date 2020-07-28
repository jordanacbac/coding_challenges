import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int[] E;
	static int[] PC;

	private static int buscar(int P, int W) {
		int[][] matriz = new int[P + 1][W + 1];
		for (int i = 0; i <= P; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					matriz[i][j] = 0;
				} else {
					matriz[i][j] = matriz[i - 1][j];
					if (j - PC[i - 1] >= 0) matriz[i][j] = Math.max(matriz[i][j], matriz[i - 1][j - PC[i - 1]] + E[i - 1]);
				}
			}
		}
		return matriz[P][W];
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int G = scan.nextInt();
		int P;
		int W;
		for (int i = 0; i < G; i++) {
			P = scan.nextInt();
			W = scan.nextInt();
			E = new int[P];
			PC = new int[P];
			for (int j = 0; j < P; j++) {
				E[j] = scan.nextInt();
				PC[j] = scan.nextInt();
			}
			System.out.println("Galho " + (i + 1) + ":");
			System.out.println("Numero total de enfeites: " + buscar(P, W));
			System.out.println();
		}
		scan.close();
	}

}
