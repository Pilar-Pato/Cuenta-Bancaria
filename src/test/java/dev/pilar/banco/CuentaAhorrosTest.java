package dev.pilar.banco;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CuentaAhorrosTest {

   
    @SuppressWarnings("deprecation")
    @Test
    public void testCuentaAhorrosCreacion() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(1, 15000f, 0.05f);

        
        assertThat(cuentaAhorros.imprimir(), containsString("Cuenta Activa: true"));
        
        
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 15000.00"));
        
        
        assertThat(cuentaAhorros.imprimir(), containsString("Transacciones realizadas: 0"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testCuentaInactiva() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(2, 5000f, 0.05f);

        
        assertThat(cuentaAhorros.imprimir(), containsString("Cuenta Activa: false"));
        
        
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 5000.00"));
        
       
        cuentaAhorros.consignar(1000f);
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 5000.00"));  // El saldo no debe haber cambiado

        cuentaAhorros.retirar(1000f);
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 5000.00"));  // El saldo sigue igual
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testConsignarCuentaActiva() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(3, 15000f, 0.05f);

        
        cuentaAhorros.consignar(1000f);

        
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 16000.00"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testConsignarCuentaInactiva() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(4, 5000f, 0.05f);

        
        cuentaAhorros.consignar(1000f);

        
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 5000.00"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testRetirarCuentaActiva() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(5, 15000f, 0.05f);

        
        cuentaAhorros.retirar(1000f);

        
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 14000.00"));
    }

   
    @SuppressWarnings("deprecation")
    @Test
    public void testRetirarCuentaInactiva() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(6, 5000f, 0.05f);

       
        cuentaAhorros.retirar(1000f);

        
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 5000.00"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testComisionPorRetirosAdicionales() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(7, 20000f, 0.05f);

        
        cuentaAhorros.retirar(1000f);
        cuentaAhorros.retirar(1000f);
        cuentaAhorros.retirar(1000f);
        cuentaAhorros.retirar(1000f);
        cuentaAhorros.retirar(1000f);  

        
        assertThat(cuentaAhorros.imprimir(), containsString("Comisión mensual: 1000.00"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testExtractoMensual() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(8, 15000f, 0.10f);
        cuentaAhorros.comisionMensual = 500f;  

        
        cuentaAhorros.extractoMensual();

        
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 14950.00"));
        assertThat(cuentaAhorros.imprimir(), containsString("Comisión mensual: 500.00"));
    }

    
    @SuppressWarnings("deprecation")
    @Test
    public void testImprimir() {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(9, 10000f, 0.05f);

        
        assertThat(cuentaAhorros.imprimir(), containsString("ID: 9"));
        assertThat(cuentaAhorros.imprimir(), containsString("Saldo: 10000.00"));
        assertThat(cuentaAhorros.imprimir(), containsString("Cuenta Activa: true"));
        assertThat(cuentaAhorros.imprimir(), containsString("Transacciones realizadas: 0"));
    }
}