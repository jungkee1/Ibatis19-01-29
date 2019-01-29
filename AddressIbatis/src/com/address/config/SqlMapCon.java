package com.address.config;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapCon { 
	private static SqlMapClient sqlMap; //static은 가장 먼저 실행됨
	static {
		
		try {
			String resource="com/address/config/SqlMapConfig.xml"; // 이 파일을 읽어온다
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlMapClient getSqlMapInstacne() {
		return sqlMap;
	}

}
