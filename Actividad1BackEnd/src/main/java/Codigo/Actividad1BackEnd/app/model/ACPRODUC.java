package Codigo.Actividad1BackEnd.app.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table
public class ACPRODUC  {
	@Id
	@SequenceGenerator(name="acproduct_sequence",sequenceName="acproduct_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,	generator = "acproduct_sequence")
	private int PRO_Id;
	private String PRO_Nombre;
	private double PRO_Precio;
	private int PRO_Existencias;
	public int getPRO_Id() {
		return PRO_Id;
	}
	public void setPRO_Id(int pRO_Id) {
		PRO_Id = pRO_Id;
	}
	public int getPRO_Existencias() {
		return PRO_Existencias;
	}
	public void setPRO_Existencias(int pRO_Existencias) {
		PRO_Existencias = pRO_Existencias;
	}
	public String getPRO_Nombre() {
		return PRO_Nombre;
	}
	public void setPRO_Nombre(String pRO_Nombre) {
		PRO_Nombre = pRO_Nombre;
	}
	public double getPRO_Precio() {
		return PRO_Precio;
	}
	public void setPRO_Precio(double pRO_Precio) {
		PRO_Precio = pRO_Precio;
	}
	public ACPRODUC(int pRO_Id, int pRO_Existencias, String pRO_Nombre, double pRO_Precio) {
		PRO_Id = pRO_Id;
		PRO_Existencias = pRO_Existencias;
		PRO_Nombre = pRO_Nombre;
		PRO_Precio = pRO_Precio;
	}
	public ACPRODUC(int pRO_Existencias, String pRO_Nombre, double pRO_Precio) {
		PRO_Existencias = pRO_Existencias;
		PRO_Nombre = pRO_Nombre;
		PRO_Precio = pRO_Precio;
	}
	public ACPRODUC() {
		super();
	}
	@Override
	public String toString() {
		return "ACPRODUC {PRO_Id=" + PRO_Id + ", PRO_Existencias=" + PRO_Existencias + ", PRO_Nombre=" + PRO_Nombre
				+ ", PRO_Precio=" + PRO_Precio + "}";
	}
	
	
	
	
}
