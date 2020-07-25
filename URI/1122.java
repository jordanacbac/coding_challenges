import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static int N;
	static int F;
	static int[] entrada;
	static boolean[] pos;
	static boolean[] neg;
	static Map<String, Boolean> mapa;

	static public boolean executar(int i, int soma) {
		if (i >= N && soma == F) {
			return true;
		} else if (i >= N) {
			return false;
		}
		String memo = soma + " " + i;
		if (mapa.containsKey(memo)) return mapa.get(memo);
		boolean in = false;
		boolean out = false;
		in = executar(i + 1, soma + entrada[i]);
		out = executar(i + 1, soma - entrada[i]);
		if (in && !out) {
			pos[i] = true;
		} else if (!in && out) {
			neg[i] = true;
		} else if (in && out) {
			pos[i] = true;
			neg[i] = true;
		}
		mapa.put(memo, in || out);
		if (in || out) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			N = scan.nextInt();
			F = scan.nextInt();
			if (N + F == 0) {
				scan.close();
				return;
			}
			pos = new boolean[50];
			neg = new boolean[50];
			entrada = new int[50];
			mapa = new HashMap<String, Boolean>();
			for (int i = 0; i < N; i++) {
				entrada[i] = scan.nextInt();
				pos[i] = false;
				neg[i] = false;
			}
			boolean flag = executar(0, 0);
			for (int i = 0; i < N && flag; i++) {
				if (pos[i] && neg[i]) {
					System.out.print("?");
				} else if (pos[i]) {
					System.out.print("+");
				} else {
					System.out.print("-");
				}
			}
			if (!flag) System.out.print("*");
			System.out.println();
		}
		scan.close();
	}

}