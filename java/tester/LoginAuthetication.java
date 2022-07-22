package tester;
import org.hibernate.*;
import dao.VoterDaoImpl;
import pojos.Voter;

import  static utils.HibernateUtils.getFactory;
import java.util.Scanner;
public class LoginAuthetication {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc= new Scanner(System.in))
		{
			VoterDaoImpl voterDao= new VoterDaoImpl();
			System.out.println("Enter name and password");
			Voter voter=voterDao.authoticateUser(sc.next(), sc.next());
			if(voter!=null) {
				System.out.println("Welcome Voter"+voter.getName());
			System.out.println(voterDao.UpdateVotingStatus(voter.getId()));
			}
			else
			{
				System.out.println("Wrong name or password");
			}
			}catch(Exception e)
		    {
				e.printStackTrace();
		}
		

	}

}
