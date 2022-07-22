package dao;

import java.util.List;

import pojos.Voter;

public interface IVoterDao {
	String registerVoter(Voter voter);
	Voter getVoterDetails(int uid);
	List<Voter> getAllVoterDetails();
	Voter authoticateUser(String name,String pwd);
	String UpdateVotingStatus(int id);

}
