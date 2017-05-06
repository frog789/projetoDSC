package com.farmacontrol.usuario;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="sequencia_cartao",sequenceName="sq_cartao",initialValue=1,allocationSize=5)
@Table(name="tb_cartao")
@Access(AccessType.FIELD)
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;
	
	@Column(name="num_cartao", nullable = false, unique = true)
	private String numero;
	
	@Column(name="bandeira_cartao", nullable = false)
	private String bandeira;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	
}
