/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgControlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 *
 * @author Sebas
 */
public class vistaController extends HttpServlet {

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
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
        int accion = Integer.parseInt(request.getParameter("accion"));
        if (accion == 1) {
            String respuesta = "{\"chart\":{\"container\": \"#collapsable-example\", \"rootOrientation\":  \"WEST\", \"animateOnInit\": true, \"node\": { \"collapsable\": true}, \"animation\": {\"nodeAnimation\": \"easeOutBounce\", \"nodeSpeed\": 700, \"connectorsAnimation\": \"bounce\", \"connectorsSpeed\": 700}}, \"nodeStructure\": { \"image\": \"imagenes/malory.png\", \"children\": [{ \"image\":\"imagenes/lana.png\", \"children\": [{ \"image\": \"imagenes/figgs.png\"}] },{\"image\":\"imagenes/sterling.png\", \"children\": [ { \"image\": \"imagenes/woodhouse.png\"}]},{\"image\": \"imagenes/cheryl.png\"},{\"image\": \"imagenes/pam.png\"},{\"image\": \"imagenes/cheryl.png\"},{\"image\": \"imagenes/pam.png\"}]}}";
//            Gson gson = new Gson();
//            String json = gson.toJson(respuesta);
            response.getWriter().write(respuesta);
        } 
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet vistaController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet vistaController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
