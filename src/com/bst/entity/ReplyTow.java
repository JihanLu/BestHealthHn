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
 * 论坛二级回复(实体类)
 * @author By：
 * @param replyOneId 一级回复ID
 * @param topicID 帖子ID
 * @param beihuifuID 被回复的id
 * @param huifuID //回复的id
 * @param content 内容
 * @param replyTime 回复时间
 * 
 */
@Entity
@Table(name="replyTow")
public class ReplyTow {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long replyTowID;
	@Column
	private long replyOneID;
	@Column
	private long topicID;
	@Column
	private long huifuID;
	@Column
	private long beihuifuID;
	@Column(length=16777216)
	private String content;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date replyTime;
	public long getReplyTowID() {
		return replyTowID;
	}
	public void setReplyTowID(long replyTowID) {
		this.replyTowID = replyTowID;
	}
	public long getReplyOneID() {
		return replyOneID;
	}
	public void setReplyOneID(long replyOneID) {
		this.replyOneID = replyOneID;
	}
	public long getTopicID() {
		return topicID;
	}
	public void setTopicID(long topicID) {
		this.topicID = topicID;
	}
	public long getHuifuID() {
		return huifuID;
	}
	public void setHuifuID(long huifuID) {
		this.huifuID = huifuID;
	}
	public long getBeihuifuID() {
		return beihuifuID;
	}
	public void setBeihuifuID(long beihuifuID) {
		this.beihuifuID = beihuifuID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	@Override
	public String toString() {
		return "ReplyTow [replyTowID=" + replyTowID + ", replyOneID=" + replyOneID + ", topicID=" + topicID
				+ ", huifuID=" + huifuID + ", beihuifuID=" + beihuifuID + ", content=" + content + ", replyTime="
				+ replyTime + "]";
	}
}
