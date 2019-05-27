import java.util.*;
import java.io.*;
import java.io.IOException;


/*

mi y hj forman una pareja bloqueante en E si:
mi y hj no son pareja en E.
mi prefiere a hj antes que a pE(mi) y hj prefiere a mi antes que a pE(hj). Es decir, mi y hj preferirian ser pareja, en lugar de sus actuales en E.

*/

public class StableMatching {

int[][] preferenciasHombres;
int[][] preferenciasMujeres;
int[] matchHombres; // Arreglo que establece con que mujer sale un hombre (El hombre es representado por el indice del arreglo y la mujer por el contenido del arreglo)
int[] matchMujeres; // Arreglo que establece con que hombre sale una mujer (La mujer es representada por el indice del arreglo y el hombre por el contenido del arreglo)
int numberOfPeople;

public void readFile(String filePath) {
	BufferedReader fileReader = null;

	try {
			String currentLineString = null;
			String[] currentLineArray = null;
			int currentLineNumber = 0;
			String person;

			fileReader = new BufferedReader(new FileReader(filePath));
			
			// leo linea a linea para leer la persona y sus preferencias.
		// 'persona' puede ser tanto hombre como mujer
			while ((currentLineString = fileReader.readLine()) != null ) {

				// separo la linea por el delimitador
				currentLineArray = currentLineString.split(",");
				
				if(preferenciasHombres == null || preferenciasMujeres == null){ //Si no habia inicializado la estructura, la inicializo
					numberOfPeople = currentLineArray.length - 1;
					preferenciasHombres = new int[numberOfPeople][numberOfPeople];
					preferenciasMujeres = new int[numberOfPeople][numberOfPeople];
					matchHombres = new int[numberOfPeople];
					matchMujeres = new int[numberOfPeople];
				}

				if(currentLineNumber < numberOfPeople){
					for (int i = 0; i < preferenciasHombres[0].length ; i++) {
						person = currentLineArray[i+1];
						preferenciasHombres[currentLineNumber][i] = Integer.valueOf(person.substring(person.length()-1));
					}
				}else{
					for (int i = 0; i < preferenciasMujeres[0].length ; i++) {
						person = currentLineArray[i+1];
						preferenciasMujeres[currentLineNumber - numberOfPeople][i] = Integer.valueOf(person.substring(person.length()-1));
					}
				}
				currentLineNumber++;
				


			}

		

			showPreferencias();

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
	// El valor '0' en el arreglo match significa que no tienen pareja
	int contador = 0;
	int aux = 0;
	boolean todosEmparejados = false;


	int hombre = i; // La posicion de Hombre1 es en realidad 0, por lo que en los indices se resta 1
	int indx_h = hombre-1;

	int mujer = preferencias[hombre-1][contador]; // Idem 'int hombre'
	int indx_m = mujer-1;

	// while(haya hombres sin pareja)
	if(matchMujeres[indx_m] == 0){
		matchHombres[indx_h] = mujer;
		matchMujeres[indx_m] = hombre;	
	}else{
		int indx_pref_actual=0, indx_pref_propuesta=0;
		int actual = matchMujeres[indx_m];

		while(actual != preferencias[indx_m][indx_pref_actual]  || hombre != preferencias[indx_m][indx_pref_propuesta]){
			if(actual != preferencias[indx_m][indx_pref_actual] ){
				indx_pref_actual++;
			}

			if(hombre != preferencias[indx_m][indx_pref_propuesta] ){
				indx_pref_propuesta++;
			}
		}

		if(indx_pref_propuesta < indx_pref_actual){ 
			// Switch pareja
			matchHombres[actual-1] = 0;
			matchHombres[indx_h] = mujer;
			matchMujeres[indx_m] = hombre;
			contador=0;
			hombre++;

		}else{
			// Rechazar
			contador++;
		}
	}
}









public void show() {

}

public void showPreferencias(){
	for(int i = 0; i < preferenciasHombres.length;  i++){
		System.out.print("Hombre"+(i+1)+ " , ");
		for(int j = 0; j < preferenciasHombres[0].length;  j++){
			//if(){
			//	System.out.print(preferencias[i][j] + " , ");
			//}else{
				System.out.print("Mujer"+preferenciasHombres[i][j] + " , ");
			//}
		}
		System.out.println();
	}

	

	for(int i = 0; i < preferenciasMujeres.length;  i++){
		System.out.print("Mujer"+(i+1)+ " , ");
		for(int j = 0; j < preferenciasMujeres[0].length;  j++){
			//if(){
			//	System.out.print(preferencias[i][j] + " , ");
			//}else{
				System.out.print("Hombre"+preferenciasMujeres[i][j] + " , ");
			//}
		}
		System.out.println();
	}
}



}



/*
if(preferencias == null){ //Si no habia inicializado la estructura, la inicializo
					preferencias = new String[2*numberOfPeople][numberOfPeople+1];
					match = new String[numberOfPeople][2];
				}

				if(currentLineNumber < 2*numberOfPeople){
					preferencias[currentLineNumber][0] = person;
					if(currentLineNumber < numberOfPeople){
						match[currentLineNumber][1] = person;
					}
					
					for (int i = 1; i < preferencias[0].length ; i++) {
						preferencias[currentLineNumber][i] = currentLineArray[i];
					}
				}

				currentLineNumber++; */


/* 
				if(preferencias == null){ //Si no habia inicializado la estructura, la inicializo
					preferencias = new int[2*numberOfPeople][numberOfPeople];
					match = new int[numberOfPeople][numberOfPeople];
				}

				for (int i = 0; i < preferencias[0].length ; i++) {
					person = currentLineArray[i+1];
					preferencias[currentLineNumber][i] = Integer.valueOf(person.substring(person.length()-1));
				}

				currentLineNumber++;
*/