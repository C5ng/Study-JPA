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
            /* Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            // 영속
            em.persist(member); */

            // 준영속, 분리
            /* em.detach(member);

            // 삭제
            em.refresh(member); */

            /* 영속성 컨텍스트 1 */

            /* 영속성 컨텍스트 2 */

            /* Member findMember1 = em.find(Member.class, 100L); // 조회를 해도 Select 쿼리가 실행되지 않는다. -> 1차 캐시에서 조회하기 때문

            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2); */ // 쓰기 지연 저장소에 쌓아둔다.
            /* System.out.println("=======================");

            Member member = em.find(Member.class, 150L);
            member.setName("HI"); */ // 변경 감지

            /* 영속성 컨텍스트 2 */

            /* 플러시 */

            /* Member member = new Member(200L, "200");
            em.persist(member);

            em.flush(); // 플러시, 1차 캐시는 유지 된다.

            System.out.println("==============="); */

            /* 플러시 */

            /* 준영속 */

            /* Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.detach(member); */ // Select 쿼리만 실행되고 Update 쿼리는 실행되지 않는다.

            /* 준영속 */

            /* 단방향 연관관계 */

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            // member.setTeamId(team.getId());
            member.setTeam(team);
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());
            Team team1 = findMember.getTeam();
            System.out.println("team1.getName() = " + team1.getName());
            // Team findTeam = em.find(Team.class, teamId); // 객체 지향적이지 않다.

            /* 단방향 연관관계 */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
