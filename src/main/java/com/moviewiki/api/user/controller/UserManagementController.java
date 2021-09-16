package com.moviewiki.api.user.controller;

import com.moviewiki.api.user.domain.User;
import com.moviewiki.api.user.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserManagementController {
    private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserManagementService userManagementService;

    // 초기 메인페이지 call
    @GetMapping("/")
    public String initMainPage() {
        return "/main";
    }

    // 로그인 후 메인페이지
    @GetMapping("/main")
    public String MainPage(Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        model.addAttribute("currentUserId", currentUser.getUsername());
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
    public String loginSuccess(@AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser, Map<String, Object> model,
                               SecurityContextHolderAwareRequestWrapper requestWrapper) {
        log.info("currentUser = " + currentUser);
        String nextPage = null;
        if (currentUser == null) {
            model.put("message", "유효하지 않은 데이터");
            nextPage = "redirect:/denied";
        } else {
            if (requestWrapper.isUserInRole("ADMIN")) {
                nextPage = "redirect:/admin/admin_news";
            } else {
                model.put("currentUserId", currentUser.getUsername());
                nextPage = "redirect:/main";
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

    // 회원 탈퇴
    @RequestMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userManagementService.deleteUser(userId);
        return "redirect:/logout";
    }

    // 회원정보 수정 -> DB 저장
    @PostMapping("/updateUser/{userId}")
    public String updateUser(User user) {
        log.info("userId = " + user.getUserId());
        user.setUserPw(passwordEncoder.encode(user.getUserPw()));
        userManagementService.updateUser(user);
        return "redirect:/member/mypage";
    }

    // 회원정보 수정 form call
    @GetMapping("/member/modify_info")
    public String modifyInfoPage(Model model, @AuthenticationPrincipal org.springframework.security.core.userdetails.User currentUser) {
        model.addAttribute("currentUserId", currentUser.getUsername());
        model.addAttribute("currentUser", userManagementService.getUser(currentUser.getUsername()));
        return "/member/modify_info";
    }

    // 아이디 찾기 form call
    @GetMapping("/find_id")
    public String findIdPage() {
        return "/find_id";
    }

    // 아이디 찾기 DB 조회
    @PostMapping("/find_id")
    public String findId(HttpServletRequest request, Model model) {
        String userName = request.getParameter("userName");
        String userMail = request.getParameter("userMail");
        User user = userManagementService.findId(userName, userMail);
        model.addAttribute("user", user);
        return "find_id_result";
    }

    // 아이디 찾기 결과 페이지
    @RequestMapping("/find_id_result")
    public String findIdResult() {
        return "/login";
    }

    // 비밀번호 찾기 form call
    @GetMapping("/find_pw")
    public String findPwPage() {
        return "/find_pw";
    }

    // 비밀번호 찾기 DB 조회
//    @PostMapping("/find_pw")
//    public String findPw(HttpServletRequest request, Model model) {
//        String userId = request.getParameter("userId");
//        String userName = request.getParameter("userName");
//        String userMail = request.getParameter("userMail");
//        log.info("userId====== " + userId);
//        log.info("userName====== " + userName);
//        log.info("userMail====== " + userMail);
//        return "/change_pw";
//    }

    // 비밀번호 변경 페이지 form call
//    @GetMapping("/change_pw")
//    public String changePw() {
//        return "/";
//    }



}
