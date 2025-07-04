package see.jkhere;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import see.jkhere.Entities.Citizen;
import see.jkhere.Entities.Passport;
import see.jkhere.Entities.Student;
import see.jkhere.Entities.Tutor;

import java.util.ArrayList;


public class App
{
    public static void main( String[] args){


       SessionFactory sf = new Configuration().configure().buildSessionFactory();
       Session session = sf.openSession();

        session.beginTransaction();
//
//
//        Tutor tutor = (Tutor) session.get(Tutor.class, 112);
//        System.out.println("Tutor :"+ tutor.getTutorName());
//        tutor.setTutorName("NIALL");
//        session.update(tutor);





//        Tutor tutor = (Tutor) session.load(Tutor.class, 114);
//        System.out.println(tutor.getTutorName());
//        List<Student> arr=tutor.getStudents();
//        for(Student s:arr){
//            System.out.println(s.getName());
//        }
//
//        ArrayList<Student> std= new ArrayList<>();
//        Tutor Ram = new Tutor();
//        Ram.setId(114);
//        Student asnit = new Student(10,"Aayushka",14,Ram);
//        std.add(asnit);
//        session.save(asnit);
//        Student asnit2 = new Student(11,"Asmita",15,Ram);
//        std.add(asnit2);
//        session.save(asnit2);
//        Student asnit3 = new Student(12,"Jvni",16,Ram);
//        std.add(asnit3);
//        session.save(asnit3);
//        Ram.setCourse("Mathematics");
//        Ram.setTutorName("John");
//        Ram.setStudents(std);
//        session.save(Ram);
        Passport passport = new Passport();
        passport.setNationality("American");
        passport.setPassportId(4L);
        passport.setVisaDetails("All around the world");
        Citizen citizen = new Citizen();
        citizen.setAddress("California");
        citizen.setName("John Doe");
        citizen.setPassport(passport);
        session.save(citizen);

        session.getTransaction().commit();
        session.close();
    }
}
