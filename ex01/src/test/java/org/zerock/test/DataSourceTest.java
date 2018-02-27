package org.zerock.test;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {

	@Inject
	private DataSource ds;
	
	@Test
	public void testConection()throws Exception{
		
		try(Connection con = ds.getConnection()){
			
			System.out.println(con);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*
(5)161.DataSourceTest는 설정된 DataSource를 자동으로 주입받을 수 있게 한다.
자동으로 Connection 객체가 close()될 수 있도록 작성
실행결과로 Connection 객체가 만들어지는 것을 확인
그리고 테이블 생성작업
*/