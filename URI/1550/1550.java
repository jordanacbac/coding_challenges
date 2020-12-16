import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static public int inverter(int i) {
        int res = 0;
        while (i > 0) {
            res = res * 10;
            res = res + (i % 10);
            i = i / 10;
        }
        return res;
    }

    //Busca em Largura (BFS)
    static public int buscaEmLargura(int a, int b) {
        Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
        dist.put(a, 0);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(a);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == b)
                break;
            int[] viz = { u + 1, inverter(u) };
            for (int i = 0; i < viz.length; i++) {
                if (!dist.containsKey(viz[i])) {
                    dist.put(viz[i], dist.get(u) + 1);
                    q.add(viz[i]);
                }
            }
        }
        return dist.get(b);
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int A;
        int B;
        for (int i = T; i > 0; i--) {
            A = scan.nextInt();
            B = scan.nextInt();
            System.out.println(buscaEmLargura(A, B));
        }
        scan.close();
        return;
    }

}
