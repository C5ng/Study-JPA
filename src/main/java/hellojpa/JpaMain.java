package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml에서 정의한 persistenceUnitName 전달
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member); // 저장

            Member findMember = em.find(Member.class, 2L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.Name = " + findMember.getName()); // 조회

//            em.remove(findMember); // 삭제

            findMember.setName("HelloJPA"); // 수정, 수정할 때 em.persist로 저장하지 않아도 된다.

            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
                    .getResultList(); // JPQL
            for (Member member1 : resultList) {
                System.out.println(member1.getName());
            }

            tx.commit(); // 트랜잭션 커밋
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
