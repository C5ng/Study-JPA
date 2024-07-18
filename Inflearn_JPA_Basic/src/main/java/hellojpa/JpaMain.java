package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /* Member member = new Member();
            member.setId(1L);
            member.setName("HelloB");

            em.persist(member); */ // 등록

            /* Member findMember = em.find(Member.class, 1L); // 조회
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            findMember.setName("HelloJPA"); // 수정

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList(); // JPQL
            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            } */

            /* 영속성 컨텍스트 1 */

            // 비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            // 영속
            em.persist(member);

            // 준영속, 분리
            em.detach(member);

            // 삭제
            em.refresh(member);

            /* 영속성 컨텍스트 1 */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
