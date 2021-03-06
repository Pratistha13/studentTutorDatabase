package com.example.studentTutorDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.studentTutorDatabase.domain.Department;
import com.example.studentTutorDatabase.domain.DepartmentRepository;
import com.example.studentTutorDatabase.domain.Student;
import com.example.studentTutorDatabase.domain.StudentRepository;
import com.example.studentTutorDatabase.domain.Tutor;
import com.example.studentTutorDatabase.domain.TutorRepository;
import com.example.studentTutorDatabase.domain.User;
import com.example.studentTutorDatabase.domain.UserRepository;

@SpringBootApplication
public class StudentTutorDatabaseApplication {
	private static final Logger log = LoggerFactory.getLogger(StudentTutorDatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StudentTutorDatabaseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner tutorDemo(TutorRepository repository, DepartmentRepository drepository, UserRepository urepository, StudentRepository srepository) {
		return (args) -> {
			log.info("save a couple of Departments");
			Department d1 = new Department("IT");
			Department d2 = new Department("Business");
			Department d3 = new Department("Law");
			Department d4 = new Department("Hospitality");
			Department d5 = new Department("Restaurants");
			Department d6 = new Department("Human Resources");
			Department d7 = new Department("Logistics");
			drepository.save(d1);
			drepository.save(d2);
			drepository.save(d3);
			drepository.save(d4);
			drepository.save(d5);
			drepository.save(d6);
			drepository.save(d7);
			
			
			log.info("save some tutors");
			repository.save(new Tutor("John", "Johnson", "john@john.com", "Arabianranta 2A, Helsinki", "0456892342", "1984-02-12", d1));
			repository.save(new Tutor("Mary", "Sluis", "mary@sluis.com", "Toronto, Canada", "0406012345", "1982-08-19", d2));
			repository.save(new Tutor("Kyoichi", "Maliniak", "Malinaik@haaga.com", "Pasila, Helsinki", "123456", "1983-05-10", d3));
			repository.save(new Tutor("Malini", "Vijabalaji", "malini@haaga-helia.com", "Leppavaara, Espoo", "574523452", "1987-06-20", d4));
			repository.save(new Tutor("Pratik", "Subedi", "subedi@haaga-helia.com", "Myyrmäki, Vantaa", "00242545", "1963-06-01", d5));
			repository.save(new Tutor("Niwas", "Maskey", "maskey@haaga-helia.com", "Kannelmäki, Helsinki", "0560175334", "1956-02-12", d6));
			repository.save(new Tutor("Gautam", "Chaudhary", "chaudhary@haaga-helia.com", "Sörnäinen, Helsinki", "09284345", "1972-11-07", d7));
			repository.save(new Tutor("Nilabh", "Terkki", "nilabh@haaga-helia.com", "Hakaniemi, Helsinki", "264895637", "1973-04-20", d2));
			repository.save(new Tutor("Berni", "Simmel", "simmel@haaga-helia.com", "Iso-omena, Espoo", "139863795", "1996-01-21", d3));
			repository.save(new Tutor("Mariya", "Ganeva", "ganeva@haaga-helia.com", "Herttoniemi, Helsinki", "45678742", "1992-08-19", d1));
			repository.save(new Tutor("Guoxiang", "Nooteboom", "noteboom@haaga-helia.com", "Vuosaari Helsinki", "324567", "1962-09-09", d7));
			repository.save(new Tutor("Anastasia", "Kulakova", "anastasia@haaga-helia.com", "Malmi, Helsinki", "8976543", "1987-08-08", d6));
			repository.save(new Tutor("Natalia", "Baksh", "natalia@haaga-helia.com", "Turku", "5698244", "1990-08-29", d5));
			repository.save(new Tutor("Asmara", "Riaz", "asmara@haaga-helia.com", "Jarvenpää", "0983476", "1994-08-17", d4));
			repository.save(new Tutor("Joanna", "Tohila", "joanna@haaga-helia.com", "Srilanka", "436782", "1995-08-03", d1));
			repository.save(new Tutor("Tiina", "Haapala", "tiina@haaga-helia.com", "Nokia, Finland", "09872345", "1982-03-20", d2));
			
			
			log.info("save some students");
			srepository.save(new Student("Helena", "Trump", "helena@haaga-helia.com", "3rd", "0456892342", d1));
			srepository.save(new Student("Angela", "Toivonen", "angelaToi@haaga-helia.com", "1st", "047612323", d4));
			srepository.save(new Student("Jaana", "Kusisto", "jaana@haaga-helia.com", "3rd", "0458923894", d2));
			srepository.save(new Student("Johanna", "Jim", "johanna@haaga-helia.com", "2nd", "04777777", d1));
			srepository.save(new Student("Jennamari", "Kanervala", "jenna@haaga-helia.com", "final", "046666642", d7));
			srepository.save(new Student("Sonia", "Pesonen", "sonia@haaga-helia.com", "third", "042222222", d5));
			srepository.save(new Student("Anni", "Sirku", "anni@haaga-helia.com", "second", "042234333", d6));
			srepository.save(new Student("Sini", "Hinkkula", "sini@haaga-helia.com", "first", "043680000", d1));
			srepository.save(new Student("Nelly", "Ahola", "nelly@haaga-helia.com", "fourth", "045685555", d2));
			srepository.save(new Student("Emmi", "Halonen", "emmy@haaga-helia.com", "sixth", "04565332", d3));
			srepository.save(new Student("Tania", "Koskonen", "tania@haaga-helia.com", "2nd", "04566556", d5));
			srepository.save(new Student("Tom", "Pownall", "tom@haaga-helia.com", "3rd", "0987265", d4));
			srepository.save(new Student("Andrea", "Bigeweea", "andrea@haaga-helia.com", "first", "04566432", d1));
			srepository.save(new Student("Jonas", "Niemi", "Jonas@haaga-helia.com", "1st", "7456342", d7));
			srepository.save(new Student("Charles", "Jackkson", "charles@haaga-helia.com", "3rd", "4567889", d6));
			
			
			// Create users: admin/admin user/user
			log.info("Create users");
			urepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			urepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
			
			log.info("fetch all tutors");
			for (Tutor tutor : repository.findAll()) {
				log.info(tutor.toString());
			}

		};
	}
}