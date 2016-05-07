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
import java.util.LinkedList;
import pkgModelo.Arbol;
import pkgModelo.CodigoParaGraficarTabla;
import pkgModelo.Dato;

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
        Arbol arbol = new Arbol(new Dato("1", "var 1"));
        arbol.getRaiz().adicionarHijo(new Dato("2", "var 2asdsadasd sdfsdfsd sdfsdf"));
        arbol.getRaiz().getHijos().get(0).adicionarHijo(new Dato("3", "var 3"));
        arbol.getRaiz().adicionarHijo(new Dato("4", "var 4"));
        //System.out.println(arbol.toJSONParaGraficar());
        
        CodigoParaGraficarTabla codigo = new CodigoParaGraficarTabla();
        LinkedList<String> cod = new LinkedList<>();
        cod.add("Nombre del metodo y esas cosas");
        cod.add("instruccion 1");
        cod.add("instruccion 2");
        cod.add("instruccion 3");
        cod.add("instruccion 4");
        codigo.setLineas(cod);
        codigo.setLineaSeleccionada(0);
        
        
        int accion = Integer.parseInt(request.getParameter("accion"));
        if (accion == 1) {
            //String respuesta = "{\"chart\":{\"container\": \"#collapsable-example\", \"rootOrientation\":  \"WEST\", \"animateOnInit\": true, \"node\": { \"collapsable\": true}, \"animation\": {\"nodeAnimation\": \"easeOutBounce\", \"nodeSpeed\": 700, \"connectorsAnimation\": \"bounce\", \"connectorsSpeed\": 700}}, \"nodeStructure\": { \"text\": {\"name\": \"1 variables\",\"title\": \"variables\"}, \"children\": [{ \"text\": {\"name\": \"2 variables\",\"title\": \"variables\"}, \"children\": [{ \"text\": {\"name\": \"3 variables\",\"title\": \"variables\"}}] },{\"text\": {\"name\": \"4 variables\",\"title\": \"variables\"}, \"children\": [ { \"text\": {\"name\": \"5 variables\",\"title\": \"variables\"}}]},{\"text\": {\"name\": \"6 variables\",\"title\": \"variables\"}},{\"text\": {\"name\": \"7 variables\",\"title\": \"variables\"}}]}}";
            String respuesta = arbol.toJSONParaGraficar();
//            Gson gson = new Gson();
//            String json = gson.toJson(respuesta);
            response.getWriter().write(respuesta);
        } else if(accion == 2){
            int linea = Integer.parseInt(request.getParameter("linea"));
            String respuesta;
            if(linea == -1){
                respuesta = codigo.getLineaSeleccionada()+"";
                
            }else{
                codigo.setLineaSeleccionada(linea+1);
                if(codigo.getLineas().size() == codigo.getLineaSeleccionada()){
                    codigo.setLineaSeleccionada(0);
                }
                respuesta = codigo.getLineaSeleccionada()+"";
            }
            response.getWriter().write(respuesta);
            
        }else if (accion == 3){
            int linea = Integer.parseInt(request.getParameter("linea"));
            codigo.setLineaSeleccionada(linea);
            String respuesta = codigo.toString();
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
