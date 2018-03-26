package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InicioServlet", urlPatterns = {"/index.html"})
public class InicioServlet extends HttpServlet {

    Map<String, String> mapa;

    public InicioServlet() {
        mapa = new HashMap<>();
        mapa.put("Brasil", "Azul");
        mapa.put("França", "Vermelho");
        mapa.put("Japão", "Amarelo");
        mapa.put("Argentina", "Branco");
        mapa.put("Itália", "Verde");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ordem = request.getParameter("ordem");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Exercício 2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Exercício 2" + "</h1>");
            out.println("<a href='?ordem=pais'>País" + "</a>");
            out.println("<a href='?ordem=cor'>Agrupamento por cor" + "</a>");
            out.println("<ul>");
            switch (ordem) {
                case "cor":
                    for (Map.Entry<String, String> mapa : mapa.entrySet()) {
                        out.println("<dt>" + mapa.getKey() + "</dt>");
                        out.println("<dd>"+ mapa.getValue() +"</dd>");
                    }
                    break;
                case "pais":
                    for (Map.Entry<String, String> mapa : mapa.entrySet()) {
                        List<String> cores = new ArrayList<String>();
                        cores.add(mapa.getValue());
                    }
                    break;
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
