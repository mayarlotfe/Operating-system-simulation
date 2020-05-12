package carX1;

import java.util.concurrent.TimeUnit;

public class Drive extends Move {
	boolean drive;
	
   static int number1 = 0;
	public Drive() {
		priority = 1;
		number1++;
		uniqueProcess = 1;
		type= "drive"+" "+number1;
	}

	public void speedUp() throws Exception {
		// delay on second

		drive = true;
		System.out.println(state);

		if (state == true) {
			if (trans_state == 'P') {
				System.out.println("Change The Transmition To D/R");
			} else {
				if(!speedUp) {
					speedUp=true;
				while (drive == true &&!usebreak&&!carState&&!transimition) {
					// delay depending on the acceleration
					if (speed < 30)
						TimeUnit.SECONDS.sleep(1);
					else if (speed < 80)
						TimeUnit.SECONDS.sleep(2);
					else {
						TimeUnit.SECONDS.sleep(2);}
                    if(state==true) { 
					if (speed < speed_limit) {
						speed += 40;
						System.out.println("Your speed is " + speed);
					} else {
						System.out.println("you have exceeded speed limit");
						terminate();
					}
                    }else {
						System.out.println("the car is not running");
						terminate();
						
					}

				}
				speedUp=false;
			}else{
				System.out.println("You Are Already Moving");
			}
			}
		} else {
			System.out.println("The Car Is Not Running");
		}
		Memory.removeFromMemory(this);
		OperatingSystem.info.newLine();
		OperatingSystem.info.write("This is the Turn Around Time of "+type+"==>>"+(System.currentTimeMillis()-OperatingSystem.start));
		OperatingSystem.info.newLine();
		OperatingSystem.info.write("-------------newProcess----------");

	}

	public void terminate() {
		drive = false;
	}

}
