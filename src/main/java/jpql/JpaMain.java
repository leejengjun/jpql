package jpql;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

        //    TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class); // 반환 타입이 명확할 때 사용
        //    TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
        //    Query query3 = em.createQuery("select m.username, m.age from Member m");    // 반환 타입이 명확하지 않을 때 사용
        //    List<Member> resultList = query1.getResultList();
//
//            for (Member member1 : resultList){
//                System.out.println("member1 = " + member1);
//            }

//            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//
//            System.out.println("result = " + result.getUsername());

            em.flush();
            em.clear();

            // 영속성 컨텍스트에 다 관리가 된다!
//            List<Member> result = em.createQuery("select m from Member m", Member.class)  // 엔티티 프로젝션
//                    .getResultList();

//            Member findMember = result.get(0);
//            findMember.setAge(20);

//            List<Team> result = em.createQuery("select m.team from Member m join m.team", Team.class) // 엔티티 프로젝션
//                    .getResultList();

//            em.createQuery("select o.address from Order o", Address.class)  // 임베디드 타입 프로젝션
//                    .getResultList();

//            List resultList = em.createQuery("select distinct m.username, m.age from Member m") // 스칼라 타입 프로젝션
//                            .getResultList();

//            // Object[] 타입으로 조회하기
//            List<Object[]> resultList = em.createQuery("select distinct m.username, m.age from Member m")
//                    .getResultList();
//
//            Object[] result = resultList.get(0);
//            System.out.println("username = " + result[0]);
//            System.out.println("age = " + result[1]);

            // new 명령어로 조회
            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList();

            MemberDTO memberDTO = result.get(0);
            System.out.println("memberDTO = " + memberDTO.getUsername());
            System.out.println("memberDTO = " + memberDTO.getAge());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
