package br.com.caelum.vraptor.util;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class PaginacaoUtil {

	public PaginacaoUtil() {
	}

	/**
	 * Total de linhas apresentada em cada página
	 * 
	 * @return
	 */
	public int getTotalRegistrosPorPagina() {
		return 3;
	}

	/**
	 * Retorna número do indice utilizado no banco de dados para fazer a consulta
	 * 
	 * @param indice
	 * @return
	 */
	public int getIndiceBancoDados(int indice) {
		indice -= 1;
		if (indice == 0) {
			return 0;
		}
		return indice * getTotalRegistrosPorPagina();
	}

	/**
	 * Retorna a quantidade de paginas a ser apresentada ao usuario
	 * 
	 * @param totalRegistros
	 * @return
	 */
	public int getMaxPage(long totalRegistros) {

		if (totalRegistros < getTotalRegistrosPorPagina()) {
			return 1;
		}

		int indice = (int) totalRegistros / getTotalRegistrosPorPagina();

		if (totalRegistros % getTotalRegistrosPorPagina() > 0) {
			indice++;
		}
		return indice;
	}
}
