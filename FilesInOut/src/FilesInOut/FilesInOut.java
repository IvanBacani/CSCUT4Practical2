package FilesInOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *	CSCU9T4 Java strings and files exercise.
 * @author Ivan Eldrich Bacani - 3140380
 *	
 */
public class FilesInOut {

	public static void main(String[] args) {

		// Input/Output.
		File inputFile = new File("C:\\Users\\vanni\\eclipse-workspace\\FilesInOut\\src\\inputm.txt");
		File outputFile = new File("C:\\Users\\vanni\\eclipse-workspace\\FilesInOut\\src\\outputm.txt");

		// Displays if the input is missing.
		if (!inputFile.exists()) {
			System.out.println("!FILE NOT FOUND!");
			return;
		}

		try {

			// Scanner
			Scanner scanner = new Scanner(inputFile);
			PrintWriter writer = new PrintWriter(outputFile);

			// Reads each line
			while (scanner.hasNextLine()) {
				
				//
				String line = scanner.nextLine();
				String[] nameLength = line.split(" ");
				
				// StringBuilder for initialization of an variable for the date
				StringBuilder formatName = new StringBuilder();
				String dateFormat = "";

				// Reads the date
				int fullDate = line.lastIndexOf(" ");
				String date = line.substring(fullDate + 1);
				String day = date.substring(0, 2);
				String month = date.substring(2, 4);
				String year = date.substring(4);

				for (int i = 0; i < nameLength.length; i++) {

					String selectingStringName = nameLength[i];

					// First name 
					if (i == 0) {
						String name = selectingStringName.substring(0, 1).toUpperCase()
								+ selectingStringName.substring(1).toLowerCase();
						formatName.append(name);
					}

					// Middle name
					else if (i == 1 && selectingStringName.length() == 1) {
						formatName.append(". ").append(selectingStringName.toUpperCase());
					}

					// Last name
					else if (i == nameLength.length - 1) {
						String name = selectingStringName.substring(0, 1).toUpperCase()
								+ selectingStringName.substring(1).toLowerCase();
						formatName.append(" ").append(name.replaceAll("[0-9]", ""));
					}

					// Full name
					else {
						String name = selectingStringName.substring(0, 1).toUpperCase()
								+ selectingStringName.substring(1).toLowerCase();
						formatName.append(" ").append(name.replaceAll("[0-9]", ""));
					}
				}

				//Write into date format 
				dateFormat = day + "/" + month + "/" + year;
				
				//Writes the name and date
				writer.println(formatName.toString() + " " + dateFormat);
			}

			scanner.close();
			writer.close();
		}

		// Catch Exception
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}