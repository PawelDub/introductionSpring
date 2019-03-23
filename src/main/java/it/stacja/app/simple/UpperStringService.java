package it.stacja.app.simple;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile("upper")
public class UpperStringService implements StringService {

    @Override
    public String processString(String text) {
        return text.toUpperCase();
    }
}
