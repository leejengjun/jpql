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
//            for (int i = 0; i < 100; i++){
//                Member member = new Member();
//                member.setUsername("member" + i);
//                member.setAge(i);
//                em.persist(member);
//            }
            // JPQL 기본문법 파트
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("관리자");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//
//            member.setTeam(team);
//
//            em.persist(member);
            
            //JPQL 기본함수 파트 
            Member member1 = new Member();
            member1.setUsername("관리자1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            em.persist(member2);


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

//            // new 명령어로 조회
//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            MemberDTO memberDTO = result.get(0);
//            System.out.println("memberDTO = " + memberDTO.getUsername());
//            System.out.println("memberDTO = " + memberDTO.getAge());

            //페이징 쿼리
//            String query = "select m from Member m order by m.age desc";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();

//            System.out.println("result.size = " + result.size());
//            for (Member member1 : result){
//                System.out.println("member1 = " + member1);
//            }

//            String query = "select m from Member m, Team t where m.username = t.name";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());

            // 조인 대상 필터링(예: 회원과 팀을 조인하면서, 팀 이름이 A인 팀만 조인
//            String query = "select m from Member m left join m.team t on t.name = 'teamA'";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());

//            // 연관관계 없는 엔티티 외부 조인(예: 회원의 이름과 팀의 이름이 같은 대상 외부 조인)
//            String query = "select m from Member m left join Team t on m.username = t.name";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());

            // 서브쿼리 FREOM 절의 서브 쿼리는 현재 JPQL에서 불가능
//            String query = "select mm.age, mm.username " +
//                    " from (select m.age, m.username from Member m) as mm";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());

            // ENUM 타입
//            String query = "select m.username, 'HELLO', true From Member m " +
//                    "where m.type = jpql.MemberType.USER";
//            List<Object[]> result = em.createQuery(query)
//                    .getResultList();

            // ENUM 타입
//            String query = "select m.username, 'HELLO', true From Member m " +
//                    "where m.type = :userType";
//            List<Object[]> result = em.createQuery(query)
//                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : result){
//                System.out.println("objects = " + objects[0]);
//                System.out.println("objects = " + objects[1]);
//                System.out.println("objects = " + objects[2]);
//            }

//            String query =
//                    "select " +
//                            "case when m.age <= 10 then '학생요금'" +
//                            "     when m.age >= 60 then '경로요금'" +
//                            "     else '일반요금' " +
//                            "end " +
//                    "from Member m";
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m ";
//            String query = "select nullif(m.username, '관리자') as username " +
//                    "from Member m ";
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = "+ s);
//            }

            // JPQL 기본 함수
//            String query = "select 'a' || 'b' From Member m"; //CONCAT
//            String query = "select substring(m.username, 2, 3) From Member m";  //SUBSTRING
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = "+ s);
//            }

//            String query = "select locate('de', 'abcdefg') From Member m";  //LOCATE

//            String query = "select size(t.members) From Team t ";
//
//            List<Integer> result = em.createQuery(query, Integer.class)
//                    .getResultList();
//
//            for (Integer s : result) {
//                System.out.println("s = "+ s);
//            }
            String query = "select function('group_concat', m.username) from Member m ";

            List<String> result = em.createQuery(query, String.class)
                    .getResultList();

            for (String s : result) {
                System.out.println("s = "+ s);
            }

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
