package lab2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.DoubleBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.pow;

@WebServlet({"/areaCheck", "/areaCheck/recompute"})
public class AreaCheckServlet extends HttpServlet {

    private static boolean checkAreaHit(String X, String Y, String R) {
        double x = Double.parseDouble(X);
        double y = Double.parseDouble(Y);
        double r = Double.parseDouble(R);
        if ((x <= 0) && (y >= 0) && (y <= (2 * x + r))) return true;
        if ((x <= 0) && (y <= 0) && ((pow(x, 2) + pow(y, 2)) <= pow(r, 2))) return true;
        if ((x >= 0) && (y <= 0) && (x <= r && (y >= (-r)))) return true;
        else return false;
    }

    private static boolean checkDataValidity(String x, String y, String r) {
        try {
            Double.parseDouble(x);
            Double.parseDouble(y);
            Double.parseDouble(r);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getRequestURI();
        PrintWriter out = response.getWriter();
        HttpSession httpSession = request.getSession();

        if (query.contains("recompute")) {
            String r = request.getParameter("r");

            out.write("[");
            if (httpSession.getAttribute("dotChecks") != null) {
                List<Result> list = (List<Result>) httpSession.getAttribute("dotChecks");
                for (int i = 0; i < list.size(); i++) {
                    out.write("{" + "\"x\":" + list.get(i).x + ",\"y\":" + list.get(i).y + ",\"res\":" + checkAreaHit(list.get(i).x, list.get(i).y, r) + "}");
                    if (i < list.size() - 1) out.write(",");
                }
            }
            out.write("]");
            return;
        }

        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        String sRes;
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        String currentTime = df.format(new Date());

        if (!checkDataValidity(x, y, r)) {
            sRes = "Error";
        } else {
            boolean res = checkAreaHit(x, y, r);

            if (res)
                sRes = "True";
            else
                sRes = "False";
        }

        out.write(sRes + " " + currentTime);

        Result result = new Result(x, y, r, sRes, currentTime);
        List<Result> list = new LinkedList<Result>();

        if (httpSession.getAttribute("dotChecks") == null) {
            list.add(result);
            httpSession.setAttribute("dotChecks", list);
        } else {
            list = (List<Result>) httpSession.getAttribute("dotChecks");
            list.add(result);
            httpSession.setAttribute("dotChecks", list);
        }

        //request.getRequestDispatcher("result.jsp").forward(request, response);

    }


}
