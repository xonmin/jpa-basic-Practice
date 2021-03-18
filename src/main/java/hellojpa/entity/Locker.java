package hellojpa.entity;

import javax.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue
    private Long id;


    private String name;

    // locker도 양방향으로 멤버를 알고 싶다면
    @OneToOne(mappedBy = "locker") // 읽기 전용
    private Member member;

}
