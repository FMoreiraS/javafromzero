package core.npolimorphism.test;

import core.npolimorphism.domain.Computer;
import core.npolimorphism.domain.Desktop;
import core.npolimorphism.domain.Laptop;

public class ComputerTest {
    public static void main(String[] args) {
        // TESTANDO POLIMORFISMO
        // 1. Widening cast
        Computer desktop = new Desktop("PC9710", "01/2029");
        Computer laptop = new Laptop("LP8906", "02/2029");
        // Assim podemos acessar o método de Computer que recebe objetos
        // Computer como parâmetro:
        Computer.showInfo(desktop);
        // Num IDE, observe-se na depuração o funcionamento de "instanceof",
        // colocando um breakpoint na linha 18.
        Computer.showInfo(laptop);
        
        // Tendo usado o cast num laptop, é impossível acessar "openLid()".
        // laptop.openLid();
        // É compulsório criar um objeto com o tipo específico:
        Laptop koreatop = new Laptop("KoreaTop30+", "01/2028");
        koreatop.openLid();
    }
}
