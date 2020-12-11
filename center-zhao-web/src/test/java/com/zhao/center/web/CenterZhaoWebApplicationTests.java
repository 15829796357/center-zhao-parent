package com.zhao.center.web;

import com.zhao.center.api.SysMenuService;
import com.zhao.center.api.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
@TestComponent
class CenterZhaoWebApplicationTests {

	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired


	@Test
	void contextLoads() {
		sysMenuService.findMenuAll();
	}

	@Test
	public void test(){
	}
}
