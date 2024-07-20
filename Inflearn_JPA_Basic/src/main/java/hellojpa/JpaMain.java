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

            /* Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            // member.setTeamId(team.getId());
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            Team team1 = findMember.getTeam();
            List<Member> members = team1.getMembers();
            for (Member member1 : members) {
                System.out.println("member1 = " + member1);
            } */
            // Team findTeam = em.find(Team.class, teamId); // 객체 지향적이지 않다.

            /* 단방향 연관관계 */

            /* 양방향 매핑시 연관관계의 주인 */

            /* Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member");
            member.changeTeam(team);
            em.persist(member);

            team.getMembers().add(member);

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers(); // team.getMembers().add(member)를 하지 않아도 Team에서 Member 데이터를 사용하는 시점에 쿼리를 실행한다.
            for (Member m : members) {
                System.out.println("m = " + m.getUsername());
            } */

            /* 양방향 매핑시 연관관계의 주인 */

            /* 상속 관계 매핑 */

            /* Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMove = em.find(Movie.class, movie.getId());
            System.out.println("findMove = " + findMove); */ // Join해서 가져온다.

            /* 상속 관계 매핑 */

            /* 프록시 */

            /* Member member = em.find(Member.class, 1L);
            printMember(member);
            printMemberAndTeam(member); */

            /* Member member = new Member();
            member.setUsername("hello");

            em.persist(member);

            em.flush();
            em.clear();

//            Member findMember = em.find(Member.class, member.getId());
            Member findMember = em.getReference(Member.class, member.getId());
            System.out.println("findMember.getClass() = " + findMember.getClass());
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getUserName() = " + findMember.getUsername()); */
            
            // id는 쿼리가 호출되지 않고, username을 호출할때 쿼리가 호출된다.
            // id는 값이 있기 때문
            // username은 값이 DB에 있기 때문에 즉 실제 호출해야 할 수 있기 때문에 이때 호출한다.

            /* Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            em.persist(member2);

            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.find(Member.class, member2.getId());

//            System.out.println("m1 == m2: " + (m1.getClass() == m2.getClass())); // true

            Member m2 = em.getReference(Member.class, member2.getId());
//            System.out.println("m1 == m2: " + (m1.getClass() == m2.getClass())); // false
            System.out.println("m1: " + (m1 instanceof Member)); // true
            System.out.println("m2: " + (m1 instanceof Member)); */ // true

            /* Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
            System.out.println("m1 = " + m1.getClass());

            Member reference = em.getReference(Member.class, member1.getId());
            System.out.println("reference = " + reference.getClass());

            System.out.println("a == a: " + (m1 == reference)); // 같은 Tx에서 가져오고 PK가 같으면 항상 True를 반환한다. */

            /* Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass()); // proxy

            Member findMember = em.find(Member.class, member1.getId()); // find를 해도 proxy로 반환된다.
            System.out.println("findMember = " + findMember.getClass());

            System.out.println("refMember == findMember: " + (refMember == findMember)); */

            /* Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass());

            em.detach(refMember); // 영속성 컨텍스트에서 제거된다.
            // em.close() // 마찬가지

            System.out.println("refMember = " + refMember.getUsername()); */

            /* 프록시 */
            
            /* 즉시 로딩과 지연 로딩 */

            /* Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.changeTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();

            Member m = em.getReference(Member.class, member1.getId());

//            List<Member> members = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();

            List<Member> members2 = em.createQuery("select m from Member m join fetch m.team", Member.class)
                    .getResultList();*/  // 한 번에 가져온다

            /* 즉시 로딩과 지연 로딩 */

            /* 영속성 전이와 고아 객체 */

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);
            // em.persist()를 3번 호출
            // CascateType.ALL -> em.persist하면 같이 persist한다.

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0); // 부모 객체와 끊긴 자식 개체는 remove 쿼리를 호출한다. 고아객체



            /* 영속성 전이와 고아 객체 */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    private static void printMember(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
}
