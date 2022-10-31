package lv.venta.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
@MappedSuperclass
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person {

	@NonNull
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

	public Person(
			@NotEmpty(message = "Lauks nedrīkst būt tukšs") @Size(min = 3, max = 30, message = "Vārdam ir jābūt 3-30 simbolu garam") @Pattern(regexp = "[A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*", message = "Jāsatur tikai burti") String name,
			@NotEmpty @Size(min = 3, max = 30) @Pattern(regexp = "[A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*") String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	
	
}
