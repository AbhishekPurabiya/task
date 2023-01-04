package SpringCore.ThermalPowerPlantDOI;

import org.springframework.stereotype.Component;

@Component
public class SouthernBoiler implements IBoilerSpecification {

	
	public String getMaxPressure() {
		
		return "130 bar";
	}

	
	public String getMaxTempreture() {
		
		return "540 Degree";
	}

	
	public String getBoilerCapacity() {
		
		return "150 Ton";
	}

	
	public String getEfficiency() {
		
		return "85 %";
	}

	
	public String getBoilerType() {
		
		return "Fire Type Boiler";
	}

	
	public String getBoilerPrice() {
		
		return "6 lac";
	}

}

