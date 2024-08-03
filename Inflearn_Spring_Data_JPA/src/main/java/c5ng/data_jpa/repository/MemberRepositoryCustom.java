package c5ng.data_jpa.repository;

import c5ng.data_jpa.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
