package com.app.pamu.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppUtil {

	public static Map<Integer, String> convertListToMap(List<Object[]> list) {
		
		return list.stream().collect(
				Collectors.toMap(
						ob->Integer.valueOf(ob[0].toString()), 
						ob->ob[1].toString()));
	}

}
