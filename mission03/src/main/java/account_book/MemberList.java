package account_book;

import java.util.ArrayList;
import java.util.List;

public class MemberList {
    private List<Member> memberList;

    public MemberList(){
        memberList = new ArrayList<>();
    }

    public boolean checkMemberList(Member compareVo){
        boolean hasMember;

        for (Member member : memberList) {
            if(compareVo.equals(member)){
                return true;
            }
        }

        return false;
    }

    public void addMember(Member member){
        if(member.isPasswordType()){
            memberList.add(member);
        }
    }

    public Member getMember(Member loginMember){
        for (Member member : memberList) {
            if(member.equals(loginMember)){
                return member;
            }
        }
        return null;
    }

    public void printRecords(Member loginMember){
        Member member = getMember(loginMember);


    }
}
