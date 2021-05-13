package br.com.caelum.vraptor.model.dataTable;

public class ProdutoDat {

    private final Long id;
    private final String nomeProduto;
    private final String nomeFamilia;
    private final Integer volume;
    private final Boolean ativo;
    private final Double margem;
    private final Integer atacado;

    public ProdutoDat(Long id, String nomeProduto, String nomeFamilia, Integer volume, Boolean ativo, Double margem,
            Integer atacado) {
        super();
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.nomeFamilia = nomeFamilia;
        this.volume = volume;
        this.ativo = ativo;
        this.margem = margem;
        this.atacado = atacado;
    }

    public Long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getNomeFamilia() {
        return nomeFamilia;
    }

    public Integer getVolume() {
        return volume;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Double getMargem() {
        return margem;
    }

    public Integer getAtacado() {
        return atacado;
    }

}
