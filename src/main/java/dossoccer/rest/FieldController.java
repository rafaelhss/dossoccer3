package dossoccer.rest;

import java.util.concurrent.atomic.AtomicLong;

import dossoccer.gameengine.state.Field;
import dossoccer.gamestate.FieldFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://127.0.0.1:41699")
    @RequestMapping("/field/kickoff")
    public Field kickOff() {
        return new FieldFactory().kickOff();
    }
}