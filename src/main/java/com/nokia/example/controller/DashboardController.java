package com.nokia.example.controller;

import com.nokia.example.model.MyUserDetail;
import com.nokia.example.model.Person;
import com.nokia.example.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DashboardController {

    /*@Autowired
    private StudentPersistenceService studentPersistenceService;*/

    @Autowired
    public BaseService baseService;

    @RequestMapping("/index")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String index(Model model){
        model.addAttribute("name" , "hello world!!!");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        System.out.println("username = "+userDetails.getUsername());
        System.out.println("password = "+userDetails.getPassword());
        System.out.println("getAuthorities = "+userDetails.getAuthorities());
        System.out.println("isAccountNonExpired = "+userDetails.isAccountNonExpired());
        System.out.println("isAccountNonLocked = "+userDetails.isAccountNonLocked());
        System.out.println("isCredentialsNonExpired = "+userDetails.isCredentialsNonExpired());
        System.out.println("isEnabled = "+userDetails.isEnabled());

        model.addAttribute("auth" , userDetails.getAuthorities());

        return "index";
    }

    @RequestMapping("/edit1")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String edit1(@RequestParam(value = "name",required = false) String name,
                       @RequestParam(value = "age" , required = false) String age,Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        System.out.println("getAuthorities = "+userDetails.getAuthorities());
        model.addAttribute("status" , "Success!");
        model.addAttribute("name" , name);
        model.addAttribute("age" , age);
        model.addAttribute("auth" , userDetails.getAuthorities());

        return "index";
    }

    @RequestMapping("/edit2")
    @PreAuthorize("hasPermission('edit','ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String edit2(@RequestParam(value = "name",required = false) String name,
                        @RequestParam(value = "age" , required = false) String age,Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        System.out.println("getAuthorities = "+userDetails.getAuthorities());
        model.addAttribute("status" , "Success!");
        model.addAttribute("name" , name);
        model.addAttribute("age" , age);
        model.addAttribute("auth" , userDetails.getAuthorities());

        return "index";
    }

    @RequestMapping("/edit3")
    @PreAuthorize("hasRole('ROLE_EDIT')")
    public String edit3(@RequestParam(value = "name",required = false) String name,
                        @RequestParam(value = "age" , required = false) String age,Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        System.out.println("getAuthorities = "+userDetails.getAuthorities());
        model.addAttribute("status" , "Success!");
        model.addAttribute("name" , name);
        model.addAttribute("age" , age);
        model.addAttribute("auth" , userDetails.getAuthorities());
        return "index";
    }

    public MyUserDetail getUserDetail() {
        MyUserDetail user = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || (!auth.isAuthenticated())){
            return null;
        }
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            if (userDetails instanceof MyUserDetail) {
                user = ((MyUserDetail) userDetails);
            } else {
                //logger.info("Not able to get user name");
            }
        } else {
            //logger.info("Anonymous login");
        }
        return user;
    }

    @RequestMapping("/hello")
    @PreAuthorize("hasPermission('edit','ROLE_USER') or hasPermission('add' , 'ROLE_ADMIN')")
    public String hello(Model model){
        Person person = new Person();
        person.setName("kkkk");
        baseService.BaseInfo(person);
        model.addAttribute("name" , "hello world!!!");
        return "hello";
    }

    /*@RequestMapping("/students")
    public @ResponseBody  List<Map<String,Object>> getStudentDetials(){
        return studentPersistenceService.studentsDetials();
    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView root() {
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) throws Exception {
        /*String rand = (String) request.getSession().getAttribute("rand");
        String authcode = request.getParameter("authcode");

        if(StringUtils.isEmpty(rand)){
            throw new Exception("Rand is empty.");
        }

        if(StringUtils.isEmpty(authcode)){
            throw new Exception("Authcode is empty.");
        }

        if(!rand.equals(authcode)){
            throw new Exception("Wrong auth code.");
        }*/

        return "login";
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        //logger.info("Get logout request. method = " + request.getMethod() + ", parameters: " + request.getParameterMap());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            //logger.info("Tuser is login, try to log out");
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }else{
            //logger.info("Tuser is not login, nothing todo");
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDenied(Model model) {
        return "accessDenied";
    }

}
