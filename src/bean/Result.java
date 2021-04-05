package bean;

import java.io.Serializable;

public class Result implements Serializable {

	// Resultの情報をフィールドに定義
	private Integer student_id;
	private String semester;
	private String test_date;
	private String test_name;
	private Integer english;
	private Integer math;
	private Integer japanese;
	private Integer science;
	private Integer society;
	private Integer music;
	private Integer tech_home;
	private Integer physical;
	private Integer art;

	// getter,setterメソッド
	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getTest_date() {
		return test_date;
	}

	public void setTest_date(String test_date) {
		this.test_date = test_date;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	public Integer getMath() {
		return math;
	}

	public void setMath(Integer math) {
		this.math = math;
	}

	public Integer getJapanese() {
		return japanese;
	}

	public void setJapanese(Integer japanese) {
		this.japanese = japanese;
	}

	public Integer getScience() {
		return science;
	}

	public void setScience(Integer science) {
		this.science = science;
	}

	public Integer getSociety() {
		return society;
	}

	public void setSociety(Integer society) {
		this.society = society;
	}

	public Integer getMusic() {
		return music;
	}

	public void setMusic(Integer music) {
		this.music = music;
	}

	public Integer getTech_home() {
		return tech_home;
	}

	public void setTech_home(Integer tech_home) {
		this.tech_home = tech_home;
	}

	public Integer getPhysical() {
		return physical;
	}

	public void setPhysical(Integer physical) {
		this.physical = physical;
	}

	public Integer getArt() {
		return art;
	}

	public void setArt(Integer art) {
		this.art = art;
	}

}
