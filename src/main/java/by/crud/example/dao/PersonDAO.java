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
        people.add(new Person(++PEOPLE_COUNT,"Vasya",23,"kap@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Lesha",54,"yas@ya.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Oleg",28,"opbs@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT,"Igor",34,"03021@mail.ru"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id){
        Person personHowDelete = show(id);
        people.remove(personHowDelete);
    }
}
