package it.polito.tdp.rivers.model;

import java.util.HashMap;
import java.util.Map;

public class RiverIdMap {
			
		private Map<Integer,River> map ;
			
		public RiverIdMap() {
			map = new HashMap<>() ;
		}
			
		public River get(Integer id) {
			return map.get(id) ;
		}
			
		
		public River put(River river) {
			River old = map.get(river.getId()) ; 
			if(old==null) {
				map.put(river.getId(), river) ;
				return river ;
			} else {
				return old ;
			}
		}

}
