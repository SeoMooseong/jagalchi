package com.spring.jagalchi.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.spring.jagalchi.model.MemberModel;

public interface MemberDAO {
	public ArrayList<MemberModel> selectAllMember();
	public MemberModel selectMemberById(@Param("id") String id);
	public MemberModel loginMember(@Param("id") String id, @Param("password") String password);
	public int insertMember(MemberModel member);
	public int deleteMember(@Param("id") String id);
	public int updateMember(MemberModel member);
}
