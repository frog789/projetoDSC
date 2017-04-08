package com.farmacontrol.produto;
import com.farmacontrol.produto.Lote;
import java.util.List;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="sequencia_fornecedor",sequenceName="sq_fornecedor",initialValue=1,allocationSize=5)
@Table(name="tb_fornecedor")
@Access(AccessType.FIELD)
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;

	@OneToMany(fetch=FetchType.LAZY,
			cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="id_lote", referencedColumnName="id")
	private List<Lote> lotes;

	@Column(name="nome_fornecedor")
	private String nome;
	
	@Column(name="telefone_fornecedor")
	private String telefone;

}
