package yogiyo;

import java.util.regex.Pattern;

public class Version {
    private final String errorVersionMustNotBeNull = "'version' must not be null!";
    private final String errorOtherMustNotBeNull = "'other' must not be null!";
    private final String errorVersionMustMatchPattern = "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";
    private final String SNAPSHOT_STR = "-SNAPSHOT";
    private String version;

    public Version(String version) {
        validateVersion(version);
        this.version = getFormatVersion(version);
    }

    public boolean isSnapshot() {
        return this.version.endsWith(SNAPSHOT_STR);
    }

    private void validateVersion(String version) {
        if (version == null) {
            throw new IllegalArgumentException(errorOtherMustNotBeNull);
        }
        String regex = "\\d+(\\.\\d+){0,2}(-SNAPSHOT)?";
        if (!Pattern.matches(regex, version)) {
            throw new IllegalArgumentException(errorVersionMustMatchPattern);
        }
    }

    public String getFormatVersion(String version) {
        int idx = (version.indexOf(SNAPSHOT_STR) > 0) ? version.indexOf(SNAPSHOT_STR) : version.length();
        String str = version.substring(0, idx);
        String[] split = str.split("\\.");
        StringBuffer formatVersion = new StringBuffer();
        if (split.length == 1) {
            formatVersion.append(str);
            formatVersion.append(".0.0-SNAPSHOT");
            return formatVersion.toString();
        }

        if (split.length == 2) {
            formatVersion.append(str);
            formatVersion.append(".0-SNAPSHOT");
            return formatVersion.toString();
        }

        return version;
    }

    public String getVersion() {
        return version;
    }
}
