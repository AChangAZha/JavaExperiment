public class USBFlashDisk extends PortableStorageDevice {
    private Object data = null;
    public String name = "U盘";

    public Object read() {
        if (this.data == null) {
            System.out.println("U盘数据为空");
            return null;
        } else {
            System.out.println("U盘读数据成功");
            return this.data;
        }
    }

    public void write(Object data) {
        if (data == null)
            System.out.println("空数据");
        else {
            this.data = data;
            System.out.println("U盘写数据成功");
        }

    }

    public String name() {
        return name;
    }

}
