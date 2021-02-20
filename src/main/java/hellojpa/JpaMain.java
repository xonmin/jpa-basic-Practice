package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.RoleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        //JpA 의 모든 데이터 변경은 트랜잭션 안에서 실행해여한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("A");
            member.setRoleType(RoleType.USER);




           System.out.println("==================================");
            tx.commit();
        }catch (Exception e) { //에러시
         tx.rollback();
        }finally {
            em.close();
        }

        emf.close();


    }
}
