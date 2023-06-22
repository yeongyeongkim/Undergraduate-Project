package finalproject;

import java.util.ArrayList;
import java.util.Scanner;

interface Show{
	void show();
}

class Member implements Show{
	   private String name;
	   private int period; 
	   private String tel;

	   String getName() { return name; }
	   int getPeriod() { return period; }
	   void setName(String name) { this.name = name; }
	   void setPeriod(int period) { this.period = period; }
	   void setTel(String tel) { this.tel = tel; }
	   public void show() {
		   System.out.println(name + " / " + period + " / " + tel);
		   }
}

public class Health {
		
	public static void main(String[] args) {
	
		Scanner in=new Scanner(System.in);
		ArrayList<Member> list = new ArrayList<Member>();
		
		int num=1; int i=0;
		
		while (num!=6) {
			System.out.println( "*** member management system ***"    );
			System.out.println( "1. View member list"    );
			System.out.println( "2. Add new member"    );
			System.out.println( "3. Delete member information"    );
			System.out.println( "4. Edit member information"    );
			System.out.println( "5. Search member information"    );
			System.out.println( "6. Exit"    );
			System.out.println(  );
			System.out.print( "Select one of 1 - 6 commands >> ");
			num=in.nextInt();
			System.out.println(  );

		
		switch (num) {

		case 1:
			
			for (Member m : list)
				m.show();
			System.out.println(  );
			break;

		case 2: 
			
			Member mem=new Member();
			
			System.out.println( "Please enter the name, period, and phone number want to add."    );
			
			System.out.print( "name>> "); 
			mem.setName(in.next());
			
			System.out.print( "period>> ");
			mem.setPeriod(in.nextInt());
			if (mem.getPeriod() < 0) {
				System.out.println( "Error: period < 0"    );
				System.out.println(  );
				break;
			}
			
			System.out.print( "tel>> ");
			mem.setTel(in.next());
			
			list.add(mem);
			System.out.println(  );
			System.out.println( "Complete"    );
			System.out.println(  );
			break;

		case 3:
			
			System.out.println( "Please enter the name you want to delete."    );
			System.out.print( "name>> ");
			String s_name=in.next();
			
			for (Member m : list) {
				if (m.getName().equals(s_name)) {
					list.remove(i);
					System.out.println( "Complete"    );
				}
			i++;
			}
			System.out.println(  );
			break;

		case 4:
			
			System.out.println( "Please enter the name you want to edit"    );
			System.out.print( "name>> ");
			s_name=in.next();
			
			for (Member m : list) {
				if (m.getName().equals(s_name)) {
					System.out.println( "What did you want to edit?"    );
					System.out.println();
					System.out.print( "1.name 2.period 3.tel >> ");
					num=in.nextInt();
					switch (num) {
					case 1:
						System.out.print( "name>> ");
						m.setName(in.next());
						break;
					case 2:
						System.out.print( "period>> ");
						m.setPeriod(in.nextInt());
						break;
					case 3:
						System.out.print( "tel>> ");
						m.setTel(in.next());
						break;
					}
					System.out.println( "Complete"    );
					}
			}
			System.out.println(  );
			break;

		case 5:
			
			System.out.println( "Please enter the name you want to search."    );
			System.out.print( "name>> ");
			s_name=in.next();
			
			for (Member m : list) {
				if (m.getName().equals(s_name)) {
					System.out.println(  );
					m.show();
					System.out.println(  );
					System.out.println( "Complete"    );
				}
				}
			System.out.println(  );
			break;

		case 6:
			break;
			
		default:
			System.out.println( "Unlisted command. Please select one of 1 - 6 commands"    );
			System.out.println(  );
			break;
			}
		
		}if (num == 6) {
			System.out.println( "BYE- BYE-"    );
			}
		}
	}


