public abstract class PortableStorageDevice {

    public abstract Object read();

    public abstract void write(Object data);

    public abstract String name();
}
