package SpringCore.ThermalPowerPlantDOI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "SpringCore.ThermalPowerPlantDOI")
public class App {

	private IBoilerSpecification boilerSpecification;

	public App() {
		super();
	}

	public App(SpringCore.ThermalPowerPlantDOI.IBoilerSpecification boilerSpecification) {
		super();
		this.boilerSpecification = boilerSpecification;
	}

	public IBoilerSpecification getBoilerSpecification() {
		return boilerSpecification;
	}

	public void setBoilerSpecification(IBoilerSpecification boilerSpecification) {
		this.boilerSpecification = boilerSpecification;
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		//ThermaxIndiaLimited specification = context.getBean(ThermaxIndiaLimited.class);
		 SouthernBoiler specification = context.getBean(SouthernBoiler.class);
		App plant = context.getBean(App.class);
		plant.setBoilerSpecification(specification);

		System.out.println("Boiler Type: " + plant.boilerSpecification.getBoilerType());
		System.out.println("Boiler Maximum Pressure: " + plant.boilerSpecification.getMaxPressure());
		System.out.println("Boiler Maximum Tempreture: " + plant.boilerSpecification.getMaxTempreture());
		System.out.println("Boiler Capacity: " + plant.boilerSpecification.getBoilerCapacity());
		System.out.println("Boiler Price: " + plant.boilerSpecification.getBoilerPrice());
	}
}
