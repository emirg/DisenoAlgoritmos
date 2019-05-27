package StableMatching;

import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class StableMatching {

    HashMap<String, LinkedList<String>> preferencias;
    HashMap<String, String> match;
    LinkedList<String> hombresLibres;
    int cantidadPersonas;

    public void readFile(String filePath) {
        BufferedReader fileReader = null;

        try {
            String currentLineString = null;
            String[] currentLineArray = null;
            preferencias = new HashMap<>();
            match = new HashMap<>();

            fileReader = new BufferedReader(new FileReader(filePath));
            int currentLineNumber = 0;
            hombresLibres = new LinkedList<>();
            // leo linea a linea para leer la persona y sus preferencias.
            // 'persona' puede ser tanto hombre como mujer
            while ((currentLineString = fileReader.readLine()) != null) {

                // separo la linea por el delimitador
                currentLineArray = currentLineString.split(",");
                int cantidadElecciones = currentLineArray.length - 1;
                String person = currentLineArray[0];
                LinkedList<String> preferenciasActual = new LinkedList();

                if (cantidadPersonas == 0) {
                    cantidadPersonas = cantidadElecciones * 2;
                }

                for (int i = 1; i < currentLineArray.length; i++) {

                    preferenciasActual.add(currentLineArray[i]);

                }

                if (currentLineNumber < cantidadElecciones) {
                    hombresLibres.add(person);
                }

                preferencias.put(person, preferenciasActual);

                currentLineNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    // close reader, good practice
                    fileReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void resolv() {

        String hombreEmparejando, hombreActual;
        String mujer;

        while (!hombresLibres.isEmpty()) {
            for (int i = 0; i < hombresLibres.size(); i++) {

                hombreEmparejando = hombresLibres.get(i);
                mujer = preferencias.get(hombreEmparejando).remove(0);
                if (match.get(mujer) == null) {
                    match.put(hombreEmparejando, mujer);
                    match.put(mujer, hombreEmparejando);
                    hombresLibres.remove(hombreEmparejando);
                } else {
                    hombreActual = match.get(mujer);
                    
                    LinkedList<String> preferenciasMujer = preferencias.get(mujer);
                    
                    int rankActual = preferenciasMujer.indexOf(hombreActual), 
                        rankPropuesta = preferenciasMujer.indexOf(hombreEmparejando);

                    if (rankPropuesta < rankActual) {
                        match.put(mujer, hombreEmparejando);
                        match.put(hombreEmparejando, mujer);
                        match.put(hombreActual, null);
                        hombresLibres.remove(hombreEmparejando);
                        hombresLibres.add(hombreActual);
                    }
                }

            }
        }

    }

    public void show() {
        String matchString =   match.toString().replaceAll(" ", "");
        String[] parejas = matchString.split("[{,}]");

        String salida = "";
        for (int i = 1; i < parejas.length; i++) {
            if(parejas[i].charAt(0) == 'W'){
                salida = salida + parejas[i] + "\n";
            }
        }
        System.out.println(salida);
    }
}
