package org.bienestar.cocina.export;

import org.bienestar.cocina.domain.PreparationRegistry;

public class PreparationRegistryTransformView implements TransformView<PreparationRegistry> {

	public String transform(PreparationRegistry value) {
		StringBuilder sb = new StringBuilder();
		String template = value.getDate() + "," + value.getDiners() + "," + value.getPreparation().getName();
		value.getPreparation().getConsumptions().stream().forEach(x -> {
			sb.append(template);
			sb.append(x.getIngredient().getName());
			sb.append(",");
			sb.append(x.getQuantity());
			sb.append(System.lineSeparator());
		});
		return sb.toString();
	}

}
