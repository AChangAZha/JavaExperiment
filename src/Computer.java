public class Computer {
    public Object data = new Object();
    public PortableStorageDevice device = null;

    public void connect(PortableStorageDevice device) {
        if (device != null) {
            this.device = device;
            System.out.println(device.name() + "连接成功");
        } else
            System.out.println("连接失败");
    }

    public void readFromDevice() {
        Object temp = device.read();
        if (temp != null)
            data = temp;
    }

    public void writeToDevice(Object data) {
        if (device != null)
            device.write(data);
    }
}
