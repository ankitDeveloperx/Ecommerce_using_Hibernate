package ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class SaveProduct {

    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========Create Product===========");
//        System.out.print("Enter Product ID: ");
        int id = 0;

        System.out.print("Enter Product Name: ");
        String name = scanner.next();

        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        Product p = new Product(id, name, price);

        et.begin();
        em.persist(p);
        et.commit();

        System.out.println("Product saved successfully!");
        
        em.close();
        emf.close();
    }
}

