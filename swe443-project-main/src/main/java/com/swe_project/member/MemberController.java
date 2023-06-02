package com.swe_project.member;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController<GreetingService> {
    
    MemberService srvc;
    
    @GetMapping("/member")
    public String profileForm(Model model) {
      model.addAttribute("member", new Member());
      return "member";
    }

    @PostMapping("/member/profile")
    public String greetingSubmit(@ModelAttribute Member member, Model model) {
      model.addAttribute("member", member);
      srvc.saveMember(member);
      return "result";
  }
}

