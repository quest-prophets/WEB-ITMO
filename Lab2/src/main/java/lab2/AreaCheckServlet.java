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

    private static boolean checkDataValidity (String x, String y, String r) {
        try {
            Double.parseDouble(x);
            Double.parseDouble(y);
            Double.parseDouble(r);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String r = request.getParameter("r");
        String sRes;

        if (!checkDataValidity(x,y,r)) {
            sRes = "Error";
        }
        else {
            double dx = Double.parseDouble(x);
            double dy = Double.parseDouble(y);
            double dr = Double.parseDouble(r);

            boolean res = checkAreaHit(dx, dy, dr);

            if (res)
                sRes = "True";
            else
                sRes = "False";
        }
        PrintWriter out = response.getWriter();

        out.write(sRes);

        HttpSession httpSession = request.getSession();
        Result result = new Result(x,y,r,sRes);
        List<Result> list = new LinkedList<Result>();

        if (httpSession.getAttribute("dotChecks") == null) {
            list.add(result);
            httpSession.setAttribute("dotChecks", list);
        }
        else {
            list = (List<Result>) httpSession.getAttribute("dotChecks");
            list.add(result);
            httpSession.setAttribute("dotChecks", list);
        }

        //request.getRequestDispatcher("result.jsp").forward(request, response);

    }


}
