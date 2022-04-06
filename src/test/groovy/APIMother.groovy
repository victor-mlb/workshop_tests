import groovy.json.JsonParser
import jdk.nashorn.internal.parser.JSONParser

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

/**
 * This class allows to build a mock of an API Response.
 * There are two ways of doing this.
 * The easy way is reading the response from a file and return it. But is not flexible if the response needs changes.
 * The other is to instantiate an object from models and then serialize it to a string using the mapper in this class.
 * This way is much more flexible allowing to build custom objects.
 */
class APIMother {
    private static final String BASE_PATH = "src/test/groovy/mocks/"

    static List<String> fetchList(String fileName) {
        List<String> list = new ArrayList<>();
        String path = BASE_PATH + fileName + ".txt";
        try {
            byte[] file = Files.readAllBytes(Paths.get(path))
            return new String(file).split(",");
        } catch (IOException e) {
            e.printStackTrace()
        }
        return list;
    }
}