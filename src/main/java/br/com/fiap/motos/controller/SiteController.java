package br.com.fiap.motos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/site")
public class SiteController {

    private static final Logger log = LoggerFactory.getLogger( SiteController.class );

    @GetMapping(value = {"", "/", "/index.html", "index"})
    public ModelAndView getSite() {
        log.info( "Usuário acessando o site:  " );
        ModelAndView mv = new ModelAndView( "/index" );
        return mv;
    }

}
