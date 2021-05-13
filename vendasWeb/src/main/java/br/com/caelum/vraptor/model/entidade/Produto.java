package br.com.caelum.vraptor.model.entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.vraptor.model.enuns.Status;
import br.com.caelum.vraptor.model.enuns.TipoCarga;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(unique = true, length = 120, nullable = false)
	@NotEmpty(message = "Nome deve ser informado")
	@Length(max = 120, message = "Nome aceita apenas 120 caracteres")
	private String nome;

	@Column(nullable = false)
	@NotNull(message = "Volume inválido")
	private Integer volume;

	@Column(nullable = false)
	@NotNull(message = "Atacado inválido")
	private Integer atacado;

	@Column(nullable = false)
	@NotNull(message = "Margem inválida")
	private Double margem;

	@OneToOne(cascade = CascadeType.ALL)
	private Estoque estoque;

	@OneToOne(cascade = CascadeType.ALL)
	private TabelaValores tabelaValores;

	@ManyToOne
	private Categoria categoria;

	@Enumerated(EnumType.STRING)
	private TipoCarga tipoCarga;

	@Enumerated(EnumType.STRING)
	private Status status;

	public Produto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getAtacado() {
		return atacado;
	}

	public void setAtacado(Integer atacado) {
		this.atacado = atacado;
	}

	public Double getMargem() {
		return margem;
	}

	public void setMargem(Double margem) {
		this.margem = margem;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public TipoCarga getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(TipoCarga tipoCarga) {
		this.tipoCarga = tipoCarga;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

}
