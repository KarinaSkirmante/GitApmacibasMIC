package lv.venta.demo.model;



import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Table
@Entity(name="StudentTable")
@Getter @Setter @ToString @NoArgsConstructor
public class Student extends Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	@Column(name="Id")
	private int id;
	
	/*@NonNull
	@NotEmpty(message="Lauks nedrīkst būt tukšs")
	@Size(min = 3, max = 30, message="Vārdam ir jābūt 3-30 simbolu garam")
	@Pattern(regexp="[A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*", message="Jāsatur tikai burti")
	@Column(name="Name")
	private String name;
	
	@NonNull
	@NotEmpty
	@Size(min = 3, max = 30)
	@Pattern(regexp="[A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*")
	@Column(name="Surname")
	private String surname;
	*/
	
	//1-to-many
	@OneToMany(mappedBy="student")
	@ToString.Exclude
	private Collection<Grade> grades;
	
	
	public Student(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	
	
	
}