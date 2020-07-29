package br.ufrn.imd.domain;

import br.ufrn.imd.exception.FatorInvalidoException;

import java.util.concurrent.RecursiveAction;

/**
 * Classe para realizar todas as operações necessárias para o cálculo do número de Euler. Ela extende RecursiveAction para
 * o cálculo do número de euler utilizando a Work Stealing Thread Pool, e Runnable para o cálculo utilizando Fixed e Cached
 * Thread Pool.
 *
 * @author Rodolpho Erick - rodolphoess@gmail.com
 */
public class CalculoNumeroEuler extends RecursiveAction implements Runnable {

    private final int fator;
    private double resultado;

    public CalculoNumeroEuler(int fator) throws FatorInvalidoException {
        if (fator < 0) {
            throw new FatorInvalidoException("O fator informado para cálculo do Número de Euler deve ser um número natural.");
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
     * Realiza o cálculo do número de euler fazendo uso da concorrência.
     */
    private void calculaNumeroEuler() {
        long idThread = Thread.currentThread().getId();

        System.out.println("\nThread em execução de ID " + idThread + ".");

        for (int i = 1; i < fator; i++) {
            resultado = resultado + 1 / fatorial(i);
        }

        System.out.println("\nO número de Euler é: " + getResultado());
    }

    /**
     * Método que realiza o cálculo do fatorial recursivo para ser utilizado no cálculo do número de euler.
     *
     * @param fator Número natural para cálculo do fatorial.
     * @return O fatorial de um número.
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
