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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.pow;

@WebServlet("/areaCheck")
public class AreaCheckServlet extends HttpServlet {

    private static boolean checkAreaHit(double x, double y, double r) {
        if ((x<=0) && (y>=0) && (y<=(2*x+r))) {return true;}
        if ((x<=0) && (y<=0) && ((pow(x,2) + pow(y,2))<=pow(r,2))) {return true;}
        if ((x>=0) && (y<=0) && (x<=r && (y>=(-r)))) {return true;}
        return false;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        double dx = Double.parseDouble(x);
        double dy = Double.parseDouble(y);
        double dr = Double.parseDouble(r);

        boolean res = checkAreaHit(dx,dy,dr);
        String sRes;

        if (res)
            sRes = "Point is in the area";
        else
            sRes = "Point is not in the area";

        PrintWriter out = response.getWriter();
        out.write("\n");
        out.write("<!DOCTYPE html>\n");
        out.write("<html>\n");
        out.write("<head>\n");
        out.write("    <meta charset=\"UTF-8\">\n");
        out.write("</head>\n");
        out.write("\n");
        out.write("<body>\n");
        out.write("<table>\n");
        out.write("    <tr>\n");
        out.write("        <td>\n");
        out.write(x + "\n");
        out.write("        </td>\n");
        out.write("        <td>\n");
        out.write(y + "\n");
        out.write("        </td>\n");
        out.write("        <td>\n");
        out.write(r + "\n");
        out.write("        </td>\n");
        out.write("        <td>\n");
        out.write(sRes + "\n");
        out.write("        </td>\n");
        out.write("        <td>\n");
        out.write("<a href = http://localhost:8080/Lab2-1.0/</a>\n");
        out.write("        </td>\n");
        out.write("    </tr>\n");
        out.write("</table>\n");
        out.write("</body>\n");

        String resultString = x + " " + y + " " + r + " " + sRes;
        HttpSession httpSession = request.getSession();
        List<String> list = new LinkedList<String>();

        if (httpSession.getAttribute("dotChecks") == null) {
            list.add(resultString);
            httpSession.setAttribute("dotChecks", list);
        }
        else {
            list = (List<String>) httpSession.getAttribute("dotChecks");
            list.add(resultString);
            httpSession.setAttribute("dotChecks", list);
        }

        //request.getRequestDispatcher("result.jsp").forward(request, response);

    }


}
