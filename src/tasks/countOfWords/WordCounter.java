package tasks.countOfWords;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class WordCounter {

    public void creatorFile() {
        String[] array = {"the day is sunny the the", "the sunny is is"};
        File file = new File("words.txt");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (String str : array) {
                bufferedWriter.write(str + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void counter() {
        List<String> list = new ArrayList<>();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" ");

                Collections.addAll(list, data);
            }
            Map<String, Integer> count = list.stream()
                            .collect(Collectors.toMap(
                                    e -> e,
                                    e -> 1,
                                    Integer::sum
                            ));
            count.forEach((k,v) -> System.out.println(k + ": " + v));
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
