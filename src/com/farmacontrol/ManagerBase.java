package com.farmacontrol;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class ManagerBase {

	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction et = null;

	public void beginTransaction(){
		this.emf = Persistence.createEntityManagerFactory("FarmaControl");
		this.em = emf.createEntityManager();
		this.et = em.getTransaction();
		this.et.begin();
	}

	public void endTransaction(){
		if(this.em != null){
			this.em.close();
		}
		if(this.emf != null){
			this.emf.close();
		}
	}

	
}
