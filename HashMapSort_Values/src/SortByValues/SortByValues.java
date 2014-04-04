package SortByValues;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class SortByValues {
	public static boolean A=true;
	public static boolean D=true;
	public static void main(String args[]){
		Map<String, Integer> m=new HashMap<String, Integer>();
		m.put("d", 8);
		m.put("a", 7);
		m.put("g", 1);
		m.put("a", 5);
		m.put("k", 4);
		System.out.println("Unsorted Map:"+m);
		System.out.println("After Sorting.......");
		Map<String, Integer> sortAsc=Sort(m, D);
		printMap(sortAsc);
	}
	private static Map<String, Integer> Sort(Map<String, Integer> map, final boolean order){
		List<Entry<String, Integer>> list=new LinkedList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
				if(order){
					return o1.getValue().compareTo(o2.getValue());
				}
				else{
					return o2.getValue().compareTo(o1.getValue());
				}
			}
		});
		
		Map<String, Integer> m=new LinkedHashMap<String, Integer>();
		for(Entry<String, Integer> entry:list){
			m.put(entry.getKey(), entry.getValue());
		}
		return m;
	}
	public static void printMap(Map<String, Integer> map){
		for(Entry<String, Integer> entry:map.entrySet()){
			System.out.println("Key:"+entry.getKey()+"   Value:"+entry.getValue());
		}
	}
}
