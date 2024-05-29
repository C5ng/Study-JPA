package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity // pk 정의 필수
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq") SEQUENCE 관리
public class MemberTest {
    @Id
    @GeneratedValue // IDENTITY, SEQUENCE, TABLE, AUTO
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId; // 객체가 아닌 테이블에 모델링

    @ManyToOne
    @JoinColumn(name = "TEAM_ID") // join하는 컬럼 즉 여기선 MemberTest에 TEAM_ID Column
    private Team team; // teamId를 아예 Team으로 선언한다. -> 서로 관계를 정의해야함 ex) 1:N, 1:1 ...

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Long getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(Long teamId) {
//        this.teamId = teamId;
//    }
}
