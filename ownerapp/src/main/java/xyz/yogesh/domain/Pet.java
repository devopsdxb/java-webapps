package xyz.yogesh.domain;
// default package
// Generated Oct 14, 2016 6:57:04 PM by Hibernate Tools 5.2.0.Beta1

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pets", catalog = "petclinic")
public class Pet{

	private Integer id;
	private Owner owner;
	private Type type;
	private String name;
	private Date birthDate;
	private Set<Visit> visits;

	public Pet() {
	}

	public Pet(Owner owner, Type type) {
		this.owner = owner;
		this.type = type;
	}

	public Pet(Owner owner, Type type, String name, Date birthDate, Set<Visit> visits) {
		this.owner = owner;
		this.type = type;
		this.name = name;
		this.birthDate = birthDate;
		this.visits = visits;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id", nullable = false)
	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id", nullable = false)
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", length = 10)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pet")
	public Set<Visit> getVisits() {
		return this.visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

}
