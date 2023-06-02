package com.swe_project.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberService {
    
    MemberRepository grepository;
    
public void saveMember(Member member)
{
	
	grepository.save(member);
	
}


}
