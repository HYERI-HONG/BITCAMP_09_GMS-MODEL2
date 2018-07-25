package domain;

import lombok.Data;

@Data
public class MemberBean {
	private String userId,ssn,name,roll,teamId,password,age;

	@Override
	public String toString() {
		return "MemberBean [userId=" + userId + ", ssn=" + ssn + ", name=" + name + ", roll=" + roll + ", teamId="
				+ teamId + ", password=" + password + ", age=" + age + ", toString()=" + super.toString() + "]";
	}

	

	
}
