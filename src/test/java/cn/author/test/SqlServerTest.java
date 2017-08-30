package cn.author.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.author.common.utils.SpringJunitTest;
import cn.author.entity.User;
import cn.author.entity.UserExample;
import cn.author.entity.UserExample.Criteria;
import cn.author.mapper.UserMapper;

public class SqlServerTest extends SpringJunitTest{
	@Autowired
	private UserMapper userMapper;
	
/*	@Test
	public void sqlServerTest02(){		
		TCsCaseSatisfactionExample tCsCaseSatisfactionExample = new TCsCaseSatisfactionExample();		
		cn.author.entity.TCsCaseSatisfactionExample.Criteria tCsCaseSatisfactionCriteria=tCsCaseSatisfactionExample.createCriteria();
		tCsCaseSatisfactionCriteria.andPkidBetween(2l, 60l);
		PageHelper.startPage(2, 10);
		List<TCsCaseSatisfaction> list = tCsCaseSatisfactionMapper.selectByExample(tCsCaseSatisfactionExample);
		for (TCsCaseSatisfaction tCsCaseSatisfaction : list) {
			System.out.println("getPkid:"+
					" getCreateTime:"+tCsCaseSatisfaction.getCreateTime());
		}
	}*/
	
	@Test
	public void test1(){
		UserExample userExample = new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		Criteria userCriteria = createCriteria;
		PageHelper.startPage(2, 3);
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
