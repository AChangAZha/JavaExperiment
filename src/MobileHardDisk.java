public class MobileHardDisk extends PortableStorageDevice {
    private Object data = null;
    public String name = "移动硬盘";

    public Object read() {
        if (this.data == null) {
            System.out.println("移动硬盘数据为空");
            return null;
        } else {
            System.out.println("移动硬盘读数据成功");
            return this.data;
        }
    }

    public void write(Object data) {
        if (data == null)
            System.out.println("空数据");
        else {
            this.data = data;
            System.out.println("移动硬盘写数据成功");
        }

    }

    public String name() {
        return name;
    }

}
