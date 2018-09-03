package com.situ.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

/**
 * 学生的Controller
 */
public class FindStudentController extends HttpServlet {
	private IStudentService studentService = new StudentServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list = studentService.list();
		// 将list放到req里面
		req.setAttribute("list", list);
		// 转发到student_manager.jsp页面进行展示
		req.getRequestDispatcher("/student_list.jsp").forward(req, resp);

		// // 乱码问题
		// resp.setContentType("text/html;charset=utf-8");
		// PrintWriter printWriter = resp.getWriter();
		// // 将list数据放到html页面中返回给浏览器
		// printWriter.println("<table border='1' cellspacing='0'>");
		// printWriter.println(" <tr> ");
		// printWriter.println(" <th>ID</th>");
		// printWriter.println(" <th>姓名</th>");
		// printWriter.println(" <th>年龄</th>");
		// printWriter.println(" <th>性别</th>");
		// printWriter.println(" </tr> ");
		// for (Student student : list) {
		// printWriter.println(" <tr> ");
		// printWriter.println(" <td>" + student.getId() + "</td> ");
		// printWriter.println(" <td>" + student.getName() + "</td>");
		// printWriter.println(" <td>" + student.getAge() + "</td> ");
		// printWriter.println(" <td>" + student.getGender() + "</td>");
		// printWriter.println(" </tr> ");
		// }
		// printWriter.println("</table> ");
		//
		// printWriter.close();
	}

}
