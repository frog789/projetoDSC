package testes;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.farmacontrol.usuario.Cliente;
import com.farmacontrol.usuario.Funcionario;
import com.farmacontrol.usuario.TipoUsuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Cen01_UsuarioTestes {

	private static EntityManagerFactory emf;
	private static Logger logger;
	private EntityManager em;
	private EntityTransaction et;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger = Logger.getGlobal();
		logger.setLevel(Level.INFO);
		emf = Persistence.createEntityManagerFactory("FarmaControl");
		DbUnitUtil.insertData();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@Before
	public void setUp() throws Exception {
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
			em.close();
			em = null;
			et = null;
		}
	}

	
	@Test
	public void t01_insertFuncionarioValido() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Funcionario01");
		funcionario.setTipo(TipoUsuario.F);
		assertNotNull(funcionario.getId());
	}
	
	
//	@Test
//	public void t02_insertClienteValido(){
//		Cliente cliente = new Cliente();
//		cliente.set
//		
//	}
	
	

}
