package no.nav.demo.storage;

public class AuthorDTO {

    private String fornavn;
    private String etternavn;

    protected AuthorDTO(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

}
