package tester;
import org.hibernate.*;
import dao.VoterDaoImpl;
import pojos.Voter;
import java.util.Scanner;
import  static utils.HibernateUtils.getFactory;

public class getUserDetailsById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(SessionFactory sf= getFactory(); Scanner sc= new Scanner(System.in))
		{
			VoterDaoImpl vtrdao = new VoterDaoImpl();
			System.out.println("Enter voterId");
			Voter vt=vtrdao.getVoterDetails(sc.nextInt());
			System.out.println(vt);
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
