package com.bst.util;

public class ModelParam {
	/*fa_Id 发帖人ID  
	content评论内容
	hui_ID  评论人ID 
	topicID 帖子id
	*/
	private long beihuiID;
	private long fa_Id;
	private long topicID;
	private String content;
	private long repltOneID;//一级评论的id
	public long getRepltOneID() {
		return repltOneID;
	}
	public void setRepltOneID(long repltOneID) {
		this.repltOneID = repltOneID;
	}
	public long getBeihuiID() {
		return beihuiID;
	}
	public void setBeihuiID(long beihuiID) {
		this.beihuiID = beihuiID;
	}
	public long getFa_Id() {
		return fa_Id;
	}
	public void setFa_Id(long fa_Id) {
		this.fa_Id = fa_Id;
	}
	public long getTopicID() {
		return topicID;
	}
	public void setTopicID(long topicID) {
		this.topicID = topicID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ModelParam [beihuiID=" + beihuiID + ", fa_Id=" + fa_Id + ", topicID=" + topicID + ", content=" + content
				+ ", repltOneID=" + repltOneID + "]";
	}
	
}
