
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GiftEmulator {
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	HashMap <String, String> assignment = new HashMap<String, String>();
	
	public GiftEmulator() {
		// TODO Auto-generated constructor stub
		/*
		employees.add(new Employee("Sarah", "sarah@email.com"));
		employees.add(new Employee("Ben", "ben@gmail.com"));
		employees.add(new Employee("Arthur", "arthur@yahoo.com"));
		employees.add(new Employee("Ken", "ken@live.com"));
		employees.add(new Employee("Chris", "chris@yahoo.com"));
		*/
		
		//assignHashMap(employees);
	}
	
	public Employee createEmployee(String name, String email) {
		Employee e = new Employee(name, email);
		return e;
	}
	
	public void assignHashMap(ArrayList<Employee> emps) {
		Random r = new Random();
		assignment.clear();
		List list = new ArrayList<>(emps.size());
		int testNum = 0;
		 for (int i = 0; i < emps.size(); i++) {
			 testNum = r.nextInt(emps.size());
			 while ((testNum==i) || (list.contains(testNum))) {
				 testNum = r.nextInt(emps.size());
			 }
			 assignment.put(emps.get(i).getName(), emps.get(testNum).getName());
			 list.add(testNum);
		 }
		 
		 HashMap<String, String> mp = assignment;
			
		 Iterator it = mp.entrySet().iterator();
		 while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " is assigned to " + pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		 }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GiftEmulator g = new GiftEmulator();
		//ArrayList<Employee> arrListEmployees = g.employees;
		ArrayList<Employee> arrListEmployees = new ArrayList<Employee>();
		String input;
		String inName;
		String inEmail;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("======== INPUT EMPLOYEES ========");
		System.out.println("How many employees do you want to input?");
        input = sc.nextLine();
        int ctr = Integer.parseInt(input);
        for (int c = 0; c < ctr; c++) {
        	System.out.println("Please enter employee name: ");
        	inName = sc.nextLine();
        	System.out.println("Please enter employee email: ");
        	inEmail = sc.nextLine();
        	Employee empInput = g.createEmployee(inName, inEmail);
        	arrListEmployees.add(empInput);
        }
        
        //Initial Gift Assignment
        System.out.println("Initial Gift Assignment: ");
        g.assignHashMap(arrListEmployees);
		
        //PROCESS - Update or Delete Employee, Re-shuffle Gift Assignment after data update
		String userInput;
	    Scanner keyboard = new Scanner(System.in);
	    
	    while (true) {
		    System.out.println("======== MENU ========");
		    System.out.println("Press 'u' for update or 'd' for delete, "
		    		+ "'s' to shuffle gift assignment, or enter 'Quit' to exit.");
		    userInput = keyboard.nextLine();
		    
	    	if (userInput.equalsIgnoreCase("Quit")) {
	    		break;
	    	}
	    	
	    	//Update
		    if (userInput.equalsIgnoreCase("u")){
		    	System.out.println("Update");
		    	System.out.println("Please enter the name of the employee you want to update:");
		    	String username = keyboard.nextLine();
		    	for (Employee e : arrListEmployees) {
		    		if (e.getName().contentEquals(username)) {
		    			System.out.println("Employee found = " + username);
		    			System.out.println("Please input new name: ");
		    			String newName = keyboard.nextLine();
		    			e.setName(newName);
		    			System.out.println("Please input new email: ");
		    			String newEmail = keyboard.nextLine();
		    			e.setEmail(newEmail);
		    		}
		    	}
		    	System.out.println("(1) employee has been updated");
		    	System.out.println("Here is the new employee list after update: ");
		    	for (int x = 0; x < arrListEmployees.size(); x++) {
					System.out.println(arrListEmployees.get(x).getName() + " " 
										+ arrListEmployees.get(x).getEmail());
				}
		    }
		    
		    //Delete
		    if (userInput.equalsIgnoreCase("d")){
		    	System.out.println("Delete");
		    	System.out.println("Please enter the name of the employee you want to update:");
		    	String username = keyboard.nextLine();
		    	Iterator<Employee> iter = arrListEmployees.iterator();
		    	while (iter.hasNext()) {
		    	  Employee e = iter.next();
		    	  if (e.getName().contentEquals(username)) iter.remove();
		    	}
		    	System.out.println("(1) employee has been deleted");
		    	System.out.println("Here is the new employee list after deletion: ");
		    	for (int y = 0; y < arrListEmployees.size(); y++) {
					System.out.println(arrListEmployees.get(y).getName() + " " 
										+ arrListEmployees.get(y).getEmail());
				}
		    }
		    
			//Reshuffle gift assignment
			if (userInput.equalsIgnoreCase("s")){
				System.out.println("The New Gift Assignment Are: ");
				g.assignHashMap(arrListEmployees);
			}
	    }
	    
	    keyboard.close();
	    sc.close();
	}
	
	public class Employee {
		
		public String name = "";
		public String email = "";

		public Employee() {
			// TODO Auto-generated constructor stub
		}
		
		public Employee(String name, String email) {
			this.name = name;
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	}

}