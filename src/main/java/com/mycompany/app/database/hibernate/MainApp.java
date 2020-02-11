package com.mycompany.app.database.hibernate;

import com.mycompany.app.database.hibernate.model.BankAccount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class MainApp {
    EntityManager em = null;
    public MainApp(){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
//        registerBankAccount("Saipul Anwar", "777888");
//        getAllBankAccount();
        findById(1);
        showAllAcountNumber();
        em.close();
    }

    private void registerBankAccount(String ownerName, String accountNumber){
        em.getTransaction().begin();
        BankAccount b = new BankAccount();
        b.setAccountNumber(accountNumber);
        b.setOwnerName(ownerName);
        b.setSaldo(BigDecimal.ZERO);
        em.persist(b);
        em.getTransaction().commit();
    }

    private void findById(long id){
        BankAccount b = em.find(BankAccount.class, id);
        if(b != null){
            em.getTransaction().begin();
            b.setOwnerName("haha");
            em.persist(b);
            em.getTransaction().commit();
        }
    }


    private void getAllBankAccount(){
        Query q = em.createQuery("from BankAccount order by id desc", BankAccount.class);
        List<BankAccount> bankAccounts = q.getResultList();
        for(BankAccount b : bankAccounts){
            System.out.println(b.getAccountNumber());
        }
    }

    private void showAllAcountNumber() {
        Query q = em.createQuery("select accountNumber, ownerName from BankAccount order by id desc");
        List<Object[]> bankAccounts = q.getResultList();
        int no = 1;
        for (Object[] b : bankAccounts) {
            System.out.printf("%d - %s - %s \n", no, b[0], b[1]);
        }
    }

    public static void main(String[] args){
        new MainApp();
    }
}
