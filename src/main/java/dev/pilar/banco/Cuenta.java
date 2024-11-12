package dev.pilar.banco;

public class Cuenta {
    protected int id;               
    protected float saldo;
    protected int numConsignaciones;
    protected int numRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    
    public Cuenta(int id, float saldo, float tasaAnual) {
        this.id = id;
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
        this.comisionMensual = 0;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public void consignar(float cantidad) {
        this.saldo += cantidad;
        this.numConsignaciones++;
    }

    
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    
    public void calcularInteresMensual() {
        float interesMensual = (saldo * tasaAnual) / 12;
        saldo += interesMensual;
    }

    
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

 
    public String imprimir() {
        return String.format("ID: %d, Saldo: %.2f, Comisión mensual: %.2f, Transacciones realizadas: %d",
                id, saldo, comisionMensual, numConsignaciones + numRetiros);
    }
}