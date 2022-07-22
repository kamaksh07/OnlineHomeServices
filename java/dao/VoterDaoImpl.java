package dao;

import pojos.Voter;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.util.List;

public class VoterDaoImpl implements IVoterDao {

	@Override
	public String registerVoter(Voter voter) {
		// TODO Auto-generated method stub
		Integer id = null;
		
		Session session= getFactory().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			
		id = (Integer)session.save(voter);
		//session.save(voter);bn
			tx.commit();
		}catch(RuntimeException e)
		{
			if(tx!= null)
				tx.rollback();
		}
		finally {
			if(session!=null)
				session.close();
		}
		//return "Voter regester with VoterId "+voter.getId();
		return "Voter regester with VoterId "+id;
	}

	@Override
	public Voter getVoterDetails(int uid) {
		// TODO Auto-generated method stub
		Voter vtr= null;
		Session session=getFactory().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
			vtr=session.get(Voter.class, uid);
			tx.commit();
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return vtr;
	}

	@Override
	public List<Voter> getAllVoterDetails() {
		List<Voter> votrs= null;
		Session session= getFactory().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try {
		String jpql="select u from Voter u";
		votrs= session.createQuery(jpql,Voter.class).getResultList();
		tx.commit();
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return votrs;
	}

	@Override
	public Voter authoticateUser(String name, String pwd) {
		Voter vtr= null;
		Session session =getFactory().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try 
		{
			String Jaql="select u from Voter u where u.name=:nm and u.password=:pass";
			System.out.println("hello");
			vtr=session.createQuery(Jaql,Voter.class).setParameter("nm", name).setParameter("pass", pwd).getSingleResult();
			tx.commit();
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return vtr;
	}

	@Override
	public String UpdateVotingStatus(int id) {
		String message="Updation failed!!!";
		Session session =getFactory().getCurrentSession();
		Transaction tx= session.beginTransaction();
		try 
		{
			Voter voter=null;
//			String jpql="update  Voter u set status=1 where id=:vid ";
//			int updateCnt= session.createQuery(jpql).setParameter("vid", id).executeUpdate();
//			message=updateCnt+" Status updeted!!!";
			voter=session.get(Voter.class, id);
			voter.setStatus(1);
			tx.commit();

			message="Status update";
			
		}catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return message;
	}
	

}
