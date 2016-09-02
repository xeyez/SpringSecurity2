package io.github.xeyez.persistence;

import io.github.xeyez.domain.UserVO;

public interface UserDAO {

	UserVO getUser(String userid)throws Exception;
	
	void createUser(String userid, String userpw, String username, String role);
	
	void updateUser(String userid, String userpw, String username, String role);
	
	void deleteUser(String userid);
	
	void changePassword(String userid, String userpw);
	
	boolean userExists(String userid);
}
