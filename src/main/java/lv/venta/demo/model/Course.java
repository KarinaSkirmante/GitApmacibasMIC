package lv.venta.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity(name="CourseTable")
@Getter @Setter @NoArgsConstructor 
public class Course {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	@Column(name="Cid")
	private int cid;
	
	@NotNull
	@NotEmpty
	@Size(min = 5, max=30)
	@Pattern(regexp="[A-Za-z0-9\\ ]+")
	@Column(name="Title")
	private String title;
	
	@Min(value=0)
	@Max(value=20)
	@Column(name="CreditPoints")
	private int creditPoints;
	
	
	
	
	
	
	
	//1-to-many
	@OneToMany(mappedBy="course")
	@ToString.Exclude
	private Collection<Grade> grades;
	
	//example 1-to-1
	/*
	//1-to-1
	@OneToOne
	@JoinColumn(name="Pid")//kolonas nosaukums no otras klašu tabulas
	private Professor professor;
	 */
	
	//example many-to-many
	@ManyToMany
	@JoinTable(name="Professor_Course", joinColumns=@JoinColumn(name="Cid"),inverseJoinColumns=@JoinColumn(name="Pid") )
	private Collection<Professor> professors;
	
	
	
	
	
	
	public Course(@NotNull @NotEmpty @Size(min = 5, max = 30) @Pattern(regexp = "[A-Za-z0-9\\ ]+") String title,
			@Min(0) @Max(20) int creditPoints, ArrayList<Professor> professors) {
		super();
		this.title = title;
		this.creditPoints = creditPoints;
		this.professors = professors;
	}









	@Override
	public String toString() {
		return "Course [cid=" + cid + ", title=" + title + ", creditPoints=" + creditPoints +  ", professor=" + professors + "]";
	}
	
	
	
	
	
	
}
