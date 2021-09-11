package com.moviewiki.api.user.controller;

import com.moviewiki.api.news.domain.News;
import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserManagementController {
    private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserManagementService userManagementService;

    // 메인페이지 call
    @GetMapping("/")
    public String mainPage() {
        return "/main";
    }

    // 로그인 form call
    @RequestMapping("/login")
    public void loginPage() {
        log.info("/loginPage");
    }

    // 로그인 오류 메시지
    @GetMapping("/loginFail")
    public void loginFail() {
    }

    // 로그인 성공시 이동할 페이지
    @RequestMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user, Map<String, Object> model,
                               SecurityContextHolderAwareRequestWrapper requestWrapper) {
        log.info("user = " + user);
        String nextPage = null;
        if (user == null) {
            model.put("message", "유효하지 않은 데이터");
            nextPage = "redirect:/denied";
        } else {
            if (requestWrapper.isUserInRole("ADMIN")) {
                nextPage = "redirect:/admin/admin_news";
            } else {
                model.put("currentMemberId", user.getUsername());
                nextPage = "redirect:/";
            }
        }
        return nextPage;
    }

    // 비정상 접속시 접근 불가 페이지
    @GetMapping("/denied")
    public String deniedPage() {
        return "denied";
    }

    // 회원가입을 위한 form call
    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("user", new User());
        log.info("/join");
        return "join";
    }

    // 회원가입 -> 패스워드 암호화 및 DB insert
    @PostMapping("/createUser")
    public String createUser(User user) {
        user.setUserPw(passwordEncoder.encode(user.getUserPw()));
        userManagementService.createUser(user);
        return "redirect:/login";
    }

    // mypage form call
    @GetMapping("/member/mypage")
    public String mypageMain(Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {
        model.addAttribute("user", userManagementService.getUser(user.getUsername()));
        return "/member/mypage";
    }

    // 회원 탈퇴
    @RequestMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userManagementService.deleteUser(userId);
        return "redirect:/logout";
    }

    // 회원정보 수정 -> DB 저장
    @PostMapping("/updateUser/{userId}")
    public String updateUser(User user) {
        log.info("userId = "+ user.getUserId());
        user.setUserPw(passwordEncoder.encode(user.getUserPw()));
        userManagementService.updateUser(user);
        return "redirect:/member/mypage";
    }

    // 회원정보 수정 form call
    @GetMapping("/member/modify_info")
    public String modifyInfoPage(Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {
        model.addAttribute("user", userManagementService.getUser(user.getUsername()));
        return "/member/modify_info";
    }

}
