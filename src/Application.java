public class Application {
    public static void main(String[] args) {
        Computer myComputer = new Computer();
        PortableStorageDevice myUSBFlashDisk = new USBFlashDisk();
        myComputer.connect(myUSBFlashDisk);
        myComputer.writeToDevice(myComputer.data);
        myComputer.readFromDevice();
        PortableStorageDevice myMP3Player = new MP3Player();
        myComputer.connect(myMP3Player);
        myComputer.writeToDevice(myComputer.data);
        myComputer.readFromDevice();
        PortableStorageDevice myMobileHardDisk = new MobileHardDisk();
        myComputer.connect(myMobileHardDisk);
        myComputer.writeToDevice(myComputer.data);
        myComputer.readFromDevice();
    }
}