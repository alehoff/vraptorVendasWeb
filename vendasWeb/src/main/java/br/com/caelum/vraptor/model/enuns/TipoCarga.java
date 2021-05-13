package br.com.caelum.vraptor.model.enuns;

public enum TipoCarga {

    CERVEJA("Cerveja"),
    KS("Ks"),
    LATA("Lata"),
    LITRO_CANA("Litro Cana"),
    GARRAFAO("Garrafão"),
    LONG_NECK("Long Neck"),
    PET("Pet");

    private final String tipoCarga;

    private TipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

}
