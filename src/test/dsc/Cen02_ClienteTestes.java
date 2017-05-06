//package test.dsc;
package test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import org.junit.After;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.farmacontrol.usuario.Cartao;
import com.farmacontrol.usuario.Cliente;
import com.farmacontrol.usuario.Endereco;
import com.farmacontrol.usuario.Funcionario;
import com.farmacontrol.usuario.TipoUsuario;
import com.farmacontrol.usuario.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Cen01_UsuarioTestes {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	private static Logger logger;

	@Before
	public void setUp() throws Exception {
		logger = Logger.getGlobal();
		logger.setLevel(Level.INFO);
		// Persistence.generateSchema("FarmaControl", null);
		DbUnitUtil.insertData();
		emf = Persistence.createEntityManagerFactory("FarmaControl");
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
	}

	@After
	public void tearDown() throws Exception {
		try {
			et.commit();
		} catch (Exception ex) {

			logger.log(Level.SEVERE, ex.getMessage());

			if (et.isActive()) {
				et.rollback();
			}

		} finally {
			if (et.isActive()) {
				et.rollback();
			}
			em.close();
			em = null;
			et = null;
		}
		emf.close();
	}

	@Test
	public void t01_insertClienteValido() {

		Cliente cliente = new Cliente();
		cliente.setNome("Cliente 001");
		cliente.setEmail("a@a.com");
		TipoUsuario tip = TipoUsuario.C;
		cliente.setTipo(tip);
		Endereco end = new Endereco(cliente, "Rua a", 111, "Apt 001", "Boa Viagem", "Recife", "PE");

		em.persist(cliente);
		em.persist(end);
	}
	
	@Test
	public void t02_criarCartaoCliente(){
		Cartao cartaoCredito = new Cartao();
        cartaoCredito.setNumero("4929293458709012");
        cartaoCredito.setBandeira("VISA");
        
        List<Cartao> listCartao = null;
        listCartao.add(cartaoCredito);
        
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.email LIKE ?1", Cliente.class);
        query.setParameter(1, "asdo@qwe.com");
        Cliente cliente = query.getSingleResult();
        cliente.setCartoes(listCartao);
        em.flush();
        
	}

	@Test
	public void t03_atualizarCliente() {

		Logger.getGlobal().log(Level.INFO, "t02_atualizarCliente");
		TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.email like :email", Cliente.class);
		query.setParameter("email", "asdo@qwe.com");
		Usuario usuario = query.getSingleResult();
		usuario.setNome("NomeAtualizado");

		try {
			em.flush();
			assertTrue(false);
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}

	}

	// @Test
	// public void t02_insertClienteValido(){
	// Cliente cliente = new Cliente();
	// cliente.set
	//
	// }

}
