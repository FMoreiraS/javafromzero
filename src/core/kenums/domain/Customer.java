package core.kenums.domain;

public class Customer {

    private String name;
    // Sem Enum: muitos valores para definir um campo
    private static final String STATE_SP = "São Paulo";
    private static final String STATE_RJ = "Rio de Janeiro";
    private String fedUnit;
    // Com Enum: uma só classe define o campo.
    private StatesOfBrazil stateOfResidence;
    // Enum interno para testes, exige a criação do atributo
    public enum PaymentType {
        DEBT, CREDIT
    }
    private PaymentType paymentType;
    
    // Construtor restritivo
    public Customer(String name, String fedUnit) {
        if(
            !fedUnit.equals(STATE_RJ) &&
            !fedUnit.equals(STATE_SP)
            // Imagina colocar todos os estados brasileiros aqui
        ) {
            return; // Ou seja, objeto não é criado.
        }
        this.name = name;
        this.fedUnit = fedUnit;
    }

    // Construtor para usar enum externo
    public Customer(String name, StatesOfBrazil state) {
        this.name = name;
        this.stateOfResidence = state;
    }

    // Construtor para usar enum interno
    public Customer(String name, PaymentType paymentType) {
        this.name = name;
        this.paymentType = paymentType;
    }

    @Override
    public String toString(){
        return "Customer [name=" + name + ", stateOfResidence="
            + stateOfResidence + ", paymentType=" + paymentType + "]";
    }

    public String getInfo() {
        return "Customer [name=" + name + ", stateOfResidence="
        + stateOfResidence.FORMATTED_NAME + ", paymentType=" + paymentType + "]";
    }

    // public String toString() {
    //     return "Customer [name=" + name + ", stateOfResidence="
    //             + stateOfResidence + ", paymentType=" + paymentType + "]";
    // }

    public String getName() {
        return this.name;
    }
}
