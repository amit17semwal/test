import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ExternalizableMain {
 /**
  */
 public static void main(String[] args) {
//serializAndExternalizeDemo();
 }
 
 
 public void serializAndExternalizeDemo() {
	 EmployeeExter emp = new EmployeeExter();
	  emp.setEmployeeId(101);
	  emp.setEmployeeName("Arpit");
	  emp.setDepartment("CS");
	  
	  EmployeeSerial empsr = new EmployeeSerial();
	  empsr.setEmployeeId(102);
	  empsr.setEmployeeName("Amit");
	  empsr.setDepartment("MCA");
	  //Serialize
	  try
	  {
	   FileOutputStream fileOut = new FileOutputStream("employeeExter.ser");
	   ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
	   outStream.writeObject(emp);
	   fileOut = new FileOutputStream("employeeSer.ser");
	   outStream = new ObjectOutputStream(fileOut);
	 
	   outStream.writeObject(empsr);
	   outStream.close();
	   fileOut.close();
	  }catch(IOException i)
	  {
	   i.printStackTrace();
	  }

	  //Deserialize
	  emp = null;
	  empsr = null;
	  try
	  {
	   FileInputStream fileIn =new FileInputStream("employeeExter.ser");
	   ObjectInputStream in = new ObjectInputStream(fileIn);
	   emp = (EmployeeExter) in.readObject();
	   
	   System.out.println("Deserialized Employee...");
	   System.out.println("Emp id: " + emp.getEmployeeId());
	   System.out.println("Name: " + emp.getEmployeeName());
	   System.out.println("CS: " + emp.getDepartment());
	   
	   fileIn =new FileInputStream("employeeSer.ser");
	   in = new ObjectInputStream(fileIn);
	 
	   empsr = (EmployeeSerial) in.readObject();
	   in.close();
	   fileIn.close();
	  }catch(IOException i)
	  {
	   i.printStackTrace();
	   return;
	  }catch(ClassNotFoundException c)
	  {
	   System.out.println("Employee class not found");
	   c.printStackTrace();
	   return;
	  }
	  System.out.println("Deserialized Employee...");
	  System.out.println("Emp id: " + empsr.getEmployeeId());
	  System.out.println("Name: " + empsr.getEmployeeName());
	  System.out.println("CS: " + empsr.getDepartment());
	 
 }
}

class EmployeeExter implements Externalizable {

	int employeeId;
	String employeeName;
	String department;
	String nationality;

	public EmployeeExter() {

	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		employeeId = in.readInt();
		employeeName = (String) in.readObject();

	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {

		out.writeInt(employeeId);
		out.writeObject(employeeName);
	}
}

class EmployeeSerial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 55;
	int employeeId;
	String employeeName;
	String department;
	String nationality;

	public EmployeeSerial() {

	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}

class EmployeeSerial2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 55;
	int employeeId;
	String employeeName;
	

	public EmployeeSerial2() {

	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


}