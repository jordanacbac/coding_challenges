import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> ctrl = new ArrayList<Integer>();
    static List<List<Integer>> grafo = new ArrayList<List<Integer>>();;
    static int casos;

    private static void buscaEmProfundidade(int n, int space) {
        ctrl.set(n, 1);
        for (int i = 0; i < grafo.get(n).size(); i++) {
            for (int j = 0; j < space; j++) {
                System.out.print(' ');
            }
            System.out.print(n + "-" + grafo.get(n).get(i));
            if (ctrl.get(grafo.get(n).get(i)) == 0) {
                System.out.println(" pathR(G," + grafo.get(n).get(i) + ")");
                buscaEmProfundidade(grafo.get(n).get(i), space + 2);
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        casos = 1;
        int teste = scan.nextInt();
        List<Integer> flags = new ArrayList<Integer>();
        for (int i = teste; i > 0; i--) {
            int V = scan.nextInt();
            int E = scan.nextInt();
            for (int j = 0; j < V; j++) {
                grafo.add(new ArrayList<Integer>());
                ctrl.add(0);
                flags.add(0);
            }
            for (int j = 0; j < E; j++) {
                int u = scan.nextInt();
                int w = scan.nextInt();
                flags.set(u, 1);
                grafo.get(u).add(w);
            }
            for (int j = 0; j < V; j++) {
                Collections.sort(grafo.get(j));
            }
            System.out.println("Caso " + casos + ":");
            casos++;
            for (int j = 0; j < V; j++) {
                if (ctrl.get(j) == 0 && flags.get(j) == 1) {
                    buscaEmProfundidade(j, 2);
                    System.out.println();
                }
            }
            grafo.clear();
            ctrl.clear();
            flags.clear();
        }
        scan.close();
    }

}
