package tasks.jsonFolder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FromFileToGson {

    public void creator() {
        String[] array = {"name age", "alice 25", "ryan 30"};
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("text.txt"));
            for (String str : array) {
                bufferedWriter.write(str + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reader() {
        try {
            Scanner scanner = new Scanner(new File("text.txt"));
            List<String> list = new ArrayList<>();
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
            list.remove(0);
            List<Person> person = new ArrayList<>();

            for (String str : list) {
                String[] array = str.split(" ");
                String name = array[0];
                Integer age = Integer.parseInt(array[1]);
                person.add(new Person(name, age));
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(person);

            System.out.println(json);

            OutputStream fos = new FileOutputStream("user.json");
            fos.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
