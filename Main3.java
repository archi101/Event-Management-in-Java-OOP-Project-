
import java.io.*;
import java.util.*;
// import read.*;
import java.nio.file.*;

import javax.lang.model.util.ElementScanner14;

// import register.*;

class Student implements Serializable {
    String id;
    String name;
    String MobileNo;
    String Email;
    String gender;
    

    Student() {
        super();
    }

    Student(String id, String name, String MobileNo, String Email, String gender) {

        this.id = id;
        this.name = name;
        this.MobileNo = MobileNo;
        this.Email = Email;
        this.gender = gender;
        
    }
}

class countS {
    public static void countFile(File f) throws IOException {
        int count = 0;

        // Try block to check for exceptions
        try {
            // System.out.println("hello");
            // Creating new file using File object above
            f.createNewFile();
        }

        // Catch block to handle the exception
        catch (Exception e) {
            // System.out.println();
        }

        // If the file is empty
        if (f.length() != 0) {

            try {

                // If file doesn't exists
                FileInputStream fis = null;

                fis = new FileInputStream(
                        f);
                ObjectInputStream ois = new ObjectInputStream(fis);

                Student c = null;

                while (fis.available() != 0) {

                    c = (Student) ois.readObject();
                    System.out.println(c.name);
                    count++;

                }

                // Closing the connection to release memory
                // resources using close() method
                ois.close();
                fis.close();
            }

            // Catch block to handle the exception
            catch (Exception e) {

                // Print the exception on the console
                // along with display message
                System.out.println("Error Occurred" + e);

                // Exception encountered line is also
                // displayed on console using the
                // printStackTrace() method
                e.printStackTrace();
            }
        } else {
            System.out.println("File is empty");
        }
        System.out.println(count);
    }
}

class Registration {
    public static boolean Registration(Student c, File f0) {
        boolean status = false;

        if (c != null) {

            try {
                FileOutputStream fos = null;

                fos = new FileOutputStream(
                        f0, true);

                if (f0.length() == 0) {
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(c);
                    oos.close();
                } else {

                    MyObjectOutputStream oos = null;
                    oos = new MyObjectOutputStream(fos);
                    oos.writeObject(c);
                    oos.close();
                }
                fos.close();
            }

            catch (Exception e) {

                System.out.println("Error Occurred" + e);
            }
            status = true;
        }

        return status;
    }
}

class Winner {
    public static boolean Addtonewtempfile(File temp, Student c) {
        boolean status = false;

        if (c != null) {

            try {
                FileOutputStream fos = null;

                fos = new FileOutputStream(
                        temp, true);

                if (temp.length() == 0) {
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(c);
                    oos.close();
                } else {

                    MyObjectOutputStream oos = null;
                    oos = new MyObjectOutputStream(fos);
                    oos.writeObject(c);
                    oos.close();
                }
                fos.close();
            }

            catch (Exception e) {

                System.out.println("Error Occurred" + e);
            }
            status = true;
        }

        return status;
    }

    static boolean winner(String idd, File f) {
        File newFile = new File("temp.txt");

        boolean status = false;

        // Try block to check for exceptions
        try {
            // System.out.println("hello");
            // Creating new file using File object above
            newFile.createNewFile();
        }

        // Catch block to handle the exception
        catch (Exception e) {
        }

        // If the file is empty
        if (f.length() != 0) {

            try {

                // If file doesn't exists
                FileInputStream fis = null;

                fis = new FileInputStream(
                        f);
                ObjectInputStream ois = new ObjectInputStream(fis);

                Student c = null;

                while (fis.available() != 0) {

                    c = (Student) ois.readObject();
                    if (!idd.equals(c.id)) {
                        Addtonewtempfile(newFile, c);

                    }
                }

                // Closing the connection to release memory
                // resources using close() method

                ois.close();
                fis.close();
                String name = f.getName();
                // System.out.println(name);
                // File Winner = new File("temp.txt");
                // status = newFile.renameTo(f);

                // Once all connection are closed after the
                // desired action change the flag state
                f.delete();
                Path oldFile = Paths.get("./temp.txt");

                try {
                    Files.move(oldFile, oldFile.resolveSibling(
                            name));
                    // System.out.println("File Successfully Rename");
                } catch (IOException e) {
                    System.out.println("operation failed");
                }

            } catch (Exception e) {

                // Print the exception on the console
                // along with display message
                System.out.println("Error Occurred" + e);

                // Exception encountered line is also
                // displayed on console using the
                // printStackTrace() method
                e.printStackTrace();
            }
        } else {
            System.out.println("File is empty");
        }
        return status;

    }
}

