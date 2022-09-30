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
        if (tAlcool < MAX_ALCOOL * 0.25 ||
            tGasolina < MAX_GASOLINA * 0.25 ||
            tAditivo < MAX_ADITIVO * 0.25)
            this.situacao = SITUACAO.EMERGENCIA;
        else if (tAlcool < MAX_ALCOOL * 0.5 ||
                tGasolina < MAX_GASOLINA * 0.5 ||
                tAditivo < MAX_ADITIVO * 0.5)
            this.situacao = SITUACAO.SOBRAVISO;
        else
            this.situacao = SITUACAO.NORMAL;
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
        if (qtdade <= 0) return -1;
        int canReceive = qtdade + tAditivo > MAX_ADITIVO ? MAX_ADITIVO - tAditivo : qtdade;
        tAditivo += canReceive;
        defineSituacao();
        return canReceive;
    }

    public int recebeGasolina(int qtdade) {
        if (qtdade <= 0) return -1;
        int canReceive = qtdade + tGasolina > MAX_GASOLINA ? MAX_GASOLINA - tGasolina : qtdade;
        tGasolina += canReceive;
        defineSituacao();
        return canReceive;
    }

    public int recebeAlcool(int qtdade) {
        if (qtdade <= 0) return -1;
        int canReceive = qtdade + tAlcool > MAX_ALCOOL ? MAX_ALCOOL - tAlcool : qtdade;
        tAlcool += canReceive;
        defineSituacao();
        return canReceive;
    }

    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
        if (qtdade <= 0)
            return new int[]{-7};
        if (situacao == SITUACAO.EMERGENCIA && tipoPosto != TIPOPOSTO.ESTRATEGICO)
            return new int[]{-14};

        if (situacao == SITUACAO.EMERGENCIA || (situacao == SITUACAO.SOBRAVISO && tipoPosto == TIPOPOSTO.COMUM)) {
            qtdade /= 2;
        }

        int aditivoAfter = tAditivo - (int)(qtdade * 0.05);
        int alcoolAfter = tAlcool - (int)(qtdade * 0.25);
        int gasolinaAfter = tGasolina - (int)(qtdade * 0.7);

        if (aditivoAfter < 0 || alcoolAfter < 0 || gasolinaAfter < 0)
            return new int[]{-21};

        tAditivo = aditivoAfter;
        tAlcool = alcoolAfter;
        tGasolina = gasolinaAfter;
        defineSituacao();

        return new int[]{tAditivo, tGasolina, tAlcool};
    }
}
