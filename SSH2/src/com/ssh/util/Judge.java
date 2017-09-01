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
		//���б���������ļ�,�����ָ����real.out��
		try {
			pro.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Judge {
	String dir = ""; //Ŀ¼��ַ
	String prolist = "";//��������Ŀ¼
	public long time = 0;   //����ʱ��
	
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
		//�������test.exe,����ɾ��
		
		Process pro=Runtime.getRuntime().exec("cmd.exe /c g++ -o "+dir+"test.exe "+dir+"test.cpp");
		pro.waitFor();   //�ȴ��������
		
		if (!file.exists()) return "compile error";   
		//�����ڸ��ļ�,˵�����뷢��������
		
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
		
		//�����ļ�
		
		long bef = System.currentTimeMillis(),now = 0;
		//��¼��ǰʱ��
		
		Thread calctime = new Monitor(dir);
		
		for (calctime.start();calctime.isAlive();)
		{
			now = System.currentTimeMillis();
			//����ʱ��,�������ʱ�䳬��������ʱ��,��ǿ�ƽ�������,����ʱ�䳬��
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
		//��ȡ��������ļ�,���бȽ�
		
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