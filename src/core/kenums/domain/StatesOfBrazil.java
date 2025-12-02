package core.kenums.domain;

public enum StatesOfBrazil {

    PARA ("Pará"),
    SAO_PAULO("São Paulo"),
    RIO_DE_JANEIRO("Rio de Janeiro"),
    ESPIRITO_SANTO("Espírito Santo");

    public final String NAME;

    private StatesOfBrazil(String name) {
        this.NAME = name;
    }

}