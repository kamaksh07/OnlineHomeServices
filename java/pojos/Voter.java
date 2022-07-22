package pojos;

import  javax.persistence.*;

//id | name    | email             | password | status | role
@Entity
@Table(name="voters")
public class Voter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true)
	private String name;
	@Column(unique=true)
	private String email;
	private String password;
	@Transient
	private String confPassword;
	private int status;
	@Enumerated(EnumType.STRING)
	private Role role;
	public Voter() {
		System.out.println("In default constructor "+getClass());
	}
	public Voter(String name, String email, String password, String confPassword, int status, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confPassword = confPassword;
		this.status = status;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfPassword() {
		return confPassword;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", name=" + name + ", email=" + email + ", status=" + status + ", role=" + role
				+ "]";
	}
	
	
	
	
	
	
	
	

}
