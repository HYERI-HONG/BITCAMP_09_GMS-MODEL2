package domain;

public class ExamBean {
	private String memId, examSeq, score, month;
	private String subSeq,recordSeq;
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getExamSeq() {
		return examSeq;
	}
	public void setExamSeq(String examSeq) {
		this.examSeq = examSeq;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getSubSeq() {
		return subSeq;
	}
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}
	public String getRecordSeq() {
		return recordSeq;
	}
	public void setRecordSeq(String recordSeq) {
		this.recordSeq = recordSeq;
	}
	@Override
	public String toString() {
		return "시험 정보 [학생 ID = " + memId + ", 시험SEQ = " + examSeq + ", 점수 = " + score + ", 월 = " + month
				+ ", 과목 SEQ = " + subSeq + ", 성적SEQ =" + recordSeq + "]";
	}
	
}
