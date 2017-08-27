package <%= packageName %>.support.config;

public class ProdConfiguration implements Configuration {

    @Override
    public Environment getEnvironment() {
        return Environment.PRO;
    }
}
