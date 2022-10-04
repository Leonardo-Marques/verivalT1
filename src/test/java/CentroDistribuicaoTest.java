import org.example.CentroDistribuicao;
import org.junit.jupiter.api.*;
public class CentroDistribuicaoTest {
    private CentroDistribuicao centroDistribuicao = null;

    @BeforeEach
    void setUp() {
        centroDistribuicao = new CentroDistribuicao(500,10000,2500);
    }

    @Test
    public void tst(){
        Assertions.assertEquals(500,centroDistribuicao.getAditivo());
    }
}
