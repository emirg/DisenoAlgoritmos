import java.util.*;
import java.io.*;
import java.io.IOException;


/*
 * No modificar este archivo.
 */
public class App {
	public static void main(String[] args) {
		new App(args[0]);
	}

	public App(String filePath) {
    long startTime, estimatedTime;

    StableMatching matcher = new StableMatching();

    startTime = System.nanoTime();
    matcher.readFile(filePath);
    estimatedTime = System.nanoTime() - startTime;

    double secondsParse = (double) estimatedTime / 1000000000.0;

    startTime = System.nanoTime();
    //matcher.resolv();
    estimatedTime = System.nanoTime() - startTime;

    double secondsResolv = (double) estimatedTime / 1000000000.0;


    matcher.show();

    System.out.format("Tiempos : %f | %f%n", secondsParse, secondsResolv);
	}
}
