package hellojpa.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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

}
