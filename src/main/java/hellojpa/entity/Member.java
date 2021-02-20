package hellojpa.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;
    @Column(name = "name",nullable = false, length = 10, columnDefinition = "varchar(100) default 'EMPTY'")
    private String name;

    @Column(precision = 10, scale = 2) //pre - 소수점포함 자릿수 scale = 소수 자리수
    private BigDecimal age;

    @Enumerated(EnumType.STRING) //enum으로 관리
    //enum ordinal 로하면 enum 의 새로운 녀석이 들어가면 관리하기 어려워진다. (구분 불가)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) //temporal -> date/time/timestamp
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //위에 temporal은 LocalDateTime 사용하면 @temporal 생략 가능
    private LocalDateTime createdAt;

    @Lob    //길이제한 없는 string field  크기가 큰 데이터형태
    //필드 타입이 문자면 clob 매핑/ 나머지는 Blob매핑
    private String description;

    @Transient //   특정 필드를 칼럼에 매핑하지 않고 싶을 떄(매핑 무시)
    private  int temp;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setName(String name) {
        this.name = name;
    }
//
}
