package br.ufrn.imd;

import br.ufrn.imd.domain.CalculoNumeroEuler;
import br.ufrn.imd.exception.FatorInvalidoException;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    private static int fatorCalculo = 0;

    /**
     * M�todo de inicializa��o da execu��o do programa Java que chamar� a leitura dos dados do usu�rio, a instancia��o das Threads
     * e por fim a chamada para o c�lculo do n�mero de euler.
     *
     * @param args Entradas do usu�rio por linha de comando.
     * @throws FatorInvalidoException Exce��o caso seja passado um fator zero ou negativo.
     */
    public static void main(String[] args) throws FatorInvalidoException {

        entradasUsuario();

        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable task = new CalculoNumeroEuler(fatorCalculo);
        System.out.println("\nExecutando c�lculo do n�mero de Euler utilizando a Cached Thread Pool...");

        executor.execute(task);
        executor.shutdown();
    }

    /**
     * Realiza a leitura das entradas do usu�rio para o fator de c�lculo do n�mero de euler e o n�mero de threads que o
     * usu�rio deseja alocar para realizar o c�lculo.
     */
    private static void entradasUsuario() {
        Scanner scanner = new Scanner(System.in);

        while (fatorCalculo <= 0) {
            System.out.print("\nInforme o fator para c�lculo do N�mero de Euler: ");
            fatorCalculo = scanner.nextInt();
        }
    }

}
