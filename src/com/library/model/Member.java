package com.library.model;

import java.io.Serializable;

import com.library.dao.MemberDao;
import com.library.dao.MemberDaoImpl;

public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberId;
	private String name;
	private String address;
	private String type;
	private String password;
	MemberDao mb = new MemberDaoImpl();

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String memberId, String name, String address, String type, String password) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.address = address;
		this.type = type;
		this.password = password;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println(name);
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println(address);
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		System.out.println(type);
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Member getMemberInfo() {
		return (mb.getMemberData(this.memberId));
	}

	public boolean getChangePassword() {
		return mb.changePassword(this.memberId, this.password);
	}

	public int getAddMember() {
		return (mb.addMember(this));
	}

	public boolean getUpdateMember() {
		return (mb.updateMember(this));
	}

	public boolean getDeleteMember() {
		return (mb.deleteMember(this));
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", address=" + address + ", type=" + type
				+ ", password=" + password + "]";
	}

}
