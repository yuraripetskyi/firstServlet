import Entity.Person;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {


        List<Person> users = Arrays.asList(
                new Person(1 , "Yurii", "Yur", 21 ),
                new Person(2,"Andriy","And", 20),
                new Person(3, "Taras", "Tar", 19)

        );

        String tempPAth = System.getProperty("user.dir")+
                File.separator+
                "src"+
                File.separator+
                "main"+
                File.separator+
                "java"+
                File.separator+
                "template"+
                File.separator+
                "temp.txt";

        File file = new File(tempPAth);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(tempPAth));
        String line = "";
        String collector = "";
        while ((line = bufferedReader.readLine())!=null){
          collector = collector + line;
        }

        for (Person user : users) {
          String newCollector =  collector.replace("${xxx}", user.toString());


            String resultFilePAth = System.getProperty("user.dir")+
                    File.separator+
                    "src"+
                    File.separator+
                    "main"+
                    File.separator+
                    "webapp"+
                    File.separator+
                    "pagesx"+
                    File.separator+
                    "user"+user.getId()+".html"
                    ;
                File userFile = new File(resultFilePAth);
            PrintWriter printWriter = new PrintWriter(userFile);
            printWriter.println(newCollector);
            printWriter.close();
        }


    }
}
