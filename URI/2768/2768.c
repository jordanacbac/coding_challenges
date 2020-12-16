#include <stdio.h>
#include <string.h>
#define inf 0x3f3f3f3f
#define min(a, b) (((a) < (b)) ? (a) : (b))

void floyd_warshall(int N, int (*grafo)[N][N][N]){
    int i = 0;
    while(i < N) {
        int j = 0;
        while(j < i + 1) {
            int k = 0;
            while(k < N) {
                int l = 0;
                while(l < N) {
                    (*grafo)[i][k][l] = min((*grafo)[0][k][l], min((*grafo)[i][k][l], (*grafo)[i][k][j] + (*grafo)[i][j][l]));
                    l++;
                }
                k++;
            }
            j++;
        }
        i++;
    }
}

int main(){
    int N, M, U, V, W, K, Q, res;
    while(scanf("%d %d", &N, &M) != EOF) {
        int grafo[N][N][N];
        memset(grafo, inf, sizeof(grafo));
        while(M--) {
            scanf("%d %d %d", &U, &V, &W);
            U--;
            V--;
            grafo[0][U][V] = W;
            grafo[0][V][U] = W;
            grafo[0][U][U] = 0;
            grafo[0][V][V] = 0;
        }
        floyd_warshall(N, &grafo);
        scanf("%d", &Q);
        while(Q--) {
            scanf("%d %d %d", &U, &V, &K);
            U--;
            V--;
            K--;
            res = grafo[K][U][V];
            if(res != inf) {
                printf("%d\n", res);
            } else {
                printf("%d\n", -1);
            }
        }
    }
    return 0;
}
