package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
	public String goods = "goods";
	public int count = 5;
	public double profit = 3.14;
	public String[] secretData = {"<![CDATA[<secretData> </secretData>]]><", "<secretData></secretData>"};


	public static class Goods{
		public List names;
	}
}
