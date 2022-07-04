package by.crud.example.dao;

import by.crud.example.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Vasya"));
        people.add(new Person(++PEOPLE_COUNT,"Lesha"));
        people.add(new Person(++PEOPLE_COUNT,"Oleg"));
        people.add(new Person(++PEOPLE_COUNT,"Igor"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
