package com.cn.exer;
public class ImmutableClass {
	
	private final String detail;
	private final String postCode;
	
	public ImmutableClass(){
		
		this.detail = "";
		this.postCode = "";
	}
	
	public ImmutableClass(String detail, String postCode){
		
		this.detail = detail;
		this.postCode = postCode;
	}
	
	public String getDetail(){
		return this.detail;
	}
	
	public String getPostCode(){
		
		return this.postCode;
	}
	
	public boolean equals(Object obj){
		
		if (this == obj) {
			return true;
		}
		
		if (obj!= null && obj.getClass() == ImmutableClass.class) {
			
			ImmutableClass immutable = (ImmutableClass)obj;
			
			if (this.getDetail().equals(immutable.getDetail()) && this.getPostCode().equals(immutable.getPostCode())) {
				return true;
			}
			
		}
		
		return false;
	}
	
	public int hashCode(){
		
		return detail.hashCode() + postCode.hashCode()*31;
	}
	
	

}
