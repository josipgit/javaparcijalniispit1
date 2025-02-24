package J17PrInteExteSmartDevice;

import static java.lang.System.out;

interface RemoteControllable {
    void remoteControl();
}

public abstract class SmartDevice {

    public abstract void performAction(Object object);

    public abstract void displayStatus();

    public void updateFirmware(String version) {
        out.println("Firmware updated to version: " + version);
    }
}

class SmartLight extends SmartDevice implements RemoteControllable {

    private boolean lightOnOff;
    private int lightIntensity;

    @Override
    public void performAction(Object object) {
        if (object instanceof Boolean) {
            this.lightOnOff = (Boolean) object;
            out.println("Light turned " + (lightOnOff ? "ON" : "OFF"));
        } else {
            out.println("Invalid input for SmartLight. Expected a Boolean value.");
        }
    }

    public void displayStatus() {
        if (lightOnOff) {
            out.println("Light intensity is: " + lightIntensity);
        } else {
            out.println("The light is OFF. Turn it ON to adjust intensity.");
        }
    }

    public void setLightIntensity(int lightIntensity) {
        if (lightOnOff) {
            this.lightIntensity = lightIntensity;
            out.println("Light intensity set to: " + lightIntensity);
        } else {
            out.println("Cannot set light intensity while the light is OFF.");
        }
    }

    public void remoteControl() {
        out.println("Remote control enabled for SmartLight.");
    }
}

class SmartThermostat extends SmartDevice implements RemoteControllable {

    private int temperatura;

    @Override
    public void performAction(Object object) {
        if (object instanceof Integer) {
            this.temperatura = (Integer) object;
            out.println("Temperature set to: " + temperatura);
        } else {
            out.println("Invalid input for SmartThermostat. Expected an Integer value.");
        }
    }

    public void displayStatus() {
        out.println("Current temperature: " + this.temperatura + "°C");
    }

    public void remoteControl() {
        out.println("Remote control enabled for SmartThermostat.");
    }
}

class SmartSpeaker extends SmartDevice implements RemoteControllable {

    private int volume;
    private String muzika;

    @Override
    public void performAction(Object object) {
        if (object instanceof Integer) {
            this.volume = (Integer) object;
            out.println("Volume set to: " + volume);
        } else if (object instanceof String) {
            this.muzika = (String) object;
            out.println("Playing music: " + muzika);
        } else {
            out.println("Invalid input for SmartSpeaker. Expected Integer (volume) or String (music name).");
        }
    }

    public void displayStatus() {
        if (muzika != null) {
            out.println("Playing music: " + this.muzika);
        } else {
            out.println("No music is currently playing.");
        }
    }

    public void remoteControl() {
        out.println("Remote control enabled for SmartSpeaker.");
    }
}

class Main {
    public static void main(String[] args) {
        // Create a SmartLight instance
        SmartLight uredaj1 = new SmartLight();
        uredaj1.updateFirmware("Android 14.0");
        uredaj1.remoteControl();
        uredaj1.performAction(true); // Turn on the light
        uredaj1.setLightIntensity(80);
        uredaj1.displayStatus();

        // Create a SmartSpeaker instance
        SmartSpeaker uredaj2 = new SmartSpeaker();
        uredaj2.updateFirmware("v1.2.3");
        uredaj2.remoteControl();
        uredaj2.performAction(50); // Set volume
        uredaj2.performAction("Classical Music"); // Play music
        uredaj2.displayStatus();
    }
}
