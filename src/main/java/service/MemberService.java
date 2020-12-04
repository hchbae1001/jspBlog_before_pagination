package service;

import domain.Member;

import java.util.List;

public interface MemberService {
    Member getMember(long id);		// primary key에 해당하는 id로  조회
    List<Member> getMembers(); // 모든 사용자 조회
    List<Member> getMembersByNameEmail(String email); // email로 조회
    List<Member> getMemberByName(String name); // name으로 조회
    List<Member> getMemberByPage(int index, int size); // 페이지로 조회
    int postMember(Member member); // 생성
    int updateMember(Member member); // 수정
    int deleteMember(long id); // 삭제
}
