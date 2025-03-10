package ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class DeleteProduct {
    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner scanner = new Scanner(System.in);
        System.out.println("===============Delete Product==============");
        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();
        
        Product p = em.find(Product.class, id);

        if (p != null) {
            et.begin();
            em.remove(p);
            et.commit();
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }

        em.close();
        emf.close();
    }
}
