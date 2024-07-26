import net.portswigger.burp.extensions.Constants;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JA3Test {
    @Test
    public void firefox() {
        String firefox_ja3 = "4865-4867-4866-49195-49199-52393-52392-49196-49200-49162-49161-49171-49172-156-157-47-53";
        List<String> firefoxCipherSuite = List.of(firefox_ja3.split("-"));
        List<String> humanReadableList = firefoxCipherSuite.stream()
                .map(Integer::parseInt)
                .map(i -> Constants.defaultContextCipherSuites().get(i))
                .toList();
        List<String> constant = List.of(Constants.BROWSERS_CIPHERS.get("Firefox"));
        assertEquals(humanReadableList,constant, "Firefox JA3 fails");
    }
    @Test
    public void chrome() {
        String ja3 = "4865-4866-4867-49195-49199-49196-49200-52393-52392-49171-49172-156-157-47-53";
        List<String> cipherSuite = List.of(ja3.split("-"));
        List<String> humanReadableList = cipherSuite.stream()
                .map(Integer::parseInt)
                .map(i -> Constants.defaultContextCipherSuites().get(i))
                .toList();
        List<String> constant = List.of(Constants.BROWSERS_CIPHERS.get("Chrome"));
        assertEquals(humanReadableList,constant, "Chrome JA3 fails");
    }
    @Test
    public void safari() {
        String ja3 = "4865-4866-4867-49196-49195-52393-49200-49199-52392-49162-49161-49172-49171-157-156-53-47-49160-49170-10";
        List<String> cipherSuite = List.of(ja3.split("-"));
        List<String> humanReadableList = cipherSuite.stream()
                .map(Integer::parseInt)
                .map(i -> Constants.defaultContextCipherSuites().get(i))
                .toList();
        List<String> constant = List.of(Constants.BROWSERS_CIPHERS.get("Safari"));
        assertEquals(humanReadableList,constant, "Safari JA3 fails");
    }


}
