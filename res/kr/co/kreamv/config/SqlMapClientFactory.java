package kr.co.kreamv.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	private static SqlMapClient smc;
	
	static {
		try {
			Charset charset = Charset.forName("utf-8");
			
			Resources.setCharset(charset);

			Reader reader = Resources.getResourceAsReader("kr/co/kreamv/config/sqlMapConfig.xml");
			
			smc = SqlMapClientBuilder.buildSqlMapClient(reader);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlMapClient getSqlMapClient() {
		return smc;
	}
	
	
}
