import org.example.CentroDistribuicao;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CentroDistribuicaoTest {
    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    //Testes de encomenda combustivel

    @Test
    public void S1P1() {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(MAX_ADITIVO/2,MAX_GASOLINA/2,MAX_ALCOOL/2);
        int pedido = 100;
        String result = Arrays.toString(centroDistribuicao1.encomendaCombustivel(pedido, CentroDistribuicao.TIPOPOSTO.COMUM));

        String adt = String.valueOf((int)(MAX_ADITIVO/2) - (int)(0.05*pedido));
        String gas = String.valueOf((int)(MAX_GASOLINA/2) - (int)(0.7*pedido));
        String alc = String.valueOf((int)(MAX_ALCOOL/2) - (int)(0.25*pedido));

        String resultE = "["+adt+", "+gas+", "+alc+"]";

        Assertions.assertEquals(result,resultE);
    }
    @Test
    public void S1P2() {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(CentroDistribuicao.MAX_ADITIVO/2,CentroDistribuicao.MAX_GASOLINA/2,CentroDistribuicao.MAX_ALCOOL/2);
        int pedido = 100;
        String result = Arrays.toString(centroDistribuicao1.encomendaCombustivel(100, CentroDistribuicao.TIPOPOSTO.ESTRATEGICO));
        String adt = String.valueOf((int)(MAX_ADITIVO/2) - (int)(0.05*pedido));
        String gas = String.valueOf((int)(MAX_GASOLINA/2) - (int)(0.7*pedido));
        String alc = String.valueOf((int)(MAX_ALCOOL/2) - (int)(0.25*pedido));

        String resultE = "["+adt+", "+gas+", "+alc+"]";

        Assertions.assertEquals(result,resultE);
    }

    @ParameterizedTest
    @CsvSource({
            "125,10000,2500,COMUM",
            "500,2500,2500,COMUM",
            "500,10000,625,COMUM",
    })
    public void S2P1(int qtAditivo, int qtGasolina, int qtAlcool, CentroDistribuicao.TIPOPOSTO st) {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(qtAditivo,qtGasolina,qtAlcool);

        int pedido = 100;
        String result = Arrays.toString(centroDistribuicao1.encomendaCombustivel(pedido, st));
        String adt = String.valueOf((int)(qtAditivo) - (int)(0.05*(pedido/2)));
        String gas = String.valueOf((int)(qtGasolina) - (int)(0.7*(pedido/2)));
        String alc = String.valueOf((int)(qtAlcool) - (int)(0.25*(pedido/2)));

        String resultE = "["+adt+", "+gas+", "+alc+"]";

        Assertions.assertEquals(result,resultE);

    }
    @ParameterizedTest
    @CsvSource({
            "125,10000,2500,ESTRATEGICO",
            "500,2500,2500,ESTRATEGICO",
            "500,10000,625,ESTRATEGICO",
    })
    public void S2P2(int qtAditivo, int qtGasolina, int qtAlcool, CentroDistribuicao.TIPOPOSTO st) {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(qtAditivo,qtGasolina,qtAlcool);

        int pedido = 100;
        String result = Arrays.toString(centroDistribuicao1.encomendaCombustivel(pedido,st));
        String adt = String.valueOf((int)(qtAditivo) - (int)(0.05*pedido));
        String gas = String.valueOf((int)(qtGasolina) - (int)(0.7*pedido));
        String alc = String.valueOf((int)(qtAlcool) - (int)(0.25*pedido));

        String resultE = "["+adt+", "+gas+", "+alc+"]";

        Assertions.assertEquals(result,resultE);
    }

    @ParameterizedTest
    @CsvSource({
            "5,10000,2500,COMUM",
            "500,100,2500,COMUM",
            "500,10000,25,COMUM",
    })
    public void S3P1(int qtAditivo, int qtGasolina, int qtAlcool, CentroDistribuicao.TIPOPOSTO st) {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(qtAditivo,qtGasolina,qtAlcool);
        int pedido = 100;
        String result = Arrays.toString(centroDistribuicao1.encomendaCombustivel(pedido, st));
        String resultE = "[-14]";
        Assertions.assertEquals(result,resultE);
    }

    @ParameterizedTest
    @CsvSource({
            "5,10000,2500,ESTRATEGICO",
            "500,100,2500,ESTRATEGICO",
            "500,10000,25,ESTRATEGICO",
    })
    public void S3P2(int qtAditivo, int qtGasolina, int qtAlcool, CentroDistribuicao.TIPOPOSTO st) {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(qtAditivo,qtGasolina,qtAlcool);

        int pedido = 100;
        String result = Arrays.toString(centroDistribuicao1.encomendaCombustivel(pedido, st));
        String adt = String.valueOf((int)(qtAditivo) - (int)(0.05*(pedido/2)));
        String gas = String.valueOf((int)(qtGasolina) - (int)(0.7*(pedido/2)));
        String alc = String.valueOf((int)(qtAlcool) - (int)(0.25*(pedido/2)));

        String resultE = "["+adt+", "+gas+", "+alc+"]";

        Assertions.assertEquals(result,resultE);
    }

    @ParameterizedTest
    @CsvSource({
            "0,10000,2500,COMUM",
            "500,0,2500,COMUM",
            "500,10000,0,COMUM",
    })
    public void S4P1(int qtAditivo, int qtGasolina, int qtAlcool, CentroDistribuicao.TIPOPOSTO st) {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(qtAditivo,qtGasolina,qtAlcool);
        int pedido = 100;
        String result = Arrays.toString(centroDistribuicao1.encomendaCombustivel(pedido, st));

        String resultE = "[-21]";

        Assertions.assertEquals(result,resultE);
    }


    @ParameterizedTest
    @CsvSource({
            "0,10000,2500,ESTRATEGICO",
            "500,0,2500,ESTRATEGICO",
            "500,10000,0,ESTRATEGICO",
    })
    public void S4P2(int qtAditivo, int qtGasolina, int qtAlcool, CentroDistribuicao.TIPOPOSTO st) {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(qtAditivo,qtGasolina,qtAlcool);
        int pedido = 100;
        String result = Arrays.toString(centroDistribuicao1.encomendaCombustivel(pedido, st));

        String resultE = "[-21]";

        Assertions.assertEquals(result,resultE);
    }

    @Test
    public void S1P1E1() {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(MAX_ADITIVO,MAX_GASOLINA,MAX_ALCOOL);
        int pedido = -1;
        String result = Arrays.toString(centroDistribuicao1.encomendaCombustivel(pedido, CentroDistribuicao.TIPOPOSTO.COMUM));
        String resultE = "[-7]";
        Assertions.assertEquals(result,resultE);
    }

    //Testes de Recebe combustivel/aditivo/alcool

    @ParameterizedTest
    @CsvSource({
            "9999,10,1",
            "9900,50,50 ",
            "9900,-1,-1",
            "10000,10,0",
    })
    public void recebeComb(int qntGas, int qntPosta, int resultE) {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(MAX_ADITIVO,qntGas,MAX_ALCOOL);
        int result = centroDistribuicao1.recebeGasolina(qntPosta);
        Assertions.assertEquals(result,resultE);
    }

    @ParameterizedTest
    @CsvSource({
            "499,10,1",
            "400,50,50 ",
            "400,-1,-1",
            "500,10,0",
    })
    public void recebeAdt(int qntAdt, int qntPosta, int resultE) {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(qntAdt,MAX_GASOLINA,MAX_ALCOOL);
        int result = centroDistribuicao1.recebeAditivo(qntPosta);
        Assertions.assertEquals(result,resultE);
    }

    @ParameterizedTest
    @CsvSource({
            "2499,10,1",
            "2400,50,50 ",
            "2400,-1,-1",
            "2500,10,0",
    })
    public void recebeAlc(int qntAlc, int qntPosta, int resultE) {
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(MAX_ADITIVO,MAX_GASOLINA,qntAlc);
        int result = centroDistribuicao1.recebeAlcool(qntPosta);
        Assertions.assertEquals(result,resultE);
    }


    //Testes do contrutor

    @Test
    public void contrutorOK(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(MAX_ADITIVO,MAX_GASOLINA,MAX_ALCOOL);
        Assertions.assertEquals(500,centroDistribuicao1.getAditivo());
    }
    @Test
    public void contrutorErro(){
        assertThrows(IllegalArgumentException.class,
                ()->{
                    CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(600,MAX_GASOLINA,MAX_ALCOOL);
                });

    }

    //Testes Gets
//    public CentroDistribuicao.SITUACAO getSituacao() {
//        return this.situacao;
//    }
//
//    public int getGasolina() {
//
//
//    public int getAditivo() {
//
//    public int getAlcool() {

    @Test
    public void getSituacaoTest(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(MAX_ADITIVO,MAX_GASOLINA,MAX_ALCOOL);
        Assertions.assertEquals(CentroDistribuicao.SITUACAO.NORMAL,centroDistribuicao1.getSituacao());
    }

    @Test
    public void getGasolinaTest(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(MAX_ADITIVO,MAX_GASOLINA,MAX_ALCOOL);
        Assertions.assertEquals(MAX_GASOLINA,centroDistribuicao1.getGasolina());
    }
    @Test
    public void getAlcoolTest(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(MAX_ADITIVO,MAX_GASOLINA,MAX_ALCOOL);
        Assertions.assertEquals(MAX_ALCOOL,centroDistribuicao1.getAlcool());
    }
    @Test
    public void getAditivoTest(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(MAX_ADITIVO,MAX_GASOLINA,MAX_ALCOOL);
        Assertions.assertEquals(MAX_ADITIVO,centroDistribuicao1.getAditivo());
    }





}

















