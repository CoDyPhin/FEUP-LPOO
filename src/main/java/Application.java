import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import control.GameController;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, FontFormatException {
        Screen screen;
        TerminalSize terminalSize = new TerminalSize(50, 25);

        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();

        File fontFile = new File("files/square.ttf");
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);


        Font loadedFont = font.deriveFont(Font.PLAIN, 10);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        defaultTerminalFactory.setForceAWTOverSwing(true);
        defaultTerminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

        Terminal terminal = defaultTerminalFactory.setInitialTerminalSize(terminalSize).createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        GameController gc = new GameController(screen);
        while(gc.getCurrentController() != null){
            gc.run();
        }
    }
}
