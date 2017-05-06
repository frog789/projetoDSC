package com.farmacontrol;

import com.farmacontrol.usuario.Cliente;
import com.farmacontrol.usuario.Endereco;
import com.farmacontrol.usuario.Funcionario;
import com.farmacontrol.usuario.TipoUsuario;

public class FuncionarioManager extends ManagerBase {

	
	public void criaFuncionario(String nome, String email, String funcao, Long matricula) {	
		Funcionario func = new Funcionario();
		func.setNome(nome);
		func.setTipo(TipoUsuario.F);
		func.setFuncao(funcao);
		func.setMatricula(matricula);
		
		this.beginTransaction();
		this.em.persist(func);
		this.et.commit();
		this.endTransaction();
		}
	
	public Funcionario recuperarFuncionario(long matricula){
		this.beginTransaction();
		Funcionario func = this.em.find(Funcionario.class, matricula);
		this.endTransaction();
		return func;
	}
	
	public void atualizarFuncionario(String nome, String funcao, long matricula){
		
		Funcionario func = this.recuperarFuncionario(matricula);
		this.beginTransaction();
		func.setNome(nome);
		func.setFuncao(funcao);
		this.em.merge(func);
		this.et.commit();
		this.endTransaction();
	}
	public void removerFuncionario(long matricula){
		Funcionario func = this.recuperarFuncionario(matricula);
		this.beginTransaction();
		func = this.em.merge(func);
		this.em.remove(func);
		this.et.commit();
		this.endTransaction();
	}

}
