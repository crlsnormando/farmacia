package br.com.farmacia.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity  // informa que essa clase é uma tablea no banco de dados
@Table(name="medicamento")  // informa o nome da tabela NÃO É OBRIGATORIA
public class Medicamento implements Serializable , Base{

	private static final long serialVersionUID = 1L;

	@Id // informa que é a chave primaria
	@GeneratedValue   // é o auto incremento dfo sql
	@Column(name = "codigo")  //para defini o nome da coluna , caso queira
	private Long id;
	private String nome;
	private String  apresentacao;
	private String laboratorio;
	private String resgitro;
	private BigDecimal preco;
	
	
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
	public String getApresentacao() {
		return apresentacao;
	}
	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getResgitro() {
		return resgitro;
	}
	public void setResgitro(String resgitro) {
		this.resgitro = resgitro;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
