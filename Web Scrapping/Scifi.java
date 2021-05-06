/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author manan
 */
public class Scifi extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             Document doc;
            try{
            doc=Jsoup.connect("https://www.imdb.com/chart/moviemeter/?ref_=nv_mv_mpm").timeout(6000).get();
            Elements body = doc.select("tbody.lister-list");
            int x=1;
            out.print("<h1><b><u><center>Most Popular Movies</h1></b></u>");
            //out.println(body.select("tr").size());
               for(Element e:body.select("tr"))
                {
                    String img=e.select("td.posterColumn img").attr("src");
                    out.print("<center><br><img src="+img+">");
                    String title=e.select("td.posterColumn img").attr("alt");
                    out.print("  <h2>"+x+" "+title +"</h2>  ");
                    String year=e.select("td.titleColumn span.secondaryInfo")
                            .text().replaceAll("[^\\d]","");
                    out.print(" Year:-"+year+"<br>  ");
                    String rate=e.select("td.ratingColumn.imdbRating").text().trim();
                    out.print(" IMDB Rating :- "+rate);
                    out.print("<br><br>");
                    x++;
                    out.print("---------------------------------------------------------------------------------------<br>");
                    
                }
            }
            catch(Exception e)
            {
                out.print(e);
            }
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
