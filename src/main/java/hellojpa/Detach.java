package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Detach {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml에서 정의한 persistenceUnitName 전달
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {
//            Member member = new Member();
//            member.setId(200L);
//            member.setName("Flush");
//
//            em.detach(member); // 영속성 컨텍스트에서 제거
//
//            System.out.println("===================");
//
//            member.setName("Detach"); // Update 되지 않는다.

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
