package dossoccer.rest;

import dossoccer.gameengine.state.FieldSquare;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rafael on 20/04/17.
 */
@RestController
public class FieldSquareController {
    @CrossOrigin(origins = "http://127.0.0.1:41699")
    @RequestMapping("/fieldSquares")
    public FieldSquare[] fieldSquares() {
        return FieldSquare.values();
    }
}
