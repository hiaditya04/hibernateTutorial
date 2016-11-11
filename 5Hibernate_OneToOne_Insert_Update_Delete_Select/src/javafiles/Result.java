package javafiles;

public class Result {
	private int rollNumber;
	private int mathsMarks;
	private int scienceMarks;	
	private int totalMarks;
	private Pupil pupil;
	
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int getMathsMarks() {
		return mathsMarks;
	}
	public void setMathsMarks(int mathsMarks) {
		this.mathsMarks = mathsMarks;
	}

	public int getScienceMarks() {
		return scienceMarks;
	}
	public void setScienceMarks(int scienceMarks) {
		this.scienceMarks = scienceMarks;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public Pupil getPupil() {
		return pupil;
	}
	public void setPupil(Pupil pupil) {
		this.pupil = pupil;
	}
	
}
