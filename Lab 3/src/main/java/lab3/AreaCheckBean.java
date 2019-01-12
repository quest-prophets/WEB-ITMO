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
    CheckHistoryBean historyBean = null;
    List<Dot> dots = new ArrayList<>();
    double x = 0.0;
    double y = 0.0;
    double r = 2.0;

    int area1 = 1;
    int area2 = 1;
    int area3 = 1;
    int area4 = 1;


    private  boolean checkDataValidity() {
        return ((x>=(-2.0) && x<=2.0) && (y>=(-5.0) && y<5.0) && (r>=2.0 && r<=5.0) &&
                (area1>=1 && area1<=9) && (area2>=1 && area2<=9) && (area3>=1 && area3<=9) && (area4>=1 && area4<=9));
    }

    private boolean checkAreaHit(double x, double y, double r, int area1, int area2, int area3, int area4) {
        if ((x > 0) && (y > 0)) {
            switch (area1) {
                case 1:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r, 2)) return true;
                case 2:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r/2, 2)) return true;
                case 3:
                    if (x <= r && y <= r) return true;
                case 4:
                    if (x <= r/2 && y <= r/2) return true;
                case 6:
                    if (x <= r/2 && y <= r) return true;
                case 7:
                    if (x <= r && y <= r/2) return true;
                case 8:
                    if (y <= ((-1)*x + r)) return true;
                case 9:
                    if (y <= (x/(-2) + r/2)) return true;
                default:
                    return false;
            }
        }
        else if ((x < 0) && (y > 0)) {
            switch (area2) {
                case 1:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r, 2)) return true;
                case 2:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r/2, 2)) return true;
                case 3:
                    if (x >= -r && y <= r) return true;
                case 4:
                    if (x >= -r/2 && y <= r/2) return true;
                case 6:
                    if (x >= -r/2 && y <= r) return true;
                case 7:
                    if (x >= -r && y <= r/2) return true;
                case 8:
                    if (y <= (x + r)) return true;
                case 9:
                    if (y <= (x + r)/2) return true;
                default:
                    return false;
            }
        }

        else if ((x < 0) && (y < 0)) {
            switch (area3) {
                case 1:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r, 2)) return true;
                case 2:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r/2, 2)) return true;
                case 3:
                    if (x >= -r && y >= -r) return true;
                case 4:
                    if (x >= -r/2 && y >= -r/2) return true;
                case 6:
                    if (x >= -r/2 && y >= -r) return true;
                case 7:
                    if (x >= -r && y >= -r/2) return true;
                case 8:
                    if (y <= -(x + r)) return true;
                case 9:
                    if (y <= -(x + r)/2) return true;
                default:
                    return false;
            }
        }

        else if ((x > 0) && (y < 0)) {
            switch (area4) {
                case 1:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r, 2)) return true;
                case 2:
                    if ((pow(x, 2) + pow(y, 2)) <= pow(r/2, 2)) return true;
                case 3:
                    if (x <= r && y >= -r) return true;
                case 4:
                    if (x <= r/2 && y >= -r/2) return true;
                case 6:
                    if (x <= r/2 && y >= -r) return true;
                case 7:
                    if (x <= r && y >= -r/2) return true;
                case 8:
                    if (y <= (x - r)) return true;
                case 9:
                    if (y <= (x - r)/2) return true;
                default:
                    return false;
            }
        }
        else if (area1 == 5 && area2 == 5 && area3 == 5 && area4 == 5)
            return false;
        else
            return true;
    }

    public void dataCheck() {
        if(!checkDataValidity()) return;
        boolean isHit = checkAreaHit(x,y,r,area1,area2,area3,area4);
        historyBean.addResult(new Result(x,y,r,isHit,LocalDateTime.now()));
        dots.add(new Dot(x,y,isHit));
    }

    /*
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

    */
}
