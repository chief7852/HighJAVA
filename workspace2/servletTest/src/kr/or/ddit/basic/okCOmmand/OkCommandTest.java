package kr.or.ddit.basic.okCOmmand;

public class OkCommandTest {

	public static void main(String[] args) {

		//램프 켜기
		Lamp lamp = new Lamp();
		
		ICommand lampCommand = new LampCommandImpl(lamp);
		
		OkCommand test = new OkCommand(lampCommand);
		test.run();
		
		// 히터켜기
		Heater heater = new Heater();
		ICommand heaterCommand = new HeaterCommandImpl(heater);
		
		test.setCommand(heaterCommand);
		test.run();
	}

}
