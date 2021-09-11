package com.moviewiki.api.user.controller;

import com.moviewiki.api.user.service.UserManagementService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MypageProcessController {
    private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    UserManagementService userManagementService;



    // check_pw form call
//    @GetMapping("/member/check_pw")
//    public String checkPwPage(Model model) {
//        return "/member/check_pw";
//    }

    // DB에 아이디와 패스워드가 일치하는 게 있는지 확인
//    @PostMapping("/member/check_pw")
//    public String checkPw(Model model, @AuthenticationPrincipal User user, String userPw) {
//        log.info("userPw===" + userPw);
//        String userId = user.getUsername();
//        com.moviewiki.api.user.domain.User currentUser = userManagementService.checkPw(userId, userPw);
//        log.info("currentUser" + currentUser);
//        if(currentUser == null) {
//            return "redirect:/member/check_pw";
//        }
//        return "/member/modify_info";
//    }


}
