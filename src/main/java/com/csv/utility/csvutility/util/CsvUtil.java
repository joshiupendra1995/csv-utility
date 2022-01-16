package com.csv.utility.csvutility.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CsvUtil {

	private static void copyToAnotherFileWithHeader(File inputFile, File outputFile, String header) throws IOException {
		try (Stream<String> lines = Files.lines(Paths.get(inputFile.getPath()))) {
			try (PrintWriter pw = new PrintWriter(outputFile.getPath())) {
				pw.write(header);
				pw.write("\n");
				lines.skip(1).map(l -> l).forEach(pw::println);
			}
		}

		System.out.println("File copied successfully");

	}

	public static void main(String[] args) throws IOException {
		File inputFile = new File("D:/data.csv");
		File outputFile = new File("D:/output.csv");
		String header = "Region,Country,Item Type,Sales Channel,Order Priority,Order Date,Order ID,Ship Date,Units Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit";
		copyToAnotherFileWithHeader(inputFile, outputFile, header);
	}

}
