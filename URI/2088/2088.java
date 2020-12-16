import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static int N;
    static double[][] dist;
    static Map<String, Double> memo;

    //Conta o número de focos visitados até o momento.
    private static int contar(int[] focos) {
        int cont = 0;
        for(int i = 0; i < focos.length; i++) {
            if(focos[i] == 1) cont++;
        }
        return cont;
    }
    
    //Transforma em String o estado atual dos focos.
    private static String imprimeFocos(int[] focos) {
        String palavra = "";
        for(int i = 0; i < focos.length; i++) {
            if(focos[i] == 0) palavra = palavra + "0";
            if(focos[i] == 1) palavra = palavra + "1";
        }
        return palavra;
    }
    
    //Algoritmo do caixeiro viajante.
    private static double TSP(int atual, int[] focos) {
        //Se todos os focos foram visitados, retorna a distância atual para a origem. 
        if(contar(focos) == N) return dist[atual][0];
        String est = atual + " " + imprimeFocos(focos);
        //Caso esse estado est já tenha sido calculado, retorna o resultado salvo.
        if(memo.containsKey(est)) return memo.get(est);
        //Inicia a resposta com a maior distância possível.
        double res = Integer.MAX_VALUE;
        //Itera por todos os focos.
        for (int prox = 0; prox < N; prox++) {
            //Se a próxima coordenada (prox) for igual a coordenada atual (atual), não há distância.
            //Se o próximo foco (focos[prox]) já foi visitado antes, não se deve visitar novamente.
            if (prox != atual && focos[prox] == 0) {
                int[] novoFocos = Arrays.copyOf(focos, focos.length);
                novoFocos[prox] = 1;
                //Guarda o resultado mínimo dentre todos os caminhos percorridos.
                res = Math.min(res, dist[atual][prox] + TSP(prox, novoFocos));
            }
        }
        //Salva o resultado calculado do estado atual e retorna ele.
        memo.put(est, res);
        return  res;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            //Recebe N e encerra a execução se o valor for 0.
            N = scan.nextInt();
            if(N == 0) {
                scan.close();
                return;
            }
            //Incrementa o não para considerar a origem.
            //Recebe as coordenadas dos focos em x e y.
            //Inicia um vetor ctrl, para controle dos focos visitados.
            //Inicia uma matriz para salvar as distâncias entre os focos.
            N++;
            int[] x = new int[N];
            int[] y = new int[N];
            int[] ctrl = new int[N];
            dist = new double[N][N];
            memo = new HashMap<String, Double>();
            //Recebe as coordenadas.
            for (int i = 0; i < N; i++) {
                x[i] = scan.nextInt();
                y[i] = scan.nextInt();
            }
            //Calcula as distâncias e salva na matriz dist.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i + 1; j++) {
                    dist[i][j] = Math.hypot(x[j] - x[i], y[j] - y[i]);
                    dist[j][i] = dist[i][j];
                }
            }
            //Inicia a origem como já visitada.
            ctrl[0] = 1;
            //Imprime o resultado.
            System.out.printf("%.2f", TSP(0, ctrl));
            System.out.println();
        }
        scan.close();
        return;
    }

}
