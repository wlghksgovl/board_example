package kr.rosesystems.www.dao;

import kr.rosesystems.www.dto.Paging;
import kr.rosesystems.www.dto.User;

public interface IDao {

	int insert(User user);
	User[] getAll(Paging paging);
	User getContent(String u_num);
	int delete(String u_num);
	int update(String u_num, String u_contents);
	String pwChk(String  u_num, String  c_num);
}
