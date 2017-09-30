package com.bst.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 类名：管理员
 * @author By：
 * @param adminsID id
 * @param adminsName 用户名(账户)
 * @param password 密码
 * @param time 注册时间
 */
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long adminsID;
	@Column
	private String adminsName;
	@Column
	private String password;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;
	@Column
	private String phone;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public long getAdminsID() {
		return adminsID;
	}
	public void setAdminsID(long adminsID) {
		this.adminsID = adminsID;
	}
	public String getAdminsName() {
		return adminsName;
	}
	public void setAdminsName(String adminsName) {
		this.adminsName = adminsName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Admin [adminsID=" + adminsID + ", adminsName=" + adminsName + ", password=" + password + ", time="
				+ time + ", phone=" + phone + "]";
	}
	
}
