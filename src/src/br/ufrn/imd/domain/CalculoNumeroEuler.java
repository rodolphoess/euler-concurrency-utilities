package br.ufrn.imd.domain;

import br.ufrn.imd.exception.FatorInvalidoException;

import java.util.concurrent.RecursiveAction;

/**
 * Classe para realizar todas as opera��es necess�rias para o c�lculo do n�mero de Euler. Ela extende RecursiveAction para
 * o c�lculo do n�mero de euler utilizando a Work Stealing Thread Pool, e Runnable para o c�lculo utilizando Fixed e Cached
 * Thread Pool.
 *
 * @author Rodolpho Erick - rodolphoess@gmail.com
 */
public class CalculoNumeroEuler extends RecursiveAction implements Runnable {

    private final int fator;
    private double resultado;

    public CalculoNumeroEuler(int fator) throws FatorInvalidoException {
        if (fator < 0) {
            throw new FatorInvalidoException("O fator informado para c�lculo do N�mero de Euler deve ser um n�mero natural.");
        }

        this.fator = fator;
    }

    @Override
    public void run() {
        calculaNumeroEuler();
    }

    @Override
    protected void compute() {
        calculaNumeroEuler();
    }

    /**
     * Realiza o c�lculo do n�mero de euler fazendo uso da concorr�ncia.
     */
    private void calculaNumeroEuler() {
        long idThread = Thread.currentThread().getId();

        System.out.println("\nThread em execu��o de ID " + idThread + ".");

        for (int i = 1; i < fator; i++) {
            resultado = resultado + 1 / fatorial(i);
        }

        System.out.println("\nO n�mero de Euler �: " + getResultado());
    }

    /**
     * M�todo que realiza o c�lculo do fatorial recursivo para ser utilizado no c�lculo do n�mero de euler.
     *
     * @param fator N�mero natural para c�lculo do fatorial.
     * @return O fatorial de um n�mero.
     */
    private double fatorial(int fator) {
        double fatorial;

        if (fator <= 1) {
            return fator;
        } else {
            fatorial = fator * fatorial(fator - 1);
        }

        return fatorial;
    }

    public double getResultado() {
        return resultado;
    }

}
