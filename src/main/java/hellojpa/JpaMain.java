package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.Movie;
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

            Movie movie = new Movie();
            movie.setActor("bbb");
            movie.setDirector("aaaa");
            movie.setName("바람과함꼐사라지다");
            movie.setPrice(10000);

            em.flush();
            em.persist(movie);
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println(" findMovie  =  " + findMovie);


            tx.commit();
        }catch (Exception e) { //에러시
         tx.rollback();
        }finally {
            em.close();
        }

        emf.close();


    }
}
