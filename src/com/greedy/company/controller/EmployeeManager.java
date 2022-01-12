package com.greedy.company.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.greedy.company.dto.EmployeeDTO;


public class EmployeeManager {

	private HashMap<Integer, EmployeeDTO> EmployeeMap = new HashMap<>();
	
	//새로운 직원 추가
	public void insertEmployee(EmployeeDTO employee) {
		
	//HashMap<Integer, EmployeeDTO>	에서 Integer 부분
		int lastNo = 0;
		
		
		Iterator<Integer> it = EmployeeMap.keySet().iterator();
		while(it.hasNext()) {
			lastNo = it.next();
		}
		              //목록의 끝에서 +1 해서 새로운 직원 추가
		EmployeeMap.put(lastNo+1,employee);
	}
	
	
	//직원 삭제
	public int deleteEmployee(int employeeNo) {
		
		EmployeeDTO old = null;
		
		Iterator<Integer> it = EmployeeMap.keySet().iterator();
		
		while(it.hasNext()) {
			//it의 다음 값이 입력 받는 employeeNo와 일치하는 경우
			if(it.next() == employeeNo) {
				//EmployeeMap에서 제거를 하면 old에 해당 값이 들어가게 된다.
				old = EmployeeMap.remove(employeeNo);
				break;
			}
		}
		
		//old에 null 값이 없으면 제거 할 값이 있다는 뜻이다. 그렇다면 1을 return한다.
		return old != null ? 1 : 0;
	}
	
	
	//직원 검색 출력
	public Map<Integer, EmployeeDTO> searchEmployee(String name) {
		
		//새로운 맵 생성
		 Map<Integer, EmployeeDTO> searchMap = new HashMap<>();
		 
		 
		 Iterator<Entry<Integer, EmployeeDTO>> it = searchMap.entrySet().iterator();
	
		 while(it.hasNext()) {
			 
			 Entry<Integer, EmployeeDTO> entry = it.next();
			 
			 //입력받은 name이 값의 이름에 포함되는 경우
			 if(entry.getValue().getName().contains(name)) {
				 
				 searchMap.put(entry.getKey(), entry.getValue());
				 
			 }
		 }
		 
		return searchMap;
	}
	
	//전체 출력
	public Map<Integer, EmployeeDTO> selectEmployee() {
		return EmployeeMap;
	}
	
	
	
	
	
	
	
	
}
