public class MP3Player extends PortableStorageDevice {
    private Object data = null;
    public String name = "MP3播放器";

    public Object read() {
        if (this.data == null) {
            System.out.println("MP3播放器数据为空");
            return null;
        } else {
            System.out.println("MP3播放器读数据成功");
            return this.data;
        }
    }

    public void write(Object data) {
        if (data == null)
            System.out.println("空数据");
        else {
            this.data = data;
            System.out.println("MP3播放器写数据成功");
        }

    }

    public String name() {
        return name;
    }

}
