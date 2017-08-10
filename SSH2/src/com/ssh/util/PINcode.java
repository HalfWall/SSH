package com.ssh.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PINcode extends HttpServlet {

	
	public PINcode() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html;charset=utf-8");
			//生成图片
			BufferedImage img=new BufferedImage(115, 25, BufferedImage.TYPE_3BYTE_BGR);
			
			Graphics g=img.getGraphics();	
			g.setFont(new Font("宋体", Font.BOLD, 20));
			g.setColor(Color.white);
			
			Random random = new Random();
			//用于保存随机产生的验证码
			StringBuffer randomCode = new StringBuffer();
			int length = 4;

			String base = "abcdefghijklmnopqrstuvwxyz0123456789";
			int size = base.length();

			for (int i = 0; i < length; i++) {
				int start = random.nextInt(size);
				String strRand = base.substring(start, start + 1);
				g.drawString(strRand, 20 * i + 24, 19);

				randomCode.append(strRand);
			}
			//保存到session中
			HttpSession session = request.getSession();
	        session.setAttribute("checkCode", randomCode.toString());
			
//			for(int i=0;i<4;i++){
//				
//				String rand=String.valueOf(s.nextInt(10)); 
//				g.drawString(rand, 2+12*i, 17);
//			}
			
		
			
			//禁止图像缓存
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);	
			response.setContentType("image/jpeg");
			
			//将图像输出到servlet输出流中
			ServletOutputStream sos=response.getOutputStream();
			
			ImageIO.write(img, "jpeg", sos);
			sos.close();

		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
