import math
import os
import random
import re
import sys
import copy as cp

def calculaUltrapassagens(inicial, final):
    ultrapassagens = 0
    comparador = cp.copy(inicial)
    for i in range(len(inicial)):
        if(comparador[i] != final[i]):
            ultrapassagens += comparador.index(final[i]) - final.index(final[i])
            comparador.remove(final[i])
            comparador.insert(i, final[i])
    print(ultrapassagens)

if __name__ == '__main__':
    while True:
        try:
            n = int(input())
            inicial = list(map(int, input().rstrip().split()))
            final = list(map(int, input().rstrip().split()))
            calculaUltrapassagens(inicial, final)
        except EOFError:
            break
