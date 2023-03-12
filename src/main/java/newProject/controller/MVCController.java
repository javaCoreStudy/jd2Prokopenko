package newProject.controller;

import newProject.entity.Person;
import newProject.rep.PersonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class MVCController {

    @Autowired
    PersonRep personRep;

    // localhost:8080/p
    @RequestMapping("/p")
    public String printStr(){
        System.out.println("Fofksfewofkeo");

        return "hello";
    }



    //localhost:8080/pp/query
    @RequestMapping("/pp/{query}")
    public String newPrint(@PathVariable String query){
        System.out.println(query);

        return "hello";
    }
//
//    @RequestMapping("/allpers")
//    public ModelAndView getAllPersons(){
//        List<Person> people = personRep.findAll();
//
//        System.out.println(people);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("people", people);
//
//        modelAndView.setViewName("hello");
//
//        return modelAndView;
//    }
//

// /person?id=1
    @RequestMapping("/person")
    public ModelAndView getOnePersonById(@RequestParam("id") int id){
        System.out.println(personRep.findOne(id));

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("person", personRep.findOne(id));

        return modelAndView;
    }



    // /person?id=1&name=Roman

    // /onepers/id=1&name=Roman

    @RequestMapping("/onepers")
    public ModelAndView showOnePerson(@ModelAttribute Person person){
        //System.out.println(person);

        personRep.createPerson(person);

        return new ModelAndView();
    }
//
//
//    /**
//     * .../addpers?name=Roman
//     *
//     * @param person
//     * @return
//     */
//    @RequestMapping("/addpers")
//    public ModelAndView addPerson(@ModelAttribute Person person){
//        System.out.println(person);
//
//        personRep.createPerson(person);
//
//        return new ModelAndView();
//    }
//
//    /**
//     * .../addpers?name=Roman&id=1&num=2
//     *
//     * @param person
//     * @return
//     */
//    @RequestMapping("/updatepers")
//    public ModelAndView updatePerson(@ModelAttribute Person person, @RequestParam int num){
//        System.out.println(person);
//        System.out.println(num);
//
//        personRep.updatePerson(num, person);
//
////        personRep.createPerson(person);
//
//        return new ModelAndView();
//    }
//
//    @RequestMapping(value = "/seebody", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ModelAndView ololo(@RequestBody Person person){
//        System.out.println(person);
//
//
////        personRep.createPerson(person);
//
//        return new ModelAndView();
//    }






}
