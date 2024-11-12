package dev.pilar.banco;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CuentaCorrienteTest {

    
    @SuppressWarnings("deprecation")
    @Test
    public void testCuentaCorrienteCreacion() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(1, 5000f, 0.05f);

       
        assertThat(cuentaCorriente.imprimir(), containsString("Saldo: 5000.00"));
        
        
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 0.0"));
    }

   
    @SuppressWarnings("deprecation")
    @Test
    public void testRetirarSinSobregiro() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(2, 3000f, 0.05f);

        
        cuentaCorriente.retirar(1000f);

        
        assertThat(cuentaCorriente.imprimir(), containsString("Saldo: 2000.00"));

        
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 0.0"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testRetiroConSobregiro() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(3, 2000f, 0.05f);

        
        cuentaCorriente.retirar(2500f);

       
        assertThat(cuentaCorriente.imprimir(), containsString("Saldo: 0.00"));

        
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 500.0"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testConsignarConSobregiro() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(4, 1000f, 0.05f);

        
        cuentaCorriente.retirar(1500f);  

       
        cuentaCorriente.consignar(600f);

        
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 0.0"));

        
        assertThat(cuentaCorriente.imprimir(), containsString("Saldo: 100.00"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testConsignarParcialmenteSobregiro() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(5, 1000f, 0.05f);

        
        cuentaCorriente.retirar(1500f);  

        
        cuentaCorriente.consignar(400f);

        
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 100.0"));

        
        assertThat(cuentaCorriente.imprimir(), containsString("Saldo: 0.00"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testRetiroMaximo() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(6, 1000f, 0.05f);

        
        cuentaCorriente.retirar(2000f);

       
        assertThat(cuentaCorriente.imprimir(), containsString("Saldo: 0.00"));
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 1000.0"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testExtractoMensual() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(7, 3000f, 0.12f);
        cuentaCorriente.comisionMensual = 100f;

       
        cuentaCorriente.extractoMensual();

        
        assertThat(cuentaCorriente.imprimir(), containsString("Saldo: 3000.00"));
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 0.0"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testImprimir() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(8, 5000f, 0.05f);

        
        assertThat(cuentaCorriente.imprimir(), containsString("ID: 8"));
        assertThat(cuentaCorriente.imprimir(), containsString("Saldo: 5000.00"));
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 0.0"));
    }
}