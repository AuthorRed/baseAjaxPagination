package cn.author.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.author.common.utils.SpringJunitTest;
import cn.author.entity.User;
import cn.author.entity.UserExample;
import cn.author.entity.UserExample.Criteria;
import cn.author.mapper.UserMapper;

public class Testa extends SpringJunitTest{
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test1(){
		UserExample userExample = new UserExample();
		Criteria userCriteria = userExample.createCriteria();
		List<User> userList = userMapper.selectByExample(userExample);
		for (User user : userList) {
			System.out.println(user.toString());
		}
	}
	
	@Test
	public void testInsert(){
		User user = new User();
		user.setDate(new Date());
		user.setName("李四");
		userMapper.insertSelective(user);		
	}
}