class MyObjectOutputStream extends ObjectOutputStream {

    // Constructor of this class
    // 1. Default
    MyObjectOutputStream() throws IOException {

        // Super keyword refers to parent class instance
        super();
    }

    // Constructor of this class
    // 1. Parameterized constructor
    MyObjectOutputStream(OutputStream o) throws IOException {
        super(o);
    }

    // Method of this class
    public void writeStreamHeader() throws IOException {
        return;
    }
}

abstract class Event {
    abstract boolean Registration(Student c, File f);

    abstract void Event_Info() throws IOException;

    // abstract void Contestant_count(File f) throws IOException;

    // abstract boolean Winner(String s);

    public static void Event_i() throws IOException {
        // ReadFile r1 = new ReadFile();
        // r1.ReadF("Shaastra.txt");
    }
}

abstract class Workshop {
    abstract void Info() throws IOException;

    abstract boolean Registration(Student c, File f);

}

class Tressure_Hunt extends Event {
    boolean Registration(Student c, File f) {

        boolean status = Registration.Registration(c, f);
        return status;
    }

    public void Event_Info() throws IOException {
        // ReadFile r1 = new ReadFile();
        // r1.ReadF("Tressure.txt");
    }

    public void Contestant_count(File f0) throws IOException {
        countS.countFile(f0);
    }

}

class chess extends Event {
    boolean Registration(Student c, File f) {

        boolean status = Registration.Registration(c, f);
        return status;
 // ReadFile r1 = new ReadFile();
        // r1.ReadF("Chess.txt");
    }

    public void Event_Info() throws IOException {
       
    }

    public void Contestant_count(File f1) throws IOException {
        countS.countFile(f1);
    }
}

class mousemazer extends Event {
    boolean Registration(Student c, File f) {

        boolean status = Registration.Registration(c, f);
        return status;
    }

    public void Event_Info() throws IOException {
        // ReadFile r1 = new ReadFile();
        // r1.ReadF("MouseMazer.txt");
    }

    public void Contestant_count(File f2) throws IOException {
        countS.countFile(f2);
    }

}

class World_Programming extends Event {
    boolean Registration(Student c, File f) {

        boolean status = Registration.Registration(c, f);
        return status;
    }

    public void Event_Info() throws IOException {
        // ReadFile r1 = new ReadFile();
        // r1.ReadF("WorldPrograming.txt");
    }

    public void Contestant_count(File f3) throws IOException {
        countS.countFile(f3);
    }

}

class Trade_Master extends Event {
    boolean Registration(Student c, File f) {

        boolean status = Registration.Registration(c, f);
        return status;
    }

    public void Event_Info() throws IOException {
        // ReadFile r1 = new ReadFile();
        // r1.ReadF("TradeMaster.txt");
    }

    public void Contestant_count(File f4) throws IOException {
        countS.countFile(f4);
    }

}

class Tech_Talks extends Event {
    boolean Registration(Student c, File f) {

        boolean status = Registration.Registration(c, f);
        return status;
    }

    public void Event_Info() throws IOException {
        // ReadFile r1 = new ReadFile();
        // r1.ReadF("TeckTalks.txt");
    }

    public void Contestant_count(File f5) throws IOException {
        countS.countFile(f5);
    }

}

class Hackathon extends Event {
    boolean Registration(Student c, File f) {

        boolean status = Registration.Registration(c, f);
        return status;
    }

    public void Event_Info() throws IOException {
        // ReadFile r1 = new ReadFile();
        // r1.ReadF("HAckathon.txt");
    }

    public void Contestant_count(File f6) throws IOException {
        countS.countFile(f6);
    }

}

class Web_Weaver extends Event {
    boolean Registration(Student c, File f) {

        boolean status = Registration.Registration(c, f);
        return status;
    }

    public void Event_Info() throws IOException {
        // ReadFile r1 = new ReadFile();
        // r1.ReadF("WebWeaver.txt");
    }

    public void Contestant_count(File f7) throws IOException {
        countS.countFile(f7);
    }

}

