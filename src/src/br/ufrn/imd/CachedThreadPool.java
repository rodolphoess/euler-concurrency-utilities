package br.ufrn.imd;

import br.ufrn.imd.domain.CalculoNumeroEuler;
import br.ufrn.imd.exception.FatorInvalidoException;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

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

        double tempoInicial = System.currentTimeMillis();
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable task = new CalculoNumeroEuler(fatorCalculo);
        System.out.println("\nExecutando cálculo do número de Euler utilizando a Cached Thread Pool...");

        executor.execute(task);
        executor.shutdown();
        double tempoFinal = System.currentTimeMillis();

        System.out.println("\nTempo de execução: " + (tempoFinal - tempoInicial));
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
