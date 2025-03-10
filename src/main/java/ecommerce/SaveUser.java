package ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class SaveUser {

    public  void start(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("============Create User================");
//        System.out.print("Enter User ID: ");
        int id = 0;

        System.out.print("Enter Name: ");
        String name = scanner.next();

        System.out.print("Enter Email: ");
        String email = scanner.next();

        System.out.print("Enter Phone Number: ");
        long phone = scanner.nextLong();

        System.out.print("Enter Password: ");
        String password = scanner.next();

        User u = new User(id, name, email, phone, password);

        et.begin();
        em.persist(u);
        et.commit();

        System.out.println("User saved successfully!");
        
        em.close();
        emf.close();
    }
}
