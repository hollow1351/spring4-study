package ch4;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyEditorBean extends PropertyEditorSupport {

    private byte[] bytes;
    private Class cls;
    private Boolean bool;
    private List<String> list;
    private Date date;
    private Float floatVal;
    private File file;
    private InputStream stream;
    private Locale locale;
    private Pattern pattern;
    private Properties properties;
    private String trimString;
    private URL url;
    private MyWrapper myWrapper;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new MyWrapper(text));
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFloatVal(Float floatVal) {
        this.floatVal = floatVal;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setTrimString(String trimString) {
        this.trimString = trimString;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void setMyWrapper(MyWrapper myWrapper) {
        this.myWrapper = myWrapper;
    }

    @Override
    public String toString() {
        return "PropertyEditorBean{" + "bytes=" + bytes + ", cls=" + cls + ", bool=" + bool + ", list=" + list + ", date=" + date + ", floatVal=" + floatVal + ", file=" + file + ", stream=" + stream + ", locale=" + locale + ", pattern=" + pattern + ", properties=" + properties + ", trimString=" + trimString + ", url=" + url + ", myWrapper=" + myWrapper + '}';
    }

    public static class MyWrapper {

        private String value;

        public MyWrapper(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "MyWrapper{" + "value=" + value + '}';
        }
    }

    public static class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

        @Override
        public void registerCustomEditors(PropertyEditorRegistry registry) {
            registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy.MM.dd"), true));
            registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        }
    }

    public static void main(String[] args) throws Exception {
        File tmp = new File("test.txt");
        tmp.createNewFile();
        tmp.deleteOnExit();
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("ch4/propertyEditor.xml");
        ctx.refresh();
        System.out.println(ctx.getBean("builtInSample"));
    }
}
