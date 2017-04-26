package com.library.dao;

import java.util.ArrayList;

import com.library.model.Member;

public interface MemberDao {
	int addMember(Member member);
	
	Member getMemberData(String memberId);

	boolean updateMember(Member member);

	boolean deleteMember(Member member);

	boolean validateMember(String memberId, String password, String type);

	boolean changePassword(String memberId, String password);

	ArrayList<Member> retrieveAll();
}
