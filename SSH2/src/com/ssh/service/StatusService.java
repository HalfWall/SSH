package com.ssh.service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.dao.StatusDao;
import com.ssh.model.Status;
import com.ssh.util.Judge;

@Component("statusService")
public class StatusService {
	
	private StatusDao statusDao;
	
	
	public void judge(Status status,int id) throws IOException, InterruptedException{
		
		String str = status.getCode();
		File f1 = new File("E:\\WorkSpace\\MyEclipse\\SSH2\\judge",
				"test.cpp");
		String filename1 = f1.getAbsolutePath();

		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(filename1));
			pw.println(str);// 写内容
			pw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//得到题号
		String pro = String.valueOf(id);
		
		//判题
		Judge judge=new Judge("E:\\WorkSpace\\MyEclipse\\SSH2\\judge\\");
		judge.setpro("E:\\WorkSpace\\MyEclipse\\SSH2\\judge\\problem\\");
		
		String ans=judge.judge(pro,1000);
		String time=String.valueOf(judge.time);
		Date dates=new Date();
		String date=dates.toString();
		
		ActionContext.getContext().getSession().put("code", str);
		ActionContext.getContext().getSession().put("ans", ans);
		ActionContext.getContext().getSession().put("time", time);
		ActionContext.getContext().getSession().put("date", date);
		
	}
	
	
	public void add(int id){
		statusDao.add(id);
	}
	
	public List<Status> list(){
		return statusDao.list();
	}
	

	
	
	
	
	
	
	
	
	public StatusDao getStatusDao() {
		return statusDao;
	}

	@Resource
	public void setStatusDao(StatusDao statusDao) {
		this.statusDao = statusDao;
	}

}
