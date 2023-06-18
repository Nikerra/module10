package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class CalcController {

    private static final String MIN_AMOUNT_ERROR = "The minimum amount at the time of opening the deposit must be more than 50,000 thousand rubles";
    private static final String INVALID_FORMAT = "Invalid data format. Adjust the values.";
    private String result;

    @GetMapping("/webapp")
    public ModelAndView home() {
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }

    @GetMapping("/webapp/errorAmount")
    public ModelAndView errorAmount() {
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("/error.jsp");
        modelAndView.addObject("message", MIN_AMOUNT_ERROR);
        return modelAndView;
    }
    @GetMapping("/webapp/errorFormat")
    public ModelAndView errorFormat() {
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("/error.jsp");
        modelAndView.addObject("message", INVALID_FORMAT);
        return modelAndView;
    }

    @GetMapping("/webapp/result")
    public ModelAndView result() {
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("/result.jsp");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    @GetMapping("/webapp/calc")
    public ModelAndView calc() {
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("/calc.jsp");
        return modelAndView;
    }
    @PostMapping("/webapp/calc")
    public String calcOperation(@RequestParam String amount, String percent, String years) {
        int amountInt;
        int percentInt;
        int yearsInt;

        try {
            amountInt = Integer.parseInt(amount);
            percentInt = Integer.parseInt(percent);
            yearsInt = Integer.parseInt(years);
            if (isCheckAmount(amountInt)){
                return "redirect:/webapp/errorAmount";
            } else {
                if (amountInt < 0 || percentInt < 0 || yearsInt < 0) {
                    return "redirect:/webapp/errorFormat";
                } else {
                    InfoCalc infoCalc = new InfoCalc(amountInt,percentInt,yearsInt);
                    Calc calc = new Calc();
                    result = String.valueOf(calc.sum(amountInt,percentInt,yearsInt));
                    return "redirect:/webapp/result";
                }
            }
        } catch (NumberFormatException nfe) {
            return "redirect:/webapp/errorFormat";
        }
    }
    public boolean isCheckAmount(int amount) {
        return amount < 50_000;
    }
}
