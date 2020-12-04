package service;

import domain.Member;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    @Override
    public Member getMember(long id) {
        return null;
    }

    @Override
    public List<Member> getMembers() {
        return null;
    }

    @Override
    public List<Member> getMembersByNameEmail(String email) {
        return null;
    }

    @Override
    public List<Member> getMemberByName(String name) {
        return null;
    }

    @Override
    public List<Member> getMemberByPage(int index, int size) {
        return null;
    }

    @Override
    public int postMember(Member member) {
        return 0;
    }

    @Override
    public int updateMember(Member member) {
        return 0;
    }

    @Override
    public int deleteMember(long id) {
        return 0;
    }
}
