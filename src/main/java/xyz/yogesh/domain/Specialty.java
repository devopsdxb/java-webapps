package xyz.yogesh.domain;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "specialties", catalog = "petclinic")
public class Specialty {

	private Integer id;
	private String name;
	private Set<Vet> vets;

	public Specialty() {
	}

	public Specialty(String name, Set<Vet> vets) {
		this.name = name;
		this.vets = vets;
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

	@Column(name = "name", length = 80)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vet_specialties", 
    			joinColumns = @JoinColumn(name = "specialty_id", referencedColumnName = "id"), 
    			inverseJoinColumns = @JoinColumn(name = "vet_id", referencedColumnName = "id"))
	public Set<Vet> getVets() {
		return this.vets;
	}

	public void setVets(Set<Vet> vets) {
		this.vets = vets;
	}

}
