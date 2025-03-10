package ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class UpdateProduct {

    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("==========Update Product============");
        System.out.print("Enter Product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Product p = em.find(Product.class, id);
        if (p != null) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new Price: ");
            double newPrice = scanner.nextDouble();
            
            p.setName(newName);
            p.setPrice(newPrice);
            
            et.begin();
            em.merge(p);
            et.commit();
            
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }

        em.close();
        emf.close();
    }
}
