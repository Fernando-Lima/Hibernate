package br.edu.unoesc.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "nome")
// comando para comparar ex: dois alunos pelo nome
@ToString(of = { "codigo", "nome" })
// comparando pessoas pelo codigo e pelo nome
// @Table (name = "CAD_ALUNO")
public class Aluno implements MinhaEntidade {

	@Id // cria a chave primaria no banco
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id campo auto
														// incremento
	// @Column (name = "CD_aluno")
	private Long codigo;
	// @Column (name = "NM_ALUNO", nullable= false, length=60, unique=true)
	@Column(nullable = false, length = 60)
	private String nome;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP) // timestamp data e hora
	private Date data;
	@ManyToOne
	private Cidade cidade;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}