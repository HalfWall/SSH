package com.ssh.service;

import static java.lang.System.out;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ssh.dao.ProblemDao;
import com.ssh.model.Problem;

@Component("problemService")
public class ProblemService {
	
	private ProblemDao problemDao;

	
	public boolean add(Problem pro){
		problemDao.add(pro);
		return true;
	}
	
	public List<Problem> list(){
		return problemDao.list();
	}
	
	public boolean delete(int id) {
		problemDao.delete(id);
		return true;

	}

	public Problem load(int id) {
		return problemDao.load(id);
	}
	
	public boolean update(Problem pro) {
		problemDao.update(pro);
		return true;
	}
	
	
	//----------------------增删in out 文件--------------------------------------
	public void fileAdd(Problem pro){
		String str=pro.getTestIn();
		String str2=pro.getTestOut();
		String prolist=String.valueOf(pro.getId());

		File f1 = new File("E:\\WorkSpace\\MyEclipse\\SSH2\\judge\\problem",
				prolist+".in");
		File f2 = new File("E:\\WorkSpace\\MyEclipse\\SSH2\\judge\\problem",
				prolist+".out");
		String filename1 = f1.getAbsolutePath();
		String filename2 = f2.getAbsolutePath();

		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(filename1));
			PrintWriter pw2 = new PrintWriter(new FileOutputStream(filename2));
			pw.println(str);
			pw2.println(str2);// 写内容
			pw.close();
			pw2.close();
		} catch (IOException e) {
			out.println(e.getMessage());
		}
	}
	
	public void fileDelete(int id){
		String prolist=String.valueOf(id);
		File f1 = new File("E:\\WorkSpace\\MyEclipse\\SSH2\\judge\\problem",
				prolist+".in");
		File f2 = new File("E:\\WorkSpace\\MyEclipse\\SSH2\\judge\\problem",
				prolist+".out");
		if (f1.exists())// 如果文件存在，则删除
		{
			f1.delete();
		}
		if (f2.exists())
		{
			f2.delete();
		}
	}
	
	
	
	
	
	
	
	
	
	
	public ProblemDao getProblemDao() {
		return problemDao;
	}

	@Resource
	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}

	

	

	
}
