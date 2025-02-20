package SmartDevice;

import J17PrKnjiznicaInterface.Knjiga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

interface RemoteControllable {
    void remoteControl();
}

public abstract class SmartDevice {

    public abstract void performAction();

    public abstract void displayStatus();

    public void updateFirmware() {
        out.println("Firmware updated to version: ");
    }
}

class SmartLight extends SmartDevice implements RemoteControllable {

    String version;

    public SmartLight(String version) {
        this.version = version;
    }

    public void performAction() {
        out.println("Podesi svjetlinu sa SmartLight");
    }

    public void displayStatus() {
        out.println("Postavi i prikazi temperaturu sa SmartLight");
    }

    public void updateFirmware() {
        super.updateFirmware();
        out.println(this.version);
    }

    public void remoteControl(){
        out.println("Upravljaj daljinski preko SmartLight");
    }

}

class SmartSpeaker extends SmartDevice implements RemoteControllable {

    public void performAction() {
        out.println("Pustaj glazbu sa SmartSpeaker");
    }

    public void displayStatus() {
        out.println("Podesavaj glasnocu sa SmartSpeaker");
    }

    public void remoteControl() {
        out.println("Upravljaj daljinski preko SmartSpeaker");
    }
}

class Main {
    public static void main(String[] args) {
        SmartLight uredaj1 = new SmartLight("Android 14.0");
        uredaj1.updateFirmware();
        uredaj1.remoteControl();
        uredaj1.performAction();
        uredaj1.displayStatus();
        SmartSpeaker uredaj2 = new SmartSpeaker();
        uredaj2.updateFirmware();
        uredaj2.remoteControl();
        uredaj2.performAction();
        uredaj2.displayStatus();
    }
}