import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void sortbyColumn(int arr[][], int col) {
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[col] < b[col]) return -1;
				if (a[col] == b[col]) {
					if (a[0] > b[0]) {
						return -1;
					} else {
						return 1;
					}
				}
				return 1;
			}
		});
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			String input = scan.next();
			int[] cont = new int[130];
			int[][] map = new int[130][2];
			for (int i = 0; i < input.length(); i++) {
				cont[(int) input.charAt(i)]++;
			}
			for (int i = 0; i < cont.length; i++) {
				if (cont[i] != 0) {
					map[i][0] = i;
					map[i][1] = cont[i];
				}
			}
			sortbyColumn(map, 1);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != 0) {
						System.out.print(map[i][j]);
						if (j == 0) System.out.print(" ");
					}
				}
				if (map[i][0] != 0) System.out.println();
			}
			if (scan.hasNext()) {
				System.out.println();
			} else {
				scan.close();
				return;
			}
		}
	}

}
