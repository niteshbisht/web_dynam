package com.nitesh.reverse.ptrar;

public class PlaywithPointers {
	
	public CharPtr playPointers(String q) {
		CharPtr base=new CharPtr(null);
		CharPtr next=base;
		for(int n=0;n<q.length();n++){
			CharPtr obj=(CharPtr) buildCharPtrLinks(q.charAt(n));
			next.charObj=obj;
			next=next.charObj;
		}
		return base;
	}
	
	public String viewChars(CharPtr base){
		CharPtr start=base.charObj;
		StringBuffer q=new StringBuffer();
		while(start!=null){
			q.append(start.value);
			start=start.charObj;
		}
		return q.toString();
	}
	
	public Object buildCharPtrLinks(char s){
		CharPtr c = new CharPtr(null);
		c.value=s;
		return c;
	}
}
