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
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team); // 영속 상태가 되면 무조건 PK값이 세팅 된다.

            MemberTest memberTest = new MemberTest();
            memberTest.setUsername("member1");
//            memberTest.setTeamId(team.getId()); // 객체스럽지 못한 이슈 발생
            memberTest.changeTeam(team); // 참조형태로 수정
            em.persist(memberTest);

            MemberTest findMember = em.find(MemberTest.class, memberTest.getId());
//            Team findTeam = em.find(Team.class, findMember.getTeamId()); // Team을 바로 꺼내지 못한다. -> 연관관계가 앖기 때문
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam = " + findTeam);

            List<MemberTest> members = findMember.getTeam().getMembers();
            for (MemberTest member : members) {
                System.out.println("m: " + member.getUsername());
            }
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member); // 저장
//
//            Member findMember = em.find(Member.class, 2L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.Name = " + findMember.getName()); // 조회
//
////            em.remove(findMember); // 삭제
//
//            findMember.setName("HelloJPA"); // 수정, 수정할 때 em.persist로 저장하지 않아도 된다.
//
//            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList(); // JPQL
//
//            for (Member member1 : resultList) {
//                System.out.println(member1.getName());
//            }
//
//            // 비영속
//            Member member2 = new Member();
//            member2.setId(101L);
//            member2.setName("Context");
//
//            // 영속, 이 때 DB에 저장되는 것이 아닌 컨텍스트에 저장된다.
//            em.persist(member2);
//
////            Member findMember2 = em.find(Member.class, 101L);
////            System.out.println("findMember2.getId() = " + findMember2.getId());
////            System.out.println("findMember2.getName() = " + findMember2.getName()); // 조회 쿼리 X
//
//            Member findMember3 = em.find(Member.class, 100L);
//            Member findMember4 = em.find(Member.class, 100L); // DB 조회 쿼리 한 번만 실행, 두 번째는 영속성 컨텍스트에서 조회한다.
//            System.out.println(findMember3 == findMember4); // 영속 엔티티의 동일성 보장
//
//            // 준영, 영속성 컨텍스트에서 분리
////            em.detach(member2);
//
//            // 삭제
////            em.remove(member2);
//
//            Member member5 = new Member();
//            member5.setId(150L);
//            member5.setName("변경");
//            Member findMember5 = em.find(Member.class, 150L);
//
//            findMember5.setName("변경감지"); // persist를 하지 않아도 Update 된다. (변경 감지 기능)

            tx.commit(); // 트랜잭션 커밋시 데이터베이스에 쿼리 실행한다. -> 버퍼링
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
