package kr.or.ddit.basic.okCOmmand;

public class LampCommandImpl implements ICommand {
	
	private Lamp lamp;
	
	public LampCommandImpl(Lamp lamp) {
		this.lamp = lamp;
	}
	
	@Override
	public void execute() {
		lamp.turnOn();

	}


}
