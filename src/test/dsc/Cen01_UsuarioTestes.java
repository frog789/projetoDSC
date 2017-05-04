package test.dsc;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.farmacontrol.usuario.Funcionario;
import com.farmacontrol.usuario.TipoUsuario;

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
		Persistence.generateSchema("FarmaControl", null);
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
