package hellojpa;

import hellojpa.jpql.Member;
import hellojpa.jpql.MemberDTO;
import jakarta.persistence.*;
import org.h2.command.dml.Merge;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            em.flush();
            em.clear();

            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class); // 타입 정보를 명확하게 적어서 TypeQuery
            Query query1 = em.createQuery("select m.username, m.age from Member m", String.class); // 반환 타입이 명확하지 않아 Query

            em.createQuery("select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "member1"); // 파라미터 이름 기준
//            em.createQuery("select m from Member m where m.username = :username", Member.class)
//                    .setParameter(1, "member1"); // 파라미터 이름 기준

            List<Member> result = em.createQuery("select m from Member m", Member.class)
                    .getResultList(); // 전부 영속성 컨텍스트에 관리된다.

            List<MemberDTO> resultList = em.createQuery("select new hellojpa.jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList(); // new 명령어로 조회

            System.out.println("resultList = " + resultList);

            em.createQuery("select m from Member m order by m.age desc", Member.class)
                        .setFirstResult(1)
                        .setMaxResults(10)
                        .getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        em.close();
        emf.close();
    }
}
