package com.farmacontrol.usuario;
import com.farmacontrol.usuario.Cliente;
import javax.persistence.*;


@Entity
@SequenceGenerator(name="sequencia_endereco",sequenceName="sq_endereco",initialValue=1,allocationSize=5)
@Table(name="tb_endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@OneToOne(mappedBy="endereco")
	private Cliente cliente;
	
	@Column(name="end_logradouro")
	private String logradouro;
	
	@Column(name="end_numero")
	private int numero;
	
	@Column(name="end_complemento")
	private String complemento;
	
	@Column(name="end_bairro")
	private String bairro;
	
	@Column(name="end_cidade")
	private String cidade;
	
	@Size(min = 2, max = 2)
	@Column(name="end_estado")
	private String estado;
	
	public Endereco(){}
	
	public Endereco(Cliente cliente,String logradouro,int numero,String complemento,String bairro,String cidade,String estado){
		this.cliente = cliente;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
}
