package lv.venta.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Table
@Entity(name="ProfessorTable")
@Getter @Setter @ToString @NoArgsConstructor
public class Professor extends Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	@Column(name="Pid")
	private int pid;
	
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
	
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 10)
	@Pattern(regexp="[A-Za-z]+")
	@Column(name="Degree")
	private String degree;
	
	
	//example 1-to-1
	/*
	//1-to-1
	@OneToOne(mappedBy="professor")//norādīt mainīgo, caur kuru sasaista
	@ToString.Exclude
	private Course course;
	 */
	
	//example many-to-many
	@ManyToMany(mappedBy="professors")
	@ToString.Exclude
	private Collection<Course> courses;
	

	public Professor(
			@NotEmpty(message = "Lauks nedrīkst būt tukšs") @Size(min = 3, max = 30, message = "Vārdam ir jābūt 3-30 simbolu garam") @Pattern(regexp = "[A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*", message = "Jāsatur tikai burti") String name,
			@NotEmpty @Size(min = 3, max = 30) @Pattern(regexp = "[A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*") String surname,
			@NotNull @NotEmpty @Size(min = 3, max = 10) @Pattern(regexp = "[A-Za-z.]") String degree) {
		super(name, surname);
		//setName(name);
		//setSurname(surname);
		this.degree = degree;
	}
	
	
	
	
	
	
}
