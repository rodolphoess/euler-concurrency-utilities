package br.ufrn.imd;

import br.ufrn.imd.domain.CalculoNumeroEuler;
import br.ufrn.imd.exception.FatorInvalidoException;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class WorkStealingThreadPool {

    private static int fatorCalculo = 0;

    /**
     * Método de inicialização da execução do programa Java que chamará a leitura dos dados do usuário, a instanciação das Threads
     * e por fim a chamada para o cálculo do número de euler.
     *
     * @param args Entradas do usuário por linha de comando.
     * @throws FatorInvalidoException Exceção caso seja passado um fator zero ou negativo.
     */
    public static void main(String[] args) throws FatorInvalidoException {

        entradasUsuario();

        CalculoNumeroEuler ne = new CalculoNumeroEuler(fatorCalculo);
        System.out.println("\nExecutando cálculo do número de Euler utilizando a Work Stealing Thread Pool...");

        int parallelism = ForkJoinPool.getCommonPoolParallelism();
        ForkJoinPool stealer = (ForkJoinPool) Executors.newWorkStealingPool(parallelism);
        stealer.invoke(ne);
        stealer.shutdown();
    }

    /**
     * Realiza a leitura das entradas do usuário para o fator de cálculo do número de euler.
     */
    private static void entradasUsuario() {
        Scanner scanner = new Scanner(System.in);

        while (fatorCalculo <= 0) {
            System.out.print("\nInforme o fator para cálculo do Número de Euler: ");
            fatorCalculo = scanner.nextInt();
        }
    }

}
