package ecommerce;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserLogin {
    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User Id: ");
        int id = scanner.nextInt();
        System.out.print("Enter Password: ");
        String password = scanner.next();

        User u = em.find(User.class, id);

        if (u != null) 
        {  
            if (u.getPassword().equals(password)) 
            { 
                System.out.println("============Logged in Successfully!==============");
                boolean b = true;
                while(b)
                {
                	System.out.println(" 1.Create Product \n 2.View Products \n 3.Update Product \n 4.Delete Product \n 5.Logout");
                	System.out.print("Enter your Choice:- ");
                	int ch = scanner.nextInt();
                	switch(ch)
                	{
                	case 1:	new SaveProduct().start();
                		break;
                	case 2:	new ViewAllProduct().start();
                		break;
                	case 3: new UpdateProduct().start();
                		break;
                	case 4:	new DeleteProduct().start();
                		break;
                	case 5:	em.close();
                    		emf.close();
                    		System.out.println("Loged out Successfully!");
                    		b=false;
                		break;
                	default: System.out.println("Invalid Choice! Try Again");		
                	}
                }
            } 
				
            else {
                System.out.println("User not found, create a new account!");
            }
        
            
        } else {
            System.out.println("No Data");
        }

//        scanner.close();
        em.close();
        emf.close();
    }
}
