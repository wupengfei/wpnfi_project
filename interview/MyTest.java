package edu.bjtu.sse.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author wupengfei
 *
 */
public class MyTest {

	public static void main(String[] args) {
		/*Map<String,String> jdkMap = new HashMap<String,String>();
		
		for (int i = 0; i <1000; i++) {
			jdkMap.put("teacher"+i, "perry"+i);
		}*/
		
		PerryMap<String,String> pMap = new PerryHashMap<String,String>();
		for (int i = 0; i <1000; i++) {
			pMap.put("teacher"+i, "perry"+i);
		}
		System.out.println("pMap.size=" + pMap.size());
		for (int i = 0; i <1000; i++) {
			System.out.println("teacher"+i + ":" +pMap.get("teacher"+i));
			
		}
	}

}
