package control;

import java.io.IOException;

public interface StateController {
    void run(GameController gc) throws IOException;
}
