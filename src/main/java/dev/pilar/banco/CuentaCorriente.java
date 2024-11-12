package dev.pilar.banco;

public class CuentaCorriente extends Cuenta {
    private float sobregiro;
    private int cuentaId;  

    
    public CuentaCorriente(int id, float saldo, float tasaAnual) {
        super(id, saldo, tasaAnual);
        this.sobregiro = 0;
        this.cuentaId = id;  
    }

    
    @Override
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            super.retirar(cantidad);
        } else {
            sobregiro += cantidad - saldo;
            saldo = 0;
            numRetiros++;
        }
    }

    
    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
                cantidad = 0;
            }
        }
        super.consignar(cantidad);
    }

    
    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    
    @Override
    public String imprimir() {
        return super.imprimir() + ", Sobregiro: " + sobregiro + ", Cuenta ID: " + cuentaId;
    }
}