package Codigo.Actividad1BackEnd.app.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table
public class ACCATEGO  {
	@Id
	@SequenceGenerator(name="accatego_sequence",sequenceName="accatego_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,	generator = "accatego_sequence")
	private int CAT_Id;
	private String CAT_Nombre;
	
	public int getCAT_Id() {
		return CAT_Id;
	}
	public void setCAT_Id(int cAT_Id) {
		CAT_Id = cAT_Id;
	}
	public String getCAT_Nombre() {
		return CAT_Nombre;
	}
	public void setCAT_Nombre(String cAT_Nombre) {
		CAT_Nombre = cAT_Nombre;
	}
	@Override
	public String toString() {
		return "ACCATEGO {CAT_Id=" + CAT_Id + ", CAT_Nombre=" + CAT_Nombre + "}";
	}
	public ACCATEGO(int cAT_Id, String cAT_Nombre) {
		CAT_Id = cAT_Id;
		CAT_Nombre = cAT_Nombre;
	}
	public ACCATEGO(String cAT_Nombre) {
		CAT_Nombre = cAT_Nombre;
	}
	public ACCATEGO() {
		super();
	}
	
	
	
	
	
	
}
