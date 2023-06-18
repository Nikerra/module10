package org.example.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.model.InfoCalc;
import org.example.service.Calc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/")
@PropertySource("classpath:application.properties")
@Data
@RequiredArgsConstructor
public class CalcController {

    @Value("${default.min.amount.error}")
    private String MIN_AMOUNT_ERROR;

    @Value("${default.invalid.format}")
    private String INVALID_FORMAT;

    @Value("${default.min.amount}")
    private Integer minAmount;

    private final Calc calc;


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
    public ModelAndView result(Model model) {
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("/result.jsp");
        String result = (String) model.getAttribute("result");
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
    public String calcOperation(@RequestParam String amount, String percent, String years, Model model, RedirectAttributes attributes) {
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
                    String result = String.valueOf(calc.sum(infoCalc));
                    attributes.addFlashAttribute("result", result);
                    model.addAttribute("result", result);
                    return "redirect:/webapp/result/";
                }
            }
        } catch (NumberFormatException nfe) {
            return "redirect:/webapp/errorFormat";
        }
    }
    public boolean isCheckAmount(int amount) {
        return amount < minAmount;
    }
}
