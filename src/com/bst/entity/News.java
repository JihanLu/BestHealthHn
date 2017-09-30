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
 * 资讯新闻(实体类)
 * @author By：
 * @param title 标题
 * @param photo 图片
 * @param content 内容
 * @param startTime 创建时间
 * @param endTime 最后修改时间
 */
@Entity
@Table(name="news")
public class News {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
	private String author;
	@Column
	private String sources;
	@Column
	private String title;
	@Column
	private String photo;
	@Column(length=16777216)
	private String content;
	@Column
	private int topid;
	@Column
	private long clicks;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSources() {
		return sources;
	}
	public void setSources(String sources) {
		this.sources = sources;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getTopid() {
		return topid;
	}
	public void setTopid(int topid) {
		this.topid = topid;
	}
	public long getClicks() {
		return clicks;
	}
	public void setClicks(long clicks) {
		this.clicks = clicks;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", author=" + author + ", sources=" + sources + ", title=" + title + ", photo="
				+ photo + ", content=" + content + ", topid=" + topid + ", clicks=" + clicks + ", time=" + time + "]";
	}
}
