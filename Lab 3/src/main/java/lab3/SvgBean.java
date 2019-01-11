package lab3;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "svgBean")
@ApplicationScoped
public class SvgBean {
    public String getSvgOverlay() {
        return "<svg id=\"overlay\" class=\"graphOverlay hidden\" xmlns=\"http://www.w3.org/2000/svg\" width=\"400\" height=\"400\"></svg>";
    }

    public String getSvgLT() {
        return "<svg id=\"sector_LT\" class=\"graphSector\" xmlns=\"http://www.w3.org/2000/svg\" width=\"200\" height=\"200\">\n" +
                "    <path id=\"sector_LT_figure\" fill=\"3399ff\" stroke='black' d=\"\"/>\n" +
                "    <path stroke='black' d=\"M 200 0 l -3 7\"/>\n" +
                "    <text x=\"180\" y=\"40\" font-size=\"16\"> R</text>\n" +
                "    <text x=\"170\" y=\"120\" font-size=\"16\"> R/2</text>\n" +
                "    <g id=\"dots_LT\"/>\n" +
                "</svg>";
    }
    public String getSvgLB() {
        return "<svg id=\"sector_LB\" class=\"graphSector\" xmlns=\"http://www.w3.org/2000/svg\" width=\"200\" height=\"200\">\n" +
                "    <path id=\"sector_LB_figure\" style=\"transform: rotate(-90deg); transform-origin: 100px 100px\"\n" +
                "          fill=\"3399ff\"\n" +
                "          stroke='black' d=\"\"/>\n" +
                "    <path stroke='black' d=\"M 0 0 h 200\"/>\n" +
                "    <text x=\"40\" y=\"20\" font-size=\"16\"> R</text>\n" +
                "    <text x=\"120\" y=\"20\" font-size=\"16\"> R/2</text>\n" +
                "    <g id=\"dots_LB\"/>\n" +
                "</svg>\n";
    }

    public String getSvgRT() {
        return  "<svg id=\"sector_RT\" class=\"graphSector\" xmlns=\"http://www.w3.org/2000/svg\" width=\"200\" height=\"200\">\n" +
                "    <path id=\"sector_RT_figure\" style=\"transform: rotate(90deg); transform-origin: 100px 100px\"\n" +
                "          fill=\"3399ff\"\n" +
                "          stroke='black' d=\"\"/>\n" +
                "    <path stroke='black' d=\"M 0 0 v 200\"/>\n" +
                "    <path stroke='black' d=\"M 0 0 l 3 7\"/>\n" +
                "    <path stroke='black' d=\"M 200 200 l -6 -3\"/>\n" +
                "    <text x=\"80\" y=\"190\" font-size=\"16\"> R/2</text>\n" +
                "    <text x=\"160\" y=\"190\" font-size=\"16\"> R</text>\n" +
                "    <g id=\"dots_RT\"/>\n" +
                "</svg>";
    }

    public String getSvgRB() {
        return  "<svg id=\"sector_RB\" class=\"graphSector\" xmlns=\"http://www.w3.org/2000/svg\" width=\"200\" height=\"200\">\n" +
                "    <path id=\"sector_RB_figure\" style=\"transform: rotate(180deg); transform-origin: 100px 100px\"\n" +
                "          fill=\"3399ff\"\n" +
                "          stroke='black' d=\"\"/>\n" +
                "    <path stroke='black' d=\"M 0 0 v 200\"/>\n" +
                "    <path stroke='black' d=\"M 0 0 h 200\"/>\n" +
                "    <path stroke='black' d=\"M 200 0 l -6 3\"/>\n" +
                "    <text x=\"10\" y=\"80\" font-size=\"16\"> R/2</text>\n" +
                "    <text x=\"10\" y=\"160\" font-size=\"16\"> R</text>\n" +
                "    <g id=\"dots_RB\"/>\n" +
                "</svg>";
    }
}
