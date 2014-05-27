package aula.app;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import aula.model.Artista;
import aula.model.CD;
import aula.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		insertArtista();
		
		updateArtista();
		
		criarCDParaArtista();
	}

	private static void insertArtista() {
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		
		try{
			
			Artista artista = new Artista();
			artista.setNome("Josino");
			artista.setPais("Brasil");
			session.saveOrUpdate(artista);
			
			t.commit();
		}catch(Exception e){
			e.printStackTrace();
			t.rollback();
		}
		session.close();
	}

	private static void updateArtista() {
		
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		try{
			Artista artista =  (Artista) session.createCriteria(Artista.class)
					.add(Restrictions.eq("nome", "Josino"))
					.uniqueResult();
			
			artista.setBanda(false);
			session.saveOrUpdate(artista);
			t.commit();
		}catch(Exception e){
			e.printStackTrace();
			t.rollback();
		}
		
		session.close();
	}
	
	
	private static void criarCDParaArtista() {
		
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		try{
			Artista artista =  (Artista) session.createCriteria(Artista.class)
					.add(Restrictions.eq("nome", "Josino"))
					.uniqueResult();
			
			artista.setBanda(false);
			
			CD cd = new CD();
			cd.setArtista(artista);
			cd.setDuplo(false);
			cd.setFaixas("Faixas");
			cd.setNome("The Best");
			
//			artista.getCds().add(cd);
			
			session.saveOrUpdate(cd);
			t.commit();
		}catch(Exception e){
			e.printStackTrace();
			t.rollback();
		}
		
		session.close();
	}
}
