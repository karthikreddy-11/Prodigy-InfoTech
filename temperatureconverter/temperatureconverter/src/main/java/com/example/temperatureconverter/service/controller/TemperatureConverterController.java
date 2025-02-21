package com.example.temperatureconverter.service.controller;//package com.example.temperatureconverter.controller;

import com.example.temperatureconverter.service.TemperatureConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/temperature")
@CrossOrigin(origins = "*") // Allow frontend requests from any origin
public class TemperatureConverterController {

    @Autowired
    private TemperatureConverterService converterService;

    @GetMapping("/convert")
    public String convertTemperature(
            @RequestParam double value,
            @RequestParam String from,
            @RequestParam String to) {

        from = from.trim().toUpperCase();
        to = to.trim().toUpperCase();

        double result;
        switch (from) {
            case "C":
                result = (to.equals("F")) ? converterService.celsiusToFahrenheit(value) :
                         (to.equals("K")) ? converterService.celsiusToKelvin(value) :
                         Double.NaN;
                break;
            case "F":
                result = (to.equals("C")) ? converterService.fahrenheitToCelsius(value) :
                         (to.equals("K")) ? converterService.fahrenheitToKelvin(value) :
                         Double.NaN;
                break;
            case "K":
                result = (to.equals("C")) ? converterService.kelvinToCelsius(value) :
                         (to.equals("F")) ? converterService.kelvinToFahrenheit(value) :
                         Double.NaN;
                break;
            default:
                return "{\"error\": \"Invalid unit. Use C, F, or K.\"}";
        }

        if (Double.isNaN(result)) {
            return "{\"error\": \"Invalid conversion. Check input values.\"}";
        }

        return String.format("{\"input\": \"%.2f%s\", \"output\": \"%.2f%s\"}", value, from, result, to);
    }
}
