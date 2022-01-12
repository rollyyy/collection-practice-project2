package com.greedy.company.dto;

public class EmployeeDTO {

	private int number;            //부서 이름
	private String name;          //사원 이름
	private String gender;        //사원 성별 
	
	//기본생성자
	public EmployeeDTO() {}                     

	//매개변수 생성자
	public EmployeeDTO(int number, String name, String gender) {      
		this.number = number;
		this.name = name;
		this.gender = gender;
	}

	
	//게터, 세터
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	@Override
	public String toString() {
		
		String categoryName = "";
		if(number == 1) {
			categoryName = "개발";
		} else if(number == 2) {
			categoryName = "기획";
		} else if(number == 3) {
			categoryName = "제작";
		} else if(number == 4) {
			categoryName = "경영지원";
		}
		return "부서 : " + categoryName + ", 사원 이름 : " + name + ", 성별 : " + gender;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
