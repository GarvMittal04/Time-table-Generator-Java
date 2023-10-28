package autotimetable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class signup extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException,IOException{
    response.setContentType("text/html;charset=UTF-8");String path = "index.jsp#overlay";;
    try {
DB d = new DB();
String uname = request.getParameter("name");
String pass1 = request.getParameter("pass1");
String pass2 = request.getParameter("pass2");
String fname = request.getParameter("fn");
String lname = request.getParameter("ln");
String addr = request.getParameter("addr");
String contactno = request.getParameter("cn");
String dob = request.getParameter("dob");
String doj = request.getParameter("doj");
String qualific = request.getParameter("qu");
String email = request.getParameter("email");
String maddr = request.getParameter("maddr");
String course = request.getParameter("course");
String subjectlist[] = request.getParameterValues("subjectslist");
String slist = "";
        for (int i = 0; i < subjectlist.length; i++) {
            System.err.println("subjectlist :" + subjectlist[i]);
            slist = slist + subjectlist[i] + ",";
        }
        ArrayList < String > a=new ArrayList < String > ();
        a.add(uname);
        a.add(pass1);
        a.add(pass2);
        a.add(fname);
        a.add(lname);
        a.add(addr);
        a.add(contactno);
        a.add(dob);
        a.add(doj);
        a.add(qualific);
        a.add(email);
        a.add(maddr);
        a.add(course);
        a.add(slist);
        d.addTeacher(a);
        path = "index.jsp?success";
    }
    finally {
    }
    response.sendRedirect(path);
}
protected void doGet(HttpServletRequest request, HttpServletResponseresponse)
throws ServletException, IOException {
    processRequest(request, response);
} 
protected void doPost(HttpServletRequest request, HttpServletResponseresponse)
throws ServletException, IOException {
    processRequest(request, response);
}
public String getServletInfo() {
    return "Short description";
}
}
// Substitute request
<% @page import="java.sql.ResultSet" %>
<% @page contentType = "text/html" pageEncoding = "UTF-8" %>
< !DOCTYPE html >
<jsp:useBean id="object" class="autotimetable.DB" />
<%
    ResultSet r = object.getSubst(session.getAttribute("id") + "");
out.print("<table id='admin_menu'>");
out.print("<th>");
out.print("</th>");
out.print("<th>");
out.print("</th>");
out.print("<th>");
out.print("Requested By</th>");
out.print("<th>");
out.print("Requested For</th>");
out.print("<th>");
while (r.next()) {
    out.print("<tr>");
    out.print("<td>");
    out.print("<div style='padding: 10px 10px 10px 10px; background-color:green'>
    < a href = 'user/leaveAction.jsp?id="+session.getAttribute("id")+"&date="+r.getString(2)+"&action=approved' style = 'text-decoration:none;color:white' > Approve</a > </div > ");
out.print("</td>");
    out.print("<td>");
    out.print("<div style='padding: 10px 10px 10px 10px; background-color:Red'>
    < a href = 'user/leaveAction.jsp&id="+session.getAttribute("id")+"&date="+r.getString(2)+"&action=Rejected' style = 'text-decoration:none;color:white' > Reject</a ></div > ");
out.print("</td>");
}
