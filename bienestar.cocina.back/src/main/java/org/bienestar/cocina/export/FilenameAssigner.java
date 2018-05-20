package org.bienestar.cocina.export;

import java.time.LocalDate;

public class FilenameAssigner {

	public String getName(LocalDate from, LocalDate to) {
		return from.toString() + "_" + to.toString() + ".csv";
	}
}
