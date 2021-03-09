package hellojpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team {

    @Id @GeneratedValue
    private Long id;

    private String name;

    // teaM의 입장에선 본인이 하나 연결된 팀원이 여러명
    @OneToMany(mappedBy = "team") //member에 무슨 변수와 매핑되어잇는지
    private List<Member> members = new ArrayList<>();


    private void addMember(Member member){
        member.setTeam(this);
        members.add(member);
    }
}
