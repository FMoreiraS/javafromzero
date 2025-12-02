package core.kenums.domain;

public enum StatesOfBrazil {

    PARA ("Pará", "PA"),
    SAO_PAULO("São Paulo", "SP"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ"),
    ESPIRITO_SANTO("Espírito Santo", "ES");

    public final String FORMATTED_NAME;
    public final String ABBREVIATION;

    private StatesOfBrazil(String name, String abbreviation) {
        this.FORMATTED_NAME = name;
        this.ABBREVIATION = abbreviation;
    }

    public static StatesOfBrazil getStateFromFormattedName(String formattedName) {
        for(StatesOfBrazil state : values()) {
            if(state.FORMATTED_NAME.equals(formattedName)) {
                return state;
            }
        }
        return null;
    }

}