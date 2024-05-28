package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // pk 정의 필수
public class Member {
    @Id
    private Long id;
    @Column(unique = true, length = 10) // unique 제약조건, 길이 제한 등 @Column 속성으로 여러 조건 추가 가능
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
