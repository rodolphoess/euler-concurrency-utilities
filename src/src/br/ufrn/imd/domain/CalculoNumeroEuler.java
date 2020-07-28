package br.ufrn.imd.domain;

import br.ufrn.imd.exception.FatorInvalidoException;

/**
 * Classe para realizar todas as operações necessárias para o cálculo do número de Euler.
 *
 * @author Rodolpho Erick - rodolphoess@gmail.com
 */
public class CalculoNumeroEuler implements Runnable {

    private final int fator;
    private double resultado;

    public CalculoNumeroEuler(int fator) throws FatorInvalidoException {
        if (fator < 0) {
            throw new FatorInvalidoException("O número informado para cálculo do Número de Euler deve ser um número natural.");
        }

        this.fator = fator;
    }

    /**
     * Realiza o cálculo do número de euler fazendo uso da concorrência.
     */
    @Override
    public void run() {

        for (int i = 1; i < fator; i++) {
            resultado = resultado + 1 / fatorial(i);
        }
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
