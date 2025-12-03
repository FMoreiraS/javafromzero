package core.kenums.test;

import core.kenums.domain.Customer;
import core.kenums.domain.StatesOfBrazil;
import core.kenums.domain.Customer.PaymentType;

public class EnumTest {

    public static void main(String[] args) {
        System.out.println("Teste do enum externo");
        Customer customer1 = new Customer("Francis", StatesOfBrazil.RIO_DE_JANEIRO);
        Customer customer2 = new Customer("Gregorius", StatesOfBrazil.SAO_PAULO);
        System.out.println(customer1);
        System.out.println(customer2);
        
        System.out.println("\nTeste do enum interno");
        Customer customer3 = new Customer("Cinthia", PaymentType.CREDIT);
        Customer customer4 = new Customer("Magda", PaymentType.DEBT);
        System.out.println(customer3);
        System.out.println(customer4);

        System.out.println("\nTeste do atributo tipo String NAME");
        Customer customer5 = new Customer("Alexander", StatesOfBrazil.SAO_PAULO);
        System.out.println(customer5.getInfo());

        System.out.println("\nTeste do valueOf() com valor da enumeração");
        // Só consegue retornar um valor da enumeração se receber o
        // nome real, não um atributo, como o nome formatado.
        StatesOfBrazil stateSP = StatesOfBrazil.valueOf("SAO_PAULO");
        System.out.println(stateSP.FORMATTED_NAME);
        System.out.println("\nTeste da busca por atributo");
        StatesOfBrazil statePA = StatesOfBrazil.getStateFromFormattedName("Pará");
        System.out.println(
            "Usando o atributo \"Pará\"(FORMATTED_NAME) conseguimos outro (ABBREVIATION): " +
            statePA.ABBREVIATION
        );
    }
}