/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 *
 * Página 269 Thomas H. Cormen 3 ed
 *
 * Corte de Hastes Memorizado de baixo para cima/Memoized Cut Rod Botton Up
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtração de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 * 
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
import java.util.Arrays;

public class Principal {

    /**
     * Imprime a solução para a haste.
     *
     * @param s Vetor com a solução
     * @param n Tamanho da haste.
     */
    public static void imprimirCorteDeHastesSolucao(int[] s, int n) {
        System.out.print("Para "+ n + " cortes: ");
        while (n > 0) {
            System.out.print(s[n] + "-");
            n = n - s[n];
        }
        System.out.println();
    }

    /**
     * Cortes de Hastes/Cut Rod.
     *
     * @param p Vetor dos preços das hastes.
     * @param n Tamanho de haste.
     *
     * @return Matriz na posição 0 com a receita máxima possível para uma haste
     * de comprimento n. Na posição 1 contém o tamanho ótimo i da primeira peça.
     */
    public static int[][] memoizedcorteDeHastes(int[] p, int n) {
        //um novo arranjo
        int[] r = new int[n + 1];
        int[] s = new int[n + 1];
        r[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                if (q < (p[i - 1] + r[j - i])) {
                    q = p[i - 1] + r[j - i];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
        int[][] retorno = {r, s};
        return retorno;
    }

    public static void main(String args[]) {

        //Vetor dos dados com os preços das hastes   
        int p[] = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        //Tamanho da astes
        int n = 10;

        System.out.println(">>> Corte de Hastes Memorizado de baixo para cima/Memoized Cut Rod Botton Up <<<");

        int[][] retorno = memoizedcorteDeHastes(p, n);

        int[] r = retorno[0];
        int[] s = retorno[1];
        System.out.println("s:" + Arrays.toString(s));
        System.out.println("r:" + Arrays.toString(r));

        System.out.println("\nSolução com n=10");
        imprimirCorteDeHastesSolucao(s, 10);

        System.out.println("\nSolução com n=7");
        imprimirCorteDeHastesSolucao(s, 7);
    }
}
