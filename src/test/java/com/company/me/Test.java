package com.company.me;

import org.aspectj.lang.annotation.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( {"file:/src/main/webapp/WEB-INF/spring/root-context.xml,"
		+ "file:/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class Test {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
//	@Before
//	public void setUp() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
//	}
}
