package com.farmacontrol.usuario;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="sequencia_usuario",sequenceName="sq_usuario",initialValue=1,allocationSize=5)
@Table(name="tb_usuario")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_usuario",
					 discriminatorType=DiscriminatorType.STRING,
					 length=1)
@Access(AccessType.FIELD)
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private long id;

    @Column(name="nome_usuario")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_usuario")
    private TipoUsuario Tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public TipoUsuario getTipo() {
        return Tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        Tipo = tipo;
    }

    public long getId(){
    	return id;
    }

}
