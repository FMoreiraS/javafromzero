package core.hinheritanceioverride.domain;

public class Address {
    private String street;
    private String cep;

    public Address(String street, String cep) {
        this.street = street;
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}