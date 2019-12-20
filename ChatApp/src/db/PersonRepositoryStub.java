package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Person;
import domain.Role;

public class PersonRepositoryStub implements PersonRepository {

    private Map<String, Person> persons = new HashMap<String, Person>();

    public PersonRepositoryStub () {
        Person administrator = new Person("bib@ucll.be", "t", "Bib", "Liothekaris", 46, "Female", Role.BIB);
        add(administrator);
        Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", 61, "Male",Role.LID );
        add(jan);
        Person an = new Person("an@ucll.be", "t", "An", "Cornelissen", 29,"Female" ,Role.LID );
        add(an);
        Person jos = new Person("jos@ucll.be", "t", "Jos", "Ke", 37, "Male",Role.LID);
        add(jos);
        Person freddy = new Person("freddy@ucll.be", "t", "Freddy", "Peeters", 53, "Male", Role.LID);
        add(freddy);
    }

    public Person get(String personId){
        if(personId == null){
            throw new IllegalArgumentException("No id given");
        }
        return persons.get(personId);
    }

    public List<Person> getAll(){
        return new ArrayList<Person>(persons.values());
    }

    public void add(Person person){
        if(person == null){
            throw new IllegalArgumentException("No person given");
        }
        if (persons.containsKey(person.getUserId())) {
            throw new IllegalArgumentException("User already exists");
        }
        persons.put(person.getUserId(), person);
    }

    public void update(String userId, Person person){
        if(person == null){
            throw new IllegalArgumentException("No person given");
        }
        persons.get(userId).setFirstName(person.getFirstName());
        persons.get(userId).setLastName(person.getLastName());
        persons.get(userId).setAge(person.getAge());
        persons.get(userId).setGender(person.getGender());
    }

    public void delete(String personId){
        if(personId == null){
            throw new IllegalArgumentException("No id given");
        }
        persons.remove(personId);
    }

    public Person getAuthenticatedUser(String email, String password) {
        Person person = get(email);

        if (person != null && person.isCorrectPassword(password)) {
            return person;
        }
        else {
            return null;
        }
    }
}
