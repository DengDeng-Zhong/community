package cn.targetpath.community.controller;

import cn.targetpath.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * 测试类
 *
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/15 20:55
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/alpha")
    @ResponseBody
    public String hello(){
        return "hello alpha";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    /**
     * http请求和响应参数
     * @param request
     * @param response
     */
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            System.out.println(name+"--"+request.getHeader(name));
        }
        System.out.println(request.getParameter("code"));

        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("<H1>返回网页</H1>");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * 第一种传参方式
     * /students?current=1&limit=2
     * @param current
     * @param limit
     * @return
     */
    @RequestMapping(path ="/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current",required = false,defaultValue ="1") int current,
            @RequestParam(name = "limit",required = false,defaultValue ="10") int limit
    ){
        System.out.println(current);
        System.out.println("----------");
        System.out.println(limit);
        return "some students";
    }

    /**
     * 第二种传参方式
     * /student/1
     * @param id
     * @return
     */
    @RequestMapping(path ="/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id")int id){
        System.out.println(id);
        return "a student";
    }

    /**
     * 从页面取回数据
     * @param name
     * @param age
     * @return
     */
    @ResponseBody
    @RequestMapping(path ="/student",method = RequestMethod.POST)
    public String saveStudent(String name,int age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "success";
    }

    /**
     * 数据展示到页面  响应数据
     * @return
     */
    @RequestMapping(path ="/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.addObject("age",12);
        modelAndView.setViewName("/view");
        return modelAndView;
    }



    @RequestMapping(path ="/school", method = RequestMethod.GET)
    public String school(Model model){
        model.addAttribute("name","GTE");
        model.addAttribute("age",19);
        return "/view";

    }

    @RequestMapping(path ="/emp",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList<>();

        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",25);
        emp.put("salary",15000);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name","李思");
        emp.put("age",22);
        emp.put("salary",12000);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name","王武");
        emp.put("age",32);
        emp.put("salary",25000);
        list.add(emp);

        return list;
    }
}
