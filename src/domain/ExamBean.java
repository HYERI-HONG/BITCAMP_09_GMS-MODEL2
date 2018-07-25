package domain;

import lombok.Data;

@Data
public class ExamBean {
	private String memId, examSeq, score, month;
	private String subSeq,recordSeq;

	@Override
	public String toString() {
		return "시험 정보 [학생 ID = " + memId + ", 시험SEQ = " + examSeq + ", 점수 = " + score + ", 월 = " + month
				+ ", 과목 SEQ = " + subSeq + ", 성적SEQ =" + recordSeq + "]";
	}
	
}
