package org.bienestar.cocina.export;

import java.util.Date;

public class FilenameAssigner {

	public String getName(Date from, Date to) {
		return from.toString() + "_" + to.toString() + ".csv";
	}
}
