package com.farmacontrol.venda;
import javax.persistence.*;
import com.farmacontrol.produto.*;
import com.farmacontrol.usuario.*;
import java.util.List;

@Entity
@SequenceGenerator(name="sequencia_venda",sequenceName="sq_venda",initialValue=1,allocationSize=5)
@Table(name="tb_venda")
@Access(AccessType.FIELD)
public class Venda {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;
	
	@ManyToMany
	@JoinTable(name="venda_produtos",
	      joinColumns=@JoinColumn(name="venda_id", referencedColumnName="id"),
	      inverseJoinColumns=@JoinColumn(name="produto_id", referencedColumnName="id"))
	private List<Produto> produtos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="funcionario_id")
	private Funcionario funcionario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cliente_id")	
	private Cliente cliente;

	public long getId() {
		return id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
