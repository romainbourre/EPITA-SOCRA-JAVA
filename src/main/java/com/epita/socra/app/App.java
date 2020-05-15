package com.epita.socra.app;

import com.epita.socra.app.tools.*;

/**
 * Hello world!
 */
public final class App {
    private IOAdapter adapter;

    private App() {
        this(new ConsoleAdapter());
    }

    public App(IOAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App application = new App();
        application.run();
    }

    public void run() {
        try
        {
            adapter.write("Hello, what's your number ?");
            String valueToConvert = adapter.read();

            IConverter romanConverter = new RomanConverter();
            IConverter arabicConverter = new ArabicConverter();

            String romanNumber = romanConverter.convert(valueToConvert);
            String arabicNumber = arabicConverter.convert(valueToConvert);
            adapter.write("Your Roman number is: " + romanNumber);
            adapter.write("Your Arabic number is: " + arabicNumber);
        }
        catch (Exception e)
        {
            System.out.println("error: " + e.getMessage());
        }
    }
}
