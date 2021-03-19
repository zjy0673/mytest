package com.yaorange.ssm.web;

import com.yaorange.ssm.pojo.User;
import com.yaorange.ssm.service.UserService;
import com.yaorange.ssm.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rest/user/")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("all")
    public List<User> findAll() {
        return userService.findAll();
    }

    //page=1&limit=10
    @GetMapping("/listByPage")
    public ResultVO<User> listByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit
    ) {
        return userService.findByPage(page, limit);
    }


    @PostMapping("/add")
    public void add(User user) {
        userService.save(user);
    }

    @PostMapping("/update")
    public void update(User user) {
        userService.update(user);
    }

    @PostMapping("/delete")
    public void delete(Integer id) {
        userService.deleteById(id);
    }
}
