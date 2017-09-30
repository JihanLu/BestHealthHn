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
 * 论坛帖子管理(实体类)
 * @author By：
 * @param topicId 帖子ID
 * @param title 标题
 * @param topicUserID 发表帖子的用户ID
 * @param content 内容
 */
@Entity
@Table(name="topic")
public class Topic {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long topicID;
	@Column
	private String title;
	@Column
	private long topicUserID;
	@Column(length=16777216)
	private String content;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;
	
	public long getTopicID() {
		return topicID;
	}
	public void setTopicID(long topicID) {
		this.topicID = topicID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getTopicUserID() {
		return topicUserID;
	}
	public void setTopicUserID(long topicUserID) {
		this.topicUserID = topicUserID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Topic [topicID=" + topicID + ", title=" + title + ", topicUserID=" + topicUserID + ", content=" + content + ", time=" + time + "]";
	}
	
}
