import java.util.ArrayList;

public class LeaveFulfillment {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        LeaveFulfillment lv = new LeaveFulfillment();
		
        LeaveItem filerank = lv.createLeaveItem(EmployeePosition.FILERANK, "File and Rank", 10.0);
        LeaveItem officer = lv.createLeaveItem(EmployeePosition.OFFICER, "Officer", 15.0);
		       LeaveItem manager = lv.createLeaveItem(EmployeePosition.MANAGER, "Manager", 30.0);
		       LeaveItem director = lv.createLeaveItem(EmployeePosition.DIRECTOR, "Director", 40.0);
        
        Employee dr1 = lv.createEmployee(10001, "Rene", EmployeePosition.DIRECTOR);
        Employee mgr1 = lv.createEmployee(10002, "Adolf", EmployeePosition.MANAGER);
        
        ArrayList<Employee> empList = new ArrayList<Employee>();
        
        empList.add(dr1);
        empList.add(mgr1);
        
        String leavesHolder;
        for (Employee e : empList) {
			if (e.position == EmployeePosition.FILERANK) {
				System.out.println("Employee " + e.getEmpNo() + ", has leaves of " + filerank.getCredits());
			} else if (e.position == EmployeePosition.OFFICER) {
				System.out.println("Employee " + e.getEmpNo() + ", has leaves of " + officer.getCredits());
			} else if (e.position == EmployeePosition.MANAGER) {
				System.out.println("Employee " + e.getEmpNo() + ", has leaves of " + manager.getCredits());
			} else if (e.position == EmployeePosition.DIRECTOR) {
				System.out.println("Employee " + e.getEmpNo() + ", has leaves of " + director.getCredits());
			}
		}
		
        

    }
    
    public LeaveItem createLeaveItem(String leaveCode, String leaveDesc, double credits) {
		LeaveItem i = new LeaveItem(leaveCode, leaveDesc, credits);
		return i;
	}
    
    public class LeaveItem {
		
		public String leaveCode;
		public String leaveDesc;
		public double credits; 
		
		public LeaveItem(String leaveCode, String leaveDesc, double credits) {
			this.leaveCode = leaveCode;
			this.leaveDesc = leaveDesc;
			this.credits = credits;
		}
		
		public String getLeaveCode() {
			return leaveCode;
		}

		public void setLeaveCode(String leaveCode) {
			this.leaveCode = leaveCode;
		}
		
		public String getLeaveDesc() {
			return leaveDesc;
		}
		public void setLeaveDesc(String leaveDesc) {
			this.leaveDesc = leaveDesc;
		}
		public double getCredits() {
			return credits;
		}
		public void setCredits(double credits) {
			this.credits = credits;
		}
		
	}
    
    public final class EmployeePosition{
        private EmployeePosition() {
    // No need to instantiate the class, we can hide its constructor
  }

  public static final String FILERANK = "filerank";
  public static final String OFFICER = "officer";
        public static final String MANAGER = "manager";
  public static final String DIRECTOR = "director";
   
    }
    
    public Employee createEmployee(int empNo, String name, String position) {
		Employee e = new Employee(empNo, name, position);
		return e;
	}
    
    public class Employee {
        public int empNo;
        public String name;
        public String position;
        
        public Employee(int empNo, String name, String position) {
            this.empNo = empNo;
            this.name = name;
            this.position = position;
        }
        
        public int getEmpNo(){
            return empNo;
        }
        
        public void setEmpNo(int empNo){
            this.empNo = empNo;
        }
        
        public String getName(){
            return name;
        }
        
        public void setName(String name){
            this.name = name;
        }
        
        public String getPosition(){
            return position;
        }
        
        public void setPosition(String position){
            this.position = position;
        }
        
        
    }
}