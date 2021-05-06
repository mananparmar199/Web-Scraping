/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author manan
 */
public class FirstServlet extends HttpServlet {

    public int hitCount; 

  
    @Override
        public void init() { 
           // Reset hit counter.
           hitCount = 0;
        } 

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        hitCount++;
        try (PrintWriter out = response.getWriter()) {
            String n=request.getParameter("username");  
            String p=request.getParameter("password");  
            String s1="",s2="",s3="",s4=String.valueOf(hitCount);  ;
              
                boolean status=false;  
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/StudentPortal","root","");  

                    PreparedStatement ps=con.prepareStatement("select * from reg where username=? and password=?");  
                    ps.setString(1,n);  
                    ps.setString(2,p);  

                    ResultSet rs=ps.executeQuery();  
                    status=rs.next(); 
                    
                    s1=rs.getString(1);
                    s2=rs.getString(2);
                    s3=rs.getString(3);

                  

                }catch(Exception e){out.println(e);}  
                
                
                if(status){  
                    request.setAttribute("s1",s1);
                    request.setAttribute("s2",s2);
                    request.setAttribute("s3",s3);
                    request.setAttribute("s4",s4);
                   
                    HttpSession session=request.getSession();  
                    session.setAttribute("name",s1); 
                    session.setAttribute("fullname",s2); 
                    session.setAttribute("email",s3); 
                    session.setAttribute("visitor",s4); 
                    
                    request.getRequestDispatcher("Welcome1.jsp").forward(request, response);     
                }  
                else{  
                    out.print("Sorry username or password error");  
                    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
                    rd.include(request,response);  
                }  

                out.close(); 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
