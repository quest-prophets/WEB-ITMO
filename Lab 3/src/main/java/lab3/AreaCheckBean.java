package lab3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Math.pow;

public class AreaCheckBean implements Serializable {
    double x = 0.0;
    double y = 0.0;
    double r = 1.0;

    private boolean checkAreaHit(String X, String Y, String R) {
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
                    out.write("{" + "\"x\":" + list.get(i).getX() + ",\"y\":" + list.get(i).getY() + ",\"res\":"
                            + checkAreaHit(Double.toString(list.get(i).getX()), Double.toString(list.get(i).getY()), r) + "}");
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
        LocalDateTime currentTime = LocalDateTime.now();

        if (!checkDataValidity(x, y, r)) {
            sRes = "Error";
        } else {
            boolean res = checkAreaHit(x, y, r);

            if (res)
                sRes = "true";
            else
                sRes = "false";
        }

        out.write(sRes + " " + currentTime);

        Result result = new Result(Double.parseDouble(x), Double.parseDouble(y), Double.parseDouble(r), Boolean.parseBoolean(sRes), currentTime);
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
