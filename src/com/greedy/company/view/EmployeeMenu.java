package com.greedy.company.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.greedy.company.controller.EmployeeManager;
import com.greedy.company.dto.EmployeeDTO;

public class EmployeeMenu {

	Scanner sc = new Scanner(System.in);
	private EmployeeManager employeeManager = new EmployeeManager();
	
	public EmployeeMenu() {}
	
	public void mainMenu() {
		mainMenu :
		while (true) {
			
			
			System.out.println("====직원 관리 프로그램====");
			System.out.println("1. 새로운 직원 추가");
			System.out.println("2. 직원 삭제");
			System.out.println("3. 직원 검색 출력");
			System.out.println("4. 전체 출력");
			System.out.println("0.  끝내기");
			
			System.out.print("메뉴 선택 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			
			switch (num) {
			
			case 1 : 
				insertEmployee();
				break;
			case 2 :
				deleteEmployee();
				break;
			case 3 :
				searchEmployee();
				break;
			case 4 :
				selectEmployee();
				break;
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				break mainMenu; 
			
			}		
		}
	
	}
	
	//입력한 값을 Manager로 전달해줌
	public void insertEmployee() {
		
		System.out.print("부서 (1.개발/2.기획/3.제작/4.경원지원)숫자로 입력 : ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		
		System.out.print("성별 : ");
		String gender = sc.nextLine();
		
		//매개변수 생성자 순서 그대로 작성해줘야 에러가 나지 않음
		employeeManager.insertEmployee(new EmployeeDTO(number,name,gender));
		
	
	}
	
	public void deleteEmployee() {
		
		System.out.print("직원 번호 : ");
		int result = employeeManager.deleteEmployee(sc.nextInt());
		
		if(result > 0) {
			System.out.println("성공적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제할 책이 존재하지 않습니다.");
		}
		
	}
	
	public void searchEmployee() {
		System.out.print("직원 이름 검색 : ");
		Map<Integer, EmployeeDTO> searchMap = employeeManager.searchEmployee(sc.nextLine());
		
		if(searchMap.isEmpty()) {
			System.out.println("조회한 직원이 존재하지 않습니다.");
		} else {
			Iterator<Integer> it = searchMap.keySet().iterator();
			while(it.hasNext()) {
				int key = it.next();
				System.out.println("직원 번호 : " + key + ", " + searchMap.get(key));
			}
		}
	}
	
	public void selectEmployee() {
		Map<Integer, EmployeeDTO> employeeMap =  employeeManager.selectEmployee();
		
		if(employeeMap.isEmpty()) {
			System.out.println("직원이 없습니다.");
		} else {
			Iterator<Integer> it = employeeMap.keySet().iterator();
			while(it.hasNext()) {
				
				Integer key = it.next();
				System.out.println("직원번호 : " + key + ", " +  employeeMap.get(key));
		
			}
		}
	}

	
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

