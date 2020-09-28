package com.oy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class LoginController {
    @RequestMapping("/loginForm")
    public String loginForm(HttpServletRequest request){
        System.out.println("loginController  loginForm 中--："+request.getServletPath());
        return "/login";
    }
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpSession httpSession, @RequestParam("inputUsername") String username, @RequestParam("inputPassword") String password, Model model){
        if(username.equals("oy") && password.equals("123")){
            httpSession.setAttribute("username",username);
            System.out.println("loginController  login 中--："+request.getServletPath());
            return "redirect:/test";
        }else {
            model.addAttribute("message","密码或者用户名错误");
            System.out.println("loginController 2 login 中--："+request.getServletPath());
            return "login";
        }
    }
    @RequestMapping("/success")
    public String loginSuccess(HttpSession httpSession ,Model model){
        return "loginSuccess";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession,HttpServletRequest request){
        httpSession.invalidate();
        System.out.println("loginController  logout 中--："+request.getServletPath());
        return "login";
    }
    @RequestMapping("/test")
    public String testt(HttpServletRequest request){
        System.out.println("LoginController test中--："+request.getServletPath());
        return "loginSuccess";
    }
}
