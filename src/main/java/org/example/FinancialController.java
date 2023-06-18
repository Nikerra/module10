package org.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FinancialController{
    private static final String MIN_AMOUNT_ERROR = "The minimum amount at the time of opening the deposit must be more than 50,000 thousand rubles";
    private static final String INVALID_FORMAT = "Invalid data format. Adjust the values.";

    @GetMapping("/jsp")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/jsp/calc")
    public String calc(Model model) {
        return "calculator";
    }

    @PostMapping("/calc")
    public String calc(@RequestParam String amount, String percent, String years) {
        System.out.println(amount + " " + percent + " " + years);
        return "redirect:/calculator";
    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        int amount;
//        int percent;
//        int years;
//
//        try {
//            amount = Integer.parseInt(req.getParameter("amount"));
//            percent = Integer.parseInt(req.getParameter("percent"));
//            years = Integer.parseInt(req.getParameter("years"));
//            if (amount < 0 || percent < 0 || years < 0) {
//                req.setAttribute("result", INVALID_FORMAT);
//                getServletContext().getRequestDispatcher("/error.jsp").forward(req,resp);
//            }
//            InfoCalc infoCalc = new InfoCalc(amount, percent, years);
//            Calc calc = new Calc();
//            int result = calc.sum(amount, percent, years);
//            if (calc.isCheckAmount(amount)) {
//                req.setAttribute("result", MIN_AMOUNT_ERROR);
//                getServletContext().getRequestDispatcher("/error.jsp").forward(req,resp);
//            } else {
//                HttpSession session = req.getSession();
//                session.setAttribute("infoCalc", infoCalc);
//                req.setAttribute("result", result);
//                getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
//            }
//        } catch (NumberFormatException nfe) {
//            req.setAttribute("result", INVALID_FORMAT);
//            getServletContext().getRequestDispatcher("/error.jsp").forward(req,resp);
//        }
//    }
}
