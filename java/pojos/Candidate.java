package pojos;
import javax.persistence.*;
@Entity
@Table(name="candidates")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String name;
	
	private String party;
	private int votes;
	
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Candidate(String name, String party, int votes) {
		super();
		
		this.name = name;
		this.party = party;
		this.votes = votes;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	@Override
	public String toString() {
		return "Condidate [name=" + name + ", party=" + party + ", votes=" + votes + "]";
	}
	
	
}
