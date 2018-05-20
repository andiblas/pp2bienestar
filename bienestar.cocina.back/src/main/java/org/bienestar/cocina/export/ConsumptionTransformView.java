package org.bienestar.cocina.export;

import org.bienestar.cocina.domain.Consumption;

public class ConsumptionTransformView implements TransformView<Consumption> {

	public String transform(Consumption value) {
		return value.getIngredient() + "," + value.getQuantity();
	}

}
