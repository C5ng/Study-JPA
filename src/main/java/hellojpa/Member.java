package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity // pk 정의 필수
public class Member {
    @Id
    private Long id;

    @Column(name = "name") // unique 제약조건, 길이 제한 등 @Column 속성으로 여러 조건 추가 가능
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member() {
    }
}
