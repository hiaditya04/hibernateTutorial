package com.training.hibernatedemos;

public class CreateSessionFactory {

	public static void main(String[] args) {
		try{
			System.out.println("in cret...class");
			DemoSessionFactory.createSessionFactory();
			System.out.println("after factr...");
	}
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
			DemoSessionFactory.shutdown();
		}
}
}