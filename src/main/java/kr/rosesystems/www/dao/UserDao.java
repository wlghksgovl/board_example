package kr.rosesystems.www.dao;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.rosesystems.www.dto.Paging;
import kr.rosesystems.www.dto.User;

@Repository
public class UserDao implements IDao{

	@Autowired
	private JdbcTemplate jdbcTmp;
	
	@Value("#{sql['user.insert']}")
	private String insert;
	@Value("#{sql['user.getAll']}")
	private String getAll;
	@Value("#{sql['user.getUser']}")
	private String getUser;
	@Value("#{sql['user.deleteUser']}")
	private String deleteUser;
	@Value("#{sql['user.updateUser']}")
	private String updateUser;
	@Value("#{sql['user.page']}")
	private String page;
	@Value("#{sql['user.count']}")
	private String count;
	
	@Override
	public int insert(User user) {
		
		return jdbcTmp.update(
				insert,
				toEn(user.getU_name()), 
				user.getU_pw(), 
				toEn(user.getU_contents()));
	}

	@Override
	public User[] getAll(Paging paging) {

		int totalCount = jdbcTmp.queryForInt(count);
		paging.setTotalCount(totalCount);
		
		List<User> sList = jdbcTmp.query(page, new UserMapper(), paging.getViewPage(), paging.getPageSize());

		return sList.toArray(new User[0]);
	}
	


	@Override
	public User getContent(String u_num) {
		List<User> list = jdbcTmp.query(getUser, new UserMapper(), u_num);
		return list.get(0);
	}

	@Override
	public int delete(String u_num) {
		return jdbcTmp.update(deleteUser, u_num);
	}

	@Override
	public int update(String u_num, String u_contents) {
		return jdbcTmp.update(
				updateUser,
				toEn(u_contents),
				u_num);
	}
	
	@Override
	public String pwChk(String  u_num, String  c_pw){
		String  pw = getContent(u_num).getU_pw();
		System.out.println(pw);
		if(c_pw.equals(pw)){
			return null;
		}else{
			return "password Error";
		}
	}
	
	//User의 멤버변수에 할당
	class UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int idx) throws SQLException {
			
			return new User(
					rs.getString("u_num"),
					toKor(rs.getString("u_name")),
					rs.getString("u_pw"),
					toKor(rs.getString("u_contents")));
		}
		
	}
	
	//한글->byte, byte->한글
	private String toKor(String en){
		String kor = null;
		try{
			kor = new String(en.getBytes("8859_1"), "euc_kr");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return kor;
	}
	private String toEn(String kor){
		String en = null;
		try{
			en = new String(kor.getBytes("euc_kr"), "8859_1");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return en;
	}

}

















