package hello.hellospring.domain;

import javax.persistence.*;

//jpa 적용을 위해 Entity 어노테이션 적용
@Entity
public class Member {//멤버가 가지고 있는 정보는 아이디와 이름이다. getter, setter는 기본적으로 따로 만들어주었다.

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
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
