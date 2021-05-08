package hellojpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)  //상속관계 매핑 방법
@DiscriminatorColumn  // 하위 엔티티들을 구별하게 해주는  DTYPE 칼럼을  생성하게  해준다. 없어도 할 수 있긴함 하지만 싱글테이블 전략에서는 무조건 필요
@Getter @Setter
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;

}
