package br.ufrn.imd.domain;

import br.ufrn.imd.exception.FatorInvalidoException;

/**
 * Classe para realizar todas as opera��es necess�rias para o c�lculo do n�mero de Euler.
 *
 * @author Rodolpho Erick - rodolphoess@gmail.com
 */
public class CalculoNumeroEuler {

    private double resultado;

    /**
     * M�todo para c�lculo do n�mero de Euler.
     *
     * @param fator N�mero 'n' para c�lculo do n�mero de euler.
     *
     * @return Retorna o n�mero de euler ao final do c�lculo.
     * @throws FatorInvalidoException Retorna uma exce��o caso seja informado um valor negativo.
     */
    public double numeroDeEuler(int fator) throws FatorInvalidoException {
        if (fator < 0) {
            throw new FatorInvalidoException("O n�mero informado para c�lculo do N�mero de Euler deve ser um n�mero natural.");
        }

        for (int i = 1; i < fator; i++) {
            resultado = resultado + 1 / fatorial(i);
        }

        return resultado;
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
