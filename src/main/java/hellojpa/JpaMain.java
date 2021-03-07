package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.RoleType;
import hellojpa.entity.Team;

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
            Team team = new Team();
            team.setName("XonminTeam");
            em.persist(team);

            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            //2. 나가는 쿼리문을 직접 보고 싶을 때화
            //영속성 컨텍스트에 쌓여있는 쿼리 강제 전송
            em.flush();
            //영속성 컨텍스트초기화
            em.clear();


            // 1.셀렉트 쿼리문이 없는 이유, 이미 영속성컨텍스트에서 가져와 1차캐시에 있기 때문에
            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for(Member m : members ){
                System.out.println(m.getName());
            }


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
