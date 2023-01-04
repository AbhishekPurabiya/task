package SpringCore.ThermalPowerPlantDOI;

import org.springframework.stereotype.Component;

@Component
public interface IBoilerSpecification {

	public abstract String getBoilerType();
	public abstract String getMaxPressure();
	public abstract String getMaxTempreture();
	public abstract String getBoilerCapacity();
	public abstract String getEfficiency();
	public abstract String getBoilerPrice();
	
}
