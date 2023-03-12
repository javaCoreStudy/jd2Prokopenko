package newProject;

import newProject.entity.Person;
import newProject.rep.PersonRep;
import newProject.rep.PersonRepImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext("newProject");
//
        PersonRep rep = context.getBean("personRepImpl", PersonRep.class);
//
        System.out.println(rep.findAll());

        System.out.println(rep.findOne(1));

//        System.out.println(rep.updatePerson(1, new Person("Serega")));
//
//        rep.createPerson(new Person("Valera"));


    }
}
