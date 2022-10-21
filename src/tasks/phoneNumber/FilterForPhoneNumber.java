package tasks.phoneNumber;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FilterForPhoneNumber {

    public void writingPhoneNumber() {
        String[] phoneNumbers = {"123 456 7890", "987-123-4567", "(123) 456-7890"};
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt"));

            for (String correct : phoneNumbers) {
                bufferedWriter.write(correct + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isPhone(String number){
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Pattern secondPattern = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");

        Matcher matcher = pattern.matcher(number);
        Matcher secondMatcher = secondPattern.matcher(number);

        return matcher.matches() || secondMatcher.matches();
    }

    public void checkingPhoneNumber() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (isPhone(line)){
                    System.out.println(line);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}