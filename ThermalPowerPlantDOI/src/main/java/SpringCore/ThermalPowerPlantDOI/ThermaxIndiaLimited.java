package SpringCore.ThermalPowerPlantDOI;

import org.springframework.stereotype.Component;

@Component
public class ThermaxIndiaLimited implements IBoilerSpecification {

	
	public String getMaxPressure() {
		
		return "120 bar";
	}

	
	public String getMaxTempreture() {
		
		return "600 Degree";
	}

	
	public String getBoilerCapacity() {
		
		return "140 Ton";
	}

	
	public String getEfficiency() {
		
		return "80%";
	}

	
	public String getBoilerType() {
		
		return "Water Type Boiler";
	}

	
	public String getBoilerPrice() {
		
		return "5 lac";
	}

}
