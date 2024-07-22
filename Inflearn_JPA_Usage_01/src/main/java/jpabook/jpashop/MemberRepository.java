package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext // 해당 어노테이션이 있으면 SpringBoot가 EntityManger를 주입 해준다.
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // 커맨드랑 쿼리를 분리한다. member를 리턴하면 사이드 이펙트를 발생할 수 있는 커맨드성이다. 따라서 id만 return
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
