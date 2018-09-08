package com.qa.tests;

import org.testng.annotations.Test;

public class GroupsTest {
 
  @Test(groups= {"smoke", "sanity"})
  public void f1() {
	  System.out.println("smoke");
  }
  
  @Test(groups= {"regression"})
  public void f2() {
	  System.out.println("regression");
  }
}
