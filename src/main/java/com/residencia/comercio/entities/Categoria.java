package com.residencia.comercio.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "categoria")
@JsonIdentityInfo(
	generator = ObjectIdGenerators.PropertyGenerator.class, 
	property = "idCategoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer idCategoria;

	@Column(name = "nome_categoria")
	@NotBlank(message = "O nome da categoria não pode ficar em branco.")
	private String nomeCategoria;

	@Column(name = "imagem")
	private String nomeImagem;

	@OneToMany(mappedBy = "categoria")
	@JsonManagedReference
	private List<Produto> produtoList;

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

}