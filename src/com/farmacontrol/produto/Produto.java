package com.farmacontrol.produto;
import com.farmacontrol.produto.Lote;
import com.farmacontrol.produto.Fornecedor;
import java.util.List;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="sequencia_lote",sequenceName="sq_lote",initialValue=1,allocationSize=5)
@Table(name="tb_lote")
@Access(AccessType.FIELD)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;

    @Column(name="classificacao_produto")
    private String classificacao;
    
    @Column(name="preco_produto")
	private float preco;
	
	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	@OneToMany(fetch=FetchType.LAZY,
			cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="id_lote", referencedColumnName="id")
	private List<Lote> lotes;
	
	@OneToMany(fetch=FetchType.LAZY,
			cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="id_fornecedor", referencedColumnName="id")
	private List<Fornecedor> fornecedores;

}
