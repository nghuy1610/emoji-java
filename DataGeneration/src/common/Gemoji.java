package common;

import java.util.List;

public class Gemoji {
    private String emoji;
    private String description;
    private String category;
    private List<String> aliases;
    private List<String> tags;
    private String unicode_version;
    private String ios_version;
    private boolean skin_tones;

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getUnicode_version() {
        return unicode_version;
    }

    public void setUnicode_version(String unicode_version) {
        this.unicode_version = unicode_version;
    }

    public String getIos_version() {
        return ios_version;
    }

    public void setIos_version(String ios_version) {
        this.ios_version = ios_version;
    }

    public boolean isSkin_tones() {
        return skin_tones;
    }

    public void setSkin_tones(boolean skin_tones) {
        this.skin_tones = skin_tones;
    }
}
