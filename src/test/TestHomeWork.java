package test;

import tasks.countOfWords.WordCounter;
import tasks.jsonFolder.FromFileToGson;
import tasks.phoneNumber.FilterForPhoneNumber;

public class TestHomeWork {

    public static void main(String[] args) {
        FilterForPhoneNumber filter = new FilterForPhoneNumber();
        WordCounter wordCounter = new WordCounter();
        FromFileToGson person = new FromFileToGson();

        filter.writingPhoneNumber();
        filter.checkingPhoneNumber();

        System.out.println();

        wordCounter.creatorFile();
        wordCounter.counter();

        System.out.println();

        person.creator();
        person.reader();

    }
}
