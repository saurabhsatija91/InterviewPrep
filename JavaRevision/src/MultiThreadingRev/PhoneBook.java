package MultiThreadingRev;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class PhoneBook {
	private ConcurrentHashMap<String, Person> _db;
	
	public PhoneBook() {
		_db = new ConcurrentHashMap<>();
	}
	
	public Person lookUpByName (String name) {
		for (Entry<String, Person> e : _db.entrySet()) {
			if (e.getValue().getName().equals(name))
				return e.getValue();
		}
		return null;
	}
	
	public Person lookUpByPhoneNumber (String phoneNumber) {
		return _db.get(phoneNumber);
	}
	
	public synchronized void addPerson (Person person) {
		_db.put(person.getPhoneNumber(), person);
	}
	
	public synchronized void addPerson (Person... persons) {
		for (Person person : persons)
			_db.put(person.getPhoneNumber(), person);
	}
	
	public static void main(String[] args) {
		Person person1 = new Person("jmk", "8743562734");
		Person person2 = new Person("emmt", "3332322343");
		Person person3 = new Person("eclipse", "654345678");
		PhoneBook pb = new PhoneBook();
		pb.addPerson(person1, person2, person3);

		System.out.println(pb.lookUpByName("jmk"));
		System.out.println(pb.lookUpByPhoneNumber("3332322343"));

	}
}
