package com.farmacontrol.usuario;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tb_cliente")
@DiscriminatorValue(value="C")
@PrimaryKeyJoinColumn(name="id_usuario", referencedColumnName="id")
public class Cliente extends Usuario {
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="tb_endereco", referencedColumnName="id")
	private Endereco endereco;
	
	@Column(name="cliente_email")
	private String email;
	
	@OneToMany(fetch=FetchType.LAZY,
			cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="id_cartao", referencedColumnName="id")
	private List<Cartao> cartoes;

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Cartao> getCartoes() {
		return cartoes;
	}
	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}
	
}
