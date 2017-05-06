package com.farmacontrol.usuario;
import javax.persistence.*;

@Entity
@Table(name="tb_funcionario")
@DiscriminatorValue(value="F")
@PrimaryKeyJoinColumn(name="id_usuario", referencedColumnName="id")
public class Funcionario extends Usuario{
	
	public Funcionario(){
	}
	
	
	@Column(name="func_funcao")
	private String funcao;

	@Column(name="func_matricula", unique = true)
	private long matricula;

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
	
	
}
