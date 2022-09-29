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

    public CentroDistribuicao(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {

    }

    public void defineSituacao() {

    }

    public SITUACAO getSituacao() {
        return null;
    }

    public int getGasolina() {
        return -1;
    }

    public int getAditivo() {
        return -1;
    }

    public int getAlcool1() {
        return -1;
    }

    public int getAlcool2() {
        return -1;
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
        return null;
    }
}