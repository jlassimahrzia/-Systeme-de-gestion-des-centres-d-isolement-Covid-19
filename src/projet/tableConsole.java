package projet;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class tableConsole {
	
	
	
	public static String[][] changeformat_gouvernorat(ArrayList<Gouvernorat> list){
		String[][] t = new String[list.size()+1][3] ;
		t[0][0] = "Numéro" ; t[0][1] = "Nom" ; t[0][2] ="Nombres Des Centres" ;
		for(int i=0 ; i<list.size();i++) {
			t[i+1][0]=Integer.toString(i+1);
			t[i+1][1]=list.get(i).get_nom();
			t[i+1][2]=Integer.toString(list.get(i).get_list_Centres().size());
		}
		return t;
	}
	public static String[][] changeformat_centre(ArrayList<Centre> list){
		String[][] t = new String[list.size()+1][6] ;
		t[0][0] = "Numéro de Réf" ; t[0][1] = "Adresse" ; t[0][2] ="Gouvernorat" ;
		t[0][3] = "Capacite" ; t[0][4]="Nombre personnes accueillies" ;
		t[0][5] = "Nombre de places disponible" ;
		for(int i=0 ; i<list.size();i++) {
			t[i+1][0]=Integer.toString(list.get(i).getNumero_ref());
			t[i+1][1]=list.get(i).getAdresse();
			t[i+1][2]=list.get(i).getGouvernorat();
			t[i+1][3]=Integer.toString(list.get(i).getCapacite());
			t[i+1][4]=Integer.toString(list.get(i).getNombre_personnes());
			t[i+1][5]=Integer.toString(list.get(i).getCapacite()-list.get(i).getNombre_personnes());
		}
		return t;
	}
	public static String[][] changeformat_personne(ArrayList<Personne> list){
		String[][] t = new String[list.size()+1][11] ;
		t[0][0] = "Numéro de CIN" ; t[0][1] = "Nom" ; t[0][2] ="Prénom" ;
		t[0][3] = "Genre" ; t[0][4]="date de naissance" ;t[0][5] = "gouvernerat" ;
		t[0][6] = "Num Chambre" ; t[0][7]="Etat" ; t[0][8]="type_contamination" ;
		t[0][9] = "date entree" ; t[0][10] = "date sortie" ;
		for(int i=0 ; i<list.size();i++) {
			t[i+1][0]=Integer.toString(list.get(i).getNum_cin());
			t[i+1][1]=list.get(i).getNom();
			t[i+1][2]=list.get(i).getPrenom();
			t[i+1][3]=list.get(i).getGenre()+"";
			t[i+1][4]=list.get(i).getDate_naissance();
			t[i+1][5]=list.get(i).getGouvernerat();
			t[i+1][6]=Integer.toString(list.get(i).getNum_chambre());
			if(list.get(i).getEtat()==0) {
				t[i+1][7]="rien";
			}
			else if(list.get(i).getEtat()==1) {
				t[i+1][7]="maladie confirmé";
			}
			else if(list.get(i).getEtat()==2) {
				t[i+1][7]="personne malades";
			}
			else if(list.get(i).getEtat()==3) {
				t[i+1][7]="n’a eu aucun symptôme";
			}
			if(list.get(i).getType_contamination()==1) {
				t[i+1][8]="venant de l'etranger";
			}
			else if(list.get(i).getType_contamination()==0) {
				t[i+1][8]="grace à un contact";
			}
			t[i+1][9]=list.get(i).getDate_entree();
			t[i+1][10]=list.get(i).getDate_sortie();
		}
		return t;
	}
	public static String[][] changeformat_chambre(ArrayList<Chambre> list){
		String[][] t = new String[list.size()+1][4] ;
		t[0][0] = "Numéro" ; t[0][1] = "Etat" ; t[0][2] ="Desinfecter" ;
		t[0][3] = "Num_personne" ; 
		for(int i=0 ; i<list.size();i++) {
			t[i+1][0]=Integer.toString(list.get(i).getNum_chambre());
			if(list.get(i).getEtat()==0) {
				t[i+1][1]="Libre";
			}
			else if(list.get(i).getEtat()==1) {
				t[i+1][1]="Occupée";
			}
			if(list.get(i).getDesinfecter()==0) {
				t[i+1][2]="Oui";
			}
			else if(list.get(i).getDesinfecter()==1) {
				t[i+1][2]="Non";
			}
			if(list.get(i).getNum_personne()==0) {
				t[i+1][3]="Libre";
			}
			else {
				t[i+1][3]=Integer.toString(list.get(i).getNum_personne());
			}
		}
		return t;
	}
	
	 /*
	  *  Table to print in console in 2-dimensional array. Each sub-array is a row.
	 */

	public static void tableWithLinesAndMaxWidth(String[][] table) {
		/*
		 * leftJustifiedRows - If true, it will add "-" as a flag to format string to
		 * make it left justified. Otherwise right justified.
		 */
		boolean leftJustifiedRows = true;
	 
		/*
		 * Maximum allowed width. Line will be wrapped beyond this width.
		 */
		int maxWidth = 30;
	 
		/*
		 * Create new table array with wrapped rows
		 */
		List<String[]> tableList = new ArrayList<>(Arrays.asList(table));
		List<String[]> finalTableList = new ArrayList<>();
		for (String[] row : tableList) {
			// If any cell data is more than max width, then it will need extra row.
			boolean needExtraRow = false;
			// Count of extra split row.
			int splitRow = 0;
			do {
				needExtraRow = false;
				String[] newRow = new String[row.length];
				for (int i = 0; i < row.length; i++) {
					// If data is less than max width, use that as it is.
					if (row[i].length() < maxWidth) {
						newRow[i] = splitRow == 0 ? row[i] : "";
					} else if ((row[i].length() > (splitRow * maxWidth))) {
						// If data is more than max width, then crop data at maxwidth.
						// Remaining cropped data will be part of next row.
						int end = row[i].length() > ((splitRow * maxWidth) + maxWidth)
								? (splitRow * maxWidth) + maxWidth
								: row[i].length();
						newRow[i] = row[i].substring((splitRow * maxWidth), end);
						needExtraRow = true;
					} else {
						newRow[i] = "";
					}
				}
				finalTableList.add(newRow);
				if (needExtraRow) {
					splitRow++;
				}
			} while (needExtraRow);
		}
		String[][] finalTable = new String[finalTableList.size()][finalTableList.get(0).length];
		for (int i = 0; i < finalTable.length; i++) {
			finalTable[i] = finalTableList.get(i);
		}
	 
		/*
		 * Calculate appropriate Length of each column by looking at width of data in
		 * each column.
		 * 
		 * Map columnLengths is <column_number, column_length>
		 */
		Map<Integer, Integer> columnLengths = new HashMap<>();
		Arrays.stream(finalTable).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
			if (columnLengths.get(i) == null) {
				columnLengths.put(i, 0);
			}
			if (columnLengths.get(i) < a[i].length()) {
				columnLengths.put(i, a[i].length());
			}
		}));
		//System.out.println("columnLengths = " + columnLengths);
	 
		/*
		 * Prepare format String
		 */
		final StringBuilder formatString = new StringBuilder("");
		String flag = leftJustifiedRows ? "-" : "";
		columnLengths.entrySet().stream().forEach(e -> formatString.append("| %"+ flag + e.getValue() + "s "));
		formatString.append("|\n");
		//System.out.println("formatString = " + formatString.toString());
	 
		/*
		 * Prepare line for top, bottom & below header row.
		 */
		String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
			String templn = "+-";
			templn = templn + Stream.iterate(0, (i -> i < b.getValue()), (i -> ++i)).reduce("", (ln1, b1) -> ln1 + "-",
					(a1, b1) -> a1 + b1);
			templn = templn + "-";
			return ln + templn;
		}, (a, b) -> a + b);
		line = line + "+\n";
		//System.out.println("Line = " + line);
	 
		/*
		 * Print table
		 */
		System.out.print(line);
		Arrays.stream(finalTable).limit(1).forEach(a -> System.out.printf(ConsoleColors.BLACK_BOLD+formatString.toString()+ConsoleColors.RESET, a));
		System.out.print(line);
	 
		Stream.iterate(1, (i -> i < finalTable.length), (i -> ++i))
				.forEach(a -> System.out.printf(formatString.toString(), finalTable[a]));
		System.out.print(line);
	}
}
