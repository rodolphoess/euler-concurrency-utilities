package br.ufrn.imd.tests;

import br.ufrn.imd.domain.CalculoNumeroEuler;
import br.ufrn.imd.exception.FatorInvalidoException;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculoNumeroEulerTest {

    CalculoNumeroEuler calculoNumeroEuler;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    public void setUp() {
        calculoNumeroEuler = new CalculoNumeroEuler();
    }

    @Test
    public void realiza_o_calculo_do_numero_de_euler_com_sucesso() throws FatorInvalidoException {

        double resultadoCalculo = this.calculoNumeroEuler.numeroDeEuler(5);

        assertEquals(calculoNumeroEuler.getResultado(), resultadoCalculo, 0);
    }

}