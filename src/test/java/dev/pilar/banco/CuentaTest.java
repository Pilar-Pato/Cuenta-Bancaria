package dev.pilar.banco;


import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CuentaTest {

    @SuppressWarnings("deprecation")
    @Test
    public void testCuentaAhorros() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(1, 12000, 0.05f);
        
        
        assertThat(cuentaAhorros.imprimir(), containsString("Cuenta Activa: true"));
        
        
        cuentaAhorros.consignar(2000);
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 14000.00"));
        
        
        cuentaAhorros.retirar(5000);
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 9000.00"));
        
        
        cuentaAhorros.extractoMensual();
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 9025.00")); // Interés y comisión
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testCuentaCorriente() {
        CuentaCorriente cuentaCorriente = new CuentaCorriente(2, 2000, 0.06f);

        
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 0.0"));
        
        
        cuentaCorriente.retirar(2500);  
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 500.0"));
        
        
        cuentaCorriente.consignar(1000);
        assertThat(cuentaCorriente.imprimir(), containsString("Sobregiro: 0.0"));
    }
}