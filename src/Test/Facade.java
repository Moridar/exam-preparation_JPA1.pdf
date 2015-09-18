/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entity.Project;
import Entity.Projectuser;
import Entity.Task;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ansty
 */
public class Facade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exam-preparation_jpa1PU");
     EntityManager em = emf.createEntityManager();
     
     public void createUser(String name, String email){
         em.getTransaction().begin();
         em.persist(new Projectuser(name,email));
         em.getTransaction().commit();
     }
     
     public Projectuser findUser(String userName){
         return (Projectuser) em.createNamedQuery("Projectuser.findByUsername").setParameter("username",userName).getSingleResult();
     }
     
     public Collection<Projectuser> getAllUsers(){
         return em.createNamedQuery("Projectuser.findAll").getResultList();
     }
     
     public void createProject(String name, String description){
         em.getTransaction().begin();
         em.persist(new Project(name,description));
         em.getTransaction().commit();
     }
     
     public void assignUserToProject(Project p, Projectuser u){
         p.getProjectuserCollection().add(u);
         
         em.getTransaction().begin();
         em.refresh(p);
         em.getTransaction().commit();
     }
     
     public Project findProject(String name){
         return (Project) em.createNamedQuery("Project.findByName").setParameter("name", name).getSingleResult();
     }
     
     public void createTaskAndAssignToProject(String name, String description, Project p){
         
         em.getTransaction().begin();
         em.persist(new Task(name,description,p));
         em.getTransaction().commit();
     }
     
    public static void main(String[] args) {
        Facade f = new Facade();    
        f.createUser("Bobbie", "lel@lelsen.dk");
        f.findUser("Bobbie");
        f.getAllUsers();
        f.createProject("bedpro", "bedste project");
        f.findProject("bedpro");
        f.assignUserToProject(f.findProject("bedpro"),f.findUser("Bobbie"));
        f.createTaskAndAssignToProject("1.task", "første gang", f.findProject("bedpro"));
    }
}
