package dev.pilar.banco;

public class CuentaAhorros extends Cuenta {
    private boolean cuentaActiva;
    private int cuentaId;  

    
    public CuentaAhorros(int id, float saldo, float tasaAnual) {
        super(id, saldo, tasaAnual);
        this.cuentaActiva = saldo >= 10000;
        this.cuentaId = id;  
    }

    
    @Override
    public void consignar(float cantidad) {
        if (cuentaActiva) {
            super.consignar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva.");
        }
    }

    
    @Override
    public void retirar(float cantidad) {
        if (cuentaActiva) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva.");
        }
    }

    
    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual = (numRetiros - 4) * 1000; 
        }
        super.extractoMensual();
        cuentaActiva = saldo >= 10000;
    }

    
    @Override
    public String imprimir() {
        return super.imprimir() + ", Cuenta Activa: " + cuentaActiva + ", Cuenta ID: " + cuentaId;
    }
}