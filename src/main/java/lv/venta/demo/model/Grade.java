package lv.venta.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity(name="GradeTable")
@Getter @Setter @NoArgsConstructor
public class Grade {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	@Column(name="Gid")
	private int gid;
	
	
	@Min(value=0)
	@Max(value=10)
	@Column(name="GradeValue")
	private int gradeValue;
	
	//1. izveido otras klases mainīgos
	//2. abās pusēs nodefinē saites ar anotācijām
	//3. tajā pusē, kur glabāsies otras puses id, liekam @JoinColumn un norādam uz id
	//4. otrā pusē liekam mappedBy un norādam uz mainīgo
	
	//many-to-1
	@ManyToOne
	@JoinColumn(name="Id")
	private Student student;
	
	//many-to-1
	@ManyToOne
	@JoinColumn(name="Cid")
	private Course course;

	
	
	
	
	
	
	public Grade(@Min(0) @Max(10) int gradeValue, Student student, Course course) {
		super();
		this.gradeValue = gradeValue;
		this.student = student;
		this.course = course;
	}







	@Override
	public String toString() {
		return "Grade [gid=" + gid + ", gradeValue=" + gradeValue + ", student=" + student + ", course=" + course + "]";
	}
	
	
	
}
