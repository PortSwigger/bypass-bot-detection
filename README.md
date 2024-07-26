# Bypass bot detection
Burp Suite extension that mutates ciphers to bypass TLS-fingerprint based bot detection

## Usage
1. Install the extension from [Releses](https://github.com/PortSwigger/bypass-bot-detection/releases) or build from sources.
2. The extension changes network settings at Settings -> Network -> TLS and select `Use custom protocols and cipher`.
3. Right-click on a Request/Response item in the Proxy History tab, navigate to Extensions -> Bypass bot detection, and select one of the menu items.
4. If the server's response changes (i.e., the number of words and headers are different), the extension will log the message and add notes to the Proxy History.

## Build Instructions
* Ensure that Java JDK 17 or newer is installed
* From root of project, run the command `./gradlew jar`
* This should place the JAR file `Bypass-Bot-Detection-0.0.1.jar` within the `build/libs` directory
* This can be loaded into Burp by navigating to the `Extensions` tab, `Installed` sub-tab, clicking `Add` and loading
  the JAR file
* This BApp is using the newer Montoya API, so it's best to use the latest version of Burp (try the earlier adopter
  channel if there are issues with the latest stable release)

### Modes
- **Firefox Mode**: Install the following list of cipher suites: 4865, 4867, 4866, 49195, 49199, 52393, 52392, 49196, 49200, 49162, 49161, 49171, 49172, 156, 157, 47, 53 and add the Firefox User-Agent header.
- **Chrome Mode**: Use cipher suites 4865, 4866, 4867, 49195, 49199, 49196, 49200, 52393, 52392, 49171, 49172, 156, 157, 47, 53 and add the Chrome User-Agent header.
- **Safari Mode**: Include cipher suites 4865, 4866, 4867, 49196, 49195, 52393, 49200, 49199, 52392, 49162, 49161, 49172, 49171, 157, 156, 53, 47, 49160, 49170, 10 and add the Safari User-Agent header.
- **Brute Force Mode**: Tries different combinations of TLS protocol versions and cipher suites. For a full list, visit: [PortSwigger/bypass-bot-detection](https://github.com/PortSwigger/bypass-bot-detection/blob/d677ad52a3cad97aa51b39b66976e35490cef76d/src/main/java/net/portswigger/burp/extensions/Constants.java#L88).

## Warning
The extension modifies network settings during brute force attacks. It is not recommended to use this extension concurrently with other active scans.
