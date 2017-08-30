package cn.author.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;

import cn.author.common.utils.ResponseUtils;
import cn.author.entity.User;
import cn.author.entity.UserExample;
import cn.author.entity.UserExample.Criteria;
import cn.author.mapper.UserMapper;
@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="list")
	public String listUser(Model model){
		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		List<User> userList = userMapper.selectByExample(userExample);
		model.addAttribute("list", userList);
		return "user";
	}
	
	@RequestMapping(value="toUserList")
	public String toUserList(){
		return "userList";
	}
	
	@RequestMapping(value="listPage")
	public void listPageUser(Integer page,Integer rows,HttpServletRequest request,HttpServletResponse response){
		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		PageHelper.startPage(page, rows);
		List<User> userList = userMapper.selectByExample(userExample);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", userList);
		ResponseUtils.renderJson(response, jsonObject.toString());

	}

}
