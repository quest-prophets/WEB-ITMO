package lab2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/")
public class ControllerServlet extends HttpServlet {
    /*
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ArrayList<Dot> checkings = new ArrayList<>();
        getServletContext().setAttribute("resultTable", checkings);
    }
    */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String query = request.getRequestURI();

        if (query != null && (query.endsWith(".css") || query.endsWith(".png") || query.endsWith(".js") || query.endsWith(".ico"))) {
            if (query.endsWith(".css")) response.setContentType("text/css;charset=UTF-8");
            if (query.endsWith(".png")) response.setContentType("image/png");
            if (query.endsWith(".ico")) response.setContentType("image/x-icon");
            if (query.endsWith(".js")) response.setContentType("text/javascript;charset=UTF-8");
            String filename = query.split("/")[query.split("/").length - 1];
            InputStream res = getServletContext().getResourceAsStream("/" + filename);
            if (res == null) {
                response.setStatus(404);
            } else {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = res.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, len);
                }
            }
        } else {

            if (query.contains("clearHistory")) {
                HttpSession session = request.getSession();
                session.setAttribute("dotChecks", new LinkedList<Result>());
            }
            else {
                if (query.contains("hitCheck")) {
                    response.setContentType("text/html;charset=UTF-8");
                    String kx = request.getParameter("x");
                    request.setAttribute("x", kx);
                    String ky = request.getParameter("y");
                    request.setAttribute("y", ky);
                    String r = request.getParameter("r");
                    request.setAttribute("r", r);


                    if (kx != null && ky != null && r != null) {
                        request.getRequestDispatcher("/areaCheck").forward(request, response);
                    } else {
                        response.setContentType("text/html;charset=UTF-8");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } else {
                    response.setContentType("text/html;charset=UTF-8");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
        }

    }
}
