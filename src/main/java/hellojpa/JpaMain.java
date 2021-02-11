package hellojpa;

import hellojpa.entity.Member;

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


        //조회
            //Member findMember = em.find(Member.class, 1L);
            List<Member> result = em.createQuery("select  m from Member m", Member.class)
                    .setFirstResult(100)
                    .setMaxResults(8)
                    .getResultList();

            for(Member member : result){
               System.out.println("member.name = "+ member.getName());
           }




            tx.commit();
        }catch (Exception e) { //에러시
         tx.rollback();
        }finally {
            em.close();
        }

        emf.close();


    }
}
