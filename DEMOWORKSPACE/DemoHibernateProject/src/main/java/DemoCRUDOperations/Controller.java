package DemoCRUDOperations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Controller 
{
	public static void main(String args[])
	{
		Controller controller = new Controller();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Select an operation:");
			System.out.println("1. Add Patient");
			System.out.println("2. Get Patient by ID");
			System.out.println("3. Update Patient Details");
			System.out.println("4. Delete Patient");
			System.out.println("5. Exit");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				controller.addpatient();
				break;
			case 2:
				controller.getpatientbyid();
				break;
			case 3:
				controller.updatepatient();
				break;
			case 4:
				controller.deletepatient();
				break;
			default:
				System.out.println("Invalid Choice");		
			}
			
		}	
	
	}
	
	private void addpatient() 
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sf =configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Patient p = new Patient();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Patient ID:");
		int id =sc.nextInt();
		System.out.println("Enter the Patient Name:");
		String name = sc.next();
		System.out.println("Enter the Gender:");
		String gender = sc.next();
		System.out.println("Enter Age:");
		float age = sc.nextFloat();
		System.out.println("Enter the email:");
		String email = sc.next();
		System.out.println("Enter the Location:");
		String location = sc.next();
		System.out.println("Enter the Contact Number:");
		String contactno = sc.next();
		
		p.setId(id);
		p.setName(name);
		p.setGender(gender);
		p.setAge(age);
		p.setEmail(email);
		p.setLocation(location);
		p.setContactno(contactno);
		
		session.persist(p);
		t.commit();
		
		System.out.println("Patient Added Successfully");
		
	}
	
	
	
	private void getpatientbyid() 
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sf =configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Patient ID:");
		int id =sc.nextInt();
		Patient patient =session.find(Patient.class, id);
		if(patient!=null)
		{
			System.out.println("Patient ID="+patient.getId());
			System.out.println("Patient Name="+patient.getName());
			System.out.println("Patient Gender="+patient.getGender());
			System.out.println("Patient Age="+patient.getAge());
			System.out.println("Patient Email="+patient.getEmail());
			System.out.println("Patient Location="+patient.getLocation());
			System.out.println("Patient Contactno="+patient.getContactno());			
		}
		else
		{
			System.out.println("Patient ID is Not Found");
		}
		
		
	}
	
	
	
	private void updatepatient() 
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sf =configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Patient ID:");
		int id =sc.nextInt();
		Patient patient =session.find(Patient.class, id);
		if(patient!=null)
		{
			System.out.println("Enter Patient Name");
			String name = sc.next();
			System.out.println("Enter Age");
			float age = sc.nextFloat();
			System.out.println("Enter Location");
			String location =sc.next();
			
			patient.setName(name);
			patient.setAge(age);
			
			patient.setLocation(location);
			
			t.commit();
			System.out.println("Patient Details Updated Successfully");
			
		}
		else
		{
			System.out.println("Patient ID Not Found");
		}
		session.close();
		sf.close();
			
	}
	
	
	private void deletepatient() 
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory sf =configuration.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Patient ID:");
		int id =sc.nextInt();
		Patient patient =session.find(Patient.class, id);
		if(patient!=null)
		{
			session.remove(patient);
			t.commit();
			System.out.println("Patient Deleted Successfully");
		}
		else
		{
			System.out.println("Patient ID Not Found");
		}
		
		session.close();
		sf.close();
		
		
	}

	

	

	
}	