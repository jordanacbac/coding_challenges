import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		List<String> arvs = new ArrayList<String>();
		String input;
		int N;
		int cont;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		scan.nextLine();
		scan.nextLine();
		for (int i = N; i > 0; i--) {
			mapa.clear();
			arvs.clear();
			cont = 0;
			while (scan.hasNextLine()) {
				input = scan.nextLine();
				if (input.equals("")) break;
				cont++;
				if (mapa.containsKey(input)) {
					mapa.put(input, mapa.get(input) + 1);
				} else {
					mapa.put(input, 1);
					arvs.add(input);
				}
			}
			Collections.sort(arvs);
			for (int j = 0; j < arvs.size(); j++) {
				double res = ((double) mapa.get(arvs.get(j))) / cont * 100;
				System.out.println(arvs.get(j) + String.format(" %.4f", res));
			}
			if (i != 1) System.out.println();
		}
		scan.close();
	}

}
