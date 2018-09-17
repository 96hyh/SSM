package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lenovo
 */
@Controller
@RequestMapping("user")
public class UserController {


    /**
     * 注入service
     */
    @Autowired
    private IUserService userService;


    @RequestMapping("lists")
    @ResponseBody
    public List<User> queryUserList() {
        return userService.queryUserList();
    }

 /*   @RequestMapping("list")
    public String toUsers(){
        return "list";
    }
*/

    /**
     * 通用的页面跳转方法
     */
    @RequestMapping("{pageName}")
    public String toPage(@PathVariable("pageName") String pageName) {
        return pageName;
    }


    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    @ResponseBody
    public void insert(@RequestParam("name") String name, @RequestParam("birthday") String birthday) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date birthday1 = df.parse(birthday);
        User user = new User();
        user.setBirthday(birthday1);
        user.setName(name);
        userService.addUsers(user);

    }


}
