package tester;
import org.hibernate.*;
import dao.VoterDaoImpl;
import pojos.Voter;

import  static utils.HibernateUtils.getFactory;

import java.util.List;
public class getAllVotersList {

	public static void main(String[] args) {
		try(SessionFactory sf= getFactory())
		{
			VoterDaoImpl vtrdao= new VoterDaoImpl();
			vtrdao.getAllVoterDetails().forEach(System.out::println);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		System.out.println("Hello from Dhananjay")

	}

}
