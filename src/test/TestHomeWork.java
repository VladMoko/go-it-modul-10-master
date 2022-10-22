package test;

import tasks.countOfWords.WordCounter;
import tasks.jsonFolder.FromFileToGson;
import tasks.phoneNumber.FilterForPhoneNumber;

import java.io.IOException;

public class TestHomeWork {

    public static void main(String[] args) throws IOException {
        FilterForPhoneNumber filter = new FilterForPhoneNumber();
        FromFileToGson person = new FromFileToGson();
        WordCounter wordCounter = new WordCounter();

        filter.writingPhoneNumber();
        filter.checkingPhoneNumber();

        System.out.println();

        wordCounter.counter();

        System.out.println();

        person.creator();
        person.reader();

    }
}
