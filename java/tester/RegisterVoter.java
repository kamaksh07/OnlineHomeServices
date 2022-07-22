package tester;
import static utils.HibernateUtils.getFactory;
import dao.VoterDaoImpl;
import pojos.Role;
import pojos.Voter;

import java.util.Scanner;
import org.hibernate.*;

public class RegisterVoter {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); Scanner sc= new Scanner(System.in))
		{
			VoterDaoImpl vtrdao= new VoterDaoImpl();
			//public Voter(String name, String email, String password, String confPassword,  String role)
			System.out.println("Enter name email pwd confPwd  role");
			Voter vtr= new Voter(sc.next(), sc.next(), sc.next(), sc.next(),0, Role.valueOf(sc.next().toUpperCase()));
			System.out.println(vtrdao.registerVoter(vtr));
		}catch(Exception e)
		{ e.printStackTrace();}
		
		System.out.println("Changes");

	}

}
