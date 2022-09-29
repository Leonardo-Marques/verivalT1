package org.example;

public class CentroDistribuicao {
    public enum SITUACAO {
        NORMAL,
        SOBRAVISO,
        EMERGENCIA
    }
    public enum TIPOPOSTO {
        COMUM,
        ESTRATEGICO
    }
    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    private int tAditivo;
    private int tGasolina;
    private int tAlcool;
    private SITUACAO situacao;

    public CentroDistribuicao(int tAditivo, int tGasolina, int tAlcool) {
        if (tAditivo > MAX_ADITIVO || tAditivo < 0 ||
            tGasolina > MAX_GASOLINA || tGasolina < 0 ||
            tAlcool > MAX_ADITIVO || tAlcool < 0)
            throw new IllegalArgumentException();

        this.tAditivo = tAditivo;
        this.tGasolina = tGasolina;
        this. tAlcool = tAlcool;
        defineSituacao();
    }

    public void defineSituacao() {

    }

    public SITUACAO getSituacao() {
        return this.situacao;
    }

    public int getGasolina() {
        return this.tGasolina;
    }

    public int getAditivo() {
        return this.tAditivo;
    }

    public int getAlcool() {
        return this.tAlcool;
    }

    public int recebeAditivo(int qtdade) {
        return -1;
    }

    public int recebeGasolina(int qtdade) {
        return -1;
    }

    public int recebeAlcool(int qtdade) {
        return -1;
    }

    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
        if (qtdade <= 0)
            return new int[]{-7};
        if (situacao == SITUACAO.EMERGENCIA && tipoPosto != TIPOPOSTO.ESTRATEGICO)
            return new int[]{-14};
        
        return null;
    }
}