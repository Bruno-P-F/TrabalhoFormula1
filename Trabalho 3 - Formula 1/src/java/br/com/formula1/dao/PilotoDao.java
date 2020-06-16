package br.com.formula1.dao;

import br.com.formula1.domain.Piloto;
import br.com.formula1.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class PilotoDao {
    
    public List<Piloto> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Piloto> pilotos = session.createQuery("from Piloto order by nome").list();
            session.getTransaction().commit();
            return pilotos;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public Piloto consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Piloto piloto = (Piloto)session.createQuery("from Piloto where id = " + id).uniqueResult();
            session.getTransaction().commit();
            return piloto;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(Piloto piloto){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(piloto);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
    
     public boolean alterar(Piloto piloto){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(piloto);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
     
      public boolean excluir(Piloto piloto){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.delete(piloto);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
}