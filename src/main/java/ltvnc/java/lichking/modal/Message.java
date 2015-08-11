package ltvnc.java.lichking.modal;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ltvnc.java.lichking.modal.User;

@Component
public class Message {
	private int id;
	private User sourceUser;
	private User targetUser;
	private String message;
	private Date time;
	@Autowired
	private ltvnc.java.lichking.entity.Message messageEntity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getSourceUser() {
		return sourceUser;
	}

	public void setSourceUser(User sourceUser) {
		this.sourceUser = sourceUser;
	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public ltvnc.java.lichking.entity.Message createEntity() {
		messageEntity.setId(id);
		messageEntity.setMessage(message);
		messageEntity.setTime(time);
		messageEntity.setSourceUser(sourceUser.createEntity());
		messageEntity.setTargetUser(targetUser.createEntity());
		return messageEntity;
	}
}
