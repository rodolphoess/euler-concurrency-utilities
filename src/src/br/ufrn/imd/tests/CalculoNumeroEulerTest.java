package br.ufrn.imd.tests;

import br.ufrn.imd.domain.CalculoNumeroEuler;
import br.ufrn.imd.exception.FatorInvalidoException;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculoNumeroEulerTest {

    CalculoNumeroEuler calculoNumeroEuler;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void realiza_o_calculo_do_numero_de_euler_com_sucesso() throws FatorInvalidoException {

        calculoNumeroEuler = new CalculoNumeroEuler(5);
        this.calculoNumeroEuler.run();
        double resultadoCalculo = calculoNumeroEuler.getResultado();

        assertEquals(calculoNumeroEuler.getResultado(), resultadoCalculo, 0);
    }

    @Test
    public void retorna_uma_excecao_ao_passar_um_fator_negativo() {
        expectedException.expect(FatorInvalidoException.class);

        try {
            calculoNumeroEuler = new CalculoNumeroEuler(-1);
        } catch (FatorInvalidoException e) {
            e.printStackTrace();
        }
    }

}