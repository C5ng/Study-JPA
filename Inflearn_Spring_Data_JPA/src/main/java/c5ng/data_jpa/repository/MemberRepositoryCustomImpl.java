package c5ng.data_jpa.repository;

import c5ng.data_jpa.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {
    private final EntityManager em;

    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m")
                .getResultList();
    }
}
