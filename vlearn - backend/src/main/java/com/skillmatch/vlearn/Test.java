package com.skillmatch.vlearn;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		String path= "emps/{empId}?collection=collectiond";
		String name = "Ananth";
		name.chars()
		.mapToObj(c -> Character.toLowerCase((char)c))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
		.stream()
		.filter(e -> e.getValue() == 1)
		.map(Map.Entry::getKey)
		.toList()
		.stream()
		.forEach(System.out::println);

		
		
		
		
		//		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), 
//                Arrays.asList(4, 5), Arrays.asList(6, 7, 8, 9));
//		List<Integer> singleList = listOfLists.stream()
//				.flatMap(List::stream)
//				.map(i-> i*i).toList();
//		System.out.println(singleList);
		
//		emp -> id, name, salary and deptId
//		dep -> deptName, deptId
//		
//		select deptName, TotalEmps from emp e,dep d where e.salary>10000 
//		and e.deptId = d.deptId;
	}

}