class python extends Workshop {
    void Info() throws IOException {
        // ReadFile r1 = new ReadFile();
        // r1.ReadF("Python.txt");
    }

    boolean Registration(Student c, File f) {

        boolean status = Registration.Registration(c, f);
        return status;
    }

}

class ML extends Workshop {
    void Info() throws IOException {
        // ReadFile r1 = new ReadFile();
        // r1.ReadF("ML.txt");
    }

    boolean Registration(Student c, File f) {

        boolean status = Registration.Registration(c, f);
        return status;
    }

}

public class Main3 {

    static float sum = 0f;
    static int count = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static float Rating(Integer c) {
        Map<Integer, Integer> hs = new HashMap<Integer, Integer>();
        list.add(c);
        count++;

        sum = 0;
        for (Integer x : list) {

            Integer count1 = hs.get(x);
            if (count1 == null) {
                count1 = 0;
            }

            hs.put(x, count1 + 1);

        }
        
        for (Map.Entry<Integer, Integer> entry : hs.entrySet()) {

            sum += entry.getKey() * entry.getValue();
        }

        return sum / count;

    }

    public static void main(String[] args) throws IOException {
        File f0 = new File("./Tressiure_hunt.txt");
        File f5 = new File("./Tech_Talks.txt");
        File f3 = new File("./World_Programing.txt");
        File f1 = new File("./Chess.txt");

        File f4 = new File("./Trade_Master.txt");
        File f9 = new File("./ML.txt");
        File f8 = new File("./Python.txt");
        File f7 = new File("./Web_Weaver.txt");
        File f6 = new File("./Hackathon.txt");
        File f2 = new File("./mousemazer.txt");

        Event a = new World_Programming();
        Event b = new Trade_Master();
        Event c = new Tech_Talks();
        Event d = new Web_Weaver();

        Workshop e = new python();
        Workshop f = new ML();
        Event g = new Tressure_Hunt();
        Event h = new chess();
        Event i = new mousemazer();
        Student s = null;
        System.out.println("About the Event");
        Event.Event_i();

        while (true) {
            System.out.println(
                    "Enter " + "\n" + "1 for Techevents" + "\n" + "2 for Non Techevents" + "\n" + "3 for Workshops"
                            + "\n" + "4 for Rating");
            Scanner se = new Scanner(System.in);
            int option = se.nextInt();
            if (option == 1) {
                System.out.println("Press" + "\n" + "1 for World_Programming " + "\n" + "2 for TradeMaster " + "\n"
                        + "3 for TechTalks" + "\n" + "4 for WebWeaver");
                int option1 = se.nextInt();
                if (option1 == 1) {
                    System.out.println(
                            "Press 1 for Registration, 2 for disqualify, 3 for registered contestents");
                    int option2 = se.nextInt();
                    if (option2 == 1) {
                        Scanner see = new Scanner(System.in);
                        System.out.println("enter id");
                        String id = see.next();
                        System.out.println("enter name");
                        String name = see.next();
                        System.out.println("enter roll");
                        String mobile = see.next();
                        System.out.println("enter Email");
                        String Email = see.next();
                        System.out.println("enter gender");
                        String gender = see.next();
            
                    
                        s = new Student(id, name, mobile, Email, gender);
                        a.Registration(s, f3);
                    } else if (option2 == 2) {
                        System.out.println("enter number of students disqualified");
                        int dis = se.nextInt();
                        for (int j = 0; j < dis; j++) {
                            System.out.println("Enter the ID");
                            Scanner sce = new Scanner(System.in);
                            String idd = sce.nextLine();
                            Winner.winner(idd, f3);
                        }
                    } else if (option2 == 3) {
                        countS.countFile(f3);
                    } else if (option2 == 4) {
                        a.Event_Info();
                    } else {
                        break;
                    }
                } else if (option1 == 2) {
                    System.out.println(
                            "Press 1 for Registration, 2 for disqualify, 3 for registered contestents");
                    int option2 = se.nextInt();
                    if (option2 == 1) {
                        Scanner see = new Scanner(System.in);
                        System.out.println("enter id");
                        String id = see.next();
                        System.out.println("enter name");
                        String name = see.next();
                        System.out.println("enter roll");
                        String mobile = see.next();
                        System.out.println("enter Email");
                        String Email = see.next();
                        System.out.println("enter gender");
                        String gender = see.next();
                        s = new Student(id, name, mobile, Email, gender);
                        b.Registration(s, f4);
                    } else if (option2 == 2) {
                        System.out.println("enter number of students disqualified");
                        int dis = se.nextInt();
                        for (int j = 0; j < dis; j++) {
                            System.out.println("Enter the ID");
                            Scanner sce = new Scanner(System.in);
                            String idd = sce.nextLine();
                            Winner.winner(idd, f4);
                        }
                    } else if (option2 == 3) {
                        countS.countFile(f4);
                    } else if (option2 == 4) {
                        b.Event_Info();
                    } else {
                        break;
                    }

                } else if (option1 == 3) {
                    System.out.println(
                            "Press 1 for Registration, 2 for disqualify, 3 for registered contestents");
                    int option2 = se.nextInt();
                    if (option2 == 1) {
                        Scanner see = new Scanner(System.in);
                        System.out.println("enter id");
                        String id = see.next();
                        System.out.println("enter name");
                        String name = see.next();
                        System.out.println("enter roll");
                        String mobile = see.next();
                        System.out.println("enter Email");
                        String Email = see.next();
                        System.out.println("enter gender");
                        String gender = see.next();
                        s = new Student(id, name, mobile, Email, gender);
                        c.Registration(s, f5);

                    } else if (option2 == 2) {
                        System.out.println("enter number of students disqualified");
                        int dis = se.nextInt();
                        for (int j = 0; j < dis; j++) {
                            System.out.println("Enter the ID");
                            Scanner sce = new Scanner(System.in);
                            String idd = sce.nextLine();
                            Winner.winner(idd, f5);
                        }
                    } else if (option2 == 3) {
                        countS.countFile(f5);
                    } else if (option2 == 4) {
                        c.Event_Info();
                    } else {
                        break;
                    }
                } else if (option1 == 4) {
                    System.out.println(
                            "Press 1 for Registration, 2 for disqualify, 3 for registered contestents");
                    int option2 = se.nextInt();
                    if (option2 == 1) {
                        Scanner see = new Scanner(System.in);
                        System.out.println("enter id");
                        String id = see.next();
                        System.out.println("enter name");
                        String name = see.next();
                        System.out.println("enter roll");
                        String mobile = see.next();
                        System.out.println("enter Email");
                        String Email = see.next();
                        System.out.println("enter gender");
                        String gender = see.next();
                        
                        s = new Student(id, name, mobile, Email, gender);
                        d.Registration(s, f7);

                    } else if (option2 == 2) {
                        System.out.println("enter number of students disqualified");
                        int dis = se.nextInt();
                        for (int j = 0; j < dis; j++) {
                            System.out.println("Enter the ID");
                            Scanner sce = new Scanner(System.in);
                            String idd = sce.nextLine();
                            Winner.winner(idd, f7);
                        }
                    } else if (option2 == 3) {
                        countS.countFile(f7);
                    } else if (option2 == 4) {
                        d.Event_Info();
                    } else {
                        break;
                    }
                } else {
                    break;
                }

            } else if (option == 2) {
                System.out.println("Press" + "\n" + "1 for TressureHunt " + "\n" + "2 for Chess " + "\n"
                        + "3 for mousemazer" + "\n" + "4 for exit");
                int option1 = se.nextInt();
                if (option1 == 1) {
                    System.out.println(
                            "Press 1 for Registration, 2 for disqualify, 3 for registered contestents");
                    int option2 = se.nextInt();
                    if (option2 == 1) {
                        Scanner see = new Scanner(System.in);
                        System.out.println("enter id");
                        String id = see.next();
                        System.out.println("enter name");
                        String name = see.next();
                        System.out.println("enter roll");
                        String mobile = see.next();
                        System.out.println("enter Email");
                        String Email = see.next();
                        System.out.println("enter gender");
                        String gender = see.next();
        
                        s = new Student(id, name, mobile, Email, gender);
                        g.Registration(s, f0);

                    } else if (option2 == 2) {
                        System.out.println("enter number of students disqualified");
                        int dis = se.nextInt();
                        for (int j = 0; j < dis; j++) {
                            System.out.println("Enter the ID");
                            Scanner sce = new Scanner(System.in);
                            String idd = sce.nextLine();
                            Winner.winner(idd, f0);
                        }
                    } else if (option2 == 3) {
                        countS.countFile(f0);
                    } else if (option2 == 4) {
                        g.Event_Info();
                    }

                    else {
                        break;
                    }
                } else if (option1 == 2) {
                    System.out.println(
                            "Press 1 for Registration, 2 for disqualify, 3 for registered contestents");
                    int option2 = se.nextInt();
                    if (option2 == 1) {
                        Scanner see = new Scanner(System.in);
                        System.out.println("enter id");
                        String id = see.next();
                        System.out.println("enter name");
                        String name = see.next();
                        System.out.println("enter roll");
                        String mobile = see.next();
                        System.out.println("enter Email");
                        String Email = see.next();
                        System.out.println("enter gender");
                        String gender = see.next();
                        s = new Student(id, name, mobile, Email, gender);
                        h.Registration(s, f1);

                    } else if (option2 == 2) {
                        System.out.println("enter number of students disqualified");
                        int dis = se.nextInt();
                        for (int j = 0; j < dis; j++) {
                            System.out.println("Enter the ID");
                            Scanner sce = new Scanner(System.in);
                            String idd = sce.nextLine();
                            Winner.winner(idd, f1);
                        }
                    } else if (option2 == 3) {
                        countS.countFile(f1);
                    } else if (option2 == 4) {
                        h.Event_Info();
                    } else {
                        break;
                    }

                } else if (option1 == 3) {
                    System.out.println(
                            "Press 1 for Registration, 2 for disqualify, 3 for registered contestents");
                    int option2 = se.nextInt();
                    if (option2 == 1) {
                        Scanner see = new Scanner(System.in);
                        System.out.println("enter id");
                        String id = see.next();
                        System.out.println("enter name");
                        String name = see.next();
                        System.out.println("enter roll");
                        String mobile = see.next();
                        System.out.println("enter Email");
                        String Email = see.next();
                        System.out.println("enter gender");
                        String gender = see.next();
                        s = new Student(id, name, mobile, Email, gender);
                        i.Registration(s, f2);

                    } else if (option2 == 2) {
                        System.out.println("enter number of students disqualified");
                        int dis = se.nextInt();
                        for (int j = 0; j < dis; j++) {
                            System.out.println("Enter the ID");
                            Scanner sce = new Scanner(System.in);
                            String idd = sce.nextLine();
                            Winner.winner(idd, f2);
                        }
                    } else if (option2 == 3) {
                        countS.countFile(f2);
                    } else if (option2 == 4) {
                        i.Event_Info();
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else if (option == 3) {
                System.out.println("Press" + "\n" + "1 for Python " + "\n" + "2 for ML " +"\n"+ "3 for exit");
                int option1 = se.nextInt();
                if (option1 == 1) {
                    System.out.println("Press 1 for Registration 2 for event information");
                    int option2 = se.nextInt();
                    if (option2 == 1) {
                        Scanner see = new Scanner(System.in);
                        System.out.println("enter id");
                        String id = see.next();
                        System.out.println("enter name");
                        String name = see.next();
                        System.out.println("enter roll");
                        String mobile = see.next();
                        System.out.println("enter Email");
                        String Email = see.next();
                        System.out.println("enter gender");
                        String gender = see.next();
                        s = new Student(id, name, mobile, Email, gender);
                        e.Registration(s, f8);
                    }else if (option2 == 2) {
                        e.Info();
                    } else {
                        break;
                    }
                } else if (option1 == 2) {
                    System.out.println("Press 1 for Registration 2 for event information");
                    int option2 = se.nextInt();
                    if (option2 == 1) {
                        Scanner see = new Scanner(System.in);
                        System.out.println("enter id");
                        String id = see.next();
                        System.out.println("enter name");
                        String name = see.next();
                        System.out.println("enter roll");
                        String mobile = see.next();
                        System.out.println("enter Email");
                        String Email = see.next();
                        System.out.println("enter gender");
                        String gender = see.next();
                        s = new Student(id, name, mobile, Email, gender);
                        f.Registration(s, f9);
                    } else if (option2 == 2) {
                        f.Info();
                    } else {
                        break;
                    }

                } else {
                    break;
                }
            } else if (option == 4) {
                System.out.println("Rate in scale of 1-5");
                Scanner sc = new Scanner(System.in);
                int ratings = sc.nextInt();
                float z = Rating(ratings);
                System.out.println(z);
            }

            else

            {
                break;
            }
        }

    }
}