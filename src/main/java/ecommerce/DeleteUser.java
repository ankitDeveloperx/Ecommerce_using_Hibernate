package ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class DeleteUser {
    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=============Delete User by Id and password===============");
        System.out.print("Enter User ID to delete: ");
        int id = scanner.nextInt();
//        System.out.println("Enter the password: ");
//        String password = scanner.next();
        
        User user = em.find(User.class, id);
//        User user2 = em.find(User.class, password);
        
        if (user!= null) {
            et.begin();
            em.remove(user);
            et.commit();
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found!");
        }

        em.close();
        emf.close();
    }
}
