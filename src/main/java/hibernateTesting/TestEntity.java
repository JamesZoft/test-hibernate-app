package hibernateTesting;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "testentity")
@Where(clause = "name IS NOT NULL")
public class TestEntity {
	@Id
	@GeneratedValue
	private Long id;

	@Basic
	private String name;

	//For hibernate
	protected TestEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ID: " + id + "|| name: " + name;
	}
}
