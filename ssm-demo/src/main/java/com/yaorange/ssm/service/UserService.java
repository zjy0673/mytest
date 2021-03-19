package com.yaorange.ssm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yaorange.ssm.mapper.UserMapper;
import com.yaorange.ssm.pojo.User;
import com.yaorange.ssm.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public ResultVO<User> findByPage(Integer page, Integer limit) {
        ResultVO<User> resultVO = new ResultVO<User>();
        resultVO.setCode(0);

        //分页助手分页
        PageHelper.startPage(page,limit);
        //select count(id) from tb_user
        //select * from tb_user limit 0,limit
        Page<User> pageInfo = (Page<User>) userMapper.findAll();
        resultVO.setData(pageInfo);
        resultVO.setCount(pageInfo.getTotal());


        return resultVO;
    }

    public void save(User user) {
        userMapper.insertUser(user);
    }

    public void update(User user) {
        userMapper.updateUser(user);
    }

    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }
}
