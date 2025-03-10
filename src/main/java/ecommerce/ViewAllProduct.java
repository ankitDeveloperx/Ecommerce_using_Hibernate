
package ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ViewAllProduct {
    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Product Id to fetch: ");
        int id = scanner.nextInt();

        Product p = em.find(Product.class, id);
        
        if (p != null) {
            System.out.println("Product Found:");
            System.out.println("ID: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
        } else {
            System.out.println("Product not found!");
        }

        em.close();
        emf.close();
    }
}
