package com.matthewxu.effectivejava;

public class Item2Builder {

	private final String name;
	
	private final String phone;
	
	private final String address;
	
	public static class Builder{
		
		private final String name;
		
		private final String phone;
		
		private String address = "";
		
		public Builder(String name, String phone){
			this.name = name;
			this.phone = phone;
		}
		
		public Builder address(String address){
			this.address = address;
			return this;
		}
		
		public Item2Builder build(){
			return new Item2Builder(this);
		}
	}
	
	private Item2Builder(Builder builder){
		this.name = builder.name;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	@Override
	public String toString() {
		return "Item2Builder [name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}

	public static void main(String[] args) {
		Item2Builder item2Builder = new Item2Builder.Builder("matthew", "15366203524").address("1602").build();
		System.out.println(item2Builder);
		
	}
}
