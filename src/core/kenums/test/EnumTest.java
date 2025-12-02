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
        
        System.out.println("Teste do enum interno");
        Customer customer3 = new Customer("Cinthia", PaymentType.CREDIT);
        Customer customer4 = new Customer("Magda", PaymentType.DEBT);
        System.out.println(customer3);
        System.out.println(customer4);

        System.out.println("Teste do atributo tipo String NAME");
        Customer customer5 = new Customer("Alexander", StatesOfBrazil.SAO_PAULO);
        System.out.println(customer5.getInfo());

        System.out.println("Teste de valueOf");
        // Só consegue retornar um valor da enumeração se receber o
        // nome real, não o formatado.
        StatesOfBrazil stateSP = StatesOfBrazil.valueOf("SAO_PAULO");
        System.out.println(stateSP.FORMATTED_NAME);
        System.out.println("Teste da busca por atributo");
    }
}