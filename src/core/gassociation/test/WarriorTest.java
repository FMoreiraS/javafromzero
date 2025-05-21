package core.gassociation.test;

import core.gassociation.domain.Army;
import core.gassociation.domain.Warrior;

public class WarriorTest {
    public static void main(String[] args) {
        Warrior knight = new Warrior("Cavaleiro Alexander");
        Warrior archer = new Warrior("Arqueiro Fabricius");
        Army romanus = new Army("Exercitus Romanus");

        // Mútua associação:
        knight.setArmy(romanus);
        archer.setArmy(romanus);

        romanus.setWarriors(knight, archer);

        System.out.println("====== Guerreiros ======");
        knight.print();
        archer.print();

        System.out.println("====== Exército ======");
        romanus.print();
    }
}
