package core.npolimorphism.test;

import core.npolimorphism.domain.Computer;
import core.npolimorphism.domain.Desktop;
import core.npolimorphism.domain.Laptop;

public class ComputerTest {
    public static void main(String[] args) {
        // TESTANDO POLIMORFISMO
        // 1. Widening cast
        Computer desktop = new Desktop("PC9710", "01/2029");
        Computer laptop = new Desktop("LP8906", "02/2029");
        // Usando o cast no laptop, é impossível acessar "openLid()".
        // Resolvemos criando um objeto com o tipo específico
        Laptop koreatop = new Laptop("KoreaTop30+", "01/2028");
        koreatop.openLid();

        // Usar Computer nas variáveis de referência permite isto:
        Computer.showInfo(desktop);
        Computer.showInfo(laptop);
        
    }
}
