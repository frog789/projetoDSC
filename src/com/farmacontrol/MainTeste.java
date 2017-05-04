package com.farmacontrol;

import java.util.List;

import com.farmacontrol.usuario.Cliente;

public class MainTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteManager climanager = new ClienteManager();
		climanager.criarCliente("Um Cliente", "exemplo@exemplo.com", "Rua A", 111, "Compl. B", "Bairro C", "Cidade D", "Estado E");
		climanager.criarCliente("Outro Cliente", "aaa@bbb.com", "Rua Z", 222, "Compl. Y", "Bairro X", "Cidade W", "Estado V");
		climanager.criarCliente("Terceiro Cliente", "asdo@qwe.com", "Rua M", 555, "Compl. N", "Bairro O", "Cidade P", "Estado Q");
		List<Cliente> lista_clientes = climanager.todosOsClientes();
		System.out.println("Teste query todos os clientes");
		for (int i=0; i<lista_clientes.size(); i++){
			System.out.println(lista_clientes.get(i).getNome() + " - " + lista_clientes.get(i).getEmail());
		}
		Cliente exemplo = lista_clientes.get(0);
		long id = exemplo.getId();
		Cliente recuperado = climanager.recuperarCliente(id);
		System.out.println("Teste recuperar Cliente");
		System.out.println("Email Recuperado:"+recuperado.getEmail() + " - Email Exemplo:" + exemplo.getEmail());
		climanager.atualizarCliente("Novo Nome", "novo@email.com", id);
		lista_clientes = climanager.todosOsClientes();
		System.out.println("Teste atualizar cliente");
		for (int i=0; i<lista_clientes.size(); i++){
			System.out.println(lista_clientes.get(i).getNome() + " - " + lista_clientes.get(i).getEmail());
		}
		climanager.removerCliente(id);
		lista_clientes = climanager.todosOsClientes();
		System.out.println("Teste remover cliente");
		for (int i=0; i<lista_clientes.size(); i++){
			System.out.println(lista_clientes.get(i).getNome() + " - " + lista_clientes.get(i).getEmail());
		}		
	}

}
