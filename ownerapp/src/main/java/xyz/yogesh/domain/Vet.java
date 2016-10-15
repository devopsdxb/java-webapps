package xyz.yogesh.domain;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets", catalog = "petclinic")
public class Vet {

	private Integer id;
	private String firstName;
	private String lastName;
	private Set<Specialty> specialties;

	public Vet() {
	}

	public Vet(String firstName, String lastName, Set<Specialty> vetspecialties) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialties = vetspecialties;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "first_name", length = 30)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 30)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "vets")
	public Set<Specialty> getSpecialties() {
		return this.specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}

}
