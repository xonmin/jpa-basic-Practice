package hellojpa.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.locks.Lock;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    //sequence 사용
    private Long id;

    @Column(name = "user_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) // member 입장에선 본인이 매니 그리고 팀(원)으로
    @JoinColumn(name = "team_id")
    private Team team;

    public void changeTeam(Team team) {  // 연관관계 편의 메소드
        this.team = team;
        team.getMembers().add(this);
    }
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker; //joincolumn 무조건 넣어
}
