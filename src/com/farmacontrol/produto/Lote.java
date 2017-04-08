package com.farmacontrol.produto;
import javax.persistence.*;



@Entity
@SequenceGenerator(name="sequencia_lote",sequenceName="sq_lote",initialValue=1,allocationSize=5)
@Table(name="tb_lote")
@Access(AccessType.FIELD)
public class Lote {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;

    @Column(name="numero_lote")
	private long numero;
    
	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}


	
}
