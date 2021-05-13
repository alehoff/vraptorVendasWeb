package br.com.caelum.vraptor.model.entidade;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: TabelaValores
 *
 */
@Entity

public class TabelaValores implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@NotNull(message = "Valor Venda deve ser informado")
	@Column(nullable = false)
	private BigDecimal valorVenda;

	@SuppressWarnings("unused")
	private BigDecimal valorCusto;

	@OneToOne(mappedBy = "tabelaValores")
	private Produto produto;

	private static final long serialVersionUID = 1L;

	public TabelaValores() {
		super();
	}

}
