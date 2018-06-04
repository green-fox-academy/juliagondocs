package com.greenfox.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;
@Controller
public class SayHelloWebController {
    String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
            "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
            "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
            "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};
    String[] fontColor = {"red", "blue", "green", "yellow", "orange", "dark", "lavender", "cyan", "maroon", "navy", "chocolate"};
    Random rnd = new Random();

    @RequestMapping("/web/greeting")
    public String sayHello(Model model, @RequestParam("name") String name) {
        int counter = rnd.nextInt(hellos.length);
        int counterColor = rnd.nextInt(fontColor.length);
        int sizeFont = 15 + rnd.nextInt(50);
        model.addAttribute("name", name);
        model.addAttribute("hellos", hellos[counter]);
        model.addAttribute("fontSize", sizeFont);
        model.addAttribute("fontColor", fontColor[counterColor]);

        return "greeting";
    }
}
