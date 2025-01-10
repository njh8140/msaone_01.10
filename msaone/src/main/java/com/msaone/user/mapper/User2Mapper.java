package com.msaone.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.msaone.user.model.UserVO;

@Mapper
public interface User2Mapper {

	List<UserVO> selectUserList();
	void insertUser(String id, String name);
	UserVO selectById(String id);
	void deleteUser(String id);
	void updateUser(String id, String name);
}