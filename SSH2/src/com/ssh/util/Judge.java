package com.ssh.util;

import java.io.*;
import java.util.*;

class Monitor extends Thread {
	Process pro= null;
	String dir="";
	Monitor(String dir){
		this.dir=dir;
	}
	public void run(){
		try {
			pro=Runtime.getRuntime().exec("cmd.exe /c "+dir+"test.exe<"+dir+"test.in>"+dir+"real.out");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//运行编译产生的文件,输出到指定的real.out中
		try {
			pro.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Judge {
	String dir = ""; //目录地址
	String prolist = "";//测试数据目录
	public long time = 0;   //运行时间
	
	public Judge(String dir)
	{
		this.dir = dir;
	}
	public void setpro(String s)
	{
		prolist=s;
	}
	public String judge(String name, long limit) throws IOException, InterruptedException
	{
		File file = new File(dir+"test.exe");
		if (file.exists()) file.delete();
		//如果存在test.exe,将其删除
		
		Process pro=Runtime.getRuntime().exec("cmd.exe /c g++ -o "+dir+"test.exe "+dir+"test.cpp");
		pro.waitFor();   //等待编译结束
		
		if (!file.exists()) return "compile error";   
		//不存在该文件,说明编译发生错误了
		
		file = new File(dir+"test.in");
		if (file.exists()) file.delete();
		pro=Runtime.getRuntime().exec("cmd.exe /c copy "+prolist+name+".in "+dir);
		pro.waitFor();
		file = new File(dir+name+".in");
		file.renameTo(new File(dir+"test.in"));
		
		file = new File(dir+"test.out");
		if (file.exists()) file.delete();
		pro=Runtime.getRuntime().exec("cmd.exe /c copy "+prolist+name+".out "+dir);
		pro.waitFor();
		file = new File(dir+name+".out");
		file.renameTo(new File(dir+"test.out"));
		
		//复制文件
		
		long bef = System.currentTimeMillis(),now = 0;
		//记录当前时间
		
		Thread calctime = new Monitor(dir);
		
		for (calctime.start();calctime.isAlive();)
		{
			now = System.currentTimeMillis();
			//控制时间,如果运行时间超过给定的时间,则强制结束进程,返回时间超限
			if (now-bef > limit) 
			{
				((Monitor)calctime).pro.destroy();
				Runtime.getRuntime().exec("cmd.exe /c taskkill /f /im test.exe");
				return "Timelimit Exceed";
			}
		}
		
		InputStream A = new FileInputStream(new File(dir+"test.out")); 
		InputStream B = new FileInputStream(new File(dir+"real.out"));
		Scanner a=new Scanner(A),b=new Scanner(B);
		//读取两个输出文件,进行比较
		
		String ans="Accepted";
		
		while (a.hasNext())
		{
			String u = a.next();
			if (b.hasNext()) 
			{
				String v=b.next();
				if (u.equals(v)) continue;
				else ans="Wrong answer";
			}
			else ans="Wrong answer";
		}
		
		if (b.hasNext()) ans="OutputLimitExceeded";
		a.close(); b.close(); A.close(); B.close();
		
		if (ans.equals("Accepted")) time = now-bef; else time=limit;
		
		return ans;
	}
	
	
}