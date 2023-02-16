package cn.targetpath.community.controller;

import cn.targetpath.community.entity.DiscussPost;
import cn.targetpath.community.entity.User;
import cn.targetpath.community.service.DiscussPostService;
import cn.targetpath.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DengBo_Zhong
 * @version V1.0
 * @date 2023/2/16 23:05
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscussPostService discussPostService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        List<DiscussPost> discussPosts = discussPostService.findDiscussPosts(0, 0, 10);
        List<Map<String, Object>> discussPost = new ArrayList<>();
        if (discussPosts != null) {
            for (DiscussPost post : discussPosts) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", discussPost);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPost.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/view";
    }
}
