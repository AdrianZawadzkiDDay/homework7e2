package pl.bykowski.homework7_2.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bykowski.homework7_2.repository.ArticleDAOList;
import pl.bykowski.homework7_2.service.ArticleDB;


@Component
@RequestMapping("/news")
public class ArticleController {

    ArticleDAOList articleDaoList;

    public ArticleController(ArticleDAOList articleDaoList) {
        this.articleDaoList = articleDaoList;
    }

    @GetMapping
    public String getVehicles(Model model){
        model.addAttribute("articles", articleDaoList.findAll());
        model.addAttribute("delNews", new ArticleDB());
        model.addAttribute("modNews", new ArticleDB());

        return "index";
    }


    @GetMapping("/modification")
    public String modElementVehicle(@ModelAttribute ArticleDB articleDB){
            articleDaoList.updateArticle(articleDB);
            return "redirect:/news";
        }


    @GetMapping("/delete/{id}")
    public String removeVehicle(@PathVariable Long id){
        articleDaoList.deleteArticle(id);
        return "redirect:/news";
    }


}
