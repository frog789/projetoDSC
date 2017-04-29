package com.farmacontrol.usuario;
import javax.persistence.*;

@Entity
@Table(name="tb_funcionario")
@DiscriminatorValue(value="F")
@PrimaryKeyJoinColumn(name="id_usuario", referencedColumnName="id")
public class Funcionario extends Usuario{
	
	@Column(name="func_funcao")
	private String funcao;

	@Column(name="func_matricula")
	private long matricula;
}
