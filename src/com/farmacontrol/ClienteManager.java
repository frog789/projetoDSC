package com.farmacontrol;
import com.farmacontrol.usuario.Cliente;
import com.farmacontrol.usuario.Endereco;
import com.farmacontrol.usuario.TipoUsuario;
import java.util.List;
import javax.persistence.*;


public class ClienteManager extends ManagerBase{

	public Endereco criarEndereco(Cliente cliente,String logradouro,int numero,String complemento,String bairro,String cidade,String estado){
		Endereco endereco = new Endereco(cliente,logradouro,numero,complemento,bairro,cidade,estado);
		return endereco;
	}

	public void criarCliente(String nome,String email,String logradouro,int numero,String complemento,String bairro,String cidade,String estado){
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setTipo(TipoUsuario.C);
		Endereco endereco = this.criarEndereco(cliente,logradouro,numero,complemento,bairro,cidade,estado);
		cliente.setEndereco(endereco);
			this.beginTransaction();
			this.em.persist(cliente);
			this.em.persist(endereco);
			this.et.commit();
			this.endTransaction();
			}

	public Cliente recuperarCliente(long id){
		this.beginTransaction();
		Cliente cliente = this.em.find(Cliente.class, id);
		this.endTransaction();
		return cliente;
	}

	public void atualizarCliente(String nome, String email, long id){
		
		Cliente cliente = this.recuperarCliente(id);
		this.beginTransaction();
		cliente.setNome(nome);
		cliente.setEmail(email);
		this.em.merge(cliente);
		this.et.commit();
		this.endTransaction();
	}
	public void removerCliente(long id){
		Cliente cliente = this.recuperarCliente(id);
		this.beginTransaction();
		cliente = this.em.merge(cliente);
		this.em.remove(cliente);
		this.et.commit();
		this.endTransaction();
	}
	
	public List<Cliente> todosOsClientes(){
		this.beginTransaction();
		TypedQuery<Cliente> query = this.em.createQuery("SELECT c FROM Cliente c", Cliente.class);
		List<Cliente> clients_list = query.getResultList();
		this.endTransaction();
		return clients_list;
	}

}
